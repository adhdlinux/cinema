package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.Map;

public final /* synthetic */ class zzfao implements zzbij {
    public final /* synthetic */ zzfgr zza;
    public final /* synthetic */ zzeba zzb;

    public /* synthetic */ zzfao(zzfgr zzfgr, zzeba zzeba) {
        this.zza = zzfgr;
        this.zzb = zzeba;
    }

    public final void zza(Object obj, Map map) {
        zzfgr zzfgr = this.zza;
        zzeba zzeba = this.zzb;
        zzceq zzceq = (zzceq) obj;
        String str = (String) map.get("u");
        if (str == null) {
            zzbzr.zzj("URL missing from httpTrack GMSG.");
        } else if (!zzceq.zzD().zzaj) {
            zzfgr.zzc(str, (zzffy) null);
        } else {
            zzeba.zzd(new zzebc(zzt.zzB().currentTimeMillis(), ((zzcfw) zzceq).zzP().zzb, str, 2));
        }
    }
}
