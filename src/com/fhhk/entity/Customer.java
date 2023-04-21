package com.fhhk.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
// 客户表
public class Customer implements Serializable {
   //  (customer_name,customer_pwd, gender, age, phone,address,customer_date,number,remark)
    private int customer_id;
    private String customer_name;
    private String customer_pwd;
    private String gender;
    private int age;
    private String phone;
    private String address;
    private LocalDateTime customer_date;
    private int number;
    private String remark;

    public Customer() {
    }

    public Customer(int customer_id, String customer_name, String customer_pwd, String gender, int age, String phone, String address, LocalDateTime customer_date, int number, String remark) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_pwd = customer_pwd;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.customer_date = customer_date;
        this.number = number;
        this.remark = remark;
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

    /**
     * 获取
     * @return customer_pwd
     */
    public String getCustomer_pwd() {
        return customer_pwd;
    }

    /**
     * 设置
     * @param customer_pwd
     */
    public void setCustomer_pwd(String customer_pwd) {
        this.customer_pwd = customer_pwd;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return customer_date
     */
    public LocalDateTime getCustomer_date() {
        return customer_date;
    }

    /**
     * 设置
     * @param customer_date
     */
    public void setCustomer_date(LocalDateTime customer_date) {
        this.customer_date = customer_date;
    }

    /**
     * 获取
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * 设置
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * 获取
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String toString() {
        return "Customer{customer_id = " + customer_id + ", customer_name = " + customer_name + ", customer_pwd = " + customer_pwd + ", gender = " + gender + ", age = " + age + ", phone = " + phone + ", address = " + address + ", customer_date = " + customer_date + ", number = " + number + ", remark = " + remark + "}";
    }
}
