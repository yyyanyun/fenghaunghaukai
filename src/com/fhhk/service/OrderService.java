package com.fhhk.service;

import com.fhhk.entity.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {
    List<Order> selectByOrderId(Integer order_id);

    int addOrder(Integer customer_id,Date date_time, Double sum_monetary);

    int changeOrder(Integer order_id,Integer customer_id,Date date_time,Double sum_monetary,Integer order_status,Integer pay_status);

    int delOrder(Integer order_id);
}
