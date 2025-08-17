package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.ExoMediaDrm;
import java.util.UUID;

public final /* synthetic */ class v implements ExoMediaDrm.Provider {
    public final ExoMediaDrm a(UUID uuid) {
        return FrameworkMediaDrm.B(uuid);
    }
}
