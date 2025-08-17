package com.xuhao.didi.socket.client.impl.client;

import com.xuhao.didi.socket.client.impl.client.abilities.IConnectionSwitchListener;
import com.xuhao.didi.socket.client.impl.client.action.ActionDispatcher;
import com.xuhao.didi.socket.client.sdk.client.ConnectionInfo;
import com.xuhao.didi.socket.client.sdk.client.action.ISocketActionListener;
import com.xuhao.didi.socket.client.sdk.client.connection.IConnectionManager;
import java.io.Serializable;

public abstract class AbsConnectionManager implements IConnectionManager {
    protected ActionDispatcher mActionDispatcher;
    private IConnectionSwitchListener mConnectionSwitchListener;
    protected ConnectionInfo mLocalConnectionInfo;
    protected ConnectionInfo mRemoteConnectionInfo;

    public AbsConnectionManager(ConnectionInfo connectionInfo) {
        this(connectionInfo, (ConnectionInfo) null);
    }

    public ConnectionInfo getLocalConnectionInfo() {
        ConnectionInfo connectionInfo = this.mLocalConnectionInfo;
        if (connectionInfo != null) {
            return connectionInfo;
        }
        return null;
    }

    public ConnectionInfo getRemoteConnectionInfo() {
        ConnectionInfo connectionInfo = this.mRemoteConnectionInfo;
        if (connectionInfo != null) {
            return connectionInfo.clone();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void sendBroadcast(String str, Serializable serializable) {
        this.mActionDispatcher.sendBroadcast(str, serializable);
    }

    /* access modifiers changed from: protected */
    public void setOnConnectionSwitchListener(IConnectionSwitchListener iConnectionSwitchListener) {
        this.mConnectionSwitchListener = iConnectionSwitchListener;
    }

    public synchronized void switchConnectionInfo(ConnectionInfo connectionInfo) {
        if (connectionInfo != null) {
            ConnectionInfo connectionInfo2 = this.mRemoteConnectionInfo;
            ConnectionInfo clone = connectionInfo.clone();
            this.mRemoteConnectionInfo = clone;
            ActionDispatcher actionDispatcher = this.mActionDispatcher;
            if (actionDispatcher != null) {
                actionDispatcher.setConnectionInfo(clone);
            }
            IConnectionSwitchListener iConnectionSwitchListener = this.mConnectionSwitchListener;
            if (iConnectionSwitchListener != null) {
                iConnectionSwitchListener.onSwitchConnectionInfo(this, connectionInfo2, this.mRemoteConnectionInfo);
            }
        }
    }

    public AbsConnectionManager(ConnectionInfo connectionInfo, ConnectionInfo connectionInfo2) {
        this.mRemoteConnectionInfo = connectionInfo;
        this.mLocalConnectionInfo = connectionInfo2;
        this.mActionDispatcher = new ActionDispatcher(connectionInfo, this);
    }

    public IConnectionManager registerReceiver(ISocketActionListener iSocketActionListener) {
        this.mActionDispatcher.registerReceiver(iSocketActionListener);
        return this;
    }

    /* access modifiers changed from: protected */
    public void sendBroadcast(String str) {
        this.mActionDispatcher.sendBroadcast(str);
    }

    public IConnectionManager unRegisterReceiver(ISocketActionListener iSocketActionListener) {
        this.mActionDispatcher.unRegisterReceiver(iSocketActionListener);
        return this;
    }
}
