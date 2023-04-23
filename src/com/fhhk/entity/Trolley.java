package com.fhhk.entity;

import java.io.Serializable;

/**
 * @BelongsProject:fenghaunghaukai
 * @BelongsPackage:com.fhhk.entity
 * @Author:LSL
 * @CreateTime:2023/4/21
 * @Description:TODO 购物车实体类
 * @Version: 1.0
 */
public class Trolley implements Serializable {
    private int tid;
    private int customer_id;//用户id
    private int service_id;//服务id
    private int trolley_number;//数量
    private String order_id;//订单编号
    //添加服务映射
    private Service service;
    private Staff staff;

    public Trolley() {
    }

    public Trolley(int tid, int customer_id, int service_id, int trolley_number, String order_id, Service service, Staff staff) {
        this.tid = tid;
        this.customer_id = customer_id;
        this.service_id = service_id;
        this.trolley_number = trolley_number;
        this.order_id = order_id;
        this.service = service;
        this.staff = staff;
    }

    /**
     * 获取
     * @return tid
     */
    public int getTid() {
        return tid;
    }

    /**
     * 设置
     * @param tid
     */
    public void setTid(int tid) {
        this.tid = tid;
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
     * @return service_id
     */
    public int getService_id() {
        return service_id;
    }

    /**
     * 设置
     * @param service_id
     */
    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    /**
     * 获取
     * @return trolley_number
     */
    public int getTrolley_number() {
        return trolley_number;
    }

    /**
     * 设置
     * @param trolley_number
     */
    public void setTrolley_number(int trolley_number) {
        this.trolley_number = trolley_number;
    }

    /**
     * 获取
     * @return order_id
     */
    public String getOrder_id() {
        return order_id;
    }

    /**
     * 设置
     * @param order_id
     */
    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    /**
     * 获取
     * @return service
     */
    public Service getService() {
        return service;
    }

    /**
     * 设置
     * @param service
     */
    public void setService(Service service) {
        this.service = service;
    }

    /**
     * 获取
     * @return staff
     */
    public Staff getStaff() {
        return staff;
    }

    /**
     * 设置
     * @param staff
     */
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String toString() {
        return "Trolley{tid = " + tid + ", customer_id = " + customer_id + ", service_id = " + service_id + ", trolley_number = " + trolley_number + ", order_id = " + order_id + ", service = " + service + ", staff = " + staff + "}";
    }
}
