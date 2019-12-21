package com.pri.entity;

import lombok.Data;

import java.util.Date;

@Data
public class WxUser {
    /**ChenQi 2019/4/28; 小程序用户主键*/
    private Integer id;

    /**ChenQi 2019/4/28; 小程序openid*/
    private String openid;

    /**ChenQi 2019/4/28; 平台id*/
    private String nid;

    /**ChenQi 2019/4/28; 昵称*/
    private String nickname;

    /**ChenQi 2019/4/28; 性别(1男，2女)*/
    private Integer sex;

    /**ChenQi 2019/4/28; 头像*/
    private String headimgurl;

    /**ChenQi 2019/4/28; 状态0.禁用1.正常*/
    private Integer state;

    /**ChenQi 2019/4/28; 创建时间*/
    private Date createdate;

}