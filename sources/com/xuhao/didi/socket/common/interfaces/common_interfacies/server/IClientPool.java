package com.xuhao.didi.socket.common.interfaces.common_interfacies.server;

import com.xuhao.didi.core.iocore.interfaces.ISendable;

public interface IClientPool<T, K> {
    void cache(T t2);

    T findByUniqueTag(K k2);

    void sendToAll(ISendable iSendable);

    int size();
}
