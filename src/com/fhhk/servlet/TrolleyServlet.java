package com.fhhk.servlet;

import com.fhhk.entity.Trolley;
import com.fhhk.service.TrolleyService;
import com.fhhk.service.impl.TrolleyServiceImpl;
import com.fhhk.utils.JsonUtils;
import com.fhhk.utils.ResultVo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

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

    /**
     * 根据顾客id查询
     * @param request
     * @param response
     * @throws SQLException
     */
    public void selectTrolley(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));

        List<Trolley> trolleys = trolleyService.selectTrolleyByCustomer_id(customer_id);

        ResultVo<List<Trolley>> resultVo = new ResultVo<>();
        if (trolleys != null && trolleys.size()>0) {
            resultVo.setCode(200);
            resultVo.setMessage("查询成功");
            resultVo.setData(trolleys);
        }else {
            resultVo.setCode(500);
            resultVo.setMessage("查询失败");
            resultVo.setData(null);
        }
        JsonUtils.toJson(resultVo,response);
    }

    /**
     * 根据tid 顾客id删除
     * @param request
     * @param response
     * @throws SQLException
     */
    public void deleteTrolley(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int tid = Integer.parseInt(request.getParameter("tid"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));

        int result = trolleyService.deleteTrolley(tid, customer_id);

        ResultVo<Boolean> resultVo = new ResultVo<>();
        if (result >0) {
            resultVo.setCode(200);
            resultVo.setData(true);
            resultVo.setMessage("删除成功");
        }else {
            resultVo.setCode(500);
            resultVo.setData(false);
            resultVo.setMessage("删除失败");
        }
        JsonUtils.toJson(resultVo,response);

    }
}
