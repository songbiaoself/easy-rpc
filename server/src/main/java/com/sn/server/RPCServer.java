package com.sn.server;

import com.alibaba.fastjson.JSON;
import com.sn.bean.Data;

import java.io.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @Description: 服务器socket
 * @Author: songbiao
 */
public class RPCServer{

    private static final int PORT = 8088;

    public static void start(){
        System.out.println("正在启动服务器:[127.0.0.1:"+PORT+"]");
        try (ServerSocket serverSocket = new ServerSocket(PORT,5);
             Socket socket =  serverSocket.accept();
             OutputStream outputStream = socket.getOutputStream();
             InputStream inputStream = socket.getInputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)){
            //接受客户端数据
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Data receiveData = (Data) objectInputStream.readObject();
            System.out.println("接收到["+socket.getRemoteSocketAddress()+"]客户端数据:"+ JSON.toJSONString(receiveData));
            //反射调用
            Object result = methodInvoke(receiveData);
            //响应
            objectOutputStream.writeObject(result);
            System.out.println("服务端响应成功.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射调用实现方法
     * 用了invokeDynamic动态调用的方式解决了反射包装、多态的问题
     * @param data
     * @return
     */
    public static Object methodInvoke(Data data){
        //返回类型加参数类型
        MethodType methodType = MethodType.methodType(data.getReturnType(), data.getParameterTypes());
        try {
            MethodHandle methodHandle = lookup().findVirtual(data.getType(), data.getMethodName(), methodType)
                    .bindTo(data.getType().newInstance());//除了static方法 每个方法都有一个隐式参数 如 this
            return methodHandle.invokeWithArguments(data.getArgs());
        }catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

}
