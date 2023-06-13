package com.hzlx.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    static Properties properties = null;
    private PropertiesUtil(){}
    static {
        properties = new Properties();
    }
    /*
    * 将配置文件的数据读取到程序中
    *
    * */
    public static void load(String fileName){

        InputStream resourceAsStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName + ".properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            System.out.println("加载配置文件异常");
            e.printStackTrace();
        }
    }
    public static String getValue(String key){
        return properties.get(key).toString();
    }

}
