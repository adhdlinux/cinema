package com.google.android.gms.internal.ads;

public final class zzwz {
    public final zzcy zza;
    public final int[] zzb;

    public zzwz(zzcy zzcy, int[] iArr, int i2) {
        if (iArr.length == 0) {
            zzer.zzd("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.zza = zzcy;
        this.zzb = iArr;
    }
}
