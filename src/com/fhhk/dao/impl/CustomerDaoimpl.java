package com.fhhk.dao.impl;
import com.fhhk.dao.CustomerDao;
import com.fhhk.entity.Customer;
import com.fhhk.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        String sql="delete from customer where customer_id  in("+cid+")";
        int update = qr.update(sql);
        return update;
    }

    @Override
    public Integer selectCustomercount(String name, String startTime, String endTime) throws SQLException {
        String sql="select count(1)  from Customer where 1=1";
        StringBuffer sb=new StringBuffer(sql);
        List<Object> list=new ArrayList<>();
        if(name!=null&&!"".equals(name)){
            sb.append(" and customer_name like ? ");
            list.add("%"+name+"%");
        }
        if(startTime!=null&&!"".equals(startTime)){
            sb.append(" and customer_date> ? ");
            list.add(startTime);
        }
        if(endTime!=null&&!"".equals(endTime)){
            sb.append(" and customer_date< ? ");
            list.add(endTime);
        }
        Long query=null;
        if(list!=null&&list.size()>0){
             query = (Long) qr.query(sb.toString(), new ScalarHandler(), list.toArray());
        }else {
             query = (Long) qr.query(sb.toString(), new ScalarHandler(), list.toArray());
        }
        return query==null?0:Integer.parseInt(query.toString());
    }

    @Override
    public List<Customer> selectCustomerList(String name, String startTime, String endTime, Integer currentPageNO, Integer pageSize) throws SQLException {
        String sql="select *  from Customer where 1=1  ";
        StringBuffer sb=new StringBuffer(sql);
        List<Object> list=new ArrayList<>();
        if(name!=null&&!"".equals(name)){
            sb.append(" and customer_name like ? ");
            list.add("%"+name+"%");
        }
        if(startTime!=null&&!"".equals(startTime)){
            sb.append(" and customer_date> ? ");
            list.add(startTime);
        }
        if(endTime!=null&&!"".equals(endTime)){
            sb.append(" and customer_date< ? ");
            list.add(endTime);
        }
        sb.append(" limit ?,? ");
        list.add((currentPageNO-1)*pageSize);
        list.add(pageSize);
        List<Customer> query = qr.query(sb.toString(), new BeanListHandler<>(Customer.class), list.toArray());
        return query;
    }
}




