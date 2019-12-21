package com.pri.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.pri.entity.ResultVo;
import com.pri.entity.SysUser;
import com.pri.entity.WxUser;
import com.pri.service.SysService;
import com.pri.service.api.ApiSysService;
import com.pri.util.HttpClientUtil;
import com.pri.util.WxUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ApiSysController
 * @Description:
 * @auther: Chenqi
 * @Date: 2019/4/23 18:04
 * @Version 1.0 jdk1.8
 */
@RestController
@RequestMapping("/api/sys")
public class ApiSysController {

    @Autowired
    private ApiSysService apiSysService;

    /**ChenQi 2019/4/28; PC端->系统业务层接口*/
    @Autowired
    private SysService sysService;

    /**
     *@MethodName:  testIndex
     *@Description:  api测试方法，后期删除
     *@Param: []
     *@Return: com.pri.entity.ResultVo
     *@Author: ChenQi
     *@CreateDate: 2019/4/24 13:48
     */
    @RequestMapping("/testIndex")
    public ResultVo testIndex(){

        ResultVo resultVo = new ResultVo();
        System.out.println("api 测试方法");

        String st = "api 测试方法";
        resultVo.setCode(1);
        resultVo.getData();

        return resultVo;
    }


    /**
     *@MethodName:  getUserInfo
     *@Description: 登陆功能
     * 获取微信用户的openid和accessToken
     *@Param: [request]
     *@Return: com.pri.entity.ResultVo
     *@Author: ChenQi
     *@CreateDate: 2019/4/24 13:48
     */
    @RequestMapping("/login")
    public ResultVo login(HttpServletRequest request) throws Exception {
        ResultVo resultVo = new ResultVo();
        String code=request.getParameter("code");
        String nid = request.getHeader("nid");
        if(nid == null){
            System.out.println("请求头未获取到nid");
            nid = "2";
        }
        System.out.println("nid:"+nid);
        System.out.println("request -- code:"+request.getParameter("code"));

        //获取用户的openid.小程序和公众号不同，公众号可以获取用户的详细信息，小程序仅能获取openid,其他信息在前端获取
        String userInfoUrl= WxUrl.GET_USER_INFO_URL.replace("APPID", WxUrl.APP_ID).replace("SECRET", WxUrl.APP_SECRET).replace("JSCODE", code);
        String infoStr = HttpClientUtil.doGet(userInfoUrl);
        String openId= JSONObject.parseObject(infoStr).getString("openid");

        if(openId == null){
            resultVo.setCode(0);
            resultVo.setMsg("获取openid异常！");
            return resultVo;
        }

        /*获取token*/
        String tokenUrl=WxUrl.GET_ACCESS_TOKEN_URL.replace("APPID", WxUrl.APP_ID).replace("APPSECRET", WxUrl.APP_SECRET);
        String tokenStr=HttpClientUtil.doGet(tokenUrl);
        String accessToken =JSONObject.parseObject(tokenStr).getString("access_token");

        //查询次用户在数据库是否存在，不存在则添加
        WxUser wxUser = wxUser = new WxUser();
        wxUser.setOpenid(openId);
        wxUser.setNid(nid);
        //查询微信用户，如果不存在，就新插入一条用户信息
        wxUser = selectWxUser(wxUser,1);

        Map<String,Object> maps = new HashMap<>();
        maps.put("accessToken",accessToken);
        maps.put("openId",openId);
        maps.put("userId",wxUser.getId());
        resultVo.setCode(1);
        resultVo.setData(maps);
        return resultVo;
    }

    /**
     *@MethodName:  selectWxUser
     *@Description: 查询微信用户，如果不存在，就新插入一条用户信息
     *@Param: [wxUser ,ident1.登陆 2.获取用户信息]
     *@Return: com.pri.entity.WxUser
     *@Author: ChenQi
     *@CreateDate: 2019/4/24 14:20
     */
    public WxUser selectWxUser( WxUser wxUser ,int ident){
        WxUser user = apiSysService.selectByOpenid(wxUser.getOpenid(),wxUser.getNid());
        if(user == null){
            apiSysService.insert(wxUser);
        }else{
            if(2 == ident){
                apiSysService.updateByPrimaryKey(wxUser);
                return wxUser;
            }
        }
        return user;
    }

    /**
     *@MethodName:  getUserInfo
     *@Description:
     *@Param: [request]
     *@Return: com.pri.entity.ResultVo
     *@Author: ChenQi
     *@CreateDate: 2019/4/24 14:08
     */
    @RequestMapping("/getUserInfo")
    public ResultVo getUserInfo(HttpServletRequest request){
        ResultVo resultVo = new ResultVo();

        Integer userId = Integer.valueOf(request.getParameter("userId"));
        String openId = request.getParameter("openId");
        String nickname = request.getParameter("nickname");
        String headimgurl = request.getParameter("headimgurl");
        String nid = request.getHeader("nid");
        Integer sex = Integer.valueOf(request.getParameter("sex") == null ? "0":request.getParameter("sex"));
        if(nid == null){
            System.out.println("请求头未获取到nid");
            nid = "2";
        }
        if(openId == null){
            resultVo.setCode(0);
            resultVo.setMsg("获取openid异常！");
            return resultVo;
        }
        WxUser wxUser = new WxUser();
        wxUser.setId(userId);
        wxUser.setOpenid(openId);
        wxUser.setNickname(nickname);
        wxUser.setHeadimgurl(headimgurl);
        wxUser.setSex(sex);
        wxUser.setNid(nid);
        //查询微信用户，如果不存在，就新插入一条用户信息
        wxUser = selectWxUser(wxUser,2);

        resultVo.setCode(1);
        resultVo.setData(wxUser);

        return resultVo;
    }

    /**
     *@MethodName:  pcLogin
     *@Description:
     *@Param: [request]
     *@Return: com.pri.entity.ResultVo
     *@Author: ChenQi
     *@CreateDate: 2019/5/31 0031 下午 10:33
     */
    @RequestMapping("/pcLogin")
    public ResultVo pcLogin(HttpServletRequest request, SysUser sysUser){
        ResultVo resultVo = new ResultVo();
        SysUser sysU = sysService.selectByNameAndPassword(sysUser);
        if(sysU == null){
            resultVo.setCode(0);
            resultVo.setMsg("用户名或密码错误！");
        }else{
            resultVo.setCode(1);
            resultVo.setMsg("登陆成功！");
            // ChenQi 2019/5/3; 添加session
            HttpSession session = request.getSession();
            session.setAttribute( "sysUser",sysU );
            session.setMaxInactiveInterval(60*60);
        }
        return resultVo;
    }

}
