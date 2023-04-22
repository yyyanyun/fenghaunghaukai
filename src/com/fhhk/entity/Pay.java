package com.fhhk.entity;

import java.io.Serializable;

public class Pay implements Serializable {
    private int payId;//支付id
    private int customerId;//客户id
    private int orderId;//订单id


    public Pay() {
    }

    public Pay(int payId, int customerId, int orderId) {
        this.payId = payId;
        this.customerId = customerId;
        this.orderId = orderId;
    }

    /**
     * 获取
     * @return payId
     */
    public int getPayId() {
        return payId;
    }

    /**
     * 设置
     * @param payId
     */
    public void setPayId(int payId) {
        this.payId = payId;
    }

    /**
     * 获取
     * @return customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * 设置
     * @param customerId
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取
     * @return orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * 设置
     * @param orderId
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String toString() {
        return "Pay{payId = " + payId + ", customerId = " + customerId + ", orderId = " + orderId + "}";
    }
}
