package com.study.spring_kafka_broadcast.producer;

import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import com.study.spring_kafka_broadcast.message.Demo05Message;


@Component
public class Demo05Producer {

    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @SuppressWarnings("rawtypes")
	public SendResult syncSend(Integer id) throws InterruptedException, ExecutionException {
        // 创建 Demo05Message 消息
        Demo05Message message = new Demo05Message();
        message.setId(id);
        // 异步发送消息
        return kafkaTemplate.send(Demo05Message.TOPIC, message).get();
    }
}
