package com.example.seckill.controller;

import cn.hutool.core.util.StrUtil;
import com.example.seckill.entity.Admin;
import com.example.seckill.entity.Product;
import com.example.seckill.entity.User;
import com.example.seckill.entity.vo.AdminVo;
import com.example.seckill.entity.vo.OrderVo;
import com.example.seckill.entity.vo.RespBean;
import com.example.seckill.entity.vo.RespBeanEnum;
import com.example.seckill.service.IAdminService;
import com.example.seckill.service.IOrderService;
import com.example.seckill.service.IProductService;
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
 * @since 2022-06-07
 */
@RestController
@RequestMapping("/admin")
@Api(value = "AdminController", tags = {"管理员管理"})
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IOrderService orderService;

    @ApiOperation(value = "管理员登录")
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminVo adminVo){
        if (StrUtil.isBlank((adminVo.getName())) || StrUtil.isBlank(adminVo.getPassword())){
            return RespBean.error(RespBeanEnum.BIND_ERROR);
        }
        AdminVo result = new AdminVo();
        try {
            result =  adminService.login(adminVo);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (result.getToken() == null){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        return RespBean.success(result);
    }

    @GetMapping("/product")
    @ApiOperation(value = "获取所有产品")
    public RespBean selectAllProduct(){
        List<Product> productList = productService.selectAllProduct();
        return RespBean.success(productList);
    }

    @GetMapping("/order")
    @ApiOperation(value = "获取所有订单")
    public RespBean getAllOrder(){
        List<OrderVo>  orderVoList = orderService.getAllOrder();
        return RespBean.success(orderVoList);
    }

    @GetMapping("/{name}")
    @ApiOperation(value = "根据产品名获取订单")
    public RespBean getOrderByName(@PathVariable("name") String name){
        List<OrderVo> orderVoList = orderService.getOrderByName(name);
        return RespBean.success(orderVoList);
    }

}
