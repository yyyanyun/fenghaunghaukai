package com.fhhk.dao;

import com.fhhk.entity.VipUser;

import java.sql.SQLException;
import java.util.List;

public interface VipUserDao {
   VipUser selectvip(Integer customerid) throws SQLException;
   Integer updatevip(VipUser vipUser) throws SQLException;
   Integer delectVip(String tid) throws SQLException;
}
