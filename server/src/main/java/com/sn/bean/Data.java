package com.sn.bean;

import java.io.Serializable;

/**
 * @Description: 数据传输实体类
 * @Author: songbiao
 */
public class Data implements Serializable {

    private Class type;
    private String methodName;
    private Object[] args;

    public Data() {
    }

    public Data(Class type, String methodName, Object[] args) {
        this.type = type;
        this.methodName = methodName;
        this.args = args;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
