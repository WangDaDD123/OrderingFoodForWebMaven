package com.hzlx.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Description:
 * 解析 properties 的工具类
 *
 * @author: Mr、晓航
 * @Date: 2023/3/13 11:00
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File Templates.
 */
public class PropertiesUtil {
    private Properties properties;
    //加载配置文件
    public PropertiesUtil(String pathName) {
        properties = new Properties();
        InputStream resourceAsStream = this.getClass().getResourceAsStream(pathName);
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据配置文件中的key获取值
     *
     * @param key
     * @return
     */
    public String getPropertyForKey(String key) {
        return properties.getProperty(key);
    }

}
