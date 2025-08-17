package com.google.android.gms.internal.ads;

import java.util.List;

public final /* synthetic */ class zzvy implements zzwt {
    public final /* synthetic */ zzwy zza;
    public final /* synthetic */ zzwm zzb;
    public final /* synthetic */ boolean zzc;

    public /* synthetic */ zzvy(zzwy zzwy, zzwm zzwm, boolean z2) {
        this.zza = zzwy;
        this.zzb = zzwm;
        this.zzc = z2;
    }

    public final List zza(int i2, zzcy zzcy, int[] iArr) {
        zzwy zzwy = this.zza;
        zzwm zzwm = this.zzb;
        boolean z2 = this.zzc;
        zzvx zzvx = new zzvx(zzwy);
        zzfrz zzfrz = new zzfrz();
        zzcy zzcy2 = zzcy;
        int i3 = 0;
        while (true) {
            int i4 = zzcy2.zzb;
            if (i3 > 0) {
                return zzfrz.zzi();
            }
            zzfrz.zzf(new zzwg(i2, zzcy, i3, zzwm, iArr[i3], z2, zzvx));
            i3++;
        }
    }
}
