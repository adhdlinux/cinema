package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

final class zzhl {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = new MediaCodec.CryptoInfo.Pattern(0, 0);

    /* synthetic */ zzhl(MediaCodec.CryptoInfo cryptoInfo, zzhk zzhk) {
        this.zza = cryptoInfo;
    }

    static /* bridge */ /* synthetic */ void zza(zzhl zzhl, int i2, int i3) {
        zzhl.zzb.set(i2, i3);
        zzhl.zza.setPattern(zzhl.zzb);
    }
}
