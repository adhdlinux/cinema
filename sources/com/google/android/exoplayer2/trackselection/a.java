package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.Comparator;
import java.util.List;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return DefaultTrackSelector.TextTrackInfo.c((List) obj, (List) obj2);
    }
}
