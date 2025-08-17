package androidx.media3.exoplayer;

import android.os.Looper;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;

public final class PlayerMessage {

    /* renamed from: a  reason: collision with root package name */
    private final Target f5484a;

    /* renamed from: b  reason: collision with root package name */
    private final Sender f5485b;

    /* renamed from: c  reason: collision with root package name */
    private final Clock f5486c;

    /* renamed from: d  reason: collision with root package name */
    private final Timeline f5487d;

    /* renamed from: e  reason: collision with root package name */
    private int f5488e;

    /* renamed from: f  reason: collision with root package name */
    private Object f5489f;

    /* renamed from: g  reason: collision with root package name */
    private Looper f5490g;

    /* renamed from: h  reason: collision with root package name */
    private int f5491h;

    /* renamed from: i  reason: collision with root package name */
    private long f5492i = -9223372036854775807L;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5493j = true;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5494k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5495l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f5496m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f5497n;

    public interface Sender {
        void e(PlayerMessage playerMessage);
    }

    public interface Target {
        void j(int i2, Object obj) throws ExoPlaybackException;
    }

    public PlayerMessage(Sender sender, Target target, Timeline timeline, int i2, Clock clock, Looper looper) {
        this.f5485b = sender;
        this.f5484a = target;
        this.f5487d = timeline;
        this.f5490g = looper;
        this.f5486c = clock;
        this.f5491h = i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040 A[SYNTHETIC, Splitter:B:16:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(long r7) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.f5494k     // Catch:{ all -> 0x0048 }
            androidx.media3.common.util.Assertions.h(r0)     // Catch:{ all -> 0x0048 }
            android.os.Looper r0 = r6.f5490g     // Catch:{ all -> 0x0048 }
            java.lang.Thread r0 = r0.getThread()     // Catch:{ all -> 0x0048 }
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0048 }
            if (r0 == r1) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            androidx.media3.common.util.Assertions.h(r0)     // Catch:{ all -> 0x0048 }
            androidx.media3.common.util.Clock r0 = r6.f5486c     // Catch:{ all -> 0x0048 }
            long r0 = r0.elapsedRealtime()     // Catch:{ all -> 0x0048 }
            long r0 = r0 + r7
        L_0x001f:
            boolean r2 = r6.f5496m     // Catch:{ all -> 0x0048 }
            if (r2 != 0) goto L_0x003a
            r3 = 0
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x003a
            androidx.media3.common.util.Clock r2 = r6.f5486c     // Catch:{ all -> 0x0048 }
            r2.c()     // Catch:{ all -> 0x0048 }
            r6.wait(r7)     // Catch:{ all -> 0x0048 }
            androidx.media3.common.util.Clock r7 = r6.f5486c     // Catch:{ all -> 0x0048 }
            long r7 = r7.elapsedRealtime()     // Catch:{ all -> 0x0048 }
            long r7 = r0 - r7
            goto L_0x001f
        L_0x003a:
            if (r2 == 0) goto L_0x0040
            boolean r7 = r6.f5495l     // Catch:{ all -> 0x0048 }
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.PlayerMessage.a(long):boolean");
    }

    public boolean b() {
        return this.f5493j;
    }

    public Looper c() {
        return this.f5490g;
    }

    public int d() {
        return this.f5491h;
    }

    public Object e() {
        return this.f5489f;
    }

    public long f() {
        return this.f5492i;
    }

    public Target g() {
        return this.f5484a;
    }

    public Timeline h() {
        return this.f5487d;
    }

    public int i() {
        return this.f5488e;
    }

    public synchronized boolean j() {
        return this.f5497n;
    }

    public synchronized void k(boolean z2) {
        this.f5495l = z2 | this.f5495l;
        this.f5496m = true;
        notifyAll();
    }

    public PlayerMessage l() {
        Assertions.h(!this.f5494k);
        if (this.f5492i == -9223372036854775807L) {
            Assertions.a(this.f5493j);
        }
        this.f5494k = true;
        this.f5485b.e(this);
        return this;
    }

    public PlayerMessage m(Object obj) {
        Assertions.h(!this.f5494k);
        this.f5489f = obj;
        return this;
    }

    public PlayerMessage n(int i2) {
        Assertions.h(!this.f5494k);
        this.f5488e = i2;
        return this;
    }
}
