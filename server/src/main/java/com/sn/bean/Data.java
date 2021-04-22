package com.sn.bean;

import java.io.Serializable;

/**
 * @Description: 数据传输实体类
 * @Author: songbiao
 */
public class Data implements Serializable {

    private Class type;
    private Class returnType;
    private String methodName;
    private Class[] parameterTypes;
    private Object[] args;

    public Data(Class type, Class returnType, String methodName,Class[] parameterTypes, Object[] args) {
        this.type = type;
        this.returnType = returnType;
        this.methodName = methodName;
        this.parameterTypes = parameterTypes;
        this.args = args;
    }

    public Class[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public Class getReturnType() {
        return returnType;
    }

    public void setReturnType(Class returnType) {
        this.returnType = returnType;
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
