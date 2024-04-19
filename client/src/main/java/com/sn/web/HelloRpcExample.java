package com.sn.web;

import com.sn.api.ServerApi;
import com.sn.utils.RPC;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:  web层示例
 * @Author: 公众号: CodeRevolt
 */
public class HelloRpcExample implements IRPCWeb {

    @RPC("ServerApiImpl")
    private ServerApi serverApi;

    @Override
    public void helloRpc(){
        Object result = serverApi.callServer("你好 我是客户端");
        System.out.println(result);

        // 测试1
        serverApi.test1(new String[]{"hello", "rpc"}, "hi");

        // 测试2
        System.out.println(serverApi.test2(10, new Integer(32)));

        // 测试3
        Map map = new HashMap();
        map.put("hi", "rpc");
        System.out.println(serverApi.test3(map));

        // 测试4
        System.out.println(serverApi.test4((HashMap) map));
    }

}
