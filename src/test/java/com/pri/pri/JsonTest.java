package com.pri.pri;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;
import java.util.List;
/**
 * className: JsonTest <BR>
 * description: <BR>
 * remark: Java中操作JSON<BR>
 * author: ChenQi <BR>
 * createDate: 2020-11-18 10:56 <BR>
 */
@RunWith (SpringRunner.class)
@SpringBootTest
public class JsonTest {
    /** JSON 编码测试 ChenQi*/
    @Test
    public void editTest(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("string","String");
        jsonObject.put("int",1);
        // 存放集合 ChenQi
        List<Integer> list = Arrays.asList(1,2,3);
        jsonObject.put("list",list);
        System.out.println(jsonObject);
        /** 打印
         * {"string":"String","list":[1,2,3],"int":1}
         * ChenQi*/
    }

    /** JSON解析测试 ChenQi*/
    @Test
    public void parseTest(){
        JSONObject object = JSONObject.parseObject("{\"boolean\":true,\"string\":\"string\",\"list\":[1,2,3],\"int\":2}");
        String st = object.getString("string");
        int i = object.getInteger("int");
        Boolean bool = object.getBoolean("boolean");
        System.out.println("st:"+st+",i:"+i+",bool:"+bool);
        List<Integer> list = JSON.parseArray(object.getJSONArray("list").toJSONString(),Integer.class);
        list.forEach(item -> System.out.println(item));
        /** 打印
         * st:string,i:2,bool:true
         * 1
         * 2
         * 3
         * ChenQi*/
    }
}