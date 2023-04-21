package com.fhhk.dao;

import com.fhhk.entity.Staff;
import com.fhhk.entity.Service;

import java.sql.SQLException;

public interface StaffDao {

    //添加技师

    int addStaff(Staff staff) throws SQLException;


    //删除技师
    int deleteStaff(String staff_id) throws SQLException;


    //去修改

    Staff goUpdateStaff(int staff_id) throws SQLException;


    //修改技师
    int updateStaff(Staff staff, int staff_id) throws SQLException;

    //根据技师staff_id查询技师记录

    Staff selectByIdStaff(int staff_id) throws SQLException;


}
