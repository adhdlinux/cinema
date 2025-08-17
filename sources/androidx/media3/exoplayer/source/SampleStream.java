package androidx.media3.exoplayer.source;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import java.io.IOException;

public interface SampleStream {
    void a() throws IOException;

    int d(long j2);

    boolean isReady();

    int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2);
}
