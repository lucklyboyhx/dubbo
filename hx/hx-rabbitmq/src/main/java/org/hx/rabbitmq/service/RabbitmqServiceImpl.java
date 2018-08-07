package org.hx.rabbitmq.service;



import org.hx.common.service.service.rabbitmq.RabbitmqService;
import org.hx.rabbitmq.Rabbitmq;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class RabbitmqServiceImpl implements RabbitmqService{

    @Autowired
    private Rabbitmq rabbitmq;
    @Override
    public void send(String topic, String message) {
        rabbitmq.send(topic, message);
    }

}
