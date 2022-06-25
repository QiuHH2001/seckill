package com.example.seckill.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：qhh
 * @date ：Created in 2022/5/31 14:12
 */
@RestController
@Api(value = "TestController", tags = {"测试管理"})
public class TestController {

//    @Autowired
//    private ProductMapper productMapper;
//
//    @ApiOperation(value = "测试一下")
//    @GetMapping("/")
//    public String test(){
//        return "test";
//    }
//
//    @ApiOperation(value = "获取所有产品")
//    @GetMapping("/product")
//    public List<Product> getAll(){
//        List<Product> productList = productMapper.findAll();
//        return productList;
//    }
}
