package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.Tracks;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.RendererConfiguration;

public final class TrackSelectorResult {

    /* renamed from: a  reason: collision with root package name */
    public final int f7472a;

    /* renamed from: b  reason: collision with root package name */
    public final RendererConfiguration[] f7473b;

    /* renamed from: c  reason: collision with root package name */
    public final ExoTrackSelection[] f7474c;

    /* renamed from: d  reason: collision with root package name */
    public final Tracks f7475d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f7476e;

    public TrackSelectorResult(RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr, Tracks tracks, Object obj) {
        boolean z2;
        if (rendererConfigurationArr.length == exoTrackSelectionArr.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f7473b = rendererConfigurationArr;
        this.f7474c = (ExoTrackSelection[]) exoTrackSelectionArr.clone();
        this.f7475d = tracks;
        this.f7476e = obj;
        this.f7472a = rendererConfigurationArr.length;
    }

    public boolean a(TrackSelectorResult trackSelectorResult) {
        if (trackSelectorResult == null || trackSelectorResult.f7474c.length != this.f7474c.length) {
            return false;
        }
        for (int i2 = 0; i2 < this.f7474c.length; i2++) {
            if (!b(trackSelectorResult, i2)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(TrackSelectorResult trackSelectorResult, int i2) {
        if (trackSelectorResult != null && Util.c(this.f7473b[i2], trackSelectorResult.f7473b[i2]) && Util.c(this.f7474c[i2], trackSelectorResult.f7474c[i2])) {
            return true;
        }
        return false;
    }

    public boolean c(int i2) {
        return this.f7473b[i2] != null;
    }
}
