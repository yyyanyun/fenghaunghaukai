package com.fhhk.servlet;

import com.fhhk.service.TrolleyService;
import com.fhhk.service.impl.TrolleyServiceImpl;

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

    }
}
