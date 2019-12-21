package com.pri.controller.api;

import com.pri.entity.Product;
import com.pri.entity.ResultVo;
import com.pri.service.api.ApiProductService;
import com.pri.service.api.ApiTradeCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName: ApiProductController
 * @Description:    产品->控制层
 * @auther: Chenqi
 * @Date: 2019/4/27 13:18
 * @Version 1.0 jdk1.8
 */
@RestController
@RequestMapping("/api/product")
public class ApiProductController {

    /**ChenQi 2019/4/27; 产品->业务逻辑层接口*/
    @Autowired
    private ApiProductService apiProductService;

    /**ChenQi 2019/4/27; 行业中间关系业务层接口*/
    @Autowired
    private ApiTradeCentreService apiTradeCentreService;

    /**
     *@MethodName:  insertSelective
     *@Description: 新增产品(有选择性地)
     *@Param: []
     *@Return: com.pri.entity.ResultVo
     *@author: ChenQi
     *@CreateDate: 2019/4/27 13:21
     */
    @RequestMapping("/insert")
    public ResultVo insert(HttpServletRequest request, Product product){
        ResultVo resultVo = new ResultVo();
        String nid = request.getHeader("nid");
        product.setNid(nid);

        apiProductService.insertSelective(product);

        resultVo.setCode(1);
        return resultVo;
    }

    /**
     *@MethodName:  selectById
     *@Description: 根据主键查询产品
     *@Param: []
     *@Return: com.pri.entity.ResultVo
     *@author: ChenQi
     *@CreateDate: 2019/4/27 13:28
     */
    @RequestMapping("/selectById")
    public ResultVo selectById(HttpServletRequest request){
        ResultVo resultVo = new ResultVo();
        Integer id = Integer.valueOf(request.getParameter("id"));
        Product product = apiProductService.selectByPrimaryKey(id);
        resultVo.setCode(1);
        resultVo.setData(product);
        return resultVo;
    }

    /**
     *@MethodName:  updateByById
     *@Description: 修改产品(有选择性地)
     *@Param: [request, record]
     *@Return: com.pri.entity.ResultVo
     *@author: ChenQi
     *@CreateDate: 2019/4/27 13:39
     */
    @RequestMapping("/updateByById")
    public ResultVo updateByById(HttpServletRequest request,Product record){
        ResultVo resultVo = new ResultVo();
        apiProductService.updateByPrimaryKeySelective(record);
        resultVo.setCode(1);
        return resultVo;
    }

    /**
     *@MethodName:  selectProductListByCondition
     *@Description: 根据条件查询产品集合
     *@Param: [request, record]
     *@Return: com.pri.entity.ResultVo
     *@author: ChenQi
     *@CreateDate: 2019/4/27 13:42
     */
    @RequestMapping("/selectProductListByCondition")
    public ResultVo selectProductListByCondition(HttpServletRequest request,Product record){
        ResultVo resultVo = new ResultVo();

        String nid = request.getHeader("nid");
        // ChenQi 2019/4/27; 行业id,如果多个用','分隔，例如1,2,4
        String tredeIds = request.getParameter("tredeIds");
        // ChenQi 2019/4/27;根据行业id，获取关联表id集合
        List<Integer> ids = apiTradeCentreService.getRelevanceIdList(tredeIds,3);
        record.setIds(ids);
        record.setNid(nid);

        List<Product> productList = apiProductService.selectProductListByCondition(record);
        resultVo.setCode(1);
        resultVo.setData(productList);
        return resultVo;
    }

    /**
     *@MethodName:  deleteById
     *@Description: 根据主键，做逻辑删除
     *@Param: [request]
     *@Return: com.pri.entity.ResultVo
     *@author: ChenQi
     *@CreateDate: 2019/4/27 13:45
     */
    @RequestMapping("/deleteById")
    public ResultVo deleteById(HttpServletRequest request){
        ResultVo resultVo = new ResultVo();
        Integer id = Integer.valueOf(request.getParameter("id"));
        apiProductService.deleteLoginById(id);
        resultVo.setCode(1);
        return resultVo;
    }
}
