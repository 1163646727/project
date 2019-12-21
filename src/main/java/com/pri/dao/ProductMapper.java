package com.pri.dao;

import com.pri.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
  * @ClassName:      ProductMapper
  * @Description:    产品数据层
  * @author:         ChenQi
  * @CreateDate:     2019/4/27 10:58
  */
public interface ProductMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    /**ChenQi 2019/4/27; 新增产品(有选择性地)*/
    int insertSelective(Product record);

    /**ChenQi 2019/4/27; 根据主键查询产品*/
    Product selectByPrimaryKey(Integer id);

    /**ChenQi 2019/4/27; 修改产品(有选择性地)*/
    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);

    /**ChenQi 2019/4/27; 根据条件查询产品集合*/
    List<Product> selectProductListByCondition(Product record);

    /**ChenQi 2019/4/27; 根据主键，做逻辑删除*/
    int deleteLoginById(Integer id);
}