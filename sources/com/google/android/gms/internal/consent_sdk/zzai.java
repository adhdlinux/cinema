package com.google.android.gms.internal.consent_sdk;

final class zzai implements zzat {
    private final zzaj zza;
    private final zzai zzb = this;
    private final zzcl<zzbi> zzc;
    private final zzcl<zzbc> zzd;
    private final zzcl<zzay> zze;
    private final zzcl zzf;
    private final zzcl<zzbg> zzg;

    /* synthetic */ zzai(zzaj zzaj, zzbc zzbc, zzaf zzaf) {
        this.zza = zzaj;
        zzcl<zzbi> zza2 = zzcg.zza(new zzbj(zzaj.zzb));
        this.zzc = zza2;
        zzch zza3 = zzci.zza(zzbc);
        this.zzd = zza3;
        zzcf zzcf = new zzcf();
        this.zze = zzcf;
        zzbn zzbn = new zzbn(zzaj.zzb, zza2, zzao.zza, zzaq.zza, zzaj.zzi, zzaj.zzj, zzcf, zzaj.zzc);
        this.zzf = zzbn;
        zzbh zzbh = new zzbh(zza2, zzao.zza, zzbn);
        this.zzg = zzbh;
        zzcf.zza(zzcf, zzcg.zza(new zzaz(zzaj.zzb, zzaj.zzd, zza2, zzaj.zzc, zza3, zzbh)));
    }

    public final zzay zza() {
        return this.zze.zzb();
    }
}
