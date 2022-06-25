package com.example.seckill.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.example.seckill.entity.Order;
import com.example.seckill.entity.Product;
import com.example.seckill.entity.User;
import com.example.seckill.entity.vo.ProductVo;
import com.example.seckill.entity.vo.RespBean;
import com.example.seckill.entity.vo.RespBeanEnum;
import com.example.seckill.service.IOrderService;
import com.example.seckill.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qhh
 * @since 2022-06-06
 */
@RestController
@RequestMapping("/product")
@Api(value = "ProductController", tags = {"产品管理"})
@Slf4j
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("")
    @ApiOperation(value = "获取所有产品")
    public RespBean selectAllProduct(){
        List<Product> productList = productService.selectAllProduct();

//        User currentUser = TokenUtil.getCurrentUser();
//        System.out.println(currentUser.getName());
        return RespBean.success(productList);
    }

    @PostMapping("/add")
    @ApiOperation(value = "增加产品")
    public RespBean addProduct(@RequestBody Product product){
        productService.save(product);
        System.out.println("2345678");
        return RespBean.success();
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除产品")
    public RespBean delete(@RequestBody Product product){
        productService.removeById(product.getId());
        return RespBean.success();
    }

    @PostMapping("/seckill")
    @ApiOperation(value = "秒杀产品")
    public RespBean seckill(@RequestBody Order orderForm){
        Integer userId = orderForm.getUserId();
        Integer productId = orderForm.getProductId();
        Product product = productService.getById(productId);
        if (product.getQuantity() < 1){
            return RespBean.error(RespBeanEnum.EMPTY_STOCK);
        }
//        查询同一用户是否抢购同一商品
//        Order order = orderService.getOrder(userId, productId);

//        从redis中查询订单
        Order order = (Order) redisTemplate.opsForValue().get("order:" + userId + ":" + productId);
        if (order == null){
            order = orderService.getOrder(userId, productId);
        }
        if (order != null){
            return RespBean.error(RespBeanEnum.REPEAT_ERROR);
        }
        try{
            orderService.seckill(userId, productId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return RespBean.success();
    }

    @PostMapping("/seckillTest")
    @ApiOperation(value = "秒杀产品测试")
    public RespBean seckillTest(@RequestParam Integer userId,
                                @RequestParam Integer productId){
        System.out.println(userId + " " + productId);
        Product product = productService.getById(productId);
        if (product.getQuantity() < 1){
            return RespBean.error(RespBeanEnum.EMPTY_STOCK);
        }
//        查询同一用户是否抢购同一商品
//        Order order = orderService.getOrder(userId, productId);

//        从redis中查询订单
        Order order = (Order) redisTemplate.opsForValue().get("order:" + userId + ":" + productId);
        if (order == null){
            order = orderService.getOrder(userId, productId);
        }
        if (order != null){
            return RespBean.error(RespBeanEnum.REPEAT_ERROR);
        }
        try{
            orderService.seckill(userId, productId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return RespBean.success();


    }

}
