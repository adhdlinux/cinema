package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;

final class zzfaq implements zzfvy {
    final /* synthetic */ zzcez zza;
    final /* synthetic */ zzfgr zzb;
    final /* synthetic */ zzeba zzc;

    zzfaq(zzcez zzcez, zzfgr zzfgr, zzeba zzeba) {
        this.zza = zzcez;
        this.zzb = zzfgr;
        this.zzc = zzeba;
    }

    public final void zza(Throwable th) {
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        if (!this.zza.zzD().zzaj) {
            this.zzb.zzc(str, (zzffy) null);
            return;
        }
        long currentTimeMillis = zzt.zzB().currentTimeMillis();
        String str2 = this.zza.zzP().zzb;
        int i2 = 2;
        if (!zzt.zzo().zzx(this.zza.getContext())) {
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzgb)).booleanValue() || !this.zza.zzD().zzT) {
                i2 = 1;
            }
        }
        this.zzc.zzd(new zzebc(currentTimeMillis, str2, str, i2));
    }
}
