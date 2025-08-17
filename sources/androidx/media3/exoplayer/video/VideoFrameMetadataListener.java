package androidx.media3.exoplayer.video;

import android.media.MediaFormat;
import androidx.media3.common.Format;

public interface VideoFrameMetadataListener {
    void e(long j2, long j3, Format format, MediaFormat mediaFormat);
}
