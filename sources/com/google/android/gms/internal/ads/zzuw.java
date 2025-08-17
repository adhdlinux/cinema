package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Looper;

public final class zzuw extends zzsp implements zzun {
    private final zzbp zza;
    private final zzbi zzb;
    private final zzgd zzc;
    private final zzqu zzd;
    private final int zze;
    private boolean zzf = true;
    private long zzg = -9223372036854775807L;
    private boolean zzh;
    private boolean zzi;
    private zzhg zzj;
    private final zzut zzk;
    private final zzxt zzl;

    /* synthetic */ zzuw(zzbp zzbp, zzgd zzgd, zzut zzut, zzqu zzqu, zzxt zzxt, int i2, zzuv zzuv) {
        zzbi zzbi = zzbp.zzd;
        zzbi.getClass();
        this.zzb = zzbi;
        this.zza = zzbp;
        this.zzc = zzgd;
        this.zzk = zzut;
        this.zzd = zzqu;
        this.zzl = zzxt;
        this.zze = i2;
    }

    private final void zzv() {
        zzbf zzbf;
        zzcw zzcw;
        long j2 = this.zzg;
        boolean z2 = this.zzh;
        boolean z3 = this.zzi;
        zzbp zzbp = this.zza;
        if (z3) {
            zzbf = zzbp.zzf;
        } else {
            zzbf = null;
        }
        zzvj zzvj = r1;
        boolean z4 = z2;
        long j3 = j2;
        zzvj zzvj2 = new zzvj(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j2, j3, 0, 0, z4, false, false, (Object) null, zzbp, zzbf);
        if (this.zzf) {
            zzcw = new zzus(this, zzvj);
        } else {
            zzcw = zzvj;
        }
        zzo(zzcw);
    }

    public final void zzF(zztm zztm) {
        ((zzur) zztm).zzM();
    }

    public final zztm zzH(zzto zzto, zzxp zzxp, long j2) {
        zzge zza2 = this.zzc.zza();
        zzhg zzhg = this.zzj;
        if (zzhg != null) {
            zza2.zzf(zzhg);
        }
        Uri uri = this.zzb.zzb;
        zzut zzut = this.zzk;
        zzb();
        return new zzur(uri, zza2, new zzsr(zzut.zza), this.zzd, zzc(zzto), this.zzl, zze(zzto), this, zzxp, (String) null, this.zze);
    }

    public final zzbp zzI() {
        return this.zza;
    }

    public final void zza(long j2, boolean z2, boolean z3) {
        if (j2 == -9223372036854775807L) {
            j2 = this.zzg;
        }
        if (this.zzf || this.zzg != j2 || this.zzh != z2 || this.zzi != z3) {
            this.zzg = j2;
            this.zzh = z2;
            this.zzi = z3;
            this.zzf = false;
            zzv();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzn(zzhg zzhg) {
        this.zzj = zzhg;
        Looper.myLooper().getClass();
        zzb();
        zzv();
    }

    /* access modifiers changed from: protected */
    public final void zzq() {
    }

    public final void zzy() {
    }
}
