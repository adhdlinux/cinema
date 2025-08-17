package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;

final class zzajq implements zzaji {
    final /* synthetic */ zzajr zza;
    private final zzez zzb = new zzez(new byte[5], 5);
    private final SparseArray zzc = new SparseArray();
    private final SparseIntArray zzd = new SparseIntArray();
    private final int zze;

    public zzajq(zzajr zzajr, int i2) {
        this.zza = zzajr;
        this.zze = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0118, code lost:
        if (r28.zzk() == 21) goto L_0x00d9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzfa r28) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            int r2 = r28.zzk()
            r3 = 2
            if (r2 == r3) goto L_0x000c
            return
        L_0x000c:
            com.google.android.gms.internal.ads.zzajr r2 = r0.zza
            java.util.List r2 = r2.zzb
            r4 = 0
            java.lang.Object r2 = r2.get(r4)
            com.google.android.gms.internal.ads.zzfh r2 = (com.google.android.gms.internal.ads.zzfh) r2
            int r5 = r28.zzk()
            r5 = r5 & 128(0x80, float:1.794E-43)
            if (r5 != 0) goto L_0x0022
            return
        L_0x0022:
            r5 = 1
            r1.zzG(r5)
            int r6 = r28.zzo()
            r7 = 3
            r1.zzG(r7)
            com.google.android.gms.internal.ads.zzez r8 = r0.zzb
            r1.zzA(r8, r3)
            com.google.android.gms.internal.ads.zzez r8 = r0.zzb
            r8.zzl(r7)
            com.google.android.gms.internal.ads.zzajr r8 = r0.zza
            com.google.android.gms.internal.ads.zzez r9 = r0.zzb
            r10 = 13
            int r9 = r9.zzd(r10)
            r8.zzq = r9
            com.google.android.gms.internal.ads.zzez r8 = r0.zzb
            r1.zzA(r8, r3)
            com.google.android.gms.internal.ads.zzez r3 = r0.zzb
            r8 = 4
            r3.zzl(r8)
            com.google.android.gms.internal.ads.zzez r3 = r0.zzb
            r9 = 12
            int r3 = r3.zzd(r9)
            r1.zzG(r3)
            android.util.SparseArray r3 = r0.zzc
            r3.clear()
            android.util.SparseIntArray r3 = r0.zzd
            r3.clear()
            int r3 = r28.zza()
        L_0x0069:
            if (r3 <= 0) goto L_0x01f0
            com.google.android.gms.internal.ads.zzez r11 = r0.zzb
            r12 = 5
            r1.zzA(r11, r12)
            com.google.android.gms.internal.ads.zzez r11 = r0.zzb
            r13 = 8
            int r11 = r11.zzd(r13)
            com.google.android.gms.internal.ads.zzez r13 = r0.zzb
            r13.zzl(r7)
            com.google.android.gms.internal.ads.zzez r13 = r0.zzb
            int r13 = r13.zzd(r10)
            com.google.android.gms.internal.ads.zzez r14 = r0.zzb
            r14.zzl(r8)
            com.google.android.gms.internal.ads.zzez r14 = r0.zzb
            int r14 = r14.zzd(r9)
            int r15 = r28.zzc()
            int r9 = r15 + r14
            r16 = 0
            r17 = -1
            r5 = r16
            r10 = r5
            r18 = -1
        L_0x009e:
            int r4 = r28.zzc()
            if (r4 >= r9) goto L_0x01a0
            int r4 = r28.zzk()
            int r19 = r28.zzk()
            int r20 = r28.zzc()
            int r8 = r20 + r19
            if (r8 <= r9) goto L_0x00b6
            goto L_0x01a0
        L_0x00b6:
            r19 = 172(0xac, float:2.41E-43)
            r20 = 135(0x87, float:1.89E-43)
            r22 = 129(0x81, float:1.81E-43)
            if (r4 != r12) goto L_0x00f4
            long r23 = r28.zzs()
            r25 = 1094921523(0x41432d33, double:5.409631094E-315)
            int r4 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
            if (r4 != 0) goto L_0x00ca
            goto L_0x00f8
        L_0x00ca:
            r25 = 1161904947(0x45414333, double:5.74057318E-315)
            int r4 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
            if (r4 != 0) goto L_0x00d2
            goto L_0x0105
        L_0x00d2:
            r25 = 1094921524(0x41432d34, double:5.4096311E-315)
            int r4 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
            if (r4 != 0) goto L_0x00e2
        L_0x00d9:
            r21 = r2
            r22 = r6
            r12 = 4
            r18 = 172(0xac, float:2.41E-43)
            goto L_0x018f
        L_0x00e2:
            r19 = 1212503619(0x48455643, double:5.990563836E-315)
            int r4 = (r23 > r19 ? 1 : (r23 == r19 ? 0 : -1))
            if (r4 != 0) goto L_0x011b
            r4 = 36
            r21 = r2
            r22 = r6
            r12 = 4
            r18 = 36
            goto L_0x018f
        L_0x00f4:
            r12 = 106(0x6a, float:1.49E-43)
            if (r4 != r12) goto L_0x0101
        L_0x00f8:
            r21 = r2
            r22 = r6
            r12 = 4
            r18 = 129(0x81, float:1.81E-43)
            goto L_0x018f
        L_0x0101:
            r12 = 122(0x7a, float:1.71E-43)
            if (r4 != r12) goto L_0x010e
        L_0x0105:
            r21 = r2
            r22 = r6
            r12 = 4
            r18 = 135(0x87, float:1.89E-43)
            goto L_0x018f
        L_0x010e:
            r12 = 127(0x7f, float:1.78E-43)
            if (r4 != r12) goto L_0x011e
            int r4 = r28.zzk()
            r12 = 21
            if (r4 != r12) goto L_0x011b
            goto L_0x00d9
        L_0x011b:
            r21 = r2
            goto L_0x013d
        L_0x011e:
            r12 = 123(0x7b, float:1.72E-43)
            if (r4 != r12) goto L_0x012c
            r4 = 138(0x8a, float:1.93E-43)
            r21 = r2
            r22 = r6
            r12 = 4
            r18 = 138(0x8a, float:1.93E-43)
            goto L_0x018f
        L_0x012c:
            r12 = 10
            if (r4 != r12) goto L_0x0141
            java.nio.charset.Charset r4 = com.google.android.gms.internal.ads.zzfot.zzc
            java.lang.String r4 = r1.zzx(r7, r4)
            java.lang.String r4 = r4.trim()
            r21 = r2
            r10 = r4
        L_0x013d:
            r22 = r6
            r12 = 4
            goto L_0x018f
        L_0x0141:
            r12 = 89
            if (r4 != r12) goto L_0x0182
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x014a:
            int r5 = r28.zzc()
            if (r5 >= r8) goto L_0x0179
            java.nio.charset.Charset r5 = com.google.android.gms.internal.ads.zzfot.zzc
            java.lang.String r5 = r1.zzx(r7, r5)
            java.lang.String r5 = r5.trim()
            int r7 = r28.zzk()
            r21 = r2
            r12 = 4
            byte[] r2 = new byte[r12]
            r22 = r6
            r6 = 0
            r1.zzB(r2, r6, r12)
            com.google.android.gms.internal.ads.zzajs r6 = new com.google.android.gms.internal.ads.zzajs
            r6.<init>(r5, r7, r2)
            r4.add(r6)
            r2 = r21
            r6 = r22
            r7 = 3
            r12 = 89
            goto L_0x014a
        L_0x0179:
            r21 = r2
            r22 = r6
            r12 = 4
            r5 = r4
            r18 = 89
            goto L_0x018f
        L_0x0182:
            r21 = r2
            r22 = r6
            r12 = 4
            r2 = 111(0x6f, float:1.56E-43)
            if (r4 != r2) goto L_0x018f
            r2 = 257(0x101, float:3.6E-43)
            r18 = 257(0x101, float:3.6E-43)
        L_0x018f:
            int r2 = r28.zzc()
            int r8 = r8 - r2
            r1.zzG(r8)
            r2 = r21
            r6 = r22
            r7 = 3
            r8 = 4
            r12 = 5
            goto L_0x009e
        L_0x01a0:
            r21 = r2
            r22 = r6
            r12 = 4
            r1.zzF(r9)
            com.google.android.gms.internal.ads.zzajt r2 = new com.google.android.gms.internal.ads.zzajt
            byte[] r4 = r28.zzH()
            byte[] r4 = java.util.Arrays.copyOfRange(r4, r15, r9)
            r6 = r18
            r2.<init>(r6, r10, r5, r4)
            r4 = 6
            if (r11 == r4) goto L_0x01bd
            r4 = 5
            if (r11 != r4) goto L_0x01bf
        L_0x01bd:
            int r11 = r2.zza
        L_0x01bf:
            int r14 = r14 + 5
            int r3 = r3 - r14
            com.google.android.gms.internal.ads.zzajr r4 = r0.zza
            android.util.SparseBooleanArray r4 = r4.zzg
            boolean r4 = r4.get(r13)
            if (r4 != 0) goto L_0x01e2
            com.google.android.gms.internal.ads.zzajr r4 = r0.zza
            com.google.android.gms.internal.ads.zzaju r4 = r4.zze
            com.google.android.gms.internal.ads.zzajw r2 = r4.zza(r11, r2)
            android.util.SparseIntArray r4 = r0.zzd
            r4.put(r13, r13)
            android.util.SparseArray r4 = r0.zzc
            r4.put(r13, r2)
        L_0x01e2:
            r2 = r21
            r6 = r22
            r4 = 0
            r5 = 1
            r7 = 3
            r8 = 4
            r9 = 12
            r10 = 13
            goto L_0x0069
        L_0x01f0:
            r21 = r2
            r22 = r6
            android.util.SparseIntArray r1 = r0.zzd
            int r1 = r1.size()
            r6 = 0
        L_0x01fb:
            if (r6 >= r1) goto L_0x024f
            android.util.SparseIntArray r2 = r0.zzd
            int r2 = r2.keyAt(r6)
            android.util.SparseIntArray r3 = r0.zzd
            int r3 = r3.valueAt(r6)
            com.google.android.gms.internal.ads.zzajr r4 = r0.zza
            android.util.SparseBooleanArray r4 = r4.zzg
            r5 = 1
            r4.put(r2, r5)
            com.google.android.gms.internal.ads.zzajr r4 = r0.zza
            android.util.SparseBooleanArray r4 = r4.zzh
            r4.put(r3, r5)
            android.util.SparseArray r4 = r0.zzc
            java.lang.Object r4 = r4.valueAt(r6)
            com.google.android.gms.internal.ads.zzajw r4 = (com.google.android.gms.internal.ads.zzajw) r4
            if (r4 == 0) goto L_0x0244
            com.google.android.gms.internal.ads.zzajr r5 = r0.zza
            com.google.android.gms.internal.ads.zzaaz r5 = r5.zzk
            com.google.android.gms.internal.ads.zzajv r7 = new com.google.android.gms.internal.ads.zzajv
            r8 = 8192(0x2000, float:1.14794E-41)
            r9 = r22
            r7.<init>(r9, r2, r8)
            r2 = r21
            r4.zzb(r2, r5, r7)
            com.google.android.gms.internal.ads.zzajr r5 = r0.zza
            android.util.SparseArray r5 = r5.zzf
            r5.put(r3, r4)
            goto L_0x0248
        L_0x0244:
            r2 = r21
            r9 = r22
        L_0x0248:
            int r6 = r6 + 1
            r21 = r2
            r22 = r9
            goto L_0x01fb
        L_0x024f:
            com.google.android.gms.internal.ads.zzajr r1 = r0.zza
            android.util.SparseArray r1 = r1.zzf
            int r2 = r0.zze
            r1.remove(r2)
            com.google.android.gms.internal.ads.zzajr r1 = r0.zza
            r2 = 0
            r1.zzl = r2
            com.google.android.gms.internal.ads.zzajr r1 = r0.zza
            int r2 = r1.zzl
            if (r2 != 0) goto L_0x0275
            com.google.android.gms.internal.ads.zzaaz r1 = r1.zzk
            r1.zzC()
            com.google.android.gms.internal.ads.zzajr r1 = r0.zza
            r2 = 1
            r1.zzm = true
        L_0x0275:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajq.zza(com.google.android.gms.internal.ads.zzfa):void");
    }

    public final void zzb(zzfh zzfh, zzaaz zzaaz, zzajv zzajv) {
    }
}
