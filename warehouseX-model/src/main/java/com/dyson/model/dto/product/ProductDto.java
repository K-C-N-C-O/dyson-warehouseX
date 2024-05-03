package com.dyson.model.dto.product;

import com.dyson.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema
public class ProductDto  {

    private String name;

    private Long orderId;

    private Integer status;

    private Integer auditStatus;

    private Long categoryId;

    private Date createTime;


}