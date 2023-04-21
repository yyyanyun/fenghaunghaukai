package com.fhhk.service;

import com.fhhk.entity.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> selectAllStaff();

    Staff  selectByStaff_id(int staff_id);

    // 获取  技师 总 记录数
    Integer selectStaffBy

}
