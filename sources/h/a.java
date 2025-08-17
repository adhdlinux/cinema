package h;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.trackselection.BaseTrackSelection;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return BaseTrackSelection.u((Format) obj, (Format) obj2);
    }
}
