package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.Comparator;

public final /* synthetic */ class d implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return DefaultTrackSelector.VideoTrackInfo.e((DefaultTrackSelector.VideoTrackInfo) obj, (DefaultTrackSelector.VideoTrackInfo) obj2);
    }
}
