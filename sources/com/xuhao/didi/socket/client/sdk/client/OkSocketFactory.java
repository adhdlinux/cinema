package com.xuhao.didi.socket.client.sdk.client;

import java.net.Socket;

public abstract class OkSocketFactory {
    public abstract Socket createSocket(ConnectionInfo connectionInfo, OkSocketOptions okSocketOptions) throws Exception;
}
