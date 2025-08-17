package androidx.media3.exoplayer.hls;

import android.util.SparseArray;
import androidx.media3.common.util.TimestampAdjuster;

public final class TimestampAdjusterProvider {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<TimestampAdjuster> f6452a = new SparseArray<>();

    public TimestampAdjuster a(int i2) {
        TimestampAdjuster timestampAdjuster = this.f6452a.get(i2);
        if (timestampAdjuster != null) {
            return timestampAdjuster;
        }
        TimestampAdjuster timestampAdjuster2 = new TimestampAdjuster(9223372036854775806L);
        this.f6452a.put(i2, timestampAdjuster2);
        return timestampAdjuster2;
    }

    public void b() {
        this.f6452a.clear();
    }
}
