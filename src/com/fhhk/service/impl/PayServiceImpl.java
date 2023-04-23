package com.fhhk.service.impl;

import com.fhhk.dao.OrderDao;
import com.fhhk.dao.PayDao;
import com.fhhk.dao.impl.OrderDaoImpl;
import com.fhhk.dao.impl.PayDaoImpl;
import com.fhhk.entity.Order;
import com.fhhk.entity.Pay;
import com.fhhk.entity.VipUser;
import com.fhhk.service.PayService;

import java.sql.SQLException;
import java.util.List;

public class PayServiceImpl implements PayService {
    //获取dao层
    private OrderDao orderDao = new OrderDaoImpl();
    private PayDao payDao = new PayDaoImpl();

    //计算价格
    @Override
    public Double payPrice(int orderId) {
        //返回给前端的价格
        double price=0;

        //1.查询订单表记录
        List<Order> orderList = null;
        try {
            orderList = orderDao.selectOrderByOrderId(orderId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //得到order对象
        Order order = orderList.get(0);
        //获取order表中元素
        int vipId = order.getVip_id();//会员id
        int customer_id = order.getCustomer_id();//客户id
        double sum_monetary = order.getSum_monetary();//合计消费金额

        //2.会员表的变动
        VipUser vipUser = new VipUser();
        vipUser.setVip_id(vipId);
        VipUser vu = null;
        try {
            //查询会员表记录
            vu = payDao.selectVip(vipUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //获取会员表的 折扣，免费次数，会员余额
        double decimal = vu.getDiscount();
        int free_count = vu.getFree_count();
        double vip_money = vu.getVip_money();
        //计算打折后的价格(合计消费金额*折扣)
        price = sum_monetary*decimal;
        //判断，如果免费次数大于0，则免单，次数-1
        if (free_count>0){
            price=0;
            free_count-=1;
            vu.setFree_count(free_count);
        }else {
            //没有免费次数，则判断会员余额
            if (vip_money>0){
                //价格多于会员余额
                if (price>=vip_money){
                    price = price-vip_money;
                    vu.setVip_money(0);
                }else {
                    //价格少于会员余额，会员余额减少，价格为0
                    vu.setVip_money(vip_money-price);
                    price=0;
                }
            }

        }

        //一、增加支付表
        Pay pay = new Pay();
        pay.setOrderId(orderId);
        pay.setCustomerId(customer_id);
        int payI = 0;
        try {
            payI = payDao.addPay(pay);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (payI>0){
            System.out.println("pay增加成功");
        }else {
            System.out.println("pay增加失败");
        }

        //二、修改订单表
        int orderI = 0;
        try {
            orderI = payDao.updateOrder(order);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (orderI>0){
            System.out.println("order修改成功");
        }else {
            System.out.println("order修改失败");
        }

        //三、修改会员表
        int vipI = 0;
        try {
            vipI = payDao.updateVip(vu);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (vipI>0){
            System.out.println("vip修改成功");
        }else {
            System.out.println("vip修改失败");
        }

        //返回价格
        return price;
    }
}
