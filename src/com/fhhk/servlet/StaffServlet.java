package com.fhhk.servlet;

import com.fhhk.dao.StaffDao;
import com.fhhk.dao.impl.StaffDaoImpl;
import com.fhhk.entity.Staff;
import com.fhhk.service.StaffService;
import com.fhhk.service.impl.StaffServiceImpl;
import com.fhhk.utils.JsonUtils;
import com.fhhk.utils.ResultVo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "staffServlet" ,urlPatterns = "/staffServlet")
public class StaffServlet extends BaseServlet{

    private StaffService staffService =  new StaffServiceImpl();

    /**
     * 重新所有的 技师 信息
     * @param res
     * @param resp
     */
    public void selectAllStaff(HttpServletRequest res , HttpServletResponse resp){

        ResultVo<List<Staff>> listResultVo = new ResultVo<>();
        //调用service 层的方法
        List<Staff> staffList = staffService.selectAllStaff();

        if (staffList!=null && staffList.size()>0){
            listResultVo.setCode(200);
            listResultVo.setMessage("成功");
            listResultVo.setData(staffList);
        }else {
            listResultVo.setCode(500);
            listResultVo.setMessage("失败");
            listResultVo.setData(null);
        }

        JsonUtils.toJson(listResultVo,resp);

    }

    /**
     * 根据 技师 id 查询 信息
     * @param res
     * @param resp
     */
    public void selectStaffByID(HttpServletRequest res , HttpServletResponse resp){

        ResultVo<Staff> listResultVo = new ResultVo<>();

        //获取前端数据
        String staff_id = res.getParameter("staff_id");
        //调用service 层的方法
        Staff staffList = staffService.selectByStaff_id(Integer.parseInt(staff_id));

        if (staffList!=null){
            listResultVo.setCode(200);
            listResultVo.setMessage("成功");
            listResultVo.setData(staffList);
        }else {
            listResultVo.setCode(500);
            listResultVo.setMessage("失败");
            listResultVo.setData(null);
        }

        JsonUtils.toJson(listResultVo,resp);
    }


}
