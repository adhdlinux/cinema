package com.google.android.gms.internal.ads;

import android.view.Surface;

final class zzza {
    public static void zza(Surface surface, float f2) {
        int i2;
        if (f2 == 0.0f) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        try {
            surface.setFrameRate(f2, i2);
        } catch (IllegalStateException e2) {
            zzer.zzd("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e2);
        }
    }
}
