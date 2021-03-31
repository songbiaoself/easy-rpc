package com.sn.main;

import com.sn.server.RPCServer;

/**
 * @Description:
 * @Author: songbiao
 */
public class ServerMain {

    public static void main(String[] args) {
        while (true) {
            RPCServer.start();
        }
    }

}
