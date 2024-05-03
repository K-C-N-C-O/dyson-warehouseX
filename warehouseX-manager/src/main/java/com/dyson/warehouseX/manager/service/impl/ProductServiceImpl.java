package com.dyson.warehouseX.manager.service.impl;

import com.dyson.model.dto.product.ProductDto;
import com.dyson.model.dto.product.ProductInfoDto;
import com.dyson.model.entity.product.Product;
import com.dyson.warehouseX.manager.mapper.ProductMapper;
import com.dyson.warehouseX.manager.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public PageInfo<Product> findByPage(Integer page, Integer limit, ProductDto productDto) {
        PageHelper.startPage(page,limit);
        List<Product> list= productMapper.findByPage(productDto);
        return new PageInfo<>(list);
    }

    @Override
    public void save(ProductInfoDto productInfoDto) {
        Product product=new Product();
        String serialId= UUID.randomUUID().toString().replaceAll("-","");
        product.setName(productInfoDto.getName());
        product.setCategoryId(productInfoDto.getCategoryId());
        product.setStoreLocation(productInfoDto.getStoreLocation());
        product.setOrderId(productInfoDto.getOrderId());
        product.setSliderUrls(productInfoDto.getSliderUrls());
        product.setSerialId(serialId);
        product.setStatus(0);
        product.setAuditStatus(0);
        productMapper.save(product);
    }

    @Override
    public Product getById(Long id) {
        Product product=productMapper.findProductById(id);
        return product;

    }

    @Override
    public void update(Product product) {
        productMapper.updateById(product);
    }

    @Override
    public void deleteById(Long id) {
        productMapper.deleteById(id);
    }

    @Override
    public void updateAuditStatus(Long id, Integer auditStatus) {
        Product product = new Product();
        product.setId(id);
        if(auditStatus == 1) {
            product.setAuditStatus(1);
            product.setAuditMessage("审批通过");
        } else {
            product.setAuditStatus(-1);
            product.setAuditMessage("审批不通过");
        }
        productMapper.updateById(product);
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        Product product = new Product();
        product.setId(id);
        if(status == 1) {
            product.setStatus(1);
        } else {
            product.setStatus(2);
        }
        productMapper.updateById(product);
    }
}
