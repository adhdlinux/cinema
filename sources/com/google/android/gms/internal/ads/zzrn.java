package com.google.android.gms.internal.ads;

import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;

public final class zzrn {
    public final zzrs zza;
    public final MediaFormat zzb;
    public final zzam zzc;
    public final Surface zzd;
    public final MediaCrypto zze = null;

    private zzrn(zzrs zzrs, MediaFormat mediaFormat, zzam zzam, Surface surface, MediaCrypto mediaCrypto, int i2) {
        this.zza = zzrs;
        this.zzb = mediaFormat;
        this.zzc = zzam;
        this.zzd = surface;
    }

    public static zzrn zza(zzrs zzrs, MediaFormat mediaFormat, zzam zzam, MediaCrypto mediaCrypto) {
        return new zzrn(zzrs, mediaFormat, zzam, (Surface) null, (MediaCrypto) null, 0);
    }

    public static zzrn zzb(zzrs zzrs, MediaFormat mediaFormat, zzam zzam, Surface surface, MediaCrypto mediaCrypto) {
        return new zzrn(zzrs, mediaFormat, zzam, surface, (MediaCrypto) null, 0);
    }
}
