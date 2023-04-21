package com.fhhk.service;

import com.fhhk.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> selectByOrderId(Integer order_id);
}
