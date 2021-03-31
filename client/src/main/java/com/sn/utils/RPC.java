package com.sn.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RPC {

    //指定服务端实现类
    Class type();

    String IP() default "127.0.0.1";

    int port() default 8088;

}
