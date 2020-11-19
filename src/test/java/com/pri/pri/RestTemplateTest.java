package com.pri.pri;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * className: RestTemplateTest <BR>
 * description:RestTemplate测试 <BR>
 * remark: <BR>
 * author: ChenQi <BR>
 * createDate: 2020-11-19 11:32 <BR>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateTest {

    @Test
    public void restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://cpro.baidustatic.com/cpro/ui/noexpire/img/4.0.0/pc_ads_bear.1x.png";
        try {
            com.alibaba.fastjson.JSONObject result = restTemplate.getForObject(url,null,com.alibaba.fastjson.JSONObject.class);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void restTemplate2(){
        RestTemplate restT = new RestTemplate();
        com.alibaba.fastjson.JSONObject quoteString = restT.getForObject("http://gturnquist-quoters.cfapps.io/api/random", com.alibaba.fastjson.JSONObject.class);
        System.out.println(quoteString);
    }

    @Test
    public void restTemplate3(){
        RestTemplate restTemplate = new RestTemplate();
        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("key1","value1");
        headers.add("key2","value2");

        HttpEntity<String> entity = new HttpEntity<>(new String(), headers);
        String url = "http://xxx.com";
        //发送post请求
        JSONObject result = restTemplate.postForObject(url, entity, JSONObject.class);
        System.out.println(result);
    }
}
