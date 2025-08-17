package s0;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.List;

public final /* synthetic */ class e implements DefaultTrackSelector.TrackInfo.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector.Parameters f29221a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int[] f29222b;

    public /* synthetic */ e(DefaultTrackSelector.Parameters parameters, int[] iArr) {
        this.f29221a = parameters;
        this.f29222b = iArr;
    }

    public final List a(int i2, TrackGroup trackGroup, int[] iArr) {
        return DefaultTrackSelector.VideoTrackInfo.h(i2, trackGroup, this.f29221a, iArr, this.f29222b[i2]);
    }
}
