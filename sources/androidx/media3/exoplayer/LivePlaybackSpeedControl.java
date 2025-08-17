package androidx.media3.exoplayer;

import androidx.media3.common.MediaItem;

public interface LivePlaybackSpeedControl {
    float a(long j2, long j3);

    long b();

    void c();

    void d(long j2);

    void e(MediaItem.LiveConfiguration liveConfiguration);
}
