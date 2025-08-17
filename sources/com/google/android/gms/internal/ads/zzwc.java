package com.google.android.gms.internal.ads;

import java.util.List;

public final /* synthetic */ class zzwc implements zzwt {
    public final /* synthetic */ zzwm zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzwc(zzwm zzwm, String str) {
        this.zza = zzwm;
        this.zzb = str;
    }

    public final List zza(int i2, zzcy zzcy, int[] iArr) {
        zzwm zzwm = this.zza;
        String str = this.zzb;
        int i3 = zzwy.zzb;
        zzfrz zzfrz = new zzfrz();
        int i4 = 0;
        while (true) {
            int i5 = zzcy.zzb;
            if (i4 > 0) {
                return zzfrz.zzi();
            }
            zzfrz.zzf(new zzws(i2, zzcy, i4, zzwm, iArr[i4], str));
            i4++;
        }
    }
}
