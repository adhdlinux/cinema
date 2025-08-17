package h;

import androidx.media3.common.TrackGroup;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import java.util.List;

public final /* synthetic */ class f implements DefaultTrackSelector.TrackInfo.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector.Parameters f21891a;

    public /* synthetic */ f(DefaultTrackSelector.Parameters parameters) {
        this.f21891a = parameters;
    }

    public final List a(int i2, TrackGroup trackGroup, int[] iArr) {
        return DefaultTrackSelector.ImageTrackInfo.e(i2, trackGroup, this.f21891a, iArr);
    }
}
