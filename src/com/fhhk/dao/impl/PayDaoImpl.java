package com.fhhk.dao.impl;

import com.fhhk.dao.PayDao;
import com.fhhk.entity.Order;
import com.fhhk.entity.Pay;
import com.fhhk.entity.VipUser;
import com.fhhk.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PayDaoImpl implements PayDao {
    QueryRunner qr = DBUtils.DB.getQr();

    @Override
    public int addPay(Pay pay) throws SQLException {
        String sql = "insert into pay(customer_id,order_id) value (?,?)";
        Object[] obj = {pay.getCustomerId(),pay.getOrderId()};
        int i = qr.update(sql, obj);
        return i;
    }

    @Override
    public int updateOrder(Order order) throws SQLException {
        String endTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        //完成时间+订单状态
        String sql = "update `order` set end_time=?,order_status=? where order_id=?";
        Object[] obj = {endTime,"已完成",order.getOrder_id()};
        int i = qr.update(sql,obj);
        return i;
    }

    //VIP表
    @Override
    public VipUser selectVip(VipUser vipUser) throws SQLException {
        String sql = "select * from vip_privilege where vip_id=?;";
        VipUser vu = qr.query(sql, new BeanHandler<>(VipUser.class), vipUser.getVipId());
        return vu;
    }

    @Override
    public int updateVip(VipUser vipUser) throws SQLException {
        String sql = "update vip_privilege set free_count=?,vip_money=? where vip_id=?";
        Object[] obj = {vipUser.getFree_count(),vipUser.getVip_money(),vipUser.getVipId()};
        int i = qr.update(sql, obj);
        return i;
    }
}
