package com.pri.controller.test;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * className: TestController <BR>
 * description: <BR>
 * remark: <BR>
 * auther: ChenQi <BR>
 * date: 2019/8/12 0012 下午 11:10 <BR>
 * version 1.0 jdk1.8 <BR>
 */
@RestController
@RequestMapping("/test")
public class TestController {
    //@Value("${http_url}")
    private String httpUrl="127.0.0.1";

    @ResponseBody
    @PostMapping("/testVaule")
    public String testVaule(){
        System.out.println("httpUrl:"+httpUrl);
        return httpUrl;
    }
}
