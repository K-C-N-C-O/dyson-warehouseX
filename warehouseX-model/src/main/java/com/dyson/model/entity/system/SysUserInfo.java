package com.dyson.model.entity.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @program: dyson-warehouse-dev
 * @description:
 * @author: KCNCO
 **/
@Data
public class SysUserInfo {
    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "职位")
    private String role;

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "手机号码")
    private String phone;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "状态（1：正常 0：停用）")
    private Integer status;
}
