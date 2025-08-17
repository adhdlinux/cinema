package androidx.media3.exoplayer.source;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;

public final class EmptySampleStream implements SampleStream {
    public void a() {
    }

    public int d(long j2) {
        return 0;
    }

    public boolean isReady() {
        return true;
    }

    public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        decoderInputBuffer.setFlags(4);
        return -4;
    }
}
