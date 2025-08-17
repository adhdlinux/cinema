package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;
import java.util.List;

public final class zzcuk {
    private final zzfel zza;
    private final zzbzx zzb;
    private final ApplicationInfo zzc;
    private final String zzd;
    private final List zze;
    private final PackageInfo zzf;
    private final zzgvy zzg;
    private final String zzh;
    private final zzerb zzi;
    private final zzg zzj;
    private final zzfai zzk;

    public zzcuk(zzfel zzfel, zzbzx zzbzx, ApplicationInfo applicationInfo, String str, List list, PackageInfo packageInfo, zzgvy zzgvy, zzg zzg2, String str2, zzerb zzerb, zzfai zzfai) {
        this.zza = zzfel;
        this.zzb = zzbzx;
        this.zzc = applicationInfo;
        this.zzd = str;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = zzgvy;
        this.zzh = str2;
        this.zzi = zzerb;
        this.zzj = zzg2;
        this.zzk = zzfai;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbue zza(zzfwm zzfwm) throws Exception {
        boolean z2;
        Bundle bundle = (Bundle) zzfwm.get();
        zzbzx zzbzx = this.zzb;
        ApplicationInfo applicationInfo = this.zzc;
        String str = this.zzd;
        List list = this.zze;
        PackageInfo packageInfo = this.zzf;
        String str2 = (String) ((zzfwm) this.zzg.zzb()).get();
        String str3 = this.zzh;
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzgV)).booleanValue() || !this.zzj.zzP()) {
            z2 = false;
        } else {
            z2 = true;
        }
        return new zzbue(bundle, zzbzx, applicationInfo, str, list, packageInfo, str2, str3, (zzfcb) null, (String) null, z2, this.zzk.zzb());
    }

    public final zzfwm zzb() {
        zzfel zzfel = this.zza;
        return zzfdv.zzc(this.zzi.zza(new Bundle()), zzfef.SIGNALS, zzfel).zza();
    }

    public final zzfwm zzc() {
        zzfwm zzb2 = zzb();
        return this.zza.zza(zzfef.REQUEST_PARCEL, zzb2, (zzfwm) this.zzg.zzb()).zza(new zzcuj(this, zzb2)).zza();
    }
}
