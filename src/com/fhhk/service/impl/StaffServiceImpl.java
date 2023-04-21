package com.fhhk.service.impl;

import com.fhhk.dao.StaffDao;
import com.fhhk.dao.impl.StaffDaoImpl;
import com.fhhk.entity.Staff;
import com.fhhk.service.StaffService;

import java.sql.SQLException;
import java.util.List;

public class StaffServiceImpl implements StaffService {
    private StaffDao staffDao = new StaffDaoImpl();
    @Override
    public List<Staff> selectAllStaff() {
        try {
            return staffDao.selectAllStaff();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Staff selectByStaff_id(int staff_id) {
        try {
            return   staffDao.selectByStaff_id(staff_id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
