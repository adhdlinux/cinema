package com.google.android.exoplayer2.upstream.cache;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;
import java.io.InterruptedIOException;
import v0.c;

public final class CacheWriter {

    /* renamed from: a  reason: collision with root package name */
    private final CacheDataSource f28587a;

    /* renamed from: b  reason: collision with root package name */
    private final Cache f28588b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSpec f28589c;

    /* renamed from: d  reason: collision with root package name */
    private final String f28590d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f28591e;

    /* renamed from: f  reason: collision with root package name */
    private final ProgressListener f28592f;

    /* renamed from: g  reason: collision with root package name */
    private long f28593g;

    /* renamed from: h  reason: collision with root package name */
    private long f28594h;

    /* renamed from: i  reason: collision with root package name */
    private long f28595i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f28596j;

    public interface ProgressListener {
        void a(long j2, long j3, long j4);
    }

    public CacheWriter(CacheDataSource cacheDataSource, DataSpec dataSpec, byte[] bArr, ProgressListener progressListener) {
        this.f28587a = cacheDataSource;
        this.f28588b = cacheDataSource.s();
        this.f28589c = dataSpec;
        this.f28591e = bArr == null ? new byte[131072] : bArr;
        this.f28592f = progressListener;
        this.f28590d = cacheDataSource.t().a(dataSpec);
        this.f28593g = dataSpec.f28345g;
    }

    private long c() {
        long j2 = this.f28594h;
        if (j2 == -1) {
            return -1;
        }
        return j2 - this.f28589c.f28345g;
    }

    private void d(long j2) {
        this.f28595i += j2;
        ProgressListener progressListener = this.f28592f;
        if (progressListener != null) {
            progressListener.a(c(), this.f28595i, j2);
        }
    }

    private void e(long j2) {
        if (this.f28594h != j2) {
            this.f28594h = j2;
            ProgressListener progressListener = this.f28592f;
            if (progressListener != null) {
                progressListener.a(c(), this.f28595i, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006f A[Catch:{ IOException -> 0x0068 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0085 A[Catch:{ IOException -> 0x0068 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long f(long r10, long r12) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r10 + r12
            long r2 = r9.f28594h
            r4 = 1
            r5 = 0
            r6 = -1
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 == 0) goto L_0x0013
            int r0 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r0 = 0
            goto L_0x0014
        L_0x0013:
            r0 = 1
        L_0x0014:
            int r1 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x0036
            com.google.android.exoplayer2.upstream.DataSpec r1 = r9.f28589c
            com.google.android.exoplayer2.upstream.DataSpec$Builder r1 = r1.a()
            com.google.android.exoplayer2.upstream.DataSpec$Builder r1 = r1.h(r10)
            com.google.android.exoplayer2.upstream.DataSpec$Builder r12 = r1.g(r12)
            com.google.android.exoplayer2.upstream.DataSpec r12 = r12.a()
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r13 = r9.f28587a     // Catch:{ IOException -> 0x0031 }
            long r12 = r13.i(r12)     // Catch:{ IOException -> 0x0031 }
            goto L_0x0038
        L_0x0031:
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r12 = r9.f28587a
            com.google.android.exoplayer2.upstream.DataSourceUtil.a(r12)
        L_0x0036:
            r12 = r6
            r4 = 0
        L_0x0038:
            if (r4 != 0) goto L_0x005d
            r9.g()
            com.google.android.exoplayer2.upstream.DataSpec r12 = r9.f28589c
            com.google.android.exoplayer2.upstream.DataSpec$Builder r12 = r12.a()
            com.google.android.exoplayer2.upstream.DataSpec$Builder r12 = r12.h(r10)
            com.google.android.exoplayer2.upstream.DataSpec$Builder r12 = r12.g(r6)
            com.google.android.exoplayer2.upstream.DataSpec r12 = r12.a()
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r13 = r9.f28587a     // Catch:{ IOException -> 0x0056 }
            long r12 = r13.i(r12)     // Catch:{ IOException -> 0x0056 }
            goto L_0x005d
        L_0x0056:
            r10 = move-exception
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r11 = r9.f28587a
            com.google.android.exoplayer2.upstream.DataSourceUtil.a(r11)
            throw r10
        L_0x005d:
            if (r0 == 0) goto L_0x006a
            int r1 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x006a
            long r12 = r12 + r10
            r9.e(r12)     // Catch:{ IOException -> 0x0068 }
            goto L_0x006a
        L_0x0068:
            r10 = move-exception
            goto L_0x008b
        L_0x006a:
            r12 = 0
            r13 = 0
        L_0x006c:
            r1 = -1
            if (r12 == r1) goto L_0x0083
            r9.g()     // Catch:{ IOException -> 0x0068 }
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r12 = r9.f28587a     // Catch:{ IOException -> 0x0068 }
            byte[] r2 = r9.f28591e     // Catch:{ IOException -> 0x0068 }
            int r3 = r2.length     // Catch:{ IOException -> 0x0068 }
            int r12 = r12.read(r2, r5, r3)     // Catch:{ IOException -> 0x0068 }
            if (r12 == r1) goto L_0x006c
            long r1 = (long) r12     // Catch:{ IOException -> 0x0068 }
            r9.d(r1)     // Catch:{ IOException -> 0x0068 }
            int r13 = r13 + r12
            goto L_0x006c
        L_0x0083:
            if (r0 == 0) goto L_0x0091
            long r0 = (long) r13     // Catch:{ IOException -> 0x0068 }
            long r10 = r10 + r0
            r9.e(r10)     // Catch:{ IOException -> 0x0068 }
            goto L_0x0091
        L_0x008b:
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r11 = r9.f28587a
            com.google.android.exoplayer2.upstream.DataSourceUtil.a(r11)
            throw r10
        L_0x0091:
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r10 = r9.f28587a
            r10.close()
            long r10 = (long) r13
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.CacheWriter.f(long, long):long");
    }

    private void g() throws InterruptedIOException {
        if (this.f28596j) {
            throw new InterruptedIOException();
        }
    }

    public void a() throws IOException {
        long j2;
        g();
        Cache cache = this.f28588b;
        String str = this.f28590d;
        DataSpec dataSpec = this.f28589c;
        this.f28595i = cache.g(str, dataSpec.f28345g, dataSpec.f28346h);
        DataSpec dataSpec2 = this.f28589c;
        long j3 = dataSpec2.f28346h;
        if (j3 != -1) {
            this.f28594h = dataSpec2.f28345g + j3;
        } else {
            long a2 = c.a(this.f28588b.b(this.f28590d));
            if (a2 == -1) {
                a2 = -1;
            }
            this.f28594h = a2;
        }
        ProgressListener progressListener = this.f28592f;
        if (progressListener != null) {
            progressListener.a(c(), this.f28595i, 0);
        }
        while (true) {
            long j4 = this.f28594h;
            if (j4 == -1 || this.f28593g < j4) {
                g();
                long j5 = this.f28594h;
                if (j5 == -1) {
                    j2 = Long.MAX_VALUE;
                } else {
                    j2 = j5 - this.f28593g;
                }
                long h2 = this.f28588b.h(this.f28590d, this.f28593g, j2);
                if (h2 > 0) {
                    this.f28593g += h2;
                } else {
                    long j6 = -h2;
                    if (j6 == Clock.MAX_TIME) {
                        j6 = -1;
                    }
                    long j7 = this.f28593g;
                    this.f28593g = j7 + f(j7, j6);
                }
            } else {
                return;
            }
        }
    }

    public void b() {
        this.f28596j = true;
    }
}
