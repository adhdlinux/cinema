package com.google.android.exoplayer2.analytics;

import android.util.Base64;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import h0.n1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class DefaultPlaybackSessionManager implements PlaybackSessionManager {

    /* renamed from: h  reason: collision with root package name */
    public static final Supplier<String> f23580h = new n1();

    /* renamed from: i  reason: collision with root package name */
    private static final Random f23581i = new Random();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Timeline.Window f23582a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Timeline.Period f23583b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, SessionDescriptor> f23584c;

    /* renamed from: d  reason: collision with root package name */
    private final Supplier<String> f23585d;

    /* renamed from: e  reason: collision with root package name */
    private PlaybackSessionManager.Listener f23586e;

    /* renamed from: f  reason: collision with root package name */
    private Timeline f23587f;

    /* renamed from: g  reason: collision with root package name */
    private String f23588g;

    private final class SessionDescriptor {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f23589a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f23590b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public long f23591c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public MediaSource.MediaPeriodId f23592d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f23593e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public boolean f23594f;

        public SessionDescriptor(String str, int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            long j2;
            this.f23589a = str;
            this.f23590b = i2;
            if (mediaPeriodId == null) {
                j2 = -1;
            } else {
                j2 = mediaPeriodId.f25796d;
            }
            this.f23591c = j2;
            if (mediaPeriodId != null && mediaPeriodId.b()) {
                this.f23592d = mediaPeriodId;
            }
        }

        private int l(Timeline timeline, Timeline timeline2, int i2) {
            if (i2 < timeline.t()) {
                timeline.r(i2, DefaultPlaybackSessionManager.this.f23582a);
                for (int i3 = DefaultPlaybackSessionManager.this.f23582a.f23525p; i3 <= DefaultPlaybackSessionManager.this.f23582a.f23526q; i3++) {
                    int f2 = timeline2.f(timeline.q(i3));
                    if (f2 != -1) {
                        return timeline2.j(f2, DefaultPlaybackSessionManager.this.f23583b).f23494d;
                    }
                }
                return -1;
            } else if (i2 < timeline2.t()) {
                return i2;
            } else {
                return -1;
            }
        }

        public boolean i(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            if (mediaPeriodId != null) {
                MediaSource.MediaPeriodId mediaPeriodId2 = this.f23592d;
                if (mediaPeriodId2 == null) {
                    if (mediaPeriodId.b() || mediaPeriodId.f25796d != this.f23591c) {
                        return false;
                    }
                    return true;
                } else if (mediaPeriodId.f25796d == mediaPeriodId2.f25796d && mediaPeriodId.f25794b == mediaPeriodId2.f25794b && mediaPeriodId.f25795c == mediaPeriodId2.f25795c) {
                    return true;
                } else {
                    return false;
                }
            } else if (i2 == this.f23590b) {
                return true;
            } else {
                return false;
            }
        }

        public boolean j(AnalyticsListener.EventTime eventTime) {
            MediaSource.MediaPeriodId mediaPeriodId = eventTime.f23556d;
            if (mediaPeriodId != null) {
                long j2 = this.f23591c;
                if (j2 == -1) {
                    return false;
                }
                if (mediaPeriodId.f25796d > j2) {
                    return true;
                }
                if (this.f23592d == null) {
                    return false;
                }
                int f2 = eventTime.f23554b.f(mediaPeriodId.f25793a);
                int f3 = eventTime.f23554b.f(this.f23592d.f25793a);
                MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.f23556d;
                if (mediaPeriodId2.f25796d < this.f23592d.f25796d || f2 < f3) {
                    return false;
                }
                if (f2 > f3) {
                    return true;
                }
                if (mediaPeriodId2.b()) {
                    MediaSource.MediaPeriodId mediaPeriodId3 = eventTime.f23556d;
                    int i2 = mediaPeriodId3.f25794b;
                    int i3 = mediaPeriodId3.f25795c;
                    MediaSource.MediaPeriodId mediaPeriodId4 = this.f23592d;
                    int i4 = mediaPeriodId4.f25794b;
                    if (i2 > i4) {
                        return true;
                    }
                    if (i2 != i4 || i3 <= mediaPeriodId4.f25795c) {
                        return false;
                    }
                    return true;
                }
                int i5 = eventTime.f23556d.f25797e;
                if (i5 == -1 || i5 > this.f23592d.f25794b) {
                    return true;
                }
                return false;
            } else if (this.f23590b != eventTime.f23555c) {
                return true;
            } else {
                return false;
            }
        }

        public void k(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            if (this.f23591c == -1 && i2 == this.f23590b && mediaPeriodId != null) {
                this.f23591c = mediaPeriodId.f25796d;
            }
        }

        public boolean m(Timeline timeline, Timeline timeline2) {
            int l2 = l(timeline, timeline2, this.f23590b);
            this.f23590b = l2;
            if (l2 == -1) {
                return false;
            }
            MediaSource.MediaPeriodId mediaPeriodId = this.f23592d;
            if (mediaPeriodId != null && timeline2.f(mediaPeriodId.f25793a) == -1) {
                return false;
            }
            return true;
        }
    }

    public DefaultPlaybackSessionManager() {
        this(f23580h);
    }

    /* access modifiers changed from: private */
    public static String k() {
        byte[] bArr = new byte[12];
        f23581i.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private SessionDescriptor l(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        int i3;
        SessionDescriptor sessionDescriptor = null;
        long j2 = Clock.MAX_TIME;
        for (SessionDescriptor next : this.f23584c.values()) {
            next.k(i2, mediaPeriodId);
            if (next.i(i2, mediaPeriodId)) {
                long b2 = next.f23591c;
                if (b2 == -1 || b2 < j2) {
                    sessionDescriptor = next;
                    j2 = b2;
                } else if (!(i3 != 0 || ((SessionDescriptor) Util.j(sessionDescriptor)).f23592d == null || next.f23592d == null)) {
                    sessionDescriptor = next;
                }
            }
        }
        if (sessionDescriptor != null) {
            return sessionDescriptor;
        }
        String str = this.f23585d.get();
        SessionDescriptor sessionDescriptor2 = new SessionDescriptor(str, i2, mediaPeriodId);
        this.f23584c.put(str, sessionDescriptor2);
        return sessionDescriptor2;
    }

    @RequiresNonNull({"listener"})
    private void m(AnalyticsListener.EventTime eventTime) {
        if (eventTime.f23554b.u()) {
            this.f23588g = null;
            return;
        }
        SessionDescriptor sessionDescriptor = this.f23584c.get(this.f23588g);
        SessionDescriptor l2 = l(eventTime.f23555c, eventTime.f23556d);
        this.f23588g = l2.f23589a;
        d(eventTime);
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f23556d;
        if (mediaPeriodId != null && mediaPeriodId.b()) {
            if (sessionDescriptor == null || sessionDescriptor.f23591c != eventTime.f23556d.f25796d || sessionDescriptor.f23592d == null || sessionDescriptor.f23592d.f25794b != eventTime.f23556d.f25794b || sessionDescriptor.f23592d.f25795c != eventTime.f23556d.f25795c) {
                MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.f23556d;
                this.f23586e.z0(eventTime, l(eventTime.f23555c, new MediaSource.MediaPeriodId(mediaPeriodId2.f25793a, mediaPeriodId2.f25796d)).f23589a, l2.f23589a);
            }
        }
    }

    public synchronized String a() {
        return this.f23588g;
    }

    public void b(PlaybackSessionManager.Listener listener) {
        this.f23586e = listener;
    }

    public synchronized void c(AnalyticsListener.EventTime eventTime) {
        PlaybackSessionManager.Listener listener;
        this.f23588g = null;
        Iterator<SessionDescriptor> it2 = this.f23584c.values().iterator();
        while (it2.hasNext()) {
            SessionDescriptor next = it2.next();
            it2.remove();
            if (next.f23593e && (listener = this.f23586e) != null) {
                listener.e0(eventTime, next.f23589a, false);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0117, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void d(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime r25) {
        /*
            r24 = this;
            r1 = r24
            r0 = r25
            monitor-enter(r24)
            com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener r2 = r1.f23586e     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.util.Assertions.e(r2)     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.Timeline r2 = r0.f23554b     // Catch:{ all -> 0x0118 }
            boolean r2 = r2.u()     // Catch:{ all -> 0x0118 }
            if (r2 == 0) goto L_0x0014
            monitor-exit(r24)
            return
        L_0x0014:
            java.util.HashMap<java.lang.String, com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$SessionDescriptor> r2 = r1.f23584c     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = r1.f23588g     // Catch:{ all -> 0x0118 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$SessionDescriptor r2 = (com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor) r2     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r0.f23556d     // Catch:{ all -> 0x0118 }
            r4 = 1
            if (r3 == 0) goto L_0x004b
            if (r2 == 0) goto L_0x004b
            long r5 = r2.f23591c     // Catch:{ all -> 0x0118 }
            r7 = -1
            r3 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x003a
            int r2 = r2.f23590b     // Catch:{ all -> 0x0118 }
            int r5 = r0.f23555c     // Catch:{ all -> 0x0118 }
            if (r2 == r5) goto L_0x0047
        L_0x0038:
            r3 = 1
            goto L_0x0047
        L_0x003a:
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r5 = r0.f23556d     // Catch:{ all -> 0x0118 }
            long r5 = r5.f25796d     // Catch:{ all -> 0x0118 }
            long r7 = r2.f23591c     // Catch:{ all -> 0x0118 }
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 >= 0) goto L_0x0047
            goto L_0x0038
        L_0x0047:
            if (r3 == 0) goto L_0x004b
            monitor-exit(r24)
            return
        L_0x004b:
            int r2 = r0.f23555c     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r0.f23556d     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$SessionDescriptor r2 = r1.l(r2, r3)     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = r1.f23588g     // Catch:{ all -> 0x0118 }
            if (r3 != 0) goto L_0x005d
            java.lang.String r3 = r2.f23589a     // Catch:{ all -> 0x0118 }
            r1.f23588g = r3     // Catch:{ all -> 0x0118 }
        L_0x005d:
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r0.f23556d     // Catch:{ all -> 0x0118 }
            if (r3 == 0) goto L_0x00d9
            boolean r3 = r3.b()     // Catch:{ all -> 0x0118 }
            if (r3 == 0) goto L_0x00d9
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r10 = new com.google.android.exoplayer2.source.MediaSource$MediaPeriodId     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r0.f23556d     // Catch:{ all -> 0x0118 }
            java.lang.Object r5 = r3.f25793a     // Catch:{ all -> 0x0118 }
            long r6 = r3.f25796d     // Catch:{ all -> 0x0118 }
            int r3 = r3.f25794b     // Catch:{ all -> 0x0118 }
            r10.<init>(r5, r6, r3)     // Catch:{ all -> 0x0118 }
            int r3 = r0.f23555c     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$SessionDescriptor r3 = r1.l(r3, r10)     // Catch:{ all -> 0x0118 }
            boolean r5 = r3.f23593e     // Catch:{ all -> 0x0118 }
            if (r5 != 0) goto L_0x00d9
            boolean unused = r3.f23593e = r4     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.Timeline r5 = r0.f23554b     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r6 = r0.f23556d     // Catch:{ all -> 0x0118 }
            java.lang.Object r6 = r6.f25793a     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.Timeline$Period r7 = r1.f23583b     // Catch:{ all -> 0x0118 }
            r5.l(r6, r7)     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.Timeline$Period r5 = r1.f23583b     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r6 = r0.f23556d     // Catch:{ all -> 0x0118 }
            int r6 = r6.f25794b     // Catch:{ all -> 0x0118 }
            long r5 = r5.i(r6)     // Catch:{ all -> 0x0118 }
            long r5 = com.google.android.exoplayer2.util.Util.i1(r5)     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.Timeline$Period r7 = r1.f23583b     // Catch:{ all -> 0x0118 }
            long r7 = r7.p()     // Catch:{ all -> 0x0118 }
            long r5 = r5 + r7
            r7 = 0
            long r11 = java.lang.Math.max(r7, r5)     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime r15 = new com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime     // Catch:{ all -> 0x0118 }
            long r6 = r0.f23553a     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.Timeline r8 = r0.f23554b     // Catch:{ all -> 0x0118 }
            int r9 = r0.f23555c     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.Timeline r13 = r0.f23558f     // Catch:{ all -> 0x0118 }
            int r14 = r0.f23559g     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r5 = r0.f23560h     // Catch:{ all -> 0x0118 }
            r16 = r5
            long r4 = r0.f23561i     // Catch:{ all -> 0x0118 }
            r20 = r2
            r21 = r3
            long r2 = r0.f23562j     // Catch:{ all -> 0x0118 }
            r22 = r4
            r4 = r16
            r16 = r22
            r5 = r15
            r0 = r15
            r15 = r4
            r18 = r2
            r5.<init>(r6, r8, r9, r10, r11, r13, r14, r15, r16, r18)     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener r2 = r1.f23586e     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = r21.f23589a     // Catch:{ all -> 0x0118 }
            r2.r0(r0, r3)     // Catch:{ all -> 0x0118 }
            goto L_0x00db
        L_0x00d9:
            r20 = r2
        L_0x00db:
            boolean r0 = r20.f23593e     // Catch:{ all -> 0x0118 }
            if (r0 != 0) goto L_0x00f3
            r0 = r20
            r2 = 1
            boolean unused = r0.f23593e = r2     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener r2 = r1.f23586e     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = r0.f23589a     // Catch:{ all -> 0x0118 }
            r4 = r25
            r2.r0(r4, r3)     // Catch:{ all -> 0x0118 }
            goto L_0x00f7
        L_0x00f3:
            r4 = r25
            r0 = r20
        L_0x00f7:
            java.lang.String r2 = r0.f23589a     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = r1.f23588g     // Catch:{ all -> 0x0118 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0118 }
            if (r2 == 0) goto L_0x0116
            boolean r2 = r0.f23594f     // Catch:{ all -> 0x0118 }
            if (r2 != 0) goto L_0x0116
            r2 = 1
            boolean unused = r0.f23594f = r2     // Catch:{ all -> 0x0118 }
            com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener r2 = r1.f23586e     // Catch:{ all -> 0x0118 }
            java.lang.String r0 = r0.f23589a     // Catch:{ all -> 0x0118 }
            r2.f0(r4, r0)     // Catch:{ all -> 0x0118 }
        L_0x0116:
            monitor-exit(r24)
            return
        L_0x0118:
            r0 = move-exception
            monitor-exit(r24)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.d(com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime):void");
    }

    public synchronized void e(AnalyticsListener.EventTime eventTime, int i2) {
        boolean z2;
        boolean z3;
        Assertions.e(this.f23586e);
        if (i2 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator<SessionDescriptor> it2 = this.f23584c.values().iterator();
        while (it2.hasNext()) {
            SessionDescriptor next = it2.next();
            if (next.j(eventTime)) {
                it2.remove();
                if (next.f23593e) {
                    boolean equals = next.f23589a.equals(this.f23588g);
                    if (!z2 || !equals || !next.f23594f) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (equals) {
                        this.f23588g = null;
                    }
                    this.f23586e.e0(eventTime, next.f23589a, z3);
                }
            }
        }
        m(eventTime);
    }

    public synchronized void f(AnalyticsListener.EventTime eventTime) {
        Assertions.e(this.f23586e);
        Timeline timeline = this.f23587f;
        this.f23587f = eventTime.f23554b;
        Iterator<SessionDescriptor> it2 = this.f23584c.values().iterator();
        while (it2.hasNext()) {
            SessionDescriptor next = it2.next();
            if (!next.m(timeline, this.f23587f) || next.j(eventTime)) {
                it2.remove();
                if (next.f23593e) {
                    if (next.f23589a.equals(this.f23588g)) {
                        this.f23588g = null;
                    }
                    this.f23586e.e0(eventTime, next.f23589a, false);
                }
            }
        }
        m(eventTime);
    }

    public synchronized String g(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        return l(timeline.l(mediaPeriodId.f25793a, this.f23583b).f23494d, mediaPeriodId).f23589a;
    }

    public DefaultPlaybackSessionManager(Supplier<String> supplier) {
        this.f23585d = supplier;
        this.f23582a = new Timeline.Window();
        this.f23583b = new Timeline.Period();
        this.f23584c = new HashMap<>();
        this.f23587f = Timeline.f23481b;
    }
}
