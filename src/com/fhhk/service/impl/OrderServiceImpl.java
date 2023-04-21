package com.fhhk.service.impl;

import com.fhhk.dao.OrderDao;
import com.fhhk.dao.ServiceDao;
import com.fhhk.dao.TrolleyDao;
import com.fhhk.dao.impl.OrderDaoImpl;
import com.fhhk.dao.impl.ServiceDaoImpl;
import com.fhhk.dao.impl.TrolleyDaoImpl;
import com.fhhk.entity.Order;
import com.fhhk.entity.Service;
import com.fhhk.entity.Trolley;
import com.fhhk.service.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private TrolleyDao trolleyDao = new TrolleyDaoImpl();
    private ServiceDao serviceDao = new ServiceDaoImpl();
    @Override
    public List<Order> selectAllOrderByOrderId(int order_id) {
        List<Order> orderList = null;
        try {
            orderList = orderDao.selectAllOrderByOrderId(order_id);
            orderList.forEach((Order o)->{
                List<Trolley> trolleyList = null;
                try {
                    trolleyList = trolleyDao.selectByOrderId(order_id);
                    o.setTrolleyList(trolleyList);
                    trolleyList.forEach((Trolley t)->{
                        int service_id = t.getService_id();
                        Service service = null;
                        try {
                            service = serviceDao.selectByServiceId(service_id);
                            t.setService(service);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    });
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}
