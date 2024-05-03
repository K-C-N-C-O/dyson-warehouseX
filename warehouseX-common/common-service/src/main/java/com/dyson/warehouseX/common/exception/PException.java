package com.dyson.warehouseX.common.exception;

import com.dyson.model.vo.common.ResultCodeEnum;
import lombok.Data;

@Data
public class PException extends RuntimeException{

    private  Integer code;
    private String message;

    private ResultCodeEnum resultCodeEnum;

    public  PException(ResultCodeEnum resultCodeEnum){
        this.resultCodeEnum=resultCodeEnum;
        this.code=resultCodeEnum.getCode();
        this.message=resultCodeEnum.getMessage();
    }



}
