package com.fhhk.entity;

import java.io.Serializable;

public class Service implements Serializable {
    private int service_id;
    private String service_name;
    private double price;
    private int duration;

    public Service() {
    }

    public Service(int service_id, String service_name, double price, int duration) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.price = price;
        this.duration = duration;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
