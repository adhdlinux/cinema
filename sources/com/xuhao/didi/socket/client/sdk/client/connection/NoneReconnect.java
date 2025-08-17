package com.xuhao.didi.socket.client.sdk.client.connection;

import com.xuhao.didi.socket.client.sdk.client.ConnectionInfo;

public class NoneReconnect extends AbsReconnectionManager {
    public void onSocketConnectionFailed(ConnectionInfo connectionInfo, String str, Exception exc) {
    }

    public void onSocketConnectionSuccess(ConnectionInfo connectionInfo, String str) {
    }

    public void onSocketDisconnection(ConnectionInfo connectionInfo, String str, Exception exc) {
    }
}
