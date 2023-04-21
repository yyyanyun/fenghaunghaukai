package com.fhhk.servlet;

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
        String code = userService.checkCode();
        HttpSession session = req.getSession();
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
}
