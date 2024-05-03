package com.dyson.warehouseX.manager.service;

import com.dyson.model.entity.product.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findByParentId(Long parentId);
}
