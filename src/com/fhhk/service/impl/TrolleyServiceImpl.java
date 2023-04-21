package com.fhhk.service.impl;

import com.fhhk.dao.TrolleyDao;
import com.fhhk.dao.impl.TrolleyDaoImpl;
import com.fhhk.entity.Trolley;
import com.fhhk.service.TrolleyService;

import java.sql.SQLException;

/**
 * @BelongsProject:fenghaunghaukai
 * @BelongsPackage:com.fhhk.service.impl
 * @Author:LSL
 * @CreateTime:2023/4/21
 * @Description:TODO
 * @Version: 1.0
 */
public class TrolleyServiceImpl implements TrolleyService {
    private TrolleyDao trolleyDao = new TrolleyDaoImpl();
    @Override
    public int addTrolley(Trolley trolley) {
        int customer_id = trolley.getCustomer_id();
        int service_id = trolley.getService_id();
        int result = -1;
        try {
            Trolley exists = trolleyDao.selectTrolleyByExists(customer_id, service_id);
            if (exists == null) {
                //执行增加
                 result = trolleyDao.addTrolley(trolley);
            }else {
                //执行修改
                trolley.setTrolley_number(exists.getTrolley_number()+trolley.getTrolley_number());
                 result = trolleyDao.updateTrolley(trolley);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
