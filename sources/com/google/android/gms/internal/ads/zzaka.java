package com.google.android.gms.internal.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;

final class zzaka implements zzakb {
    private static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE, 143, 157, 173, 190, Sdk$SDKError.Reason.INVALID_JSON_BID_PAYLOAD_VALUE, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    private final zzaaz zzc;
    private final zzabz zzd;
    private final zzake zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzfa zzh;
    private final int zzi;
    private final zzam zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzaka(zzaaz zzaaz, zzabz zzabz, zzake zzake) throws zzcd {
        this.zzc = zzaaz;
        this.zzd = zzabz;
        this.zze = zzake;
        int max = Math.max(1, zzake.zzc / 10);
        this.zzi = max;
        zzfa zzfa = new zzfa(zzake.zzf);
        zzfa.zzi();
        int zzi2 = zzfa.zzi();
        this.zzf = zzi2;
        int i2 = zzake.zzb;
        int i3 = zzake.zzd;
        int i4 = (((i3 - (i2 * 4)) * 8) / (zzake.zze * i2)) + 1;
        if (zzi2 == i4) {
            int i5 = zzfj.zza;
            int i6 = ((max + zzi2) - 1) / zzi2;
            this.zzg = new byte[(i3 * i6)];
            this.zzh = new zzfa(i6 * (zzi2 + zzi2) * i2);
            int i7 = ((zzake.zzc * zzake.zzd) * 8) / zzi2;
            zzak zzak = new zzak();
            zzak.zzS("audio/raw");
            zzak.zzv(i7);
            zzak.zzO(i7);
            zzak.zzL((max + max) * i2);
            zzak.zzw(zzake.zzb);
            zzak.zzT(zzake.zzc);
            zzak.zzN(2);
            this.zzj = zzak.zzY();
            return;
        }
        throw zzcd.zza("Expected frames per block: " + i4 + "; got: " + zzi2, (Throwable) null);
    }

    private final int zzd(int i2) {
        int i3 = this.zze.zzb;
        return i2 / (i3 + i3);
    }

    private final int zze(int i2) {
        return (i2 + i2) * this.zze.zzb;
    }

    private final void zzf(int i2) {
        long zzp = this.zzl + zzfj.zzp(this.zzn, 1000000, (long) this.zze.zzc);
        int zze2 = zze(i2);
        this.zzd.zzs(zzp, 1, zze2, this.zzm - zze2, (zzaby) null);
        this.zzn += (long) i2;
        this.zzm -= zze2;
    }

    public final void zza(int i2, long j2) {
        this.zzc.zzN(new zzakh(this.zze, this.zzf, (long) i2, j2));
        this.zzd.zzk(this.zzj);
    }

