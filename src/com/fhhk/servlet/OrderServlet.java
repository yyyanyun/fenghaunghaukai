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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public void  addOrder(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        ResultVo<Boolean> resultVo = new ResultVo<>();

        String date_t = request.getParameter("date_time");
        String sum_monetary = request.getParameter("sum_monetary");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date_time = sdf.parse(date_t);

        int num = orderService.addOrder(date_time, Double.parseDouble(sum_monetary));

        if (num>0){
            resultVo.setCode(200);
            resultVo.setMessage("成功");
            resultVo.setData(true);
        }else {
            resultVo.setCode(500);
            resultVo.setMessage("失败");
            resultVo.setData(false);
        }
    }

    public void  changeOrder(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        ResultVo<Boolean> resultVo = new ResultVo<>();

        String date_t = request.getParameter("date_time");
        String sum_monetary = request.getParameter("sum_monetary");
        String order_status = request.getParameter("order_status");
        String pay_status = request.getParameter("pay_status");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date_time = sdf.parse(date_t);

        int num = orderService.changeOrder(date_time,Double.parseDouble(sum_monetary),Integer.parseInt(order_status),Integer.parseInt(pay_status));

        if (num>0){
            resultVo.setCode(200);
            resultVo.setMessage("成功");
            resultVo.setData(true);
        }else {
            resultVo.setCode(500);
            resultVo.setMessage("失败");
            resultVo.setData(false);
        }
    }

    public void  delOrder(HttpServletRequest request, HttpServletResponse response){
        ResultVo<Boolean> resultVo = new ResultVo<>();

        String order_id = request.getParameter("order_id");

        int num = orderService.delOrder(Integer.parseInt(order_id));

        if (num>0){
            resultVo.setCode(200);
            resultVo.setMessage("成功");
            resultVo.setData(true);
        }else {
            resultVo.setCode(500);
            resultVo.setMessage("失败");
            resultVo.setData(false);
        }
    }
}
