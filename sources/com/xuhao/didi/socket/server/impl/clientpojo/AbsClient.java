package com.xuhao.didi.socket.server.impl.clientpojo;

import com.xuhao.didi.core.pojo.OriginalData;
import com.xuhao.didi.core.protocol.IReaderProtocol;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IClient;
import com.xuhao.didi.socket.common.interfaces.utils.TextUtils;
import com.xuhao.didi.socket.server.action.ClientActionDispatcher;
import com.xuhao.didi.socket.server.impl.OkServerOptions;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsClient implements IClient, ClientActionDispatcher.ClientActionListener {
    private volatile boolean isCallDead;
    private volatile boolean isCallReady;
    private List<OriginalData> mCacheForNotPrepare = new ArrayList();
    protected InetAddress mInetAddress;
    protected OkServerOptions mOkServerOptions;
    protected IReaderProtocol mReaderProtocol;
    protected Socket mSocket;
    protected String mUniqueTag;

    public AbsClient(Socket socket, OkServerOptions okServerOptions) {
        this.mOkServerOptions = okServerOptions;
        this.mSocket = socket;
        this.mInetAddress = socket.getInetAddress();
        this.mReaderProtocol = this.mOkServerOptions.getReaderProtocol();
        this.mUniqueTag = getHostIp() + "-" + System.currentTimeMillis() + "-" + System.nanoTime() + "-" + this.mSocket.getPort();
    }

    public String getHostIp() {
        return this.mInetAddress.getHostAddress();
    }

    public String getHostName() {
        return this.mInetAddress.getCanonicalHostName();
    }

    public String getUniqueTag() {
        if (TextUtils.isEmpty(this.mUniqueTag)) {
            return getHostIp();
        }
        return this.mUniqueTag;
    }

    /* access modifiers changed from: protected */
    public abstract void onClientDead(Exception exc);

    public final void onClientReadDead(Exception exc) {
        synchronized (this) {
            if (!this.isCallDead) {
                onClientDead(exc);
                this.isCallDead = true;
                this.isCallReady = false;
            }
        }
    }

    public final void onClientReadReady() {
        synchronized (this) {
            if (!this.isCallReady) {
                onClientReady();
                this.isCallDead = false;
                this.isCallReady = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onClientReady();

    public final void onClientWriteDead(Exception exc) {
        synchronized (this) {
            if (!this.isCallDead) {
                onClientDead(exc);
                this.isCallDead = true;
                this.isCallReady = false;
            }
        }
    }

    public void onClientWriteReady() {
        synchronized (this) {
            if (!this.isCallReady) {
                onClientReady();
                this.isCallDead = false;
                this.isCallReady = true;
            }
        }
    }
}
