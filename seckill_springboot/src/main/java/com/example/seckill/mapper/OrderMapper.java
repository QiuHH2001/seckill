package com.example.seckill.mapper;

import com.example.seckill.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.seckill.entity.vo.OrderVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qhh
 * @since 2022-06-04
 */
public interface OrderMapper extends BaseMapper<Order> {

    List<OrderVo> getAllOrderByUserId(Integer userId);

    List<OrderVo> getAllOrder();

    List<OrderVo> getOrderByName(String name);
}
