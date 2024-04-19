package com.sn.main;

import com.sn.server.RPCServer;

import java.io.IOException;

/**
 * @Description:
 * @Author: 公众号: CodeRevolt
 */
public class ServerMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        RPCServer.start();
    }

}
