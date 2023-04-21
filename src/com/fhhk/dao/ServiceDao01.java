package com.fhhk.dao;

import com.fhhk.entity.Service;

import java.sql.SQLException;

public interface ServiceDao01 {
    Service selectByService_id(Integer service_id) throws SQLException;
}
