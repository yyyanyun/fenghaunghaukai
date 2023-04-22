package com.fhhk.service.impl;

import com.fhhk.dao.StaffDao;
import com.fhhk.dao.impl.StaffDaoImpI;
import com.fhhk.entity.Staff;
import com.fhhk.service.StaffService;
import com.fhhk.utils.PageUtils;

import java.sql.SQLException;
import java.util.List;

public class StaffServiceImpI implements StaffService {
    private StaffDao staffDao = new StaffDaoImpI();

    @Override
    //添加技师
    public int addStaff(Staff staff) {
        try {
            return staffDao.addStaff(staff);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    //删除技师
    public int deleteStaff(String staff_id) throws SQLException {
        return staffDao.deleteStaff(staff_id);
    }

    @Override
    //去修改技师
    public Staff goUpdateStaff(int staff_id) throws SQLException {
        return staffDao.goUpdateStaff(staff_id);
    }

    @Override
    //修改技师
    public int updateStaff(Staff staff, int staff_id) throws SQLException {


        return staffDao.updateStaff(staff, staff_id);
    }

    @Override
    public Staff selectByIdStaff(int staff_id) throws SQLException {
        return staffDao.selectByIdStaff(staff_id);
    }

    @Override
    public List<Staff> selectAllStaff() {
        return null;
    }

    @Override
    public Staff selectByStaff_id(int staff_id) {
        return null;
    }

    @Override
    public PageUtils<Staff> selectStartList(String staff_name, String gender, Integer age, String currentPageNoStr, String PageSizeStr) throws SQLException {
        return null;
    }


}
