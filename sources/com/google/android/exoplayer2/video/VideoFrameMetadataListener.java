package com.google.android.exoplayer2.video;

import android.media.MediaFormat;
import com.google.android.exoplayer2.Format;

public interface VideoFrameMetadataListener {
    void e(long j2, long j3, Format format, MediaFormat mediaFormat);
}
