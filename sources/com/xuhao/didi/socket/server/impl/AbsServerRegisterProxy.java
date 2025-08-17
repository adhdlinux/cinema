package com.xuhao.didi.socket.server.impl;

import com.xuhao.didi.core.iocore.interfaces.IStateSender;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.dispatcher.IRegister;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IServerActionListener;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IServerManager;
import com.xuhao.didi.socket.server.action.ServerActionDispatcher;
import java.io.Serializable;

public class AbsServerRegisterProxy implements IRegister<IServerActionListener, IServerManager>, IStateSender {
    private IServerManager<OkServerOptions> mManager;
    protected ServerActionDispatcher mServerActionDispatcher;

    /* access modifiers changed from: protected */
    public void init(IServerManager<OkServerOptions> iServerManager) {
        this.mManager = iServerManager;
        this.mServerActionDispatcher = new ServerActionDispatcher(this.mManager);
    }

    public void sendBroadcast(String str, Serializable serializable) {
        this.mServerActionDispatcher.sendBroadcast(str, serializable);
    }

    public IServerManager<OkServerOptions> registerReceiver(IServerActionListener iServerActionListener) {
        return this.mServerActionDispatcher.registerReceiver(iServerActionListener);
    }

    public void sendBroadcast(String str) {
        this.mServerActionDispatcher.sendBroadcast(str);
    }

    public IServerManager<OkServerOptions> unRegisterReceiver(IServerActionListener iServerActionListener) {
        return this.mServerActionDispatcher.unRegisterReceiver(iServerActionListener);
    }
}
