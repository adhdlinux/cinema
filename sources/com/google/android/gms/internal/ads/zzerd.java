package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.ArrayList;

public final class zzerd implements zzeqx {
    public final boolean zza;
    public final boolean zzb;
    public final String zzc;
    public final boolean zzd;
    public final boolean zze;
    public final boolean zzf;
    public final String zzg;
    public final ArrayList zzh;
    public final String zzi;
    public final String zzj;
    public final String zzk;
    public final boolean zzl;
    public final String zzm;
    public final long zzn;
    public final boolean zzo;

    public zzerd(boolean z2, boolean z3, String str, boolean z4, boolean z5, boolean z6, String str2, ArrayList arrayList, String str3, String str4, String str5, boolean z7, String str6, long j2, boolean z8) {
        this.zza = z2;
        this.zzb = z3;
        this.zzc = str;
        this.zzd = z4;
        this.zze = z5;
        this.zzf = z6;
        this.zzg = str2;
        this.zzh = arrayList;
        this.zzi = str3;
        this.zzj = str4;
        this.zzk = str5;
        this.zzl = z7;
        this.zzm = str6;
        this.zzn = j2;
        this.zzo = z8;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putBoolean("cog", this.zza);
        bundle.putBoolean("coh", this.zzb);
        bundle.putString("gl", this.zzc);
        bundle.putBoolean("simulator", this.zzd);
        bundle.putBoolean("is_latchsky", this.zze);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjC)).booleanValue()) {
            bundle.putBoolean("is_sidewinder", this.zzf);
        }
        bundle.putString("hl", this.zzg);
        if (!this.zzh.isEmpty()) {
            bundle.putStringArrayList("hl_list", this.zzh);
        }
        bundle.putString("mv", this.zzi);
        bundle.putString("submodel", this.zzm);
        Bundle zza2 = zzfat.zza(bundle, "device");
        bundle.putBundle("device", zza2);
        zza2.putString("build", this.zzk);
        zza2.putLong("remaining_data_partition_space", this.zzn);
        Bundle zza3 = zzfat.zza(zza2, "browser");
        zza2.putBundle("browser", zza3);
        zza3.putBoolean("is_browser_custom_tabs_capable", this.zzl);
        if (!TextUtils.isEmpty(this.zzj)) {
            Bundle zza4 = zzfat.zza(zza2, "play_store");
            zza2.putBundle("play_store", zza4);
            zza4.putString("package_version", this.zzj);
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjO)).booleanValue()) {
            bundle.putBoolean("is_bstar", this.zzo);
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjM)).booleanValue()) {
            zzfat.zzg(bundle, "gotmt_l", true, ((Boolean) zzba.zzc().zzb(zzbbm.zzjJ)).booleanValue());
            zzfat.zzg(bundle, "gotmt_i", true, ((Boolean) zzba.zzc().zzb(zzbbm.zzjI)).booleanValue());
        }
    }
}
