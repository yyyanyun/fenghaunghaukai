package com.fhhk.dao.impl;

import com.fhhk.dao.OrderDao;
import com.fhhk.entity.Order;
import com.fhhk.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public List<Order> selectOrderByOrderId(Integer order_id) throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        String sql = "SELECT * FROM `order` WHERE order_id=?";
        List<Order> orderList = qr.query(sql,new BeanListHandler<Order>(Order.class),order_id);
        return orderList;
    }
}
