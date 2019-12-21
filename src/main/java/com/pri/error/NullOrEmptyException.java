package com.pri.error;

import lombok.Getter;
import lombok.Setter;
 /**
  * @ClassName:      NullOrEmptyException
  * @Description:    全局异常类：参数异常
  * @Author:         ChenQi
  * @CreateDate:     2019/4/25 19:54
  */
public class NullOrEmptyException extends Exception {
    @Getter
    @Setter
    protected String message;

    public NullOrEmptyException() {
        setMessage("Parameter is null or empty!");
    }

    public NullOrEmptyException(String message) {
        this.message = message;
    }
}