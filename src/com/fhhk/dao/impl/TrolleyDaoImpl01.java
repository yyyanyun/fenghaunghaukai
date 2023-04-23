package com.fhhk.dao.impl;

import com.fhhk.dao.TrolleyDao01;
import com.fhhk.entity.Trolley;
import com.fhhk.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @BelongsProject:fenghaunghaukai
 * @BelongsPackage:com.fhhk.dao.impl
 * @Author:LSL
 * @CreateTime:2023/4/21
 * @Description:TODO
 * @Version: 1.0
 */
public class TrolleyDaoImpl01 implements TrolleyDao01 {
    private QueryRunner qr = DBUtils.DB.getQr();

    /**
     * 查看是否存在
     * @param customer_id
     * @param service_id
     * @return
     */
    @Override
    public Trolley selectTrolleyByExists(Integer customer_id, Integer service_id) throws SQLException {
        String sql = "SELECT * FROM trolley WHERE customer_id=? and service_id=? and order_id is null;";
        Object[] obj = {customer_id,service_id};
        Trolley trolley = qr.query(sql, new BeanHandler<>(Trolley.class), obj);
        return trolley;
    }

    /**
     * 添加购物车
     * @param trolley
     * @return
     */
    @Override
    public int addTrolley(Trolley trolley) throws SQLException {
        String sql = "INSERT INTO trolley(customer_id,service_id,trolley_number) VALUES (?,?,?);";
        Object[] obj = {trolley.getCustomer_id(),trolley.getService_id(),trolley.getTrolley_number()};
        int result = qr.update(sql, obj);
        return result;
    }

    /**
     * 修改
     * @param trolley
     * @return
     * @throws SQLException
     */
    @Override
    public int updateTrolley(Trolley trolley) throws SQLException {

        String sql = "UPDATE trolley SET trolley_number=? WHERE customer_id=? and service_id=? and order_id is null;";
        Object[] obj = {trolley.getTrolley_number(),trolley.getCustomer_id(),trolley.getService_id()};
        int result = qr.update(sql, obj);
        return result;
    }

    @Override
    public List<Trolley> selectTrolleyByCustomer_id(Integer customer_id) throws SQLException {

        String sql = "SELECT * FROM trolley WHERE customer_id=?;";
        List<Trolley> trolleyList = qr.query(sql, new BeanListHandler<Trolley>(Trolley.class), customer_id);
        return trolleyList;
    }

    /**
     * 删除
     * @param tid
     * @param customer_id
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteTrolley(Integer tid,Integer customer_id) throws SQLException {

        String sql = "DELETE FROM trolley WHERE tid=? and customer_id=?;";
        Object[] obj = {tid,customer_id};
        int result = qr.update(sql, obj);
        return result;
    }
}