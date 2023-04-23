package com.fhhk.dao;

import com.fhhk.entity.Order;
import com.fhhk.entity.Pay;
import com.fhhk.entity.VipUser;

import java.sql.SQLException;

public interface PayDao {
    //根据order表获取客户id、订单id来增加支付表
    int addPay(Pay pay) throws SQLException;

    //修改order表的 完成时间+订单状态
    int updateOrder(Order order) throws SQLException;

    //查询vip表
    VipUser selectVip(VipUser vipUser) throws SQLException;
    //修改VIP表
    int updateVip(VipUser vipUser) throws SQLException;
}
