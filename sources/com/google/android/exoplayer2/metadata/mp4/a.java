package com.google.android.exoplayer2.metadata.mp4;

import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.common.collect.ComparisonChain;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ComparisonChain.j().e(((SlowMotionData.Segment) obj).f25455b, ((SlowMotionData.Segment) obj2).f25455b).e(((SlowMotionData.Segment) obj).f25456c, ((SlowMotionData.Segment) obj2).f25456c).d(((SlowMotionData.Segment) obj).f25457d, ((SlowMotionData.Segment) obj2).f25457d).i();
    }
}
