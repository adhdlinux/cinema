package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class DiskCacheWriteLocker {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, WriteLock> f16622a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final WriteLockPool f16623b = new WriteLockPool();

    private static class WriteLock {

        /* renamed from: a  reason: collision with root package name */
        final Lock f16624a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f16625b;

        WriteLock() {
        }
    }

    private static class WriteLockPool {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<WriteLock> f16626a = new ArrayDeque();

        WriteLockPool() {
        }

        /* access modifiers changed from: package-private */
        public WriteLock a() {
            WriteLock poll;
            synchronized (this.f16626a) {
                poll = this.f16626a.poll();
            }
            if (poll == null) {
                return new WriteLock();
            }
            return poll;
        }

        /* access modifiers changed from: package-private */
        public void b(WriteLock writeLock) {
            synchronized (this.f16626a) {
                if (this.f16626a.size() < 10) {
                    this.f16626a.offer(writeLock);
                }
            }
        }
    }

    DiskCacheWriteLocker() {
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        WriteLock writeLock;
        synchronized (this) {
            writeLock = this.f16622a.get(str);
            if (writeLock == null) {
                writeLock = this.f16623b.a();
                this.f16622a.put(str, writeLock);
            }
            writeLock.f16625b++;
        }
        writeLock.f16624a.lock();
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        WriteLock writeLock;
        synchronized (this) {
            writeLock = (WriteLock) Preconditions.d(this.f16622a.get(str));
            int i2 = writeLock.f16625b;
            if (i2 >= 1) {
                int i3 = i2 - 1;
                writeLock.f16625b = i3;
                if (i3 == 0) {
                    WriteLock remove = this.f16622a.remove(str);
                    if (remove.equals(writeLock)) {
                        this.f16623b.b(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + writeLock + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + writeLock.f16625b);
            }
        }
        writeLock.f16624a.unlock();
    }
}
