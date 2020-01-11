package com.pri.mapper;

import com.pri.entity.Card;

import java.util.List;

public interface CardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Card record);

    /**ChenQi 2019/4/26; 插入名片*/
    int insertSelective(Card record);

    /**ChenQi 2019/4/26; 根据主键查询名片*/
    Card selectByPrimaryKey(Integer id);

    /**ChenQi 2019/4/26; 修改名片*/
    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);

    /**ChenQi 2019/4/26; 根据用户主键，查询名片集合*/
    List<Card>  selectByUserId(Integer userId);

    /**ChenQi 2019/4/26; 根据主键，逻辑删除*/
    int deleteById(Integer id);

}