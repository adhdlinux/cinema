package com.google.android.exoplayer2.util;

import com.facebook.common.time.Clock;

public final class TimestampAdjuster {

    /* renamed from: a  reason: collision with root package name */
    private long f28804a;

    /* renamed from: b  reason: collision with root package name */
    private long f28805b;

    /* renamed from: c  reason: collision with root package name */
    private long f28806c;

    /* renamed from: d  reason: collision with root package name */
    private final ThreadLocal<Long> f28807d = new ThreadLocal<>();

    public TimestampAdjuster(long j2) {
        g(j2);
    }

    public static long f(long j2) {
        return (j2 * 1000000) / 90000;
    }

    public static long i(long j2) {
        return (j2 * 90000) / 1000000;
    }

    public static long j(long j2) {
        return i(j2) % 8589934592L;
    }

    public synchronized long a(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f28805b == -9223372036854775807L) {
            long j3 = this.f28804a;
            if (j3 == 9223372036854775806L) {
                j3 = ((Long) Assertions.e(this.f28807d.get())).longValue();
            }
            this.f28805b = j3 - j2;
            notifyAll();
        }
        this.f28806c = j2;
        return j2 + this.f28805b;
    }

    public synchronized long b(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j3 = this.f28806c;
        if (j3 != -9223372036854775807L) {
            long i2 = i(j3);
            long j4 = (4294967296L + i2) / 8589934592L;
            long j5 = ((j4 - 1) * 8589934592L) + j2;
            j2 += j4 * 8589934592L;
            if (Math.abs(j5 - i2) < Math.abs(j2 - i2)) {
                j2 = j5;
            }
        }
        return a(f(j2));
    }

    public synchronized long c() {
        long j2;
        j2 = this.f28804a;
        if (j2 == Clock.MAX_TIME || j2 == 9223372036854775806L) {
            j2 = -9223372036854775807L;
        }
        return j2;
    }

    public synchronized long d() {
        long j2;
        long j3 = this.f28806c;
        if (j3 != -9223372036854775807L) {
            j2 = j3 + this.f28805b;
        } else {
            j2 = c();
        }
        return j2;
    }

    public synchronized long e() {
        return this.f28805b;
    }

    public synchronized void g(long j2) {
        long j3;
        this.f28804a = j2;
        if (j2 == Clock.MAX_TIME) {
            j3 = 0;
        } else {
            j3 = -9223372036854775807L;
        }
        this.f28805b = j3;
        this.f28806c = -9223372036854775807L;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void h(boolean r6, long r7) throws java.lang.InterruptedException {
        /*
            r5 = this;
            monitor-enter(r5)
            long r0 = r5.f28804a     // Catch:{ all -> 0x0037 }
            r2 = 9223372036854775806(0x7ffffffffffffffe, double:NaN)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            com.google.android.exoplayer2.util.Assertions.g(r0)     // Catch:{ all -> 0x0037 }
            long r0 = r5.f28805b     // Catch:{ all -> 0x0037 }
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
            monitor-exit(r5)
            return
        L_0x001f:
            if (r6 == 0) goto L_0x002b
            java.lang.ThreadLocal<java.lang.Long> r6 = r5.f28807d     // Catch:{ all -> 0x0037 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0037 }
            r6.set(r7)     // Catch:{ all -> 0x0037 }
            goto L_0x0035
        L_0x002b:
            long r6 = r5.f28805b     // Catch:{ all -> 0x0037 }
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x0035
            r5.wait()     // Catch:{ all -> 0x0037 }
            goto L_0x002b
        L_0x0035:
            monitor-exit(r5)
            return
        L_0x0037:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.TimestampAdjuster.h(boolean, long):void");
    }
}
