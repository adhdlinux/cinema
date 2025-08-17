package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;

public final class zzeqo implements zzeqx {
    public final boolean zza;
    public final boolean zzb;
    public final String zzc;
    public final boolean zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final String zzh;

    zzeqo(boolean z2, boolean z3, String str, boolean z4, int i2, int i3, int i4, String str2) {
        this.zza = z2;
        this.zzb = z3;
        this.zzc = str;
        this.zzd = z4;
        this.zze = i2;
        this.zzf = i3;
        this.zzg = i4;
        this.zzh = str2;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("js", this.zzc);
        bundle.putBoolean("is_nonagon", true);
        bundle.putString("extra_caps", (String) zzba.zzc().zzb(zzbbm.zzds));
        bundle.putInt("target_api", this.zze);
        bundle.putInt("dv", this.zzf);
        bundle.putInt("lv", this.zzg);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfI)).booleanValue() && !TextUtils.isEmpty(this.zzh)) {
            bundle.putString("ev", this.zzh);
        }
        Bundle zza2 = zzfat.zza(bundle, "sdk_env");
        zza2.putBoolean("mf", ((Boolean) zzbdf.zza.zze()).booleanValue());
        zza2.putBoolean("instant_app", this.zza);
        zza2.putBoolean("lite", this.zzb);
        zza2.putBoolean("is_privileged_process", this.zzd);
        bundle.putBundle("sdk_env", zza2);
        Bundle zza3 = zzfat.zza(zza2, "build_meta");
        zza3.putString("cl", "549114221");
        zza3.putString("rapid_rc", "dev");
        zza3.putString("rapid_rollup", "HEAD");
        zza2.putBundle("build_meta", zza3);
    }
}
