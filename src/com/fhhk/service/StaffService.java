package com.fhhk.service;

import com.fhhk.entity.Staff;
import com.fhhk.utils.PageUtils;

import java.sql.SQLException;
import java.util.List;

public interface StaffService {
    List<Staff> selectAllStaff();

    Staff  selectByStaff_id(int staff_id);

    // 获取  技师 总 记录数
    PageUtils<Staff> selectStartList(String staff_name , String gender, Integer age , String currentPageNoStr , String PageSizeStr ) throws SQLException;

}
