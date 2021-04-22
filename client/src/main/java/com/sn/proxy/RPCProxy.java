package com.sn.proxy;

import com.alibaba.fastjson.JSON;
import com.sn.bean.Data;
import com.sn.utils.RPC;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @Description: rpc代理类
 * @Author: songbiao
 */
public class RPCProxy implements InvocationHandler {

    private RPC rpc;

    public RPCProxy(RPC rpc) {
        this.rpc = rpc;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("正在连接服务端:["+rpc.IP()+":"+rpc.port()+"]");
        //自动释放资源
        try (
            Socket socket = new Socket(rpc.IP(), rpc.port());
            OutputStream outputStream =  socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)
        ) {
            //===============发送====================
            Data data = new Data(rpc.type(),method.getReturnType(),method.getName(),method.getParameterTypes(),args);
            objectOutputStream.writeObject(data);
            //==================结束=======================
            //阻塞等待响应
            System.out.println("等待服务器响应....");
            result = objectInputStream.readObject();
        }
        System.out.println("接受服务端["+rpc.IP()+":"+rpc.port()+"]的消息:"+JSON.toJSONString(result));
        return result;
    }

    public Class[] covertToClass(Object[] objects) {
        if (objects == null || objects.length==0) {
            return null;
        }
        Class[] classes = new Class[objects.length];
        for (int i = 0; i < objects.length ; i++) {
            classes[i] = objects[i].getClass();
        }
        return classes;
    }
}
