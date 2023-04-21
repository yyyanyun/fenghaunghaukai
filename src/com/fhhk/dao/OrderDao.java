package com.fhhk.dao;

import com.fhhk.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    //通过顾客ID查找Order集合
    List<Order> selectOrderByOrderId(Integer order_id) throws SQLException;
}
