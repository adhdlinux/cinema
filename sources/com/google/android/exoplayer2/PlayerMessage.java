package com.google.android.exoplayer2;

import android.os.Looper;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;

public final class PlayerMessage {

    /* renamed from: a  reason: collision with root package name */
    private final Target f23427a;

    /* renamed from: b  reason: collision with root package name */
    private final Sender f23428b;

    /* renamed from: c  reason: collision with root package name */
    private final Clock f23429c;

    /* renamed from: d  reason: collision with root package name */
    private final Timeline f23430d;

    /* renamed from: e  reason: collision with root package name */
    private int f23431e;

    /* renamed from: f  reason: collision with root package name */
    private Object f23432f;

    /* renamed from: g  reason: collision with root package name */
    private Looper f23433g;

    /* renamed from: h  reason: collision with root package name */
    private int f23434h;

    /* renamed from: i  reason: collision with root package name */
    private long f23435i = -9223372036854775807L;

    /* renamed from: j  reason: collision with root package name */
    private boolean f23436j = true;

    /* renamed from: k  reason: collision with root package name */
    private boolean f23437k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f23438l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f23439m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f23440n;

    public interface Sender {
        void e(PlayerMessage playerMessage);
    }

    public interface Target {
        void j(int i2, Object obj) throws ExoPlaybackException;
    }

    public PlayerMessage(Sender sender, Target target, Timeline timeline, int i2, Clock clock, Looper looper) {
        this.f23428b = sender;
        this.f23427a = target;
        this.f23430d = timeline;
        this.f23433g = looper;
        this.f23429c = clock;
        this.f23434h = i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040 A[SYNTHETIC, Splitter:B:16:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(long r7) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.f23437k     // Catch:{ all -> 0x0048 }
            com.google.android.exoplayer2.util.Assertions.g(r0)     // Catch:{ all -> 0x0048 }
            android.os.Looper r0 = r6.f23433g     // Catch:{ all -> 0x0048 }
            java.lang.Thread r0 = r0.getThread()     // Catch:{ all -> 0x0048 }
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0048 }
            if (r0 == r1) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            com.google.android.exoplayer2.util.Assertions.g(r0)     // Catch:{ all -> 0x0048 }
            com.google.android.exoplayer2.util.Clock r0 = r6.f23429c     // Catch:{ all -> 0x0048 }
            long r0 = r0.elapsedRealtime()     // Catch:{ all -> 0x0048 }
            long r0 = r0 + r7
        L_0x001f:
            boolean r2 = r6.f23439m     // Catch:{ all -> 0x0048 }
            if (r2 != 0) goto L_0x003a
            r3 = 0
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x003a
            com.google.android.exoplayer2.util.Clock r2 = r6.f23429c     // Catch:{ all -> 0x0048 }
            r2.c()     // Catch:{ all -> 0x0048 }
            r6.wait(r7)     // Catch:{ all -> 0x0048 }
            com.google.android.exoplayer2.util.Clock r7 = r6.f23429c     // Catch:{ all -> 0x0048 }
            long r7 = r7.elapsedRealtime()     // Catch:{ all -> 0x0048 }
            long r7 = r0 - r7
            goto L_0x001f
        L_0x003a:
            if (r2 == 0) goto L_0x0040
            boolean r7 = r6.f23438l     // Catch:{ all -> 0x0048 }
            monitor-exit(r6)
            return r7
        L_0x0040:
            java.util.concurrent.TimeoutException r7 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x0048 }
            java.lang.String r8 = "Message delivery timed out."
            r7.<init>(r8)     // Catch:{ all -> 0x0048 }
            throw r7     // Catch:{ all -> 0x0048 }
        L_0x0048:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.PlayerMessage.a(long):boolean");
    }

    public boolean b() {
        return this.f23436j;
    }

    public Looper c() {
        return this.f23433g;
    }

    public int d() {
        return this.f23434h;
    }

    public Object e() {
        return this.f23432f;
    }

    public long f() {
        return this.f23435i;
    }

    public Target g() {
        return this.f23427a;
    }

    public Timeline h() {
        return this.f23430d;
    }

    public int i() {
        return this.f23431e;
    }

    public synchronized boolean j() {
        return this.f23440n;
    }

    public synchronized void k(boolean z2) {
        this.f23438l = z2 | this.f23438l;
        this.f23439m = true;
        notifyAll();
    }

    public PlayerMessage l() {
        Assertions.g(!this.f23437k);
        if (this.f23435i == -9223372036854775807L) {
            Assertions.a(this.f23436j);
        }
        this.f23437k = true;
        this.f23428b.e(this);
        return this;
    }

    public PlayerMessage m(Object obj) {
        Assertions.g(!this.f23437k);
        this.f23432f = obj;
        return this;
    }

    public PlayerMessage n(int i2) {
        Assertions.g(!this.f23437k);
        this.f23431e = i2;
        return this;
    }
}
