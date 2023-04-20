package com.fhhk.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonUtils {
    public static void toJson(ResultVo resultVo, HttpServletResponse resp){
        PrintWriter pw = null;
        try {
            pw = resp.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String s = JSON.toJSONString(resultVo);
        pw.print(s);
        pw.flush();
        pw.close();
    }
}
