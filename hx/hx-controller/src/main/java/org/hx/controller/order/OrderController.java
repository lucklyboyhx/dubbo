package org.hx.controller.order;


import org.hx.common.service.entity.order.WholesaleOrder;
import org.hx.common.service.service.order.WholesaleOrderService;
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
}
