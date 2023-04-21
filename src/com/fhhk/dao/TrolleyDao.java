package com.fhhk.dao;

import com.fhhk.entity.Trolley;

import java.sql.SQLException;
import java.util.List;

public interface TrolleyDao {
    List<Trolley> selectByOrderId(Integer order_id) throws SQLException;
}
