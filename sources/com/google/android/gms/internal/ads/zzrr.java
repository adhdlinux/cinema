package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import java.util.List;

final class zzrr {
    public static int zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        List a2 = videoCapabilities.getSupportedPerformancePoints();
        if (a2 != null && !a2.isEmpty()) {
            String str = zzfj.zzb;
            if (!str.equals("sabrina") && !str.equals("boreal")) {
                String str2 = zzfj.zzd;
                if (!str2.startsWith("Lenovo TB-X605") && !str2.startsWith("Lenovo TB-X606") && !str2.startsWith("Lenovo TB-X616")) {
                    MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint = new MediaCodecInfo.VideoCapabilities.PerformancePoint(i2, i3, (int) d2);
                    for (int i4 = 0; i4 < a2.size(); i4++) {
                        if (((MediaCodecInfo.VideoCapabilities.PerformancePoint) a2.get(i4)).covers(performancePoint)) {
                            return 2;
                        }
                    }
                    return 1;
                }
            }
        }
        return 0;
    }
}
