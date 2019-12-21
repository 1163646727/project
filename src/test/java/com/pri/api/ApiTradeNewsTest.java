package com.pri.api;

import com.pri.service.api.ApiTradeCentreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ApiTradeNewsTest
 * @Description:
 * @Auther: Chenqi
 * @Date: 2019/4/26 10:35
 * @Version 1.0 jdk1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTradeNewsTest {

    /**ChenQi 2019/4/27; 行业中间关系业务层接口*/
    @Autowired
    private ApiTradeCentreService apiTradeCentreService;


    /**
    *@MethodName:
    *@Description: 根据行业id，获取关联表id集合
    *@Param:
    *@Return:
    *@author: ChenQi
    *@CreateDate: 2019/4/27 14:56
    */
    @Test
    public void getRelevanceIdList(){
        List<Integer> list = new ArrayList<>();
                list = apiTradeCentreService.getRelevanceIdList("",1);
        list.forEach(e -> System.out.println(e));
    }

    /**
     *@MethodName:  updateTradeCentre
     *@Description: 修改行业中间关系数据
     *@Param: []
     *@Return: void
     *@author: ChenQi
     *@CreateDate: 2019/4/28 15:00
     */
    @Test
    public void updateTradeCentre(){
        apiTradeCentreService.updateTradeCentre("1,2,3",6,2);
    }

}
