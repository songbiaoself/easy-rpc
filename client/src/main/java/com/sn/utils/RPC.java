package com.sn.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 公众号: CodeRevolt
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RPC {
    /**
     * 指定实现类class名称
     * @return
     */
    String value();

    String IP() default "127.0.0.1";

    int port() default 8088;

}
