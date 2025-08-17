package com.google.android.exoplayer2.analytics;

import android.util.SparseArray;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.base.Objects;
import java.io.IOException;
import java.util.List;

public interface AnalyticsListener {

    public static final class EventTime {

        /* renamed from: a  reason: collision with root package name */
        public final long f23553a;

        /* renamed from: b  reason: collision with root package name */
        public final Timeline f23554b;

        /* renamed from: c  reason: collision with root package name */
        public final int f23555c;

        /* renamed from: d  reason: collision with root package name */
        public final MediaSource.MediaPeriodId f23556d;

        /* renamed from: e  reason: collision with root package name */
        public final long f23557e;

        /* renamed from: f  reason: collision with root package name */
        public final Timeline f23558f;

        /* renamed from: g  reason: collision with root package name */
        public final int f23559g;

        /* renamed from: h  reason: collision with root package name */
        public final MediaSource.MediaPeriodId f23560h;

        /* renamed from: i  reason: collision with root package name */
        public final long f23561i;

        /* renamed from: j  reason: collision with root package name */
        public final long f23562j;

        public EventTime(long j2, Timeline timeline, int i2, MediaSource.MediaPeriodId mediaPeriodId, long j3, Timeline timeline2, int i3, MediaSource.MediaPeriodId mediaPeriodId2, long j4, long j5) {
            this.f23553a = j2;
            this.f23554b = timeline;
            this.f23555c = i2;
            this.f23556d = mediaPeriodId;
            this.f23557e = j3;
            this.f23558f = timeline2;
            this.f23559g = i3;
            this.f23560h = mediaPeriodId2;
            this.f23561i = j4;
            this.f23562j = j5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || EventTime.class != obj.getClass()) {
                return false;
            }
            EventTime eventTime = (EventTime) obj;
            if (this.f23553a == eventTime.f23553a && this.f23555c == eventTime.f23555c && this.f23557e == eventTime.f23557e && this.f23559g == eventTime.f23559g && this.f23561i == eventTime.f23561i && this.f23562j == eventTime.f23562j && Objects.a(this.f23554b, eventTime.f23554b) && Objects.a(this.f23556d, eventTime.f23556d) && Objects.a(this.f23558f, eventTime.f23558f) && Objects.a(this.f23560h, eventTime.f23560h)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.b(Long.valueOf(this.f23553a), this.f23554b, Integer.valueOf(this.f23555c), this.f23556d, Long.valueOf(this.f23557e), this.f23558f, Integer.valueOf(this.f23559g), this.f23560h, Long.valueOf(this.f23561i), Long.valueOf(this.f23562j));
        }
    }

    public static final class Events {

        /* renamed from: a  reason: collision with root package name */
        private final FlagSet f23563a;

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray<EventTime> f23564b;

        public Events(FlagSet flagSet, SparseArray<EventTime> sparseArray) {
            this.f23563a = flagSet;
            SparseArray<EventTime> sparseArray2 = new SparseArray<>(flagSet.d());
            for (int i2 = 0; i2 < flagSet.d(); i2++) {
                int c2 = flagSet.c(i2);
                sparseArray2.append(c2, (EventTime) Assertions.e(sparseArray.get(c2)));
            }
            this.f23564b = sparseArray2;
        }

        public boolean a(int i2) {
            return this.f23563a.a(i2);
        }

        public int b(int i2) {
            return this.f23563a.c(i2);
        }

        public EventTime c(int i2) {
            return (EventTime) Assertions.e(this.f23564b.get(i2));
        }

        public int d() {
            return this.f23563a.d();
        }
    }

    void A(EventTime eventTime, String str, long j2, long j3);

    void B(EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation);

    void C(EventTime eventTime, Exception exc);

    void D(EventTime eventTime, int i2);

    @Deprecated
    void E(EventTime eventTime);

    void F(EventTime eventTime, MediaItem mediaItem, int i2);

