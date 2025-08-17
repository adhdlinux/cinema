package androidx.media3.exoplayer.analytics;

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
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.base.Objects;
import java.io.IOException;
import java.util.List;

public interface AnalyticsListener {

    public static final class EventTime {

        /* renamed from: a  reason: collision with root package name */
        public final long f5542a;

        /* renamed from: b  reason: collision with root package name */
        public final Timeline f5543b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5544c;

        /* renamed from: d  reason: collision with root package name */
        public final MediaSource.MediaPeriodId f5545d;

        /* renamed from: e  reason: collision with root package name */
        public final long f5546e;

        /* renamed from: f  reason: collision with root package name */
        public final Timeline f5547f;

        /* renamed from: g  reason: collision with root package name */
        public final int f5548g;

        /* renamed from: h  reason: collision with root package name */
        public final MediaSource.MediaPeriodId f5549h;

        /* renamed from: i  reason: collision with root package name */
        public final long f5550i;

        /* renamed from: j  reason: collision with root package name */
        public final long f5551j;

        public EventTime(long j2, Timeline timeline, int i2, MediaSource.MediaPeriodId mediaPeriodId, long j3, Timeline timeline2, int i3, MediaSource.MediaPeriodId mediaPeriodId2, long j4, long j5) {
            this.f5542a = j2;
            this.f5543b = timeline;
            this.f5544c = i2;
            this.f5545d = mediaPeriodId;
            this.f5546e = j3;
            this.f5547f = timeline2;
            this.f5548g = i3;
            this.f5549h = mediaPeriodId2;
            this.f5550i = j4;
            this.f5551j = j5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || EventTime.class != obj.getClass()) {
                return false;
            }
            EventTime eventTime = (EventTime) obj;
            if (this.f5542a == eventTime.f5542a && this.f5544c == eventTime.f5544c && this.f5546e == eventTime.f5546e && this.f5548g == eventTime.f5548g && this.f5550i == eventTime.f5550i && this.f5551j == eventTime.f5551j && Objects.a(this.f5543b, eventTime.f5543b) && Objects.a(this.f5545d, eventTime.f5545d) && Objects.a(this.f5547f, eventTime.f5547f) && Objects.a(this.f5549h, eventTime.f5549h)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.b(Long.valueOf(this.f5542a), this.f5543b, Integer.valueOf(this.f5544c), this.f5545d, Long.valueOf(this.f5546e), this.f5547f, Integer.valueOf(this.f5548g), this.f5549h, Long.valueOf(this.f5550i), Long.valueOf(this.f5551j));
        }
    }

    public static final class Events {

        /* renamed from: a  reason: collision with root package name */
        private final FlagSet f5552a;

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray<EventTime> f5553b;

        public Events(FlagSet flagSet, SparseArray<EventTime> sparseArray) {
            this.f5552a = flagSet;
            SparseArray<EventTime> sparseArray2 = new SparseArray<>(flagSet.d());
            for (int i2 = 0; i2 < flagSet.d(); i2++) {
                int c2 = flagSet.c(i2);
                sparseArray2.append(c2, (EventTime) Assertions.f(sparseArray.get(c2)));
            }
            this.f5553b = sparseArray2;
        }

        public boolean a(int i2) {
            return this.f5552a.a(i2);
        }

        public int b(int i2) {
            return this.f5552a.c(i2);
        }

        public EventTime c(int i2) {
            return (EventTime) Assertions.f(this.f5553b.get(i2));
        }

        public int d() {
            return this.f5552a.d();
        }
    }

    void A(EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2);

    void B(EventTime eventTime, int i2);

    void C(EventTime eventTime, Player.Commands commands);

    void D(EventTime eventTime, Exception exc);

    void E(EventTime eventTime, DecoderCounters decoderCounters);

    void F(EventTime eventTime, Exception exc);

    void G(EventTime eventTime, boolean z2);

    void H(EventTime eventTime, int i2);

    void I(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2);

    void J(EventTime eventTime, long j2);

    void K(EventTime eventTime, int i2, long j2, long j3);

    void L(EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation);

    @Deprecated
    void M(EventTime eventTime, String str, long j2);

    void N(EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig);

    void O(EventTime eventTime, PlaybackParameters playbackParameters);

    void P(EventTime eventTime, String str);

    void Q(EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig);

    void R(EventTime eventTime, String str);

    void S(EventTime eventTime, int i2);

    void T(EventTime eventTime, MediaLoadData mediaLoadData);

    void U(EventTime eventTime);

    @Deprecated
    void V(EventTime eventTime, int i2, int i3, int i4, float f2);

    @Deprecated
    void W(EventTime eventTime, boolean z2);

    void X(EventTime eventTime, int i2, long j2);

    @Deprecated
    void Y(EventTime eventTime);

    void Z(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void a(EventTime eventTime, Object obj, long j2);

    @Deprecated
    void a0(EventTime eventTime, boolean z2, int i2);

    void b(EventTime eventTime, boolean z2);

    void b0(EventTime eventTime, PlaybackException playbackException);

    @Deprecated
    void c0(EventTime eventTime, String str, long j2);

    void d(EventTime eventTime, int i2, boolean z2);

    @Deprecated
    void d0(EventTime eventTime);

    void e(EventTime eventTime, boolean z2);

    void e0(EventTime eventTime);

    void f(EventTime eventTime, Metadata metadata);

    void f0(EventTime eventTime, Tracks tracks);

    @Deprecated
    void g(EventTime eventTime, List<Cue> list);

    void h(EventTime eventTime, boolean z2);

    void h0(EventTime eventTime, int i2);

    void i(EventTime eventTime, PlaybackException playbackException);

    void i0(EventTime eventTime, CueGroup cueGroup);

    @Deprecated
    void j(EventTime eventTime, int i2);

    void j0(EventTime eventTime, String str, long j2, long j3);

    void k(EventTime eventTime, boolean z2, int i2);

    void k0(EventTime eventTime, VideoSize videoSize);

    void l(EventTime eventTime, DecoderCounters decoderCounters);

    void l0(EventTime eventTime, long j2, int i2);

    void m(EventTime eventTime);

    void m0(EventTime eventTime, MediaLoadData mediaLoadData);

    void n(EventTime eventTime, int i2, long j2, long j3);

    void n0(Player player, Events events);

    void o(EventTime eventTime, Exception exc);

    void o0(EventTime eventTime, DeviceInfo deviceInfo);

    void p(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void q(EventTime eventTime, String str, long j2, long j3);

    void q0(EventTime eventTime);

    void r(EventTime eventTime, TrackSelectionParameters trackSelectionParameters);

    void r0(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void s(EventTime eventTime, MediaMetadata mediaMetadata);

    void t(EventTime eventTime, int i2);

    void t0(EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation);

    void u(EventTime eventTime, Exception exc);

    void v(EventTime eventTime, DecoderCounters decoderCounters);

    void w(EventTime eventTime, MediaItem mediaItem, int i2);

    void x(EventTime eventTime, DecoderCounters decoderCounters);

    void y(EventTime eventTime);

    void z(EventTime eventTime, int i2, int i3);
}
