package com.google.android.gms.internal.ads;

final class zzahi implements zzahp {
    private final zzaho zza;
    /* access modifiers changed from: private */
    public final long zzb;
    /* access modifiers changed from: private */
    public final long zzc;
    /* access modifiers changed from: private */
    public final zzahu zzd;
    private int zze;
    /* access modifiers changed from: private */
    public long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzahi(zzahu zzahu, long j2, long j3, long j4, long j5, boolean z2) {
        boolean z3;
        if (j2 < 0 || j3 <= j2) {
            z3 = false;
        } else {
            z3 = true;
        }
        zzdy.zzd(z3);
        this.zzd = zzahu;
        this.zzb = j2;
        this.zzc = j3;
        if (j4 == j3 - j2 || z2) {
            this.zzf = j5;
            this.zze = 4;
        } else {
            this.zze = 0;
        }
        this.zza = new zzaho();
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ae A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzd(com.google.android.gms.internal.ads.zzaax r22) throws java.io.IOException {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            int r2 = r0.zze
            r3 = 1
            r5 = 0
            r6 = -1
            if (r2 == 0) goto L_0x00f0
            if (r2 == r3) goto L_0x0103
            r3 = 2
            r10 = 3
            if (r2 == r3) goto L_0x0018
            if (r2 == r10) goto L_0x0015
            return r6
        L_0x0015:
            r8 = r6
            goto L_0x00b1
        L_0x0018:
            long r2 = r0.zzi
            long r11 = r0.zzj
            int r13 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r13 != 0) goto L_0x0024
        L_0x0020:
            r8 = r6
            r11 = r8
            goto L_0x00aa
        L_0x0024:
            long r2 = r22.zzf()
            com.google.android.gms.internal.ads.zzaho r13 = r0.zza
            boolean r11 = r13.zzc(r1, r11)
            if (r11 != 0) goto L_0x0041
            long r11 = r0.zzi
            int r13 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x0039
        L_0x0036:
            r8 = r6
            goto L_0x00aa
        L_0x0039:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "No ogg page can be found."
            r1.<init>(r2)
            throw r1
        L_0x0041:
            com.google.android.gms.internal.ads.zzaho r11 = r0.zza
            r11.zzb(r1, r5)
            r22.zzj()
            long r11 = r0.zzh
            com.google.android.gms.internal.ads.zzaho r13 = r0.zza
            long r14 = r13.zzb
            long r11 = r11 - r14
            int r8 = r13.zzd
            int r9 = r13.zze
            int r8 = r8 + r9
            r16 = 0
            int r9 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r9 < 0) goto L_0x0063
            r16 = 72000(0x11940, double:3.55727E-319)
            int r13 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r13 >= 0) goto L_0x0063
            goto L_0x0020
        L_0x0063:
            if (r9 >= 0) goto L_0x006a
            r0.zzj = r2
            r0.zzl = r14
            goto L_0x0074
        L_0x006a:
            long r2 = r22.zzf()
            long r4 = (long) r8
            long r2 = r2 + r4
            r0.zzi = r2
            r0.zzk = r14
        L_0x0074:
            long r2 = r0.zzj
            long r4 = r0.zzi
            long r14 = r2 - r4
            r17 = 100000(0x186a0, double:4.94066E-319)
            int r19 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r19 >= 0) goto L_0x0085
            r0.zzj = r4
            r11 = r4
            goto L_0x0036
        L_0x0085:
            long r6 = (long) r8
            if (r9 > 0) goto L_0x008b
            r8 = 2
            goto L_0x008d
        L_0x008b:
            r8 = 1
        L_0x008d:
            long r19 = r22.zzf()
            long r6 = r6 * r8
            long r19 = r19 - r6
            long r11 = r11 * r14
            long r6 = r0.zzl
            long r8 = r0.zzk
            long r6 = r6 - r8
            long r11 = r11 / r6
            long r6 = r19 + r11
            r8 = -1
            long r2 = r2 + r8
            long r2 = java.lang.Math.min(r6, r2)
            long r11 = java.lang.Math.max(r4, r2)
        L_0x00aa:
            int r2 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x00af
            return r11
        L_0x00af:
            r0.zze = r10
        L_0x00b1:
            com.google.android.gms.internal.ads.zzaho r2 = r0.zza
            r2.zzc(r1, r8)
            com.google.android.gms.internal.ads.zzaho r2 = r0.zza
            r3 = 0
            r2.zzb(r1, r3)
            com.google.android.gms.internal.ads.zzaho r2 = r0.zza
            long r3 = r2.zzb
            long r5 = r0.zzh
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00d3
            r22.zzj()
            r1 = 4
            r0.zze = r1
            long r1 = r0.zzk
            r4 = 2
            long r1 = r1 + r4
            long r1 = -r1
            return r1
        L_0x00d3:
            r4 = 2
            int r3 = r2.zzd
            int r2 = r2.zze
            int r3 = r3 + r2
            r2 = r1
            com.google.android.gms.internal.ads.zzaam r2 = (com.google.android.gms.internal.ads.zzaam) r2
            r6 = 0
            r2.zzo(r3, r6)
            long r2 = r22.zzf()
            r0.zzi = r2
            com.google.android.gms.internal.ads.zzaho r2 = r0.zza
            long r2 = r2.zzb
            r0.zzk = r2
            r8 = -1
            goto L_0x00b1
        L_0x00f0:
            long r4 = r22.zzf()
            r0.zzg = r4
            r0.zze = r3
            long r6 = r0.zzc
            r8 = -65307(0xffffffffffff00e5, double:NaN)
            long r6 = r6 + r8
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0103
            return r6
        L_0x0103:
            com.google.android.gms.internal.ads.zzaho r2 = r0.zza
            r2.zza()
            com.google.android.gms.internal.ads.zzaho r2 = r0.zza
            r4 = -1
            boolean r2 = r2.zzc(r1, r4)
            if (r2 == 0) goto L_0x0166
            com.google.android.gms.internal.ads.zzaho r2 = r0.zza
            r4 = 0
            r2.zzb(r1, r4)
            com.google.android.gms.internal.ads.zzaho r2 = r0.zza
            int r5 = r2.zzd
            int r2 = r2.zze
            int r5 = r5 + r2
            r2 = r1
            com.google.android.gms.internal.ads.zzaam r2 = (com.google.android.gms.internal.ads.zzaam) r2
            r2.zzo(r5, r4)
            com.google.android.gms.internal.ads.zzaho r2 = r0.zza
            long r4 = r2.zzb
        L_0x0129:
            com.google.android.gms.internal.ads.zzaho r2 = r0.zza
            int r6 = r2.zza
            r7 = 4
            r6 = r6 & r7
            if (r6 == r7) goto L_0x015e
            r6 = -1
            boolean r2 = r2.zzc(r1, r6)
            if (r2 == 0) goto L_0x015e
            long r8 = r22.zzf()
            long r10 = r0.zzc
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 >= 0) goto L_0x015e
            com.google.android.gms.internal.ads.zzaho r2 = r0.zza
            boolean r2 = r2.zzb(r1, r3)
            if (r2 == 0) goto L_0x015e
            com.google.android.gms.internal.ads.zzaho r2 = r0.zza
            int r8 = r2.zzd
            int r2 = r2.zze
            int r8 = r8 + r2
            boolean r2 = com.google.android.gms.internal.ads.zzaba.zze(r1, r8)
            if (r2 != 0) goto L_0x0159
            goto L_0x015e
        L_0x0159:
            com.google.android.gms.internal.ads.zzaho r2 = r0.zza
            long r4 = r2.zzb
            goto L_0x0129
        L_0x015e:
            r0.zzf = r4
            r1 = 4
            r0.zze = r1
            long r1 = r0.zzg
            return r1
        L_0x0166:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahi.zzd(com.google.android.gms.internal.ads.zzaax):long");
    }

    public final /* bridge */ /* synthetic */ zzabv zze() {
        if (this.zzf != 0) {
            return new zzahh(this, (zzahg) null);
        }
        return null;
    }

    public final void zzg(long j2) {
        this.zzh = Math.max(0, Math.min(j2, this.zzf - 1));
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0;
        this.zzl = this.zzf;
    }
}
