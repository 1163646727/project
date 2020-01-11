package com.pri.service.api;

import com.pri.mapper.ActivitysMapper;
import com.pri.entity.Activitys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ApiActivitysService
 * @Description:    活动->业务层
 * @auther: Chenqi
 * @Date: 2019/4/27 16:56
 * @Version 1.0 jdk1.8
 */
@Service
public class ApiActivitysService {

    /**ChenQi 2019/4/27; 活动->数据层接口*/
    @Autowired
    private ActivitysMapper activitysMapper;


    /**
     *@MethodName:  insertSelective
     *@Description: 新增活动(有选择性的)
     *@Param: [record]
     *@Return: int
     *@author: ChenQi
     *@CreateDate: 2019/4/27 16:58
     */
    public int insertSelective(Activitys record){
        return activitysMapper.insertSelective(record);
    }

    /**
     *@MethodName:  deleteLoginById
     *@Description: 根据主键，做逻辑删除
     *@Param: [id]
     *@Return: int
     *@author: ChenQi
     *@CreateDate: 2019/4/27 16:58
     */
    public int deleteLogicById(Integer id){
        return activitysMapper.deleteLogicById(id);
    }


    /**
     *@MethodName:  updateByPrimaryKeySelective
     *@Description: 修改活动(有选择性的)
     *@Param: [record]
     *@Return: int
     *@author: ChenQi
     *@CreateDate: 2019/4/27 17:00
     */
    public int updateByPrimaryKeySelective(Activitys record){
        return activitysMapper.updateByPrimaryKeySelective(record);
    }


    /**
     *@MethodName:  selectActivitysListByCondition
     *@Description: 根据条件查询活动集合
     *@Param: [activitys]
     *@Return: java.util.List<com.pri.entity.Activitys>
     *@author: ChenQi
     *@CreateDate: 2019/4/27 17:01
     */
    public List<Activitys> selectActivitysListByCondition(Activitys activitys){
        return activitysMapper.selectActivitysListByCondition(activitys);
    }
}
