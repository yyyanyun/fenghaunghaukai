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
        try {
            return trolleyDao.addTrolley(trolley);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
