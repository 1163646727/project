package com.pri.error;

import com.pri.entity.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

 /**
  * @ClassName:      GlobalExceptionHandler
  * @Description:    全局异常通知类
  *                    指定了 3 个 特定 的异常处理器和 1 个 默认 的异常处理器。
  *                    当请求处理出现异常时，会根据 异常处理器的配置顺序依次尝试异常匹配和处理。
  *                    当异常不在 SessionNotFoundException、NullOrEmptyException、IllegalPropertiesException 中时，
  *                    Spring 会委托 默认 的 exceptionHandler 进行处理。
  *                    小结:使用 @ControllerAdvice 处理异常也有一定的 局限性。只有进入 Controller 层的错误，才会由 @ControllerAdvice 处理。
  *                    拦截器抛出的错误以及访问错误地址的情况@ControllerAdvice 处理不了，由Spring Boot默认的异常处理机制 处理。
  * @Author:         ChenQi
  * @CreateDate:     2019/4/25 19:56
  */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

     //记得加上这个哇，这是告诉全世界，你要开始在这类里面使用日志
     protected static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


     @ExceptionHandler(SessionNotFoundException.class)
    @ResponseBody
    public ErrorMessage<String> sessionNotFoundExceptionHandler(HttpServletRequest request, SessionNotFoundException exception) throws Exception {
        return handleErrorInfo(request, exception.getMessage(), exception);
    }

    @ExceptionHandler(NullOrEmptyException.class)
    @ResponseBody
    public ErrorMessage<String> nullOrEmptyExceptionHandler(HttpServletRequest request, NullOrEmptyException exception) throws Exception {
        return handleErrorInfo(request, exception.getMessage(), exception);
    }

    @ExceptionHandler(IllegalPropertiesException.class)
    @ResponseBody
    public ErrorMessage<String> illegalPropExceptionHandler(HttpServletRequest request, IllegalPropertiesException exception) throws Exception {
        return handleErrorInfo(request, exception.getMessage(), exception);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorMessage<String> exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
        return handleErrorInfo(request, exception.getMessage(), exception);
    }

    private ErrorMessage<String> handleErrorInfo(HttpServletRequest request, String message, Exception exception) {
        ErrorMessage<String> errorMessage = new ErrorMessage<>();
        errorMessage.setMsg(message);
        errorMessage.setCode(ErrorMessage.ERROR);
        errorMessage.setData(message);
        errorMessage.setUrl(request.getRequestURL().toString());
        log.error(errorMessage.toString());
        return errorMessage;
    }
}