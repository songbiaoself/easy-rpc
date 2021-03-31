package com.easyrpc.test;

import com.sn.proxy.GeneratorProxy;
import com.sn.web.HelloRpcExample;
import com.sn.web.IRPCWeb;
import org.junit.Test;

/**
 * @Description: 测试单元
 * @Author: songbiao
 */
public class ClientTest {

    private IRPCWeb web = (IRPCWeb) GeneratorProxy.getProxy(new HelloRpcExample());

    /**
     * 数组测试没有问题
     */
    @Test
    public void test1() {
        web.test1();
    }


    /**
     * 存在包装类问题
     */
    @Test
    public void test2() {
        web.test2();
    }

    /**
     *  存在多态问题
     */
    @Test
    public void test3() {
        web.test3();
    }

    /**
     * 正常
     */
    @Test
    public void test4() {
        web.test4();
    }
}
