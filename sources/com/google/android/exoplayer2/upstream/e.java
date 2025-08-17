package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.SlidingPercentile;
import java.util.Comparator;

public final /* synthetic */ class e implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return Float.compare(((SlidingPercentile.Sample) obj).f28511c, ((SlidingPercentile.Sample) obj2).f28511c);
    }
}
