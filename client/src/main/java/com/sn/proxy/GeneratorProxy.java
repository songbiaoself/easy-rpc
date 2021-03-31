package com.sn.proxy;

import com.sn.utils.RPC;

import java.lang.reflect.Proxy;

/**
 * @Description: 生成代理类
 * @Author: songbiao
 */
public class GeneratorProxy {

    public static Object getRPCProxy(Class object, RPC rpc){
        //idea debug 模式会有意想不到的bug
        Object proxy = Proxy.newProxyInstance(
                  object.getClassLoader()//指定类的加载器
                , new Class[]{object} // 代理需要实现的接口，可指定多个，这是一个数组
                , new RPCProxy(rpc)); // 代理对象处理器
        return proxy;
    }

    public static Object getProxy(Object object){
        Object proxy = Proxy.newProxyInstance(
                 object.getClass().getClassLoader()//指定类的加载器
                ,object.getClass().getInterfaces() // 代理需要实现的接口，可指定多个，这是一个数组
                , new TargetProxy(object)); // 代理对象处理器
        return proxy;
    }

}
