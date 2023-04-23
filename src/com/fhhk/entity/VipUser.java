package com.fhhk.entity;


import java.util.List;

public class VipUser {
    private int vip_id;
    private int customer_id;
    private String vip_level;
    private double discount;
    private int free_count;
    private double vip_money;
    private  String datetime;
    private  String customer_name;


    public VipUser() {
    }

    public VipUser(int vip_id, int customer_id, String vip_level, double discount, int free_count, double vip_money, String datetime, String customer_name) {
        this.vip_id = vip_id;
        this.customer_id = customer_id;
        this.vip_level = vip_level;
        this.discount = discount;
        this.free_count = free_count;
        this.vip_money = vip_money;
        this.datetime = datetime;
        this.customer_name = customer_name;
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
     * @return vip_level
     */
    public String getVip_level() {
        return vip_level;
    }

    /**
     * 设置
     * @param vip_level
     */
    public void setVip_level(String vip_level) {
        this.vip_level = vip_level;
    }

    /**
     * 获取
     * @return discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * 设置
     * @param discount
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * 获取
     * @return free_count
     */
    public int getFree_count() {
        return free_count;
    }

    /**
     * 设置
     * @param free_count
     */
    public void setFree_count(int free_count) {
        this.free_count = free_count;
    }

    /**
     * 获取
     * @return vip_money
     */
    public double getVip_money() {
        return vip_money;
    }

    /**
     * 设置
     * @param vip_money
     */
    public void setVip_money(double vip_money) {
        this.vip_money = vip_money;
    }

    /**
     * 获取
     * @return datetime
     */
    public String getDatetime() {
        return datetime;
    }

    /**
     * 设置
     * @param datetime
     */
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    /**
     * 获取
     * @return customer_name
     */
    public String getCustomer_name() {
        return customer_name;
    }

    /**
     * 设置
     * @param customer_name
     */
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String toString() {
        return "VipUser{vip_id = " + vip_id + ", customer_id = " + customer_id + ", vip_level = " + vip_level + ", discount = " + discount + ", free_count = " + free_count + ", vip_money = " + vip_money + ", datetime = " + datetime + ", customer_name = " + customer_name + "}";
    }
}
