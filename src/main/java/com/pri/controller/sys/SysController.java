package com.pri.controller.sys;

import com.pri.entity.ResultVo;
import com.pri.entity.SysUser;
import com.pri.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: LoginController
 * @Description: 系统业务控制层
 * @Auther: Chenqi
 * @Date: 2019/4/20 14:04
 * @Version 1.0 jdk1.8
 */
@Controller
public class SysController{

    /**ChenQi 2019/4/28; PC端->系统业务层接口*/
    @Autowired
    private SysService sysService;

    @Autowired
    RedisTemplate redisTemplate;


    /**
     *@MethodName:  toLogin
     *@Description: 跳转登陆页面
     *@Param: []
     *@Return: java.lang.String
     *@Author: ChenQi
     *@CreateDate: 2019/4/20 14:05
     */
    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("/index_v1")
    public String page(HttpServletRequest request){
        System.out.println("跳转index_v1页面。。。。");
        return "index_v1";
    }

    @RequestMapping("/index")
    public String index(){
        System.out.println("跳转index页面。。。。");
        return "index";
    }


    @RequestMapping("/login")
    @ResponseBody
    public ResultVo login(HttpServletRequest request, SysUser sysUser, RedirectAttributes attributes, HttpServletResponse response){
        ResultVo resultVo = new ResultVo();

        SysUser sysU = sysService.selectByNameAndPassword(sysUser);
        if(sysU == null){
            attributes.addFlashAttribute("nullNameAndPassword","用户名或密码不能为空");
            resultVo.setCode(0);
            resultVo.setMsg("用户名或密码错误！");
        }else{
            resultVo.setCode(1);
            resultVo.setMsg("登陆成功！");
            // ChenQi 2019/5/3; 添加session
            HttpSession  session = request.getSession();
            session.setAttribute( "sysUser",sysU );
            session.setMaxInactiveInterval(60*60);
        }
        return resultVo;
    }

}
