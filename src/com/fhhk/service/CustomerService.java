package com.fhhk.service;

import com.fhhk.entity.Customer;

import java.sql.SQLException;

public interface CustomerService {
    Customer selectCustomerbycid(int cid);
    int selectCustomercount(int cid);
    int updateCustomer(Customer customer);
    int deleteCustomer(String cid) ;
}
