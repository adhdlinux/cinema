package com.xuhao.didi.core.iocore.interfaces;

import java.io.Serializable;

public interface IStateSender {
    void sendBroadcast(String str);

    void sendBroadcast(String str, Serializable serializable);
}
