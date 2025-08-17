package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;

public abstract class TrackSelector {

    /* renamed from: a  reason: collision with root package name */
    private InvalidationListener f27818a;

    /* renamed from: b  reason: collision with root package name */
    private BandwidthMeter f27819b;

    public interface InvalidationListener {
        void b();
    }

    /* access modifiers changed from: protected */
    public final BandwidthMeter a() {
        return (BandwidthMeter) Assertions.i(this.f27819b);
    }

    public TrackSelectionParameters b() {
        return TrackSelectionParameters.B;
    }

    public void c(InvalidationListener invalidationListener, BandwidthMeter bandwidthMeter) {
        this.f27818a = invalidationListener;
        this.f27819b = bandwidthMeter;
    }

    /* access modifiers changed from: protected */
    public final void d() {
        InvalidationListener invalidationListener = this.f27818a;
        if (invalidationListener != null) {
            invalidationListener.b();
        }
    }

    public boolean e() {
        return false;
    }

    public abstract void f(Object obj);

    public void g() {
        this.f27818a = null;
        this.f27819b = null;
    }

    public abstract TrackSelectorResult h(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException;

    public void i(AudioAttributes audioAttributes) {
    }

    public void j(TrackSelectionParameters trackSelectionParameters) {
    }
}
