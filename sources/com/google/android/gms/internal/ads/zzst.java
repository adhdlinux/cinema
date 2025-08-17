package com.google.android.gms.internal.ads;

import com.facebook.common.time.Clock;
import java.io.IOException;

public final class zzst implements zztm, zztl {
    public final zztm zza;
    long zzb;
    private zztl zzc;
    private zzss[] zzd = new zzss[0];
    private long zze = 0;

    public zzst(zztm zztm, boolean z2, long j2, long j3) {
        this.zza = zztm;
        this.zzb = j3;
    }

    public final long zza(long j2, zzlm zzlm) {
        long j3;
        if (j2 == 0) {
            return 0;
        }
        long max = Math.max(0, Math.min(zzlm.zzf, j2));
        long j4 = zzlm.zzg;
        long j5 = this.zzb;
        if (j5 == Long.MIN_VALUE) {
            j3 = Clock.MAX_TIME;
        } else {
            j3 = j5 - j2;
        }
        long max2 = Math.max(0, Math.min(j4, j3));
        if (!(max == zzlm.zzf && max2 == zzlm.zzg)) {
            zzlm = new zzlm(max, max2);
        }
        return this.zza.zza(j2, zzlm);
    }

    public final long zzb() {
        long zzb2 = this.zza.zzb();
        if (zzb2 != Long.MIN_VALUE) {
            long j2 = this.zzb;
            if (j2 == Long.MIN_VALUE || zzb2 < j2) {
                return zzb2;
            }
        }
        return Long.MIN_VALUE;
    }

    public final long zzc() {
        long zzc2 = this.zza.zzc();
        if (zzc2 != Long.MIN_VALUE) {
            long j2 = this.zzb;
            if (j2 == Long.MIN_VALUE || zzc2 < j2) {
                return zzc2;
            }
        }
        return Long.MIN_VALUE;
    }

    public final long zzd() {
        boolean z2;
        if (zzq()) {
            long j2 = this.zze;
            this.zze = -9223372036854775807L;
            long zzd2 = zzd();
            if (zzd2 != -9223372036854775807L) {
                return zzd2;
            }
            return j2;
        }
        long zzd3 = this.zza.zzd();
        if (zzd3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z3 = false;
        if (zzd3 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzf(z2);
        long j3 = this.zzb;
        if (j3 == Long.MIN_VALUE || zzd3 <= j3) {
            z3 = true;
        }
        zzdy.zzf(z3);
        return zzd3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r0 > r8) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zze(long r8) {
        /*
            r7 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7.zze = r0
            com.google.android.gms.internal.ads.zzss[] r0 = r7.zzd
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x000c:
            if (r3 >= r1) goto L_0x0018
            r4 = r0[r3]
            if (r4 == 0) goto L_0x0015
            r4.zzc()
        L_0x0015:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0018:
            com.google.android.gms.internal.ads.zztm r0 = r7.zza
            long r0 = r0.zze(r8)
            r3 = 1
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x0035
            r8 = 0
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 < 0) goto L_0x0036
            long r8 = r7.zzb
            r4 = -9223372036854775808
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0035
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 > 0) goto L_0x0036
        L_0x0035:
            r2 = 1
        L_0x0036:
            com.google.android.gms.internal.ads.zzdy.zzf(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzst.zze(long):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0059, code lost:
        if (r4 > r7) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzf(com.google.android.gms.internal.ads.zzxa[] r15, boolean[] r16, com.google.android.gms.internal.ads.zzvf[] r17, boolean[] r18, long r19) {
        /*
            r14 = this;
            r0 = r14
            r1 = r17
            int r2 = r1.length
            com.google.android.gms.internal.ads.zzss[] r3 = new com.google.android.gms.internal.ads.zzss[r2]
            r0.zzd = r3
            com.google.android.gms.internal.ads.zzvf[] r2 = new com.google.android.gms.internal.ads.zzvf[r2]
            r3 = 0
            r4 = 0
        L_0x000c:
            int r5 = r1.length
            r11 = 0
            if (r4 >= r5) goto L_0x0021
            com.google.android.gms.internal.ads.zzss[] r5 = r0.zzd
            r6 = r1[r4]
            com.google.android.gms.internal.ads.zzss r6 = (com.google.android.gms.internal.ads.zzss) r6
            r5[r4] = r6
            if (r6 == 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzvf r11 = r6.zza
        L_0x001c:
            r2[r4] = r11
            int r4 = r4 + 1
            goto L_0x000c
        L_0x0021:
            com.google.android.gms.internal.ads.zztm r4 = r0.zza
            r5 = r15
            r6 = r16
            r7 = r2
            r8 = r18
            r9 = r19
            long r4 = r4.zzf(r5, r6, r7, r8, r9)
            boolean r6 = r14.zzq()
            r7 = 0
            if (r6 == 0) goto L_0x003d
            int r6 = (r19 > r7 ? 1 : (r19 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x003d
            r9 = r7
            goto L_0x003f
        L_0x003d:
            r9 = r19
        L_0x003f:
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.zze = r12
            r6 = 1
            int r12 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r12 == 0) goto L_0x005d
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 < 0) goto L_0x005c
            long r7 = r0.zzb
            r9 = -9223372036854775808
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 == 0) goto L_0x005d
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x005c
            goto L_0x005d
        L_0x005c:
            r6 = 0
        L_0x005d:
            com.google.android.gms.internal.ads.zzdy.zzf(r6)
        L_0x0060:
            int r6 = r1.length
            if (r3 >= r6) goto L_0x0086
            r6 = r2[r3]
            if (r6 != 0) goto L_0x006c
            com.google.android.gms.internal.ads.zzss[] r6 = r0.zzd
            r6[r3] = r11
            goto L_0x007d
        L_0x006c:
            com.google.android.gms.internal.ads.zzss[] r7 = r0.zzd
            r8 = r7[r3]
            if (r8 == 0) goto L_0x0076
            com.google.android.gms.internal.ads.zzvf r8 = r8.zza
            if (r8 == r6) goto L_0x007d
        L_0x0076:
            com.google.android.gms.internal.ads.zzss r8 = new com.google.android.gms.internal.ads.zzss
            r8.<init>(r14, r6)
            r7[r3] = r8
        L_0x007d:
            com.google.android.gms.internal.ads.zzss[] r6 = r0.zzd
            r6 = r6[r3]
            r1[r3] = r6
            int r3 = r3 + 1
            goto L_0x0060
        L_0x0086:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzst.zzf(com.google.android.gms.internal.ads.zzxa[], boolean[], com.google.android.gms.internal.ads.zzvf[], boolean[], long):long");
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
        this.zza.zzj(j2, false);
    }

    public final void zzk() throws IOException {
        this.zza.zzk();
    }

    public final void zzl(zztl zztl, long j2) {
        this.zzc = zztl;
        this.zza.zzl(this, j2);
    }

    public final void zzm(long j2) {
        this.zza.zzm(j2);
    }

    public final void zzn(long j2, long j3) {
        this.zzb = j3;
    }

    public final boolean zzo(long j2) {
        return this.zza.zzo(j2);
    }

    public final boolean zzp() {
        return this.zza.zzp();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzq() {
        return this.zze != -9223372036854775807L;
    }
}
