package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;

public interface TrackSelection {
    Format b(int i2);

    int c(int i2);

    int g(int i2);

    TrackGroup h();

    int length();

    int r(Format format);
}
