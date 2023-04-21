package com.fhhk.dao.impl;

import com.fhhk.dao.VipUserDao;
import com.fhhk.entity.VipUser;
import com.fhhk.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class VipUserDaoimpl implements VipUserDao {
    @Override
    public VipUser selectvip(Integer customerid) throws SQLException {
        QueryRunner qr = JDBCUtils.JD.qr;
        String sql="SELECT c.customer_name ,v.* FROM vip_privilege v INNER JOIN customer c ON v.customer_id=c.customer_id WHERE c.customer_id=?";
        VipUser query = qr.query(sql, new BeanHandler<VipUser>(VipUser.class) ,customerid);
        return query;
    }
}
