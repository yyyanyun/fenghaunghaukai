package com.fhhk.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public enum DBUtils {
    DB;
    private QueryRunner qr;
    DBUtils(){
        InputStream is = DBUtils.class.getResourceAsStream("db.properties");
        Properties pro = new Properties();
        DataSource ds = null;
        try {
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        qr = new QueryRunner(ds);
    }
    public QueryRunner getQr(){
        return qr;
    }
}
