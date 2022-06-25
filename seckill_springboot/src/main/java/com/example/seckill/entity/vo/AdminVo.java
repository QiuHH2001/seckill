package com.example.seckill.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：qhh
 * @date ：Created in 2022/6/7 19:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminVo {
    private Integer id;

    private String name;

    private String password;

    private String token;
}
