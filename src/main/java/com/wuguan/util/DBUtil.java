package com.wuguan.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * @author MFMG
 * @data 2022/01/14 17:47
 * @description
 */
public class DBUtil {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    private static BasicDataSource bds;
    private static int initialSize;
    private static int maxTotal;
    private static int maxIdle;
    private static int minIdle;
    private static long maxWaitMillis;

    static{
        init();
    }

    public static void init() {
        try{
            bds = new BasicDataSource();
            Properties properties = System.getProperties();
            properties.load(new FileInputStream("F:\\Documents\\AMuFeng\\Java\\wuguan\\src\\main\\resources\\jdbc.properties"));
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("username");
            password = properties.getProperty("password");

            initialSize = Integer.parseInt(properties.getProperty("initialSize"));
            maxTotal = Integer.parseInt(properties.getProperty("maxTotal"));
            maxIdle = Integer.parseInt(properties.getProperty("maxIdle"));
            minIdle = Integer.parseInt(properties.getProperty("minIdle"));
            maxWaitMillis = Long.parseLong(properties.getProperty("maxWaitMillis"));

            bds.setDriverClassName(driver);
            bds.setUrl(url);
            bds.setUsername(user);
            bds.setPassword(password);
            bds.setInitialSize(initialSize);
            bds.setMaxTotal(maxTotal);
            bds.setMaxIdle(maxIdle);
            bds.setMinIdle(minIdle);
            bds.setMaxWaitMillis(maxWaitMillis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (bds == null || bds.isClosed()) {
            init();
        }
        return bds.getConnection();
    }

    public static void close(Connection conn,
                             PreparedStatement ps, ResultSet rs){
        try {
            if(conn != null) {
                conn.close();
            }
            if(ps != null) {
                ps.close();
            }
            if(rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static boolean executeUpdate(Connection conn, String sql,Object...obj) throws Exception{
        PreparedStatement ps = conn.prepareStatement(sql);
        for(int i=1;i<=obj.length;i++){
            ps.setObject(i, obj[i-1]);
        }
        int i = ps.executeUpdate();
        return i > 0;
    }
    public static <T> List<T> queryList(CallBack<T> call, String sql, Object...obj) throws Exception{
        PreparedStatement ps = getConnection().prepareStatement(sql);
        for(int i=1;i<=obj.length;i++){
            ps.setObject(i, obj[i-1]);
        }
        ResultSet rs = ps.executeQuery();
        return call.getDatas(rs);
    }

    public static <T> T queryOne(CallBack<T> call,String sql,Object...obj) throws SQLException{
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        for(int i=1;i<=obj.length;i++){
            ps.setObject(i, obj[i-1]);
        }
        ResultSet rs = ps.executeQuery();
        return call.getData(rs);
    }

    public static abstract class CallBack<T>{
        public List<T> getDatas(ResultSet rs){
            return null;
        }

        public T getData(ResultSet rs){
            return null;
        }
    }
}
