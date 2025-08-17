package com.xuhao.didi.socket.client.sdk;

import com.xuhao.didi.socket.client.impl.client.ManagerHolder;
import com.xuhao.didi.socket.client.sdk.client.ConnectionInfo;
import com.xuhao.didi.socket.client.sdk.client.OkSocketOptions;
import com.xuhao.didi.socket.client.sdk.client.connection.IConnectionManager;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.dispatcher.IRegister;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IServerActionListener;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IServerManager;

public class OkSocket {
    private static ManagerHolder holder = ManagerHolder.getInstance();

    public static IConnectionManager open(ConnectionInfo connectionInfo) {
        return holder.getConnection(connectionInfo);
    }

    public static IRegister<IServerActionListener, IServerManager> server(int i2) {
        return (IRegister) holder.getServer(i2);
    }

    public static IConnectionManager open(String str, int i2) {
        return holder.getConnection(new ConnectionInfo(str, i2));
    }

    public static IConnectionManager open(ConnectionInfo connectionInfo, OkSocketOptions okSocketOptions) {
        return holder.getConnection(connectionInfo, okSocketOptions);
    }

    public static IConnectionManager open(String str, int i2, OkSocketOptions okSocketOptions) {
        return holder.getConnection(new ConnectionInfo(str, i2), okSocketOptions);
    }
}
