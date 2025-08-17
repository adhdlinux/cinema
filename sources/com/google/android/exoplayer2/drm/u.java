package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.ExoMediaDrm;
import java.util.UUID;

public final /* synthetic */ class u implements ExoMediaDrm.Provider {
    public final ExoMediaDrm a(UUID uuid) {
        return FrameworkMediaDrm.A(uuid);
    }
}
