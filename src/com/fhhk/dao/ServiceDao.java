package com.fhhk.dao;

import com.fhhk.entity.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServiceDao {
    Service selectByServiceId(Integer service_id) throws SQLException;
    //查询所有 套餐信息
    List<Service> selectAllService() throws SQLException;
    //根据 套餐 id 查询  套餐
    Service selectServiceByID(int  service_id) throws SQLException;
}
