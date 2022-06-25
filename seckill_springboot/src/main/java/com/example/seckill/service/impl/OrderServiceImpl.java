package com.example.seckill.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.seckill.entity.Order;
import com.example.seckill.entity.Product;
import com.example.seckill.entity.User;
import com.example.seckill.entity.vo.OrderVo;
import com.example.seckill.mapper.OrderMapper;
import com.example.seckill.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seckill.service.IProductService;
import com.example.seckill.service.IUserService;
import com.fasterxml.jackson.databind.BeanProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qhh
 * @since 2022-06-04
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private IProductService productService;

    @Resource
    private OrderMapper orderMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IUserService userService;

    @Override
    public Order getOrder(Integer userId, Integer productId) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId)
                .eq("product_id", productId);
        Order order = orderMapper.selectOne(queryWrapper);
        return order;
    }

    @Override
    @Transactional
    public void seckill(Integer userId, Integer productId) {
//        更新库存
        Product product = productService.getById(productId);
        product.setQuantity(product.getQuantity() - 1);
        Boolean result = productService.update(new UpdateWrapper<Product>().setSql("quantity = quantity - 1")
                .eq("id", productId).gt("quantity", 0));
        if (!result){
            return;
        }
//        生成订单
        Order order = new Order();
        order.setUserId(userId);
        order.setProductId(productId);
        order.setQuantity(1);
        order.setPrice(product.getPrice());
        order.setTime(LocalDateTime.now());
        orderMapper.insert(order);
        redisTemplate.opsForValue().set("order:" + userId + ":" + productId, order);
    }

    @Override
    public List<OrderVo> getAllOrderByUserId(Integer userId) {
        List<OrderVo> orderVoList = orderMapper.getAllOrderByUserId(userId);
        return orderVoList;

//        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("user_id", userId);
//        List<Order> orderList = orderMapper.selectList(queryWrapper);
//        User user = userService.getById(userId);
//
//        List<OrderVo> orderVoList = new ArrayList<>(orderList.size());
//        for (int i = 0; i < orderList.size(); i++) {
//            BeanUtil.copyProperties(orderList.get(i), orderVoList.get(i), true);
//            orderVoList.get(i).setUsername(user.getName());
//        }
    }

    @Override
    public List<OrderVo> getAllOrder() {
        List<OrderVo> orderVoList = orderMapper.getAllOrder();
        return orderVoList;
    }

    @Override
    public List<OrderVo> getOrderByName(String name) {
        List<OrderVo> orderVoList = orderMapper.getOrderByName(name);
        return orderVoList;
    }
}
