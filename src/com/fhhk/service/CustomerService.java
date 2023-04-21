package com.fhhk.service;

import com.fhhk.entity.Customer;
import com.fhhk.utils.PageUtils;
public interface CustomerService {
    Customer selectCustomerbycid(int cid);

    int selectCustomercount(int cid);

    int updateCustomer(Customer customer);

    int deleteCustomer(String cid);

    PageUtils<Customer> selectCustomerpage(String name, String startTime, String endTime, String currentPageNOStr, String pageSizeStr);
}