package h;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import com.google.common.base.Predicate;

public final /* synthetic */ class g implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector f21892b;

    public /* synthetic */ g(DefaultTrackSelector defaultTrackSelector) {
        this.f21892b = defaultTrackSelector;
    }

    public final boolean apply(Object obj) {
        return this.f21892b.N((Format) obj);
    }
}
