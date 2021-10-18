package com.pri.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 /**
  * @ClassName:      LoginInterceptor
  * @Description:   自定义拦截器，来过PC端滤请求；我们创建的拦截器要去实现HandlerInterceptor接口，然后定义我们的方法
  * @author:         ChenQi
  * @CreateDate:     2019/5/5 9:47
  */
public class LoginInterceptor implements HandlerInterceptor {

     /**
      *@MethodName:  preHandle
      *@Description: 进入controller层之前拦截请求
      *@Param: [httpServletRequest, httpServletResponse, o]
      *@Return: boolean
      *@author: ChenQi
      *@CreateDate: 2019/5/5 12:57
      */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        HttpSession session = httpServletRequest.getSession();
        // ChenQi 2019/5/5; 获取session中的sysUser
        /*SysUser user = (SysUser)session.getAttribute( "sysUser" );
        if(user == null){
            // ChenQi 2019/5/5; 重定向到登陆页面
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/");
            return false;
        }else{
            return true;
        }*/
        return true;
    }

     /**
      *@MethodName:  postHandle
      *@Description: 处理请求完成后视图渲染之前的处理操作
      *@Param: [httpServletRequest, httpServletResponse, o, modelAndView]
      *@Return: void
      *@author: ChenQi
      *@CreateDate: 2019/5/5 13:07
      */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

     /**
      *@MethodName:  afterCompletion
      *@Description: 视图渲染之后的操作
      *@Param: [httpServletRequest, httpServletResponse, o, e]
      *@Return: void
      *@author: ChenQi
      *@CreateDate: 2019/5/5 13:08
      */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }

}