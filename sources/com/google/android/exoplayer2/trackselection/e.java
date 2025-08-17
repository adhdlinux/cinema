package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.Comparator;

public final /* synthetic */ class e implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return DefaultTrackSelector.VideoTrackInfo.f((DefaultTrackSelector.VideoTrackInfo) obj, (DefaultTrackSelector.VideoTrackInfo) obj2);
    }
}
