package com.pri.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName:      ErrorMessage
 * @Description:    全局异常捕捉实体类
 *                  实体用于记录具体的 异常信息，并响应 客户端
 * @Author:         ChenQi
 * @CreateDate:     2019/4/25 19:51
 */
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ErrorMessage<T> {
    // 状态码(1.正常  0.异常)
    public static final Integer OK = 1;
    public static final Integer ERROR = 0;

    // 状态码(1.正常  0.异常)
    private Integer code;
    // ChenQi 2019/4/25;  异常信息
    private String msg;
    // ChenQi 2019/4/25;  记录异常所在的方法
    private String url;
    // ChenQi 2019/4/25; 异常主体
    private T data;
}