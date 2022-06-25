package com.example.seckill.service;

import com.example.seckill.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qhh
 * @since 2022-06-02
 */
public interface ICustomerService extends IService<Customer> {

    Customer getByIdentity(String identity);
}
