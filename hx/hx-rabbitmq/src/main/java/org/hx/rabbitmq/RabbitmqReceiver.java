package org.hx.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {RabbitConfig.FANOUT_A}) //消息消费的第二种方式
public class RabbitmqReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println(">>>>>>>>>>>>>>topicMessageReceiver  : " +msg);
    }

}
