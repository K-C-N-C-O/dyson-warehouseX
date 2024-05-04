package com.dyson.model.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "商品实体类")
public class ProductInfoDto {
    @Schema(description = "商品名称")
    private String name;					// 商品名称

    @Schema(description = "一级分类id")
    private Long categoryId;				// 一级分类id

    @Schema(description = "轮播图url")
    private String sliderUrls;				// 轮播图

    @Schema(description = "订单id")
    private Long orderId;               //订单ID

    @Schema(description = "存放位置")
    private String storeLocation;				// 存放位置

    private String postcode;

}
