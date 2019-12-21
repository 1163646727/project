package com.pri.controller.api;

import com.pri.entity.Card;
import com.pri.entity.ResultVo;
import com.pri.entity.TradeCentre;
import com.pri.service.api.ApiCardService;
import com.pri.service.api.ApiTradeCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: ApiCardController
 * @Description:  名片业务控制层
 * @Auther: Chenqi
 * @Date: 2019/4/24 17:10
 * @Version 1.0 jdk1.8
 */
@RestController
@RequestMapping("/api/card")
public class ApiCardController {
    @Autowired
    private ApiCardService apiCardService;

    /**ChenQi 2019/4/26; 行业中间关系业务层*/
    @Autowired
    private ApiTradeCentreService apiTradeCentreService;


    /**
     *@MethodName:  getCardById
     *@Description: 根据主键查询名片
     *@Param: [request]
     *@Return: com.pri.entity.ResultVo
     *@Author: ChenQi
     *@CreateDate: 2019/4/24 17:15
     */
    @RequestMapping("/getCardById")
    public ResultVo getCardById(HttpServletRequest request){
        ResultVo resultVo = new ResultVo();

        Integer id = Integer.valueOf(request.getParameter("id")==null?"":request.getParameter("id"));
        Card card = apiCardService.selectByPrimaryKey(id);

        resultVo.setCode(1);
        resultVo.setData(card);

        return resultVo;
    }

    /**
     *@MethodName:  getCardListByUserId
     *@Description: 根据微信用户主键，查询该用户的全部名片
     *@Param: [request]
     *@Return: com.pri.entity.ResultVo
     *@Author: ChenQi
     *@CreateDate: 2019/4/24 17:15
     */
    @RequestMapping("/getCardListByUserId")
    public ResultVo getCardListByUserId(HttpServletRequest request){
        ResultVo resultVo = new ResultVo();

        Integer userId = Integer.valueOf(request.getParameter("userId") == null ?"":request.getParameter("userId"));
        if (userId == null){
            resultVo.setCode(0);
            resultVo.setMsg("用户主键异常！");
            return resultVo;
        }
        List<Card> cardList = apiCardService.selectByUserId(userId);
        resultVo.setCode(1);
        resultVo.setData(cardList);

        return resultVo;
    }

    /**
     *@MethodName:  insertCard
     *@Description: 新增名片
     *@Param: [request]
     *@Return: com.pri.entity.ResultVo
     *@Author: ChenQi
     *@CreateDate: 2019/4/24 17:16
     */
    @RequestMapping("/insertCard")
    @Transactional
    public ResultVo insertCard(HttpServletRequest request,Card card){
        ResultVo resultVo = new ResultVo();
        String nid = request.getHeader("nid");

        card.setNid(nid);

        // ChenQi 2019/4/26; 插入名片
        apiCardService.insertSelective(card);

        /**ChenQi 2019/4/26;  添加行业与名片关系数据 */
        //获取行业条件
        String tradeId = request.getParameter("tradeIds");
        // ChenQi 2019/4/26; 将行业主键，封装成字符串集合
        List<String> tradeIdList = apiTradeCentreService.getTradeIdList(tradeId);

        /**ChenQi 2019/4/26; 新增名片与行业关系数据
         * [tradeIdList行业主键集合, relevanceId关联表id, type类型：1.行业与资讯2.行业与名片]*/
        apiTradeCentreService.insetTradeCentre(tradeIdList,card.getId(),2,card.getUserId());
        return resultVo;

    }

    /**
     *@MethodName:  deleteCardById
     *@Description: 根据主键删除名片,逻辑删除
     *@Param: [request]
     *@Return: com.pri.entity.ResultVo
     *@Author: ChenQi
     *@CreateDate: 2019/4/24 17:17
     */
    @RequestMapping("/deleteCardById")
    public ResultVo deleteCardById(HttpServletRequest request){
        ResultVo resultVo = new ResultVo();
        String nid = request.getHeader("nid");
        Integer id = Integer.valueOf(request.getParameter("cardId")==null?"":request.getParameter("cardId"));
        apiCardService.deleteById(id);
        return resultVo;
    }
    /**
     *@MethodName:  updateById
     *@Description: 修改名片
     *@Param: []
     *@Return: com.pri.entity.ResultVo
     *@author: ChenQi
     *@CreateDate: 2019/4/26 17:23
     */
    @RequestMapping("/updateById")
    public ResultVo updateById(HttpServletRequest request,Card card){
        ResultVo resultVo = new ResultVo();
        apiCardService.updateByPrimaryKeySelective(card);

        /**ChenQi 2019/4/26;  修改行业与名片关系数据 */
        //获取行业条件
        String tradeIds = request.getParameter("tradeIds");

        /*
        修改名片与行业关系数据
        ChenQi 2019/4/26;
        */
        apiTradeCentreService.updateTradeCentre(tradeIds,card.getId(),2);

        resultVo.setCode(1);
        return  resultVo;

    }
}
