package com.fhhk.dao;

import com.fhhk.entity.Staff;

import java.sql.SQLException;
import java.util.List;

public interface StaffDao {

    //查询所有的技师信息
    List<Staff> selectAllStaff() throws SQLException;
    //根据 技师 的staff_id  查询  信息
    Staff  selectByStaff_id(int staff_id) throws SQLException;
 }
