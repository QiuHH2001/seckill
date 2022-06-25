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
 * @since 2022-06-02
 */
@ApiModel(value = "Customer对象", description = "")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private String identity;

    private Boolean employed;

    private Boolean trustworthy;

    @JsonFormat(pattern = "yy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
