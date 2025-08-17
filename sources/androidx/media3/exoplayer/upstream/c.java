package androidx.media3.exoplayer.upstream;

import androidx.media3.exoplayer.upstream.SlidingPercentile;
import java.util.Comparator;

public final /* synthetic */ class c implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return Float.compare(((SlidingPercentile.Sample) obj).f7569c, ((SlidingPercentile.Sample) obj2).f7569c);
    }
}
