package com.pri.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName:      WebAppConfig
 * @Description:   拦截器添加到SpringBoot的配置中，让SpringBoot项目有这么一个拦截器存在
 * @author:         ChenQi
 * @CreateDate:     2019/5/5 9:49
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    /**
     *@MethodName:  getApiInterceptor
     *@Description: 解决自定义的ApiInterceptor接口拦截器注入不了redis接口service
     *@Param: []
     *@Return: com.pri.config.ApiInterceptor
     *@author: ChenQi
     *@CreateDate: 2019/5/5 12:18
     */
    @Bean
    public ApiInterceptor getApiInterceptor(){
        return new ApiInterceptor();
    }

    /**
     *@MethodName:  addInterceptors
     *@Description: 将自定义的拦截器添加到SpringBoot的配置中
     *@Param: [registry]
     *@Return: void
     *@author: ChenQi
     *@CreateDate: 2019/5/5 13:10
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        // ChenQi 2019/5/5; 将LoginInterceptor拦截器添加到SpringBoot的配置中
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/sys/**");

        // ChenQi 2019/5/5; 将ApiInterceptor接口拦截器添加到SpringBoot的配置中
        //registry.addInterceptor(getApiInterceptor()).addPathPatterns("/api/**");
    }
}