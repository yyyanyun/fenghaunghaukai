package com.fhhk.dao;

import com.fhhk.entity.Customer;

public interface UserDao {
    Customer selectByPhoneAndPwd(String phone, String customer_pwd);
    Customer selectByPhone(String phone);
    int addCustomer(Customer customer);
}
