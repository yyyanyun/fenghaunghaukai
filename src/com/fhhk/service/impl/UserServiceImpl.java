package com.fhhk.service.impl;

import com.fhhk.dao.UserDao;
import com.fhhk.dao.impl.UserDaoImpl;
import com.fhhk.entity.Customer;
import com.fhhk.service.UserService;
import com.fhhk.utils.VerifyCodeUtils;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();
    @Override
    public String checkCode() {
        return VerifyCodeUtils.generateVerifyCode(4);
    }

    @Override
    public Customer selectByPhoneAndPwd(String phone, String customer_pwd) {
        return userDao.selectByPhoneAndPwd(phone,customer_pwd);
    }

    @Override
    public Customer selectByPhone(String phone) {
        return userDao.selectByPhone(phone);
    }

    @Override
    public int addCustomer(Customer customer) {
        return userDao.addCustomer(customer);
    }
}
