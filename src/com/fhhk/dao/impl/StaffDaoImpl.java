package com.fhhk.dao.impl;

import com.fhhk.dao.StaffDao;
import com.fhhk.entity.Staff;
import com.fhhk.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDaoImpl implements StaffDao {

    @Override
    public int addStaff(Staff staff) throws SQLException {
        return 0;
    }

    @Override
    public int deleteStaff(String staff_id) throws SQLException {
        return 0;
    }

    @Override
    public Staff goUpdateStaff(int staff_id) throws SQLException {
        return null;
    }

    @Override
    public int updateStaff(Staff staff, int staff_id) throws SQLException {
        return 0;
    }

    @Override
    public Staff selectByIdStaff(int staff_id) throws SQLException {
        return null;
    }

    @Override
    public List<Staff> selectAllStaff() throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        String sql = "select * from staff";

        List<Staff> staffList = qr.query(sql, new BeanListHandler<Staff>(Staff.class));
        return staffList;
    }

    @Override
    public Staff selectByStaff_id(int staff_id) throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        String sql = "select * from staff where staff_id = ?";

        Staff staff = qr.query(sql, new BeanHandler<>(Staff.class), staff_id);

        return staff;
    }

    @Override
    public Integer selectStaffCount(String staff_name, String gender, Integer age) throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        StringBuffer sb = new StringBuffer("select * from staff  where  1=1 ");
        ArrayList<Object> list = new ArrayList<>();

        if (staff_name!=null && !"".equals(staff_name)){
            sb.append(" and staff_name = ?");
            list.add(staff_name);
        }

        if (gender!=null&& !"".equals(gender)){
            sb.append(" and gender = ?");
            list.add(gender);
        }

        if (age!=null){
            sb.append(" and age <= ?");
            list.add(age);
        }
        Integer count =null;

        if (list.size()>0){
            count= (Integer) qr.query(sb.toString(), new ScalarHandler(),list.toArray());
        }else {
            count= (Integer) qr.query(sb.toString(), new ScalarHandler());
        }

        return  count==null? -1 : count;
    }

    @Override
    public List<Staff> selectStartList(String staff_name, String gender, Integer age, Integer currentPageNo ,Integer PageSize) throws SQLException {
        QueryRunner qr = DBUtils.DB.getQr();
        StringBuffer sb = new StringBuffer("select * from staff  where  1=1 ");
        ArrayList<Object> list = new ArrayList<>();

        if (staff_name!=null && !"".equals(staff_name)){
            sb.append(" and staff_name = ?");
            list.add(staff_name);
        }

        if (gender!=null&& !"".equals(gender)){
            sb.append(" and gender = ?");
            list.add(gender);
        }

        if (age!=null){
            sb.append(" and age <= ?");
            list.add(age);
        }

        sb.append(" limit ?,?");
        list.add((currentPageNo-1)*PageSize);
        list.add(PageSize);

        List<Staff> staffList = qr.query(sb.toString(), new BeanListHandler<Staff>(Staff.class), list.toArray());
        return staffList;
    }
}
