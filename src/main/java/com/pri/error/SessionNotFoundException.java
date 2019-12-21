package com.pri.error;

import lombok.Getter;
import lombok.Setter;
 /**
  * @ClassName:      SessionNotFoundException
  * @Description:    全局异常类：会话找不到
  * @Author:         ChenQi
  * @CreateDate:     2019/4/25 19:53
  */
public class SessionNotFoundException extends Exception {
    @Getter
    @Setter
    protected String message;

    public SessionNotFoundException() {
        setMessage("Session is not found!");
    }

    public SessionNotFoundException(String message) {
        this.message = message;
    }
}