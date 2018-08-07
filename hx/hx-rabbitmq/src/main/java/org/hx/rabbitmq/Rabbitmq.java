package org.hx.rabbitmq;

import java.util.UUID;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Rabbitmq implements RabbitTemplate.ConfirmCallback{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String topic, String message) {
        rabbitTemplate.setConfirmCallback(this);

        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());

        System.out.println("消息id:" + correlationData.getId());

        //用RabbitMQ发送MQTT需将exchange配置为amq.topic

        this.rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, topic, message, correlationData);

    }

    public void confirm(CorrelationData correlationData, boolean ack, String cause) {

        System.out.println("confirm消息id:" + correlationData.getId());

        if (ack) {

            System.out.println("消息发送确认成功");

        } else {

            System.out.println("消息发送确认失败:" + cause);

        }

    }
    
    
    public void receive(String queueName) {
        Message message = rabbitTemplate.receive(queueName);
        System.out.println(message.toString());
    }
    
}
