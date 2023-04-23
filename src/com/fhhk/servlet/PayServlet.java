package com.fhhk.servlet;

import com.fhhk.service.PayService;
import com.fhhk.service.impl.PayServiceImpl;
import com.fhhk.utils.JsonUtils;
import com.fhhk.utils.ResultVo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "payServlet", urlPatterns = "/payServlet")
public class PayServlet extends BaseServlet{
    private PayService payService = new PayServiceImpl();

    public void payPrice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取前端数据
        String order_id = request.getParameter("order_id");
        //获取价格
        Double payPrice = payService.payPrice(Integer.parseInt(order_id));
        ResultVo<Double> resultVo = new ResultVo<>();
        //判断价格是否为空
        if (payPrice==null){
            resultVo.setCode(500);
            resultVo.setMessage("支付失败");
            resultVo.setData(null);
        }else {
            resultVo.setCode(200);
            resultVo.setMessage("支付成功");
            resultVo.setData(payPrice);
        }

        JsonUtils.toJson(resultVo,response);
    }
}
