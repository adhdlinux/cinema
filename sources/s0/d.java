package s0;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.List;

public final /* synthetic */ class d implements DefaultTrackSelector.TrackInfo.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector.Parameters f29219a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f29220b;

    public /* synthetic */ d(DefaultTrackSelector.Parameters parameters, String str) {
        this.f29219a = parameters;
        this.f29220b = str;
    }

    public final List a(int i2, TrackGroup trackGroup, int[] iArr) {
        return DefaultTrackSelector.TextTrackInfo.e(i2, trackGroup, this.f29219a, iArr, this.f29220b);
    }
}
