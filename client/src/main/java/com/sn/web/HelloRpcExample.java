package com.sn.web;

import com.sn.api.ServerApi;
import com.sn.service.ServerApiImpl;
import com.sn.utils.RPC;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:  web层示例
 * @Author: songbiao
 */
public class HelloRpcExample implements IRPCWeb {

    @RPC(type = ServerApiImpl.class)
    private ServerApi serverApi;

    public void helloRpc(){
        Object result = serverApi.callServer("你好 我是客户端");
        if (result != null) {
            System.out.println(result.toString());
        }
    }

    @Override
    public void test1() {
        System.out.println(serverApi.test1(new Object[]{new String("123"),1},"数组测试"));
    }

    public void test2() {
        System.out.println(serverApi.test2(1, 10));
    }

    @Override
    public void test3() {
        Map map = new HashMap();
        map.put("宋标", "永远的神");
        System.out.println(serverApi.test3(map));
    }

    @Override
    public void test4() {
        HashMap map = new HashMap();
        map.put("宋标", "暂时的神");
        System.out.println(serverApi.test4(map));
    }


}
