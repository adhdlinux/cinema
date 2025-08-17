package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.SlidingPercentile;
import java.util.Comparator;

public final /* synthetic */ class d implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return SlidingPercentile.g((SlidingPercentile.Sample) obj, (SlidingPercentile.Sample) obj2);
    }
}
