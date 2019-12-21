package com.pri.controller.test;

import org.springframework.beans.factory.annotation.Value;

public class TestService {
    @Value("${http_url}")
    private String httpUrl;

    public void testVaule(){
        System.out.println("httpUrl:"+httpUrl);
    }
}