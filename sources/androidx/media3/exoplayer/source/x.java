package androidx.media3.exoplayer.source;

import androidx.media3.common.util.Consumer;
import androidx.media3.exoplayer.source.SampleQueue;

public final /* synthetic */ class x implements Consumer {
    public final void accept(Object obj) {
        ((SampleQueue.SharedSampleMetadata) obj).f7113b.release();
    }
}
