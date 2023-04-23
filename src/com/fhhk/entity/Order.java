package com.fhhk.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private int order_id;
    private int customer_id;
    private double sum_monetary;
    private LocalDateTime dateTime;
    private int order_status;
    private int pay_status;
    private List<Trolley> trolleyList;
    //vipId
    private int vip_id;


    public Order() {
    }

    public Order(int order_id, int customer_id, double sum_monetary, LocalDateTime dateTime, int order_status, int pay_status, List<Trolley> trolleyList, int vip_id) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.sum_monetary = sum_monetary;
        this.dateTime = dateTime;
        this.order_status = order_status;
        this.pay_status = pay_status;
        this.trolleyList = trolleyList;
        this.vip_id = vip_id;
    }

    /**
     * 获取
     * @return order_id
     */
    public int getOrder_id() {
        return order_id;
    }

    /**
     * 设置
     * @param order_id
     */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    /**
     * 获取
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }

    /**
     * 设置
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * 获取
     * @return sum_monetary
     */
    public double getSum_monetary() {
        return sum_monetary;
    }

    /**
     * 设置
     * @param sum_monetary
     */
    public void setSum_monetary(double sum_monetary) {
        this.sum_monetary = sum_monetary;
    }

    /**
     * 获取
     * @return dateTime
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * 设置
     * @param dateTime
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * 获取
     * @return order_status
     */
    public int getOrder_status() {
        return order_status;
    }

    /**
     * 设置
     * @param order_status
     */
    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    /**
     * 获取
     * @return pay_status
     */
    public int getPay_status() {
        return pay_status;
    }

    /**
     * 设置
     * @param pay_status
     */
    public void setPay_status(int pay_status) {
        this.pay_status = pay_status;
    }

    /**
     * 获取
     * @return trolleyList
     */
    public List<Trolley> getTrolleyList() {
        return trolleyList;
    }

    /**
     * 设置
     * @param trolleyList
     */
    public void setTrolleyList(List<Trolley> trolleyList) {
        this.trolleyList = trolleyList;
    }

    /**
     * 获取
     * @return vip_id
     */
    public int getVip_id() {
        return vip_id;
    }

    /**
     * 设置
     * @param vip_id
     */
    public void setVip_id(int vip_id) {
        this.vip_id = vip_id;
    }

    public String toString() {
        return "Order{order_id = " + order_id + ", customer_id = " + customer_id + ", sum_monetary = " + sum_monetary + ", dateTime = " + dateTime + ", order_status = " + order_status + ", pay_status = " + pay_status + ", trolleyList = " + trolleyList + ", vip_id = " + vip_id + "}";
    }
}
