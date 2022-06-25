package com.example.seckill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.seckill.entity.Product;
import com.example.seckill.mapper.ProductMapper;
import com.example.seckill.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qhh
 * @since 2022-06-06
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> selectAllProduct() {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("seckill_time");
        List<Product> productList = productMapper.selectList(queryWrapper);
        return productList;
    }

    @Override
    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }
}
