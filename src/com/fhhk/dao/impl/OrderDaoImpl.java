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
    public int addOrder(Date date_time, Double sum_monetary) throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        String sql = "INSERT INTO `order`(date_time,sum_monetary,order_status,pay_status) VALUES (?,?,1,1)";
        int num = qr.update(sql,date_time,sum_monetary);
        return num;
    }

    @Override
    public int changeOrder(Date date_time, Double sum_monetary,Integer order_status,Integer pay_status) throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        String sql = "UPDATE 'order' SET date_time=?,sum_monetary=?,order_status=?,pay_status=?";
        int num = qr.update(sql,date_time,sum_monetary,order_status,pay_status);
        return num;
    }
}
