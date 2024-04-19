package com.sn.main;

import com.sn.proxy.GeneratorProxy;
import com.sn.web.HelloRpcExample;
import com.sn.web.IRPCWeb;

/**
 * @Description: 测试
 * @Author: 公众号: CodeRevolt
 */
public class ClientMain {

    public static void main(String[] args) {
        IRPCWeb web = GeneratorProxy.getProxy(new HelloRpcExample());
        web.helloRpc();
    }

}
