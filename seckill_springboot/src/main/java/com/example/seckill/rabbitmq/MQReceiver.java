//package com.example.seckill.rabbitmq;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//
///**
// * @author ：qhh
// * @date ：Created in 2022/6/8 22:36
// */
//@Service
//@Slf4j
//public class MQReceiver {
//
//    @RabbitListener(queues = "queue")
//    public void receive(Object msg){
//        log.info("接收消息：" + msg);
//    }
//}
