package com.fhhk.service.impl;

import com.fhhk.dao.VipUserDao;
import com.fhhk.dao.impl.VipUserDaoimpl;
import com.fhhk.entity.VipUser;
import com.fhhk.service.VipUseService;
import java.sql.SQLException;
public class VipUserServiceimpl implements VipUseService {

    @Override
    public VipUser selectvip(Integer customerid) {
        VipUserDao vus=new VipUserDaoimpl();
        VipUser selectvip = null;
        try {
            selectvip = vus.selectvip(customerid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return selectvip;
    }
}
