package com.pri.entity;

import lombok.Data;

import java.util.Date;

 /**
  * @ClassName:      ActivitysJoinsInfo
  * @Description:    用户-活动关系实体类
  * @author:         ChenQi
  * @CreateDate:     2019/4/27 10:53
  */
@Data
public class ActivitysJoinsInfo {
    private Integer id;

    private Integer activityId;

    private Integer joinerId;

    private Integer audit;

    private Integer auditType;

    private Integer auditorId;

    private Date createdate;

}