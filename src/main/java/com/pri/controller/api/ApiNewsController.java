package com.pri.controller.api;

import com.pri.entity.News;
import com.pri.entity.ResultVo;
import com.pri.entity.TradeCentre;
import com.pri.service.api.ApiNewsService;
import com.pri.service.api.ApiTradeCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @ClassName: ApiNewsController
 * @Description: 资讯（新闻）控制层
 * @Auther: Chenqi
 * @Date: 2019/4/24 17:33
 * @Version 1.0 jdk1.8
 */
@RestController
@RequestMapping("/api/news")
public class ApiNewsController {

    @Autowired
    private ApiNewsService apiNewsService;

    /**ChenQi 2019/4/26; 行业中间关系业务层*/
    @Autowired
    private ApiTradeCentreService apiTradeCentreService;

    /**
     *@MethodName:  selectNewsListByCondition
     *@Description:     根据查询条件，获取资讯集合
     *@Param: [request]
     *@Return: com.pri.entity.ResultVo
     *@Author: ChenQi
     *@CreateDate: 2019/4/24 17:46
     */
    @RequestMapping("/selectNewsListByCondition")
    public ResultVo selectNewsListByCondition(HttpServletRequest request,News news){
        ResultVo resultVo = new ResultVo();
        String nid = request.getHeader("nid");

        // ChenQi 2019/4/27; 行业id,如果多个用','分隔，例如1,2,4
        String tredeIds = request.getParameter("tradeIds");
        // ChenQi 2019/4/27;根据行业id，获取关联表id集合
        List<Integer> ids = apiTradeCentreService.getRelevanceIdList(tredeIds,1);
        news.setNid(nid);
        news.setIds(ids);

        List<News> list = apiNewsService.selectNewsListByCondition(news);

        resultVo.setCode(1);
        resultVo.setData(list);
        return resultVo;
    }


    /**
     *@MethodName:  selectNewsById
     *@Description: 根据主键，查询资讯
     *@Param: [request]
     *@Return: com.pri.entity.ResultVo
     *@Author: ChenQi
     *@CreateDate: 2019/4/24 17:49
     */
    @RequestMapping("/selectNewsById")
    public ResultVo selectNewsById(HttpServletRequest request){
        ResultVo resultVo = new ResultVo();

        Integer id = Integer.valueOf(request.getParameter("id")==null ? "":request.getParameter("id"));
        News news = news = apiNewsService.selectByPrimaryKey(id);

        resultVo.setCode(1);
        resultVo.setData(news);

        return resultVo;
    }

    /**
     *@MethodName:  insertNews
     *@Description: 添加资讯
     *@Param: [request]
     *@Return: com.pri.entity.ResultVo
     *@Author: ChenQi
     *@CreateDate: 2019/4/24 17:57
     */
    @RequestMapping("/insertNews")
    @Transactional
    public ResultVo insertNews(HttpServletRequest request,News news){
        ResultVo resultVo = new ResultVo();
        String nid = request.getHeader("nid");
        news.setNid(nid);

        apiNewsService.insert(news);

        //获取、封装行业条件
        // ChenQi 2019/4/26; 行业id,如果多个用','分隔，例如1,2,4
        String tradeId = request.getParameter("tradeIds");
        // ChenQi 2019/4/26; 将行业主键，封装成字符串集合
        List<String> tradeIdList = apiTradeCentreService.getTradeIdList(tradeId);

       /**ChenQi 2019/4/26; 新增资讯与行业关系数据
        * [tradeIdList行业主键集合, relevanceId关联表id, type类型：1.行业与资讯2.行业与名片]
        * */
        apiTradeCentreService.insetTradeCentre(tradeIdList,news.getId(),1,news.getOwnerId());

        resultVo.setCode(1);

        return resultVo;
    }

    /**
     *@MethodName:  deleteNewsById
     *@Description:  删除资讯,根据主键,逻辑删除
     *@Param: [request]
     *@Return: com.pri.entity.ResultVo
     *@Author: ChenQi
     *@CreateDate: 2019/4/24 17:58
     */
    @RequestMapping("/deleteNewsById")
    @Transactional
    public ResultVo deleteNewsById(HttpServletRequest request){
        ResultVo resultVo = new ResultVo();
        Integer id = Integer.valueOf(request.getParameter("id")==null ? "":request.getParameter("id"));
        apiNewsService.deleteByPrimaryKey(id);

        resultVo.setCode(1);
        return resultVo;
    }

    /**
     *@MethodName:  updateNewsById
     *@Description: 修改资讯
     *@Param: [request]
     *@Return: com.pri.entity.ResultVo
     *@Author: ChenQi
     *@CreateDate: 2019/4/24 17:58
     */
    @RequestMapping("/updateNewsById")
    public ResultVo updateNewsById(HttpServletRequest request,News news){
        ResultVo resultVo = new ResultVo();

        apiNewsService.updateByPrimaryKeySelective(news);

        // ChenQi 2019/4/26; 行业id,如果多个用','分隔，例如1,2,4
        String tradeIds = request.getParameter("tradeIds");
        /*
        修改资讯与行业关系数据
        ChenQi 2019/4/26;
        */
        apiTradeCentreService.updateTradeCentre(tradeIds,news.getId(),1);

        resultVo.setCode(1);
        return resultVo;
    }

}
