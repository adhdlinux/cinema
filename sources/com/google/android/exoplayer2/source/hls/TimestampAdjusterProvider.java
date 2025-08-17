package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class TimestampAdjusterProvider {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<TimestampAdjuster> f26540a = new SparseArray<>();

    public TimestampAdjuster a(int i2) {
        TimestampAdjuster timestampAdjuster = this.f26540a.get(i2);
        if (timestampAdjuster != null) {
            return timestampAdjuster;
        }
        TimestampAdjuster timestampAdjuster2 = new TimestampAdjuster(9223372036854775806L);
        this.f26540a.put(i2, timestampAdjuster2);
        return timestampAdjuster2;
    }

    public void b() {
        this.f26540a.clear();
    }
}
