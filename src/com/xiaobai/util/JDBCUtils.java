package com.xiaobai.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 作者： 小白
 * 日期： 2020/6/28
 * 时间： 21:24
 */
public class JDBCUtils {
    private static ComboPooledDataSource cpds = new ComboPooledDataSource();
    private static Connection connection=null;
    private static QueryRunner queryRunner = null;
    private static  volatile Object obj = "123";
    public static Connection getConnection() {
        try {
            connection = cpds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static QueryRunner getQueryRunner() {
        synchronized (obj) {
            if (queryRunner == null) {
                queryRunner = new QueryRunner();
            }
        }
        return queryRunner;
    }
}
