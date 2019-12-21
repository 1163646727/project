package com.pri.entity;

import lombok.Data;

/**
 * @ClassName: ResultVo
 * @Description: 用户封装返回结果的实体类
 * @Auther: Chenqi
 * @Date: 2019/4/23 18:10
 * @Version 1.0 jdk1.8
 */
@Data
public class ResultVo<T> {
    /**ChenQi 2019/4/26; 状态码(1.正常  0.异常)*/
    private Integer code;
    /**ChenQi 2019/4/26; 提示信息*/
    private String msg;
    /**ChenQi 2019/4/26; 响应数据*/
    private T data;
}
