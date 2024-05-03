package com.dyson.warehouseX.manager.mapper;


import com.dyson.model.dto.product.ProductDto;
import com.dyson.model.entity.order.OrderStatistics;
import com.dyson.model.entity.product.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    //列表分页查询
    List<Product> findByPage(ProductDto productDto);

    void save(Product product);

    Product findProductById(Long id);

    void updateById(Product product);

    void deleteById(Long id);

    OrderStatistics selectOrderStatistics(String createTime);
}
