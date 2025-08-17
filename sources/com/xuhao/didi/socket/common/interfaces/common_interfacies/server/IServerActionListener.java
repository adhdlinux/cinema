package com.xuhao.didi.socket.common.interfaces.common_interfacies.server;

public interface IServerActionListener {
    void onClientConnected(IClient iClient, int i2, IClientPool iClientPool);

    void onClientDisconnected(IClient iClient, int i2, IClientPool iClientPool);

    void onServerAlreadyShutdown(int i2);

    void onServerListening(int i2);

    void onServerWillBeShutdown(int i2, IServerShutdown iServerShutdown, IClientPool iClientPool, Throwable th);
}
