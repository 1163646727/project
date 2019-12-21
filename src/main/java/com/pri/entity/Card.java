package com.pri.entity;

import lombok.Data;

import java.util.Date;

/**
 * class name:Card <BR>
 * class description: 名片实体类 <BR>
 * Remark: <BR>
 * @version 1.00 2019年4月24日
 * @author )chenqi
 */
@Data
public class Card {
    private Integer id;

    private Integer userId;

    private String nid;

    private String name;

    private String email;

    private String mobile;

    private String phone;

    private Integer role;

    private Integer companyId;

    private String company;

    private String position;

    private String address;

    private String industryId;

    private Integer industry;

    private Integer def;

    private Date createdate;


}