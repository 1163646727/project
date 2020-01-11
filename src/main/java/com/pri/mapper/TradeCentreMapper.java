package com.pri.mapper;

import com.pri.entity.TradeCentre;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
  * @ClassName:      TradeCentreMapper
  * @Description:    行业中间关系数据层
  * @author:         ChenQi
  * @CreateDate:     2019/4/26 13:12
  */
public interface TradeCentreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TradeCentre record);

    int insertSelective(TradeCentre record);

    TradeCentre selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TradeCentre record);

    int updateByPrimaryKey(TradeCentre record);

     /**ChenQi 2019/4/26; 批量插入数据*/
     int insetTradeCentreList(List<TradeCentre> list);

     /**ChenQi 2019/4/26; 根据关联表主键和类型，删除相关的数据*/
     int deleteByRelevanceIdAndType(TradeCentre tradeCentre);

     /**ChenQi 2019/4/27; 根据行业主键和类型，查询关联表id集合*/
     List<Integer> selectRelevanceIdList(@Param("tredeIdList") List<String> tredeIdList,@Param("typ") Integer typ);

     /**ChenQi 2019/4/28; 根据类型和关联表id，查询数据中已经存在的行业主键集合*/
    List<String> selectTradeIdListByTypeAndRelevanceId(@Param("relevanceId") Integer relevanceId,@Param("typ") Integer typ);

    /**ChenQi 2019/4/28; 批量删除数据，根据类型、关联表id、行业id，*/
    int deleteByTypeAndRelevanceIdAndTradeId(@Param("typ") Integer typ,@Param("relevanceId") Integer relevanceId,@Param("tradeIdList") List<String> tradeIdList);

    /**ChenQi 2019/5/6; 根据微信用户主键，获取用户全部的行业*/
    List<Integer> getTradeIdListByWxUserId(Integer WxUserId);
}