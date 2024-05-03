package com.dyson.model.vo.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderStatisticsVo {
    private List<String> dateList ;
    private List<Integer> totalNumList ;
}
