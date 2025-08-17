package androidx.media3.exoplayer;

import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;

public interface LoadControl {

    public static final class Parameters {

        /* renamed from: a  reason: collision with root package name */
        public final PlayerId f5386a;

        /* renamed from: b  reason: collision with root package name */
        public final Timeline f5387b;

        /* renamed from: c  reason: collision with root package name */
        public final MediaSource.MediaPeriodId f5388c;

        /* renamed from: d  reason: collision with root package name */
        public final long f5389d;

        /* renamed from: e  reason: collision with root package name */
        public final long f5390e;

        /* renamed from: f  reason: collision with root package name */
        public final float f5391f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f5392g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f5393h;

        /* renamed from: i  reason: collision with root package name */
        public final long f5394i;

        public Parameters(PlayerId playerId, Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, float f2, boolean z2, boolean z3, long j4) {
            this.f5386a = playerId;
            this.f5387b = timeline;
            this.f5388c = mediaPeriodId;
            this.f5389d = j2;
            this.f5390e = j3;
            this.f5391f = f2;
            this.f5392g = z2;
            this.f5393h = z3;
            this.f5394i = j4;
        }
    }

    Allocator b();

    boolean c(Parameters parameters);

    void d(PlayerId playerId);

    void e(PlayerId playerId);

    boolean f(Parameters parameters);

    void g(PlayerId playerId);

    void h(PlayerId playerId, Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr);

    boolean i(PlayerId playerId);

    long j(PlayerId playerId);
}
