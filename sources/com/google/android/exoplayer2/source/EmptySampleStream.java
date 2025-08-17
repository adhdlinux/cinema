package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;

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
        decoderInputBuffer.o(4);
        return -4;
    }
}
