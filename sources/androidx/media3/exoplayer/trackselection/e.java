package androidx.media3.exoplayer.trackselection;

import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import java.util.Comparator;

public final /* synthetic */ class e implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return DefaultTrackSelector.VideoTrackInfo.e((DefaultTrackSelector.VideoTrackInfo) obj, (DefaultTrackSelector.VideoTrackInfo) obj2);
    }
}
