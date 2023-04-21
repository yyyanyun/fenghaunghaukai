package com.fhhk.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private int order_id;
    private int customer_id;
    private Date date_time;
    private double sum_monetary;
    private String order_status;
    private int pay_status;
    private List<Trolley> trolleyList;

    public Order() {
    }

    public Order(int order_id, int customer_id, Date date_time, double sum_monetary, String order_status, int pay_status, List<Trolley> trolleyList) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.date_time = date_time;
        this.sum_monetary = sum_monetary;
        this.order_status = order_status;
        this.pay_status = pay_status;
        this.trolleyList = trolleyList;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public double getSum_monetary() {
        return sum_monetary;
    }

    public void setSum_monetary(double sum_monetary) {
        this.sum_monetary = sum_monetary;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public int getPay_status() {
        return pay_status;
    }

    public void setPay_status(int pay_status) {
        this.pay_status = pay_status;
    }

    public List<Trolley> getTrolleyList() {
        return trolleyList;
    }

    public void setTrolleyList(List<Trolley> trolleyList) {
        this.trolleyList = trolleyList;
    }
}
