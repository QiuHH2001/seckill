package com.example.seckill.service;

import com.example.seckill.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qhh
 * @since 2022-06-06
 */
public interface IProductService extends IService<Product> {
    List<Product> selectAllProduct();

    void addProduct(Product product);
}
