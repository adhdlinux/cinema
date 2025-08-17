package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzuc implements zztm, zztl {
    /* access modifiers changed from: private */
    public final zztm zza;
    private final long zzb;
    private zztl zzc;

    public zzuc(zztm zztm, long j2) {
        this.zza = zztm;
        this.zzb = j2;
    }

    public final long zza(long j2, zzlm zzlm) {
        return this.zza.zza(j2 - this.zzb, zzlm) + this.zzb;
    }

    public final long zzb() {
        long zzb2 = this.zza.zzb();
        if (zzb2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzb2 + this.zzb;
    }

    public final long zzc() {
        long zzc2 = this.zza.zzc();
        if (zzc2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzc2 + this.zzb;
    }

    public final long zzd() {
        long zzd = this.zza.zzd();
        if (zzd == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return zzd + this.zzb;
    }

    public final long zze(long j2) {
        return this.zza.zze(j2 - this.zzb) + this.zzb;
    }

    public final long zzf(zzxa[] zzxaArr, boolean[] zArr, zzvf[] zzvfArr, boolean[] zArr2, long j2) {
        zzvf[] zzvfArr2 = zzvfArr;
        zzvf[] zzvfArr3 = new zzvf[zzvfArr2.length];
        int i2 = 0;
        while (true) {
            zzvf zzvf = null;
            if (i2 >= zzvfArr2.length) {
                break;
            }
            zzud zzud = (zzud) zzvfArr2[i2];
            if (zzud != null) {
                zzvf = zzud.zzc();
            }
            zzvfArr3[i2] = zzvf;
            i2++;
        }
        long zzf = this.zza.zzf(zzxaArr, zArr, zzvfArr3, zArr2, j2 - this.zzb);
        for (int i3 = 0; i3 < zzvfArr2.length; i3++) {
            zzvf zzvf2 = zzvfArr3[i3];
            if (zzvf2 == null) {
                zzvfArr2[i3] = null;
            } else {
                zzvf zzvf3 = zzvfArr2[i3];
                if (zzvf3 == null || ((zzud) zzvf3).zzc() != zzvf2) {
                    zzvfArr2[i3] = new zzud(zzvf2, this.zzb);
                }
            }
        }
        return zzf + this.zzb;
    }

    public final /* bridge */ /* synthetic */ void zzg(zzvh zzvh) {
        zztm zztm = (zztm) zzvh;
        zztl zztl = this.zzc;
        zztl.getClass();
        zztl.zzg(this);
    }

    public final zzvn zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zztm zztm) {
        zztl zztl = this.zzc;
        zztl.getClass();
        zztl.zzi(this);
    }

    public final void zzj(long j2, boolean z2) {
        this.zza.zzj(j2 - this.zzb, false);
    }

    public final void zzk() throws IOException {
        this.zza.zzk();
    }

    public final void zzl(zztl zztl, long j2) {
        this.zzc = zztl;
        this.zza.zzl(this, j2 - this.zzb);
    }

    public final void zzm(long j2) {
        this.zza.zzm(j2 - this.zzb);
    }

    public final boolean zzo(long j2) {
        return this.zza.zzo(j2 - this.zzb);
    }

    public final boolean zzp() {
        return this.zza.zzp();
    }
}
