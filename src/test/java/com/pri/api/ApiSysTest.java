package com.pri.api;

import com.pri.controller.api.ApiSysController;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

/**
 * className:  ApiSysTest <BR>
 * description: <BR>
 * remark: <BR>
 * author:  ChenQi <BR>
 * createDate:  2019-08-27 23:14 <BR>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiSysTest {
    @Autowired
    private ApiSysController apiSysController;

    /**
     * methodName: sysTest <BR>
     * description: <BR>
     * remark: <BR>
     * param: st <BR>
     * param: i <BR>
     * param: bel <BR>
     * return: java.lang.String <BR>
     * author: ChenQi <BR>
     * createDate: 2019-08-27 23:13 <BR>
     */
    @Test
    public String sysTest(String st,int i,boolean bel){
        apiSysController.testIndex();
        return null;
    }


    /**
     * methodName: test <BR>
     * description: <BR>
     * remark: <BR>
     * param: st <BR>
     * param: i <BR>
     * return: java.lang.String <BR>
     * author: ChenQi <BR>
     * createDate: 2019-08-27 23:23 <BR>
     */
    public String test(String st ,int i){
       // System.out.println( CollectionUtils.isEmpty(new ArrayList<>()));
        return "";
    }
}
