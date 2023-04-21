package com.fhhk.servlet;

import com.fhhk.entity.Order;
import com.fhhk.service.OrderService;
import com.fhhk.service.impl.OrderServiceImpl;
import com.fhhk.utils.JsonUtils;
import com.fhhk.utils.ResultVo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "orderServlet",urlPatterns = "/orderServlet")
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    public void selectOrder(HttpServletRequest request, HttpServletResponse response){
        ResultVo<List<Order>> resultVo = new ResultVo<>();

        //获取前端传递的order_id
        String order_id = request.getParameter("order_id");
        //调用service层的方法
        List<Order> orderList = orderService.selectByOrderId(Integer.parseInt(order_id));
        if (orderList != null && orderList.size() > 0){
            resultVo.setCode(200);
            resultVo.setMessage("成功");
            resultVo.setData(orderList);
        }else {
            resultVo.setCode(500);
            resultVo.setMessage("失败");
            resultVo.setData(null);
        }

        JsonUtils.toJson(resultVo,response);
    }
}
