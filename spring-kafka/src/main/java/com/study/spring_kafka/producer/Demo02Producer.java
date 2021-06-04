package com.study.spring_kafka.producer;

import javax.annotation.Resource;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.study.spring_kafka.message.Demo02Message;

@Component
public class Demo02Producer {

    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    public ListenableFuture<SendResult<Object, Object>> asyncSend(Integer id) {
        // 创建 Demo02Message 消息
        Demo02Message message = new Demo02Message();
        message.setId(id);
        // 异步发送消息
        return kafkaTemplate.send(Demo02Message.TOPIC, message);
    }
}
