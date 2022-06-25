package com.example.seckill.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：qhh
 * @date ：Created in 2022/3/25 13:59
 * 公共返回对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private Long code;
    private String message;
    private Object data;

    public static RespBean success(){
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMessage(), null);
    }

    public static RespBean success(Object data){
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMessage(), data);
    }

    public static RespBean error(RespBeanEnum respBeanEnum){
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), null);
    }

    public static RespBean error(RespBeanEnum respBeanEnum, Object data){
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), data);
    }
}
