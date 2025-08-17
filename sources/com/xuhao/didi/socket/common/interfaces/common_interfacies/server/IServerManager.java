package com.xuhao.didi.socket.common.interfaces.common_interfacies.server;

import com.xuhao.didi.core.iocore.interfaces.IIOCoreOptions;

public interface IServerManager<E extends IIOCoreOptions> extends IServerShutdown {
    IClientPool<String, IClient> getClientPool();

    boolean isLive();

    void listen();

    void listen(E e2);
}
