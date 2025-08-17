package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;

public final class RtpUtils {
    private RtpUtils() {
    }

    public static DataSpec a(int i2) {
        return new DataSpec(Uri.parse(Util.C("%s:%d", "rtp://0.0.0.0", Integer.valueOf(i2))));
    }
}
