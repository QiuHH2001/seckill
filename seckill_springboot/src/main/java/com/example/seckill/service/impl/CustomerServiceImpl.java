package com.example.seckill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.seckill.entity.Customer;
import com.example.seckill.mapper.CustomerMapper;
import com.example.seckill.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.management.Query;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qhh
 * @since 2022-06-02
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Customer getByIdentity(String identity) {
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("identity",identity);
        Customer customer = customerMapper.selectOne(queryWrapper);
        return customer;
    }
}
