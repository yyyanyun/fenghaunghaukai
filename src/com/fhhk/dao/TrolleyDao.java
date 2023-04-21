package com.fhhk.dao;

import com.fhhk.entity.Trolley;

import java.sql.SQLException;
import java.util.List;

public interface TrolleyDao {
    //查询购物车中是否有该服务 根据customer_id，service_id 查询单条
    Trolley selectTrolleyByExists(Integer customer_id,Integer service_id) throws SQLException;

    //购物车添加服务
    int addTrolley(Trolley trolley) throws SQLException;
    //修改gouwuc
    int updateTrolley(Trolley trolley) throws SQLException;
    //根据顾客id查找

    //删除购物车 根据  tid ， customer_id
    int deleteTrolley(Integer tid,Integer customer_id);
}
