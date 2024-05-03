package com.dyson.model.entity.order;

import com.dyson.model.entity.base.BaseEntity;
import lombok.Data;
import java.util.Date;

@Data
public class OrderStatistics extends BaseEntity {

    private Date orderDate;
    private Integer totalNum;

}
