package androidx.media3.exoplayer.trackselection;

import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import java.util.Comparator;
import java.util.List;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return DefaultTrackSelector.AudioTrackInfo.c((List) obj, (List) obj2);
    }
}
