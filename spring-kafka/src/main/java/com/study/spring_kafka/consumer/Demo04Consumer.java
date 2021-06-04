package com.study.spring_kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.study.spring_kafka.message.Demo04Message;


@Component
public class Demo04Consumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @KafkaListener(topics = Demo04Message.TOPIC,
            groupId = "demo04-consumer-group-" + Demo04Message.TOPIC)
    public void onMessage(Demo04Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
        throw new RuntimeException("故意抛异常...");
    }
}
