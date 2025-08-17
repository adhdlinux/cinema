package com.xuhao.didi.socket.client.sdk.client.action;

import com.xuhao.didi.core.iocore.interfaces.IPulseSendable;
import com.xuhao.didi.core.iocore.interfaces.ISendable;
import com.xuhao.didi.core.pojo.OriginalData;
import com.xuhao.didi.socket.client.sdk.client.ConnectionInfo;

public abstract class SocketActionAdapter implements ISocketActionListener {
    public void onPulseSend(ConnectionInfo connectionInfo, IPulseSendable iPulseSendable) {
    }

    public void onSocketConnectionFailed(ConnectionInfo connectionInfo, String str, Exception exc) {
    }

    public void onSocketConnectionSuccess(ConnectionInfo connectionInfo, String str) {
    }

    public void onSocketDisconnection(ConnectionInfo connectionInfo, String str, Exception exc) {
    }

    public void onSocketIOThreadShutdown(String str, Exception exc) {
    }

    public void onSocketIOThreadStart(String str) {
    }

    public void onSocketReadResponse(ConnectionInfo connectionInfo, String str, OriginalData originalData) {
    }

    public void onSocketWriteResponse(ConnectionInfo connectionInfo, String str, ISendable iSendable) {
    }
}
