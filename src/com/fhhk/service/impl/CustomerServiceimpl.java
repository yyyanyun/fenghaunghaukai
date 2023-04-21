package com.fhhk.service.impl;

import com.fhhk.dao.CustomerDao;
import com.fhhk.dao.impl.CustomerDaoimpl;
import com.fhhk.entity.Customer;
import com.fhhk.service.CustomerService;
import com.fhhk.utils.PageUtils;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceimpl implements CustomerService {
    private CustomerDao customerDao=new CustomerDaoimpl();
    @Override
    public Customer selectCustomerbycid(int cid) {
        try {
            return customerDao.selectCustomerbycid(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCustomercount(int cid) {
        try {
            return customerDao.selectCustomercount(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int updateCustomer(Customer customer) {

        try {
            return customerDao.updateCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int deleteCustomer(String cid) {
        try {
            return customerDao.deleteCustomer(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  -1;
    }

    @Override
    public PageUtils<Customer> selectCustomerpage(String name, String startTime, String endTime, String currentPageNOStr, String pageSizeStr) {
        PageUtils pageUtils=new PageUtils();
        Integer currentPageNo=1;
        if(currentPageNOStr!=null&&"".equals(currentPageNOStr)){
            currentPageNo = Integer.parseInt(currentPageNOStr);
        }
        Integer  pageSize=5;
        if(pageSizeStr!=null&&"".equals(pageSizeStr)){
            pageSize=Integer.parseInt(pageSizeStr);
        }
        Integer totalPageCount= null;
        Integer totalPageSize=null;
        List<Customer> list=null;
        try {
            totalPageCount = customerDao.selectCustomercount(name, startTime, endTime);
            totalPageSize=totalPageCount%pageSize==0?totalPageCount/pageSize:totalPageCount/pageSize+1;
            list = customerDao.selectCustomerList(name, startTime, endTime, currentPageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pageUtils.setList(list);
        pageUtils.setTotalPageCount(totalPageCount);
        pageUtils.setTotalPageSize(totalPageSize);
        pageUtils.setCurrentPageNo(currentPageNo);
        pageUtils.setPageSize(pageSize);
        return pageUtils;
    }
}


