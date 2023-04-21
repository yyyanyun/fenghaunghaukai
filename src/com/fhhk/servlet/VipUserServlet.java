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
    public void updatetVipUser(HttpServletRequest req, HttpServletResponse resp){
        String customerId = req.getParameter("customer_id");
        String vipLevel = req.getParameter("vip_level");
        String discount = req.getParameter("discount");
        String freeCount = req.getParameter("free_count");
        String vipMoney = req.getParameter("vip_money");
        String vipCreatedate = req.getParameter("vip_createdate");
        VipUser vu=new VipUser();
        vu.setVip_createdate(vipCreatedate);
       vu.setDiscount(Double.parseDouble(discount));
       vu.setVip_level(vipLevel);
       vu.setVip_money(Double.parseDouble(vipMoney));
       vu.setCustomer_id(Integer.parseInt(customerId));
       vu.setFree_count(Integer.parseInt(freeCount));
       VipUseService vi=new VipUserServiceimpl();
       ResultVo<Boolean> re=new ResultVo<>();
        Integer updatevip = vi.updatevip(vu);
        if (updatevip>0) {
            re.setData(true);
            re.setCode(200);
            re.setMessage("成功");

        }else {
            re.setData(false);
            re.setCode(500);
            re.setMessage("失败");
        }
        JsonUtils.toJson(re,resp);


    }
    public void delectVip(HttpServletRequest req, HttpServletResponse resp){
        String tid = req.getParameter("tid");
        VipUseService vs=new VipUserServiceimpl();
        Integer integer = vs.delectVip(tid);
        ResultVo<Boolean> rs=new ResultVo();
        if (integer >0) {
            rs.setCode(200);
            rs.setData(true);
            rs.setMessage("成功");
        }else {
            rs.setMessage("失败");
            rs.setData(false);
            rs.setCode(200);
        }
        JsonUtils.toJson(rs,resp);



    }
}
