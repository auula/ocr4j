package com.github.JDode.JTesseract.utils;

import java.io.*;
import java.util.Properties;

/**
 * Created by Ding on 2019/3/28 7:07 PM.
 *
 * @Description:  Properties util
 * <p>
 * <a href="https://github.com/JDode">to see GitHub</a>
 */
public class PropertiesUtil {

    private Properties properties;

    public String url;


    public PropertiesUtil build(String uri) {
        this.url = url;
        this.properties = this.properties == null ? new Properties() : this.properties;
        return this;
    }

    //获取相应key的内容
    public String getProperty(String key) {
        if (inputFile() == null) {
            new RuntimeException("配置文件读取异常！");
        }
        return inputFile().getProperty(key);
    }


    //读取配置文件
    private Properties inputFile() {
        // 使用InPutStream流读取properties文件
        try {
            // 通过输入缓冲流进行读取配置文件
            InputStream inputStream = new BufferedInputStream(new FileInputStream(new File(this.url)));
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


//    public <T>T  builder(T t)throws Exception{
//        //通过泛型获取对应类的属性然后封装成一个相应对象返回
//        Field[] declaredFields = t.getClass().getDeclaredFields();
//
//            String name = declaredFields[0].getName();
//            System.out.println(name);
//
//            Method[] declaredMethods = t.getClass().getDeclaredMethods();
//            System.out.println(declaredMethods[0].getName());
//        Class<?> aClass = t.getClass();
//        aClass.getMethod("get"+getMethodName(declaredFields[0].getName()));
//        if (declaredMethods[0].getName().equals("get"+name)){
//                System.out.println("ok");
//            }
//
//
//
//
//        return null;
//    }

    // 把一个字符串的第一个字母大写、效率是最高的、
    private static String getMethodName(String fildeName) throws Exception{
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }
}
