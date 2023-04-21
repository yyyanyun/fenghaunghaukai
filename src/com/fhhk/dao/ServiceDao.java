package com.fhhk.dao;

import com.fhhk.entity.Service;

import java.sql.SQLException;

public interface ServiceDao {
    Service selectByServiceId(Integer service_id) throws SQLException;
}
