package com.sn.main;

import com.sn.proxy.GeneratorProxy;
import com.sn.web.HelloRpcExample;
import com.sn.web.IRPCWeb;

/**
 * @Description: 测试
 * @Author: songbiao
 */
public class ClientMain {

    public static void main(String[] args) {
        //生成的代理类必须实现接口 接口接收
        IRPCWeb web = (IRPCWeb) GeneratorProxy.getProxy(new HelloRpcExample());
        web.helloRpc();
    }

}
