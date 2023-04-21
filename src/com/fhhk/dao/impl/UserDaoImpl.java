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
}
