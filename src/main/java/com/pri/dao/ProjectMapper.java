package com.pri.dao;

import com.pri.entity.Project;

import java.util.List;

/**
  * @ClassName:      ProjectMapper
  * @Description:    项目->数据层
  * @author:         ChenQi
  * @CreateDate:     2019/4/27 10:58
  */
public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    /**ChenQi 2019/4/27; 新增项目（有选择性的）*/
    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer id);

    /**ChenQi 2019/4/27; 修改项目（有选择性的）*/
    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKeyWithBLOBs(Project record);

    int updateByPrimaryKey(Project record);

    /**ChenQi 2019/4/27; 根据条件查询项目集合*/
    List<Project> selectProjectListByCondition(Project project);

    /**ChenQi 2019/4/27; 根据主键，做逻辑删除*/
    int deleteLoginById(Integer id);
}