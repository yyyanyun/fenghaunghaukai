package com.fhhk.dao;

import com.fhhk.entity.Trolley;

import java.sql.SQLException;
import java.util.List;

public interface TrolleyDao {
    List<Trolley> selectByOrderId(int order_id) throws SQLException;
}
