package com.example.seckill.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author ：qhh
 * @date ：Created in 2022/5/31 20:54
 */
public class Generator {
    public static void main(String[] args) {
        generate();
    }

    public static void generate(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/seckill", "root", "root")
                .globalConfig(builder -> {
                    builder.author("qhh") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\Documents\\Project\\seckill\\seckill_springboot\\src\\main\\java\\"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.seckill") // 设置父包名
                            .moduleName("") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\Documents\\Project\\seckill\\seckill_springboot\\src\\main\\resources\\mapper\\")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_admin") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
