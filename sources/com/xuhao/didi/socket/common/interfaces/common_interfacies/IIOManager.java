package com.xuhao.didi.socket.common.interfaces.common_interfacies;

import com.xuhao.didi.core.iocore.interfaces.IIOCoreOptions;
import com.xuhao.didi.core.iocore.interfaces.ISendable;

public interface IIOManager<E extends IIOCoreOptions> {
    void close();

    void close(Exception exc);

    void send(ISendable iSendable);

    void setOkOptions(E e2);

    void startEngine();
}
