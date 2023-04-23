package com.fhhk.entity;

public class VipUser {
    private int customer_id;
    private String vip_level;
    private double discount;
    private int free_count;
    private double vip_money;
    private  String vip_createdate;
    private  String customer_name;

    public VipUser() {
    }

    public VipUser(int customer_id, String vip_level, double discount, int free_count, double vip_money, String vip_createdate, String customer_name) {
        this.customer_id = customer_id;
        this.vip_level = vip_level;
        this.discount = discount;
        this.free_count = free_count;
        this.vip_money = vip_money;
        this.vip_createdate = vip_createdate;
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
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

    public String getVip_createdate() {
        return vip_createdate;
    }

    public void setVip_createdate(String vip_createdate) {
        this.vip_createdate = vip_createdate;
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
                ", discount=" + discount +
                ", free_count=" + free_count +
                ", vip_money=" + vip_money +
                ", vip_createdate='" + vip_createdate + '\'' +
                ", customer_name='" + customer_name + '\'' +
                '}';
    }
}
