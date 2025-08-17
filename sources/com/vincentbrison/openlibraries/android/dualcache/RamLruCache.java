package com.vincentbrison.openlibraries.android.dualcache;

import java.util.LinkedHashMap;
import java.util.Map;

class RamLruCache<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<K, V> f37817a;

    /* renamed from: b  reason: collision with root package name */
    private int f37818b;

    /* renamed from: c  reason: collision with root package name */
    private int f37819c;

    /* renamed from: d  reason: collision with root package name */
    private int f37820d;

    /* renamed from: e  reason: collision with root package name */
    private int f37821e;

    /* renamed from: f  reason: collision with root package name */
    private int f37822f;

    /* renamed from: g  reason: collision with root package name */
    private int f37823g;

    /* renamed from: h  reason: collision with root package name */
    private int f37824h;

    public RamLruCache(int i2) {
        if (i2 > 0) {
            this.f37819c = i2;
            this.f37817a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int f(K k2, V v2) {
        int g2 = g(k2, v2);
        if (g2 >= 0) {
            return g2;
        }
        throw new IllegalStateException("Negative size: " + k2 + "=" + v2);
    }

    /* access modifiers changed from: protected */
    public V a(K k2) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void b(boolean z2, K k2, V v2, V v3) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        r0 = a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r0 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r4.f37821e++;
        r1 = r4.f37817a.put(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r1 == null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        r4.f37817a.put(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        r4.f37818b += f(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
        if (r1 == null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
        b(false, r5, r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
        i(r4.f37819c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004d, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V c(K r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0054
            monitor-enter(r4)
            java.util.LinkedHashMap<K, V> r0 = r4.f37817a     // Catch:{ all -> 0x0051 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x0013
            int r5 = r4.f37823g     // Catch:{ all -> 0x0051 }
            int r5 = r5 + 1
            r4.f37823g = r5     // Catch:{ all -> 0x0051 }
            monitor-exit(r4)     // Catch:{ all -> 0x0051 }
            return r0
        L_0x0013:
            int r0 = r4.f37824h     // Catch:{ all -> 0x0051 }
            int r0 = r0 + 1
            r4.f37824h = r0     // Catch:{ all -> 0x0051 }
            monitor-exit(r4)     // Catch:{ all -> 0x0051 }
            java.lang.Object r0 = r4.a(r5)
            if (r0 != 0) goto L_0x0022
            r5 = 0
            return r5
        L_0x0022:
            monitor-enter(r4)
            int r1 = r4.f37821e     // Catch:{ all -> 0x004e }
            int r1 = r1 + 1
            r4.f37821e = r1     // Catch:{ all -> 0x004e }
            java.util.LinkedHashMap<K, V> r1 = r4.f37817a     // Catch:{ all -> 0x004e }
            java.lang.Object r1 = r1.put(r5, r0)     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x0037
            java.util.LinkedHashMap<K, V> r2 = r4.f37817a     // Catch:{ all -> 0x004e }
            r2.put(r5, r1)     // Catch:{ all -> 0x004e }
            goto L_0x0040
        L_0x0037:
            int r2 = r4.f37818b     // Catch:{ all -> 0x004e }
            int r3 = r4.f(r5, r0)     // Catch:{ all -> 0x004e }
            int r2 = r2 + r3
            r4.f37818b = r2     // Catch:{ all -> 0x004e }
        L_0x0040:
            monitor-exit(r4)     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x0048
            r2 = 0
            r4.b(r2, r5, r0, r1)
            return r1
        L_0x0048:
            int r5 = r4.f37819c
            r4.i(r5)
            return r0
        L_0x004e:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x004e }
            throw r5
        L_0x0051:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0051 }
            throw r5
        L_0x0054:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "key == null"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vincentbrison.openlibraries.android.dualcache.RamLruCache.c(java.lang.Object):java.lang.Object");
    }

    public final V d(K k2, V v2) {
        V put;
        if (k2 == null || v2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f37820d++;
            this.f37818b += f(k2, v2);
            put = this.f37817a.put(k2, v2);
            if (put != null) {
                this.f37818b -= f(k2, put);
            }
        }
        if (put != null) {
            b(false, k2, put, v2);
        }
        i(this.f37819c);
        return put;
    }

    public final V e(K k2) {
        V remove;
        if (k2 != null) {
            synchronized (this) {
                remove = this.f37817a.remove(k2);
                if (remove != null) {
                    this.f37818b -= f(k2, remove);
                }
            }
            if (remove != null) {
                b(false, k2, remove, (V) null);
            }
            return remove;
        }
        throw new NullPointerException("key == null");
    }

    /* access modifiers changed from: protected */
    public int g(K k2, V v2) {
        throw null;
    }

    public final synchronized Map<K, V> h() {
        return new LinkedHashMap(this.f37817a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0084, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045 A[Catch:{ NoSuchMethodException -> 0x003c, InvocationTargetException -> 0x0037, IllegalAccessException -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0043 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(int r6) {
        /*
            r5 = this;
        L_0x0000:
            monitor-enter(r5)
            int r0 = r5.f37818b     // Catch:{ all -> 0x0085 }
            if (r0 < 0) goto L_0x0066
            java.util.LinkedHashMap<K, V> r0 = r5.f37817a     // Catch:{ all -> 0x0085 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0085 }
            if (r0 == 0) goto L_0x0011
            int r0 = r5.f37818b     // Catch:{ all -> 0x0085 }
            if (r0 != 0) goto L_0x0066
        L_0x0011:
            int r0 = r5.f37818b     // Catch:{ all -> 0x0085 }
            if (r0 > r6) goto L_0x0017
            monitor-exit(r5)     // Catch:{ all -> 0x0085 }
            goto L_0x0044
        L_0x0017:
            r0 = 0
            java.util.LinkedHashMap<K, V> r1 = r5.f37817a     // Catch:{ NoSuchMethodException -> 0x003c, InvocationTargetException -> 0x0037, IllegalAccessException -> 0x0032 }
            java.lang.Class r1 = r1.getClass()     // Catch:{ NoSuchMethodException -> 0x003c, InvocationTargetException -> 0x0037, IllegalAccessException -> 0x0032 }
            java.lang.String r2 = "eldest"
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x003c, InvocationTargetException -> 0x0037, IllegalAccessException -> 0x0032 }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ NoSuchMethodException -> 0x003c, InvocationTargetException -> 0x0037, IllegalAccessException -> 0x0032 }
            java.util.LinkedHashMap<K, V> r2 = r5.f37817a     // Catch:{ NoSuchMethodException -> 0x003c, InvocationTargetException -> 0x0037, IllegalAccessException -> 0x0032 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x003c, InvocationTargetException -> 0x0037, IllegalAccessException -> 0x0032 }
            java.lang.Object r1 = r1.invoke(r2, r3)     // Catch:{ NoSuchMethodException -> 0x003c, InvocationTargetException -> 0x0037, IllegalAccessException -> 0x0032 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ NoSuchMethodException -> 0x003c, InvocationTargetException -> 0x0037, IllegalAccessException -> 0x0032 }
            goto L_0x0041
        L_0x0032:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x0085 }
            goto L_0x0040
        L_0x0037:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x0085 }
            goto L_0x0040
        L_0x003c:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x0085 }
        L_0x0040:
            r1 = r0
        L_0x0041:
            if (r1 != 0) goto L_0x0045
            monitor-exit(r5)     // Catch:{ all -> 0x0085 }
        L_0x0044:
            return
        L_0x0045:
            java.lang.Object r2 = r1.getKey()     // Catch:{ all -> 0x0085 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x0085 }
            java.util.LinkedHashMap<K, V> r3 = r5.f37817a     // Catch:{ all -> 0x0085 }
            r3.remove(r2)     // Catch:{ all -> 0x0085 }
            int r3 = r5.f37818b     // Catch:{ all -> 0x0085 }
            int r4 = r5.f(r2, r1)     // Catch:{ all -> 0x0085 }
            int r3 = r3 - r4
            r5.f37818b = r3     // Catch:{ all -> 0x0085 }
            int r3 = r5.f37822f     // Catch:{ all -> 0x0085 }
            r4 = 1
            int r3 = r3 + r4
            r5.f37822f = r3     // Catch:{ all -> 0x0085 }
            monitor-exit(r5)     // Catch:{ all -> 0x0085 }
            r5.b(r4, r2, r1, r0)
            goto L_0x0000
        L_0x0066:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0085 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r0.<init>()     // Catch:{ all -> 0x0085 }
            java.lang.Class r1 = r5.getClass()     // Catch:{ all -> 0x0085 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0085 }
            r0.append(r1)     // Catch:{ all -> 0x0085 }
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch:{ all -> 0x0085 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0085 }
            r6.<init>(r0)     // Catch:{ all -> 0x0085 }
            throw r6     // Catch:{ all -> 0x0085 }
        L_0x0085:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0085 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vincentbrison.openlibraries.android.dualcache.RamLruCache.i(int):void");
    }

    public final synchronized String toString() {
        int i2;
        int i3 = this.f37823g;
        int i4 = this.f37824h + i3;
        if (i4 != 0) {
            i2 = (i3 * 100) / i4;
        } else {
            i2 = 0;
        }
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f37819c), Integer.valueOf(this.f37823g), Integer.valueOf(this.f37824h), Integer.valueOf(i2)});
    }
}
