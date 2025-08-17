package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.io.IOException;

public interface SampleStream {
    void a() throws IOException;

    int d(long j2);

    boolean isReady();

    int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2);
}
