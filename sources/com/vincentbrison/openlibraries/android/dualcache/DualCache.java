package com.vincentbrison.openlibraries.android.dualcache;

import com.jakewharton.disklrucache.DiskLruCache;
import java.io.File;
import java.io.IOException;

public class DualCache<T> {

    /* renamed from: a  reason: collision with root package name */
    private final RamLruCache f37792a;

    /* renamed from: b  reason: collision with root package name */
    private DiskLruCache f37793b;

    /* renamed from: c  reason: collision with root package name */
    private final int f37794c;

    /* renamed from: d  reason: collision with root package name */
    private final File f37795d;

    /* renamed from: e  reason: collision with root package name */
    private final int f37796e;

    /* renamed from: f  reason: collision with root package name */
    private final DualCacheRamMode f37797f;

    /* renamed from: g  reason: collision with root package name */
    private final DualCacheDiskMode f37798g;

    /* renamed from: h  reason: collision with root package name */
    private final CacheSerializer<T> f37799h;

    /* renamed from: i  reason: collision with root package name */
    private final CacheSerializer<T> f37800i;

    /* renamed from: j  reason: collision with root package name */
    private final DualCacheLock f37801j = new DualCacheLock();

    /* renamed from: k  reason: collision with root package name */
    private final Logger f37802k;

    /* renamed from: l  reason: collision with root package name */
    private final LoggerHelper f37803l;

