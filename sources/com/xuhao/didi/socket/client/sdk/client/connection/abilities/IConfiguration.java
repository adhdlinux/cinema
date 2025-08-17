package com.xuhao.didi.socket.client.sdk.client.connection.abilities;

import com.xuhao.didi.socket.client.sdk.client.OkSocketOptions;
import com.xuhao.didi.socket.client.sdk.client.connection.IConnectionManager;

public interface IConfiguration {
    OkSocketOptions getOption();

    IConnectionManager option(OkSocketOptions okSocketOptions);
}
