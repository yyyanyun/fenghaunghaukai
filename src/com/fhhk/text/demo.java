package com.fhhk.text;

import com.fhhk.entity.Staff;
import com.fhhk.service.StaffService;
import com.fhhk.service.impl.StaffServiceImpI;
import com.fhhk.utils.PageUtils;

import java.sql.SQLException;

public class demo {
    public static void main(String[] args) throws SQLException {
//        StaffDaoImpl staffDao = new StaffDaoImpl();
//        List<Staff> staffList = staffDao.selectAllStaff();
        StaffService staffService = new StaffServiceImpI.StaffServiceImpl();
//        List<Staff> staffList = staffService.selectAllStaff();
//        System.out.println(staffList);

        PageUtils<Staff> pageUtils = staffService.selectStartList(null, "女", 30, null, null);
        System.out.println(pageUtils.getList());

    }
}
