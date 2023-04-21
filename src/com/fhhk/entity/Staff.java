package com.fhhk.entity;

import java.io.Serializable;

/**
 * @BelongsProject:fenghaunghaukai
 * @BelongsPackage:com.fhhk.entity
 * @Author:LSL
 * @CreateTime:2023/4/21
 * @Description:TODO 技师类
 * @Version: 1.0
 */
public class Staff implements Serializable {
    private int staff_id;//技师id
    private String staff_name;//技师姓名
    private String gender;//性别
    private int age;//年龄
    private String phone;//电话
    private String status;//技师状态
    private String photo;//照片
    private int service_id;//服务id


    public Staff() {
    }

    public Staff(int staff_id, String staff_name, String gender, int age, String phone, String status, String photo, int service_id) {
        this.staff_id = staff_id;
        this.staff_name = staff_name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.status = status;
        this.photo = photo;
        this.service_id = service_id;
    }

    /**
     * 获取
     * @return staff_id
     */
    public int getStaff_id() {
        return staff_id;
    }

    /**
     * 设置
     * @param staff_id
     */
    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    /**
     * 获取
     * @return staff_name
     */
    public String getStaff_name() {
        return staff_name;
    }

    /**
     * 设置
     * @param staff_name
     */
    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
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
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取
     * @return photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置
     * @param photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String toString() {
        return "Staff{staff_id = " + staff_id + ", staff_name = " + staff_name + ", gender = " + gender + ", age = " + age + ", phone = " + phone + ", status = " + status + ", photo = " + photo + ", service_id = " + service_id + "}";
    }
}
