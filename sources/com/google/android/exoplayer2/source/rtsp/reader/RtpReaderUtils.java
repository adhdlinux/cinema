package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.util.Util;

class RtpReaderUtils {
    private RtpReaderUtils() {
    }

    public static long a(long j2, long j3, long j4, int i2) {
        return j2 + Util.R0(j3 - j4, 1000000, (long) i2);
    }
}
