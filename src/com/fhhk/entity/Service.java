package com.fhhk.entity;

import lombok.Data;

import java.io.Serializable;


public class Service implements Serializable {

    private int service_id;
    private String service_name;
    private double price;
    private int duration; //时长

    public Service() {
    }

    public Service(int service_id, String service_name, double price, int duration) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.price = price;
        this.duration = duration;
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

    public String toString() {
        return "Service{service_id = " + service_id + ", service_name = " + service_name + ", price = " + price + ", duration = " + duration + "}";
    }
}
