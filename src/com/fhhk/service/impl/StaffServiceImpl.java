package com.fhhk.service.impl;

import com.fhhk.dao.StaffDao;
import com.fhhk.dao.impl.StaffDaoImpl;
import com.fhhk.entity.Staff;
import com.fhhk.service.StaffService;
import com.fhhk.utils.PageUtils;

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
            return staffDao.selectByStaff_id(staff_id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public    PageUtils<Staff>  selectStartList(String staff_name, String gender, Integer age, String currentPageNoStr, String PageSizeStr) throws SQLException {

        //当前 页面
        Integer currentPageNo = 1;
        //页量
        Integer PageSize = 2;

        if (currentPageNoStr != null) {
            currentPageNo = Integer.parseInt(currentPageNoStr);
        }

        if (PageSizeStr != null) {
            PageSize = Integer.parseInt(PageSizeStr);
        }


        // 总 记录条
        Integer totalCount = staffDao.selectStaffCount(staff_name, gender, age);

        // 页面数
        Integer totalPageSize = totalCount / PageSize == 0 ? totalCount / PageSize : totalCount / PageSize + 1;

        //查询的记录
        List<Staff> staffList = staffDao.selectStartList(staff_name, gender, age, currentPageNo, PageSize);

        PageUtils<Staff> pageUtils = new PageUtils<>();

        pageUtils.setCurrentPageNo(currentPageNo);
        pageUtils.setTotalPageCount(totalCount);
        pageUtils.setTotalPageSize(totalPageSize);
        pageUtils.setPageSize(PageSize);
        pageUtils.setList(staffList);

        return pageUtils;
    }


}