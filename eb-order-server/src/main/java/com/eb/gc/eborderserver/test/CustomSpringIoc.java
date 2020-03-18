package com.eb.gc.eborderserver.test;


import com.eb.gc.eborderserver.service.StorageService;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Author: gc
 * Date: 2020/3/18 14:12
 * Description: 自定义简单springIOC
 */
public class CustomSpringIoc {

    private static ResourceBundle bundle = ResourceBundle.getBundle("bean");//读取bean.properties,只能读取properties文件，只读

    private static Map<String, Object> beans = new HashMap<>();


    static {
        try {
            Enumeration<String> keys = bundle.getKeys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement();
                String beanPath = bundle.getString(key);
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key, value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("容器初始化失败");
        }
    }

    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }


    public static void main(String[] args) {
        StorageService storageService = (StorageService) CustomSpringIoc.getBean("storageService");
        System.out.println(storageService.send(1L).getMsg());
        //传统方式
//        StorageService storageService=new StorageServiceFailure();
//        System.out.println(storageService.send(1L).getMsg());
    }
}
