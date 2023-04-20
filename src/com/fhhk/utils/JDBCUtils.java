package com.fhhk.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public enum  JDBCUtils {
      JD;
      public   QueryRunner qr;

      JDBCUtils(){
          try {
              Properties pro  = new Properties();
              //InputStream is = new FileInputStream("src/db.properties");
              InputStream is = JDBCUtils.class.getResourceAsStream("db.properties");
              pro.load(is);
              //获取数据源对象
              DataSource ds = DruidDataSourceFactory.createDataSource(pro);

              qr =new QueryRunner(ds);
             // System.out.println(qr);
          } catch (Exception e) {
              e.printStackTrace();
          }


      }





}
