package com.xuhao.didi.socket.server.action;

import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IClient;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IClientPool;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IServerActionListener;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IServerShutdown;

public abstract class ServerActionAdapter implements IServerActionListener {
    public void onClientConnected(IClient iClient, int i2, IClientPool iClientPool) {
    }

    public void onClientDisconnected(IClient iClient, int i2, IClientPool iClientPool) {
    }

    public void onServerAlreadyShutdown(int i2) {
    }

    public void onServerListening(int i2) {
    }

    public void onServerWillBeShutdown(int i2, IServerShutdown iServerShutdown, IClientPool iClientPool, Throwable th) {
    }
}
