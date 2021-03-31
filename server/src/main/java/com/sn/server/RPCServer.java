package com.sn.server;

import com.alibaba.fastjson.JSON;
import com.sn.bean.Data;

import java.io.*;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: 服务器socket
 * @Author: songbiao
 */
public class RPCServer{

    private static final int PORT = 8088;

    public static void start(){
        System.out.println("正在启动服务器:[127.0.0.1:"+PORT+"]");
        try (ServerSocket serverSocket = new ServerSocket(PORT,5, InetAddress.getByName("127.0.0.1"));
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
     * @param data
     * @return
     */
    public static Object methodInvoke(Data data){
        Class type = data.getType();
        String methodName = data.getMethodName();
        Object[] objects = data.getArgs();
        Method method = null;
        Class[] args = null;
        try {
            if (objects.length > 0) {
                args = new Class[objects.length];
                for (int i = 0; i < objects.length; i++) {
                    args[i] = objects[i].getClass();
                }
            }
            method = type.getMethod(methodName, args);
            return method.invoke(type.newInstance(),objects);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
