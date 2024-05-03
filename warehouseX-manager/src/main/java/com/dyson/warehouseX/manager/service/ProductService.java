package com.dyson.warehouseX.manager.service;

import com.dyson.model.dto.product.ProductDto;
import com.dyson.model.dto.product.ProductInfoDto;
import com.dyson.model.entity.product.Product;
import com.github.pagehelper.PageInfo;

public interface ProductService {
    PageInfo<Product> findByPage(Integer page, Integer limit, ProductDto productDto);

    void save(ProductInfoDto productInfoDto);

    Product getById(Long id);

    void update(Product product);

    void deleteById(Long id);

    void updateAuditStatus(Long id, Integer auditStatus);

    void updateStatus(Long id, Integer status);
}
