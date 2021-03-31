package com.sn.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 暴露给客户端的api
 * @Author: songbiao
 */
public interface ServerApi {

    Object callServer(String str);

    Object test1(Object[] args,String str);

    /**
     *  int.class与Integer.class 不匹配
     *  int会被自动装包成Integer 存在问题.
     */
    Object test2(int a,Integer b);

    /**
     *  存在子类无法与父类匹配的问题 多态的一个问题
     * @param map
     * @return
     */
    Object test3(Map map);

    Object test4(HashMap map);

}
