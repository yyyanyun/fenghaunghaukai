package com.fhhk.entity;

import java.io.Serializable;

public class Trolley implements Serializable {
    private int customer_id;
    private int service_id;
    private int tyolley_number;
    private int order_id;
    private Service service;

    public Trolley() {
    }

    public Trolley(int customer_id, int service_id, int tyolley_number, int order_id, Service service) {
        this.customer_id = customer_id;
        this.service_id = service_id;
        this.tyolley_number = tyolley_number;
        this.order_id = order_id;
        this.service = service;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getTyolley_number() {
        return tyolley_number;
    }

    public void setTyolley_number(int tyolley_number) {
        this.tyolley_number = tyolley_number;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
