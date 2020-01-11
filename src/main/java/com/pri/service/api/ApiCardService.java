package com.pri.service.api;

import com.pri.mapper.CardMapper;
import com.pri.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ApiCardService
 * @Description: 名片业务逻辑层
 * @Auther: Chenqi
 * @Date: 2019/4/24 17:12
 * @Version 1.0 jdk1.8
 */
@Service
public class ApiCardService {
    @Autowired
    private CardMapper cardMapper;


    /**
     *@MethodName:  selectByUserId
     *@Description:  根据用户主键，查询名片集合
     *@Param: [userId]
     *@Return: java.util.List<com.pri.entity.Card>
     *@author: ChenQi
     *@CreateDate: 2019/4/26 15:30
     */
    public List<Card> selectByUserId(Integer userId){
        return cardMapper.selectByUserId(userId);
    }

    /**
     *@MethodName:  selectByPrimaryKey
     *@Description:  根据主键查询名片
     *@Param: [id]
     *@Return: com.pri.entity.Card
     *@author: ChenQi
     *@CreateDate: 2019/4/26 15:44
     */
    public Card selectByPrimaryKey(Integer id){
        return cardMapper.selectByPrimaryKey(id);
    }

    /**
     *@MethodName:  insertSelective
     *@Description: 插入名片
     *@Param: [record]
     *@Return: int
     *@author: ChenQi
     *@CreateDate: 2019/4/26 16:02
     */
    public int insertSelective(Card record){
        return  cardMapper.insertSelective(record);
    }


    /**
     *@MethodName:  deleteById
     *@Description: 根据主键，逻辑删除
     *@Param: [id]
     *@Return: int
     *@author: ChenQi
     *@CreateDate: 2019/4/26 16:44
     */
    public int deleteById(Integer id){
        return cardMapper.deleteById(id);
    }

    /**
     *@MethodName:  updateByPrimaryKeySelective
     *@Description: 修改名片
     *@Param: [record]
     *@Return: int
     *@author: ChenQi
     *@CreateDate: 2019/4/26 17:22
     */
    public int updateByPrimaryKeySelective(Card record){
        return cardMapper.updateByPrimaryKeySelective(record);
    }

}
