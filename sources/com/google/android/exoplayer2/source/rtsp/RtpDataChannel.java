package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.RtspMessageChannel;
import com.google.android.exoplayer2.upstream.DataSource;
import java.io.IOException;

interface RtpDataChannel extends DataSource {

    public interface Factory {
        RtpDataChannel a(int i2) throws IOException;

        Factory b();
    }

    String n();

    int o();

    RtspMessageChannel.InterleavedBinaryDataListener r();
}
