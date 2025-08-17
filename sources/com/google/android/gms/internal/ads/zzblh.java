package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.ArrayList;

public final /* synthetic */ class zzblh implements zzcgl {
    public final /* synthetic */ zzblv zza;

    public /* synthetic */ zzblh(zzblv zzblv) {
        this.zza = zzblv;
    }

    public final void zza() {
        zzblv zzblv = this.zza;
        zzbml zzbml = zzblv.zza;
        ArrayList arrayList = zzblv.zzb;
        long j2 = zzblv.zzc;
        zzbmk zzbmk = zzblv.zzd;
        zzblg zzblg = zzblv.zze;
        arrayList.add(Long.valueOf(zzt.zzB().currentTimeMillis() - j2));
        String valueOf = String.valueOf(arrayList.get(0));
        zze.zza("LoadNewJavascriptEngine(onEngLoaded) latency is " + valueOf + " ms.");
        zzs.zza.postDelayed(new zzblt(zzbml, zzbmk, zzblg, arrayList, j2), (long) ((Integer) zzba.zzc().zzb(zzbbm.zzc)).intValue());
    }
}
