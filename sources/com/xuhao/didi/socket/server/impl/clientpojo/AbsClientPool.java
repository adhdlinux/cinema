package com.xuhao.didi.socket.server.impl.clientpojo;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public abstract class AbsClientPool<K, V> {
    private int mCapacity;
    private volatile ConcurrentSkipListMap<K, V> mHashMap = new ConcurrentSkipListMap<>();

    interface Echo<K, V> {
        void onEcho(K k2, V v2);
    }

    public AbsClientPool(int i2) {
        this.mCapacity = i2;
    }

    private Map.Entry<K, V> getTail() {
        Map.Entry<K, V> entry = null;
        if (this.mHashMap.isEmpty()) {
            return null;
        }
        Iterator<Map.Entry<K, V>> it2 = this.mHashMap.entrySet().iterator();
        while (it2.hasNext()) {
            entry = it2.next();
        }
        return entry;
    }

    /* access modifiers changed from: package-private */
    public synchronized void echoRun(Echo echo) {
        if (echo != null) {
            for (Map.Entry next : this.mHashMap.entrySet()) {
                echo.onEcho(next.getKey(), next.getValue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public V get(K k2) {
        return this.mHashMap.get(k2);
    }

    /* access modifiers changed from: package-private */
    public abstract void onCacheDuplicate(K k2, V v2);

    /* access modifiers changed from: package-private */
    public abstract void onCacheEmpty();

    /* access modifiers changed from: package-private */
    public abstract void onCacheFull(K k2, V v2);

    /* access modifiers changed from: package-private */
    public synchronized void remove(K k2) {
        this.mHashMap.remove(k2);
        if (this.mHashMap.isEmpty()) {
            onCacheEmpty();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void removeAll() {
        this.mHashMap.clear();
    }

    /* access modifiers changed from: package-private */
    public synchronized void set(K k2, V v2) {
        V v3 = this.mHashMap.get(k2);
        if (v3 != null) {
            onCacheDuplicate(k2, v3);
        }
        if (this.mCapacity == this.mHashMap.size()) {
            Map.Entry tail = getTail();
            onCacheFull(tail.getKey(), tail.getValue());
        }
        if (!this.mHashMap.containsKey(k2)) {
            if (this.mCapacity != this.mHashMap.size()) {
                this.mHashMap.put(k2, v2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int size() {
        return this.mHashMap.size();
    }
}
