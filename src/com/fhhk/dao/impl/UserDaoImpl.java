package com.fhhk.dao.impl;

import com.fhhk.dao.UserDao;
import com.fhhk.entity.Customer;
import com.fhhk.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private final QueryRunner qr = DBUtils.DB.getQr();
    @Override
    public Customer selectByPhoneAndPwd(String phone, String customer_pwd) {
        String sql = "select * from customer where phone=? and customer_pwd=?";
        Object[] obj = {phone,customer_pwd};
        Customer customer = null;
        try {
             customer = qr.query(sql, new BeanHandler<>(Customer.class), obj);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public Customer selectByPhone(String phone) {
        String sql = "select * from customer where phone = ?";
        Customer customer = null;
        try {
            customer = qr.query(sql, new BeanHandler<>(Customer.class), phone);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public int addCustomer(Customer c) {
        int num = 0;
        String sql = "INSERT INTO customer(customer_name,customer_pwd, gender, age, phone,address,customer_date,customer_number,remark) VALUES (?,?,?,?,?,?,?,?,?);";
        Object[] obj = {c.getCustomer_name(),c.getCustomer_pwd(),c.getGender(),c.getAge(),c.getPhone(),c.getAddress(),c.getCustomer_date(),c.getCustomer_number(),c.getRemark()};
        try {
            num = qr.update(sql, obj);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return num;
    }
}
