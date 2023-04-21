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

@WebServlet(name = "userServlet", urlPatterns = "/userServlet")
public class UserServlet extends BaseServlet{
    private final UserService userService = new UserServiceImpl();
    // 生成验证码
    public void checkedCode(HttpServletRequest req , HttpServletResponse resp) {
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
        JsonUtils.toJson(resultVo, resp);
    }
    public void checkLogin(HttpServletRequest req , HttpServletResponse resp){
        // 获取参数
        String phone = req.getParameter("phone");
        String customer_pwd = req.getParameter("customer_pwd");
        String codeStr = (String) req.getSession().getAttribute("code");
        String code = req.getParameter("code");
        // 获取结果集
        ResultVo<Customer> resultVo = new ResultVo<>();
        // 判断验证码是否正确
        if (codeStr.equals(code)){
            Customer customer = userService.selectByPhoneAndPwd(phone, customer_pwd);
            if (customer != null){
                resultVo.setCode(200);
                resultVo.setMessage("登录成功");
                resultVo.setData(customer);
            }else {
                resultVo.setCode(500);
                resultVo.setMessage("用户名或者密码错误");
            }
        }else {
            resultVo.setCode(500);
            resultVo.setMessage("验证码错误");
        }
        JsonUtils.toJson(resultVo,resp);

    }

}
