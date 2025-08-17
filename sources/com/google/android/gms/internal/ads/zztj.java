package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zztj extends zzvp {
    private final boolean zzb;
    private final zzcv zzc;
    private final zzct zzd;
    private zzth zze;
    private zztg zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    public zztj(zztq zztq, boolean z2) {
        super(zztq);
        boolean z3;
        if (z2) {
            zztq.zzu();
            z3 = true;
        } else {
            z3 = false;
        }
        this.zzb = z3;
        this.zzc = new zzcv();
        this.zzd = new zzct();
        zztq.zzL();
        this.zze = zzth.zzq(zztq.zzI());
    }

    private final Object zzJ(Object obj) {
        if (this.zze.zzf == null || !obj.equals(zzth.zzd)) {
            return obj;
        }
        return this.zze.zzf;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private final void zzK(long j2) {
        zztg zztg = this.zzf;
        int zza = this.zze.zza(zztg.zza.zza);
        if (zza != -1) {
            zzth zzth = this.zze;
            zzct zzct = this.zzd;
            zzth.zzd(zza, zzct, false);
            long j3 = zzct.zze;
            if (j3 != -9223372036854775807L && j2 >= j3) {
                j2 = Math.max(0, j3 - 1);
            }
            zztg.zzs(j2);
        }
    }

    public final zzcw zzB() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final zzto zzC(zzto zzto) {
        Object obj = zzto.zza;
        if (this.zze.zzf != null && this.zze.zzf.equals(obj)) {
            obj = zzth.zzd;
        }
        return zzto.zzc(obj);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzD(com.google.android.gms.internal.ads.zzcw r15) {
        /*
            r14 = this;
            boolean r0 = r14.zzh
            r1 = 0
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzth r0 = r14.zze
            com.google.android.gms.internal.ads.zzth r15 = r0.zzp(r15)
            r14.zze = r15
            com.google.android.gms.internal.ads.zztg r15 = r14.zzf
            if (r15 == 0) goto L_0x009b
            long r2 = r15.zzn()
            r14.zzK(r2)
            goto L_0x009b
        L_0x001a:
            boolean r0 = r15.zzo()
            if (r0 == 0) goto L_0x0036
            boolean r0 = r14.zzi
            if (r0 == 0) goto L_0x002b
            com.google.android.gms.internal.ads.zzth r0 = r14.zze
            com.google.android.gms.internal.ads.zzth r15 = r0.zzp(r15)
            goto L_0x0033
        L_0x002b:
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzcv.zza
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzth.zzd
            com.google.android.gms.internal.ads.zzth r15 = com.google.android.gms.internal.ads.zzth.zzr(r15, r0, r2)
        L_0x0033:
            r14.zze = r15
            goto L_0x009b
        L_0x0036:
            com.google.android.gms.internal.ads.zzcv r0 = r14.zzc
            r2 = 0
            r3 = 0
            r15.zze(r2, r0, r3)
            com.google.android.gms.internal.ads.zzcv r0 = r14.zzc
            java.lang.Object r0 = r0.zzc
            com.google.android.gms.internal.ads.zztg r5 = r14.zzf
            if (r5 == 0) goto L_0x0062
            long r6 = r5.zzq()
            com.google.android.gms.internal.ads.zzth r8 = r14.zze
            com.google.android.gms.internal.ads.zzto r5 = r5.zza
            java.lang.Object r5 = r5.zza
            com.google.android.gms.internal.ads.zzct r9 = r14.zzd
            r8.zzn(r5, r9)
            com.google.android.gms.internal.ads.zzth r5 = r14.zze
            com.google.android.gms.internal.ads.zzcv r8 = r14.zzc
            r5.zze(r2, r8, r3)
            int r2 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0062
            r12 = r6
            goto L_0x0063
        L_0x0062:
            r12 = r3
        L_0x0063:
            com.google.android.gms.internal.ads.zzcv r9 = r14.zzc
            com.google.android.gms.internal.ads.zzct r10 = r14.zzd
            r11 = 0
            r8 = r15
            android.util.Pair r2 = r8.zzl(r9, r10, r11, r12)
            java.lang.Object r3 = r2.first
            java.lang.Object r2 = r2.second
            java.lang.Long r2 = (java.lang.Long) r2
            long r4 = r2.longValue()
            boolean r2 = r14.zzi
            if (r2 == 0) goto L_0x0082
            com.google.android.gms.internal.ads.zzth r0 = r14.zze
            com.google.android.gms.internal.ads.zzth r15 = r0.zzp(r15)
            goto L_0x0086
        L_0x0082:
            com.google.android.gms.internal.ads.zzth r15 = com.google.android.gms.internal.ads.zzth.zzr(r15, r0, r3)
        L_0x0086:
            r14.zze = r15
            com.google.android.gms.internal.ads.zztg r15 = r14.zzf
            if (r15 == 0) goto L_0x009b
            r14.zzK(r4)
            com.google.android.gms.internal.ads.zzto r15 = r15.zza
            java.lang.Object r0 = r15.zza
            java.lang.Object r0 = r14.zzJ(r0)
            com.google.android.gms.internal.ads.zzto r1 = r15.zzc(r0)
        L_0x009b:
            r15 = 1
            r14.zzi = r15
            r14.zzh = r15
            com.google.android.gms.internal.ads.zzth r15 = r14.zze
            r14.zzo(r15)
            if (r1 == 0) goto L_0x00af
            com.google.android.gms.internal.ads.zztg r15 = r14.zzf
            r15.getClass()
            r15.zzr(r1)
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztj.zzD(com.google.android.gms.internal.ads.zzcw):void");
    }

    public final void zzE() {
        if (!this.zzb) {
            this.zzg = true;
            zzA((Object) null, this.zza);
        }
    }

    public final void zzF(zztm zztm) {
        ((zztg) zztm).zzt();
        if (zztm == this.zzf) {
            this.zzf = null;
        }
    }

    /* renamed from: zzG */
    public final zztg zzH(zzto zzto, zzxp zzxp, long j2) {
        zztg zztg = new zztg(zzto, zzxp, j2);
        zztg.zzu(this.zza);
        if (this.zzh) {
            zztg.zzr(zzto.zzc(zzJ(zzto.zza)));
        } else {
            this.zzf = zztg;
            if (!this.zzg) {
                this.zzg = true;
                zzA((Object) null, this.zza);
            }
        }
        return zztg;
    }

    public final void zzq() {
        this.zzh = false;
        this.zzg = false;
        super.zzq();
    }

    public final void zzy() {
    }
}
