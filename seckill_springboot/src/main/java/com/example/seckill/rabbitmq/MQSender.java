//package com.example.seckill.rabbitmq;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * @author ：qhh
// * @date ：Created in 2022/6/8 22:32
// */
//@Service
//@Slf4j
//public class MQSender {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    public void send(Object msg){
//        log.info("发送消息：" + msg);
//        rabbitTemplate.convertAndSend("queue", msg);
//    }
//}
