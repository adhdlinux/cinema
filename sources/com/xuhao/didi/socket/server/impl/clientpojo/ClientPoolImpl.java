package com.xuhao.didi.socket.server.impl.clientpojo;

import com.xuhao.didi.core.iocore.interfaces.ISendable;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IClient;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IClientPool;
import com.xuhao.didi.socket.server.exceptions.CacheException;
import com.xuhao.didi.socket.server.impl.clientpojo.AbsClientPool;

public class ClientPoolImpl extends AbsClientPool<String, IClient> implements IClientPool<IClient, String> {
    public ClientPoolImpl(int i2) {
        super(i2);
    }

    public void onCacheEmpty() {
    }

    public void sendToAll(final ISendable iSendable) {
        echoRun(new AbsClientPool.Echo<String, IClient>() {
            public void onEcho(String str, IClient iClient) {
                iClient.send(iSendable);
            }
        });
    }

    public void serverDown() {
        echoRun(new AbsClientPool.Echo<String, IClient>() {
            public void onEcho(String str, IClient iClient) {
                iClient.disconnect();
            }
        });
        removeAll();
    }

    public int size() {
        return super.size();
    }

    public void unCache(IClient iClient) {
        remove(iClient.getUniqueTag());
    }

    public void cache(IClient iClient) {
        super.set(iClient.getUniqueTag(), iClient);
    }

    public IClient findByUniqueTag(String str) {
        return (IClient) get(str);
    }

    /* access modifiers changed from: package-private */
    public void onCacheDuplicate(String str, IClient iClient) {
        iClient.disconnect(new CacheException("there are cached in this server.it need removed before new cache"));
        unCache(iClient);
    }

    /* access modifiers changed from: package-private */
    public void onCacheFull(String str, IClient iClient) {
        iClient.disconnect(new CacheException("cache is full,you need remove"));
        unCache(iClient);
    }

    public void unCache(String str) {
        remove(str);
    }
}
