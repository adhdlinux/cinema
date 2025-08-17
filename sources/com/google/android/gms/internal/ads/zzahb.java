package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzahb {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean zza(zzaax zzaax) throws IOException {
        return zzc(zzaax, true, false);
    }

    public static boolean zzb(zzaax zzaax, boolean z2) throws IOException {
        return zzc(zzaax, false, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d0, code lost:
        r10 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zzc(com.google.android.gms.internal.ads.zzaax r22, boolean r23, boolean r24) throws java.io.IOException {
        /*
            r0 = r22
            long r1 = r22.zzd()
            r3 = 4096(0x1000, double:2.0237E-320)
            r5 = -1
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0014
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r8 <= 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r3 = r1
        L_0x0014:
            com.google.android.gms.internal.ads.zzfa r8 = new com.google.android.gms.internal.ads.zzfa
            r9 = 64
            r8.<init>((int) r9)
            int r4 = (int) r3
            r3 = 0
            r9 = 0
            r10 = 0
        L_0x001f:
            r11 = 1
            if (r9 >= r4) goto L_0x00fa
            r12 = 8
            r8.zzC(r12)
            byte[] r13 = r8.zzH()
            boolean r13 = r0.zzm(r13, r3, r12, r11)
            if (r13 != 0) goto L_0x0033
            goto L_0x00fa
        L_0x0033:
            long r13 = r8.zzs()
            int r15 = r8.zze()
            r16 = 1
            int r18 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r18 != 0) goto L_0x0054
            byte[] r13 = r8.zzH()
            r0.zzh(r13, r12, r12)
            r13 = 16
            r8.zzE(r13)
            long r16 = r8.zzr()
            r5 = r16
            goto L_0x006f
        L_0x0054:
            r16 = 0
            int r18 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r18 != 0) goto L_0x006c
            long r16 = r22.zzd()
            int r18 = (r16 > r5 ? 1 : (r16 == r5 ? 0 : -1))
            if (r18 == 0) goto L_0x006c
            long r13 = r22.zze()
            long r16 = r16 - r13
            r13 = 8
            long r13 = r16 + r13
        L_0x006c:
            r5 = r13
            r13 = 8
        L_0x006f:
            long r11 = (long) r13
            int r18 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r18 >= 0) goto L_0x0075
            return r3
        L_0x0075:
            int r9 = r9 + r13
            r13 = 1836019574(0x6d6f6f76, float:4.631354E27)
            if (r15 != r13) goto L_0x0088
            int r6 = (int) r5
            int r4 = r4 + r6
            if (r7 == 0) goto L_0x0085
            long r5 = (long) r4
            int r11 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r11 <= 0) goto L_0x0085
            int r4 = (int) r1
        L_0x0085:
            r5 = -1
            goto L_0x001f
        L_0x0088:
            r13 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r15 == r13) goto L_0x00f8
            r13 = 1836475768(0x6d766578, float:4.7659988E27)
            if (r15 != r13) goto L_0x0094
            goto L_0x00f8
        L_0x0094:
            r13 = r15
            long r14 = (long) r9
            long r14 = r14 + r5
            r19 = r1
            long r1 = (long) r4
            long r14 = r14 - r11
            int r21 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r21 < 0) goto L_0x00a0
            goto L_0x00fa
        L_0x00a0:
            long r5 = r5 - r11
            int r1 = (int) r5
            int r9 = r9 + r1
            r2 = 1718909296(0x66747970, float:2.8862439E23)
            r5 = r13
            if (r5 != r2) goto L_0x00f0
            r2 = 8
            if (r1 >= r2) goto L_0x00ae
            return r3
        L_0x00ae:
            r8.zzC(r1)
            byte[] r2 = r8.zzH()
            r0.zzh(r2, r3, r1)
            int r1 = r1 >> 2
            r2 = 0
        L_0x00bb:
            if (r2 >= r1) goto L_0x00ec
            r5 = 1
            if (r2 != r5) goto L_0x00c5
            r5 = 4
            r8.zzG(r5)
            goto L_0x00e9
        L_0x00c5:
            int r5 = r8.zze()
            int r6 = r5 >>> 8
            r11 = 3368816(0x336770, float:4.720717E-39)
            if (r6 != r11) goto L_0x00d2
        L_0x00d0:
            r10 = 1
            goto L_0x00ec
        L_0x00d2:
            r6 = 1751476579(0x68656963, float:4.333464E24)
            if (r5 != r6) goto L_0x00da
            r5 = 1751476579(0x68656963, float:4.333464E24)
        L_0x00da:
            int[] r6 = zza
            r11 = 0
        L_0x00dd:
            r12 = 29
            if (r11 >= r12) goto L_0x00e9
            r12 = r6[r11]
            if (r12 != r5) goto L_0x00e6
            goto L_0x00d0
        L_0x00e6:
            int r11 = r11 + 1
            goto L_0x00dd
        L_0x00e9:
            int r2 = r2 + 1
            goto L_0x00bb
        L_0x00ec:
            if (r10 == 0) goto L_0x00ef
            goto L_0x00f5
        L_0x00ef:
            return r3
        L_0x00f0:
            if (r1 == 0) goto L_0x00f5
            r0.zzg(r1)
        L_0x00f5:
            r1 = r19
            goto L_0x0085
        L_0x00f8:
            r5 = 1
            goto L_0x00fb
        L_0x00fa:
            r5 = 0
        L_0x00fb:
            if (r10 == 0) goto L_0x0103
            r0 = r23
            if (r0 != r5) goto L_0x0103
            r0 = 1
            return r0
        L_0x0103:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahb.zzc(com.google.android.gms.internal.ads.zzaax, boolean, boolean):boolean");
    }
}
