package com.google.android.exoplayer2.analytics;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import h0.a0;
import h0.a1;
import h0.b;
import h0.b0;
import h0.b1;
import h0.c;
import h0.c0;
import h0.c1;
import h0.d;
import h0.d0;
import h0.d1;
import h0.e;
import h0.e0;
import h0.e1;
import h0.f;
import h0.f0;
import h0.f1;
import h0.g;
import h0.g0;
import h0.g1;
import h0.h;
import h0.h0;
import h0.h1;
import h0.i;
import h0.i0;
import h0.i1;
import h0.j;
import h0.j0;
import h0.j1;
import h0.k;
import h0.k0;
import h0.k1;
import h0.l;
import h0.l0;
import h0.l1;
import h0.m;
import h0.m0;
import h0.m1;
import h0.n;
import h0.n0;
import h0.o;
import h0.o0;
import h0.p;
import h0.p0;
import h0.q;
import h0.q0;
import h0.r;
import h0.r0;
import h0.s;
import h0.s0;
import h0.t;
import h0.t0;
import h0.u;
import h0.u0;
import h0.v;
import h0.v0;
import h0.w;
import h0.w0;
import h0.x;
import h0.x0;
import h0.y;
import h0.y0;
import h0.z;
import h0.z0;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class DefaultAnalyticsCollector implements AnalyticsCollector {

    /* renamed from: b  reason: collision with root package name */
    private final Clock f23565b;

    /* renamed from: c  reason: collision with root package name */
    private final Timeline.Period f23566c;

    /* renamed from: d  reason: collision with root package name */
    private final Timeline.Window f23567d = new Timeline.Window();

    /* renamed from: e  reason: collision with root package name */
    private final MediaPeriodQueueTracker f23568e;

    /* renamed from: f  reason: collision with root package name */
    private final SparseArray<AnalyticsListener.EventTime> f23569f;

    /* renamed from: g  reason: collision with root package name */
    private ListenerSet<AnalyticsListener> f23570g;

    /* renamed from: h  reason: collision with root package name */
    private Player f23571h;

    /* renamed from: i  reason: collision with root package name */
    private HandlerWrapper f23572i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f23573j;

    private static final class MediaPeriodQueueTracker {

        /* renamed from: a  reason: collision with root package name */
        private final Timeline.Period f23574a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public ImmutableList<MediaSource.MediaPeriodId> f23575b = ImmutableList.r();

        /* renamed from: c  reason: collision with root package name */
        private ImmutableMap<MediaSource.MediaPeriodId, Timeline> f23576c = ImmutableMap.k();

        /* renamed from: d  reason: collision with root package name */
        private MediaSource.MediaPeriodId f23577d;

        /* renamed from: e  reason: collision with root package name */
        private MediaSource.MediaPeriodId f23578e;

        /* renamed from: f  reason: collision with root package name */
        private MediaSource.MediaPeriodId f23579f;

        public MediaPeriodQueueTracker(Timeline.Period period) {
            this.f23574a = period;
        }

        private void b(ImmutableMap.Builder<MediaSource.MediaPeriodId, Timeline> builder, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            if (mediaPeriodId != null) {
                if (timeline.f(mediaPeriodId.f25793a) != -1) {
                    builder.f(mediaPeriodId, timeline);
                    return;
                }
                Timeline timeline2 = this.f23576c.get(mediaPeriodId);
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
            if (t2.u()) {
                obj = null;
            } else {
                obj = t2.q(E);
            }
            if (player.f() || t2.u()) {
                i2 = -1;
            } else {
                i2 = t2.j(E, period).g(Util.F0(player.getCurrentPosition()) - period.q());
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
            if (!mediaPeriodId.f25793a.equals(obj)) {
                return false;
            }
            if ((z2 && mediaPeriodId.f25794b == i2 && mediaPeriodId.f25795c == i3) || (!z2 && mediaPeriodId.f25794b == -1 && mediaPeriodId.f25797e == i4)) {
                return true;
            }
            return false;
        }

        private void m(Timeline timeline) {
            ImmutableMap.Builder a2 = ImmutableMap.a();
            if (this.f23575b.isEmpty()) {
                b(a2, this.f23578e, timeline);
                if (!Objects.a(this.f23579f, this.f23578e)) {
                    b(a2, this.f23579f, timeline);
                }
                if (!Objects.a(this.f23577d, this.f23578e) && !Objects.a(this.f23577d, this.f23579f)) {
                    b(a2, this.f23577d, timeline);
                }
            } else {
                for (int i2 = 0; i2 < this.f23575b.size(); i2++) {
                    b(a2, this.f23575b.get(i2), timeline);
                }
                if (!this.f23575b.contains(this.f23577d)) {
                    b(a2, this.f23577d, timeline);
                }
            }
            this.f23576c = a2.c();
        }

        public MediaSource.MediaPeriodId d() {
            return this.f23577d;
        }

        public MediaSource.MediaPeriodId e() {
            if (this.f23575b.isEmpty()) {
                return null;
            }
            return (MediaSource.MediaPeriodId) Iterables.d(this.f23575b);
        }

        public Timeline f(MediaSource.MediaPeriodId mediaPeriodId) {
            return this.f23576c.get(mediaPeriodId);
        }

        public MediaSource.MediaPeriodId g() {
            return this.f23578e;
        }

        public MediaSource.MediaPeriodId h() {
            return this.f23579f;
        }

        public void j(Player player) {
            this.f23577d = c(player, this.f23575b, this.f23578e, this.f23574a);
        }

        public void k(List<MediaSource.MediaPeriodId> list, MediaSource.MediaPeriodId mediaPeriodId, Player player) {
            this.f23575b = ImmutableList.n(list);
            if (!list.isEmpty()) {
                this.f23578e = list.get(0);
                this.f23579f = (MediaSource.MediaPeriodId) Assertions.e(mediaPeriodId);
            }
            if (this.f23577d == null) {
                this.f23577d = c(player, this.f23575b, this.f23578e, this.f23574a);
            }
            m(player.t());
        }

        public void l(Player player) {
            this.f23577d = c(player, this.f23575b, this.f23578e, this.f23574a);
            m(player.t());
        }
    }

    public DefaultAnalyticsCollector(Clock clock) {
        this.f23565b = (Clock) Assertions.e(clock);
        this.f23570g = new ListenerSet<>(Util.Q(), clock, new k0());
        Timeline.Period period = new Timeline.Period();
        this.f23566c = period;
        this.f23568e = new MediaPeriodQueueTracker(period);
        this.f23569f = new SparseArray<>();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void D1(AnalyticsListener.EventTime eventTime, boolean z2, AnalyticsListener analyticsListener) {
        analyticsListener.g(eventTime, z2);
        analyticsListener.y0(eventTime, z2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void T1(AnalyticsListener.EventTime eventTime, int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, AnalyticsListener analyticsListener) {
        analyticsListener.T(eventTime, i2);
        analyticsListener.p0(eventTime, positionInfo, positionInfo2, i2);
    }

    private AnalyticsListener.EventTime Y0(MediaSource.MediaPeriodId mediaPeriodId) {
        Timeline timeline;
        boolean z2;
        Assertions.e(this.f23571h);
        if (mediaPeriodId == null) {
            timeline = null;
        } else {
            timeline = this.f23568e.f(mediaPeriodId);
        }
        if (mediaPeriodId != null && timeline != null) {
            return X0(timeline, timeline.l(mediaPeriodId.f25793a, this.f23566c).f23494d, mediaPeriodId);
        }
        int M = this.f23571h.M();
        Timeline t2 = this.f23571h.t();
        if (M < t2.t()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            t2 = Timeline.f23481b;
        }
        return X0(t2, M, (MediaSource.MediaPeriodId) null);
    }

    private AnalyticsListener.EventTime Z0() {
        return Y0(this.f23568e.e());
    }

    private AnalyticsListener.EventTime a1(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.e(this.f23571h);
        boolean z2 = true;
        if (mediaPeriodId != null) {
            if (this.f23568e.f(mediaPeriodId) == null) {
                z2 = false;
            }
            if (z2) {
                return Y0(mediaPeriodId);
            }
            return X0(Timeline.f23481b, i2, mediaPeriodId);
        }
        Timeline t2 = this.f23571h.t();
        if (i2 >= t2.t()) {
            z2 = false;
        }
        if (!z2) {
            t2 = Timeline.f23481b;
        }
        return X0(t2, i2, (MediaSource.MediaPeriodId) null);
    }

    private AnalyticsListener.EventTime b1() {
        return Y0(this.f23568e.g());
    }

    private AnalyticsListener.EventTime c1() {
        return Y0(this.f23568e.h());
    }

    private AnalyticsListener.EventTime d1(PlaybackException playbackException) {
        MediaPeriodId mediaPeriodId;
        if (!(playbackException instanceof ExoPlaybackException) || (mediaPeriodId = ((ExoPlaybackException) playbackException).f22903o) == null) {
            return W0();
        }
        return Y0(new MediaSource.MediaPeriodId(mediaPeriodId));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void e1(AnalyticsListener analyticsListener, FlagSet flagSet) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void f2(AnalyticsListener.EventTime eventTime, String str, long j2, long j3, AnalyticsListener analyticsListener) {
        analyticsListener.s0(eventTime, str, j2);
        long j4 = j2;
        analyticsListener.A(eventTime, str, j3, j4);
        analyticsListener.R(eventTime, 2, str, j4);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void h1(AnalyticsListener.EventTime eventTime, String str, long j2, long j3, AnalyticsListener analyticsListener) {
        analyticsListener.m(eventTime, str, j2);
        long j4 = j2;
        analyticsListener.a0(eventTime, str, j3, j4);
        analyticsListener.R(eventTime, 1, str, j4);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void h2(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.J(eventTime, decoderCounters);
        analyticsListener.w0(eventTime, 2, decoderCounters);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void i2(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.Z(eventTime, decoderCounters);
        analyticsListener.l(eventTime, 2, decoderCounters);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void j1(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.Y(eventTime, decoderCounters);
        analyticsListener.w0(eventTime, 1, decoderCounters);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void k1(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.j(eventTime, decoderCounters);
        analyticsListener.l(eventTime, 1, decoderCounters);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void k2(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, AnalyticsListener analyticsListener) {
        analyticsListener.r(eventTime, format);
        analyticsListener.B(eventTime, format, decoderReuseEvaluation);
        analyticsListener.O(eventTime, 2, format);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void l1(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, AnalyticsListener analyticsListener) {
        analyticsListener.g0(eventTime, format);
        analyticsListener.t0(eventTime, format, decoderReuseEvaluation);
        analyticsListener.O(eventTime, 1, format);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void l2(AnalyticsListener.EventTime eventTime, VideoSize videoSize, AnalyticsListener analyticsListener) {
        analyticsListener.d0(eventTime, videoSize);
        analyticsListener.N(eventTime, videoSize.f28962b, videoSize.f28963c, videoSize.f28964d, videoSize.f28965e);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o2(Player player, AnalyticsListener analyticsListener, FlagSet flagSet) {
        analyticsListener.o(player, new AnalyticsListener.Events(flagSet, this.f23569f));
    }

    /* access modifiers changed from: private */
    public void p2() {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 1028, new f1(W0));
        this.f23570g.j();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void z1(AnalyticsListener.EventTime eventTime, int i2, AnalyticsListener analyticsListener) {
        analyticsListener.I(eventTime);
        analyticsListener.c(eventTime, i2);
    }

    public void A(AnalyticsListener analyticsListener) {
        Assertions.e(analyticsListener);
        this.f23570g.c(analyticsListener);
    }

    public final void B(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime a12 = a1(i2, mediaPeriodId);
        q2(a12, 1005, new b0(a12, mediaLoadData));
    }

    public final void C(int i2, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        AnalyticsListener.EventTime a12 = a1(i2, mediaPeriodId);
        q2(a12, 1024, new u0(a12, exc));
    }

    public final void D(List<MediaSource.MediaPeriodId> list, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f23568e.k(list, mediaPeriodId, (Player) Assertions.e(this.f23571h));
    }

    public final void E(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime a12 = a1(i2, mediaPeriodId);
        q2(a12, 1023, new c1(a12));
    }

    public final void F(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime a12 = a1(i2, mediaPeriodId);
        q2(a12, 1001, new z0(a12, loadEventInfo, mediaLoadData));
    }

    public final void G(int i2, MediaSource.MediaPeriodId mediaPeriodId, int i3) {
        AnalyticsListener.EventTime a12 = a1(i2, mediaPeriodId);
        q2(a12, 1022, new p0(a12, i3));
    }

    public final void H(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime a12 = a1(i2, mediaPeriodId);
        q2(a12, 1027, new q(a12));
    }

    public final void I(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        AnalyticsListener.EventTime a12 = a1(i2, mediaPeriodId);
        q2(a12, 1003, new j0(a12, loadEventInfo, mediaLoadData, iOException, z2));
    }

    public final void J(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime a12 = a1(i2, mediaPeriodId);
        q2(a12, 1025, new h1(a12));
    }

    /* access modifiers changed from: protected */
    public final AnalyticsListener.EventTime W0() {
        return Y0(this.f23568e.d());
    }

    /* access modifiers changed from: protected */
    @RequiresNonNull({"player"})
    public final AnalyticsListener.EventTime X0(Timeline timeline, int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaSource.MediaPeriodId mediaPeriodId2;
        boolean z2;
        long j2;
        Timeline timeline2 = timeline;
        int i3 = i2;
        if (timeline.u()) {
            mediaPeriodId2 = null;
        } else {
            mediaPeriodId2 = mediaPeriodId;
        }
        long elapsedRealtime = this.f23565b.elapsedRealtime();
        boolean z3 = true;
        if (!timeline2.equals(this.f23571h.t()) || i3 != this.f23571h.M()) {
            z2 = false;
        } else {
            z2 = true;
        }
        long j3 = 0;
        if (mediaPeriodId2 != null && mediaPeriodId2.b()) {
            if (!(z2 && this.f23571h.p() == mediaPeriodId2.f25794b && this.f23571h.I() == mediaPeriodId2.f25795c)) {
                z3 = false;
            }
            if (z3) {
                j3 = this.f23571h.getCurrentPosition();
            }
        } else if (z2) {
            j2 = this.f23571h.K();
            return new AnalyticsListener.EventTime(elapsedRealtime, timeline, i2, mediaPeriodId2, j2, this.f23571h.t(), this.f23571h.M(), this.f23568e.d(), this.f23571h.getCurrentPosition(), this.f23571h.g());
        } else if (!timeline.u()) {
            j3 = timeline2.r(i3, this.f23567d).d();
        }
        j2 = j3;
        return new AnalyticsListener.EventTime(elapsedRealtime, timeline, i2, mediaPeriodId2, j2, this.f23571h.t(), this.f23571h.M(), this.f23568e.d(), this.f23571h.getCurrentPosition(), this.f23571h.g());
    }

    public final void a(Exception exc) {
        AnalyticsListener.EventTime c12 = c1();
        q2(c12, 1014, new t(c12, exc));
    }

    public final void b(String str) {
        AnalyticsListener.EventTime c12 = c1();
        q2(c12, 1019, new e(c12, str));
    }

    public final void c(String str, long j2, long j3) {
        AnalyticsListener.EventTime c12 = c1();
        q2(c12, 1016, new c(c12, str, j3, j2));
    }

    public final void d(String str) {
        AnalyticsListener.EventTime c12 = c1();
        q2(c12, 1012, new o(c12, str));
    }

    public final void e(String str, long j2, long j3) {
        AnalyticsListener.EventTime c12 = c1();
        q2(c12, 1008, new k(c12, str, j3, j2));
    }

    public final void f(long j2) {
        AnalyticsListener.EventTime c12 = c1();
        q2(c12, 1010, new p(c12, j2));
    }

    public final void g(Exception exc) {
        AnalyticsListener.EventTime c12 = c1();
        q2(c12, 1030, new j1(c12, exc));
    }

    public final void h(int i2, long j2) {
        AnalyticsListener.EventTime b12 = b1();
        q2(b12, 1018, new y(b12, i2, j2));
    }

    public final void i(Object obj, long j2) {
        AnalyticsListener.EventTime c12 = c1();
        q2(c12, 26, new b1(c12, obj, j2));
    }

    public final void j(Exception exc) {
        AnalyticsListener.EventTime c12 = c1();
        q2(c12, 1029, new l0(c12, exc));
    }

    public final void k(int i2, long j2, long j3) {
        AnalyticsListener.EventTime c12 = c1();
        q2(c12, 1011, new a1(c12, i2, j2, j3));
    }

    public final void l(long j2, int i2) {
        AnalyticsListener.EventTime b12 = b1();
        q2(b12, 1021, new k1(b12, j2, i2));
    }

    public final void m(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime c12 = c1();
        q2(c12, 1007, new c0(c12, decoderCounters));
    }

    public final void n(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime c12 = c1();
        q2(c12, 1017, new o0(c12, format, decoderReuseEvaluation));
    }

    public final void o(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime b12 = b1();
        q2(b12, 1020, new z(b12, decoderCounters));
    }

    public void onAvailableCommandsChanged(Player.Commands commands) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 13, new e0(W0, commands));
    }

    public void onCues(List<Cue> list) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 27, new x0(W0, list));
    }

    public void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 29, new m(W0, deviceInfo));
    }

    public void onDeviceVolumeChanged(int i2, boolean z2) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 30, new g(W0, i2, z2));
    }

    public void onEvents(Player player, Player.Events events) {
    }

    public final void onIsLoadingChanged(boolean z2) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 3, new q0(W0, z2));
    }

    public void onIsPlayingChanged(boolean z2) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 7, new s(W0, z2));
    }

    public void onLoadingChanged(boolean z2) {
    }

    public final void onMediaItemTransition(MediaItem mediaItem, int i2) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 1, new x(W0, mediaItem, i2));
    }

    public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 14, new e1(W0, mediaMetadata));
    }

    public final void onMetadata(Metadata metadata) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 28, new b(W0, metadata));
    }

    public final void onPlayWhenReadyChanged(boolean z2, int i2) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 5, new g0(W0, z2, i2));
    }

    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 12, new r0(W0, playbackParameters));
    }

    public final void onPlaybackStateChanged(int i2) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 4, new t0(W0, i2));
    }

    public final void onPlaybackSuppressionReasonChanged(int i2) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 6, new v(W0, i2));
    }

    public final void onPlayerError(PlaybackException playbackException) {
        AnalyticsListener.EventTime d12 = d1(playbackException);
        q2(d12, 10, new j(d12, playbackException));
    }

    public void onPlayerErrorChanged(PlaybackException playbackException) {
        AnalyticsListener.EventTime d12 = d1(playbackException);
        q2(d12, 10, new d(d12, playbackException));
    }

    public final void onPlayerStateChanged(boolean z2, int i2) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, -1, new w(W0, z2, i2));
    }

    public void onPositionDiscontinuity(int i2) {
    }

    public final void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
        if (i2 == 1) {
            this.f23573j = false;
        }
        this.f23568e.j((Player) Assertions.e(this.f23571h));
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 11, new y0(W0, i2, positionInfo, positionInfo2));
    }

    public void onRenderedFirstFrame() {
    }

    public final void onRepeatModeChanged(int i2) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 8, new d0(W0, i2));
    }

    public final void onSeekProcessed() {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, -1, new w0(W0));
    }

    public final void onShuffleModeEnabledChanged(boolean z2) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 9, new f(W0, z2));
    }

    public final void onSkipSilenceEnabledChanged(boolean z2) {
        AnalyticsListener.EventTime c12 = c1();
        q2(c12, 23, new i1(c12, z2));
    }

    public final void onSurfaceSizeChanged(int i2, int i3) {
        AnalyticsListener.EventTime c12 = c1();
        q2(c12, 24, new f0(c12, i2, i3));
    }

    public final void onTimelineChanged(Timeline timeline, int i2) {
        this.f23568e.l((Player) Assertions.e(this.f23571h));
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 0, new v0(W0, i2));
    }

    public void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 19, new m1(W0, trackSelectionParameters));
    }

    public void onTracksChanged(Tracks tracks) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 2, new r(W0, tracks));
    }

    public final void onVideoSizeChanged(VideoSize videoSize) {
        AnalyticsListener.EventTime c12 = c1();
        q2(c12, 25, new d1(c12, videoSize));
    }

    public final void onVolumeChanged(float f2) {
        AnalyticsListener.EventTime c12 = c1();
        q2(c12, 22, new i0(c12, f2));
    }

    public final void p(int i2, long j2, long j3) {
        AnalyticsListener.EventTime Z0 = Z0();
        q2(Z0, 1006, new n0(Z0, i2, j2, j3));
    }

    public final void q() {
        if (!this.f23573j) {
            AnalyticsListener.EventTime W0 = W0();
            this.f23573j = true;
            q2(W0, -1, new l1(W0));
        }
    }

    /* access modifiers changed from: protected */
    public final void q2(AnalyticsListener.EventTime eventTime, int i2, ListenerSet.Event<AnalyticsListener> event) {
        this.f23569f.put(i2, eventTime);
        this.f23570g.l(i2, event);
    }

    public final void r(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime a12 = a1(i2, mediaPeriodId);
        q2(a12, GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION, new u(a12, mediaLoadData));
    }

    public void release() {
        ((HandlerWrapper) Assertions.i(this.f23572i)).g(new i(this));
    }

    public final void s(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime b12 = b1();
        q2(b12, 1013, new m0(b12, decoderCounters));
    }

    public final void t(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime c12 = c1();
        q2(c12, 1009, new a0(c12, format, decoderReuseEvaluation));
    }

    public final void u(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime a12 = a1(i2, mediaPeriodId);
        q2(a12, 1002, new l(a12, loadEventInfo, mediaLoadData));
    }

    public final void v(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime a12 = a1(i2, mediaPeriodId);
        q2(a12, 1000, new s0(a12, loadEventInfo, mediaLoadData));
    }

    public final void w(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime c12 = c1();
        q2(c12, 1015, new h(c12, decoderCounters));
    }

    public void x(Player player, Looper looper) {
        boolean z2;
        if (this.f23571h == null || this.f23568e.f23575b.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        this.f23571h = (Player) Assertions.e(player);
        this.f23572i = this.f23565b.b(looper, (Handler.Callback) null);
        this.f23570g = this.f23570g.e(looper, new n(this, player));
    }

    public final void y(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime a12 = a1(i2, mediaPeriodId);
        q2(a12, 1026, new g1(a12));
    }

    public /* synthetic */ void z(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        com.google.android.exoplayer2.drm.j.a(this, i2, mediaPeriodId);
    }

    public void onCues(CueGroup cueGroup) {
        AnalyticsListener.EventTime W0 = W0();
        q2(W0, 27, new h0(W0, cueGroup));
    }
}
