package androidx.media3.exoplayer.analytics;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.drm.j;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import f.a0;
import f.a1;
import f.b;
import f.b0;
import f.b1;
import f.c;
import f.c0;
import f.c1;
import f.d;
import f.d0;
import f.d1;
import f.e;
import f.e0;
import f.e1;
import f.f;
import f.f0;
import f.f1;
import f.g;
import f.g0;
import f.g1;
import f.h;
import f.h0;
import f.h1;
import f.i;
import f.i0;
import f.i1;
import f.j0;
import f.j1;
import f.k;
import f.k0;
import f.k1;
import f.l;
import f.l0;
import f.l1;
import f.m;
import f.m0;
import f.m1;
import f.n;
import f.n0;
import f.o;
import f.o0;
import f.p;
import f.p0;
import f.q;
import f.q0;
import f.r;
import f.r0;
import f.s;
import f.s0;
import f.t;
import f.t0;
import f.u;
import f.u0;
import f.v;
import f.v0;
import f.w;
import f.w0;
import f.x;
import f.x0;
import f.y;
import f.y0;
import f.z;
import f.z0;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class DefaultAnalyticsCollector implements AnalyticsCollector {

    /* renamed from: b  reason: collision with root package name */
    private final Clock f5554b;

    /* renamed from: c  reason: collision with root package name */
    private final Timeline.Period f5555c;

    /* renamed from: d  reason: collision with root package name */
    private final Timeline.Window f5556d = new Timeline.Window();

    /* renamed from: e  reason: collision with root package name */
    private final MediaPeriodQueueTracker f5557e;

    /* renamed from: f  reason: collision with root package name */
    private final SparseArray<AnalyticsListener.EventTime> f5558f;

    /* renamed from: g  reason: collision with root package name */
    private ListenerSet<AnalyticsListener> f5559g;

    /* renamed from: h  reason: collision with root package name */
    private Player f5560h;

    /* renamed from: i  reason: collision with root package name */
    private HandlerWrapper f5561i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5562j;

    private static final class MediaPeriodQueueTracker {

        /* renamed from: a  reason: collision with root package name */
        private final Timeline.Period f5563a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public ImmutableList<MediaSource.MediaPeriodId> f5564b = ImmutableList.r();

        /* renamed from: c  reason: collision with root package name */
        private ImmutableMap<MediaSource.MediaPeriodId, Timeline> f5565c = ImmutableMap.k();

        /* renamed from: d  reason: collision with root package name */
        private MediaSource.MediaPeriodId f5566d;

        /* renamed from: e  reason: collision with root package name */
        private MediaSource.MediaPeriodId f5567e;

        /* renamed from: f  reason: collision with root package name */
        private MediaSource.MediaPeriodId f5568f;

        public MediaPeriodQueueTracker(Timeline.Period period) {
            this.f5563a = period;
        }

        private void b(ImmutableMap.Builder<MediaSource.MediaPeriodId, Timeline> builder, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            if (mediaPeriodId != null) {
                if (timeline.b(mediaPeriodId.f6971a) != -1) {
                    builder.f(mediaPeriodId, timeline);
                    return;
                }
                Timeline timeline2 = this.f5565c.get(mediaPeriodId);
                if (timeline2 != null) {
                    builder.f(mediaPeriodId, timeline2);
                }
            }
        }

        private static MediaSource.MediaPeriodId c(Player player, ImmutableList<MediaSource.MediaPeriodId> immutableList, MediaSource.MediaPeriodId mediaPeriodId, Timeline.Period period) {
            Object obj;
            int i2;
            Timeline t2 = player.t();
            int E = player.E();
            if (t2.q()) {
                obj = null;
            } else {
                obj = t2.m(E);
            }
            if (player.f() || t2.q()) {
                i2 = -1;
            } else {
                i2 = t2.f(E, period).d(Util.P0(player.getCurrentPosition()) - period.n());
            }
            for (int i3 = 0; i3 < immutableList.size(); i3++) {
                MediaSource.MediaPeriodId mediaPeriodId2 = immutableList.get(i3);
                if (i(mediaPeriodId2, obj, player.f(), player.p(), player.I(), i2)) {
                    return mediaPeriodId2;
                }
            }
            if (immutableList.isEmpty() && mediaPeriodId != null) {
                if (i(mediaPeriodId, obj, player.f(), player.p(), player.I(), i2)) {
                    return mediaPeriodId;
                }
            }
            return null;
        }

        private static boolean i(MediaSource.MediaPeriodId mediaPeriodId, Object obj, boolean z2, int i2, int i3, int i4) {
            if (!mediaPeriodId.f6971a.equals(obj)) {
                return false;
            }
            if ((z2 && mediaPeriodId.f6972b == i2 && mediaPeriodId.f6973c == i3) || (!z2 && mediaPeriodId.f6972b == -1 && mediaPeriodId.f6975e == i4)) {
                return true;
            }
            return false;
        }

        private void m(Timeline timeline) {
            ImmutableMap.Builder a2 = ImmutableMap.a();
            if (this.f5564b.isEmpty()) {
                b(a2, this.f5567e, timeline);
                if (!Objects.a(this.f5568f, this.f5567e)) {
                    b(a2, this.f5568f, timeline);
                }
                if (!Objects.a(this.f5566d, this.f5567e) && !Objects.a(this.f5566d, this.f5568f)) {
                    b(a2, this.f5566d, timeline);
                }
            } else {
                for (int i2 = 0; i2 < this.f5564b.size(); i2++) {
                    b(a2, this.f5564b.get(i2), timeline);
                }
                if (!this.f5564b.contains(this.f5566d)) {
                    b(a2, this.f5566d, timeline);
                }
            }
            this.f5565c = a2.c();
        }

        public MediaSource.MediaPeriodId d() {
            return this.f5566d;
        }

        public MediaSource.MediaPeriodId e() {
            if (this.f5564b.isEmpty()) {
                return null;
            }
            return (MediaSource.MediaPeriodId) Iterables.d(this.f5564b);
        }

        public Timeline f(MediaSource.MediaPeriodId mediaPeriodId) {
            return this.f5565c.get(mediaPeriodId);
        }

        public MediaSource.MediaPeriodId g() {
            return this.f5567e;
        }

        public MediaSource.MediaPeriodId h() {
            return this.f5568f;
        }

        public void j(Player player) {
            this.f5566d = c(player, this.f5564b, this.f5567e, this.f5563a);
        }

        public void k(List<MediaSource.MediaPeriodId> list, MediaSource.MediaPeriodId mediaPeriodId, Player player) {
            this.f5564b = ImmutableList.n(list);
            if (!list.isEmpty()) {
                this.f5567e = list.get(0);
                this.f5568f = (MediaSource.MediaPeriodId) Assertions.f(mediaPeriodId);
            }
            if (this.f5566d == null) {
                this.f5566d = c(player, this.f5564b, this.f5567e, this.f5563a);
            }
            m(player.t());
        }

        public void l(Player player) {
            this.f5566d = c(player, this.f5564b, this.f5567e, this.f5563a);
            m(player.t());
        }
    }

    public DefaultAnalyticsCollector(Clock clock) {
        this.f5554b = (Clock) Assertions.f(clock);
        this.f5559g = new ListenerSet<>(Util.U(), clock, new m1());
        Timeline.Period period = new Timeline.Period();
        this.f5555c = period;
        this.f5557e = new MediaPeriodQueueTracker(period);
        this.f5558f = new SparseArray<>();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void D2(AnalyticsListener.EventTime eventTime, VideoSize videoSize, AnalyticsListener analyticsListener) {
        analyticsListener.k0(eventTime, videoSize);
        analyticsListener.V(eventTime, videoSize.f4488a, videoSize.f4489b, videoSize.f4490c, videoSize.f4491d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F2(Player player, AnalyticsListener analyticsListener, FlagSet flagSet) {
        analyticsListener.n0(player, new AnalyticsListener.Events(flagSet, this.f5558f));
    }

    /* access modifiers changed from: private */
    public void G2() {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 1028, new x0(n12));
        this.f5559g.j();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void S1(AnalyticsListener.EventTime eventTime, int i2, AnalyticsListener analyticsListener) {
        analyticsListener.Y(eventTime);
        analyticsListener.B(eventTime, i2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void W1(AnalyticsListener.EventTime eventTime, boolean z2, AnalyticsListener analyticsListener) {
        analyticsListener.W(eventTime, z2);
        analyticsListener.b(eventTime, z2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void m2(AnalyticsListener.EventTime eventTime, int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, AnalyticsListener analyticsListener) {
        analyticsListener.j(eventTime, i2);
        analyticsListener.A(eventTime, positionInfo, positionInfo2, i2);
    }

    private AnalyticsListener.EventTime p1(MediaSource.MediaPeriodId mediaPeriodId) {
        Timeline timeline;
        boolean z2;
        Assertions.f(this.f5560h);
        if (mediaPeriodId == null) {
            timeline = null;
        } else {
            timeline = this.f5557e.f(mediaPeriodId);
        }
        if (mediaPeriodId != null && timeline != null) {
            return o1(timeline, timeline.h(mediaPeriodId.f6971a, this.f5555c).f4357c, mediaPeriodId);
        }
        int M = this.f5560h.M();
        Timeline t2 = this.f5560h.t();
        if (M < t2.p()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            t2 = Timeline.f4346a;
        }
        return o1(t2, M, (MediaSource.MediaPeriodId) null);
    }

    private AnalyticsListener.EventTime q1() {
        return p1(this.f5557e.e());
    }

    private AnalyticsListener.EventTime r1(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.f(this.f5560h);
        boolean z2 = true;
        if (mediaPeriodId != null) {
            if (this.f5557e.f(mediaPeriodId) == null) {
                z2 = false;
            }
            if (z2) {
                return p1(mediaPeriodId);
            }
            return o1(Timeline.f4346a, i2, mediaPeriodId);
        }
        Timeline t2 = this.f5560h.t();
        if (i2 >= t2.p()) {
            z2 = false;
        }
        if (!z2) {
            t2 = Timeline.f4346a;
        }
        return o1(t2, i2, (MediaSource.MediaPeriodId) null);
    }

    private AnalyticsListener.EventTime s1() {
        return p1(this.f5557e.g());
    }

    private AnalyticsListener.EventTime t1() {
        return p1(this.f5557e.h());
    }

    private AnalyticsListener.EventTime u1(PlaybackException playbackException) {
        MediaSource.MediaPeriodId mediaPeriodId;
        if (!(playbackException instanceof ExoPlaybackException) || (mediaPeriodId = ((ExoPlaybackException) playbackException).f5241p) == null) {
            return n1();
        }
        return p1(mediaPeriodId);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void v1(AnalyticsListener analyticsListener, FlagSet flagSet) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void x2(AnalyticsListener.EventTime eventTime, String str, long j2, long j3, AnalyticsListener analyticsListener) {
        analyticsListener.c0(eventTime, str, j2);
        analyticsListener.j0(eventTime, str, j3, j2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void y1(AnalyticsListener.EventTime eventTime, String str, long j2, long j3, AnalyticsListener analyticsListener) {
        analyticsListener.M(eventTime, str, j2);
        analyticsListener.q(eventTime, str, j3, j2);
    }

    public void A(CueGroup cueGroup) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 27, new y(n12, cueGroup));
    }

    public final void B(Metadata metadata) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 28, new u(n12, metadata));
    }

    public final void C(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 1017, new j1(t1, format, decoderReuseEvaluation));
    }

    public final void D(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime s12 = s1();
        H2(s12, 1020, new m0(s12, decoderCounters));
    }

    public final void E(List<MediaSource.MediaPeriodId> list, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f5557e.k(list, mediaPeriodId, (Player) Assertions.f(this.f5560h));
    }

    public void F(MediaMetadata mediaMetadata) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 14, new f0(n12, mediaMetadata));
    }

    public void G(TrackSelectionParameters trackSelectionParameters) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 19, new c(n12, trackSelectionParameters));
    }

    public final void H(MediaItem mediaItem, int i2) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 1, new d0(n12, mediaItem, i2));
    }

    /* access modifiers changed from: protected */
    public final void H2(AnalyticsListener.EventTime eventTime, int i2, ListenerSet.Event<AnalyticsListener> event) {
        this.f5558f.put(i2, eventTime);
        this.f5559g.l(i2, event);
    }

    public final void I(PlaybackException playbackException) {
        AnalyticsListener.EventTime u1 = u1(playbackException);
        H2(u1, 10, new t(u1, playbackException));
    }

    public final void J(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        AnalyticsListener.EventTime r12 = r1(i2, mediaPeriodId);
        H2(r12, 1003, new o0(r12, loadEventInfo, mediaLoadData, iOException, z2));
    }

    public /* synthetic */ void K(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        j.a(this, i2, mediaPeriodId);
    }

    public void L(Player.Commands commands) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 13, new h(n12, commands));
    }

    public final void M(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime r12 = r1(i2, mediaPeriodId);
        H2(r12, 1026, new i1(r12));
    }

    public final void N(int i2, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        AnalyticsListener.EventTime r12 = r1(i2, mediaPeriodId);
        H2(r12, 1024, new p0(r12, exc));
    }

    public final void O(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime r12 = r1(i2, mediaPeriodId);
        H2(r12, 1002, new y0(r12, loadEventInfo, mediaLoadData));
    }

    public void P(Player player, Player.Events events) {
    }

    public void Q(AnalyticsListener analyticsListener) {
        Assertions.f(analyticsListener);
        this.f5559g.c(analyticsListener);
    }

    public final void R(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime r12 = r1(i2, mediaPeriodId);
        H2(r12, 1001, new z0(r12, loadEventInfo, mediaLoadData));
    }

    public final void S(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime r12 = r1(i2, mediaPeriodId);
        H2(r12, GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION, new v0(r12, mediaLoadData));
    }

    public final void T(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime r12 = r1(i2, mediaPeriodId);
        H2(r12, 1025, new c1(r12));
    }

    public final void U(Timeline timeline, int i2) {
        this.f5557e.l((Player) Assertions.f(this.f5560h));
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 0, new q(n12, i2));
    }

    public void V(Tracks tracks) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 2, new f.j(n12, tracks));
    }

    public void W(DeviceInfo deviceInfo) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 29, new i(n12, deviceInfo));
    }

    public void X(PlaybackException playbackException) {
        AnalyticsListener.EventTime u1 = u1(playbackException);
        H2(u1, 10, new e0(u1, playbackException));
    }

    public final void Y(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime r12 = r1(i2, mediaPeriodId);
        H2(r12, 1027, new s0(r12));
    }

    public void Z(Player player, Looper looper) {
        boolean z2;
        if (this.f5560h == null || this.f5557e.f5564b.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        this.f5560h = (Player) Assertions.f(player);
        this.f5561i = this.f5554b.b(looper, (Handler.Callback) null);
        this.f5559g = this.f5559g.e(looper, new n(this, player));
    }

    public final void a(Exception exc) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 1014, new f(t1, exc));
    }

    public final void a0(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
        if (i2 == 1) {
            this.f5562j = false;
        }
        this.f5557e.j((Player) Assertions.f(this.f5560h));
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 11, new g(n12, i2, positionInfo, positionInfo2));
    }

    public final void b(String str) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 1019, new k1(t1, str));
    }

    public final void c(String str, long j2, long j3) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 1016, new p(t1, str, j3, j2));
    }

    public final void d(String str) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 1012, new t0(t1, str));
    }

    public final void e(String str, long j2, long j3) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 1008, new v(t1, str, j3, j2));
    }

    public final void f(long j2) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 1010, new k0(t1, j2));
    }

    public final void g(Exception exc) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 1030, new e(t1, exc));
    }

    public final void h(int i2, long j2) {
        AnalyticsListener.EventTime s12 = s1();
        H2(s12, 1018, new r(s12, i2, j2));
    }

    public final void i(Object obj, long j2) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 26, new b1(t1, obj, j2));
    }

    public final void j(Exception exc) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 1029, new k(t1, exc));
    }

    public final void k(int i2, long j2, long j3) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 1011, new r0(t1, i2, j2, j3));
    }

    public final void l(long j2, int i2) {
        AnalyticsListener.EventTime s12 = s1();
        H2(s12, 1021, new b(s12, j2, i2));
    }

    public void m(AudioSink.AudioTrackConfig audioTrackConfig) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 1031, new d1(t1, audioTrackConfig));
    }

    public final void n(VideoSize videoSize) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 25, new a1(t1, videoSize));
    }

    /* access modifiers changed from: protected */
    public final AnalyticsListener.EventTime n1() {
        return p1(this.f5557e.d());
    }

    public void o(AudioSink.AudioTrackConfig audioTrackConfig) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 1032, new g1(t1, audioTrackConfig));
    }

    /* access modifiers changed from: protected */
    @RequiresNonNull({"player"})
    public final AnalyticsListener.EventTime o1(Timeline timeline, int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaSource.MediaPeriodId mediaPeriodId2;
        boolean z2;
        long j2;
        Timeline timeline2 = timeline;
        int i3 = i2;
        if (timeline.q()) {
            mediaPeriodId2 = null;
        } else {
            mediaPeriodId2 = mediaPeriodId;
        }
        long elapsedRealtime = this.f5554b.elapsedRealtime();
        boolean z3 = true;
        if (!timeline2.equals(this.f5560h.t()) || i3 != this.f5560h.M()) {
            z2 = false;
        } else {
            z2 = true;
        }
        long j3 = 0;
        if (mediaPeriodId2 != null && mediaPeriodId2.b()) {
            if (!(z2 && this.f5560h.p() == mediaPeriodId2.f6972b && this.f5560h.I() == mediaPeriodId2.f6973c)) {
                z3 = false;
            }
            if (z3) {
                j3 = this.f5560h.getCurrentPosition();
            }
        } else if (z2) {
            j2 = this.f5560h.K();
            return new AnalyticsListener.EventTime(elapsedRealtime, timeline, i2, mediaPeriodId2, j2, this.f5560h.t(), this.f5560h.M(), this.f5557e.d(), this.f5560h.getCurrentPosition(), this.f5560h.g());
        } else if (!timeline.q()) {
            j3 = timeline2.n(i3, this.f5556d).b();
        }
        j2 = j3;
        return new AnalyticsListener.EventTime(elapsedRealtime, timeline, i2, mediaPeriodId2, j2, this.f5560h.t(), this.f5560h.M(), this.f5557e.d(), this.f5560h.getCurrentPosition(), this.f5560h.g());
    }

    public void onCues(List<Cue> list) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 27, new o(n12, list));
    }

    public void onDeviceVolumeChanged(int i2, boolean z2) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 30, new l(n12, i2, z2));
    }

    public final void onIsLoadingChanged(boolean z2) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 3, new i0(n12, z2));
    }

    public void onIsPlayingChanged(boolean z2) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 7, new a0(n12, z2));
    }

    public void onLoadingChanged(boolean z2) {
    }

    public final void onPlayWhenReadyChanged(boolean z2, int i2) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 5, new z(n12, z2, i2));
    }

    public final void onPlaybackStateChanged(int i2) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 4, new c0(n12, i2));
    }

    public final void onPlaybackSuppressionReasonChanged(int i2) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 6, new x(n12, i2));
    }

    public final void onPlayerStateChanged(boolean z2, int i2) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, -1, new e1(n12, z2, i2));
    }

    public void onPositionDiscontinuity(int i2) {
    }

    public void onRenderedFirstFrame() {
    }

    public final void onRepeatModeChanged(int i2) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 8, new d(n12, i2));
    }

    public final void onShuffleModeEnabledChanged(boolean z2) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 9, new b0(n12, z2));
    }

    public final void onSkipSilenceEnabledChanged(boolean z2) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 23, new h1(t1, z2));
    }

    public final void onSurfaceSizeChanged(int i2, int i3) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 24, new n0(t1, i2, i3));
    }

    public final void p(int i2, long j2, long j3) {
        AnalyticsListener.EventTime q12 = q1();
        H2(q12, 1006, new w0(q12, i2, j2, j3));
    }

    public final void q() {
        if (!this.f5562j) {
            AnalyticsListener.EventTime n12 = n1();
            this.f5562j = true;
            H2(n12, -1, new l0(n12));
        }
    }

    public final void r(PlaybackParameters playbackParameters) {
        AnalyticsListener.EventTime n12 = n1();
        H2(n12, 12, new l1(n12, playbackParameters));
    }

    public void release() {
        ((HandlerWrapper) Assertions.j(this.f5561i)).g(new j0(this));
    }

    public final void s(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 1007, new w(t1, decoderCounters));
    }

    public final void t(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 1015, new s(t1, decoderCounters));
    }

    public final void u(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime r12 = r1(i2, mediaPeriodId);
        H2(r12, 1005, new q0(r12, mediaLoadData));
    }

    public final void v(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime r12 = r1(i2, mediaPeriodId);
        H2(r12, 1000, new m(r12, loadEventInfo, mediaLoadData));
    }

    public final void w(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime t1 = t1();
        H2(t1, 1009, new g0(t1, format, decoderReuseEvaluation));
    }

    public final void x(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime s12 = s1();
        H2(s12, 1013, new h0(s12, decoderCounters));
    }

    public final void y(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime r12 = r1(i2, mediaPeriodId);
        H2(r12, 1023, new f1(r12));
    }

    public final void z(int i2, MediaSource.MediaPeriodId mediaPeriodId, int i3) {
        AnalyticsListener.EventTime r12 = r1(i2, mediaPeriodId);
        H2(r12, 1022, new u0(r12, i3));
    }
}
