package com.study.spring_kafka_broadcast.message;

public class Demo05Message {

    public static final String TOPIC = "DEMO_05";
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
