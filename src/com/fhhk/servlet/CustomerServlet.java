package com.fhhk.servlet;
import com.fhhk.entity.Customer;
import com.fhhk.service.CustomerService;
import com.fhhk.service.impl.CustomerServiceimpl;
import com.fhhk.utils.JsonUtils;
import com.fhhk.utils.ResultVo;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/customerServlet")
public class CustomerServlet extends BaseServlet {
    private CustomerService customerService=new CustomerServiceimpl();
    public void selectCustomerbycid(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String customer_id = req.getParameter("customer_id");
        int cid=-1;
        if(customer_id!=null) {
            cid = Integer.parseInt(customer_id);
        }
        Customer customer = customerService.selectCustomerbycid(cid);
//        System.out.println(customer);
        ResultVo<Customer> resultVo=new ResultVo<>();
        if(customer!=null&&!"".equals(customer)){
            resultVo.setCode(200);
            resultVo.setMessage("成功");
            resultVo.setData(customer);
        }else {
            resultVo.setCode(500);
            resultVo.setMessage("失败");
            resultVo.setData(null);
        }
        JsonUtils.toJson(resultVo,resp);
    }
    public void updateCustomer(HttpServletRequest req,HttpServletResponse resp){
        String customer_id = req.getParameter("customer_id");
        String customer_name = req.getParameter("customer_name");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");
        String phone = req.getParameter("phone");
        String customer_pwd = req.getParameter("customer_pwd");
        String remark = req.getParameter("remark");
//        String customer_date = req.getParameter("customer_date");
//        String customer_number = req.getParameter("customer_number");
        String address = req.getParameter("address");
        Customer customer=new Customer();
        customer.setCustomer_id(Integer.parseInt(customer_id));
        customer.setCustomer_name(customer_name);
        customer.setGender(gender);
        customer.setAge(Integer.parseInt(age));
        customer.setPhone(phone);
        customer.setCustomer_pwd(customer_pwd);
        customer.setRemark(remark);
//        customer.setCustomer_date(new Date());
        int i = customerService.selectCustomercount(Integer.parseInt(customer_id));
        customer.setCustomer_number(i);
        customer.setAddress(address);
        System.out.println(customer);
        int i1 = customerService.updateCustomer(customer);
        ResultVo<Customer> resultVo=new ResultVo<>();
        if(i1>0){
            resultVo.setCode(200);
            resultVo.setMessage("成功");
            resultVo.setData(customer);
        }else {
            resultVo.setCode(500);
            resultVo.setMessage("失败");
            resultVo.setData(null);
        }
        JsonUtils.toJson(resultVo,resp);

    }
}
