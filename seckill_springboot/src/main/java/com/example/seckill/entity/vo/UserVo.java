package com.example.seckill.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：qhh
 * @date ：Created in 2022/6/3 23:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private Integer id;

    private String name;

    private String password;

    private String identity;

    private String token;
}
