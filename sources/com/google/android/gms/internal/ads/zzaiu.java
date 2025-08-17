package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzaiu implements zzaij {
    private final zzajk zza;
    private String zzb;
    private zzabz zzc;
    private zzait zzd;
    private boolean zze;
    private final boolean[] zzf = new boolean[3];
    private final zzaiy zzg = new zzaiy(32, 128);
    private final zzaiy zzh = new zzaiy(33, 128);
    private final zzaiy zzi = new zzaiy(34, 128);
    private final zzaiy zzj = new zzaiy(39, 128);
    private final zzaiy zzk = new zzaiy(40, 128);
    private long zzl;
    private long zzm = -9223372036854775807L;
    private final zzfa zzn = new zzfa();

    public zzaiu(zzajk zzajk) {
        this.zza = zzajk;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(byte[] bArr, int i2, int i3) {
        this.zzd.zzb(bArr, i2, i3);
        if (!this.zze) {
            this.zzg.zza(bArr, i2, i3);
            this.zzh.zza(bArr, i2, i3);
            this.zzi.zza(bArr, i2, i3);
        }
        this.zzj.zza(bArr, i2, i3);
        this.zzk.zza(bArr, i2, i3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0181  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzfa r32) {
        /*
            r31 = this;
            r0 = r31
            com.google.android.gms.internal.ads.zzabz r1 = r0.zzc
            com.google.android.gms.internal.ads.zzdy.zzb(r1)
            int r1 = com.google.android.gms.internal.ads.zzfj.zza
        L_0x0009:
            int r1 = r32.zza()
            if (r1 <= 0) goto L_0x01a7
            int r1 = r32.zzc()
            int r2 = r32.zzd()
            byte[] r3 = r32.zzH()
            long r4 = r0.zzl
            int r6 = r32.zza()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.zzl = r4
            com.google.android.gms.internal.ads.zzabz r4 = r0.zzc
            int r5 = r32.zza()
            r6 = r32
            r4.zzq(r6, r5)
        L_0x0030:
            if (r1 >= r2) goto L_0x0009
            boolean[] r4 = r0.zzf
            int r4 = com.google.android.gms.internal.ads.zzfu.zza(r3, r1, r2, r4)
            if (r4 == r2) goto L_0x01a4
            int r5 = r4 + 3
            byte r7 = r3[r5]
            r7 = r7 & 126(0x7e, float:1.77E-43)
            int r8 = r4 - r1
            if (r8 <= 0) goto L_0x0047
            r0.zzf(r3, r1, r4)
        L_0x0047:
            int r12 = r2 - r4
            long r9 = r0.zzl
            long r13 = (long) r12
            long r10 = r9 - r13
            if (r8 >= 0) goto L_0x0052
            int r4 = -r8
            goto L_0x0053
        L_0x0052:
            r4 = 0
        L_0x0053:
            long r8 = r0.zzm
            com.google.android.gms.internal.ads.zzait r13 = r0.zzd
            boolean r14 = r0.zze
            r13.zza(r10, r12, r14)
            boolean r13 = r0.zze
            if (r13 != 0) goto L_0x0110
            com.google.android.gms.internal.ads.zzaiy r13 = r0.zzg
            r13.zzd(r4)
            com.google.android.gms.internal.ads.zzaiy r13 = r0.zzh
            r13.zzd(r4)
            com.google.android.gms.internal.ads.zzaiy r13 = r0.zzi
            r13.zzd(r4)
            com.google.android.gms.internal.ads.zzaiy r13 = r0.zzg
            boolean r16 = r13.zze()
            if (r16 == 0) goto L_0x0110
            com.google.android.gms.internal.ads.zzaiy r14 = r0.zzh
            boolean r17 = r14.zze()
            if (r17 == 0) goto L_0x0110
            com.google.android.gms.internal.ads.zzaiy r15 = r0.zzi
            boolean r18 = r15.zze()
            if (r18 == 0) goto L_0x0110
            com.google.android.gms.internal.ads.zzabz r1 = r0.zzc
            r19 = r5
            java.lang.String r5 = r0.zzb
            int r6 = r13.zzb
            r20 = r2
            int r2 = r14.zzb
            int r2 = r2 + r6
            r21 = r3
            int r3 = r15.zzb
            int r2 = r2 + r3
            byte[] r2 = new byte[r2]
            byte[] r3 = r13.zza
            r22 = r12
            r12 = 0
            java.lang.System.arraycopy(r3, r12, r2, r12, r6)
            byte[] r3 = r14.zza
            int r6 = r13.zzb
            r23 = r10
            int r10 = r14.zzb
            java.lang.System.arraycopy(r3, r12, r2, r6, r10)
            byte[] r3 = r15.zza
            int r6 = r13.zzb
            int r10 = r14.zzb
            int r6 = r6 + r10
            int r10 = r15.zzb
            java.lang.System.arraycopy(r3, r12, r2, r6, r10)
            byte[] r3 = r14.zza
            int r6 = r14.zzb
            r10 = 5
            com.google.android.gms.internal.ads.zzfr r3 = com.google.android.gms.internal.ads.zzfu.zzc(r3, r10, r6)
            int r6 = r3.zza
            boolean r10 = r3.zzb
            int r11 = r3.zzc
            int r12 = r3.zzd
            int[] r13 = r3.zze
            int r14 = r3.zzf
            r25 = r6
            r26 = r10
            r27 = r11
            r28 = r12
            r29 = r13
            r30 = r14
            java.lang.String r6 = com.google.android.gms.internal.ads.zzea.zzb(r25, r26, r27, r28, r29, r30)
            com.google.android.gms.internal.ads.zzak r10 = new com.google.android.gms.internal.ads.zzak
            r10.<init>()
            r10.zzH(r5)
            java.lang.String r5 = "video/hevc"
            r10.zzS(r5)
            r10.zzx(r6)
            int r5 = r3.zzg
            r10.zzX(r5)
            int r5 = r3.zzh
            r10.zzF(r5)
            float r3 = r3.zzi
            r10.zzP(r3)
            java.util.List r2 = java.util.Collections.singletonList(r2)
            r10.zzI(r2)
            com.google.android.gms.internal.ads.zzam r2 = r10.zzY()
            r1.zzk(r2)
            r1 = 1
            r0.zze = r1
            goto L_0x011a
        L_0x0110:
            r20 = r2
            r21 = r3
            r19 = r5
            r23 = r10
            r22 = r12
        L_0x011a:
            com.google.android.gms.internal.ads.zzaiy r1 = r0.zzj
            boolean r1 = r1.zzd(r4)
            if (r1 == 0) goto L_0x0142
            com.google.android.gms.internal.ads.zzaiy r1 = r0.zzj
            byte[] r2 = r1.zza
            int r1 = r1.zzb
            int r1 = com.google.android.gms.internal.ads.zzfu.zzb(r2, r1)
            com.google.android.gms.internal.ads.zzfa r2 = r0.zzn
            com.google.android.gms.internal.ads.zzaiy r3 = r0.zzj
            byte[] r3 = r3.zza
            r2.zzD(r3, r1)
            com.google.android.gms.internal.ads.zzfa r1 = r0.zzn
            r2 = 5
            r1.zzG(r2)
            com.google.android.gms.internal.ads.zzajk r1 = r0.zza
            com.google.android.gms.internal.ads.zzfa r2 = r0.zzn
            r1.zza(r8, r2)
        L_0x0142:
            com.google.android.gms.internal.ads.zzaiy r1 = r0.zzk
            boolean r1 = r1.zzd(r4)
            if (r1 == 0) goto L_0x016a
            com.google.android.gms.internal.ads.zzaiy r1 = r0.zzk
            byte[] r2 = r1.zza
            int r1 = r1.zzb
            int r1 = com.google.android.gms.internal.ads.zzfu.zzb(r2, r1)
            com.google.android.gms.internal.ads.zzfa r2 = r0.zzn
            com.google.android.gms.internal.ads.zzaiy r3 = r0.zzk
            byte[] r3 = r3.zza
            r2.zzD(r3, r1)
            com.google.android.gms.internal.ads.zzfa r1 = r0.zzn
            r2 = 5
            r1.zzG(r2)
            com.google.android.gms.internal.ads.zzajk r1 = r0.zza
            com.google.android.gms.internal.ads.zzfa r2 = r0.zzn
            r1.zza(r8, r2)
        L_0x016a:
            r1 = 1
            int r1 = r7 >> 1
            long r14 = r0.zzm
            com.google.android.gms.internal.ads.zzait r9 = r0.zzd
            boolean r2 = r0.zze
            r10 = r23
            r12 = r22
            r13 = r1
            r16 = r2
            r9.zzd(r10, r12, r13, r14, r16)
            boolean r2 = r0.zze
            if (r2 != 0) goto L_0x0190
            com.google.android.gms.internal.ads.zzaiy r2 = r0.zzg
            r2.zzc(r1)
            com.google.android.gms.internal.ads.zzaiy r2 = r0.zzh
            r2.zzc(r1)
            com.google.android.gms.internal.ads.zzaiy r2 = r0.zzi
            r2.zzc(r1)
        L_0x0190:
            com.google.android.gms.internal.ads.zzaiy r2 = r0.zzj
            r2.zzc(r1)
            com.google.android.gms.internal.ads.zzaiy r2 = r0.zzk
            r2.zzc(r1)
            r6 = r32
            r1 = r19
            r2 = r20
            r3 = r21
            goto L_0x0030
        L_0x01a4:
            r0.zzf(r3, r1, r2)
        L_0x01a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaiu.zza(com.google.android.gms.internal.ads.zzfa):void");
    }

    public final void zzb(zzaaz zzaaz, zzajv zzajv) {
        zzajv.zzc();
        this.zzb = zzajv.zzb();
        zzabz zzv = zzaaz.zzv(zzajv.zza(), 2);
        this.zzc = zzv;
        this.zzd = new zzait(zzv);
        this.zza.zzb(zzaaz, zzajv);
    }

    public final void zzc() {
    }

    public final void zzd(long j2, int i2) {
        if (j2 != -9223372036854775807L) {
            this.zzm = j2;
        }
    }

    public final void zze() {
        this.zzl = 0;
        this.zzm = -9223372036854775807L;
        zzfu.zzf(this.zzf);
        this.zzg.zzb();
        this.zzh.zzb();
        this.zzi.zzb();
        this.zzj.zzb();
        this.zzk.zzb();
        zzait zzait = this.zzd;
        if (zzait != null) {
            zzait.zzc();
        }
    }
}
