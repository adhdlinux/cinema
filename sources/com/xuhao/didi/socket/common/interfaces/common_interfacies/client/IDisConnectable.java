package com.xuhao.didi.socket.common.interfaces.common_interfacies.client;

public interface IDisConnectable {
    void disconnect();

    void disconnect(Exception exc);
}
