package com.pri.service.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * className: TestService <BR>
 * description: <BR>
 * remark: <BR>
 * auther: ChenQi <BR>
 * date: 2019/8/12 0012 下午 10:55 <BR>
 * version 1.0 jdk1.8 <BR>
 */
@Service
public class TestService {
    //@Value("${http_url}")
    private String httpUrl = "333";

    public void testVaule(){
        System.out.println("httpUrl:"+httpUrl);
    }
}
