package com.google.android.gms.internal.ads;

final class zzacj implements zzabv {
    final /* synthetic */ zzacm zza;
    private final long zzb;

    public zzacj(zzacm zzacm, long j2) {
        this.zza = zzacm;
        this.zzb = j2;
    }

    public final long zze() {
        return this.zzb;
    }

    public final zzabt zzg(long j2) {
        zzabt zza2 = this.zza.zzg[0].zza(j2);
        int i2 = 1;
        while (true) {
            zzacm zzacm = this.zza;
            if (i2 >= zzacm.zzg.length) {
                return zza2;
            }
            zzabt zza3 = zzacm.zzg[i2].zza(j2);
            if (zza3.zza.zzc < zza2.zza.zzc) {
                zza2 = zza3;
            }
            i2++;
        }
    }

    public final boolean zzh() {
        return true;
    }
}
