package com.google.android.gms.internal.ads;

public final class zzpp {
    private final zzdr[] zza;
    private final zzqh zzb;
    private final zzdu zzc;

    public zzpp(zzdr... zzdrArr) {
        zzqh zzqh = new zzqh();
        zzdu zzdu = new zzdu();
        zzdr[] zzdrArr2 = new zzdr[2];
        this.zza = zzdrArr2;
        System.arraycopy(zzdrArr, 0, zzdrArr2, 0, 0);
        this.zzb = zzqh;
        this.zzc = zzdu;
        zzdrArr2[0] = zzqh;
        zzdrArr2[1] = zzdu;
    }

    public final long zza(long j2) {
        return this.zzc.zzi(j2);
    }

    public final long zzb() {
        return this.zzb.zzo();
    }

    public final zzch zzc(zzch zzch) {
        this.zzc.zzk(zzch.zzc);
        this.zzc.zzj(zzch.zzd);
        return zzch;
    }

    public final boolean zzd(boolean z2) {
        this.zzb.zzp(z2);
        return z2;
    }

    public final zzdr[] zze() {
        return this.zza;
    }
}
