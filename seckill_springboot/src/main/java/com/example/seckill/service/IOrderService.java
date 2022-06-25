
package com.example.seckill.service;

import com.example.seckill.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.entity.vo.OrderVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qhh
 * @since 2022-06-04
 */
public interface IOrderService extends IService<Order> {

    Order getOrder(Integer userId, Integer productId);

    void seckill(Integer userId, Integer productId);

    List<OrderVo> getAllOrderByUserId(Integer userId);

    List<OrderVo> getAllOrder();

    List<OrderVo> getOrderByName(String name);
}
