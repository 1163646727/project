package com.pri.service.api;

import com.pri.dao.ProductMapper;
import com.pri.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ApiProductService
 * @Description:    产品->业务逻辑层
 * @auther: Chenqi
 * @Date: 2019/4/27 13:11
 * @Version 1.0 jdk1.8
 */
@Service
public class ApiProductService {

    @Autowired
    private ProductMapper productMapper;

    /**
     *@MethodName:  insertSelective
     *@Description: 新增产品(有选择性地)
     *@Param: [record]
     *@Return: int
     *@author: ChenQi
     *@CreateDate: 2019/4/27 13:13
     */
    public int insertSelective(Product record){
            return  productMapper.insertSelective(record);
    }

    /**
     *@MethodName:  selectByPrimaryKey
     *@Description: 根据主键查询产品
     *@Param: [id]
     *@Return: com.pri.entity.Product
     *@author: ChenQi
     *@CreateDate: 2019/4/27 13:14
     */
    public Product selectByPrimaryKey(Integer id){
        return productMapper.selectByPrimaryKey(id);
    }

    /**
     *@MethodName:  updateByPrimaryKeySelective
     *@Description: 修改产品(有选择性地)
     *@Param: [record]
     *@Return: int
     *@author: ChenQi
     *@CreateDate: 2019/4/27 13:15
     */
    public int updateByPrimaryKeySelective(Product record){
        return productMapper.updateByPrimaryKeySelective(record);
    }

    /**
     *@MethodName:  selectProductListByCondition
     *@Description: 根据条件查询产品集合
     *@Param: [record]
     *@Return: java.util.List<com.pri.entity.Product>
     *@author: ChenQi
     *@CreateDate: 2019/4/27 13:16
     */
    public List<Product> selectProductListByCondition(Product record){
        return productMapper.selectProductListByCondition(record);
    }

    /**
     *@MethodName:  deleteLoginById
     *@Description: 根据主键，做逻辑删除
     *@Param: [id]
     *@Return: int
     *@author: ChenQi
     *@CreateDate: 2019/4/27 13:17
     */
    public int deleteLoginById(Integer id){
       return productMapper.deleteLoginById(id);
    }
}
