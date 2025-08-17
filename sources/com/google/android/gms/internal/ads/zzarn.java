package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

final class zzarn implements zzfla {
    private final zzfjd zza;
    private final zzfju zzb;
    private final zzasa zzc;
    private final zzarm zzd;
    private final zzaqw zze;
    private final zzasc zzf;
    private final zzaru zzg;
    private final zzarl zzh;

    zzarn(zzfjd zzfjd, zzfju zzfju, zzasa zzasa, zzarm zzarm, zzaqw zzaqw, zzasc zzasc, zzaru zzaru, zzarl zzarl) {
        this.zza = zzfjd;
        this.zzb = zzfju;
        this.zzc = zzasa;
        this.zzd = zzarm;
        this.zze = zzaqw;
        this.zzf = zzasc;
        this.zzg = zzaru;
        this.zzh = zzarl;
    }

    private final Map zze() {
        HashMap hashMap = new HashMap();
        zzaon zzb2 = this.zzb.zzb();
        hashMap.put("v", this.zza.zzb());
        hashMap.put("gms", Boolean.valueOf(this.zza.zzc()));
        hashMap.put("int", zzb2.zzh());
        hashMap.put("up", Boolean.valueOf(this.zzd.zza()));
        hashMap.put("t", new Throwable());
        zzaru zzaru = this.zzg;
        if (zzaru != null) {
            hashMap.put("tcq", Long.valueOf(zzaru.zzc()));
            hashMap.put("tpq", Long.valueOf(this.zzg.zzg()));
            hashMap.put("tcv", Long.valueOf(this.zzg.zzd()));
            hashMap.put("tpv", Long.valueOf(this.zzg.zzh()));
            hashMap.put("tchv", Long.valueOf(this.zzg.zzb()));
            hashMap.put("tphv", Long.valueOf(this.zzg.zzf()));
            hashMap.put("tcc", Long.valueOf(this.zzg.zza()));
            hashMap.put("tpc", Long.valueOf(this.zzg.zze()));
        }
        return hashMap;
    }

    public final Map zza() {
        Map zze2 = zze();
        zze2.put("lts", Long.valueOf(this.zzc.zza()));
        return zze2;
    }

    public final Map zzb() {
        Map zze2 = zze();
        zzaon zza2 = this.zzb.zza();
        zze2.put("gai", Boolean.valueOf(this.zza.zzd()));
        zze2.put("did", zza2.zzg());
        zze2.put("dst", Integer.valueOf(zza2.zzal() - 1));
        zze2.put("doo", Boolean.valueOf(zza2.zzai()));
        zzaqw zzaqw = this.zze;
        if (zzaqw != null) {
            zze2.put("nt", Long.valueOf(zzaqw.zza()));
        }
        zzasc zzasc = this.zzf;
        if (zzasc != null) {
            zze2.put("vs", Long.valueOf(zzasc.zzc()));
            zze2.put("vf", Long.valueOf(this.zzf.zzb()));
        }
        return zze2;
    }

    public final Map zzc() {
        Map zze2 = zze();
        zzarl zzarl = this.zzh;
        if (zzarl != null) {
            zze2.put("vst", zzarl.zza());
        }
        return zze2;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(View view) {
        this.zzc.zzd(view);
    }
}
