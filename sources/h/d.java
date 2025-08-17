package h;

import androidx.media3.common.TrackGroup;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import java.util.List;

public final /* synthetic */ class d implements DefaultTrackSelector.TrackInfo.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector.Parameters f21887a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int[] f21888b;

    public /* synthetic */ d(DefaultTrackSelector.Parameters parameters, int[] iArr) {
        this.f21887a = parameters;
        this.f21888b = iArr;
    }

    public final List a(int i2, TrackGroup trackGroup, int[] iArr) {
        return DefaultTrackSelector.VideoTrackInfo.h(i2, trackGroup, this.f21887a, iArr, this.f21888b[i2]);
    }
}
