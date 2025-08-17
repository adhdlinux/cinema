package h;

import androidx.media3.common.TrackGroup;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import java.util.List;

public final /* synthetic */ class c implements DefaultTrackSelector.TrackInfo.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector f21883a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector.Parameters f21884b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f21885c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int[] f21886d;

    public /* synthetic */ c(DefaultTrackSelector defaultTrackSelector, DefaultTrackSelector.Parameters parameters, boolean z2, int[] iArr) {
        this.f21883a = defaultTrackSelector;
        this.f21884b = parameters;
        this.f21885c = z2;
        this.f21886d = iArr;
    }

    public final List a(int i2, TrackGroup trackGroup, int[] iArr) {
        return this.f21883a.P(this.f21884b, this.f21885c, this.f21886d, i2, trackGroup, iArr);
    }
}
