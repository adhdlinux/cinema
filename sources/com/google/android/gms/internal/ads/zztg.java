package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zztg implements zztm, zztl {
    public final zzto zza;
    private final long zzb;
    private zztq zzc;
    private zztm zzd;
    private zztl zze;
    private long zzf = -9223372036854775807L;
    private final zzxp zzg;

    public zztg(zzto zzto, zzxp zzxp, long j2) {
        this.zza = zzto;
        this.zzg = zzxp;
        this.zzb = j2;
    }

    private final long zzv(long j2) {
        long j3 = this.zzf;
        return j3 != -9223372036854775807L ? j3 : j2;
    }

    public final long zza(long j2, zzlm zzlm) {
        zztm zztm = this.zzd;
        int i2 = zzfj.zza;
        return zztm.zza(j2, zzlm);
    }

    public final long zzb() {
        zztm zztm = this.zzd;
        int i2 = zzfj.zza;
        return zztm.zzb();
    }

    public final long zzc() {
        zztm zztm = this.zzd;
        int i2 = zzfj.zza;
        return zztm.zzc();
    }

    public final long zzd() {
        zztm zztm = this.zzd;
        int i2 = zzfj.zza;
        return zztm.zzd();
    }

    public final long zze(long j2) {
        zztm zztm = this.zzd;
        int i2 = zzfj.zza;
        return zztm.zze(j2);
    }

    public final long zzf(zzxa[] zzxaArr, boolean[] zArr, zzvf[] zzvfArr, boolean[] zArr2, long j2) {
        long j3;
        long j4 = this.zzf;
        if (j4 == -9223372036854775807L || j2 != this.zzb) {
            j3 = j2;
        } else {
            this.zzf = -9223372036854775807L;
            j3 = j4;
        }
        zztm zztm = this.zzd;
        int i2 = zzfj.zza;
        return zztm.zzf(zzxaArr, zArr, zzvfArr, zArr2, j3);
    }

    public final /* bridge */ /* synthetic */ void zzg(zzvh zzvh) {
        zztm zztm = (zztm) zzvh;
        zztl zztl = this.zze;
        int i2 = zzfj.zza;
        zztl.zzg(this);
    }

    public final zzvn zzh() {
        zztm zztm = this.zzd;
        int i2 = zzfj.zza;
        return zztm.zzh();
    }

    public final void zzi(zztm zztm) {
        zztl zztl = this.zze;
        int i2 = zzfj.zza;
        zztl.zzi(this);
    }

    public final void zzj(long j2, boolean z2) {
        zztm zztm = this.zzd;
        int i2 = zzfj.zza;
        zztm.zzj(j2, false);
    }

    public final void zzk() throws IOException {
        try {
            zztm zztm = this.zzd;
            if (zztm != null) {
                zztm.zzk();
                return;
            }
            zztq zztq = this.zzc;
            if (zztq != null) {
                zztq.zzy();
            }
        } catch (IOException e2) {
            throw e2;
        }
    }

    public final void zzl(zztl zztl, long j2) {
        this.zze = zztl;
        zztm zztm = this.zzd;
        if (zztm != null) {
            zztm.zzl(this, zzv(this.zzb));
        }
    }

    public final void zzm(long j2) {
        zztm zztm = this.zzd;
        int i2 = zzfj.zza;
        zztm.zzm(j2);
    }

    public final long zzn() {
        return this.zzf;
    }

    public final boolean zzo(long j2) {
        zztm zztm = this.zzd;
        return zztm != null && zztm.zzo(j2);
    }

    public final boolean zzp() {
        zztm zztm = this.zzd;
        return zztm != null && zztm.zzp();
    }

    public final long zzq() {
        return this.zzb;
    }

    public final void zzr(zzto zzto) {
        long zzv = zzv(this.zzb);
        zztq zztq = this.zzc;
        zztq.getClass();
        zztm zzH = zztq.zzH(zzto, this.zzg, zzv);
        this.zzd = zzH;
        if (this.zze != null) {
            zzH.zzl(this, zzv);
        }
    }

    public final void zzs(long j2) {
        this.zzf = j2;
    }

    public final void zzt() {
        zztm zztm = this.zzd;
        if (zztm != null) {
            zztq zztq = this.zzc;
            zztq.getClass();
            zztq.zzF(zztm);
        }
    }

    public final void zzu(zztq zztq) {
        zzdy.zzf(this.zzc == null);
        this.zzc = zztq;
    }
}
