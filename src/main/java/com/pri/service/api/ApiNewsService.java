package com.pri.service.api;

import com.pri.mapper.NewsMapper;
import com.pri.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ApiNewsService
 * @Description: 资讯（新闻）业务逻辑层
 * @Auther: Chenqi
 * @Date: 2019/4/24 17:34
 * @Version 1.0 jdk1.8
 */
@Service
public class ApiNewsService {
    @Autowired
    private NewsMapper newsMapper;

    /**
     *@MethodName:  selectByPrimaryKey
     *@Description:  根据主键查询
     *@Param: [id]
     *@Return: com.pri.entity.News
     *@Author: ChenQi
     *@CreateDate: 2019/4/25 9:10
     */
    public  News selectByPrimaryKey(Integer id){
        return  newsMapper.selectByPrimaryKey(id);
    }

    /**
     *@MethodName:  deleteByPrimaryKey
     *@Description: 删除资讯,根据主键逻辑删除
     *@Param: [id]
     *@Return: int
     *@Author: ChenQi
     *@CreateDate: 2019/4/25 9:51
     */
    public int deleteByPrimaryKey(Integer id){
        return  newsMapper.deleteLogicByid(id);
    }

    /**
     *@MethodName:  insert
     *@Description: 添加资讯
     *@Param: [record]
     *@Return: int
     *@Author: ChenQi
     *@CreateDate: 2019/4/25 10:16
     */
    public int insert(News record){
        return newsMapper.insert(record);
    }

    /**
     *@MethodName:  updateByPrimaryKeySelective
     *@Description: 修改资讯
     *@Param: [record]
     *@Return: int
     *@Author: ChenQi
     *@CreateDate: 2019/4/25 10:46
     */
    public int updateByPrimaryKeySelective(News record){
        return  newsMapper.updateByPrimaryKeySelective(record);
    }


    /**
     *@MethodName:  selectNewsIdListByTradeList
     *@Description: 根据行业主键查询资讯主键集合
     *@Param: [TradeList]
     *@Return: java.util.List<java.lang.Integer>
     *@Author: ChenQi
     *@CreateDate: 2019/4/25 14:28
     */
    public List<Integer> selectNewsIdListByTradeList(List<String> tradeList){
        return newsMapper.selectNewsIdListByTradeList(tradeList);
    }

    /**
     *@MethodName:  selectNewsListByTitleOrContent
     *@Description:  根据条件查询资讯集合
     *@Param: [condition, nid]
     *@Return: java.util.List<com.pri.entity.News>
     *@Author: ChenQi
     *@CreateDate: 2019/4/25 15:25
     */
    public List<News> selectNewsListByCondition(News record){
        return newsMapper.selectNewsListByCondition(record);
    }
}
