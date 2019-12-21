package com.pri.error;

import lombok.Getter;
import lombok.Setter;
 /**
  * @ClassName:      IllegalPropertiesException
  * @Description:    全局异常类：
  * @Author:         ChenQi
  * @CreateDate:     2019/4/25 19:55
  */
public class IllegalPropertiesException extends Exception {
    @Getter
    @Setter
    protected String message;

    public IllegalPropertiesException() {
        setMessage("Prop is illegal!");
    }

    public IllegalPropertiesException(String message) {
        this.message = message;
        setMessage(String.format("Prop: %s is illegal!", message));
    }
}