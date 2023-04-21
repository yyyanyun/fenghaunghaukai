package com.fhhk.service;

import com.fhhk.entity.Customer;

public interface UserService {
    String checkCode();
    Customer selectByPhoneAndPwd(String phone, String customer_pwd);
    Customer selectByPhone(String phone);
    int addCustomer(Customer customer);
}
