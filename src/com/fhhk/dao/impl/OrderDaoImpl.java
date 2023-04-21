package com.fhhk.dao.impl;

import com.fhhk.dao.OrderDao;
import com.fhhk.entity.Order;
import com.fhhk.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public List<Order> selectOrderByOrderId(Integer order_id) throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        String sql = "SELECT * FROM `order` WHERE order_id=?";
        List<Order> orderList = qr.query(sql,new BeanListHandler<Order>(Order.class),order_id);
        return orderList;
    }

    @Override
    public int addOrder(Integer customer_id,Date date_time, Double sum_monetary) throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        String sql = "INSERT INTO `order`(customer_id,date_time,sum_monetary,order_status,pay_status) VALUES (?,?,?,1,1)";
        int num = qr.update(sql,customer_id,date_time,sum_monetary);
        return num;
    }

    @Override
    public int changeOrder(Integer order_id,Integer customer_id,Date date_time, Double sum_monetary,Integer order_status,Integer pay_status) throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        String sql = "UPDATE `order` SET customer_id=?,date_time=?,sum_monetary=?,order_status=?,pay_status=? WHERE order_id=?";
        int num = qr.update(sql,customer_id,date_time,sum_monetary,order_status,pay_status,order_id);
        return num;
    }

    @Override
    public int delOrder(Integer order_id) throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        String sql = "DELETE FROM `order` WHERE order_id=?";
        int num = qr.update(sql,order_id);
        return num;
    }

    @Override
    public List<Order> selectOrderList(Integer order_id, Integer customer_id, Double sum_monetary, Integer order_status, Integer pay_status, String startTime, String endTime, Integer currentPageNo, Integer pageSize) throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        StringBuffer sb = new StringBuffer("SELECT * FROM `order` WHERE 1=1");
        List parmList = new ArrayList();
        if (order_id!=null){
            sb.append(" and order_id=? ");
            parmList.add(order_id);
        }
        if (customer_id!=null){
            sb.append(" and customer_id=? ");
            parmList.add(customer_id);
        }
        if (sum_monetary!=null){
            sb.append(" and sum_monetary=? ");
            parmList.add(customer_id);
        }
        if (order_status!=null){
            sb.append(" and order_status=? ");
            parmList.add(customer_id);
        }
        if (pay_status!=null){
            sb.append(" and pay_status=? ");
            parmList.add(customer_id);
        }
        if (startTime!=null && !"".equals(startTime)){
            sb.append(" and date_time>? ");
            parmList.add(startTime);
        }
        if (endTime!=null && !"".equals(endTime)){
            sb.append(" and date_time<? ");
            parmList.add(endTime);
        }

        sb.append(" limit ?,? ");
        parmList.add((currentPageNo-1)*pageSize);
        parmList.add(pageSize);
        List<Order> orderList = qr.query(sb.toString(),new BeanListHandler<Order>(Order.class),parmList.toArray());
        return orderList;
    }

    @Override
    public Integer selectOrderCount(Integer order_id, Integer customer_id, Double sum_monetary, Integer order_status, Integer pay_status, String startTime, String endTime) throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        StringBuffer sb = new StringBuffer("SELECT * FROM `order` WHERE 1=1");
        List parmList = new ArrayList();
        if (order_id!=null){
            sb.append(" and order_id=? ");
            parmList.add(order_id);
        }
        if (customer_id!=null){
            sb.append(" and customer_id=? ");
            parmList.add(customer_id);
        }
        if (sum_monetary!=null){
            sb.append(" and sum_monetary=? ");
            parmList.add(customer_id);
        }
        if (order_status!=null){
            sb.append(" and order_status=? ");
            parmList.add(customer_id);
        }
        if (pay_status!=null){
            sb.append(" and pay_status=? ");
            parmList.add(customer_id);
        }
        if (startTime!=null && !"".equals(startTime)){
            sb.append(" and date_time>? ");
            parmList.add(startTime);
        }
        if (endTime!=null && !"".equals(endTime)){
            sb.append(" and date_time<? ");
            parmList.add(endTime);
        }
        Long count = null;
        if (parmList!=null && parmList.size()>0){
            count = Long.valueOf(qr.query(sb.toString(),new ScalarHandler(),parmList.toArray()).toString());
        }else {
            count = Long.valueOf(qr.query(sb.toString(),new ScalarHandler()).toString());
        }
        return count == null?0:Integer.parseInt(count+"");
    }
}
