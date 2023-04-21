package com.fhhk.dao;

import com.fhhk.entity.Order;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface OrderDao {
    //通过顾客ID查找Order集合
    List<Order> selectOrderByOrderId(Integer order_id) throws SQLException;
    //增加订单
    int addOrder(Integer customer_id,Date date_time,Double sum_monetary) throws SQLException;
    //更改订单信息
    int changeOrder(Integer order_id,Integer customer_id,Date date_time,Double sum_monetary,Integer order_status,Integer pay_status) throws SQLException;

    int delOrder(Integer order_id) throws SQLException;

    List<Order> selectOrderList(Integer order_id,Integer customer_id,Double sum_monetary,Integer order_status,Integer pay_status,String startTime,String endTime,Integer currentPageNo,Integer pageSize) throws SQLException;

    Integer selectOrderCount(Integer order_id,Integer customer_id,Double sum_monetary,Integer order_status,Integer pay_status,String startTime,String endTime) throws SQLException;
}
