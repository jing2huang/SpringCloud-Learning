package com.study.spring_kafka.producer;

import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import com.study.spring_kafka.message.Demo04Message;

@Component
public class Demo04Producer {

    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @SuppressWarnings("rawtypes")
	public SendResult syncSend(Integer id) throws InterruptedException, ExecutionException {
        // 创建 Demo04Message 消息
        Demo04Message message = new Demo04Message();
        message.setId(id);
        // 异步发送消息
        return kafkaTemplate.send(Demo04Message.TOPIC, message).get();
    }
}
