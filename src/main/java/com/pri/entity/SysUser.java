package com.pri.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

 /**
  * @ClassName:      SysUser
  * @Description:    系统用户实体类
  * @Author:         ChenQi
  * @CreateDate:     2019/4/25 20:40
  */
@Data
public class SysUser implements Serializable{
    private Long id;

    private String nid;

    private String username;

    private String nickname;

    private String password;

    private String salt;

    private Long deptId;

    private String picture;

    private String sex;

    private String email;

    private String phone;

    private String remark;

    private Date createDate;

    private Date updateDate;

    private Byte status;

}