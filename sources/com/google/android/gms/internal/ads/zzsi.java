package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.unity3d.services.core.device.MimeTypes;

final class zzsi implements zzsg {
    private zzsi() {
    }

    /* synthetic */ zzsi(zzsh zzsh) {
    }

    public final int zza() {
        return MediaCodecList.getCodecCount();
    }

    public final MediaCodecInfo zzb(int i2) {
        return MediaCodecList.getCodecInfoAt(i2);
    }

    public final boolean zzc(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }

    public final boolean zzd(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (!"secure-playback".equals(str) || !MimeTypes.VIDEO_H264.equals(str2)) {
            return false;
        }
        return true;
    }

    public final boolean zze() {
        return false;
    }
}
