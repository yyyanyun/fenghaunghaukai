package com.fhhk.service;

import com.fhhk.entity.Trolley;

import java.sql.SQLException;
import java.util.List;

public interface TrolleyService {
    //添加购物车
    int addTrolley(Trolley trolley);
    //根据顾客id查找购物车详情
    List<Trolley> selectTrolleyByCustomer_id(Integer customer_id) throws SQLException;

    //删除购物车 根据  tid ， customer_id
    int deleteTrolley(Integer tid,Integer customer_id) throws SQLException;
}
