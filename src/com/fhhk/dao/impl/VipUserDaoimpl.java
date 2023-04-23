package com.fhhk.dao.impl;

import com.fhhk.dao.VipUserDao;
import com.fhhk.entity.VipUser;
import com.fhhk.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class VipUserDaoimpl implements VipUserDao {
    @Override
    public VipUser selectvip(Integer customerid) throws SQLException {
        QueryRunner qr = JDBCUtils.JD.qr;
        String sql="SELECT c.customer_name ,v.* FROM vip_privilege v INNER JOIN customer c ON v.customer_id=c.customer_id WHERE c.customer_id=?";
        VipUser query = qr.query(sql, new BeanHandler<VipUser>(VipUser.class) ,customerid);
        return query;
    }

    @Override
    public Integer updatevip(VipUser vipUser) throws SQLException {
        QueryRunner qr = JDBCUtils.JD.qr;
        String sql="UPDATE vip_privilege SET vip_level=?,discount=?,free_count=?,vip_money=?,vip_createdate=? WHERE customer_id=?";
        Object[]o={vipUser.getVip_level(),vipUser.getDiscount(),vipUser.getFree_count(),vipUser.getVip_money(),vipUser.getVip_createdate(),vipUser.getCustomer_id()} ;
        int update = qr.update(sql, o);
        return update;
    }

    @Override
    public Integer delectVip(String tid) throws SQLException {
        QueryRunner qr = JDBCUtils.JD.qr;
            String sql="DELETE FROM customer WHERE customer_id IN "+"("+tid+")";
        int update = qr.update(sql);
        return update;
    }
}
