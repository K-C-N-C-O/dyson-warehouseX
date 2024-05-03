package com.dyson.model.dto.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "请求参数实体类")
public class SysUserDto {

    @Schema(description = "搜索关键字")
    private String keyword ;

}
