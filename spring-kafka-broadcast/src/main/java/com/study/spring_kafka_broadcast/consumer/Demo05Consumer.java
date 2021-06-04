package com.study.spring_kafka_broadcast.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.study.spring_kafka_broadcast.message.Demo05Message;


@Component
public class Demo05Consumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @KafkaListener(topics = Demo05Message.TOPIC,
            groupId = "demo05-consumer-group-" + Demo05Message.TOPIC  + "-" + "#{T(java.util.UUID).randomUUID()}")
    public void onMessage(Demo05Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
