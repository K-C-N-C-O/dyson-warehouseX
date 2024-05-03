package com.dyson.warehouseX.manager.mapper;

import com.dyson.model.entity.product.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    public abstract List<Category> selectByParentId(Long parentId);
    public abstract int countByParentId(Long id);

}