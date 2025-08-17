package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

final class zzsj implements zzsg {
    private final int zza;
    private MediaCodecInfo[] zzb;

    public zzsj(boolean z2, boolean z3) {
        int i2 = 1;
        if (!z2 && !z3) {
            i2 = 0;
        }
        this.zza = i2;
    }

    @EnsuresNonNull({"mediaCodecInfos"})
    private final void zzf() {
        if (this.zzb == null) {
            this.zzb = new MediaCodecList(this.zza).getCodecInfos();
        }
    }

    public final int zza() {
        zzf();
        return this.zzb.length;
    }

    public final MediaCodecInfo zzb(int i2) {
        zzf();
        return this.zzb[i2];
    }

    public final boolean zzc(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }

    public final boolean zzd(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    public final boolean zze() {
        return true;
    }
}