    /* renamed from: com.vincentbrison.openlibraries.android.dualcache.DualCache$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37804a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f37805b;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0023 */
        static {
            /*
                com.vincentbrison.openlibraries.android.dualcache.DualCacheDiskMode[] r0 = com.vincentbrison.openlibraries.android.dualcache.DualCacheDiskMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f37805b = r0
                r1 = 1
                com.vincentbrison.openlibraries.android.dualcache.DualCacheDiskMode r2 = com.vincentbrison.openlibraries.android.dualcache.DualCacheDiskMode.ENABLE_WITH_SPECIFIC_SERIALIZER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode[] r0 = com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f37804a = r0
                com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode r2 = com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode.ENABLE_WITH_SPECIFIC_SERIALIZER     // Catch:{ NoSuchFieldError -> 0x0023 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0023 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                int[] r0 = f37804a     // Catch:{ NoSuchFieldError -> 0x002e }
                com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode r1 = com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode.ENABLE_WITH_REFERENCE     // Catch:{ NoSuchFieldError -> 0x002e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vincentbrison.openlibraries.android.dualcache.DualCache.AnonymousClass1.<clinit>():void");
        }
    }

    DualCache(int i2, Logger logger, DualCacheRamMode dualCacheRamMode, CacheSerializer<T> cacheSerializer, int i3, SizeOf<T> sizeOf, DualCacheDiskMode dualCacheDiskMode, CacheSerializer<T> cacheSerializer2, int i4, File file) {
        this.f37796e = i2;
        this.f37797f = dualCacheRamMode;
        this.f37800i = cacheSerializer;
        this.f37798g = dualCacheDiskMode;
        this.f37799h = cacheSerializer2;
        this.f37795d = file;
        this.f37802k = logger;
        this.f37803l = new LoggerHelper(logger);
        int i5 = AnonymousClass1.f37804a[dualCacheRamMode.ordinal()];
        if (i5 == 1) {
            this.f37792a = new StringLruCache(i3);
        } else if (i5 != 2) {
            this.f37792a = null;
        } else {
            this.f37792a = new ReferenceLruCache(i3, sizeOf);
        }
        if (AnonymousClass1.f37805b[dualCacheDiskMode.ordinal()] != 1) {
            this.f37794c = 0;
            return;
        }
        this.f37794c = i4;
        try {
            f(file);
        } catch (IOException e2) {
            logger.b(e2);
        }
    }

    private void f(File file) throws IOException {
        this.f37793b = DiskLruCache.r0(file, this.f37796e, 1, (long) this.f37794c);
    }

    public boolean a(String str) {
        if (!this.f37797f.equals(DualCacheRamMode.DISABLE) && this.f37792a.h().containsKey(str)) {
            return true;
        }
        try {
            this.f37801j.b(str);
            if (!this.f37798g.equals(DualCacheDiskMode.DISABLE) && this.f37793b.o0(str) != null) {
                this.f37801j.c(str);
                return true;
            }
        } catch (IOException e2) {
            this.f37802k.b(e2);
        } catch (Throwable th) {
            this.f37801j.c(str);
            throw th;
        }
        this.f37801j.c(str);
        return false;
    }

    public void b(String str) {
        if (!this.f37797f.equals(DualCacheRamMode.DISABLE)) {
            this.f37792a.e(str);
        }
        if (!this.f37798g.equals(DualCacheDiskMode.DISABLE)) {
            try {
                this.f37801j.b(str);
                this.f37793b.w0(str);
            } catch (IOException e2) {
                this.f37802k.b(e2);
            } catch (Throwable th) {
                this.f37801j.c(str);
                throw th;
            }
            this.f37801j.c(str);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T c(java.lang.String r6) {
        /*
            r5 = this;
            com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode r0 = r5.f37797f
            com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode r1 = com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode.ENABLE_WITH_SPECIFIC_SERIALIZER
            boolean r0 = r0.equals(r1)
            com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode r2 = r5.f37797f
            com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode r3 = com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode.ENABLE_WITH_REFERENCE
            boolean r2 = r2.equals(r3)
            r4 = 0
            if (r0 != 0) goto L_0x0018
            if (r2 == 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r0 = r4
            goto L_0x001e
        L_0x0018:
            com.vincentbrison.openlibraries.android.dualcache.RamLruCache r0 = r5.f37792a
            java.lang.Object r0 = r0.c(r6)
        L_0x001e:
            if (r0 != 0) goto L_0x00b1
            com.vincentbrison.openlibraries.android.dualcache.LoggerHelper r0 = r5.f37803l
            r0.b(r6)
            com.vincentbrison.openlibraries.android.dualcache.DualCacheDiskMode r0 = r5.f37798g
            com.vincentbrison.openlibraries.android.dualcache.DualCacheDiskMode r1 = com.vincentbrison.openlibraries.android.dualcache.DualCacheDiskMode.ENABLE_WITH_SPECIFIC_SERIALIZER
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006e
            com.vincentbrison.openlibraries.android.dualcache.DualCacheLock r0 = r5.f37801j     // Catch:{ IOException -> 0x0042 }
            r0.b(r6)     // Catch:{ IOException -> 0x0042 }
            com.jakewharton.disklrucache.DiskLruCache r0 = r5.f37793b     // Catch:{ IOException -> 0x0042 }
            com.jakewharton.disklrucache.DiskLruCache$Snapshot r0 = r0.o0(r6)     // Catch:{ IOException -> 0x0042 }
            com.vincentbrison.openlibraries.android.dualcache.DualCacheLock r1 = r5.f37801j
            r1.c(r6)
            goto L_0x004e
        L_0x0040:
            r0 = move-exception
            goto L_0x0068
        L_0x0042:
            r0 = move-exception
            com.vincentbrison.openlibraries.android.dualcache.Logger r1 = r5.f37802k     // Catch:{ all -> 0x0040 }
            r1.b(r0)     // Catch:{ all -> 0x0040 }
            com.vincentbrison.openlibraries.android.dualcache.DualCacheLock r0 = r5.f37801j
            r0.c(r6)
            r0 = r4
        L_0x004e:
            if (r0 == 0) goto L_0x0062
            com.vincentbrison.openlibraries.android.dualcache.LoggerHelper r1 = r5.f37803l
            r1.d(r6)
            r1 = 0
            java.lang.String r0 = r0.getString(r1)     // Catch:{ IOException -> 0x005b }
            goto L_0x006f
        L_0x005b:
            r0 = move-exception
            com.vincentbrison.openlibraries.android.dualcache.Logger r1 = r5.f37802k
            r1.b(r0)
            goto L_0x006e
        L_0x0062:
            com.vincentbrison.openlibraries.android.dualcache.LoggerHelper r0 = r5.f37803l
            r0.c(r6)
            goto L_0x006e
        L_0x0068:
            com.vincentbrison.openlibraries.android.dualcache.DualCacheLock r1 = r5.f37801j
            r1.c(r6)
            throw r0
        L_0x006e:
            r0 = r4
        L_0x006f:
            if (r0 == 0) goto L_0x00d0
            com.vincentbrison.openlibraries.android.dualcache.CacheSerializer<T> r1 = r5.f37799h
            java.lang.Object r1 = r1.a(r0)
            com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode r2 = r5.f37797f
            com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode r3 = com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode.ENABLE_WITH_REFERENCE
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0091
            com.vincentbrison.openlibraries.android.dualcache.DualCacheDiskMode r0 = r5.f37798g
            com.vincentbrison.openlibraries.android.dualcache.DualCacheDiskMode r2 = com.vincentbrison.openlibraries.android.dualcache.DualCacheDiskMode.ENABLE_WITH_SPECIFIC_SERIALIZER
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00b0
            com.vincentbrison.openlibraries.android.dualcache.RamLruCache r0 = r5.f37792a
            r0.d(r6, r1)
            goto L_0x00b0
        L_0x0091:
            com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode r2 = r5.f37797f
            com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode r3 = com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode.ENABLE_WITH_SPECIFIC_SERIALIZER
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00b0
            com.vincentbrison.openlibraries.android.dualcache.CacheSerializer<T> r2 = r5.f37799h
            com.vincentbrison.openlibraries.android.dualcache.CacheSerializer<T> r3 = r5.f37800i
            if (r2 != r3) goto L_0x00a7
            com.vincentbrison.openlibraries.android.dualcache.RamLruCache r2 = r5.f37792a
            r2.d(r6, r0)
            goto L_0x00b0
        L_0x00a7:
            com.vincentbrison.openlibraries.android.dualcache.RamLruCache r0 = r5.f37792a
            java.lang.String r2 = r3.b(r1)
            r0.d(r6, r2)
        L_0x00b0:
            return r1
        L_0x00b1:
            com.vincentbrison.openlibraries.android.dualcache.LoggerHelper r2 = r5.f37803l
            r2.a(r6)
            com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode r6 = r5.f37797f
            boolean r6 = r6.equals(r3)
            if (r6 == 0) goto L_0x00bf
            return r0
        L_0x00bf:
            com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode r6 = r5.f37797f
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x00d0
            com.vincentbrison.openlibraries.android.dualcache.CacheSerializer<T> r6 = r5.f37800i
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r6 = r6.a(r0)
            return r6
        L_0x00d0:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vincentbrison.openlibraries.android.dualcache.DualCache.c(java.lang.String):java.lang.Object");
    }

    public DualCacheDiskMode d() {
        return this.f37798g;
    }

    public DualCacheRamMode e() {
        return this.f37797f;
    }

    public void g(String str, T t2) {
        String str2;
        if (this.f37797f.equals(DualCacheRamMode.ENABLE_WITH_REFERENCE)) {
            this.f37792a.d(str, t2);
        }
        if (this.f37797f.equals(DualCacheRamMode.ENABLE_WITH_SPECIFIC_SERIALIZER)) {
            str2 = this.f37800i.b(t2);
            this.f37792a.d(str, str2);
        } else {
            str2 = null;
        }
        if (this.f37798g.equals(DualCacheDiskMode.ENABLE_WITH_SPECIFIC_SERIALIZER)) {
            try {
                this.f37801j.b(str);
                DiskLruCache.Editor j02 = this.f37793b.j0(str);
                CacheSerializer<T> cacheSerializer = this.f37800i;
                CacheSerializer<T> cacheSerializer2 = this.f37799h;
                if (cacheSerializer == cacheSerializer2) {
                    j02.g(0, str2);
                } else {
                    j02.g(0, cacheSerializer2.b(t2));
                }
                j02.e();
            } catch (IOException e2) {
                this.f37802k.b(e2);
            } catch (Throwable th) {
                this.f37801j.c(str);
                throw th;
            }
            this.f37801j.c(str);
        }
    }
}
