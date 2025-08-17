package h;

import androidx.media3.common.TrackGroup;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import java.util.List;

public final /* synthetic */ class e implements DefaultTrackSelector.TrackInfo.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector.Parameters f21889a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f21890b;

    public /* synthetic */ e(DefaultTrackSelector.Parameters parameters, String str) {
        this.f21889a = parameters;
        this.f21890b = str;
    }

    public final List a(int i2, TrackGroup trackGroup, int[] iArr) {
        return DefaultTrackSelector.TextTrackInfo.e(i2, trackGroup, this.f21889a, iArr, this.f21890b);
    }
}
