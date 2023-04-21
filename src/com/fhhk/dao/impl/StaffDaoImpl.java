package com.fhhk.dao.impl;

import com.fhhk.dao.StaffDao;
import com.fhhk.entity.Staff;
import com.fhhk.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StaffDaoImpl implements StaffDao {

    @Override
    public List<Staff> selectAllStaff() throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        String sql = "select * from staff";

        List<Staff> staffList = qr.query(sql, new BeanListHandler<Staff>(Staff.class));
        return staffList;
    }

    @Override
    public Staff selectByStaff_id(int staff_id) throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        String sql = "select * from staff where staff_id = ?";

        Staff staff = qr.query(sql, new BeanHandler<>(Staff.class), staff_id);

        return staff;
    }
}
