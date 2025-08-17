package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class zzelf implements zzeqx {
    public final zzq zza;
    public final String zzb;
    public final boolean zzc;
    public final String zzd;
    public final float zze;
    public final int zzf;
    public final int zzg;
    public final String zzh;
    public final boolean zzi;

    public zzelf(zzq zzq, String str, boolean z2, String str2, float f2, int i2, int i3, String str3, boolean z3) {
        Preconditions.checkNotNull(zzq, "the adSize must not be null");
        this.zza = zzq;
        this.zzb = str;
        this.zzc = z2;
        this.zzd = str2;
        this.zze = f2;
        this.zzf = i2;
        this.zzg = i3;
        this.zzh = str3;
        this.zzi = z3;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        boolean z2;
        boolean z3;
        Bundle bundle = (Bundle) obj;
        if (this.zza.zze == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzfat.zzf(bundle, "smart_w", "full", z2);
        if (this.zza.zzb == -2) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzfat.zzf(bundle, "smart_h", "auto", z3);
        zzfat.zzg(bundle, "ene", true, this.zza.zzj);
        zzfat.zzf(bundle, "rafmt", "102", this.zza.zzm);
        zzfat.zzf(bundle, "rafmt", "103", this.zza.zzn);
        zzfat.zzf(bundle, "rafmt", "105", this.zza.zzo);
        zzfat.zzg(bundle, "inline_adaptive_slot", true, this.zzi);
        zzfat.zzg(bundle, "interscroller_slot", true, this.zza.zzo);
        zzfat.zzc(bundle, "format", this.zzb);
        zzfat.zzf(bundle, "fluid", "height", this.zzc);
        String str = this.zzd;
        zzfat.zzf(bundle, "sz", str, !TextUtils.isEmpty(str));
        bundle.putFloat("u_sd", this.zze);
        bundle.putInt("sw", this.zzf);
        bundle.putInt("sh", this.zzg);
        String str2 = this.zzh;
        zzfat.zzf(bundle, "sc", str2, !TextUtils.isEmpty(str2));
        ArrayList arrayList = new ArrayList();
        zzq[] zzqArr = this.zza.zzg;
        if (zzqArr == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("height", this.zza.zzb);
            bundle2.putInt("width", this.zza.zze);
            bundle2.putBoolean("is_fluid_height", this.zza.zzi);
            arrayList.add(bundle2);
        } else {
            for (zzq zzq : zzqArr) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("is_fluid_height", zzq.zzi);
                bundle3.putInt("height", zzq.zzb);
                bundle3.putInt("width", zzq.zze);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
