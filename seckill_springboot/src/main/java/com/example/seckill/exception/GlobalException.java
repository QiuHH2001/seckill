package com.example.seckill.exception;

import com.example.seckill.entity.vo.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：qhh
 * @date ：Created in 2022/3/25 18:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalException extends RuntimeException{
    private RespBeanEnum respBeanEnum;
}
