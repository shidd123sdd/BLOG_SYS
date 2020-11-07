package cn.siwuya.blogsys.common;

import cn.siwuya.blogsys.vo.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shi_dd
 * @date 2020/7/11 0:56
 */
/**全局异常处理类*/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonResult doHandleRuntimeException(
            RuntimeException e){
        e.printStackTrace();//也可以写日志
        log.info(e.getMessage());
        return new JsonResult(e);//封装异常信息
    }
}
