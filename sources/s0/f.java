package s0;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.List;

public final /* synthetic */ class f implements DefaultTrackSelector.TrackInfo.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector f29223a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector.Parameters f29224b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f29225c;

    public /* synthetic */ f(DefaultTrackSelector defaultTrackSelector, DefaultTrackSelector.Parameters parameters, boolean z2) {
        this.f29223a = defaultTrackSelector;
        this.f29224b = parameters;
        this.f29225c = z2;
    }

    public final List a(int i2, TrackGroup trackGroup, int[] iArr) {
        return this.f29223a.M(this.f29224b, this.f29225c, i2, trackGroup, iArr);
    }
}
