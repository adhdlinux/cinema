package com.vincentbrison.openlibraries.android.dualcache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class DualCacheLock {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentMap<String, Lock> f37809a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private final ReadWriteLock f37810b = new ReentrantReadWriteLock();

    DualCacheLock() {
    }

    private Lock a(String str) {
        if (!this.f37809a.containsKey(str)) {
            this.f37809a.putIfAbsent(str, new ReentrantLock());
        }
        return this.f37809a.get(str);
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        this.f37810b.readLock().lock();
        a(str).lock();
    }

    /* access modifiers changed from: package-private */
    public void c(String str) {
        a(str).unlock();
        this.f37810b.readLock().unlock();
    }
}