    public final void zzb(long j2) {
        this.zzk = 0;
        this.zzl = j2;
        this.zzm = 0;
        this.zzn = 0;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0045 A[EDGE_INSN: B:38:0x0045->B:10:0x0045 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0026  */
    public final boolean zzc(com.google.android.gms.internal.ads.zzaax r21, long r22) throws java.io.IOException {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            int r3 = r0.zzi
            int r4 = r0.zzm
            int r4 = r0.zzd(r4)
            int r3 = r3 - r4
            int r4 = r0.zzf
            int r5 = com.google.android.gms.internal.ads.zzfj.zza
            int r3 = r3 + r4
            r5 = -1
            int r3 = r3 + r5
            int r3 = r3 / r4
            com.google.android.gms.internal.ads.zzake r4 = r0.zze
            int r4 = r4.zzd
            int r3 = r3 * r4
            r6 = 0
            int r9 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r9 != 0) goto L_0x0023
        L_0x0021:
            r6 = 1
            goto L_0x0024
        L_0x0023:
            r6 = 0
        L_0x0024:
            if (r6 != 0) goto L_0x0045
            int r7 = r0.zzk
            if (r7 >= r3) goto L_0x0045
            int r7 = r3 - r7
            long r9 = (long) r7
            long r9 = java.lang.Math.min(r9, r1)
            int r7 = (int) r9
            byte[] r9 = r0.zzg
            int r10 = r0.zzk
            r11 = r21
            int r7 = r11.zza(r9, r10, r7)
            if (r7 != r5) goto L_0x003f
            goto L_0x0021
        L_0x003f:
            int r9 = r0.zzk
            int r9 = r9 + r7
            r0.zzk = r9
            goto L_0x0024
        L_0x0045:
            int r1 = r0.zzk
            com.google.android.gms.internal.ads.zzake r2 = r0.zze
            int r2 = r2.zzd
            int r1 = r1 / r2
            if (r1 <= 0) goto L_0x0150
            byte[] r2 = r0.zzg
            com.google.android.gms.internal.ads.zzfa r3 = r0.zzh
            r5 = 0
        L_0x0053:
            if (r5 >= r1) goto L_0x011b
            r7 = 0
        L_0x0056:
            com.google.android.gms.internal.ads.zzake r9 = r0.zze
            int r10 = r9.zzb
            if (r7 >= r10) goto L_0x0113
            byte[] r11 = r3.zzH()
            int r9 = r9.zzd
            int r12 = r5 * r9
            int r9 = r9 / r10
            int r9 = r9 + -4
            int r13 = r7 * 4
            int r12 = r12 + r13
            int r13 = r12 + 1
            byte r13 = r2[r13]
            r13 = r13 & 255(0xff, float:3.57E-43)
            byte r14 = r2[r12]
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r15 = r12 + 2
            byte r15 = r2[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r4 = 88
            int r15 = java.lang.Math.min(r15, r4)
            int[] r16 = zzb
            r16 = r16[r15]
            int r4 = r0.zzf
            int r4 = r4 * r5
            int r4 = r4 * r10
            int r4 = r4 + r7
            int r13 = r13 << 8
            r13 = r13 | r14
            short r13 = (short) r13
            r14 = r13 & 255(0xff, float:3.57E-43)
            int r4 = r4 + r4
            byte r14 = (byte) r14
            r11[r4] = r14
            int r14 = r13 >> 8
            int r17 = r4 + 1
            byte r14 = (byte) r14
            r11[r17] = r14
            r14 = 0
        L_0x009d:
            int r8 = r9 + r9
            if (r14 >= r8) goto L_0x010b
            int r8 = r10 * 4
            int r8 = r8 + r12
            int r18 = r14 / 8
            int r19 = r14 / 2
            int r19 = r19 % 4
            int r18 = r18 * r10
            int r18 = r18 * 4
            int r8 = r8 + r18
            int r8 = r8 + r19
            byte r8 = r2[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r18 = r14 % 2
            if (r18 != 0) goto L_0x00bd
            r8 = r8 & 15
            goto L_0x00bf
        L_0x00bd:
            int r8 = r8 >> 4
        L_0x00bf:
            r18 = r8 & 7
            int r18 = r18 + r18
            r17 = 1
            int r18 = r18 + 1
            int r18 = r18 * r16
            r16 = r8 & 8
            r19 = r2
            int r2 = r18 >> 3
            if (r16 == 0) goto L_0x00d2
            int r2 = -r2
        L_0x00d2:
            int r13 = r13 + r2
            r2 = 32767(0x7fff, float:4.5916E-41)
            int r2 = java.lang.Math.min(r13, r2)
            r13 = -32768(0xffffffffffff8000, float:NaN)
            int r13 = java.lang.Math.max(r13, r2)
            int r2 = r10 + r10
            int r4 = r4 + r2
            r2 = r13 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r11[r4] = r2
            int r2 = r4 + 1
            r22 = r4
            int r4 = r13 >> 8
            byte r4 = (byte) r4
            r11[r2] = r4
            int[] r2 = zza
            r2 = r2[r8]
            int r15 = r15 + r2
            r2 = 88
            int r4 = java.lang.Math.min(r15, r2)
            r8 = 0
            int r15 = java.lang.Math.max(r8, r4)
            int[] r4 = zzb
            r16 = r4[r15]
            int r14 = r14 + 1
            r4 = r22
            r2 = r19
            goto L_0x009d
        L_0x010b:
            r19 = r2
            r17 = 1
            int r7 = r7 + 1
            goto L_0x0056
        L_0x0113:
            r19 = r2
            r17 = 1
            int r5 = r5 + 1
            goto L_0x0053
        L_0x011b:
            int r2 = r0.zzf
            int r2 = r2 * r1
            int r2 = r0.zze(r2)
            r4 = 0
            r3.zzF(r4)
            r3.zzE(r2)
            int r2 = r0.zzk
            com.google.android.gms.internal.ads.zzake r3 = r0.zze
            int r3 = r3.zzd
            int r1 = r1 * r3
            int r2 = r2 - r1
            r0.zzk = r2
            com.google.android.gms.internal.ads.zzfa r1 = r0.zzh
            int r2 = r1.zzd()
            com.google.android.gms.internal.ads.zzabz r3 = r0.zzd
            com.google.android.gms.internal.ads.zzabx.zzb(r3, r1, r2)
            int r1 = r0.zzm
            int r1 = r1 + r2
            r0.zzm = r1
            int r1 = r0.zzd(r1)
            int r2 = r0.zzi
            if (r1 < r2) goto L_0x0150
            r0.zzf(r2)
        L_0x0150:
            if (r6 == 0) goto L_0x015d
            int r1 = r0.zzm
            int r1 = r0.zzd(r1)
            if (r1 <= 0) goto L_0x015d
            r0.zzf(r1)
        L_0x015d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaka.zzc(com.google.android.gms.internal.ads.zzaax, long):boolean");
    }
}
