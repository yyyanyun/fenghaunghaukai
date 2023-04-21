package com.fhhk.dao.impl;

import com.fhhk.dao.ServiceDao;
import com.fhhk.entity.Service;
import com.fhhk.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.fhhk.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
import java.sql.SQLException;

public class ServiceDaoImpl implements ServiceDao {
    @Override
    public Service selectByServiceId(Integer service_id) throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        String sql = "SELECT * FROM service WHERE service_id=?";
        Service service = qr.query(sql,new BeanHandler<Service>(Service.class),service_id);

    @Override
    public List<Service> selectAllService() throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        String sql = "select * from service ";
        List<Service> serviceList = qr.query(sql, new BeanListHandler<Service>(Service.class));
        return serviceList;
    }

    @Override
    public Service selectServiceByID(int service_id) throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        String sql = "select * from service  where service_id = ?";
        Service service = qr.query(sql, new BeanHandler<>(Service.class), service_id);
        return service;
    }
}
