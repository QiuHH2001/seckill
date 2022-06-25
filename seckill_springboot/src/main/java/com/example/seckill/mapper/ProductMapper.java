package com.example.seckill.mapper;

import com.example.seckill.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qhh
 * @since 2022-06-06
 */
public interface ProductMapper extends BaseMapper<Product> {
    void addProduct(Product product);
}
