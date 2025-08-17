package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.util.Util;

public final class TrackSelectorResult {

    /* renamed from: a  reason: collision with root package name */
    public final int f27820a;

    /* renamed from: b  reason: collision with root package name */
    public final RendererConfiguration[] f27821b;

    /* renamed from: c  reason: collision with root package name */
    public final ExoTrackSelection[] f27822c;

    /* renamed from: d  reason: collision with root package name */
    public final Tracks f27823d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f27824e;

    public TrackSelectorResult(RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr, Tracks tracks, Object obj) {
        this.f27821b = rendererConfigurationArr;
        this.f27822c = (ExoTrackSelection[]) exoTrackSelectionArr.clone();
        this.f27823d = tracks;
        this.f27824e = obj;
        this.f27820a = rendererConfigurationArr.length;
    }

    public boolean a(TrackSelectorResult trackSelectorResult) {
        if (trackSelectorResult == null || trackSelectorResult.f27822c.length != this.f27822c.length) {
            return false;
        }
        for (int i2 = 0; i2 < this.f27822c.length; i2++) {
            if (!b(trackSelectorResult, i2)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(TrackSelectorResult trackSelectorResult, int i2) {
        if (trackSelectorResult != null && Util.c(this.f27821b[i2], trackSelectorResult.f27821b[i2]) && Util.c(this.f27822c[i2], trackSelectorResult.f27822c[i2])) {
            return true;
        }
        return false;
    }

    public boolean c(int i2) {
        return this.f27821b[i2] != null;
    }
}
