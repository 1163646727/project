package com.pri.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @ClassName: ApiInterceptor
 * @Description: api接口的拦截器
 * @auther: Chenqi
 * @Date: 2019/5/5 10:15
 * @Version 1.0 jdk1.8
 */
public class ApiInterceptor implements HandlerInterceptor {

    /**ChenQi 2019/5/5; redis工具类*/
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     *@MethodName:  preHandle
     *@Description: 进入controller层之前拦截请求
     *@Param: [httpServletRequest, httpServletResponse, o]
     *@Return: boolean
     *@author: ChenQi
     *@CreateDate: 2019/5/5 12:57
     */
    @Override
    @Bean
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // ChenQi 2019/5/5; 获取redis中的小程序用户信息
        String redisKey = "user_"+httpServletRequest.getHeader( "nid" )+"_"+httpServletRequest.getHeader( "accessToken" );
        String user=redisTemplate.opsForValue().get(redisKey)==null?null:redisTemplate.opsForValue().get(redisKey).toString();
        if(user == null ){
            PrintWriter pw= httpServletResponse.getWriter();
            JSONObject jsonObject=new JSONObject(  );
            jsonObject.put( "code","-1" );
            jsonObject.put( "msg","登陆超时！" );
            pw.write(jsonObject.toJSONString());
            return false;
        }else{
            return true;
        }

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
