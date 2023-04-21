package com.fhhk.dao;

import com.fhhk.entity.Staff;

import java.sql.SQLException;
import java.util.List;

public interface StaffDao {

    //查询所有的技师信息
    List<Staff> selectAllStaff() throws SQLException;
    //根据 技师 的staff_id  查询  信息
    Staff  selectByStaff_id(int staff_id) throws SQLException;

    // 获取  技师 总 记录数
    Integer selectStaffCount(String staff_name, String gender, Integer age) throws SQLException;

    // 根据 不同的查询 参数 查询
    List<Staff>  selectStartList(String staff_name , String gender,Integer age , Integer currentPageNo ,Integer PageSize ) throws SQLException;
 }
