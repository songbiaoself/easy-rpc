package com.sn.service;

import com.sn.api.ServerApi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 接口实现
 * @Author: songbiao
 */
public class ServerApiImpl implements ServerApi {
    @Override
    public Object callServer(String str) {
        return new String("你好我是服务端");
    }

    @Override
    public Object test1(Object[] args, String str) {
        System.out.println(Arrays.toString(args));
        System.out.println(str);
        return args;
    }

    @Override
    public Object test2(int a, Integer b) {
        return a+b;
    }

    @Override
    public Object test3(Map map) {
        System.out.println(map);
        map.put("back", "你好");
        return map;
    }

    @Override
    public Object test4(HashMap map) {
        System.out.println(map);
        map.put("comment", "多态好像有点问题,试试不是多态");
        return map;
    }
}
