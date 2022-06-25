# 基于SpringBoot+Mybatis-Plus+Redis的秒杀系统

*借鉴：https://www.bilibili.com/video/BV1sf4y1L7KE?spm_id_from=333.880.my_history.page.click&vd_source=deb173f87dd59e1442832df706e513c6*



## 开发工具

IntelliJ IDEA 2021 2.2

Visual Studio Code



## 开发环境

| JDK  | Maven | Mysql | SpringBoot | redis |
| ---- | ----- | ----- | ---------- | ----- |
| 1.8  | 3.6.3 | 5.5   | 2.6.4      | 6.2.1 |



## 项目启动说明

1、启动前，请配置 application.properties 中相关MySQL、redis地址。

2、用户端登录地址：http://localhost:8080/login

3、管理员端地址：http://localhost:8081/

4、前端启动命令：

```shell
npm run serve
```



## 目录介绍

### 后端-seckill_springboot

- config

```
-JwtInterceptor
-CorsConfig
-InterceptorConfig
-RedisConfig
-SwaggerConfig
```

- controller

```
-AdminController
-CustomerController
-OrderController
-ProductController
-UserController
```

- entity

```
-Admin
-Order
-product
-User
	-VO
		-AdminVo
		-OrderVo
		-ProductVo
		-RespBean
		-RespBeanEnum
		-UserVo
```

- exception

```
-GlobalException
-GlobalExceptionHandler
```

- mapper

```
-AdminMapper
-CustomerMapper
-OrderMapper
-ProductMapper
-UserMapper
```

- service

```
-IAdminService
-ICustomerService
-IOrderService
-IProductService
-IUserService
```

- utils

```
-Generator
-TokenUtil
-UserUitl
```



## 其他说明

### Jmeter压测配置说明

csv数据文件配置

![image-20220610154125171](../../Typroa_images/image-20220610154125171.png)



接口配置和参数设置：

![image-20220610154203851](../../Typroa_images/image-20220610154203851.png)