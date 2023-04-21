package com.fhhk.servlet;


import com.fhhk.dao.ServiceDao;
import com.fhhk.entity.Service;
import com.fhhk.entity.Staff;
import com.fhhk.service.ServiceService;
import com.fhhk.service.impl.ServiceServiceImpl;
import com.fhhk.utils.JsonUtils;
import com.fhhk.utils.ResultVo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "serviceServlet", urlPatterns = "/serviceServlet")
public class ServiceServlet extends BaseServlet {
    private ServiceService service = new ServiceServiceImpl();

    /**
     * 展示 所有 套餐
     * @param res
     * @param resp
     */
    public void selectAllService(HttpServletRequest res, HttpServletResponse resp) {

        ResultVo<List<Service>> listResultVo = new ResultVo<>();
        List<Service> services = service.selectAllService();
        if (services != null && services.size() > 0) {
            listResultVo.setData(services);
            listResultVo.setCode(200);
            listResultVo.setMessage("成功");
        } else {
            listResultVo.setData(null);
            listResultVo.setCode(500);
            listResultVo.setMessage("失败");
        }


        JsonUtils.toJson(listResultVo, resp);
    }

    /**
     * 根据id  查询 所有 套餐
     * @param res
     * @param resp
     */
    public void selectServiceByID(HttpServletRequest res, HttpServletResponse resp) {

        //获取前端数据
        String service_id = res.getParameter("service_id");
        Service service = this.service.selectServiceByID(Integer.parseInt(service_id));
        ResultVo<Service> resultVo = new ResultVo<>();

        if (service != null) {
            resultVo.setData(service);
            resultVo.setCode(200);
            resultVo.setMessage("成功");
        } else {
            resultVo.setData(null);
            resultVo.setCode(500);
            resultVo.setMessage("失败");
        }

        JsonUtils.toJson(resultVo, resp);
    }
}
