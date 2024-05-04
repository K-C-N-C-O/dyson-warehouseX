package com.dyson.model.entity.product;

import com.dyson.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "商品实体类")
public class Product extends BaseEntity {

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

	@Schema(description = "线上状态：0-初始值，1-上架，-1-自主下架")
	private Integer status;					// 线上状态：0-初始值，1-上架，-1-自主下架

	@Schema(description = "审核状态")
	private Integer auditStatus;			// 审核状态

	@Schema(description = "审核信息")
	private String auditMessage;			// 审核信息

	@Schema(description = "序列号")
	private String serialId;         //序列号

	private String postcode;

	//扩展属性
	private String categoryName;


}