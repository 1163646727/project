package com.pri.controller.api;

import com.pri.entity.Activitys;
import com.pri.entity.ResultVo;
import com.pri.service.api.ApiActivitysService;
import com.pri.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * @ClassName: ApiActivitysController
 * @Description:   活动->控制层
 * @auther: Chenqi
 * @Date: 2019/4/27 17:02
 * @Version 1.0 jdk1.8
 */
@RestController
@RequestMapping("/api/activatys")
public class ApiActivitysController {

    /**ChenQi 2019/4/27; 活动->业务层接口*/
    @Autowired
    private ApiActivitysService apiActivitysService;


    /**
     *@MethodName:  insert
     *@Description: 新增活动(有选择性的)
     *@Param: [request, activitys]
     *@Return: com.pri.entity.ResultVo
     *@author: ChenQi
     *@CreateDate: 2019/4/27 17:07
     */
    @RequestMapping("/insert")
    public ResultVo insert(HttpServletRequest request, Activitys activitys) throws ParseException {
        ResultVo resultVo = new ResultVo();
        String nid = request.getHeader("nid");
        activitys.setNid(nid);

        /*ChenQi 2019/4/28; 手动处理日期参数*/
        String startDateSt = request.getParameter("startDateSt");
        String endDateSt = request.getParameter("endDateSt");
        if(!StringUtils.isEmpty(startDateSt)){
            activitys.setStartDate(DateUtils.dateParse(startDateSt,null));
        }
        if(!StringUtils.isEmpty(endDateSt)){
            activitys.setEndDate(DateUtils.dateParse(endDateSt,null));
        }


        apiActivitysService.insertSelective(activitys);
        resultVo.setCode(1);
        return resultVo;
    }

    /**
     *@MethodName:  deleteById
     *@Description: 根据主键，做逻辑删除
     *@Param: [request]
     *@Return: com.pri.entity.ResultVo
     *@author: ChenQi
     *@CreateDate: 2019/4/27 17:14
     */
    @RequestMapping("/deleteById")
    public ResultVo deleteById(HttpServletRequest request){
        ResultVo resultVo = new ResultVo();
        Integer id = Integer.valueOf(request.getParameter("id"));
        apiActivitysService.deleteLogicById(id);
        resultVo.setCode(1);
        return resultVo;
    }

    /**
     *@MethodName:  update
     *@Description: 修改活动(有选择性的)
     *@Param: [request,activitys]
     *@Return: com.pri.entity.ResultVo
     *@author: ChenQi
     *@CreateDate: 2019/4/27 17:10
     */
    @RequestMapping("/update")
    public ResultVo update(HttpServletRequest request,Activitys activitys) throws ParseException {
        ResultVo resultVo = new ResultVo();
        /*ChenQi 2019/4/28; 手动处理日期参数*/
        String startDateSt = request.getParameter("startDateSt");
        String endDateSt = request.getParameter("endDateSt");
        if(!StringUtils.isEmpty(startDateSt)){
            activitys.setStartDate(DateUtils.dateParse(startDateSt,null));
        }
        if(!StringUtils.isEmpty(endDateSt)){
            activitys.setEndDate(DateUtils.dateParse(endDateSt,null));
        }
        apiActivitysService.updateByPrimaryKeySelective(activitys);
        resultVo.setCode(1);
        return resultVo;
    }

    /**
     *@MethodName:  selectActivitysList
     *@Description: 根据条件查询活动集合
     *@Param: [request, activitys]
     *@Return: com.pri.entity.ResultVo
     *@author: ChenQi
     *@CreateDate: 2019/4/27 17:12
     */
    @RequestMapping("/selectActivitysList")
    public ResultVo selectActivitysList(HttpServletRequest request,Activitys activitys){
        ResultVo resultVo = new ResultVo();
        String nid = request.getHeader("nid");
        activitys.setNid(nid);
        List<Activitys> list = apiActivitysService.selectActivitysListByCondition(activitys);

        resultVo.setCode(1);
        resultVo.setData(list);
        return resultVo;
    }
}
