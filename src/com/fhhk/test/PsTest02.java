package com.fhhk.test;

import com.fhhk.dao.PayDao;
import com.fhhk.dao.impl.PayDaoImpl;
import com.fhhk.entity.Order;
import com.fhhk.entity.Pay;
import com.fhhk.entity.VipUser;

import java.sql.SQLException;

public class PsTest02 {
    public static void main(String[] args) throws SQLException {
        PayDao pd = new PayDaoImpl();
        Order od = new Order();
        od.setOrder_id(2);
        int i = pd.updateOrder(od);
        if (i>0){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
    }
}
