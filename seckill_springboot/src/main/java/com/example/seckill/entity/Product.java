package com.example.seckill.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author qhh
 * @since 2022-06-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Product对象", description = "")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String img;

    private Integer quantity;

    private Integer price;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime seckillTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

}
