package com.fhhk.entity;

public class VipUser {
    private int customer_id;
    private String vip_level;
    private double decimal;
    private int free_count;
    private double vip_money;
    private  String datetime;
    private  String customer_name;

    public VipUser() {
    }

    public VipUser(int customer_id, String vip_level, double decimal, int free_count, double vip_money, String datetime, String customer_name) {
        this.customer_id = customer_id;
        this.vip_level = vip_level;
        this.decimal = decimal;
        this.free_count = free_count;
        this.vip_money = vip_money;
        this.datetime = datetime;
        this.customer_name = customer_name;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getVip_level() {
        return vip_level;
    }

    public void setVip_level(String vip_level) {
        this.vip_level = vip_level;
    }

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }

    public int getFree_count() {
        return free_count;
    }

    public void setFree_count(int free_count) {
        this.free_count = free_count;
    }

    public double getVip_money() {
        return vip_money;
    }

    public void setVip_money(double vip_money) {
        this.vip_money = vip_money;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    @Override
    public String toString() {
        return "VipUser{" +
                "customer_id=" + customer_id +
                ", vip_level='" + vip_level + '\'' +
                ", decimal=" + decimal +
                ", free_count=" + free_count +
                ", vip_money=" + vip_money +
                ", datetime='" + datetime + '\'' +
                ", customer_name='" + customer_name + '\'' +
                '}';
    }
}
