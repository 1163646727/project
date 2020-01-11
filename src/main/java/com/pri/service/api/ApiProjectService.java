package com.pri.service.api;

import com.pri.mapper.ProjectMapper;
import com.pri.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ApiProjectService
 * @Description: 项目->业务层
 * @auther: Chenqi
 * @Date: 2019/4/27 15:56
 * @Version 1.0 jdk1.8
 */
@Service
public class ApiProjectService {

    /**ChenQi 2019/4/27; 项目->数据层*/
    @Autowired
    private ProjectMapper projectMapper;


    /**
     *@MethodName:  insertSelective
     *@Description: 新增项目（有选择性的）
     *@Param: [record]
     *@Return: int
     *@author: ChenQi
     *@CreateDate: 2019/4/27 15:59
     */
    public int insertSelective(Project record){
        return projectMapper.insertSelective(record);
    }

    /**
     *@MethodName:  deleteLoginById
     *@Description: 根据主键，做逻辑删除
     *@Param: [id]
     *@Return: int
     *@author: ChenQi
     *@CreateDate: 2019/4/27 15:59
     */
    public int deleteLoginById(Integer id){
        return projectMapper.deleteLoginById(id);
    }

    /**
     *@MethodName:  updateByPrimaryKeySelective
     *@Description: 修改项目（有选择性的）
     *@Param: [record]
     *@Return: int
     *@author: ChenQi
     *@CreateDate: 2019/4/27 16:01
     */
    public int updateByPrimaryKeySelective(Project record){
        return projectMapper.updateByPrimaryKeySelective(record);
    }

    /**
     *@MethodName:  selectByProjectListByCondition
     *@Description: 根据条件查询项目集合
     *@Param: [project]
     *@Return: java.util.List<com.pri.entity.Project>
     *@author: ChenQi
     *@CreateDate: 2019/4/27 15:57
     */
    public List<Project> selectProjectListByCondition(Project project){
        return projectMapper.selectProjectListByCondition(project);
    }
}
