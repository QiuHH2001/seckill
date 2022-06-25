package com.example.seckill.controller;

import com.example.seckill.entity.User;
import com.example.seckill.entity.vo.OrderVo;
import com.example.seckill.entity.vo.RespBean;
import com.example.seckill.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qhh
 * @since 2022-06-04
 */
@RestController
@RequestMapping("/order")
@Api(value = "OrderController", tags = {"订单管理"})
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/")
    @ApiOperation(value = "根据用户id获取订单")
    public RespBean getAllOrderByUserId(@RequestBody User user){
        List<OrderVo> orderVoList = orderService.getAllOrderByUserId(user.getId());
        return RespBean.success(orderVoList);
    }


}
