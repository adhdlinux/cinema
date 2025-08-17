package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;

public interface TrackSelection {
    Format b(int i2);

    int c(int i2);

    int g(int i2);

    TrackGroup h();

    int length();

    int p(Format format);
}
