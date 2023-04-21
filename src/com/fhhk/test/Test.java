package com.fhhk.test;

import com.fhhk.entity.Customer;
import com.fhhk.service.CustomerService;
import com.fhhk.service.impl.CustomerServiceimpl;

public class Test {


    public static void main(String[] args) {
         CustomerService customerService=new CustomerServiceimpl();
        Customer customer = customerService.selectCustomerbycid(1);
        System.out.println(customer.toString());
    }
}
