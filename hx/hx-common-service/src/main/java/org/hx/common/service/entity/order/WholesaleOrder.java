package org.hx.common.service.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WholesaleOrder implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -7786907084511978704L;
    private String orderFid;
    private Date createTime;
    private BigDecimal money;
    public String getOrderFid() {
        return orderFid;
    }
    public void setOrderFid(String orderFid) {
        this.orderFid = orderFid;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public BigDecimal getMoney() {
        return money;
    }
    public void setMoney(BigDecimal money) {
        this.money = money;
    }
    @Override
    public String toString() {
        return "WholesaleOrder [orderFid=" + orderFid + ", createTime=" + createTime + ", money=" + money + "]";
    }
    
    
}
