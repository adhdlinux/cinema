package androidx.media3.exoplayer.analytics;

import android.util.Base64;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.PlaybackSessionManager;
import androidx.media3.exoplayer.source.MediaSource;
import com.facebook.common.time.Clock;
import com.google.common.base.Supplier;
import f.n1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class DefaultPlaybackSessionManager implements PlaybackSessionManager {

    /* renamed from: i  reason: collision with root package name */
    public static final Supplier<String> f5569i = new n1();

    /* renamed from: j  reason: collision with root package name */
    private static final Random f5570j = new Random();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Timeline.Window f5571a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Timeline.Period f5572b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, SessionDescriptor> f5573c;

    /* renamed from: d  reason: collision with root package name */
    private final Supplier<String> f5574d;

    /* renamed from: e  reason: collision with root package name */
    private PlaybackSessionManager.Listener f5575e;

    /* renamed from: f  reason: collision with root package name */
    private Timeline f5576f;

    /* renamed from: g  reason: collision with root package name */
    private String f5577g;

    /* renamed from: h  reason: collision with root package name */
    private long f5578h;

    private final class SessionDescriptor {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f5579a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f5580b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public long f5581c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public MediaSource.MediaPeriodId f5582d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f5583e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public boolean f5584f;

        public SessionDescriptor(String str, int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            long j2;
            this.f5579a = str;
            this.f5580b = i2;
            if (mediaPeriodId == null) {
                j2 = -1;
            } else {
                j2 = mediaPeriodId.f6974d;
            }
            this.f5581c = j2;
            if (mediaPeriodId != null && mediaPeriodId.b()) {
                this.f5582d = mediaPeriodId;
            }
        }

        private int l(Timeline timeline, Timeline timeline2, int i2) {
            if (i2 < timeline.p()) {
                timeline.n(i2, DefaultPlaybackSessionManager.this.f5571a);
                for (int i3 = DefaultPlaybackSessionManager.this.f5571a.f4385n; i3 <= DefaultPlaybackSessionManager.this.f5571a.f4386o; i3++) {
                    int b2 = timeline2.b(timeline.m(i3));
                    if (b2 != -1) {
                        return timeline2.f(b2, DefaultPlaybackSessionManager.this.f5572b).f4357c;
                    }
                }
                return -1;
            } else if (i2 < timeline2.p()) {
                return i2;
            } else {
                return -1;
            }
        }

        public boolean i(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            if (mediaPeriodId != null) {
                MediaSource.MediaPeriodId mediaPeriodId2 = this.f5582d;
                if (mediaPeriodId2 == null) {
                    if (mediaPeriodId.b() || mediaPeriodId.f6974d != this.f5581c) {
                        return false;
                    }
                    return true;
                } else if (mediaPeriodId.f6974d == mediaPeriodId2.f6974d && mediaPeriodId.f6972b == mediaPeriodId2.f6972b && mediaPeriodId.f6973c == mediaPeriodId2.f6973c) {
                    return true;
                } else {
                    return false;
                }
            } else if (i2 == this.f5580b) {
                return true;
            } else {
                return false;
            }
        }

        public boolean j(AnalyticsListener.EventTime eventTime) {
            MediaSource.MediaPeriodId mediaPeriodId = eventTime.f5545d;
            if (mediaPeriodId != null) {
                long j2 = this.f5581c;
                if (j2 == -1) {
                    return false;
                }
                if (mediaPeriodId.f6974d > j2) {
                    return true;
                }
                if (this.f5582d == null) {
                    return false;
                }
                int b2 = eventTime.f5543b.b(mediaPeriodId.f6971a);
                int b3 = eventTime.f5543b.b(this.f5582d.f6971a);
                MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.f5545d;
                if (mediaPeriodId2.f6974d < this.f5582d.f6974d || b2 < b3) {
                    return false;
                }
                if (b2 > b3) {
                    return true;
                }
                if (mediaPeriodId2.b()) {
                    MediaSource.MediaPeriodId mediaPeriodId3 = eventTime.f5545d;
                    int i2 = mediaPeriodId3.f6972b;
                    int i3 = mediaPeriodId3.f6973c;
                    MediaSource.MediaPeriodId mediaPeriodId4 = this.f5582d;
                    int i4 = mediaPeriodId4.f6972b;
                    if (i2 > i4) {
                        return true;
                    }
                    if (i2 != i4 || i3 <= mediaPeriodId4.f6973c) {
                        return false;
                    }
                    return true;
                }
                int i5 = eventTime.f5545d.f6975e;
                if (i5 == -1 || i5 > this.f5582d.f6972b) {
                    return true;
                }
                return false;
            } else if (this.f5580b != eventTime.f5544c) {
                return true;
            } else {
                return false;
            }
        }

        public void k(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            if (this.f5581c == -1 && i2 == this.f5580b && mediaPeriodId != null && mediaPeriodId.f6974d >= DefaultPlaybackSessionManager.this.n()) {
                this.f5581c = mediaPeriodId.f6974d;
            }
        }

        public boolean m(Timeline timeline, Timeline timeline2) {
            int l2 = l(timeline, timeline2, this.f5580b);
            this.f5580b = l2;
            if (l2 == -1) {
                return false;
            }
            MediaSource.MediaPeriodId mediaPeriodId = this.f5582d;
            if (mediaPeriodId != null && timeline2.b(mediaPeriodId.f6971a) == -1) {
                return false;
            }
            return true;
        }
    }

    public DefaultPlaybackSessionManager() {
        this(f5569i);
    }

    private void l(SessionDescriptor sessionDescriptor) {
        if (sessionDescriptor.f5581c != -1) {
            this.f5578h = sessionDescriptor.f5581c;
        }
        this.f5577g = null;
    }

    /* access modifiers changed from: private */
    public static String m() {
        byte[] bArr = new byte[12];
        f5570j.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    /* access modifiers changed from: private */
    public long n() {
        SessionDescriptor sessionDescriptor = this.f5573c.get(this.f5577g);
        if (sessionDescriptor == null || sessionDescriptor.f5581c == -1) {
            return this.f5578h + 1;
        }
        return sessionDescriptor.f5581c;
    }

    private SessionDescriptor o(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        int i3;
        SessionDescriptor sessionDescriptor = null;
        long j2 = Clock.MAX_TIME;
        for (SessionDescriptor next : this.f5573c.values()) {
            next.k(i2, mediaPeriodId);
            if (next.i(i2, mediaPeriodId)) {
                long b2 = next.f5581c;
                if (b2 == -1 || b2 < j2) {
                    sessionDescriptor = next;
                    j2 = b2;
                } else if (!(i3 != 0 || ((SessionDescriptor) Util.i(sessionDescriptor)).f5582d == null || next.f5582d == null)) {
                    sessionDescriptor = next;
                }
            }
        }
        if (sessionDescriptor != null) {
            return sessionDescriptor;
        }
        String str = this.f5574d.get();
        SessionDescriptor sessionDescriptor2 = new SessionDescriptor(str, i2, mediaPeriodId);
        this.f5573c.put(str, sessionDescriptor2);
        return sessionDescriptor2;
    }

    @RequiresNonNull({"listener"})
    private void p(AnalyticsListener.EventTime eventTime) {
        if (eventTime.f5543b.q()) {
            String str = this.f5577g;
            if (str != null) {
                l((SessionDescriptor) Assertions.f(this.f5573c.get(str)));
                return;
            }
            return;
        }
        SessionDescriptor sessionDescriptor = this.f5573c.get(this.f5577g);
        SessionDescriptor o2 = o(eventTime.f5544c, eventTime.f5545d);
        this.f5577g = o2.f5579a;
        b(eventTime);
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f5545d;
        if (mediaPeriodId != null && mediaPeriodId.b()) {
            if (sessionDescriptor == null || sessionDescriptor.f5581c != eventTime.f5545d.f6974d || sessionDescriptor.f5582d == null || sessionDescriptor.f5582d.f6972b != eventTime.f5545d.f6972b || sessionDescriptor.f5582d.f6973c != eventTime.f5545d.f6973c) {
                MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.f5545d;
                this.f5575e.c(eventTime, o(eventTime.f5544c, new MediaSource.MediaPeriodId(mediaPeriodId2.f6971a, mediaPeriodId2.f6974d)).f5579a, o2.f5579a);
            }
        }
    }

    public synchronized String a() {
        return this.f5577g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0111, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(androidx.media3.exoplayer.analytics.AnalyticsListener.EventTime r25) {
        /*
            r24 = this;
            r1 = r24
            r0 = r25
            monitor-enter(r24)
            androidx.media3.exoplayer.analytics.PlaybackSessionManager$Listener r2 = r1.f5575e     // Catch:{ all -> 0x0112 }
            androidx.media3.common.util.Assertions.f(r2)     // Catch:{ all -> 0x0112 }
            androidx.media3.common.Timeline r2 = r0.f5543b     // Catch:{ all -> 0x0112 }
            boolean r2 = r2.q()     // Catch:{ all -> 0x0112 }
            if (r2 == 0) goto L_0x0014
            monitor-exit(r24)
            return
        L_0x0014:
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r0.f5545d     // Catch:{ all -> 0x0112 }
            if (r2 == 0) goto L_0x0044
            long r2 = r2.f6974d     // Catch:{ all -> 0x0112 }
            long r4 = r24.n()     // Catch:{ all -> 0x0112 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0024
            monitor-exit(r24)
            return
        L_0x0024:
            java.util.HashMap<java.lang.String, androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager$SessionDescriptor> r2 = r1.f5573c     // Catch:{ all -> 0x0112 }
            java.lang.String r3 = r1.f5577g     // Catch:{ all -> 0x0112 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0112 }
            androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager$SessionDescriptor r2 = (androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager.SessionDescriptor) r2     // Catch:{ all -> 0x0112 }
            if (r2 == 0) goto L_0x0044
            long r3 = r2.f5581c     // Catch:{ all -> 0x0112 }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0044
            int r2 = r2.f5580b     // Catch:{ all -> 0x0112 }
            int r3 = r0.f5544c     // Catch:{ all -> 0x0112 }
            if (r2 == r3) goto L_0x0044
            monitor-exit(r24)
            return
        L_0x0044:
            int r2 = r0.f5544c     // Catch:{ all -> 0x0112 }
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = r0.f5545d     // Catch:{ all -> 0x0112 }
            androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager$SessionDescriptor r2 = r1.o(r2, r3)     // Catch:{ all -> 0x0112 }
            java.lang.String r3 = r1.f5577g     // Catch:{ all -> 0x0112 }
            if (r3 != 0) goto L_0x0056
            java.lang.String r3 = r2.f5579a     // Catch:{ all -> 0x0112 }
            r1.f5577g = r3     // Catch:{ all -> 0x0112 }
        L_0x0056:
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = r0.f5545d     // Catch:{ all -> 0x0112 }
            r4 = 1
            if (r3 == 0) goto L_0x00d3
            boolean r3 = r3.b()     // Catch:{ all -> 0x0112 }
            if (r3 == 0) goto L_0x00d3
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r10 = new androidx.media3.exoplayer.source.MediaSource$MediaPeriodId     // Catch:{ all -> 0x0112 }
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = r0.f5545d     // Catch:{ all -> 0x0112 }
            java.lang.Object r5 = r3.f6971a     // Catch:{ all -> 0x0112 }
            long r6 = r3.f6974d     // Catch:{ all -> 0x0112 }
            int r3 = r3.f6972b     // Catch:{ all -> 0x0112 }
            r10.<init>(r5, r6, r3)     // Catch:{ all -> 0x0112 }
            int r3 = r0.f5544c     // Catch:{ all -> 0x0112 }
            androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager$SessionDescriptor r3 = r1.o(r3, r10)     // Catch:{ all -> 0x0112 }
            boolean r5 = r3.f5583e     // Catch:{ all -> 0x0112 }
            if (r5 != 0) goto L_0x00d3
            boolean unused = r3.f5583e = r4     // Catch:{ all -> 0x0112 }
            androidx.media3.common.Timeline r5 = r0.f5543b     // Catch:{ all -> 0x0112 }
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r6 = r0.f5545d     // Catch:{ all -> 0x0112 }
            java.lang.Object r6 = r6.f6971a     // Catch:{ all -> 0x0112 }
            androidx.media3.common.Timeline$Period r7 = r1.f5572b     // Catch:{ all -> 0x0112 }
            r5.h(r6, r7)     // Catch:{ all -> 0x0112 }
            androidx.media3.common.Timeline$Period r5 = r1.f5572b     // Catch:{ all -> 0x0112 }
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r6 = r0.f5545d     // Catch:{ all -> 0x0112 }
            int r6 = r6.f6972b     // Catch:{ all -> 0x0112 }
            long r5 = r5.f(r6)     // Catch:{ all -> 0x0112 }
            long r5 = androidx.media3.common.util.Util.t1(r5)     // Catch:{ all -> 0x0112 }
            androidx.media3.common.Timeline$Period r7 = r1.f5572b     // Catch:{ all -> 0x0112 }
            long r7 = r7.m()     // Catch:{ all -> 0x0112 }
            long r5 = r5 + r7
            r7 = 0
            long r11 = java.lang.Math.max(r7, r5)     // Catch:{ all -> 0x0112 }
            androidx.media3.exoplayer.analytics.AnalyticsListener$EventTime r15 = new androidx.media3.exoplayer.analytics.AnalyticsListener$EventTime     // Catch:{ all -> 0x0112 }
            long r6 = r0.f5542a     // Catch:{ all -> 0x0112 }
            androidx.media3.common.Timeline r8 = r0.f5543b     // Catch:{ all -> 0x0112 }
            int r9 = r0.f5544c     // Catch:{ all -> 0x0112 }
            androidx.media3.common.Timeline r13 = r0.f5547f     // Catch:{ all -> 0x0112 }
            int r14 = r0.f5548g     // Catch:{ all -> 0x0112 }
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r5 = r0.f5549h     // Catch:{ all -> 0x0112 }
            r16 = r5
            long r4 = r0.f5550i     // Catch:{ all -> 0x0112 }
            r20 = r2
            r21 = r3
            long r2 = r0.f5551j     // Catch:{ all -> 0x0112 }
            r22 = r4
            r4 = r16
            r16 = r22
            r5 = r15
            r0 = r15
            r15 = r4
            r18 = r2
            r5.<init>(r6, r8, r9, r10, r11, r13, r14, r15, r16, r18)     // Catch:{ all -> 0x0112 }
            androidx.media3.exoplayer.analytics.PlaybackSessionManager$Listener r2 = r1.f5575e     // Catch:{ all -> 0x0112 }
            java.lang.String r3 = r21.f5579a     // Catch:{ all -> 0x0112 }
            r2.p0(r0, r3)     // Catch:{ all -> 0x0112 }
            goto L_0x00d5
        L_0x00d3:
            r20 = r2
        L_0x00d5:
            boolean r0 = r20.f5583e     // Catch:{ all -> 0x0112 }
            if (r0 != 0) goto L_0x00ed
            r0 = r20
            r2 = 1
            boolean unused = r0.f5583e = r2     // Catch:{ all -> 0x0112 }
            androidx.media3.exoplayer.analytics.PlaybackSessionManager$Listener r2 = r1.f5575e     // Catch:{ all -> 0x0112 }
            java.lang.String r3 = r0.f5579a     // Catch:{ all -> 0x0112 }
            r4 = r25
            r2.p0(r4, r3)     // Catch:{ all -> 0x0112 }
            goto L_0x00f1
        L_0x00ed:
            r4 = r25
            r0 = r20
        L_0x00f1:
            java.lang.String r2 = r0.f5579a     // Catch:{ all -> 0x0112 }
            java.lang.String r3 = r1.f5577g     // Catch:{ all -> 0x0112 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0112 }
            if (r2 == 0) goto L_0x0110
            boolean r2 = r0.f5584f     // Catch:{ all -> 0x0112 }
            if (r2 != 0) goto L_0x0110
            r2 = 1
            boolean unused = r0.f5584f = r2     // Catch:{ all -> 0x0112 }
            androidx.media3.exoplayer.analytics.PlaybackSessionManager$Listener r2 = r1.f5575e     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = r0.f5579a     // Catch:{ all -> 0x0112 }
            r2.s0(r4, r0)     // Catch:{ all -> 0x0112 }
        L_0x0110:
            monitor-exit(r24)
            return
        L_0x0112:
            r0 = move-exception
            monitor-exit(r24)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager.b(androidx.media3.exoplayer.analytics.AnalyticsListener$EventTime):void");
    }

    public synchronized String c(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        return o(timeline.h(mediaPeriodId.f6971a, this.f5572b).f4357c, mediaPeriodId).f5579a;
    }

    public synchronized void d(AnalyticsListener.EventTime eventTime) {
        Assertions.f(this.f5575e);
        Timeline timeline = this.f5576f;
        this.f5576f = eventTime.f5543b;
        Iterator<SessionDescriptor> it2 = this.f5573c.values().iterator();
        while (it2.hasNext()) {
            SessionDescriptor next = it2.next();
            if (!next.m(timeline, this.f5576f) || next.j(eventTime)) {
                it2.remove();
                if (next.f5583e) {
                    if (next.f5579a.equals(this.f5577g)) {
                        l(next);
                    }
                    this.f5575e.g0(eventTime, next.f5579a, false);
                }
            }
        }
        p(eventTime);
    }

    public synchronized void e(AnalyticsListener.EventTime eventTime) {
        PlaybackSessionManager.Listener listener;
        String str = this.f5577g;
        if (str != null) {
            l((SessionDescriptor) Assertions.f(this.f5573c.get(str)));
        }
        Iterator<SessionDescriptor> it2 = this.f5573c.values().iterator();
        while (it2.hasNext()) {
            SessionDescriptor next = it2.next();
            it2.remove();
            if (next.f5583e && (listener = this.f5575e) != null) {
                listener.g0(eventTime, next.f5579a, false);
            }
        }
    }

    public void f(PlaybackSessionManager.Listener listener) {
        this.f5575e = listener;
    }

    public synchronized void g(AnalyticsListener.EventTime eventTime, int i2) {
        boolean z2;
        boolean z3;
        Assertions.f(this.f5575e);
        if (i2 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator<SessionDescriptor> it2 = this.f5573c.values().iterator();
        while (it2.hasNext()) {
            SessionDescriptor next = it2.next();
            if (next.j(eventTime)) {
                it2.remove();
                if (next.f5583e) {
                    boolean equals = next.f5579a.equals(this.f5577g);
                    if (!z2 || !equals || !next.f5584f) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (equals) {
                        l(next);
                    }
                    this.f5575e.g0(eventTime, next.f5579a, z3);
                }
            }
        }
        p(eventTime);
    }

    public DefaultPlaybackSessionManager(Supplier<String> supplier) {
        this.f5574d = supplier;
        this.f5571a = new Timeline.Window();
        this.f5572b = new Timeline.Period();
        this.f5573c = new HashMap<>();
        this.f5576f = Timeline.f4346a;
        this.f5578h = -1;
    }
}
