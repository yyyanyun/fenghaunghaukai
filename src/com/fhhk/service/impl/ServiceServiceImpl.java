package com.fhhk.service.impl;

import com.fhhk.dao.ServiceDao;
import com.fhhk.dao.impl.ServiceDaoImpl;
import com.fhhk.entity.Service;
import com.fhhk.service.ServiceService;

import java.sql.SQLException;
import java.util.List;

public class ServiceServiceImpl implements ServiceService {
    private ServiceDao serviceDao= new ServiceDaoImpl();
    @Override
    public List<Service> selectAllService() {
        try {
            return serviceDao.selectAllService();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Service selectServiceByID(int service_id) {
        try {
            return serviceDao.selectServiceByID(service_id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
