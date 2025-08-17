package com.xuhao.didi.socket.client.impl.client.abilities;

import com.xuhao.didi.socket.client.sdk.client.ConnectionInfo;
import com.xuhao.didi.socket.client.sdk.client.connection.IConnectionManager;

public interface IConnectionSwitchListener {
    void onSwitchConnectionInfo(IConnectionManager iConnectionManager, ConnectionInfo connectionInfo, ConnectionInfo connectionInfo2);
}
