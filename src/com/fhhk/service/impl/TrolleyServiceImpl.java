package com.fhhk.service.impl;

import com.fhhk.dao.ServiceDao01;
import com.fhhk.dao.TrolleyDao01;
import com.fhhk.dao.impl.ServiceDaoImpl01;
import com.fhhk.dao.impl.TrolleyDaoImpl01;
import com.fhhk.entity.Service;
import com.fhhk.entity.Trolley;
import com.fhhk.service.TrolleyService;

import java.sql.SQLException;
import java.util.List;

/**
 * @BelongsProject:fenghaunghaukai
 * @BelongsPackage:com.fhhk.service.impl
 * @Author:LSL
 * @CreateTime:2023/4/21
 * @Description:TODO
 * @Version: 1.0
 */
public class TrolleyServiceImpl implements TrolleyService {
    private TrolleyDao01 trolleyDao = new TrolleyDaoImpl01();
    private ServiceDao01 serviceDao = new ServiceDaoImpl01();
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

    /**
     * 查看当前用户的购物车信息
     * @param customer_id
     * @return
     * @throws SQLException
     */
    @Override
    public List<Trolley> selectTrolleyByCustomer_id(Integer customer_id) throws SQLException {
        List<Trolley> trolleyList = null;
        try {
            trolleyList = trolleyDao.selectTrolleyByCustomer_id(customer_id);
            trolleyList.forEach(trolley -> {
                int service_id = trolley.getService_id();
                Service service = null;
                try {
                    //查询服务
                    service = serviceDao.selectByService_id(service_id);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                trolley.setService(service);
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trolleyList;
    }

    /**
     * 删除当前用户的购物车信息
     * @param tid
     * @param customer_id
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteTrolley(Integer tid, Integer customer_id) throws SQLException {
        int result = 0;
        try {
            result = trolleyDao.deleteTrolley(tid, customer_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
