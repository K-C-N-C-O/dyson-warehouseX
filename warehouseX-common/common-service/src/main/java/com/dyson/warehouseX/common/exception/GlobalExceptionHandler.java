package com.dyson.warehouseX.common.exception;

import com.dyson.model.vo.common.Result;
import com.dyson.model.vo.common.ResultCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    //全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(){
        return Result.build(null, ResultCodeEnum.SYSTEM_ERROR);
    }

    //自定义异常处理

    @ExceptionHandler(PException.class)
    @ResponseBody
    public Result error(PException e){
        return Result.build(null, e.getResultCodeEnum());
    }


}
