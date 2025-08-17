package androidx.media3.exoplayer;

import android.os.SystemClock;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import com.google.common.collect.ImmutableList;
import java.util.List;

final class PlaybackInfo {

    /* renamed from: u  reason: collision with root package name */
    private static final MediaSource.MediaPeriodId f5463u = new MediaSource.MediaPeriodId(new Object());

    /* renamed from: a  reason: collision with root package name */
    public final Timeline f5464a;

    /* renamed from: b  reason: collision with root package name */
    public final MediaSource.MediaPeriodId f5465b;

    /* renamed from: c  reason: collision with root package name */
    public final long f5466c;

    /* renamed from: d  reason: collision with root package name */
    public final long f5467d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5468e;

    /* renamed from: f  reason: collision with root package name */
    public final ExoPlaybackException f5469f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f5470g;

    /* renamed from: h  reason: collision with root package name */
    public final TrackGroupArray f5471h;

    /* renamed from: i  reason: collision with root package name */
    public final TrackSelectorResult f5472i;

    /* renamed from: j  reason: collision with root package name */
    public final List<Metadata> f5473j;

    /* renamed from: k  reason: collision with root package name */
    public final MediaSource.MediaPeriodId f5474k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f5475l;

    /* renamed from: m  reason: collision with root package name */
    public final int f5476m;

    /* renamed from: n  reason: collision with root package name */
    public final int f5477n;

    /* renamed from: o  reason: collision with root package name */
    public final PlaybackParameters f5478o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f5479p;

    /* renamed from: q  reason: collision with root package name */
    public volatile long f5480q;

    /* renamed from: r  reason: collision with root package name */
    public volatile long f5481r;

    /* renamed from: s  reason: collision with root package name */
    public volatile long f5482s;

    /* renamed from: t  reason: collision with root package name */
    public volatile long f5483t;

    public PlaybackInfo(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, int i2, ExoPlaybackException exoPlaybackException, boolean z2, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List<Metadata> list, MediaSource.MediaPeriodId mediaPeriodId2, boolean z3, int i3, int i4, PlaybackParameters playbackParameters, long j4, long j5, long j6, long j7, boolean z4) {
        this.f5464a = timeline;
        this.f5465b = mediaPeriodId;
        this.f5466c = j2;
        this.f5467d = j3;
        this.f5468e = i2;
        this.f5469f = exoPlaybackException;
        this.f5470g = z2;
        this.f5471h = trackGroupArray;
        this.f5472i = trackSelectorResult;
        this.f5473j = list;
        this.f5474k = mediaPeriodId2;
        this.f5475l = z3;
        this.f5476m = i3;
        this.f5477n = i4;
        this.f5478o = playbackParameters;
        this.f5480q = j4;
        this.f5481r = j5;
        this.f5482s = j6;
        this.f5483t = j7;
        this.f5479p = z4;
    }

    public static PlaybackInfo k(TrackSelectorResult trackSelectorResult) {
        Timeline timeline = Timeline.f4346a;
        MediaSource.MediaPeriodId mediaPeriodId = f5463u;
        return new PlaybackInfo(timeline, mediaPeriodId, -9223372036854775807L, 0, 1, (ExoPlaybackException) null, false, TrackGroupArray.f7176d, trackSelectorResult, ImmutableList.r(), mediaPeriodId, false, 1, 0, PlaybackParameters.f4303d, 0, 0, 0, 0, false);
    }

    public static MediaSource.MediaPeriodId l() {
        return f5463u;
    }

    public PlaybackInfo a() {
        return new PlaybackInfo(this.f5464a, this.f5465b, this.f5466c, this.f5467d, this.f5468e, this.f5469f, this.f5470g, this.f5471h, this.f5472i, this.f5473j, this.f5474k, this.f5475l, this.f5476m, this.f5477n, this.f5478o, this.f5480q, this.f5481r, m(), SystemClock.elapsedRealtime(), this.f5479p);
    }

    public PlaybackInfo b(boolean z2) {
        Timeline timeline = this.f5464a;
        return new PlaybackInfo(timeline, this.f5465b, this.f5466c, this.f5467d, this.f5468e, this.f5469f, z2, this.f5471h, this.f5472i, this.f5473j, this.f5474k, this.f5475l, this.f5476m, this.f5477n, this.f5478o, this.f5480q, this.f5481r, this.f5482s, this.f5483t, this.f5479p);
    }

