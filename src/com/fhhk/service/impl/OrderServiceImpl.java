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
import com.fhhk.utils.PageUtils;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private TrolleyDao trolleyDao = new TrolleyDaoImpl();
    private ServiceDao serviceDao = new ServiceDaoImpl();
    @Override
    public List<Order> selectByOrderId(Integer order_id) {
        List<Order> orderList = null;
        try {
            orderList = orderDao.selectOrderByOrderId(order_id);
            System.out.println(orderList.toString());
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

    @Override
    public int addOrder(Integer customer_id,Date date_time, Double sum_monetary) {
        try {
            return orderDao.addOrder(customer_id,date_time,sum_monetary);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int changeOrder(Integer order_id,Integer customer_id,Date date_time, Double sum_monetary, Integer order_status, Integer pay_status) {
        try {
            return orderDao.changeOrder(order_id,customer_id,date_time, sum_monetary, order_status, pay_status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delOrder(Integer order_id) {
        try {
            return orderDao.delOrder(order_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public PageUtils<Order> selectByPageOrder(Integer order_id, Integer customer_id, Double sum_monetary, Integer order_status, Integer pay_status, String startTime, String endTime, String currentPageNoStr, String pageSizeStr) {
        Integer currenPageNo = 1;
        if (currentPageNoStr != null && !"".equals(currentPageNoStr)){
            currenPageNo = Integer.parseInt(currentPageNoStr);
        }
        Integer pageSize = 2;
        if (pageSizeStr!=null && !"".equals(pageSizeStr)){
            pageSize = Integer.parseInt(pageSizeStr);
        }
        Integer totalPageCount = null;
        Integer totalPageSize = null;
        List<Order> orderList = null;
        try {
            totalPageCount = orderDao.selectOrderCount(order_id,customer_id,sum_monetary,order_status,pay_status,startTime, endTime);
            totalPageSize = totalPageCount % pageSize == 0 ? totalPageCount/pageSize : totalPageCount/pageSize + 1;
            orderList = orderDao.selectOrderList(order_id,customer_id,sum_monetary,order_status,pay_status,startTime, endTime,currenPageNo,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PageUtils<Order> pageUtils = new PageUtils<>();
        pageUtils.setList(orderList);
        pageUtils.setCurrentPageNo(currenPageNo);
        pageUtils.setPageSize(pageSize);
        pageUtils.setTotalPageCount(totalPageCount);
        pageUtils.setTotalPageSize(totalPageSize);
        return pageUtils;
    }
}
