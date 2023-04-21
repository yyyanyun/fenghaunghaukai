package com.fhhk.dao.impl;
import com.fhhk.dao.CustomerDao;
import com.fhhk.entity.Customer;
import com.fhhk.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class CustomerDaoimpl implements CustomerDao {
    private QueryRunner qr= JDBCUtils.JD.qr;
    @Override
    public Customer selectCustomerbycid(int cid) throws SQLException {
        String sql=" select * from  customer where customer_id =?";
        Customer query = qr.query(sql, new BeanHandler<>(Customer.class), cid);
        return  query;
    }

    @Override
    public int selectCustomercount(int cid) throws SQLException {
        String sql=" select count(1) from `order` where customer_id =? ";
        Object query = qr.query(sql, new ScalarHandler(), cid);
        return query==null?0:Integer.parseInt(query.toString());
    }

    @Override
    public int updateCustomer(Customer customer) throws SQLException {
        String sql="update customer set customer_name=? ,customer_pwd= ? , gender=? ,age=? ,phone=?,address=?,customer_number=? ,remark=? where customer_id=?";
        Object[] objects={customer.getCustomer_name(),customer.getCustomer_pwd(),customer.getGender(),customer.getAge(),customer.getPhone(),customer.getAddress(),customer.getCustomer_number(),customer.getRemark(),customer.getCustomer_id()};
        int update = qr.update(sql, objects);
        return update;
    }

    @Override
    public int deleteCustomer(String cid) throws SQLException {
        String sql="delete from customer where customer_id ="+cid;
        int update = qr.update(sql);
        return update;
    }



}
