package com.sn.test;

import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @Description: invoke与动态调用比较
 * @Author: 公众号: CodeRevolt
 */
public class InvokerThanDynamic {

    static class ClassA{

        public String test(int a, Map map) {
            System.out.println(a);
            map.put("key",a);
            return map.toString();
        }

    }

    /**
     * 是否支持包装类和多态测试
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void test() throws Throwable {
        //反射调用
        Class clazz = ClassA.class;
        Method test = clazz.getMethod("test", int.class, Map.class);
//        test.invoke(new Integer(123), new HashMap<>());

        //动态调用 可以支持多态也可以支持包装 舒服了
        MethodType methodType = MethodType.methodType(String.class, int.class, Map.class);
        MethodHandle mt = lookup().findVirtual(ClassA.class, "test", methodType);
        Object invoke = mt.invoke(clazz.newInstance(), new Integer(123), new HashMap<>());
        System.out.println(invoke);
    }

}
