package com.google.android.gms.internal.ads;

public final class zzoy extends Exception {
    public final int zza;
    public final boolean zzb;
    public final zzam zzc;

    public zzoy(int i2, zzam zzam, boolean z2) {
        super("AudioTrack write failed: " + i2);
        this.zzb = z2;
        this.zza = i2;
        this.zzc = zzam;
    }
}
