package com.pri.controller.api;

import com.pri.entity.Project;
import com.pri.entity.ResultVo;
import com.pri.service.api.ApiProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName: ApiProjectController
 * @Description: 项目->控制层
 * @auther: Chenqi
 * @Date: 2019/4/27 16:02
 * @Version 1.0 jdk1.8
 */
@RestController
@RequestMapping("/api/project")
public class ApiProjectController {

    /**ChenQi 2019/4/27; 项目->业务层接口*/
    @Autowired
    private ApiProjectService apiProjectService;


    /**
     *@MethodName:  insert
     *@Description: 新增项目（有选择性的）
     *@Param: [request, project]
     *@Return: com.pri.entity.ResultVo
     *@author: ChenQi
     *@CreateDate: 2019/4/27 16:05
     */
    @RequestMapping("insert")
    public ResultVo insert(HttpServletRequest request, Project project){
        ResultVo resultVo = new ResultVo();
        String nid = request.getHeader("nid");
        project.setNid(nid);

        apiProjectService.insertSelective(project);

        resultVo.setCode(1);
        return  resultVo;
    }

    /**
     *@MethodName:  delete
     *@Description: 根据主键，做逻辑删除
     *@Param: [request]
     *@Return: com.pri.entity.ResultVo
     *@author: ChenQi
     *@CreateDate: 2019/4/27 16:09
     */
    @RequestMapping("/delete")
    public ResultVo delete(HttpServletRequest request){
        ResultVo resultVo = new ResultVo();
        Integer id = Integer.valueOf(request.getParameter("id"));
        apiProjectService.deleteLoginById(id);
        resultVo.setCode(1);
        return resultVo;
    }

    /**
     *@MethodName:  update
     *@Description: 修改项目（有选择性的）
     *@Param: [request]
     *@Return: com.pri.entity.ResultVo
     *@author: ChenQi
     *@CreateDate: 2019/4/27 16:11
     */
    @RequestMapping("/update")
    public ResultVo update(HttpServletRequest request,Project project){
        ResultVo resultVo = new ResultVo();
        apiProjectService.updateByPrimaryKeySelective(project);
        resultVo.setCode(1);
        return resultVo;
    }

    /**
     *@MethodName:  selectProjectList
     *@Description: 根据条件查询项目集合
     *@Param: [request, project]
     *@Return: com.pri.entity.ResultVo
     *@author: ChenQi
     *@CreateDate: 2019/4/27 16:15
     */
    @RequestMapping("/selectProjectList")
    public ResultVo selectProjectList(HttpServletRequest request,Project project){
        ResultVo resultVo = new ResultVo();
        List<Project> list = apiProjectService.selectProjectListByCondition(project);
        resultVo.setCode(1);
        resultVo.setData(list);
        return resultVo;
    }
}
