package com.sn.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 暴露给客户端的api
 * @Author: 公众号: CodeRevolt
 */
public interface ServerApi {

    Object callServer(String str);

    Object test1(Object[] args,String str);

    Object test2(int a,Integer b);

    Object test3(Map map);

    Object test4(HashMap map);

}
