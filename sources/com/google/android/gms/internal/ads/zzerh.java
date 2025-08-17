package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

public final class zzerh implements zzeqx {
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final boolean zze;
    public final int zzf;

    public zzerh(String str, int i2, int i3, int i4, boolean z2, int i5) {
        this.zza = str;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = z2;
        this.zzf = i5;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = this.zza;
        boolean z2 = true;
        zzfat.zzf(bundle, "carrier", str, !TextUtils.isEmpty(str));
        int i2 = this.zzb;
        if (i2 == -2) {
            z2 = false;
        }
        zzfat.zze(bundle, "cnt", i2, z2);
        bundle.putInt("gnt", this.zzc);
        bundle.putInt("pt", this.zzd);
        Bundle zza2 = zzfat.zza(bundle, "device");
        bundle.putBundle("device", zza2);
        Bundle zza3 = zzfat.zza(zza2, "network");
        zza2.putBundle("network", zza3);
        zza3.putInt("active_network_state", this.zzf);
        zza3.putBoolean("active_network_metered", this.zze);
    }
}
