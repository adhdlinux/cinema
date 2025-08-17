package com.google.android.exoplayer2;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.common.collect.ImmutableList;
import java.util.List;

final class PlaybackInfo {

    /* renamed from: s  reason: collision with root package name */
    private static final MediaSource.MediaPeriodId f23376s = new MediaSource.MediaPeriodId(new Object());

    /* renamed from: a  reason: collision with root package name */
    public final Timeline f23377a;

    /* renamed from: b  reason: collision with root package name */
    public final MediaSource.MediaPeriodId f23378b;

    /* renamed from: c  reason: collision with root package name */
    public final long f23379c;

    /* renamed from: d  reason: collision with root package name */
    public final long f23380d;

    /* renamed from: e  reason: collision with root package name */
    public final int f23381e;

    /* renamed from: f  reason: collision with root package name */
    public final ExoPlaybackException f23382f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f23383g;

    /* renamed from: h  reason: collision with root package name */
    public final TrackGroupArray f23384h;

    /* renamed from: i  reason: collision with root package name */
    public final TrackSelectorResult f23385i;

    /* renamed from: j  reason: collision with root package name */
    public final List<Metadata> f23386j;

    /* renamed from: k  reason: collision with root package name */
    public final MediaSource.MediaPeriodId f23387k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f23388l;

    /* renamed from: m  reason: collision with root package name */
    public final int f23389m;

    /* renamed from: n  reason: collision with root package name */
    public final PlaybackParameters f23390n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f23391o;

    /* renamed from: p  reason: collision with root package name */
    public volatile long f23392p;

    /* renamed from: q  reason: collision with root package name */
    public volatile long f23393q;

    /* renamed from: r  reason: collision with root package name */
    public volatile long f23394r;

    public PlaybackInfo(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, int i2, ExoPlaybackException exoPlaybackException, boolean z2, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List<Metadata> list, MediaSource.MediaPeriodId mediaPeriodId2, boolean z3, int i3, PlaybackParameters playbackParameters, long j4, long j5, long j6, boolean z4) {
        this.f23377a = timeline;
        this.f23378b = mediaPeriodId;
        this.f23379c = j2;
        this.f23380d = j3;
        this.f23381e = i2;
        this.f23382f = exoPlaybackException;
        this.f23383g = z2;
        this.f23384h = trackGroupArray;
        this.f23385i = trackSelectorResult;
        this.f23386j = list;
        this.f23387k = mediaPeriodId2;
        this.f23388l = z3;
        this.f23389m = i3;
        this.f23390n = playbackParameters;
        this.f23392p = j4;
        this.f23393q = j5;
        this.f23394r = j6;
        this.f23391o = z4;
    }

    public static PlaybackInfo j(TrackSelectorResult trackSelectorResult) {
        Timeline timeline = Timeline.f23481b;
        MediaSource.MediaPeriodId mediaPeriodId = f23376s;
        return new PlaybackInfo(timeline, mediaPeriodId, -9223372036854775807L, 0, 1, (ExoPlaybackException) null, false, TrackGroupArray.f26007e, trackSelectorResult, ImmutableList.r(), mediaPeriodId, false, 0, PlaybackParameters.f23395e, 0, 0, 0, false);
    }

    public static MediaSource.MediaPeriodId k() {
        return f23376s;
    }

    public PlaybackInfo a(boolean z2) {
        Timeline timeline = this.f23377a;
        return new PlaybackInfo(timeline, this.f23378b, this.f23379c, this.f23380d, this.f23381e, this.f23382f, z2, this.f23384h, this.f23385i, this.f23386j, this.f23387k, this.f23388l, this.f23389m, this.f23390n, this.f23392p, this.f23393q, this.f23394r, this.f23391o);
    }

    public PlaybackInfo b(MediaSource.MediaPeriodId mediaPeriodId) {
        Timeline timeline = this.f23377a;
        return new PlaybackInfo(timeline, this.f23378b, this.f23379c, this.f23380d, this.f23381e, this.f23382f, this.f23383g, this.f23384h, this.f23385i, this.f23386j, mediaPeriodId, this.f23388l, this.f23389m, this.f23390n, this.f23392p, this.f23393q, this.f23394r, this.f23391o);
    }

    public PlaybackInfo c(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, long j4, long j5, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List<Metadata> list) {
        long j6 = j2;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        TrackSelectorResult trackSelectorResult2 = trackSelectorResult;
        List<Metadata> list2 = list;
        Timeline timeline = this.f23377a;
        return new PlaybackInfo(timeline, mediaPeriodId, j3, j4, this.f23381e, this.f23382f, this.f23383g, trackGroupArray2, trackSelectorResult2, list2, this.f23387k, this.f23388l, this.f23389m, this.f23390n, this.f23392p, j5, j6, this.f23391o);
    }

    public PlaybackInfo d(boolean z2, int i2) {
        Timeline timeline = this.f23377a;
        return new PlaybackInfo(timeline, this.f23378b, this.f23379c, this.f23380d, this.f23381e, this.f23382f, this.f23383g, this.f23384h, this.f23385i, this.f23386j, this.f23387k, z2, i2, this.f23390n, this.f23392p, this.f23393q, this.f23394r, this.f23391o);
    }

    public PlaybackInfo e(ExoPlaybackException exoPlaybackException) {
        Timeline timeline = this.f23377a;
        return new PlaybackInfo(timeline, this.f23378b, this.f23379c, this.f23380d, this.f23381e, exoPlaybackException, this.f23383g, this.f23384h, this.f23385i, this.f23386j, this.f23387k, this.f23388l, this.f23389m, this.f23390n, this.f23392p, this.f23393q, this.f23394r, this.f23391o);
    }

    public PlaybackInfo f(PlaybackParameters playbackParameters) {
        Timeline timeline = this.f23377a;
        return new PlaybackInfo(timeline, this.f23378b, this.f23379c, this.f23380d, this.f23381e, this.f23382f, this.f23383g, this.f23384h, this.f23385i, this.f23386j, this.f23387k, this.f23388l, this.f23389m, playbackParameters, this.f23392p, this.f23393q, this.f23394r, this.f23391o);
    }

    public PlaybackInfo g(int i2) {
        Timeline timeline = this.f23377a;
        return new PlaybackInfo(timeline, this.f23378b, this.f23379c, this.f23380d, i2, this.f23382f, this.f23383g, this.f23384h, this.f23385i, this.f23386j, this.f23387k, this.f23388l, this.f23389m, this.f23390n, this.f23392p, this.f23393q, this.f23394r, this.f23391o);
    }

    public PlaybackInfo h(boolean z2) {
        Timeline timeline = this.f23377a;
        return new PlaybackInfo(timeline, this.f23378b, this.f23379c, this.f23380d, this.f23381e, this.f23382f, this.f23383g, this.f23384h, this.f23385i, this.f23386j, this.f23387k, this.f23388l, this.f23389m, this.f23390n, this.f23392p, this.f23393q, this.f23394r, z2);
    }

    public PlaybackInfo i(Timeline timeline) {
        return new PlaybackInfo(timeline, this.f23378b, this.f23379c, this.f23380d, this.f23381e, this.f23382f, this.f23383g, this.f23384h, this.f23385i, this.f23386j, this.f23387k, this.f23388l, this.f23389m, this.f23390n, this.f23392p, this.f23393q, this.f23394r, this.f23391o);
    }
}
