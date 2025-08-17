package s0;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;

public final /* synthetic */ class i implements Bundleable.Creator {
    public final Bundleable a(Bundle bundle) {
        return DefaultTrackSelector.SelectionOverride.b(bundle);
    }
}
