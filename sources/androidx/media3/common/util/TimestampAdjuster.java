package androidx.media3.common.util;

import com.facebook.common.time.Clock;

public final class TimestampAdjuster {

    /* renamed from: a  reason: collision with root package name */
    private long f4710a;

    /* renamed from: b  reason: collision with root package name */
    private long f4711b;

    /* renamed from: c  reason: collision with root package name */
    private long f4712c;

    /* renamed from: d  reason: collision with root package name */
    private final ThreadLocal<Long> f4713d = new ThreadLocal<>();

    public TimestampAdjuster(long j2) {
        i(j2);
    }

    public static long h(long j2) {
        return (j2 * 1000000) / 90000;
    }

    public static long k(long j2) {
        return (j2 * 90000) / 1000000;
    }

    public static long l(long j2) {
        return k(j2) % 8589934592L;
    }

    public synchronized long a(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (!g()) {
            long j3 = this.f4710a;
            if (j3 == 9223372036854775806L) {
                j3 = ((Long) Assertions.f(this.f4713d.get())).longValue();
            }
            this.f4711b = j3 - j2;
            notifyAll();
        }
        this.f4712c = j2;
        return j2 + this.f4711b;
    }

    public synchronized long b(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j3 = this.f4712c;
        if (j3 != -9223372036854775807L) {
            long k2 = k(j3);
            long j4 = (4294967296L + k2) / 8589934592L;
            long j5 = ((j4 - 1) * 8589934592L) + j2;
            j2 += j4 * 8589934592L;
            if (Math.abs(j5 - k2) < Math.abs(j2 - k2)) {
                j2 = j5;
            }
        }
        return a(h(j2));
    }

    public synchronized long c(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j3 = this.f4712c;
        if (j3 != -9223372036854775807L) {
            long k2 = k(j3);
            long j4 = k2 / 8589934592L;
            Long.signum(j4);
            long j5 = (j4 * 8589934592L) + j2;
            j2 += (j4 + 1) * 8589934592L;
            if (j5 >= k2) {
                j2 = j5;
            }
        }
        return a(h(j2));
    }

    public synchronized long d() {
        long j2;
        j2 = this.f4710a;
        if (j2 == Clock.MAX_TIME || j2 == 9223372036854775806L) {
            j2 = -9223372036854775807L;
        }
        return j2;
    }

    public synchronized long e() {
        long j2;
        long j3 = this.f4712c;
        if (j3 != -9223372036854775807L) {
            j2 = j3 + this.f4711b;
        } else {
            j2 = d();
        }
        return j2;
    }

    public synchronized long f() {
        return this.f4711b;
    }

    public synchronized boolean g() {
        boolean z2;
        if (this.f4711b != -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        return z2;
    }

    public synchronized void i(long j2) {
        long j3;
        this.f4710a = j2;
        if (j2 == Clock.MAX_TIME) {
            j3 = 0;
        } else {
            j3 = -9223372036854775807L;
        }
        this.f4711b = j3;
        this.f4712c = -9223372036854775807L;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void j(boolean r9, long r10, long r12) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            r8 = this;
            monitor-enter(r8)
            long r0 = r8.f4710a     // Catch:{ all -> 0x007d }
            r2 = 9223372036854775806(0x7ffffffffffffffe, double:NaN)
            r4 = 1
            r5 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            androidx.media3.common.util.Assertions.h(r0)     // Catch:{ all -> 0x007d }
            boolean r0 = r8.g()     // Catch:{ all -> 0x007d }
            if (r0 == 0) goto L_0x001c
            monitor-exit(r8)
            return
        L_0x001c:
            if (r9 == 0) goto L_0x0028
            java.lang.ThreadLocal<java.lang.Long> r9 = r8.f4713d     // Catch:{ all -> 0x007d }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x007d }
            r9.set(r10)     // Catch:{ all -> 0x007d }
            goto L_0x007b
        L_0x0028:
            r9 = 0
            r2 = r9
            r0 = r12
        L_0x002c:
            boolean r11 = r8.g()     // Catch:{ all -> 0x007d }
            if (r11 != 0) goto L_0x007b
            int r11 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x003a
            r8.wait()     // Catch:{ all -> 0x007d }
            goto L_0x002c
        L_0x003a:
            int r11 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r11 <= 0) goto L_0x0040
            r11 = 1
            goto L_0x0041
        L_0x0040:
            r11 = 0
        L_0x0041:
            androidx.media3.common.util.Assertions.h(r11)     // Catch:{ all -> 0x007d }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x007d }
            r8.wait(r0)     // Catch:{ all -> 0x007d }
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x007d }
            long r0 = r0 - r6
            long r2 = r2 + r0
            int r11 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r11 < 0) goto L_0x0078
            boolean r11 = r8.g()     // Catch:{ all -> 0x007d }
            if (r11 == 0) goto L_0x005c
            goto L_0x0078
        L_0x005c:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            r9.<init>()     // Catch:{ all -> 0x007d }
            java.lang.String r10 = "TimestampAdjuster failed to initialize in "
            r9.append(r10)     // Catch:{ all -> 0x007d }
            r9.append(r12)     // Catch:{ all -> 0x007d }
            java.lang.String r10 = " milliseconds"
            r9.append(r10)     // Catch:{ all -> 0x007d }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x007d }
            java.util.concurrent.TimeoutException r10 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x007d }
            r10.<init>(r9)     // Catch:{ all -> 0x007d }
            throw r10     // Catch:{ all -> 0x007d }
        L_0x0078:
            long r0 = r12 - r2
            goto L_0x002c
        L_0x007b:
            monitor-exit(r8)
            return
        L_0x007d:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.TimestampAdjuster.j(boolean, long, long):void");
    }
}
