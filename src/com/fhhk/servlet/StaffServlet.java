package com.fhhk.servlet;


import com.fhhk.entity.Staff;
import com.fhhk.service.StaffService;
import com.fhhk.service.impl.StaffServiceImpI;
import com.fhhk.utils.JsonUtils;
import com.fhhk.utils.PageUtils;
import com.fhhk.utils.ResultVo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(urlPatterns = "/StaffServlet")
public class StaffServlet extends BaseServlet {

    private StaffService staffService = new StaffServiceImpI();


    //添加技师
    public void addStaff(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {


        ResultVo<Staff> resultVo = new ResultVo<>();

        String service_id = request.getParameter("service_id");

        String staff_name = request.getParameter("staff_name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");
        String status = request.getParameter("status");
        String photo = request.getParameter("photo");


        Staff staff = new Staff(staff_name, gender, Integer.parseInt(age), phone, status, photo, Integer.parseInt(service_id));

        int i = staffService.addStaff(staff);
        if (i > 0) {
            resultVo.setCode(200);
            resultVo.setMessage("成功");
            resultVo.setData(staff);

        } else {
            resultVo.setCode(500);
            resultVo.setMessage("失败");
            resultVo.setData(null);
        }

        JsonUtils.toJson(resultVo, response);

    }

    //删除技师
    public void deleteStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        String staff_id = request.getParameter("staff_id");
        int i = staffService.deleteStaff(staff_id);

        ResultVo<Boolean> resultVo = new ResultVo<>();

        if (i > 0) {
            resultVo.setCode(200);
            resultVo.setMessage("删除成功");
            resultVo.setData(true);

        } else {
            resultVo.setCode(500);
            resultVo.setMessage("删除失败");
            resultVo.setData(false);
        }

        JsonUtils.toJson(resultVo, response);
    }

    public void goUpdateStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        ResultVo<Staff> resultVo = new ResultVo<>();

        String staff_id = request.getParameter("staff_id");

        Staff staff = staffService.goUpdateStaff(Integer.parseInt(staff_id));

        if (staff != null) {
            resultVo.setCode(200);
            resultVo.setMessage("成功");
            resultVo.setData(staff);
        } else {
            resultVo.setCode(500);
            resultVo.setMessage("失败");
            resultVo.setData(null);
        }

        JsonUtils.toJson(resultVo, response);


    }

    //修改技师
    public void updateStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ResultVo<Staff> resultVo = new ResultVo<>();

        String staff_id = request.getParameter("staff_id");

        Staff byIdStaff = staffService.selectByIdStaff(Integer.parseInt(staff_id));

        String staff_name = request.getParameter("staff_name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");
        String status = request.getParameter("status");
        String photo = request.getParameter("photo");
        String service_id = request.getParameter("service_id");

        if (byIdStaff != null) {
            if (staff_name == null) {
                staff_name = byIdStaff.getStaff_name();
            } else if (gender == null) {
                gender = byIdStaff.getGender();
            } else if (age == null) {
                age = String.valueOf(byIdStaff.getAge());
            } else if (phone == null) {
                phone = byIdStaff.getPhone();
            } else if (status == null) {
                status = byIdStaff.getStatus();
            } else if (photo == null) {
                photo = byIdStaff.getPhoto();
            } else if (service_id == null) {
                service_id = String.valueOf(byIdStaff.getService_id());
            }
        }

        Staff staff = new Staff(staff_name, gender, Integer.parseInt(age), phone, status, photo, Integer.parseInt(service_id));

        int i = staffService.updateStaff(staff, Integer.parseInt(staff_id));


        if (i > 0) {
            resultVo.setCode(200);
            resultVo.setMessage("修改成功");
            resultVo.setData(staff);
        } else {
            resultVo.setCode(500);
            resultVo.setMessage("修改失败");
            resultVo.setData(null);
        }
        JsonUtils.toJson(resultVo, response);

    }

    public void selectStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ResultVo<Staff> resultVo = new ResultVo<>();

        String staff_id = request.getParameter("staff_id");

        Staff staff = staffService.selectByIdStaff(Integer.parseInt(staff_id));


        if (staff != null) {
            resultVo.setCode(200);
            resultVo.setMessage("成功");
            resultVo.setData(staff);
        } else {
            resultVo.setCode(500);
            resultVo.setMessage("失败");
            resultVo.setData(null);
        }
        JsonUtils.toJson(resultVo, response);

    }



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

    public void selectStartList(HttpServletRequest res , HttpServletResponse resp) throws SQLException {

        //获取前端 数据
        String staff_name = res.getParameter("staff_name");

        String gender = res.getParameter("gender");

        Integer age = null;
        String ageStr = res.getParameter("age");
        String currentPageNo = res.getParameter("currentPageNo");

        String PageSize = res.getParameter("PageSize");

        if (ageStr!=null){
          age = Integer.parseInt(ageStr);
        }

        ResultVo<List<Staff>> resultVo = new ResultVo<>();
        PageUtils<Staff> pageUtils = staffService.selectStartList(staff_name, gender, age, currentPageNo, PageSize);

        if (pageUtils.getList()!=null && pageUtils.getList().size()>0){
            resultVo.setMessage("成功");
            resultVo.setCode(200);
            resultVo.setData(pageUtils.getList());
        }else {
            resultVo.setMessage("失败");
            resultVo.setCode(500);
            resultVo.setData(null);
        }
        JsonUtils.toJson(resultVo,resp);
    }

}
