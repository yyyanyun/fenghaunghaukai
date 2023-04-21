package com.fhhk.entity;

import java.io.Serializable;

/**
 * @BelongsProject:fenghaunghaukai
 * @BelongsPackage:com.fhhk.entity
 * @Author:LSL
 * @CreateTime:2023/4/21
 * @Description:TODO 服务类
 * @Version: 1.0
 */
public class Service implements Serializable {
    private int service_id;//服务id
    private String service_name;//服务名称
    private double price;//价格
    private int duration;//时长
    //添加技师映射
    private Staff staff;


    public Service() {
    }

    public Service(int service_id, String service_name, double price, int duration, Staff staff) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.price = price;
        this.duration = duration;
        this.staff = staff;
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
     * @return service_name
     */
    public String getService_name() {
        return service_name;
    }

    /**
     * 设置
     * @param service_name
     */
    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    /**
     * 获取
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 获取
     * @return duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * 设置
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
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
        return "Service{service_id = " + service_id + ", service_name = " + service_name + ", price = " + price + ", duration = " + duration + ", staff = " + staff + "}";
    }
}
