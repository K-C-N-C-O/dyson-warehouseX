package com.dyson.warehouseX.manager.mapper;


import com.dyson.model.dto.order.OrderStatisticsDto;
import com.dyson.model.entity.order.OrderStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderStatisticsMapper {

    void insert(OrderStatistics orderStatistics);

    List<OrderStatistics> selectList(OrderStatisticsDto orderStatisticsDto);
}
