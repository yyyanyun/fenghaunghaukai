package com.fhhk.dao.impl;

import com.fhhk.dao.ServiceDao;
import com.fhhk.entity.Service;
import com.fhhk.utils.DBUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @BelongsProject:fenghaunghaukai
 * @BelongsPackage:com.fhhk.dao.impl
 * @Author:LSL
 * @CreateTime:2023/4/21
 * @Description:TODO
 * @Version: 1.0
 */
public class ServiceDaoImpl implements ServiceDao {
    @Override
    public Service selectByService_id(Integer service_id) throws SQLException {

        String sql = "SELECT * FROM service WHERE service_id=?;";
        Service service = DBUtils.DB.getQr().query(sql, new BeanHandler<>(Service.class), service_id);
        return service;
    }
}
