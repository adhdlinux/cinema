package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.upstream.BandwidthMeter;

public abstract class TrackSelector {

    /* renamed from: a  reason: collision with root package name */
    private InvalidationListener f7470a;

    /* renamed from: b  reason: collision with root package name */
    private BandwidthMeter f7471b;

    public interface InvalidationListener {
        void b();

        void d(Renderer renderer);
    }

    /* access modifiers changed from: protected */
    public final BandwidthMeter a() {
        return (BandwidthMeter) Assertions.j(this.f7471b);
    }

    public TrackSelectionParameters b() {
        return TrackSelectionParameters.C;
    }

    public RendererCapabilities.Listener c() {
        return null;
    }

    public void e(InvalidationListener invalidationListener, BandwidthMeter bandwidthMeter) {
        this.f7470a = invalidationListener;
        this.f7471b = bandwidthMeter;
    }

    /* access modifiers changed from: protected */
    public final void f() {
        InvalidationListener invalidationListener = this.f7470a;
        if (invalidationListener != null) {
            invalidationListener.b();
        }
    }

    /* access modifiers changed from: protected */
    public final void g(Renderer renderer) {
        InvalidationListener invalidationListener = this.f7470a;
        if (invalidationListener != null) {
            invalidationListener.d(renderer);
        }
    }

    public boolean h() {
        return false;
    }

    public abstract void i(Object obj);

    public void j() {
        this.f7470a = null;
        this.f7471b = null;
    }

    public abstract TrackSelectorResult k(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException;

    public void l(AudioAttributes audioAttributes) {
    }

    public void m(TrackSelectionParameters trackSelectionParameters) {
    }
}
