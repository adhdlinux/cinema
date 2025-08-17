package com.startapp;

import android.content.Context;

public abstract class dd<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f34373a;

    /* renamed from: b  reason: collision with root package name */
    public volatile T f34374b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f34375c;

    /* renamed from: d  reason: collision with root package name */
    public final long f34376d;

    public dd(Context context) {
        this(context, 900000);
    }

    public T a() {
        return null;
    }

    public T a(boolean z2) {
        return a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        if (r3 != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T b() {
        /*
            r8 = this;
            T r0 = r8.f34374b
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0018
            long r3 = r8.f34375c
            long r5 = r8.f34376d
            long r3 = r3 + r5
            long r5 = android.os.SystemClock.uptimeMillis()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x0015
            r3 = 1
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            if (r3 == 0) goto L_0x0044
        L_0x0018:
            monitor-enter(r8)
            T r0 = r8.f34374b     // Catch:{ all -> 0x004c }
            long r3 = r8.f34375c     // Catch:{ all -> 0x004c }
            long r5 = r8.f34376d     // Catch:{ all -> 0x004c }
            long r3 = r3 + r5
            long r5 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x004c }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r1 = 0
        L_0x002a:
            if (r0 == 0) goto L_0x002e
            if (r1 == 0) goto L_0x0043
        L_0x002e:
            java.lang.Object r0 = r8.a(r1)     // Catch:{ all -> 0x0033 }
            goto L_0x0039
        L_0x0033:
            r1 = move-exception
            android.content.Context r2 = r8.f34373a     // Catch:{ all -> 0x004c }
            com.startapp.y8.a((android.content.Context) r2, (java.lang.Throwable) r1)     // Catch:{ all -> 0x004c }
        L_0x0039:
            if (r0 == 0) goto L_0x0043
            r8.f34374b = r0     // Catch:{ all -> 0x004c }
            long r1 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x004c }
            r8.f34375c = r1     // Catch:{ all -> 0x004c }
        L_0x0043:
            monitor-exit(r8)     // Catch:{ all -> 0x004c }
        L_0x0044:
            if (r0 == 0) goto L_0x0047
            goto L_0x004b
        L_0x0047:
            java.lang.Object r0 = r8.c()
        L_0x004b:
            return r0
        L_0x004c:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x004c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.dd.b():java.lang.Object");
    }

    public abstract T c();

    public dd(Context context, long j2) {
        this.f34373a = context;
        this.f34376d = j2;
    }
}
