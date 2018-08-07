package org.hx.controller.order;


import org.hx.common.service.entity.order.WholesaleOrder;
import org.hx.common.service.service.order.WholesaleOrderService;
import org.hx.common.service.service.rabbitmq.RabbitmqService;
import org.hx.common.service.service.redis.RedisService;
import org.hx.controller.annotation.LoginRequired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;


@RestController
@RequestMapping("/api")
public class OrderController {

    @Reference(version = "1.0.0")
    private WholesaleOrderService wholesaleOrderService;
    
    @RequestMapping(method = RequestMethod.POST, value = "/branch", consumes="application/json")
    public String list(@RequestBody Integer branchNum) {
        System.out.println(">>>>>>>>>>" + branchNum.toString());
        WholesaleOrder wholesaleOrder = wholesaleOrderService.read("WO10001");
        return wholesaleOrder.toString();
    }
    
    @Reference(version = "1.0.0")
    private RedisService redisService;
    
    @RequestMapping(method = RequestMethod.POST, value = "/redis", consumes="application/json")
    public String redis(@RequestBody Integer branchNum) {
        System.out.println(">>>>>>>>>>" + branchNum.toString());
        WholesaleOrder wholesaleOrder = wholesaleOrderService.read("WO10001");
        redisService.put("redis_wholesaleorder", wholesaleOrder, 60);
        redisService.put("redis_string", "abc", 60);
        wholesaleOrder = (WholesaleOrder) redisService.get("redis_wholesaleorder");
        String redisStr = (String) redisService.get("redis_string");
        System.out.println(">>>>>>>>>>>>2" + redisStr);
        return wholesaleOrder.toString();
    }
    
    @Reference(version = "1.0.0")
    private RabbitmqService rabbitmqService;
    
    @RequestMapping(method = RequestMethod.POST, value = "/rabbitmq/send", consumes="application/json")
    public String rabbitmqSend(@RequestBody String topic) {
        System.out.println(">>>>>>>>>>topic:" + topic);
        rabbitmqService.send(topic, "222");
        return topic;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/login", consumes="application/json")
    public String login(@RequestBody String user) {
        System.out.println("controller1>>>>>>>>>>" + user);
        return user;
    }
    
    @LoginRequired
    @RequestMapping(method = RequestMethod.POST, value = "/login2", consumes="application/json")
    public String login2(@RequestBody String user) {
        System.out.println("controller2>>>>>>>>>>" + user);
        return user;
    }
}
