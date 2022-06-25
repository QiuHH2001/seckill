//package com.example.seckill.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Service;
//
///**
// * @author ：qhh
// * @date ：Created in 2022/6/8 22:44
// */
//@Configuration
//public class RabbitMQTopicConfig {
//    private static final String QUEUE01 = "queue_topic01";
//    private static final String QUEUE02 = "queue_topic02";
//    private static final String EXCHANGE = "topicExchange";
//    private static final String ROUTINGKEY01 = "#.queue.#";
//    private static final String ROUTINGKEY02 = "*.queue.#";
//
//    @Bean
//    public Queue queue01(){
//        return new Queue(QUEUE01);
//    }
//
//    @Bean
//    public Queue queue02(){
//        return new Queue(QUEUE02);
//    }
//
//    @Bean
//    public TopicExchange topicExchange(){
//        return new TopicExchange(EXCHANGE);
//    }
//    @Bean
//    public Binding binding01(){
//        return
//                BindingBuilder.bind(queue01()).to(topicExchange()).with(ROUTINGKEY01);
//    }
//    @Bean
//    public Binding binding02(){
//        return
//                BindingBuilder.bind(queue02()).to(topicExchange()).with(ROUTINGKEY02);
//    }
//}
