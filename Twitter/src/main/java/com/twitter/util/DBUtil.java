package com.twitter.util;


import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class DBUtil {
//    // 数据库用户名
//    private static final String USERNAME = "root";
//    // 数据库密码
//    private static final String PASSWORD = "root";
//    // 驱动信息
//    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//    // 数据库地址
//    private static final String URL = "jdbc:mysql://localhost:3306/mytwitter";


    static Vector<Connection> conPool = new Vector<Connection>();

    static {
        for (int i = 0; i < 20; i++) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytwitter?characterEncoding=utf8&useUnicode=true&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
                conPool.add(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        Connection con = conPool.get(0);
        conPool.remove(0);
        return con;
    }

    public static void releaseConnection(Connection con) {
        conPool.add(con);
    }

    public static List query(Class<?> c, String sql, Object... obj) {
        Connection con = getConnection();
        List<Object> list = new ArrayList<Object>();

        try {
            PreparedStatement pre = con.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                pre.setObject(i + 1, obj[i]);
            }
            ResultSet rs = pre.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();

            while (rs.next()) {
                Object object = c.newInstance();
                for (int i = 1; i <= count; i++) {
                    String filedName = rsmd.getColumnLabel(i);
                    Field field = c.getDeclaredField(filedName);
                    field.setAccessible(true);
                    field.set(object, rs.getObject(i));
                }
                list.add(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            releaseConnection(con);
        }
        return list;
    }
    /**
     * 执行更新、插入、删除等操作
     * @param sql
     * @param obj
     * @return 返回值是操作影响的行数(即更新、插入或删除了几条数据)
     */
    public static int update(String sql, Object[] obj) {

        int n = 0;
        Connection con = getConnection();
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                pre.setObject(i + 1, obj[i]);
            }
            n = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            releaseConnection(con);
        }
        return n;
    }


}
