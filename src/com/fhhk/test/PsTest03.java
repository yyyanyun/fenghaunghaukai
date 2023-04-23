package com.fhhk.test;

import com.fhhk.dao.OrderDao;
import com.fhhk.dao.impl.OrderDaoImpl;
import com.fhhk.entity.Order;
import com.fhhk.entity.VipUser;
import com.fhhk.service.PayService;
import com.fhhk.service.impl.PayServiceImpl;
import com.fhhk.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;

public class PsTest03 {
    public static void main(String[] args) throws SQLException {
        PayService ps = new PayServiceImpl();
        Double aDouble = ps.payPrice(3);
        System.out.println("价格："+aDouble);
    }
}
