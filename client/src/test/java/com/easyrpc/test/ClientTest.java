package com.easyrpc.test;

import com.sn.proxy.GeneratorProxy;
import com.sn.web.HelloRpcExample;
import com.sn.web.IRPCWeb;
import org.junit.Test;

/**
 * @Description: 测试单元
 * @Author: 公众号: CodeRevolt
 */
public class ClientTest {

    private IRPCWeb web = (IRPCWeb) GeneratorProxy.getProxy(new HelloRpcExample());

}
