package com.google.android.exoplayer2;

import com.google.android.exoplayer2.MediaItem;

public interface LivePlaybackSpeedControl {
    float a(long j2, long j3);

    long b();

    void c();

    void d(long j2);

    void e(MediaItem.LiveConfiguration liveConfiguration);
}
