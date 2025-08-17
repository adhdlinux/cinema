package com.xuhao.didi.socket.server.impl.clientpojo;

import com.xuhao.didi.core.iocore.interfaces.ISendable;
import com.xuhao.didi.core.iocore.interfaces.IStateSender;
import com.xuhao.didi.core.pojo.OriginalData;
import com.xuhao.didi.core.protocol.IReaderProtocol;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IClient;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IClientIOCallback;
import com.xuhao.didi.socket.server.action.ClientActionDispatcher;
import com.xuhao.didi.socket.server.action.IAction;
import com.xuhao.didi.socket.server.exceptions.CacheException;
import com.xuhao.didi.socket.server.impl.OkServerOptions;
import com.xuhao.didi.socket.server.impl.iocore.ClientIOManager;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientImpl extends AbsClient {
    private volatile boolean isDead;
    private volatile boolean isReadThreadStarted;
    private IStateSender mActionDispatcher = new ClientActionDispatcher(this);
    private volatile List<IClientIOCallback> mCallbackList = new ArrayList();
    private volatile ClientPoolImpl mClientPool;
    private ClientIOManager mIOManager;
    private IStateSender mServerStateSender;

    public ClientImpl(Socket socket, OkServerOptions okServerOptions) {
        super(socket, okServerOptions);
        try {
            initIOManager();
        } catch (IOException e2) {
            disconnect(e2);
        }
    }

    private void initIOManager() throws IOException {
        this.mIOManager = new ClientIOManager(this.mSocket.getInputStream(), this.mSocket.getOutputStream(), this.mOkServerOptions, this.mActionDispatcher);
    }

    public void addIOCallback(IClientIOCallback iClientIOCallback) {
        if (!this.isDead) {
            synchronized (this.mCallbackList) {
                this.mCallbackList.add(iClientIOCallback);
            }
            synchronized (this.mIOManager) {
                if (!this.isReadThreadStarted) {
                    this.isReadThreadStarted = true;
                    this.mIOManager.startReadEngine();
                }
            }
        }
    }

    public void disconnect(Exception exc) {
        ClientIOManager clientIOManager = this.mIOManager;
        if (clientIOManager != null) {
            synchronized (clientIOManager) {
                this.mIOManager.close(exc);
            }
        } else {
            onClientDead(exc);
        }
        try {
            synchronized (this.mSocket) {
                this.mSocket.close();
            }
        } catch (IOException unused) {
        }
        removeAllIOCallback();
        this.isReadThreadStarted = false;
    }

    /* access modifiers changed from: protected */
    public void onClientDead(Exception exc) {
        if (!this.isDead) {
            if (!(exc instanceof CacheException)) {
                this.mClientPool.unCache((IClient) this);
            }
            if (exc != null && this.mOkServerOptions.isDebug()) {
                exc.printStackTrace();
            }
            disconnect(exc);
            this.mServerStateSender.sendBroadcast(IAction.Server.ACTION_CLIENT_DISCONNECTED, this);
            synchronized (this) {
                this.isDead = true;
            }
        }
    }

    public void onClientRead(OriginalData originalData) {
        ArrayList<IClientIOCallback> arrayList = new ArrayList<>();
        arrayList.addAll(this.mCallbackList);
        for (IClientIOCallback onClientRead : arrayList) {
            try {
                onClientRead.onClientRead(originalData, this, this.mClientPool);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onClientReady() {
        if (!this.isDead) {
            this.mClientPool.cache((IClient) this);
            this.mServerStateSender.sendBroadcast(IAction.Server.ACTION_CLIENT_CONNECTED, this);
        }
    }

    public void onClientWrite(ISendable iSendable) {
        ArrayList<IClientIOCallback> arrayList = new ArrayList<>();
        arrayList.addAll(this.mCallbackList);
        for (IClientIOCallback onClientWrite : arrayList) {
            try {
                onClientWrite.onClientWrite(iSendable, this, this.mClientPool);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void removeAllIOCallback() {
        synchronized (this.mCallbackList) {
            this.mCallbackList.clear();
        }
    }

    public void removeIOCallback(IClientIOCallback iClientIOCallback) {
        synchronized (this.mCallbackList) {
            this.mCallbackList.remove(iClientIOCallback);
        }
    }

    public void setClientPool(ClientPoolImpl clientPoolImpl) {
        this.mClientPool = clientPoolImpl;
    }

    public void setReaderProtocol(IReaderProtocol iReaderProtocol) {
        ClientIOManager clientIOManager = this.mIOManager;
        if (clientIOManager != null) {
            synchronized (clientIOManager) {
                OkServerOptions.Builder builder = new OkServerOptions.Builder(this.mOkServerOptions);
                builder.setReaderProtocol(iReaderProtocol);
                OkServerOptions build = builder.build();
                this.mOkServerOptions = build;
                this.mIOManager.setOkOptions(build);
            }
        }
    }

    public void setServerStateSender(IStateSender iStateSender) {
        this.mServerStateSender = iStateSender;
    }

    public void startIOEngine() {
        ClientIOManager clientIOManager = this.mIOManager;
        if (clientIOManager != null) {
            synchronized (clientIOManager) {
                this.mIOManager.startWriteEngine();
            }
        }
    }

    public IClient send(ISendable iSendable) {
        ClientIOManager clientIOManager = this.mIOManager;
        if (clientIOManager != null) {
            clientIOManager.send(iSendable);
        }
        return this;
    }

    public void disconnect() {
        ClientIOManager clientIOManager = this.mIOManager;
        if (clientIOManager != null) {
            synchronized (clientIOManager) {
                this.mIOManager.close();
            }
        } else {
            onClientDead((Exception) null);
        }
        try {
            synchronized (this.mSocket) {
                this.mSocket.close();
            }
        } catch (IOException unused) {
        }
        removeAllIOCallback();
        this.isReadThreadStarted = false;
    }
}
