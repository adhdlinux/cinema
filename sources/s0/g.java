package s0;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.common.base.Predicate;

public final /* synthetic */ class g implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector f29226b;

    public /* synthetic */ g(DefaultTrackSelector defaultTrackSelector) {
        this.f29226b = defaultTrackSelector;
    }

    public final boolean apply(Object obj) {
        return this.f29226b.J((Format) obj);
    }
}
