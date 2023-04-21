package com.fhhk.service;

import com.fhhk.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> selectAllOrderByOrderId(int order_id);
}
