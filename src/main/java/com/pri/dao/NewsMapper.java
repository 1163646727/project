package com.pri.dao;

import com.pri.entity.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * class name:NewsMapper <BR>
 * class description: 资讯（新闻） <BR>
 * Remark: <BR>
 * @version 1.00 2019年4月24日
 * @author )chenqi
 */
public interface NewsMapper{
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);

    /**ChenQi 2019/5/5; 根据行业主键查询资讯主键集合*/
    List<Integer> selectNewsIdListByTradeList(List<String> tradeList);

    /**ChenQi 2019/5/5; 根据条件查询资讯集合*/
    //List<News> selectNewsListByCondition(Map<String,Object> map);

    /**ChenQi 2019/4/26;  根据主键逻辑删除*/
    int deleteLogicByid(Integer id);

    /**ChenQi 2019/4/28; 根据条件查询资讯集合*/
    List<News> selectNewsListByCondition(News record);

}