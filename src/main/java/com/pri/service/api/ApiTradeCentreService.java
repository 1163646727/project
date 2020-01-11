package com.pri.service.api;

import com.pri.mapper.TradeCentreMapper;
import com.pri.entity.TradeCentre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: ApiTradeCentreService
 * @Description:    行业中间关系业务层
 * @auther: Chenqi
 * @Date: 2019/4/26 13:28
 * @Version 1.0 jdk1.8
 */
@Service
public class ApiTradeCentreService {

    @Autowired
    private TradeCentreMapper tradeCentreMapper;

    /**
     *@MethodName:  insetTradeCentreList
     *@Description: 批量插入数据
     *@Param: [list]
     *@Return: int
     *@author: ChenQi
     *@CreateDate: 2019/4/26 13:30
     */
    public int insetTradeCentreList(List<TradeCentre> list){
        return  tradeCentreMapper.insetTradeCentreList(list);
    }

    /**
     *@MethodName:  deleteByRelevanceIdAndType
     *@Description: 根据关联表主键和类型，删除相关的数据
     *@Param: [tradeCentre]
     *@Return: int
     *@author: ChenQi
     *@CreateDate: 2019/4/26 13:31
     */
    public int deleteByRelevanceIdAndType(TradeCentre tradeCentre){
        return tradeCentreMapper.deleteByRelevanceIdAndType(tradeCentre);
    }

    /**
     *@MethodName:  getTradeIdList
     *@Description: 行业id,如果多个用','分隔，例如1,2,4；
     *                  将行业主键，封装成字符串集合
     *@Param: [tredeIds]
     *@Return: java.util.List<java.lang.String>
     *@Author: ChenQi
     *@CreateDate: 2019/4/26 9:25
     */
    public List<String> getTradeIdList(String tredeIds){
        List<String> tradeIdList = null;
        if(!StringUtils.isEmpty(tredeIds)){
            tradeIdList = Arrays.asList(tredeIds.split(","));
        }
        return tradeIdList;
    }

    /**
     *@MethodName:  getRelevanceIdList
     *@Description: 根据行业id，获取关联表id集合
     *@Param: [tredeIds, type]
     *@Return: java.util.List<java.lang.Integer>
     *@author: ChenQi
     *@CreateDate: 2019/4/27 14:34
     */
    public List<Integer> getRelevanceIdList(String tredeIds,Integer type){

        List<Integer> relevanceIdList = null;

        // ChenQi 2019/4/27; 将行业主键，封装成字符串集合
        List<String> tradeIdList = null;
        if(!StringUtils.isEmpty(tredeIds)){
            tradeIdList = Arrays.asList(tredeIds.split(","));
        }
        if(tradeIdList != null){
            relevanceIdList = tradeCentreMapper.selectRelevanceIdList(tradeIdList,type);
        }

        return relevanceIdList;
    }

    /**
     *@MethodName:  insetTradeCentre
     *@Description: 新增资讯与行业关系数据
     *@Param: [tradeIdList行业主键集合, relevanceId关联表id, type类型：1.行业与资讯2.行业与名片]
     *@Return: void
     *@author: ChenQi
     *@CreateDate: 2019/4/26 18:15
     */
    public void insetTradeCentre(List<String> tradeIdList,Integer relevanceId,Integer type,Integer WxUserId){
        List<TradeCentre> tradeNewsList = new ArrayList<>();
        for(String st:tradeIdList ){
            TradeCentre radeCentre = new TradeCentre();
            radeCentre.setTradeId(Integer.valueOf(st));
            radeCentre.setRelevanceId(relevanceId);
            radeCentre.setType(type);
            radeCentre.setWxUserId( WxUserId );
            tradeNewsList.add(radeCentre);
        }
        // ChenQi 2019/4/26; 批量插入数据
        if (tradeNewsList.size()>0){
            insetTradeCentreList(tradeNewsList);
        }
    }

    /**
     *@MethodName:  updateTradeCentre
     *@Description: 修改行业中间关系数据
     *@Param: [tradeIds, relevanceId, type]
     *@Return: void
     *@author: ChenQi
     *@CreateDate: 2019/4/28 14:49
     */
    public void updateTradeCentre(String tradeIds,Integer relevanceId,Integer type){
        // ChenQi 2019/4/28; 获取参数中最新的行业主键集合
        List<String> newTradeIdList = getTradeIdList(tradeIds);
        // ChenQi 2019/4/28; 根据类型和关联表id，查询数据中已经存在的行业主键集合
        List<String> oldTradeIdList = tradeCentreMapper.selectTradeIdListByTypeAndRelevanceId(relevanceId,type);

        // ChenQi 2019/4/28;计算数据库中需要删除的行业关系数据
        List<String> deleteTradeIdsList = new ArrayList<>();
        for(String tradeId:oldTradeIdList){
            if(!newTradeIdList.contains(tradeId)){
                deleteTradeIdsList.add(tradeId);
            }
        }
        if(deleteTradeIdsList.size()>0){
            // ChenQi 2019/4/28;批量删除数据，根据类型、关联表id、行业id，
            tradeCentreMapper.deleteByTypeAndRelevanceIdAndTradeId(type,relevanceId,deleteTradeIdsList);
        }

        // ChenQi 2019/4/28;计算需要新增的行业关系数据
        List<TradeCentre> list = new ArrayList<>();
        for(String tradeId:newTradeIdList){
            if(!oldTradeIdList.contains(tradeId)){
                TradeCentre tradeCentre = new TradeCentre();
                tradeCentre.setType(type);
                tradeCentre.setRelevanceId(relevanceId);
                tradeCentre.setTradeId(Integer.valueOf(tradeId));
                list.add(tradeCentre);
            }
        }
        if(list.size()>0){
            // ChenQi 2019/4/28;批量插入数据
            tradeCentreMapper.insetTradeCentreList(list);
        }
    }

    /**
     *@MethodName:  getTradeIdListByWxUserId
     *@Description: 根据微信用户主键，获取用户全部的行业
     *@Param: [WxUserId]
     *@Return: java.util.List<java.lang.Integer>
     *@author: ChenQi
     *@CreateDate: 2019/5/6 15:01
     */
    public List<Integer> getTradeIdListByWxUserId(Integer WxUserId){
        List<Integer> list = tradeCentreMapper.getTradeIdListByWxUserId( WxUserId );
        return list;
    }
}
