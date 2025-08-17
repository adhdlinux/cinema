package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class zzfec {
    final /* synthetic */ zzfed zza;
    private final Object zzb;
    private final String zzc;
    private final zzfwm zzd;
    private final List zze;
    private final zzfwm zzf;

    private zzfec(zzfed zzfed, Object obj, String str, zzfwm zzfwm, List list, zzfwm zzfwm2) {
        this.zza = zzfed;
        this.zzb = obj;
        this.zzc = str;
        this.zzd = zzfwm;
        this.zze = list;
        this.zzf = zzfwm2;
    }

    /* synthetic */ zzfec(zzfed zzfed, Object obj, String str, zzfwm zzfwm, List list, zzfwm zzfwm2, zzfeb zzfeb) {
        this(zzfed, obj, (String) null, zzfwm, list, zzfwm2);
    }

    public final zzfdq zza() {
        Object obj = this.zzb;
        String str = this.zzc;
        if (str == null) {
            str = this.zza.zzf(obj);
        }
        zzfdq zzfdq = new zzfdq(obj, str, this.zzf);
        this.zza.zzd.zza(zzfdq);
        zzfwm zzfwm = this.zzd;
        zzfdw zzfdw = new zzfdw(this, zzfdq);
        zzfwn zzfwn = zzcae.zzf;
        zzfwm.zzc(zzfdw, zzfwn);
        zzfwc.zzq(zzfdq, new zzfea(this, zzfdq), zzfwn);
        return zzfdq;
    }

    public final zzfec zzb(Object obj) {
        return this.zza.zzb(obj, zza());
    }

    public final zzfec zzc(Class cls, zzfvj zzfvj) {
        zzfed zzfed = this.zza;
        return new zzfec(zzfed, this.zzb, this.zzc, this.zzd, this.zze, zzfwc.zzf(this.zzf, cls, zzfvj, zzfed.zzb));
    }

    public final zzfec zzd(zzfwm zzfwm) {
        return zzg(new zzfdx(zzfwm), zzcae.zzf);
    }

    public final zzfec zze(zzfdo zzfdo) {
        return zzf(new zzfdz(zzfdo));
    }

    public final zzfec zzf(zzfvj zzfvj) {
        return zzg(zzfvj, this.zza.zzb);
    }

    public final zzfec zzg(zzfvj zzfvj, Executor executor) {
        return new zzfec(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzfwc.zzm(this.zzf, zzfvj, executor));
    }

    public final zzfec zzh(String str) {
        return new zzfec(this.zza, this.zzb, str, this.zzd, this.zze, this.zzf);
    }

    public final zzfec zzi(long j2, TimeUnit timeUnit) {
        zzfed zzfed = this.zza;
        return new zzfec(zzfed, this.zzb, this.zzc, this.zzd, this.zze, zzfwc.zzn(this.zzf, j2, timeUnit, zzfed.zzc));
    }
}
