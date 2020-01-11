package com.pri.mapper;

import com.pri.entity.ActivitysJoinsInfo;

 /**
  * @ClassName:      ActivitysJoinsInfoMapper
  * @Description:    用户-活动关系数据层
  * @author:         ChenQi
  * @CreateDate:     2019/4/27 10:57
  */
public interface ActivitysJoinsInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActivitysJoinsInfo record);

    int insertSelective(ActivitysJoinsInfo record);

    ActivitysJoinsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActivitysJoinsInfo record);

    int updateByPrimaryKey(ActivitysJoinsInfo record);
}