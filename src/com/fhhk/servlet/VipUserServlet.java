package com.fhhk.servlet;

import com.fhhk.entity.VipUser;
import com.fhhk.service.VipUseService;
import com.fhhk.service.impl.VipUserServiceimpl;
import com.fhhk.utils.JsonUtils;
import com.fhhk.utils.ResultVo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@WebServlet(name = "vipUserServlet" ,urlPatterns = "/vipUserServlet")
public class VipUserServlet extends BaseServlet{

    public void selectVipUser(HttpServletRequest req, HttpServletResponse resp){
        String customerid = req.getParameter("customerid");
        VipUseService vip=new VipUserServiceimpl();
        VipUser selectvip = vip.selectvip(Integer.parseInt(customerid));
        ResultVo<VipUser> rs=new ResultVo<>();
        if (selectvip != null) {
            rs.setCode(200);
            rs.setData(selectvip);
            rs.setMessage("成功");
        }else {
            rs.setCode(500);
            rs.setData(null);
            rs.setMessage("失败");
        }
        JsonUtils.toJson(rs,resp);
    }
}
