package com.google.android.gms.internal.ads;

import com.facebook.common.time.Clock;
import java.io.IOException;

public abstract class zzhy implements zzli, zzlk {
    private final Object zza = new Object();
    private final int zzb;
    private final zzkj zzc;
    private zzll zzd;
    private int zze;
    private zzoc zzf;
    private int zzg;
    private zzvf zzh;
    private zzam[] zzi;
    private long zzj;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private zzlj zzn;

    public zzhy(int i2) {
        this.zzb = i2;
        this.zzc = new zzkj();
        this.zzk = Long.MIN_VALUE;
    }

    private final void zzS(long j2, boolean z2) throws zzih {
        this.zzl = false;
        this.zzk = j2;
        zzv(j2, z2);
    }

    public final void zzA() {
        zzdy.zzf(this.zzg == 0);
    }

    public final void zzB(zzam[] zzamArr, zzvf zzvf, long j2, long j3) throws zzih {
        zzdy.zzf(!this.zzl);
        this.zzh = zzvf;
        if (this.zzk == Long.MIN_VALUE) {
            this.zzk = j2;
        }
        this.zzi = zzamArr;
        this.zzj = j3;
        zzz(zzamArr, j2, j3);
    }

    public final void zzC() {
        boolean z2;
        if (this.zzg == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzf(z2);
        zzkj zzkj = this.zzc;
        zzkj.zzb = null;
        zzkj.zza = null;
        zzw();
    }

    public final void zzD(long j2) throws zzih {
        zzS(j2, false);
    }

    public final void zzE() {
        this.zzl = true;
    }

    public final void zzF(zzlj zzlj) {
        synchronized (this.zza) {
            this.zzn = zzlj;
        }
    }

    public /* synthetic */ void zzG(float f2, float f3) {
    }

    public final void zzH() throws zzih {
        boolean z2 = true;
        if (this.zzg != 1) {
            z2 = false;
        }
        zzdy.zzf(z2);
        this.zzg = 2;
        zzx();
    }

    public final void zzI() {
        boolean z2;
        if (this.zzg == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzf(z2);
        this.zzg = 1;
        zzy();
    }

    public final boolean zzJ() {
        return this.zzk == Long.MIN_VALUE;
    }

    public final boolean zzK() {
        return this.zzl;
    }

    /* access modifiers changed from: protected */
    public final boolean zzL() {
        if (zzJ()) {
            return this.zzl;
        }
        zzvf zzvf = this.zzh;
        zzvf.getClass();
        return zzvf.zze();
    }

    /* access modifiers changed from: protected */
    public final zzam[] zzM() {
        zzam[] zzamArr = this.zzi;
        zzamArr.getClass();
        return zzamArr;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzbc() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final int zzbd(zzkj zzkj, zzhp zzhp, int i2) {
        zzvf zzvf = this.zzh;
        zzvf.getClass();
        int zza2 = zzvf.zza(zzkj, zzhp, i2);
        if (zza2 == -4) {
            if (zzhp.zzg()) {
                this.zzk = Long.MIN_VALUE;
                if (this.zzl) {
                    return -4;
                }
                return -3;
            }
            long j2 = zzhp.zzd + this.zzj;
            zzhp.zzd = j2;
            this.zzk = Math.max(this.zzk, j2);
        } else if (zza2 == -5) {
            zzam zzam = zzkj.zza;
            zzam.getClass();
            long j3 = zzam.zzq;
            if (j3 != Clock.MAX_TIME) {
                zzak zzb2 = zzam.zzb();
                zzb2.zzW(j3 + this.zzj);
                zzkj.zza = zzb2.zzY();
                return -5;
            }
        }
        return zza2;
    }

    /* access modifiers changed from: protected */
    public final zzih zzbe(Throwable th, zzam zzam, boolean z2, int i2) {
        int i3;
        if (zzam != null && !this.zzm) {
            this.zzm = true;
            try {
                int zzR = zzR(zzam) & 7;
                this.zzm = false;
                i3 = zzR;
            } catch (zzih unused) {
                this.zzm = false;
            } catch (Throwable th2) {
                this.zzm = false;
                throw th2;
            }
            return zzih.zzb(th, zzN(), this.zze, zzam, i3, z2, i2);
        }
        i3 = 4;
        return zzih.zzb(th, zzN(), this.zze, zzam, i3, z2, i2);
    }

    /* access modifiers changed from: protected */
    public final int zzd(long j2) {
        zzvf zzvf = this.zzh;
        zzvf.getClass();
        return zzvf.zzb(j2 - this.zzj);
    }

    public int zze() throws zzih {
        return 0;
    }

    public final long zzf() {
        return this.zzk;
    }

    /* access modifiers changed from: protected */
    public final zzkj zzh() {
        zzkj zzkj = this.zzc;
        zzkj.zzb = null;
        zzkj.zza = null;
        return zzkj;
    }

    public zzkl zzi() {
        return null;
    }

    public final zzlk zzj() {
        return this;
    }

    /* access modifiers changed from: protected */
    public final zzll zzk() {
        zzll zzll = this.zzd;
        zzll.getClass();
        return zzll;
    }

    /* access modifiers changed from: protected */
    public final zzoc zzl() {
        zzoc zzoc = this.zzf;
        zzoc.getClass();
        return zzoc;
    }

    public final zzvf zzm() {
        return this.zzh;
    }

    public final void zzn() {
        synchronized (this.zza) {
            this.zzn = null;
        }
    }

    public final void zzo() {
        boolean z2 = true;
        if (this.zzg != 1) {
            z2 = false;
        }
        zzdy.zzf(z2);
        zzkj zzkj = this.zzc;
        zzkj.zzb = null;
        zzkj.zza = null;
        this.zzg = 0;
        this.zzh = null;
        this.zzi = null;
        this.zzl = false;
        zzt();
    }

    public final void zzp(zzll zzll, zzam[] zzamArr, zzvf zzvf, long j2, boolean z2, boolean z3, long j3, long j4) throws zzih {
        boolean z4;
        boolean z5 = z2;
        if (this.zzg == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        zzdy.zzf(z4);
        this.zzd = zzll;
        this.zzg = 1;
        zzu(z2, z3);
        zzB(zzamArr, zzvf, j3, j4);
        long j5 = j2;
        zzS(j2, z2);
    }

    public void zzq(int i2, Object obj) throws zzih {
    }

    public final void zzr(int i2, zzoc zzoc) {
        this.zze = i2;
        this.zzf = zzoc;
    }

    public final void zzs() throws IOException {
        zzvf zzvf = this.zzh;
        zzvf.getClass();
        zzvf.zzd();
    }

    /* access modifiers changed from: protected */
    public void zzt() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzu(boolean z2, boolean z3) throws zzih {
    }

    /* access modifiers changed from: protected */
    public void zzv(long j2, boolean z2) throws zzih {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzw() {
    }

    /* access modifiers changed from: protected */
    public void zzx() throws zzih {
    }

    /* access modifiers changed from: protected */
    public void zzy() {
    }

    /* access modifiers changed from: protected */
    public void zzz(zzam[] zzamArr, long j2, long j3) throws zzih {
        throw null;
    }
}
