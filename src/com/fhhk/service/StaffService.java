package com.fhhk.service;

import com.fhhk.entity.Staff;

import java.sql.SQLException;
import com.fhhk.utils.PageUtils;
import java.util.List;

public interface StaffService {
    //添加技师
    int addStaff(Staff staff);

    //删除技师
    int deleteStaff(String staff_id) throws SQLException;

    //去修改

    Staff goUpdateStaff(int staff_id ) throws SQLException;

    //修改技师
    int updateStaff(Staff staff,int staff_id) throws SQLException;

    //根据技师id查询技师记录

    Staff selectByIdStaff(int staff_id) throws SQLException;

    List<Staff> selectAllStaff();

    Staff  selectByStaff_id(int staff_id);
    // 获取  技师 总 记录数
    PageUtils<Staff> selectStartList(String staff_name , String gender, Integer age , String currentPageNoStr , String PageSizeStr ) throws SQLException;

}
