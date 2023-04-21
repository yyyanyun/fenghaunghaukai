package com.fhhk.dao.impl;

import com.fhhk.dao.ServiceDao;
import com.fhhk.entity.Service;
import com.fhhk.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class ServiceDaoImpl implements ServiceDao {
    @Override
    public Service selectByServiceId(int service_id) throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        String sql = "SELECT * FROM 'service' WHERE service_id=?";
        Service service = qr.query(sql,new BeanHandler<Service>(Service.class),service_id);
        return service;
    }
}
