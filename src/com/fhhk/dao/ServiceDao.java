package com.fhhk.dao;

import com.fhhk.entity.Service;

import java.sql.SQLException;

public interface ServiceDao {
    Service selectByServiceId(int service_id) throws SQLException;
}
