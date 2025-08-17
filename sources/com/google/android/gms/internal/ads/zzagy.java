package com.google.android.gms.internal.ads;

import com.facebook.common.time.Clock;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public final class zzagy implements zzaaw, zzabv {
    public static final zzabd zza = zzagv.zza;
    private final zzfa zzb;
    private final zzfa zzc;
    private final zzfa zzd;
    private final zzfa zze;
    private final ArrayDeque zzf;
    private final zzaha zzg;
    private final List zzh;
    private int zzi;
    private int zzj;
    private long zzk;
    private int zzl;
    private zzfa zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private zzaaz zzr;
    private zzagx[] zzs;
    private long[][] zzt;
    private int zzu;
    private long zzv;
    private int zzw;
    private zzafa zzx;

    public zzagy() {
        this(0);
    }

    private static int zzf(int i2) {
        if (i2 != 1751476579) {
            return i2 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static int zzi(zzahf zzahf, long j2) {
        int zza2 = zzahf.zza(j2);
        if (zza2 == -1) {
            return zzahf.zzb(j2);
        }
        return zza2;
    }

    private static long zzj(zzahf zzahf, long j2, long j3) {
        int zzi2 = zzi(zzahf, j2);
        if (zzi2 == -1) {
            return j3;
        }
        return Math.min(zzahf.zzc[zzi2], j3);
    }

    private final void zzk() {
        this.zzi = 0;
        this.zzl = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x01a4 A[LOOP:3: B:73:0x01a1->B:75:0x01a4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzl(long r31) throws com.google.android.gms.internal.ads.zzcd {
        /*
            r30 = this;
            r0 = r30
        L_0x0002:
            java.util.ArrayDeque r1 = r0.zzf
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x028a
            java.util.ArrayDeque r1 = r0.zzf
            java.lang.Object r1 = r1.peek()
            com.google.android.gms.internal.ads.zzagc r1 = (com.google.android.gms.internal.ads.zzagc) r1
            long r3 = r1.zza
            int r1 = (r3 > r31 ? 1 : (r3 == r31 ? 0 : -1))
            if (r1 != 0) goto L_0x028a
            java.util.ArrayDeque r1 = r0.zzf
            java.lang.Object r1 = r1.pop()
            r3 = r1
            com.google.android.gms.internal.ads.zzagc r3 = (com.google.android.gms.internal.ads.zzagc) r3
            int r1 = r3.zzd
            r4 = 1836019574(0x6d6f6f76, float:4.631354E27)
            if (r1 != r4) goto L_0x0275
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r4 = r0.zzw
            com.google.android.gms.internal.ads.zzabl r11 = new com.google.android.gms.internal.ads.zzabl
            r11.<init>()
            r5 = 1969517665(0x75647461, float:2.8960062E32)
            com.google.android.gms.internal.ads.zzagd r5 = r3.zzb(r5)
            if (r5 == 0) goto L_0x0050
            com.google.android.gms.internal.ads.zzagm r5 = com.google.android.gms.internal.ads.zzagn.zzb(r5)
            com.google.android.gms.internal.ads.zzbz r6 = r5.zza
            com.google.android.gms.internal.ads.zzbz r7 = r5.zzb
            com.google.android.gms.internal.ads.zzbz r5 = r5.zzc
            if (r6 == 0) goto L_0x004c
            r11.zzb(r6)
        L_0x004c:
            r13 = r5
            r14 = r6
            r15 = r7
            goto L_0x0053
        L_0x0050:
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0053:
            r5 = 1835365473(0x6d657461, float:4.4382975E27)
            com.google.android.gms.internal.ads.zzagc r5 = r3.zza(r5)
            if (r5 == 0) goto L_0x0062
            com.google.android.gms.internal.ads.zzbz r5 = com.google.android.gms.internal.ads.zzagn.zza(r5)
            r10 = r5
            goto L_0x0063
        L_0x0062:
            r10 = 0
        L_0x0063:
            r9 = 0
            r8 = 1
            if (r4 != r8) goto L_0x006a
            r16 = 1
            goto L_0x006c
        L_0x006a:
            r16 = 0
        L_0x006c:
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 0
            r17 = 0
            com.google.android.gms.internal.ads.zzagw r18 = com.google.android.gms.internal.ads.zzagw.zza
            r4 = r11
            r12 = 1
            r8 = r17
            r9 = r16
            r20 = r10
            r10 = r18
            java.util.List r3 = com.google.android.gms.internal.ads.zzagn.zzc(r3, r4, r5, r7, r8, r9, r10)
            int r4 = r3.size()
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r10 = r13
            r8 = -1
            r9 = 0
            r12 = r6
        L_0x0091:
            r17 = 0
            if (r9 >= r4) goto L_0x01e7
            java.lang.Object r21 = r3.get(r9)
            r5 = r21
            com.google.android.gms.internal.ads.zzahf r5 = (com.google.android.gms.internal.ads.zzahf) r5
            int r2 = r5.zzb
            if (r2 != 0) goto L_0x00b1
            r22 = r3
            r23 = r4
            r19 = r10
            r3 = r20
            r2 = -1
            r28 = r6
            r7 = r11
            r10 = r28
            goto L_0x01d6
        L_0x00b1:
            com.google.android.gms.internal.ads.zzahc r2 = r5.zza
            r22 = r3
            r23 = r4
            long r3 = r2.zze
            int r24 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r24 == 0) goto L_0x00be
            goto L_0x00c0
        L_0x00be:
            long r3 = r5.zzh
        L_0x00c0:
            long r12 = java.lang.Math.max(r12, r3)
            com.google.android.gms.internal.ads.zzagx r6 = new com.google.android.gms.internal.ads.zzagx
            com.google.android.gms.internal.ads.zzaaz r7 = r0.zzr
            r25 = r12
            int r12 = r2.zzb
            com.google.android.gms.internal.ads.zzabz r7 = r7.zzv(r9, r12)
            r6.<init>(r2, r5, r7)
            com.google.android.gms.internal.ads.zzam r7 = r2.zzf
            java.lang.String r7 = r7.zzm
            java.lang.String r12 = "audio/true-hd"
            boolean r7 = r12.equals(r7)
            if (r7 == 0) goto L_0x00e4
            int r7 = r5.zze
            int r7 = r7 * 16
            goto L_0x00e8
        L_0x00e4:
            int r7 = r5.zze
            int r7 = r7 + 30
        L_0x00e8:
            com.google.android.gms.internal.ads.zzam r12 = r2.zzf
            com.google.android.gms.internal.ads.zzak r12 = r12.zzb()
            r12.zzL(r7)
            int r7 = r2.zzb
            r13 = 2
            if (r7 != r13) goto L_0x0109
            int r7 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r7 <= 0) goto L_0x0109
            int r5 = r5.zzb
            r7 = 1
            if (r5 <= r7) goto L_0x0109
            float r3 = (float) r3
            float r4 = (float) r5
            r5 = 1232348160(0x49742400, float:1000000.0)
            float r3 = r3 / r5
            float r4 = r4 / r3
            r12.zzE(r4)
        L_0x0109:
            int r3 = r2.zzb
            int r4 = com.google.android.gms.internal.ads.zzagu.zzb
            r4 = 1
            if (r3 != r4) goto L_0x0120
            boolean r3 = r11.zza()
            if (r3 == 0) goto L_0x0120
            int r3 = r11.zza
            r12.zzC(r3)
            int r3 = r11.zzb
            r12.zzD(r3)
        L_0x0120:
            int r3 = r2.zzb
            r4 = 3
            com.google.android.gms.internal.ads.zzbz[] r5 = new com.google.android.gms.internal.ads.zzbz[r4]
            r7 = 0
            r5[r7] = r15
            java.util.List r13 = r0.zzh
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L_0x0133
            r4 = 1
            r13 = 0
            goto L_0x013b
        L_0x0133:
            com.google.android.gms.internal.ads.zzbz r13 = new com.google.android.gms.internal.ads.zzbz
            java.util.List r4 = r0.zzh
            r13.<init>((java.util.List) r4)
            r4 = 1
        L_0x013b:
            r5[r4] = r13
            r13 = 2
            r5[r13] = r10
            com.google.android.gms.internal.ads.zzbz r13 = new com.google.android.gms.internal.ads.zzbz
            r19 = r10
            com.google.android.gms.internal.ads.zzby[] r10 = new com.google.android.gms.internal.ads.zzby[r7]
            r27 = r8
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r13.<init>(r7, r10)
            if (r3 != r4) goto L_0x015e
            if (r14 == 0) goto L_0x019e
            r7 = r11
            r13 = r14
        L_0x0156:
            r3 = r20
        L_0x0158:
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x01a0
        L_0x015e:
            r4 = 2
            if (r3 != r4) goto L_0x019e
            r3 = r20
            if (r3 == 0) goto L_0x019c
            r4 = 0
        L_0x0166:
            int r7 = r3.zza()
            if (r4 >= r7) goto L_0x019c
            com.google.android.gms.internal.ads.zzby r7 = r3.zzb(r4)
            boolean r8 = r7 instanceof com.google.android.gms.internal.ads.zzfn
            if (r8 == 0) goto L_0x0192
            com.google.android.gms.internal.ads.zzfn r7 = (com.google.android.gms.internal.ads.zzfn) r7
            java.lang.String r8 = r7.zza
            java.lang.String r10 = "com.android.capture.fps"
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L_0x0192
            com.google.android.gms.internal.ads.zzbz r13 = new com.google.android.gms.internal.ads.zzbz
            r4 = 1
            com.google.android.gms.internal.ads.zzby[] r8 = new com.google.android.gms.internal.ads.zzby[r4]
            r4 = 0
            r8[r4] = r7
            r7 = r11
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r13.<init>(r10, r8)
            goto L_0x01a0
        L_0x0192:
            r7 = r11
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = r4 + 1
            r11 = r7
            goto L_0x0166
        L_0x019c:
            r7 = r11
            goto L_0x0158
        L_0x019e:
            r7 = r11
            goto L_0x0156
        L_0x01a0:
            r4 = 0
        L_0x01a1:
            r8 = 3
            if (r4 >= r8) goto L_0x01ad
            r8 = r5[r4]
            com.google.android.gms.internal.ads.zzbz r13 = r13.zzd(r8)
            int r4 = r4 + 1
            goto L_0x01a1
        L_0x01ad:
            int r4 = r13.zza()
            if (r4 <= 0) goto L_0x01b6
            r12.zzM(r13)
        L_0x01b6:
            com.google.android.gms.internal.ads.zzabz r4 = r6.zzc
            com.google.android.gms.internal.ads.zzam r5 = r12.zzY()
            r4.zzk(r5)
            int r2 = r2.zzb
            r4 = 2
            r5 = r27
            if (r2 != r4) goto L_0x01cf
            r2 = -1
            if (r5 != r2) goto L_0x01d0
            int r4 = r1.size()
            r8 = r4
            goto L_0x01d1
        L_0x01cf:
            r2 = -1
        L_0x01d0:
            r8 = r5
        L_0x01d1:
            r1.add(r6)
            r12 = r25
        L_0x01d6:
            int r9 = r9 + 1
            r20 = r3
            r3 = r22
            r4 = r23
            r28 = r10
            r11 = r7
            r6 = r28
            r10 = r19
            goto L_0x0091
        L_0x01e7:
            r5 = r8
            r2 = -1
            r0.zzu = r5
            r0.zzv = r12
            r3 = 0
            com.google.android.gms.internal.ads.zzagx[] r4 = new com.google.android.gms.internal.ads.zzagx[r3]
            java.lang.Object[] r1 = r1.toArray(r4)
            com.google.android.gms.internal.ads.zzagx[] r1 = (com.google.android.gms.internal.ads.zzagx[]) r1
            r0.zzs = r1
            int r3 = r1.length
            long[][] r4 = new long[r3][]
            int[] r5 = new int[r3]
            long[] r6 = new long[r3]
            boolean[] r3 = new boolean[r3]
            r9 = 0
        L_0x0202:
            int r7 = r1.length
            if (r9 >= r7) goto L_0x021d
            r7 = r1[r9]
            com.google.android.gms.internal.ads.zzahf r7 = r7.zzb
            int r7 = r7.zzb
            long[] r7 = new long[r7]
            r4[r9] = r7
            r7 = r1[r9]
            com.google.android.gms.internal.ads.zzahf r7 = r7.zzb
            long[] r7 = r7.zzf
            r8 = 0
            r10 = r7[r8]
            r6[r9] = r10
            int r9 = r9 + 1
            goto L_0x0202
        L_0x021d:
            r8 = 0
            r9 = 0
        L_0x021f:
            int r7 = r1.length
            if (r9 >= r7) goto L_0x025f
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r7 = 0
            r12 = -1
        L_0x0229:
            int r13 = r1.length
            if (r7 >= r13) goto L_0x023b
            boolean r13 = r3[r7]
            if (r13 != 0) goto L_0x0238
            r13 = r6[r7]
            int r15 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r15 > 0) goto L_0x0238
            r12 = r7
            r10 = r13
        L_0x0238:
            int r7 = r7 + 1
            goto L_0x0229
        L_0x023b:
            r7 = r5[r12]
            r10 = r4[r12]
            r10[r7] = r17
            r11 = r1[r12]
            com.google.android.gms.internal.ads.zzahf r11 = r11.zzb
            int[] r13 = r11.zzd
            r13 = r13[r7]
            long r13 = (long) r13
            long r17 = r17 + r13
            r13 = 1
            int r7 = r7 + r13
            r5[r12] = r7
            int r10 = r10.length
            if (r7 >= r10) goto L_0x025a
            long[] r10 = r11.zzf
            r14 = r10[r7]
            r6[r12] = r14
            goto L_0x021f
        L_0x025a:
            r3[r12] = r13
            int r9 = r9 + 1
            goto L_0x021f
        L_0x025f:
            r0.zzt = r4
            com.google.android.gms.internal.ads.zzaaz r1 = r0.zzr
            r1.zzC()
            com.google.android.gms.internal.ads.zzaaz r1 = r0.zzr
            r1.zzN(r0)
            java.util.ArrayDeque r1 = r0.zzf
            r1.clear()
            r1 = 2
            r0.zzi = r1
            goto L_0x0002
        L_0x0275:
            java.util.ArrayDeque r1 = r0.zzf
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0002
            java.util.ArrayDeque r1 = r0.zzf
            java.lang.Object r1 = r1.peek()
            com.google.android.gms.internal.ads.zzagc r1 = (com.google.android.gms.internal.ads.zzagc) r1
            r1.zzc(r3)
            goto L_0x0002
        L_0x028a:
            int r1 = r0.zzi
            r2 = 2
            if (r1 == r2) goto L_0x0292
            r30.zzk()
        L_0x0292:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagy.zzl(long):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:211:0x0081 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzaax r33, com.google.android.gms.internal.ads.zzabs r34) throws java.io.IOException {
        /*
            r32 = this;
            r0 = r32
            r1 = r33
            r2 = r34
        L_0x0006:
            int r3 = r0.zzi
            r4 = 1718909296(0x66747970, float:2.8862439E23)
            r6 = 0
            r8 = -1
            r9 = 8
            r10 = 1
            if (r3 == 0) goto L_0x024b
            r13 = 262144(0x40000, double:1.295163E-318)
            if (r3 == r10) goto L_0x01cb
            long r3 = r33.zzf()
            int r9 = r0.zzn
            if (r9 != r8) goto L_0x009e
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r18 = r16
            r21 = r18
            r23 = r21
            r9 = 0
            r20 = 1
            r25 = -1
            r26 = -1
            r27 = 1
        L_0x0034:
            com.google.android.gms.internal.ads.zzagx[] r5 = r0.zzs
            int r15 = r5.length
            if (r9 >= r15) goto L_0x0084
            r5 = r5[r9]
            int r15 = r5.zze
            com.google.android.gms.internal.ads.zzahf r5 = r5.zzb
            int r12 = r5.zzb
            if (r15 != r12) goto L_0x0044
            goto L_0x0081
        L_0x0044:
            long[] r5 = r5.zzc
            r28 = r5[r15]
            long[][] r5 = r0.zzt
            int r12 = com.google.android.gms.internal.ads.zzfj.zza
            r5 = r5[r9]
            r30 = r5[r15]
            long r28 = r28 - r3
            int r5 = (r28 > r6 ? 1 : (r28 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x005d
            int r5 = (r28 > r13 ? 1 : (r28 == r13 ? 0 : -1))
            if (r5 < 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r5 = 0
            goto L_0x005e
        L_0x005d:
            r5 = 1
        L_0x005e:
            if (r5 != 0) goto L_0x0064
            if (r27 != 0) goto L_0x006c
            r12 = 0
            goto L_0x0066
        L_0x0064:
            r12 = r27
        L_0x0066:
            if (r5 != r12) goto L_0x0075
            int r15 = (r28 > r23 ? 1 : (r28 == r23 ? 0 : -1))
            if (r15 >= 0) goto L_0x0075
        L_0x006c:
            r27 = r5
            r26 = r9
            r23 = r28
            r21 = r30
            goto L_0x0077
        L_0x0075:
            r27 = r12
        L_0x0077:
            int r12 = (r30 > r18 ? 1 : (r30 == r18 ? 0 : -1))
            if (r12 >= 0) goto L_0x0081
            r20 = r5
            r25 = r9
            r18 = r30
        L_0x0081:
            int r9 = r9 + 1
            goto L_0x0034
        L_0x0084:
            int r5 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r5 == 0) goto L_0x0096
            if (r20 == 0) goto L_0x0096
            r15 = 10485760(0xa00000, double:5.180654E-317)
            long r18 = r18 + r15
            int r5 = (r21 > r18 ? 1 : (r21 == r18 ? 0 : -1))
            if (r5 < 0) goto L_0x0096
            r9 = r25
            goto L_0x0098
        L_0x0096:
            r9 = r26
        L_0x0098:
            r0.zzn = r9
            if (r9 != r8) goto L_0x009e
            goto L_0x01ca
        L_0x009e:
            com.google.android.gms.internal.ads.zzagx[] r5 = r0.zzs
            r5 = r5[r9]
            com.google.android.gms.internal.ads.zzabz r9 = r5.zzc
            int r12 = r5.zze
            com.google.android.gms.internal.ads.zzahf r15 = r5.zzb
            long[] r8 = r15.zzc
            r10 = r8[r12]
            int[] r8 = r15.zzd
            r8 = r8[r12]
            com.google.android.gms.internal.ads.zzaca r15 = r5.zzd
            long r3 = r10 - r3
            int r13 = r0.zzo
            long r13 = (long) r13
            long r3 = r3 + r13
            int r13 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r13 < 0) goto L_0x01c7
            r6 = 262144(0x40000, double:1.295163E-318)
            int r13 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r13 < 0) goto L_0x00c5
            goto L_0x01c7
        L_0x00c5:
            com.google.android.gms.internal.ads.zzahc r2 = r5.zza
            int r2 = r2.zzg
            r6 = 1
            if (r2 != r6) goto L_0x00d1
            r6 = 8
            long r3 = r3 + r6
            int r8 = r8 + -8
        L_0x00d1:
            int r2 = (int) r3
            r1.zzk(r2)
            com.google.android.gms.internal.ads.zzahc r2 = r5.zza
            int r3 = r2.zzj
            if (r3 == 0) goto L_0x013b
            com.google.android.gms.internal.ads.zzfa r2 = r0.zzc
            byte[] r2 = r2.zzH()
            r4 = 0
            r2[r4] = r4
            r6 = 1
            r2[r6] = r4
            r6 = 2
            r2[r6] = r4
            int r4 = 4 - r3
        L_0x00ec:
            int r6 = r0.zzp
            if (r6 >= r8) goto L_0x017e
            int r6 = r0.zzq
            if (r6 != 0) goto L_0x0126
            r1.zzi(r2, r4, r3)
            int r6 = r0.zzo
            int r6 = r6 + r3
            r0.zzo = r6
            com.google.android.gms.internal.ads.zzfa r6 = r0.zzc
            r7 = 0
            r6.zzF(r7)
            com.google.android.gms.internal.ads.zzfa r6 = r0.zzc
            int r6 = r6.zze()
            if (r6 < 0) goto L_0x011e
            r0.zzq = r6
            com.google.android.gms.internal.ads.zzfa r6 = r0.zzb
            r6.zzF(r7)
            com.google.android.gms.internal.ads.zzfa r6 = r0.zzb
            r10 = 4
            r9.zzq(r6, r10)
            int r6 = r0.zzp
            int r6 = r6 + r10
            r0.zzp = r6
            int r8 = r8 + r4
            goto L_0x00ec
        L_0x011e:
            java.lang.String r1 = "Invalid NAL length"
            r2 = 0
            com.google.android.gms.internal.ads.zzcd r1 = com.google.android.gms.internal.ads.zzcd.zza(r1, r2)
            throw r1
        L_0x0126:
            r7 = 0
            int r6 = r9.zze(r1, r6, r7)
            int r7 = r0.zzo
            int r7 = r7 + r6
            r0.zzo = r7
            int r7 = r0.zzp
            int r7 = r7 + r6
            r0.zzp = r7
            int r7 = r0.zzq
            int r7 = r7 - r6
            r0.zzq = r7
            goto L_0x00ec
        L_0x013b:
            com.google.android.gms.internal.ads.zzam r2 = r2.zzf
            java.lang.String r2 = r2.zzm
            java.lang.String r3 = "audio/ac4"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x015e
            int r2 = r0.zzp
            if (r2 != 0) goto L_0x015b
            com.google.android.gms.internal.ads.zzfa r2 = r0.zzd
            com.google.android.gms.internal.ads.zzaaa.zzb(r8, r2)
            com.google.android.gms.internal.ads.zzfa r2 = r0.zzd
            r3 = 7
            r9.zzq(r2, r3)
            int r2 = r0.zzp
            int r2 = r2 + r3
            r0.zzp = r2
        L_0x015b:
            int r8 = r8 + 7
            goto L_0x0163
        L_0x015e:
            if (r15 == 0) goto L_0x0163
            r15.zzd(r1)
        L_0x0163:
            int r2 = r0.zzp
            if (r2 >= r8) goto L_0x017e
            int r2 = r8 - r2
            r3 = 0
            int r2 = r9.zze(r1, r2, r3)
            int r3 = r0.zzo
            int r3 = r3 + r2
            r0.zzo = r3
            int r3 = r0.zzp
            int r3 = r3 + r2
            r0.zzp = r3
            int r3 = r0.zzq
            int r3 = r3 - r2
            r0.zzq = r3
            goto L_0x0163
        L_0x017e:
            com.google.android.gms.internal.ads.zzahf r1 = r5.zzb
            long[] r2 = r1.zzf
            r3 = r2[r12]
            int[] r1 = r1.zzg
            r1 = r1[r12]
            if (r15 == 0) goto L_0x01a7
            r21 = 0
            r22 = 0
            r2 = r15
            r16 = r9
            r17 = r3
            r19 = r1
            r20 = r8
            r15.zzc(r16, r17, r19, r20, r21, r22)
            r1 = 1
            int r12 = r12 + r1
            com.google.android.gms.internal.ads.zzahf r1 = r5.zzb
            int r1 = r1.zzb
            if (r12 != r1) goto L_0x01b5
            r1 = 0
            r2.zza(r9, r1)
            goto L_0x01b5
        L_0x01a7:
            r20 = 0
            r21 = 0
            r15 = r9
            r16 = r3
            r18 = r1
            r19 = r8
            r15.zzs(r16, r18, r19, r20, r21)
        L_0x01b5:
            int r1 = r5.zze
            r2 = 1
            int r1 = r1 + r2
            r5.zze = r1
            r1 = -1
            r0.zzn = r1
            r1 = 0
            r0.zzo = r1
            r0.zzp = r1
            r0.zzq = r1
            r8 = 0
            goto L_0x01ca
        L_0x01c7:
            r2.zza = r10
            r8 = 1
        L_0x01ca:
            return r8
        L_0x01cb:
            long r5 = r0.zzk
            int r3 = r0.zzl
            long r7 = (long) r3
            long r5 = r5 - r7
            long r7 = r33.zzf()
            long r7 = r7 + r5
            com.google.android.gms.internal.ads.zzfa r3 = r0.zzm
            if (r3 == 0) goto L_0x022a
            byte[] r10 = r3.zzH()
            int r11 = r0.zzl
            int r6 = (int) r5
            r1.zzi(r10, r11, r6)
            int r5 = r0.zzj
            if (r5 != r4) goto L_0x020f
            r3.zzF(r9)
            int r4 = r3.zze()
            int r4 = zzf(r4)
            if (r4 == 0) goto L_0x01f6
            goto L_0x020c
        L_0x01f6:
            r4 = 4
            r3.zzG(r4)
        L_0x01fa:
            int r4 = r3.zza()
            if (r4 <= 0) goto L_0x020b
            int r4 = r3.zze()
            int r4 = zzf(r4)
            if (r4 == 0) goto L_0x01fa
            goto L_0x020c
        L_0x020b:
            r4 = 0
        L_0x020c:
            r0.zzw = r4
            goto L_0x0235
        L_0x020f:
            java.util.ArrayDeque r4 = r0.zzf
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0235
            java.util.ArrayDeque r4 = r0.zzf
            java.lang.Object r4 = r4.peek()
            com.google.android.gms.internal.ads.zzagc r4 = (com.google.android.gms.internal.ads.zzagc) r4
            com.google.android.gms.internal.ads.zzagd r5 = new com.google.android.gms.internal.ads.zzagd
            int r6 = r0.zzj
            r5.<init>(r6, r3)
            r4.zzd(r5)
            goto L_0x0235
        L_0x022a:
            r3 = 262144(0x40000, double:1.295163E-318)
            int r9 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r9 >= 0) goto L_0x0237
            int r3 = (int) r5
            r1.zzk(r3)
        L_0x0235:
            r11 = 0
            goto L_0x023f
        L_0x0237:
            long r3 = r33.zzf()
            long r3 = r3 + r5
            r2.zza = r3
            r11 = 1
        L_0x023f:
            r0.zzl(r7)
            if (r11 == 0) goto L_0x0006
            int r3 = r0.zzi
            r4 = 2
            if (r3 == r4) goto L_0x0006
            r3 = 1
            return r3
        L_0x024b:
            r3 = 1
            int r5 = r0.zzl
            if (r5 != 0) goto L_0x0276
            com.google.android.gms.internal.ads.zzfa r5 = r0.zze
            byte[] r5 = r5.zzH()
            r8 = 0
            boolean r5 = r1.zzn(r5, r8, r9, r3)
            if (r5 != 0) goto L_0x025f
            r3 = -1
            return r3
        L_0x025f:
            r0.zzl = r9
            com.google.android.gms.internal.ads.zzfa r3 = r0.zze
            r3.zzF(r8)
            com.google.android.gms.internal.ads.zzfa r3 = r0.zze
            long r10 = r3.zzs()
            r0.zzk = r10
            com.google.android.gms.internal.ads.zzfa r3 = r0.zze
            int r3 = r3.zze()
            r0.zzj = r3
        L_0x0276:
            long r10 = r0.zzk
            r12 = 1
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 != 0) goto L_0x0295
            com.google.android.gms.internal.ads.zzfa r3 = r0.zze
            byte[] r3 = r3.zzH()
            r1.zzi(r3, r9, r9)
            int r3 = r0.zzl
            int r3 = r3 + r9
            r0.zzl = r3
            com.google.android.gms.internal.ads.zzfa r3 = r0.zze
            long r5 = r3.zzt()
            r0.zzk = r5
            goto L_0x02c0
        L_0x0295:
            int r3 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x02c0
            long r5 = r33.zzd()
            r7 = -1
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x02b1
            java.util.ArrayDeque r3 = r0.zzf
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.zzagc r3 = (com.google.android.gms.internal.ads.zzagc) r3
            if (r3 == 0) goto L_0x02b0
            long r5 = r3.zza
            goto L_0x02b1
        L_0x02b0:
            r5 = r7
        L_0x02b1:
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x02c0
            long r7 = r33.zzf()
            long r5 = r5 - r7
            int r3 = r0.zzl
            long r7 = (long) r3
            long r5 = r5 + r7
            r0.zzk = r5
        L_0x02c0:
            long r5 = r0.zzk
            int r3 = r0.zzl
            long r7 = (long) r3
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 < 0) goto L_0x03fd
            int r5 = r0.zzj
            r6 = 1836019574(0x6d6f6f76, float:4.631354E27)
            r7 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r5 == r6) goto L_0x03ab
            r6 = 1953653099(0x7472616b, float:7.681346E31)
            if (r5 == r6) goto L_0x03ab
            r6 = 1835297121(0x6d646961, float:4.4181236E27)
            if (r5 == r6) goto L_0x03ab
            r6 = 1835626086(0x6d696e66, float:4.515217E27)
            if (r5 == r6) goto L_0x03ab
            r6 = 1937007212(0x7374626c, float:1.9362132E31)
            if (r5 == r6) goto L_0x03ab
            r6 = 1701082227(0x65647473, float:6.742798E22)
            if (r5 == r6) goto L_0x03ab
            if (r5 != r7) goto L_0x02f0
            goto L_0x03ab
        L_0x02f0:
            r6 = 1835296868(0x6d646864, float:4.418049E27)
            if (r5 == r6) goto L_0x0377
            r6 = 1836476516(0x6d766864, float:4.7662196E27)
            if (r5 == r6) goto L_0x0377
            r6 = 1751411826(0x68646c72, float:4.3148E24)
            if (r5 == r6) goto L_0x0377
            r6 = 1937011556(0x73747364, float:1.9367383E31)
            if (r5 == r6) goto L_0x0377
            r6 = 1937011827(0x73747473, float:1.9367711E31)
            if (r5 == r6) goto L_0x0377
            r6 = 1937011571(0x73747373, float:1.9367401E31)
            if (r5 == r6) goto L_0x0377
            r6 = 1668576371(0x63747473, float:4.5093966E21)
            if (r5 == r6) goto L_0x0377
            r6 = 1701606260(0x656c7374, float:6.9788014E22)
            if (r5 == r6) goto L_0x0377
            r6 = 1937011555(0x73747363, float:1.9367382E31)
            if (r5 == r6) goto L_0x0377
            r6 = 1937011578(0x7374737a, float:1.936741E31)
            if (r5 == r6) goto L_0x0377
            r6 = 1937013298(0x73747a32, float:1.9369489E31)
            if (r5 == r6) goto L_0x0377
            r6 = 1937007471(0x7374636f, float:1.9362445E31)
            if (r5 == r6) goto L_0x0377
            r6 = 1668232756(0x636f3634, float:4.4126776E21)
            if (r5 == r6) goto L_0x0377
            r6 = 1953196132(0x746b6864, float:7.46037E31)
            if (r5 == r6) goto L_0x0377
            if (r5 == r4) goto L_0x0377
            r4 = 1969517665(0x75647461, float:2.8960062E32)
            if (r5 == r4) goto L_0x0377
            r4 = 1801812339(0x6b657973, float:2.7741754E26)
            if (r5 == r4) goto L_0x0377
            r4 = 1768715124(0x696c7374, float:1.7865732E25)
            if (r5 != r4) goto L_0x0348
            goto L_0x0377
        L_0x0348:
            long r3 = r33.zzf()
            int r5 = r0.zzl
            long r5 = (long) r5
            long r10 = r3 - r5
            int r3 = r0.zzj
            r4 = 1836086884(0x6d707664, float:4.6512205E27)
            if (r3 != r4) goto L_0x036f
            long r14 = r10 + r5
            com.google.android.gms.internal.ads.zzafa r3 = new com.google.android.gms.internal.ads.zzafa
            r8 = 0
            long r12 = r0.zzk
            long r4 = r12 - r5
            r7 = r3
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r16 = r4
            r7.<init>(r8, r10, r12, r14, r16)
            r0.zzx = r3
        L_0x036f:
            r3 = 0
            r0.zzm = r3
            r3 = 1
            r0.zzi = r3
            goto L_0x0006
        L_0x0377:
            if (r3 != r9) goto L_0x037b
            r3 = 1
            goto L_0x037c
        L_0x037b:
            r3 = 0
        L_0x037c:
            com.google.android.gms.internal.ads.zzdy.zzf(r3)
            long r3 = r0.zzk
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x038a
            r3 = 1
            goto L_0x038b
        L_0x038a:
            r3 = 0
        L_0x038b:
            com.google.android.gms.internal.ads.zzdy.zzf(r3)
            com.google.android.gms.internal.ads.zzfa r3 = new com.google.android.gms.internal.ads.zzfa
            long r4 = r0.zzk
            int r5 = (int) r4
            r3.<init>((int) r5)
            com.google.android.gms.internal.ads.zzfa r4 = r0.zze
            byte[] r4 = r4.zzH()
            byte[] r5 = r3.zzH()
            r6 = 0
            java.lang.System.arraycopy(r4, r6, r5, r6, r9)
            r0.zzm = r3
            r3 = 1
            r0.zzi = r3
            goto L_0x0006
        L_0x03ab:
            long r3 = r33.zzf()
            long r5 = r0.zzk
            long r3 = r3 + r5
            int r8 = r0.zzl
            long r10 = (long) r8
            int r8 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x03dd
            int r5 = r0.zzj
            if (r5 != r7) goto L_0x03dd
            com.google.android.gms.internal.ads.zzfa r5 = r0.zzd
            r5.zzC(r9)
            com.google.android.gms.internal.ads.zzfa r5 = r0.zzd
            byte[] r5 = r5.zzH()
            r6 = 0
            r1.zzh(r5, r6, r9)
            com.google.android.gms.internal.ads.zzfa r5 = r0.zzd
            com.google.android.gms.internal.ads.zzagn.zzd(r5)
            com.google.android.gms.internal.ads.zzfa r5 = r0.zzd
            int r5 = r5.zzc()
            r1.zzk(r5)
            r33.zzj()
        L_0x03dd:
            long r3 = r3 - r10
            java.util.ArrayDeque r5 = r0.zzf
            com.google.android.gms.internal.ads.zzagc r6 = new com.google.android.gms.internal.ads.zzagc
            int r7 = r0.zzj
            r6.<init>(r7, r3)
            r5.push(r6)
            long r5 = r0.zzk
            int r7 = r0.zzl
            long r7 = (long) r7
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x03f8
            r0.zzl(r3)
            goto L_0x0006
        L_0x03f8:
            r32.zzk()
            goto L_0x0006
        L_0x03fd:
            java.lang.String r1 = "Atom size less than header length (unsupported)."
            com.google.android.gms.internal.ads.zzcd r1 = com.google.android.gms.internal.ads.zzcd.zzc(r1)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagy.zza(com.google.android.gms.internal.ads.zzaax, com.google.android.gms.internal.ads.zzabs):int");
    }

    public final void zzb(zzaaz zzaaz) {
        this.zzr = zzaaz;
    }

    public final void zzc(long j2, long j3) {
        this.zzf.clear();
        this.zzl = 0;
        this.zzn = -1;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        if (j2 == 0) {
            zzk();
            return;
        }
        for (zzagx zzagx : this.zzs) {
            zzahf zzahf = zzagx.zzb;
            int zza2 = zzahf.zza(j3);
            if (zza2 == -1) {
                zza2 = zzahf.zzb(j3);
            }
            zzagx.zze = zza2;
            zzaca zzaca = zzagx.zzd;
            if (zzaca != null) {
                zzaca.zzb();
            }
        }
    }

    public final boolean zzd(zzaax zzaax) throws IOException {
        return zzahb.zzb(zzaax, false);
    }

    public final long zze() {
        return this.zzv;
    }

    public final zzabt zzg(long j2) {
        long j3;
        long j4;
        int zzb2;
        zzagx[] zzagxArr = this.zzs;
        if (zzagxArr.length == 0) {
            zzabw zzabw = zzabw.zza;
            return new zzabt(zzabw, zzabw);
        }
        int i2 = this.zzu;
        long j5 = -1;
        if (i2 != -1) {
            zzahf zzahf = zzagxArr[i2].zzb;
            int zzi2 = zzi(zzahf, j2);
            if (zzi2 == -1) {
                zzabw zzabw2 = zzabw.zza;
                return new zzabt(zzabw2, zzabw2);
            }
            long j6 = zzahf.zzf[zzi2];
            j3 = zzahf.zzc[zzi2];
            if (j6 >= j2 || zzi2 >= zzahf.zzb - 1 || (zzb2 = zzahf.zzb(j2)) == -1 || zzb2 == zzi2) {
                j4 = -9223372036854775807L;
            } else {
                j4 = zzahf.zzf[zzb2];
                j5 = zzahf.zzc[zzb2];
            }
            j2 = j6;
        } else {
            j3 = Clock.MAX_TIME;
            j4 = -9223372036854775807L;
        }
        int i3 = 0;
        while (true) {
            zzagx[] zzagxArr2 = this.zzs;
            if (i3 >= zzagxArr2.length) {
                break;
            }
            if (i3 != this.zzu) {
                zzahf zzahf2 = zzagxArr2[i3].zzb;
                long zzj2 = zzj(zzahf2, j2, j3);
                if (j4 != -9223372036854775807L) {
                    j5 = zzj(zzahf2, j4, j5);
                }
                j3 = zzj2;
            }
            i3++;
        }
        zzabw zzabw3 = new zzabw(j2, j3);
        if (j4 == -9223372036854775807L) {
            return new zzabt(zzabw3, zzabw3);
        }
        return new zzabt(zzabw3, new zzabw(j4, j5));
    }

    public final boolean zzh() {
        return true;
    }

    public zzagy(int i2) {
        this.zzi = 0;
        this.zzg = new zzaha();
        this.zzh = new ArrayList();
        this.zze = new zzfa(16);
        this.zzf = new ArrayDeque();
        this.zzb = new zzfa(zzfu.zza);
        this.zzc = new zzfa(4);
        this.zzd = new zzfa();
        this.zzn = -1;
        this.zzr = zzaaz.zza;
        this.zzs = new zzagx[0];
    }
}
