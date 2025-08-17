package com.google.android.gms.internal.ads;

final class zzccy extends zzams {
    static final zzccy zzb = new zzccy();

    zzccy() {
    }

    public final zzamw zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzamy();
        }
        if ("mvhd".equals(str)) {
            return new zzamz();
        }
        return new zzana(str);
    }
}
