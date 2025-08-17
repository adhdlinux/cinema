package com.xuhao.didi.socket.client.sdk.client.bean;

public interface IPulse {
    void dead();

    void feed();

    void pulse();

    void trigger();
}
