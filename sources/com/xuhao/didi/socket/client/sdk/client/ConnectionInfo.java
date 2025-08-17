package com.xuhao.didi.socket.client.sdk.client;

import java.io.Serializable;

public final class ConnectionInfo implements Serializable, Cloneable {
    private ConnectionInfo mBackupInfo;
    private String mIp;
    private int mPort;

    public ConnectionInfo(String str, int i2) {
        this.mIp = str;
        this.mPort = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectionInfo)) {
            return false;
        }
        ConnectionInfo connectionInfo = (ConnectionInfo) obj;
        if (this.mPort != connectionInfo.mPort) {
            return false;
        }
        return this.mIp.equals(connectionInfo.mIp);
    }

    public ConnectionInfo getBackupInfo() {
        return this.mBackupInfo;
    }

    public String getIp() {
        return this.mIp;
    }

    public int getPort() {
        return this.mPort;
    }

    public int hashCode() {
        return (this.mIp.hashCode() * 31) + this.mPort;
    }

    public void setBackupInfo(ConnectionInfo connectionInfo) {
        this.mBackupInfo = connectionInfo;
    }

    public ConnectionInfo clone() {
        ConnectionInfo connectionInfo = new ConnectionInfo(this.mIp, this.mPort);
        ConnectionInfo connectionInfo2 = this.mBackupInfo;
        if (connectionInfo2 != null) {
            connectionInfo.setBackupInfo(connectionInfo2.clone());
        }
        return connectionInfo;
    }
}
