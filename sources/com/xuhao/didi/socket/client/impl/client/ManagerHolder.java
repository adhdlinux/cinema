package com.xuhao.didi.socket.client.impl.client;

import com.xuhao.didi.core.utils.SLog;
import com.xuhao.didi.socket.client.impl.client.abilities.IConnectionSwitchListener;
import com.xuhao.didi.socket.client.sdk.client.ConnectionInfo;
import com.xuhao.didi.socket.client.sdk.client.OkSocketOptions;
import com.xuhao.didi.socket.client.sdk.client.connection.IConnectionManager;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IServerManager;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IServerManagerPrivate;
import com.xuhao.didi.socket.common.interfaces.utils.SPIUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ManagerHolder {
    /* access modifiers changed from: private */
    public volatile Map<ConnectionInfo, IConnectionManager> mConnectionManagerMap;
    private volatile Map<Integer, IServerManagerPrivate> mServerManagerMap;

    private static class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ManagerHolder INSTANCE = new ManagerHolder();

        private InstanceHolder() {
        }
    }

    private IConnectionManager createNewManagerAndCache(ConnectionInfo connectionInfo, OkSocketOptions okSocketOptions) {
        ConnectionManagerImpl connectionManagerImpl = new ConnectionManagerImpl(connectionInfo);
        connectionManagerImpl.option(okSocketOptions);
        connectionManagerImpl.setOnConnectionSwitchListener(new IConnectionSwitchListener() {
            public void onSwitchConnectionInfo(IConnectionManager iConnectionManager, ConnectionInfo connectionInfo, ConnectionInfo connectionInfo2) {
                synchronized (ManagerHolder.this.mConnectionManagerMap) {
                    ManagerHolder.this.mConnectionManagerMap.remove(connectionInfo);
                    ManagerHolder.this.mConnectionManagerMap.put(connectionInfo2, iConnectionManager);
                }
            }
        });
        synchronized (this.mConnectionManagerMap) {
            this.mConnectionManagerMap.put(connectionInfo, connectionManagerImpl);
        }
        return connectionManagerImpl;
    }

    public static ManagerHolder getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public IConnectionManager getConnection(ConnectionInfo connectionInfo) {
        IConnectionManager iConnectionManager = this.mConnectionManagerMap.get(connectionInfo);
        if (iConnectionManager == null) {
            return getConnection(connectionInfo, OkSocketOptions.getDefault());
        }
        return getConnection(connectionInfo, iConnectionManager.getOption());
    }

    /* access modifiers changed from: protected */
    public List<IConnectionManager> getList() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap(this.mConnectionManagerMap);
        Iterator it2 = hashMap.keySet().iterator();
        while (it2.hasNext()) {
            IConnectionManager iConnectionManager = (IConnectionManager) hashMap.get((ConnectionInfo) it2.next());
            if (!iConnectionManager.getOption().isConnectionHolden()) {
                it2.remove();
            } else {
                arrayList.add(iConnectionManager);
            }
        }
        return arrayList;
    }

    public IServerManager getServer(int i2) {
        IServerManagerPrivate iServerManagerPrivate = this.mServerManagerMap.get(Integer.valueOf(i2));
        if (iServerManagerPrivate != null) {
            return iServerManagerPrivate;
        }
        IServerManagerPrivate iServerManagerPrivate2 = (IServerManagerPrivate) SPIUtils.load(IServerManager.class);
        if (iServerManagerPrivate2 != null) {
            synchronized (this.mServerManagerMap) {
                this.mServerManagerMap.put(Integer.valueOf(i2), iServerManagerPrivate2);
            }
            iServerManagerPrivate2.initServerPrivate(i2);
            return iServerManagerPrivate2;
        }
        SLog.e("Oksocket.Server() load error. Server plug-in are required! For details link to https://github.com/xuuhaoo/OkSocket");
        throw new IllegalStateException("Oksocket.Server() load error. Server plug-in are required! For details link to https://github.com/xuuhaoo/OkSocket");
    }

    private ManagerHolder() {
        this.mConnectionManagerMap = new HashMap();
        this.mServerManagerMap = new HashMap();
        this.mConnectionManagerMap.clear();
    }

    public IConnectionManager getConnection(ConnectionInfo connectionInfo, OkSocketOptions okSocketOptions) {
        IConnectionManager iConnectionManager = this.mConnectionManagerMap.get(connectionInfo);
        if (iConnectionManager == null) {
            return createNewManagerAndCache(connectionInfo, okSocketOptions);
        }
        if (!okSocketOptions.isConnectionHolden()) {
            synchronized (this.mConnectionManagerMap) {
                this.mConnectionManagerMap.remove(connectionInfo);
            }
            return createNewManagerAndCache(connectionInfo, okSocketOptions);
        }
        iConnectionManager.option(okSocketOptions);
        return iConnectionManager;
    }
}
