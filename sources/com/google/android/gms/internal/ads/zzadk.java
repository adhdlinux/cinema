package com.google.android.gms.internal.ads;

final class zzadk implements zzabv {
    final /* synthetic */ zzabv zza;
    final /* synthetic */ zzadl zzb;

    zzadk(zzadl zzadl, zzabv zzabv) {
        this.zzb = zzadl;
        this.zza = zzabv;
    }

    public final long zze() {
        return this.zza.zze();
    }

    public final zzabt zzg(long j2) {
        zzabt zzg = this.zza.zzg(j2);
        zzabw zzabw = zzg.zza;
        zzabw zzabw2 = new zzabw(zzabw.zzb, zzabw.zzc + this.zzb.zzb);
        zzabw zzabw3 = zzg.zzb;
        return new zzabt(zzabw2, new zzabw(zzabw3.zzb, zzabw3.zzc + this.zzb.zzb));
    }

    public final boolean zzh() {
        return this.zza.zzh();
    }
}
