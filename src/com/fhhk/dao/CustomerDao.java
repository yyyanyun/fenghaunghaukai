package com.fhhk.dao;

import com.fhhk.entity.Customer;

import java.sql.SQLException;

public interface CustomerDao {
Customer selectCustomerbycid(int cid) throws SQLException;
int selectCustomercount(int cid) throws SQLException;
int updateCustomer(Customer customer) throws SQLException;
int deleteCustomer(String cid) throws SQLException;

}
