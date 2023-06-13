package com.hzlx.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaceDao<T> {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    /**
     * 通用的增删改方法
     * sql; 需要执行的sql语句包含?占位符
     * objects;  占位符对应的行数
     * */
    public int executeUpdate(String sql, Object... objects) {
        int rows = 0;
        try {
            connection = ConntionPool.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            int h = 0;

            for (int i = 0; i < objects.length; i++) {

                if (objects[i] instanceof Object[]) {
                    Object[] o = (Object[]) objects[i];
                    for (int j = 0; j < o.length; j++) {
                        preparedStatement.setObject(h+1, o[j]);
                        h++;
                    }

                } else {
                    preparedStatement.setObject(h+1 , objects[i]);
                    h++;
                }

            }
            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("连接异常");
            e.printStackTrace();
        } finally {
            ConntionPool.closeAble(null, preparedStatement, connection);
        }
        return rows;
    }

    /*
     *
     * 查询单个数据封装为一个对象
     * sql; 执行的sql语句
     * aclass; 封装对象的字节码对象
     * objects; 参数列表
     * */
    public T selectOne(String sql, Class aclass, Object... objects) {
        Object object = null;
        try {
            connection = ConntionPool.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                object = aclass.newInstance();
                //通过对象反射属性
                Field[] fields = aclass.getDeclaredFields();
                //通过属性名调用set方法进行赋值操作
                for (int i = 0; i < fields.length; i++) {
                    String fieldName = fields[i].getName();
                    String old = fieldName.substring(0, 1);
//                    String methodeName = "set" + fieldName.replace(old, old.toUpperCase(Locale.ROOT));
                    String methodeName = "set" + old.toUpperCase() + fieldName.substring(1);
                    Method[] methods = aclass.getMethods();
                    Method method = aclass.getMethod(methodeName, fields[i].getType());
                    method.invoke(object, resultSet.getObject(i + 1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.err.println("实例化失败");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.err.println("未找到set方法");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.err.println("invoke异常");
            e.printStackTrace();
        } finally {
            ConntionPool.closeAble(resultSet, preparedStatement, connection);
        }
        return (T) object;
    }


    /*
     *
     * 查询多个结果-->对象
     *  sql sql语句
     *  clazz 字节码对象
     *  objects 参数列表
     *
     *
     * */
    public List<T> selectListForObject(String sql, Class clazz, Object... objects) {
        List<T> list = null;
        try {
            connection = ConntionPool.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }
            resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
//             通过字段名获取方法的方式
//            while (resultSet.next()){
//                Object obj = clazz.newInstance();
//                List<Method> list1 =getMethodByResultSet(resultSet, MenuInfo.class);
//
//                for (int i = 0; i < list1.size(); i++) {
//                    list1.get(i).invoke(obj,resultSet.getObject(i+1));
//                }
//                list.add((T)obj);
//            }
//通过属性获取方法的方式
            while (resultSet.next()) {
                Object obj = clazz.newInstance();
                Field[] fields = clazz.getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    String name = fields[i].getName();
                    String oldChar = name.substring(0, 1);
                    String methodName = "set" + oldChar.toUpperCase() + name.substring(1);
                    Method method = clazz.getMethod(methodName, fields[i].getType());
                    method.invoke(obj, resultSet.getObject(i + 1));
                }
                list.add((T) obj);
            }
        } catch (SQLException e) {
            System.err.println("数据库连接异常");
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            System.err.println("方法获取失败");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.err.println("赋值失败");
            e.printStackTrace();
        } finally {
            ConntionPool.closeAble(resultSet, preparedStatement, connection);
        }
        return list;
    }


    /*
     *
     * 查询单条数据结果封装到map集合中
     * 适用于超出实体类属性的查询
     * sql sql语句
     * objects 参数列表
     * return 结果集Map
     *
     *
     *
     * */

    public Map<String, Object> selectOneForMap(String sql, Object... objects) {
        Map<String, Object> map = null;
        try {
            connection = ConntionPool.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }
            resultSet = preparedStatement.executeQuery();
            map = new HashMap<>();
            //通过方法过去字段名
            ResultSetMetaData metaData = resultSet.getMetaData();
            //获取结果是的总列数
            int columnCount = metaData.getColumnCount();
            if (resultSet.next()) {
                for (int i = 0; i < columnCount; i++) {
                    //获取到字段的名字别名优先
                    String columnName = metaData.getColumnLabel(i + 1);
                    Object value = resultSet.getObject(columnName);
                    map.put(columnName, value);
                }
            } else {
                throw new RuntimeException("没有找到合适的结果集");
            }
        } catch (SQLException e) {
            System.err.println("数据库连接异常");
            e.printStackTrace();
        } finally {
            ConntionPool.closeAble(resultSet, preparedStatement, connection);
        }
        return map;
    }

    /*
     *
     *
     *
     * */
    public List<Map<String, Object>> selectListForMap(String sql, Class clazz, Object... objects) {
        List<Map<String, Object>> list = null;
        try {
            connection = ConntionPool.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }
            resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i);
                    Object value = resultSet.getObject(columnName);
                    map.put(columnName, value);
                }
                list.add(map);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConntionPool.closeAble(resultSet, preparedStatement, connection);
        }

        return list;
    }

    public static List<Method> getMethodByResultSet(ResultSet resultSet, Class clazz) {
        List<Method> list = new ArrayList<>();
        Field[] declaredFields = clazz.getDeclaredFields();
//        String methodName;
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i);
                String[] columnNameArr = columnName.split("_");//user_name
                StringBuilder newColumnName = new StringBuilder();
                /*for (int i1 = 0; i1 < columnNameArr.length; i1++) {
                    String firstChar = columnNameArr[i1].substring(0, 1);
                    String rightChar = columnNameArr[i1].substring(1);
                    methodName=firstChar.toUpperCase()+rightChar;
                    Method method = clazz.getMethod(methodName, declaredFields[i1].getType());
//                    newColumnName.append("set" + firstChar.toUpperCase() + rightChar);
                    list.add(method);
                }*/

                for (String s : columnNameArr) {
                    String firstChar = s.substring(0, 1);
                    String rightChar = s.substring(1);
                    newColumnName.append(firstChar.toUpperCase() + rightChar);
//                    list.add(clazz.getMethod("set"+firstChar.toUpperCase()+rightChar,declaredFields[i].getType()));
                }
                list.add(clazz.getMethod("set" + newColumnName, declaredFields[i - 1].getType()));
//                list.add(clazz.getMethod(newColumnName[i-1],declaredFields[i].getType()));
            }
        } catch (SQLException e) {
            System.err.println("通过字段获取方法时字段获取异常");
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
