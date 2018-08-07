package org.hx.common.service.service.rabbitmq;

public interface RabbitmqService {

    void send(String topic, String message);

}
