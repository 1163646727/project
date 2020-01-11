package com.pri.mapper;

import com.pri.entity.Activitys;

import java.util.List;

/**
  * @ClassName:      ActivitysMapper
  * @Description:    活动->数据层
  * @author:         ChenQi
  * @CreateDate:     2019/4/27 10:57
  */
public interface ActivitysMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Activitys record);

    /**ChenQi 2019/4/27; 新增活动(有选择性的)*/
    int insertSelective(Activitys record);

    Activitys selectByPrimaryKey(Integer id);

    /**ChenQi 2019/4/27; 修改活动(有选择性的)*/
    int updateByPrimaryKeySelective(Activitys record);

    int updateByPrimaryKeyWithBLOBs(Activitys record);

    int updateByPrimaryKey(Activitys record);

     /**ChenQi 2019/4/27; 根据条件查询活动集合*/
     List<Activitys> selectActivitysListByCondition(Activitys activitys);

     /**ChenQi 2019/4/27; 根据主键，做逻辑删除*/
     int deleteLogicById(Integer id);
}