package com.xuhao.didi.socket.common.interfaces.common_interfacies.dispatcher;

public interface IRegister<T, E> {
    E registerReceiver(T t2);

    E unRegisterReceiver(T t2);
}
