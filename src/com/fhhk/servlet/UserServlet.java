package com.fhhk.servlet;

import com.fhhk.entity.Customer;
import com.fhhk.service.UserService;
import com.fhhk.service.impl.UserServiceImpl;
import com.fhhk.utils.JsonUtils;
import com.fhhk.utils.ResultVo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@WebServlet(name = "userServlet", urlPatterns = "/userServlet")
public class UserServlet extends BaseServlet {
    private final UserService userService = new UserServiceImpl();

    // 生成验证码
    public void checkedCode(HttpServletRequest req, HttpServletResponse resp) {
        // 生成验证码
        String code = userService.checkCode();
        //  获取session
        HttpSession session = req.getSession();
        // 获取结果集
        ResultVo<String> resultVo = new ResultVo<>();
        if (code != null && !"".equals(code)) {
            resultVo.setCode(200);
            resultVo.setMessage("验证码生成成功");
            resultVo.setData(code);
            session.setAttribute("code", code);
        } else {
            resultVo.setCode(500);
            resultVo.setMessage("验证码生成失败");
        }
        // 返回结果
        JsonUtils.toJson(resultVo, resp);
    }

    public void checkLogin(HttpServletRequest req, HttpServletResponse resp) {
        // 获取参数
        String phone = req.getParameter("phone");
        String customer_pwd = req.getParameter("customer_pwd");
        String codeStr = (String) req.getSession().getAttribute("code");
        String code = req.getParameter("code");
        // 获取结果集
        ResultVo<Customer> resultVo = new ResultVo<>();
        // 判断验证码是否正确
        if (codeStr.equals(code)) {
            Customer customer = userService.selectByPhoneAndPwd(phone, customer_pwd);
            if (customer != null) {
                resultVo.setCode(200);
                resultVo.setMessage("登录成功");
                resultVo.setData(customer);
            } else {
                resultVo.setCode(500);
                resultVo.setMessage("用户名或者密码错误");
            }
        } else {
            resultVo.setCode(500);
            resultVo.setMessage("验证码错误");
        }
        // 返回结果
        JsonUtils.toJson(resultVo, resp);
    }
    //检查电话号码是否被注册
    public void checkPhone(HttpServletRequest req, HttpServletResponse resp) {
        // 获取参数
        String phone = req.getParameter("phone");
        // 调用service层
        Customer customer = userService.selectByPhone(phone);
        // 获取结果集
        ResultVo<Boolean> resultVo = new ResultVo<>();
        // 判断是否存在
        if (customer != null){
            resultVo.setCode(500);
            resultVo.setMessage("用户已存在");
            resultVo.setData(false);
        }else {
            resultVo.setCode(200);
            resultVo.setMessage("电话号码未被注册");
            resultVo.setData(true);
        }
        // 返回结果
        JsonUtils.toJson(resultVo,resp);
    }
    //增加用户
    public void addCustomer(HttpServletRequest req, HttpServletResponse resp){
        // 获取参数
        String customer_name = req.getParameter("customer_name");
        String customer_pwd = req.getParameter("customer_pwd");
        String gender = req.getParameter("gender");
        int age = Integer.parseInt(req.getParameter("age"));
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        LocalDateTime customer_date = LocalDateTime.parse(req.getParameter("customer_date"));
        int number = Integer.parseInt(req.getParameter("customer_number"));
        String remark = req.getParameter("remark");
        // 封装对象
        Customer c = new Customer(0,customer_name,customer_pwd,gender,age,phone,address,customer_date,number,remark);
        // 获取结果集
        ResultVo<Boolean> resultVo = new ResultVo<>();
        // 调用service层
        int i = userService.addCustomer(c);
        // 判断是否成功
        if (i>0){
            resultVo.setCode(200);
            resultVo.setMessage("注册成功");
            resultVo.setData(true);
        }else {
            resultVo.setCode(500);
            resultVo.setMessage("注册失败");
            resultVo.setData(false);
        }
        // 返回结果
        JsonUtils.toJson(resultVo,resp);
    }

}