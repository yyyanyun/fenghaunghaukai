package com.fhhk.dao.impl;

import com.fhhk.dao.StaffDao;
import com.fhhk.entity.Staff;
import com.fhhk.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class StaffDaoImpI implements StaffDao {

    private QueryRunner qr = DBUtils.DB.getQr();

    @Override
    //添加技师
    public int addStaff(Staff staff) throws SQLException {
        String sql = "insert into staff (staff_name,gender,age,phone,status,photo,service_id)values (?,?,?,?,?,?,?)";
        Object[] objects = {staff.getStaff_name(), staff.getGender(), staff.getAge(), staff.getPhone()
                , staff.getStatus(), staff.getPhone(), staff.getService_id()};

        int i = qr.update(sql, objects);

        return i;
    }


    //删除技师
    @Override
    public int deleteStaff(String staff_id) throws SQLException {
        String sql = "delete from staff where staff_id in(" + staff_id + ")";

        int i = qr.update(sql);
        return i;
    }

    //去修改技师
    @Override
    public Staff goUpdateStaff(int staff_id) throws SQLException {

        String sql = "select * from staff where staff_id=?";
        Staff staff = qr.query(sql, new BeanHandler<Staff>(Staff.class), staff_id);

        return staff;
    }


    @Override
    //修改技师
    public int updateStaff(Staff staff, int staff_id) throws SQLException {
        String sql = "update staff set staff_name=?,gender=?,age=?,phone=?,status=?,photo=?,service_id=? where staff_id=?";
        Object[] objects = {staff.getStaff_name(), staff.getGender(), staff.getAge(), staff.getPhone()
                , staff.getStatus(), staff.getPhone(), staff.getService_id(), staff_id};
        int i = qr.update(sql, objects);
        return i;
    }

    @Override
    public Staff selectByIdStaff(int staff_id) throws SQLException {
        String sql = "select * from staff where  staff_id =?";
        Staff query = qr.query(sql, new BeanHandler<Staff>(Staff.class), staff_id);
        return query;
    }


}
