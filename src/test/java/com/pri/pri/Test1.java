package com.pri.pri;

import cn.hutool.core.collection.CollectionUtil;
import com.pri.service.test.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    @Test
    public void testCollection(){
        List list = null;
        System.out.println("-----------------------------collection");
        System.out.println("-----------------------------"+ CollectionUtils.isEmpty(new ArrayList<>()));
        System.out.println("-----------------------------"+ CollectionUtils.isEmpty(list));
        System.out.println("=====================:"+ CollectionUtil.isEmpty(list));
    }
}
