package com.fhhk.servlet;

import com.fhhk.entity.Trolley;
import com.fhhk.service.TrolleyService;
import com.fhhk.service.impl.TrolleyServiceImpl;
import com.fhhk.utils.JsonUtils;
import com.fhhk.utils.ResultVo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @BelongsProject:fenghaunghaukai
 * @BelongsPackage:com.fhhk.servlet
 * @Author:LSL
 * @CreateTime:2023/4/21
 * @Description:TODO
 * @Version: 1.0
 */
@WebServlet(name = "trolleyServlet",urlPatterns = "/trolleyServlet")
public class TrolleyServlet extends BaseServlet{
    private TrolleyService trolleyService = new TrolleyServiceImpl();
    /**
     * 添加购物车
     * @param request
     * @param response
     */
    public void addTrolley(HttpServletRequest request, HttpServletResponse response){
        //获取前端数据
        String customer_id = request.getParameter("customer_id");
        String service_id = request.getParameter("service_id");
        String trolley_number = request.getParameter("trolley_number");
        //封装成购物车对象
        Trolley trolley = new Trolley();
        trolley.setCustomer_id((customer_id==null ||"".equals(customer_id))?null:Integer.parseInt(customer_id));
        trolley.setService_id((service_id==null ||"".equals(service_id))?null:Integer.parseInt(service_id));
        trolley.setTrolley_number((trolley_number==null ||"".equals(trolley_number))?1:Integer.parseInt(trolley_number));

        int result = trolleyService.addTrolley(trolley);
        //实例化结果集
        ResultVo<Boolean> resultVo = new ResultVo<>();
        if (result>0){
            resultVo.setCode(200);
            resultVo.setData(true);
            resultVo.setMessage("成功");
        }else {
            resultVo.setCode(500);
            resultVo.setData(false);
            resultVo.setMessage("失败");
        }
        //转Json
        JsonUtils.toJson(resultVo,response);


    }
}
