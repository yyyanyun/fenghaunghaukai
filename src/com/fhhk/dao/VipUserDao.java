package com.fhhk.dao;

import com.fhhk.entity.VipUser;

import java.sql.SQLException;
import java.util.List;

public interface VipUserDao {
   VipUser selectvip(Integer customerid) throws SQLException;
}
