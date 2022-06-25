package com.example.seckill.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author ：qhh
 * @date ：Created in 2022/6/6 23:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVo {

    private String name;

    private Integer quantity;

    private Integer price;

    @JsonFormat(pattern = "yy-MM-dd HH:mm:ss")
    private LocalDateTime seckillTime;

}