    void G(EventTime eventTime, Tracks tracks);

    void H(EventTime eventTime, TrackSelectionParameters trackSelectionParameters);

    @Deprecated
    void I(EventTime eventTime);

    void J(EventTime eventTime, DecoderCounters decoderCounters);

    void K(EventTime eventTime);

    void L(EventTime eventTime, int i2, long j2, long j3);

    void M(EventTime eventTime, int i2, boolean z2);

    @Deprecated
    void N(EventTime eventTime, int i2, int i3, int i4, float f2);

    @Deprecated
    void O(EventTime eventTime, int i2, Format format);

    @Deprecated
    void P(EventTime eventTime);

    void Q(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    @Deprecated
    void R(EventTime eventTime, int i2, String str, long j2);

    void S(EventTime eventTime, PlaybackException playbackException);

    @Deprecated
    void T(EventTime eventTime, int i2);

    void U(EventTime eventTime, CueGroup cueGroup);

    void V(EventTime eventTime);

    void W(EventTime eventTime, PlaybackParameters playbackParameters);

    void X(EventTime eventTime, int i2, long j2, long j3);

    void Y(EventTime eventTime, DecoderCounters decoderCounters);

    void Z(EventTime eventTime, DecoderCounters decoderCounters);

    void a(EventTime eventTime, String str);

    void a0(EventTime eventTime, String str, long j2, long j3);

    void b(EventTime eventTime, long j2, int i2);

    void b0(EventTime eventTime, int i2);

    void c(EventTime eventTime, int i2);

    void c0(EventTime eventTime);

    void d(EventTime eventTime, Exception exc);

    void d0(EventTime eventTime, VideoSize videoSize);

    void e(EventTime eventTime);

    void f(EventTime eventTime, int i2);

    @Deprecated
    void g(EventTime eventTime, boolean z2);

    @Deprecated
    void g0(EventTime eventTime, Format format);

    void h(EventTime eventTime, MediaMetadata mediaMetadata);

    void h0(EventTime eventTime);

    void i(EventTime eventTime, PlaybackException playbackException);

    void i0(EventTime eventTime, float f2);

    void j(EventTime eventTime, DecoderCounters decoderCounters);

    void j0(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void k(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2);

    void k0(EventTime eventTime, boolean z2);

    @Deprecated
    void l(EventTime eventTime, int i2, DecoderCounters decoderCounters);

    void l0(EventTime eventTime, Exception exc);

    @Deprecated
    void m(EventTime eventTime, String str, long j2);

    void m0(EventTime eventTime, MediaLoadData mediaLoadData);

    void n(EventTime eventTime, Metadata metadata);

    void n0(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void o(Player player, Events events);

    void o0(EventTime eventTime, MediaLoadData mediaLoadData);

    @Deprecated
    void p(EventTime eventTime, boolean z2, int i2);

    void p0(EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2);

    void q(EventTime eventTime, int i2);

    void q0(EventTime eventTime, String str);

    @Deprecated
    void r(EventTime eventTime, Format format);

    void s(EventTime eventTime, long j2);

    @Deprecated
    void s0(EventTime eventTime, String str, long j2);

    void t(EventTime eventTime, int i2, int i3);

    void t0(EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation);

    void u(EventTime eventTime, boolean z2);

    void u0(EventTime eventTime, Player.Commands commands);

    void v(EventTime eventTime, int i2, long j2);

    void v0(EventTime eventTime, Object obj, long j2);

    void w(EventTime eventTime, Exception exc);

    @Deprecated
    void w0(EventTime eventTime, int i2, DecoderCounters decoderCounters);

    void x(EventTime eventTime, boolean z2);

    void x0(EventTime eventTime, DeviceInfo deviceInfo);

    @Deprecated
    void y(EventTime eventTime, List<Cue> list);

    void y0(EventTime eventTime, boolean z2);

    void z(EventTime eventTime, boolean z2, int i2);
}
