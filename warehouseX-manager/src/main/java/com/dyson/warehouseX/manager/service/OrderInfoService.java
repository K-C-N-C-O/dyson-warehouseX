package com.dyson.warehouseX.manager.service;

import com.dyson.model.dto.order.OrderStatisticsDto;
import com.dyson.model.vo.order.OrderStatisticsVo;

public interface OrderInfoService {
    OrderStatisticsVo getOrderStatisticsData(OrderStatisticsDto orderStatisticsDto);
}
