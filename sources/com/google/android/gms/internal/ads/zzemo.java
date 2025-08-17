package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;

public final class zzemo implements zzeqx {
    public final int zza;
    public final boolean zzb;
    public final boolean zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final float zzi;
    public final boolean zzj;

    public zzemo(int i2, boolean z2, boolean z3, int i3, int i4, int i5, int i6, int i7, float f2, boolean z4) {
        this.zza = i2;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = f2;
        this.zzj = z4;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putInt("am", this.zza);
        bundle.putBoolean("ma", this.zzb);
        bundle.putBoolean("sp", this.zzc);
        bundle.putInt("muv", this.zzd);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjz)).booleanValue()) {
            bundle.putInt("muv_min", this.zze);
            bundle.putInt("muv_max", this.zzf);
        }
        bundle.putInt("rm", this.zzg);
        bundle.putInt("riv", this.zzh);
        bundle.putFloat("android_app_volume", this.zzi);
        bundle.putBoolean("android_app_muted", this.zzj);
    }
}
