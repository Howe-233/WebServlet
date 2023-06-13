package com.hzlx.utils;

import java.sql.*;
import java.util.LinkedList;

public class ConntionPool {
    static int MIN_POOL_NUM;
    static int MAX_POOL_NUM;
    static String DRIVER;
    static String URL;
    static String USERNAME;
    static String PASSWORD;
    private static LinkedList<Connection> connectionPool = new LinkedList<>();

    private static void init() {
        PropertiesUtil.load("jdbc");
        DRIVER = PropertiesUtil.getValue("jdbc.driver");
        URL = PropertiesUtil.getValue("jdbc.url");
        USERNAME = PropertiesUtil.getValue("jdbc.userName");
        PASSWORD = PropertiesUtil.getValue("jdbc.password");
        MIN_POOL_NUM = Integer.parseInt(PropertiesUtil.getValue("jdbc.minPoolNum"));
        MAX_POOL_NUM = Integer.parseInt(PropertiesUtil.getValue("jdbc.maxPoolNum"));
    }

    static {
        init();
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("DRIVER异常");
            e.printStackTrace();
        }
        initConnection();
    }

    private static void initConnection() {
        for (int i = 0; i < MIN_POOL_NUM; i++) {
            try {
                //根据最小连接池数量创建连接，每次发放到连接池最后
                connectionPool.addLast(DriverManager.getConnection(URL, USERNAME, PASSWORD));
            } catch (SQLException e) {
                System.err.println("获取连接异常");
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        //判断连接池是否有可用对象，如果有则取出最上边的没有则返回
        if (connectionPool.size() > 0) {
            return connectionPool.removeFirst();
        } else {

            try {
                return DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                System.err.println("获取连接异常");
                e.printStackTrace();
            }

        }
        return null;
    }

    /*
     * 归还连接方法
     * connection 归还的连接
     * return boolean 归还是否成功
     * */
    private static boolean returnConnection(Connection connection) {
        //判断当前连接池是否到达最大连接数
        if (connectionPool.size() >= MAX_POOL_NUM) {
            try {
                connection.close();
                return true;
            } catch (SQLException e) {

                System.err.println("连接池满时丢弃连接异常");
                e.printStackTrace();
            }
        } else {
            connectionPool.addLast(connection);
            return true;
        }
        return false;
    }

    public static void closeAble(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.err.println("结果集关闭异常");
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.err.println("关闭sql执行器失败");
            }
        }
        if (connection != null) {
            returnConnection(connection);
        }
    }
}
