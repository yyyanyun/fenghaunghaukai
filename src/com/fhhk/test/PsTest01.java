package com.fhhk.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PsTest01 {
    public static void main(String[] args) {
        String str = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        System.out.println(str);
    }
}
