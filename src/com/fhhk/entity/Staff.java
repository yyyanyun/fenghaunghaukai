package com.fhhk.entity;

import java.io.Serializable;

public class Staff implements Serializable {
    private String  staff_id;
    //技师 的类别
    private String  gender;
    //年龄
    private int age;
    //技师图片
    private String photo;
    //技师状态
    private String status;

    public Staff() {
    }

    public Staff(String staff_id, String gender, int age, String photo, String status) {
        this.staff_id = staff_id;
        this.gender = gender;
        this.age = age;
        this.photo = photo;
        this.status = status;
    }

    /**
     * 获取
     * @return staff_id
     */
    public String getStaff_id() {
        return staff_id;
    }

    /**
     * 设置
     * @param staff_id
     */
    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
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

    public String toString() {
        return "Staff{staff_id = " + staff_id + ", gender = " + gender + ", age = " + age + ", photo = " + photo + ", status = " + status + "}";
    }
}
