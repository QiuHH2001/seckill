package com.example.seckill.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author ：qhh
 * @date ：Created in 2022/6/6 10:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVo {
    private Integer id;
    private Integer userId;
    private String username;
    private String name;
    private Integer quantity;
    private Integer price;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime time;
}
