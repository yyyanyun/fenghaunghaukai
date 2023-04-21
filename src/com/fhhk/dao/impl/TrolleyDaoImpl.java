package com.fhhk.dao.impl;

import com.fhhk.dao.TrolleyDao;
import com.fhhk.entity.Trolley;
import com.fhhk.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class TrolleyDaoImpl implements TrolleyDao {
    @Override
    public List<Trolley> selectByOrderId(int order_id) throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        String sql = "SELECT * FROM 'trolley' WHERE order_id=?";
        List<Trolley> trolleyList = qr.query(sql,new BeanListHandler<Trolley>(Trolley.class),order_id);
        return trolleyList;
    }
}
