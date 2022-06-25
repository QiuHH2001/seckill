package com.example.seckill.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author ：qhh
 * @date ：Created in 2022/3/25 14:00
 * 公共返回对象枚举
 */
@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {
//    通用
    SUCCESS(200, "SUCCESS"),
    ERROR(500, "服务端异常"),
//    注册
    REGISTER_ERROR(500110, "该用户已存在"),
//    登录
    LOST_TOKEN(500200, "无token，请重新登录"),
    TOKEN_ERROR(500201, "无token，请重新登录"),
    LOGIN_ERROR(500210, "用户名或密码错误"),
    MOBILE_ERROR(500211, "手机号码格式不正确"),
    BIND_ERROR(500212, "参数校验异常"),
    PASSWORD_UPDATE_FAIL(500213, "密码更新失败"),
    UPDATE_FAIL(500214, "个人信息修改失败"),
    QUALIFIED_FAIL(500215,"对不起，您的信用度不够，无法参与秒杀活动"),
//    秒杀模块
    EMPTY_STOCK(500500, "库存不足，秒杀失败"),
    REPEAT_ERROR(500501, "该商品每人限购一件");
    private final long code;
    private final String message;
}
