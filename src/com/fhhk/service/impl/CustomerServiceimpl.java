package com.fhhk.service.impl;

import com.fhhk.dao.CustomerDao;
import com.fhhk.dao.impl.CustomerDaoimpl;
import com.fhhk.entity.Customer;
import com.fhhk.service.CustomerService;

import java.sql.SQLException;

public class CustomerServiceimpl implements CustomerService {
    private CustomerDao customerDao=new CustomerDaoimpl();
    @Override
    public Customer selectCustomerbycid(int cid) {
        try {
            return customerDao.selectCustomerbycid(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCustomercount(int cid) {
        try {
            return customerDao.selectCustomercount(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int updateCustomer(Customer customer) {

        try {
            return customerDao.updateCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int deleteCustomer(String cid) {
        try {
            return customerDao.deleteCustomer(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  -1;
    }
}
