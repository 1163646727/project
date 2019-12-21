package com.pri.pri;

import com.pri.service.test.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * className: Test1 <BR>
 * description: <BR>
 * remark: <BR>
 * auther: ChenQi <BR>
 * date: 2019/8/12 0012 下午 10:47 <BR>
 * version 1.0 jdk1.8 <BR>
 */
@RunWith (SpringRunner.class)
@SpringBootTest
public class Test1 {

    @Autowired
    private TestService testService;

    @Test
    public void testVaule(){
        testService.testVaule ();
    }
}
