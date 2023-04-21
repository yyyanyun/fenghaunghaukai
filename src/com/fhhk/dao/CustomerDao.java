package com.fhhk.dao;

import com.fhhk.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
Customer selectCustomerbycid(int cid) throws SQLException;
int selectCustomercount(int cid) throws SQLException;
int updateCustomer(Customer customer) throws SQLException;
int deleteCustomer(String cid) throws SQLException;
Integer selectCustomercount(String name,String startTime,String endTime) throws SQLException;
List<Customer> selectCustomerList(String name, String startTime, String endTime, Integer currentPageNO, Integer pageSize) throws SQLException;
}


