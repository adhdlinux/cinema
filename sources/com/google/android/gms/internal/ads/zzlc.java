package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.List;

final class zzlc {
    private static final zzto zzt = new zzto(new Object());
    public final zzcw zza;
    public final zzto zzb;
    public final long zzc;
    public final long zzd;
    public final int zze;
    public final zzih zzf;
    public final boolean zzg;
    public final zzvn zzh;
    public final zzxh zzi;
    public final List zzj;
    public final zzto zzk;
    public final boolean zzl;
    public final int zzm;
    public final zzch zzn;
    public final boolean zzo;
    public volatile long zzp;
    public volatile long zzq;
    public volatile long zzr;
    public volatile long zzs;

    public zzlc(zzcw zzcw, zzto zzto, long j2, long j3, int i2, zzih zzih, boolean z2, zzvn zzvn, zzxh zzxh, List list, zzto zzto2, boolean z3, int i3, zzch zzch, long j4, long j5, long j6, long j7, boolean z4) {
        this.zza = zzcw;
        this.zzb = zzto;
        this.zzc = j2;
        this.zzd = j3;
        this.zze = i2;
        this.zzf = zzih;
        this.zzg = z2;
        this.zzh = zzvn;
        this.zzi = zzxh;
        this.zzj = list;
        this.zzk = zzto2;
        this.zzl = z3;
        this.zzm = i3;
        this.zzn = zzch;
        this.zzp = j4;
        this.zzq = j5;
        this.zzr = j6;
        this.zzs = j7;
        this.zzo = z4;
    }

    public static zzlc zzi(zzxh zzxh) {
        zzcw zzcw = zzcw.zza;
        zzto zzto = zzt;
        return new zzlc(zzcw, zzto, -9223372036854775807L, 0, 1, (zzih) null, false, zzvn.zza, zzxh, zzfsc.zzl(), zzto, false, 0, zzch.zza, 0, 0, 0, 0, false);
    }

    public static zzto zzj() {
        return zzt;
    }

    public final long zza() {
        long j2;
        long j3;
        if (!zzk()) {
            return this.zzr;
        }
        do {
            j2 = this.zzs;
            j3 = this.zzr;
        } while (j2 != this.zzs);
        return zzfj.zzo(zzfj.zzq(j3) + ((long) (((float) (SystemClock.elapsedRealtime() - j2)) * this.zzn.zzc)));
    }

    public final zzlc zzb() {
        return new zzlc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, zza(), SystemClock.elapsedRealtime(), this.zzo);
    }

    public final zzlc zzc(zzto zzto) {
        zzcw zzcw = this.zza;
        return new zzlc(zzcw, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, zzto, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, this.zzo);
    }

    public final zzlc zzd(zzto zzto, long j2, long j3, long j4, long j5, zzvn zzvn, zzxh zzxh, List list) {
        long j6 = j2;
        zzvn zzvn2 = zzvn;
        zzxh zzxh2 = zzxh;
        List list2 = list;
        zzcw zzcw = this.zza;
        return new zzlc(zzcw, zzto, j3, j4, this.zze, this.zzf, this.zzg, zzvn2, zzxh2, list2, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, j5, j6, SystemClock.elapsedRealtime(), this.zzo);
    }

    public final zzlc zze(boolean z2, int i2) {
        zzcw zzcw = this.zza;
        return new zzlc(zzcw, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, z2, i2, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, this.zzo);
    }

    public final zzlc zzf(zzih zzih) {
        zzcw zzcw = this.zza;
        return new zzlc(zzcw, this.zzb, this.zzc, this.zzd, this.zze, zzih, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, this.zzo);
    }

    public final zzlc zzg(int i2) {
        zzcw zzcw = this.zza;
        return new zzlc(zzcw, this.zzb, this.zzc, this.zzd, i2, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, this.zzo);
    }

    public final zzlc zzh(zzcw zzcw) {
        return new zzlc(zzcw, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, this.zzo);
    }

    public final boolean zzk() {
        return this.zze == 3 && this.zzl && this.zzm == 0;
    }
}
