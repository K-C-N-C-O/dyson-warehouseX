package com.dyson.warehouseX.manager.service.impl;

import cn.hutool.core.date.DateUtil;
import com.dyson.model.dto.order.OrderStatisticsDto;
import com.dyson.model.entity.order.OrderStatistics;
import com.dyson.model.vo.order.OrderStatisticsVo;
import com.dyson.warehouseX.manager.mapper.OrderStatisticsMapper;
import com.dyson.warehouseX.manager.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderStatisticsMapper orderStatisticsMapper ;

    @Override
    public OrderStatisticsVo getOrderStatisticsData(OrderStatisticsDto orderStatisticsDto) {

        // 查询统计结果数据
        List<OrderStatistics> orderStatisticsList = orderStatisticsMapper.selectList(orderStatisticsDto) ;

        //日期列表
        List<String> dateList = orderStatisticsList.stream().map(orderStatistics -> DateUtil.format(orderStatistics.getOrderDate(), "yyyy-MM-dd")).collect(Collectors.toList());

        //统计总数列表
        List<Integer> totalNumList = orderStatisticsList.stream().map(OrderStatistics::getTotalNum).collect(Collectors.toList());

        // 创建OrderStatisticsVo对象封装响应结果数据
        OrderStatisticsVo orderStatisticsVo = new OrderStatisticsVo() ;
        orderStatisticsVo.setDateList(dateList);
        orderStatisticsVo.setTotalNumList(totalNumList);

        // 返回数据
        return orderStatisticsVo;
    }
}
