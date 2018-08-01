package org.hx.order.service;

import org.hx.common.service.entity.order.WholesaleOrder;
import org.hx.common.service.service.order.WholesaleOrderService;

import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class WholesaleOrderServiceImpl implements WholesaleOrderService{

    @Override
    public WholesaleOrder read(String orderFid) {
        WholesaleOrder wholesaleOrder = new WholesaleOrder();
        wholesaleOrder.setOrderFid(orderFid);
        return wholesaleOrder;
    }

}
