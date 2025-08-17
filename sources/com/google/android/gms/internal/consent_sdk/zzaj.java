package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

public final class zzaj extends zzd {
    /* access modifiers changed from: private */
    public final zzaj zza = this;
    /* access modifiers changed from: private */
    public final zzcl<Application> zzb;
    /* access modifiers changed from: private */
    public final zzcl<zzam> zzc;
    /* access modifiers changed from: private */
    public final zzcl<zzac> zzd;
    private final zzcl<zzas> zze;
    private final zzcl<zzba> zzf;
    private final zzcl<zzb> zzg;
    private final zzcl<zzn> zzh;
    /* access modifiers changed from: private */
    public final zzcl<zzh> zzi;
    /* access modifiers changed from: private */
    public final zzcl<zzak> zzj;
    private final zzcl<zzz> zzk;
    private final zzcl<zzv> zzl;
    private final zzcl<zzk> zzm;

    /* synthetic */ zzaj(Application application, zzaf zzaf) {
        zzch zza2 = zzci.zza(application);
        this.zzb = zza2;
        zzcl<zzam> zza3 = zzcg.zza(new zzan(zza2));
        this.zzc = zza3;
        zzcl<zzac> zza4 = zzcg.zza(zzad.zza);
        this.zzd = zza4;
        zzaf zzaf2 = new zzaf(this);
        this.zze = zzaf2;
        zzcl<zzba> zza5 = zzcg.zza(new zzbb(zzaf2));
        this.zzf = zza5;
        zzc zzc2 = new zzc(zza2);
        this.zzg = zzc2;
        zzp zzp = new zzp(zza2, zzc2, zza3);
        this.zzh = zzp;
        zzcl<zzh> zza6 = zzcg.zza(new zzi(zzaq.zza));
        this.zzi = zza6;
        zzal zzal = new zzal(zza2, zza3, zzaq.zza);
        this.zzj = zzal;
        zzab zzab = new zzab(zza6, zzal, zza3);
        this.zzk = zzab;
        zzw zzw = new zzw(zza2, zza4, zzao.zza, zzaq.zza, zza3, zza5, zzp, zzab, zza6);
        this.zzl = zzw;
        this.zzm = zzcg.zza(new zzl(zza3, zzw, zza5));
    }

    public final zzk zzb() {
        return this.zzm.zzb();
    }

    public final zzba zzc() {
        return this.zzf.zzb();
    }
}
