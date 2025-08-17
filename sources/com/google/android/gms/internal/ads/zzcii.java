package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;
import java.util.concurrent.ScheduledExecutorService;

final class zzcii extends zzesf {
    private final zzetl zza;
    private final zzciq zzb;
    private final zzcii zzc = this;
    private final zzgwr zzd;
    private final zzgwr zze;
    private final zzgwr zzf;
    private final zzgwr zzg;
    private final zzgwr zzh;
    private final zzgwr zzi;
    private final zzgwr zzj;
    private final zzgwr zzk;
    private final zzgwr zzl;
    private final zzgwr zzm;
    private final zzgwr zzn;

    /* synthetic */ zzcii(zzciq zzciq, zzetl zzetl, zzcih zzcih) {
        this.zzb = zzciq;
        this.zza = zzetl;
        zzetn zzetn = new zzetn(zzetl);
        this.zzd = zzetn;
        zzgwr zzc2 = zzgwd.zzc(zzdoz.zza());
        this.zze = zzc2;
        zzgwr zzc3 = zzgwd.zzc(zzdox.zza());
        this.zzf = zzc3;
        zzgwr zzc4 = zzgwd.zzc(zzdpb.zza());
        this.zzg = zzc4;
        zzgwr zzc5 = zzgwd.zzc(zzdpd.zza());
        this.zzh = zzc5;
        zzgwh zzc6 = zzgwi.zzc(4);
        zzc6.zzb(zzfef.GMS_SIGNALS, zzc2);
        zzc6.zzb(zzfef.BUILD_URL, zzc3);
        zzc6.zzb(zzfef.HTTP, zzc4);
        zzc6.zzb(zzfef.PRE_PROCESS, zzc5);
        zzgwi zzc7 = zzc6.zzc();
        this.zzi = zzc7;
        zzgwr zzc8 = zzgwd.zzc(new zzdpe(zzetn, zzciq.zzg, zzfdg.zza(), zzc7));
        this.zzj = zzc8;
        zzgwo zza2 = zzgwp.zza(0, 1);
        zza2.zza(zzc8);
        zzgwp zzc9 = zza2.zzc();
        this.zzk = zzc9;
        zzfeo zzfeo = new zzfeo(zzc9);
        this.zzl = zzfeo;
        this.zzm = zzgwd.zzc(new zzfen(zzfdg.zza(), zzciq.zzm, zzfeo));
        this.zzn = zzgwd.zzc(new zzffz(zzciq.zzG));
    }

    public final zzerb zza() {
        Context zza2 = this.zzb.zza.zza();
        zzgwm.zzb(zza2);
        zzbyo zzbyo = new zzbyo();
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        zzetf zzetf = new zzetf(zzbyo, zzfwn, zzetm.zza(this.zza));
        zzgwm.zzb(zzfwn);
        HashSet hashSet = new HashSet();
        hashSet.add(new zzepg(zzetf, 0, (ScheduledExecutorService) this.zzb.zzm.zzb()));
        return new zzerb(zza2, zzfwn, hashSet, (zzffy) this.zzn.zzb(), (zzdqa) this.zzb.zzZ.zzb());
    }

    public final zzfel zzb() {
        return (zzfel) this.zzm.zzb();
    }
}
