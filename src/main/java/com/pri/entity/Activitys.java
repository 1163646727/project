package com.pri.entity;

import lombok.Data;
import java.util.Date;
 /**
  * @ClassName:      Activitys
  * @Description:    活动实体类
  * @author:         ChenQi
  * @CreateDate:     2019/4/27 10:53
  */
@Data
public class Activitys {
    /**ChenQi 2019/4/28; 活动主键*/
    private Integer id;

    /**ChenQi 2019/4/28; 平台id*/
    private String nid;

    /**ChenQi 2019/4/28; 发起者*/
    private Integer ownerId;

    /**ChenQi 2019/4/28; 主题*/
    private String topic;

    /**ChenQi 2019/4/28; 图片url,如果多个用','分隔，例如1,2,4*/
    private String img;

    /**ChenQi 2019/4/28; 开始时间*/
    private Date startDate;

    /**ChenQi 2019/4/28; 结束时间*/
    private Date endDate;

    /**ChenQi 2019/4/28; 活动名额*/
    private Integer maxNum;

    /**ChenQi 2019/4/28; 主办方(公司)id*/
    private Integer companyId;

    /**ChenQi 2019/4/28; 主办方(公司)名称*/
    private String companyName;

    /**ChenQi 2019/4/28; 状态1.正常0.已删除*/
    private Integer state;

    /**ChenQi 2019/4/28; 审核状态0.失败1.通过2.待审*/
    private Integer audit;

    /**ChenQi 2019/4/28; 审核状态0.失败1.通过2.待审*/
    private Integer auditType;

    /**ChenQi 2019/4/28; 审核人主键*/
    private Integer auditorId;

    /**ChenQi 2019/4/28; 省份编码*/
    private String provinceCode;

    /**ChenQi 2019/4/28; 省份名称*/
    private String provinceName;

    /**ChenQi 2019/4/28; 城市编码*/
    private String cityCode;

    /**ChenQi 2019/4/28; 城市名称*/
    private String cityName;

    /**ChenQi 2019/4/28; 活动地点*/
    private String address;

    /**ChenQi 2019/4/28; 创建时间*/
    private Date createdate;

    /**ChenQi 2019/4/28; 活动介绍*/
    private String content;

 }