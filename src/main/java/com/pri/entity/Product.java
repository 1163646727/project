package com.pri.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
  * @ClassName:      Product
  * @Description:    产品实体类
  * @author:         ChenQi
  * @CreateDate:     2019/4/27 10:54
  */
@Data
public class Product {
    /**ChenQi 2019/4/28; 产品*/
    private Integer id;

    /**ChenQi 2019/4/28; 平台id*/
    private String nid;

    /**ChenQi 2019/4/28; 发起者主键*/
    private Integer createId;

    /**ChenQi 2019/4/28; 产品名称*/
    private String name;

    /**ChenQi 2019/4/27; 图片url,如果多个用','分隔，例如1,2,4*/
    private String img;

    /**ChenQi 2019/4/27; 所属品牌id*/
    private Integer brandId;

    /**ChenQi 2019/4/27; 所属品牌名称*/
    private String brandName;

    /**ChenQi 2019/4/27; 公司id*/
    private Integer companyId;

    /**ChenQi 2019/4/27; 公司名称*/
    private String companyName;

    /**ChenQi 2019/4/28; 状态0.已删除1.正常*/
    private Integer state;

    /**ChenQi 2019/4/28; 审核状态0.失败1.通过2.待审*/
    private Integer audit;

    /**ChenQi 2019/4/28; 审核人主键*/
    private Integer auditorId;

    /**ChenQi 2019/4/28; 审核操作类型：1.后台2.微信*/
    private Integer auditType;

    /**ChenQi 2019/4/27; 省份编码*/
    private String provinceCode;

    /**ChenQi 2019/4/28; 省份名称*/
    private String provinceName;

    /**ChenQi 2019/4/27; 城市编码*/
    private String cityCode;

    /**ChenQi 2019/4/28; 城市名称*/
    private String cityName;

    /**ChenQi 2019/4/28; 详细地址*/
    private String address;

    /**ChenQi 2019/4/28; 创建时间*/
    private Date createdate;

    /**ChenQi 2019/4/28; 产品内容*/
    private String content;

    /**ChenQi 2019/4/27; 主键集合，用于行业条件查询*/
    private List<Integer> ids;

}