    public PlaybackInfo c(MediaSource.MediaPeriodId mediaPeriodId) {
        Timeline timeline = this.f5464a;
        return new PlaybackInfo(timeline, this.f5465b, this.f5466c, this.f5467d, this.f5468e, this.f5469f, this.f5470g, this.f5471h, this.f5472i, this.f5473j, mediaPeriodId, this.f5475l, this.f5476m, this.f5477n, this.f5478o, this.f5480q, this.f5481r, this.f5482s, this.f5483t, this.f5479p);
    }

    public PlaybackInfo d(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, long j4, long j5, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List<Metadata> list) {
        long j6 = j2;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        TrackSelectorResult trackSelectorResult2 = trackSelectorResult;
        List<Metadata> list2 = list;
        Timeline timeline = this.f5464a;
        return new PlaybackInfo(timeline, mediaPeriodId, j3, j4, this.f5468e, this.f5469f, this.f5470g, trackGroupArray2, trackSelectorResult2, list2, this.f5474k, this.f5475l, this.f5476m, this.f5477n, this.f5478o, this.f5480q, j5, j6, SystemClock.elapsedRealtime(), this.f5479p);
    }

    public PlaybackInfo e(boolean z2, int i2, int i3) {
        Timeline timeline = this.f5464a;
        return new PlaybackInfo(timeline, this.f5465b, this.f5466c, this.f5467d, this.f5468e, this.f5469f, this.f5470g, this.f5471h, this.f5472i, this.f5473j, this.f5474k, z2, i2, i3, this.f5478o, this.f5480q, this.f5481r, this.f5482s, this.f5483t, this.f5479p);
    }

    public PlaybackInfo f(ExoPlaybackException exoPlaybackException) {
        Timeline timeline = this.f5464a;
        return new PlaybackInfo(timeline, this.f5465b, this.f5466c, this.f5467d, this.f5468e, exoPlaybackException, this.f5470g, this.f5471h, this.f5472i, this.f5473j, this.f5474k, this.f5475l, this.f5476m, this.f5477n, this.f5478o, this.f5480q, this.f5481r, this.f5482s, this.f5483t, this.f5479p);
    }

    public PlaybackInfo g(PlaybackParameters playbackParameters) {
        Timeline timeline = this.f5464a;
        return new PlaybackInfo(timeline, this.f5465b, this.f5466c, this.f5467d, this.f5468e, this.f5469f, this.f5470g, this.f5471h, this.f5472i, this.f5473j, this.f5474k, this.f5475l, this.f5476m, this.f5477n, playbackParameters, this.f5480q, this.f5481r, this.f5482s, this.f5483t, this.f5479p);
    }

    public PlaybackInfo h(int i2) {
        Timeline timeline = this.f5464a;
        return new PlaybackInfo(timeline, this.f5465b, this.f5466c, this.f5467d, i2, this.f5469f, this.f5470g, this.f5471h, this.f5472i, this.f5473j, this.f5474k, this.f5475l, this.f5476m, this.f5477n, this.f5478o, this.f5480q, this.f5481r, this.f5482s, this.f5483t, this.f5479p);
    }

    public PlaybackInfo i(boolean z2) {
        Timeline timeline = this.f5464a;
        return new PlaybackInfo(timeline, this.f5465b, this.f5466c, this.f5467d, this.f5468e, this.f5469f, this.f5470g, this.f5471h, this.f5472i, this.f5473j, this.f5474k, this.f5475l, this.f5476m, this.f5477n, this.f5478o, this.f5480q, this.f5481r, this.f5482s, this.f5483t, z2);
    }

    public PlaybackInfo j(Timeline timeline) {
        return new PlaybackInfo(timeline, this.f5465b, this.f5466c, this.f5467d, this.f5468e, this.f5469f, this.f5470g, this.f5471h, this.f5472i, this.f5473j, this.f5474k, this.f5475l, this.f5476m, this.f5477n, this.f5478o, this.f5480q, this.f5481r, this.f5482s, this.f5483t, this.f5479p);
    }

    public long m() {
        long j2;
        long j3;
        if (!n()) {
            return this.f5482s;
        }
        do {
            j2 = this.f5483t;
            j3 = this.f5482s;
        } while (j2 != this.f5483t);
        return Util.P0(Util.t1(j3) + ((long) (((float) (SystemClock.elapsedRealtime() - j2)) * this.f5478o.f4306a)));
    }

    public boolean n() {
        return this.f5468e == 3 && this.f5475l && this.f5477n == 0;
    }

    public void o(long j2) {
        this.f5482s = j2;
        this.f5483t = SystemClock.elapsedRealtime();
    }
}
