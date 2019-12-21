package com.pri.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pri.entity.ResultEntity;
import com.pri.entity.ResultVo;
import com.pri.entity.WxUser;
import com.pri.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName: Controller
 * @Description: 用户业务控制层
 * @Auther: Chenqi
 * @Date: 2019/4/22 16:07
 * @Version 1.0 jdk1.8
 */
@Controller
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *@MethodName:  toIndex
     *@Description:     跳转主页面
     *@Param: []
     *@Return: java.lang.String
     *@Author: ChenQi
     *@CreateDate: 2019/4/23 8:49
     */
    @RequestMapping("/index")
    public String toIndex(){
        System.out.println("跳转主页面");
        return "user/index";
    }

    /**
     *@MethodName:  toEdit
     *@Description: 跳转编辑页面
     *@Param: []
     *@Return: java.lang.String
     *@author: ChenQi
     *@CreateDate: 2019/4/30 11:25
     */
    @RequestMapping("/edit")
    public String toEdit(){
        System.out.println("跳转用户编辑页面");
        return "user/edit";
    }

    /**
     *@MethodName:  userList
     *@Description: 查询全部用户
     *@Param: []
     *@Return: java.util.List<com.pri.entity.WxUser>
     *@author: ChenQi
     *@CreateDate: 2019/5/6 8:49
     */
    @RequestMapping("/userList")
    @ResponseBody
    public List<WxUser> userList(){
        List<WxUser> list = userService.userList();
        System.out.println(list);
        return userService.userList();
    }

    /**
     *@MethodName:  selectByPrimaryKey
     *@Description: 根据主键查询用户
     *@Param: []
     *@Return: com.pri.entity.User
     *@Author: ChenQi
     *@CreateDate: 2019/4/23 9:32
     */
    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public WxUser selectByPrimaryKey(int id){
        System.out.println("根据主键查询用户");
        WxUser user = null;
        user = userService.selectByPrimaryKey(id);
        return user;
    }

    /**
     *@MethodName:  selectUserList
     *@Description: 根据条件，查询微信用户
     *@Param: [pageSize, pageNum, wxUser]
     *@Return: com.pri.entity.ResultEntity
     *@author: ChenQi
     *@CreateDate: 2019/5/7 10:22
     */
    @RequestMapping("/selectUserList")
    @ResponseBody
    public ResultEntity selectUserList(int pageSize, int pageNum, WxUser wxUser){
        System.out.println("查询全部用户");

        ResultEntity entity = new ResultEntity();
        PageHelper.startPage(pageNum,pageSize);
        List<WxUser> list = userService.selectUserListByCondition( wxUser );
        PageInfo<WxUser> pageInfo=new PageInfo<>( list );
        int count = (int)pageInfo.getTotal();//总数量
        int c = pageInfo.getPages();//当前页数
        pageInfo.getList();//内容

        entity.setRows(list);
        entity.setTotal(count);
        System.out.println(list);
        return entity;
    }

    /**
     *@MethodName:  deleteLoginById
     *@Description: 根据主键进行逻辑删除
     *@Param: [id]
     *@Return: com.pri.entity.ResultVo
     *@author: ChenQi
     *@CreateDate: 2019/5/7 13:30
     */
    @RequestMapping("/deleteLoginById")
    @ResponseBody
    public ResultVo deleteLoginById(int id){
        ResultVo resultVo = new ResultVo();
        int r = userService.deleteLoginById( id );
        if(r==1){
            resultVo.setCode( 1 );
            resultVo.setMsg( "操作成功！" );
        }else{
            resultVo.setCode( 0 );
            resultVo.setMsg( "操作失败！" );
        }
        return resultVo;
    }

    /**
     *@MethodName:  lock
     *@Description: 禁用、解禁
     *@Param: [id, type:-1.禁用1.正常]
     *@Return: com.pri.entity.ResultVo
     *@author: ChenQi
     *@CreateDate: 2019/5/7 18:01
     */
    @RequestMapping("/lock")
    @ResponseBody
    public ResultVo lock(Integer id, Integer type){

        ResultVo resultVo = new ResultVo();
        int r = userService.lock( id,type );
        if(r==1){
            resultVo.setCode( 1 );
            resultVo.setMsg( "操作成功！" );
        }else{
            resultVo.setCode( 0 );
            resultVo.setMsg( "操作失败！" );
        }
        return resultVo;
    }
}
