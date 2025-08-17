package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class zzagn {
    private static final byte[] zza = "OpusHead".getBytes(zzfot.zzc);

    static {
        int i2 = zzfj.zza;
    }

    public static zzbz zza(zzagc zzagc) {
        zzfn zzfn;
        zzagd zzb = zzagc.zzb(1751411826);
        zzagd zzb2 = zzagc.zzb(1801812339);
        zzagd zzb3 = zzagc.zzb(1768715124);
        if (zzb == null || zzb2 == null || zzb3 == null || zzg(zzb.zza) != 1835299937) {
            return null;
        }
        zzfa zzfa = zzb2.zza;
        zzfa.zzF(12);
        int zze = zzfa.zze();
        String[] strArr = new String[zze];
        for (int i2 = 0; i2 < zze; i2++) {
            int zze2 = zzfa.zze();
            zzfa.zzG(4);
            strArr[i2] = zzfa.zzx(zze2 - 8, zzfot.zzc);
        }
        zzfa zzfa2 = zzb3.zza;
        zzfa2.zzF(8);
        ArrayList arrayList = new ArrayList();
        while (zzfa2.zza() > 8) {
            int zzc = zzfa2.zzc();
            int zze3 = zzfa2.zze();
            int zze4 = zzfa2.zze() - 1;
            if (zze4 < 0 || zze4 >= zze) {
                zzer.zzf("AtomParsers", "Skipped metadata with unknown key index: " + zze4);
            } else {
                String str = strArr[zze4];
                int i3 = zzc + zze3;
                int i4 = zzagu.zzb;
                while (true) {
                    int zzc2 = zzfa2.zzc();
                    if (zzc2 >= i3) {
                        zzfn = null;
                        break;
                    }
                    int zze5 = zzfa2.zze();
                    if (zzfa2.zze() == 1684108385) {
                        int zze6 = zzfa2.zze();
                        int zze7 = zzfa2.zze();
                        int i5 = zze5 - 16;
                        byte[] bArr = new byte[i5];
                        zzfa2.zzB(bArr, 0, i5);
                        zzfn = new zzfn(str, bArr, zze7, zze6);
                        break;
                    }
                    zzfa2.zzF(zzc2 + zze5);
                }
                if (zzfn != null) {
                    arrayList.add(zzfn);
                }
            }
            zzfa2.zzF(zzc + zze3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzbz((List) arrayList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0074, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b0, code lost:
        if (r3 != 13) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        r3 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzagm zzb(com.google.android.gms.internal.ads.zzagd r12) {
        /*
            com.google.android.gms.internal.ads.zzfa r12 = r12.zza
            r0 = 8
            r12.zzF(r0)
            r1 = 0
            r2 = r1
            r3 = r2
            r4 = r3
        L_0x000b:
            int r5 = r12.zza()
            if (r5 < r0) goto L_0x00eb
            int r5 = r12.zzc()
            int r6 = r12.zze()
            int r7 = r12.zze()
            r8 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r7 != r8) goto L_0x0077
            r12.zzF(r5)
            int r2 = r5 + r6
            r12.zzG(r0)
            zzd(r12)
        L_0x002d:
            int r7 = r12.zzc()
            if (r7 >= r2) goto L_0x0074
            int r7 = r12.zzc()
            int r8 = r12.zze()
            int r9 = r12.zze()
            r10 = 1768715124(0x696c7374, float:1.7865732E25)
            if (r9 != r10) goto L_0x006f
            r12.zzF(r7)
            int r7 = r7 + r8
            r12.zzG(r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x0050:
            int r8 = r12.zzc()
            if (r8 >= r7) goto L_0x0060
            com.google.android.gms.internal.ads.zzby r8 = com.google.android.gms.internal.ads.zzagu.zza(r12)
            if (r8 == 0) goto L_0x0050
            r2.add(r8)
            goto L_0x0050
        L_0x0060:
            boolean r7 = r2.isEmpty()
            if (r7 == 0) goto L_0x0067
            goto L_0x0074
        L_0x0067:
            com.google.android.gms.internal.ads.zzbz r7 = new com.google.android.gms.internal.ads.zzbz
            r7.<init>((java.util.List) r2)
            r2 = r7
            goto L_0x00e5
        L_0x006f:
            int r7 = r7 + r8
            r12.zzF(r7)
            goto L_0x002d
        L_0x0074:
            r2 = r1
            goto L_0x00e5
        L_0x0077:
            r8 = 1936553057(0x736d7461, float:1.8813092E31)
            if (r7 != r8) goto L_0x00dc
            r12.zzF(r5)
            int r3 = r5 + r6
            r7 = 12
            r12.zzG(r7)
        L_0x0086:
            int r8 = r12.zzc()
            if (r8 >= r3) goto L_0x00da
            int r8 = r12.zzc()
            int r9 = r12.zze()
            int r10 = r12.zze()
            r11 = 1935766900(0x73617574, float:1.7862687E31)
            if (r10 != r11) goto L_0x00d5
            r3 = 14
            if (r9 >= r3) goto L_0x00a2
            goto L_0x00da
        L_0x00a2:
            r3 = 5
            r12.zzG(r3)
            int r3 = r12.zzk()
            r8 = 1123024896(0x42f00000, float:120.0)
            if (r3 == r7) goto L_0x00b3
            r7 = 13
            if (r3 == r7) goto L_0x00b7
            goto L_0x00da
        L_0x00b3:
            if (r3 != r7) goto L_0x00b7
            r8 = 1131413504(0x43700000, float:240.0)
        L_0x00b7:
            r3 = 1
            r12.zzG(r3)
            int r7 = r12.zzk()
            com.google.android.gms.internal.ads.zzbz r9 = new com.google.android.gms.internal.ads.zzbz
            com.google.android.gms.internal.ads.zzby[] r3 = new com.google.android.gms.internal.ads.zzby[r3]
            com.google.android.gms.internal.ads.zzafd r10 = new com.google.android.gms.internal.ads.zzafd
            r10.<init>((float) r8, (int) r7)
            r7 = 0
            r3[r7] = r10
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9.<init>(r7, r3)
            r3 = r9
            goto L_0x00e5
        L_0x00d5:
            int r8 = r8 + r9
            r12.zzF(r8)
            goto L_0x0086
        L_0x00da:
            r3 = r1
            goto L_0x00e5
        L_0x00dc:
            r8 = -1451722374(0xffffffffa978797a, float:-5.5172426E-14)
            if (r7 != r8) goto L_0x00e5
            com.google.android.gms.internal.ads.zzbz r4 = zzk(r12)
        L_0x00e5:
            int r5 = r5 + r6
            r12.zzF(r5)
            goto L_0x000b
        L_0x00eb:
            com.google.android.gms.internal.ads.zzagm r12 = new com.google.android.gms.internal.ads.zzagm
            r12.<init>(r2, r3, r4)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagn.zzb(com.google.android.gms.internal.ads.zzagd):com.google.android.gms.internal.ads.zzagm");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c7, code lost:
        r21 = r9;
        r8 = -9223372036854775807L;
     */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x07f5  */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x08a3  */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x0a4f  */
    /* JADX WARNING: Removed duplicated region for block: B:485:0x0b31 A[LOOP:11: B:485:0x0b31->B:489:0x0b3b, LOOP_START, PHI: r21 
      PHI: (r21v3 int) = (r21v2 int), (r21v4 int) binds: [B:484:0x0b2f, B:489:0x0b3b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:492:0x0b44  */
    /* JADX WARNING: Removed duplicated region for block: B:503:0x0b97  */
    /* JADX WARNING: Removed duplicated region for block: B:507:0x0be4  */
    /* JADX WARNING: Removed duplicated region for block: B:508:0x0be7  */
    /* JADX WARNING: Removed duplicated region for block: B:513:0x0c0a  */
    /* JADX WARNING: Removed duplicated region for block: B:514:0x0c22  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:602:0x0e74  */
    /* JADX WARNING: Removed duplicated region for block: B:610:0x0e83 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:637:0x0b26 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x018a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List zzc(com.google.android.gms.internal.ads.zzagc r58, com.google.android.gms.internal.ads.zzabl r59, long r60, com.google.android.gms.internal.ads.zzad r62, boolean r63, boolean r64, com.google.android.gms.internal.ads.zzfov r65) throws com.google.android.gms.internal.ads.zzcd {
        /*
            r0 = r58
            r1 = r59
            r12 = r62
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            r15 = 0
        L_0x000c:
            java.util.List r2 = r0.zzc
            int r2 = r2.size()
            if (r15 >= r2) goto L_0x0e8b
            java.util.List r2 = r0.zzc
            java.lang.Object r2 = r2.get(r15)
            r11 = r2
            com.google.android.gms.internal.ads.zzagc r11 = (com.google.android.gms.internal.ads.zzagc) r11
            int r2 = r11.zzd
            r3 = 1953653099(0x7472616b, float:7.681346E31)
            if (r2 == r3) goto L_0x002a
            r2 = r13
            r31 = r15
        L_0x0027:
            r0 = 0
            goto L_0x0e78
        L_0x002a:
            r2 = 1836476516(0x6d766864, float:4.7662196E27)
            com.google.android.gms.internal.ads.zzagd r2 = r0.zzb(r2)
            r2.getClass()
            r10 = 1835297121(0x6d646961, float:4.4181236E27)
            com.google.android.gms.internal.ads.zzagc r3 = r11.zza(r10)
            r3.getClass()
            r4 = 1751411826(0x68646c72, float:4.3148E24)
            com.google.android.gms.internal.ads.zzagd r4 = r3.zzb(r4)
            r4.getClass()
            com.google.android.gms.internal.ads.zzfa r4 = r4.zza
            int r4 = zzg(r4)
            int r9 = zze(r4)
            java.lang.String r6 = "AtomParsers"
            r31 = r15
            r14 = 0
            r8 = -1
            if (r9 != r8) goto L_0x0065
            r0 = r65
            r2 = r6
            r4 = r11
            r34 = r13
            r1 = -1
        L_0x0062:
            r5 = 0
            goto L_0x089a
        L_0x0065:
            r4 = 1953196132(0x746b6864, float:7.46037E31)
            com.google.android.gms.internal.ads.zzagd r4 = r11.zzb(r4)
            r4.getClass()
            com.google.android.gms.internal.ads.zzfa r4 = r4.zza
            r5 = 8
            r4.zzF(r5)
            int r21 = r4.zze()
            int r21 = com.google.android.gms.internal.ads.zzage.zze(r21)
            if (r21 != 0) goto L_0x0083
            r10 = 8
            goto L_0x0085
        L_0x0083:
            r10 = 16
        L_0x0085:
            r4.zzG(r10)
            int r10 = r4.zze()
            r5 = 4
            r4.zzG(r5)
            int r25 = r4.zzc()
            r5 = 0
        L_0x0095:
            if (r21 != 0) goto L_0x0099
            r7 = 4
            goto L_0x009b
        L_0x0099:
            r7 = 8
        L_0x009b:
            r28 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r5 >= r7) goto L_0x00c4
            byte[] r7 = r4.zzH()
            int r30 = r25 + r5
            byte r7 = r7[r30]
            if (r7 == r8) goto L_0x00c1
            if (r21 != 0) goto L_0x00b3
            long r32 = r4.zzs()
            goto L_0x00b7
        L_0x00b3:
            long r32 = r4.zzt()
        L_0x00b7:
            int r5 = (r32 > r14 ? 1 : (r32 == r14 ? 0 : -1))
            if (r5 != 0) goto L_0x00bc
            goto L_0x00c7
        L_0x00bc:
            r21 = r9
            r8 = r32
            goto L_0x00cb
        L_0x00c1:
            int r5 = r5 + 1
            goto L_0x0095
        L_0x00c4:
            r4.zzG(r7)
        L_0x00c7:
            r21 = r9
            r8 = r28
        L_0x00cb:
            r7 = 16
            r4.zzG(r7)
            int r5 = r4.zze()
            int r7 = r4.zze()
            r14 = 4
            r4.zzG(r14)
            int r14 = r4.zze()
            int r4 = r4.zze()
            r15 = 65536(0x10000, float:9.18355E-41)
            r0 = -65536(0xffffffffffff0000, float:NaN)
            if (r5 != 0) goto L_0x00fe
            if (r7 != r15) goto L_0x00fd
            if (r14 != r0) goto L_0x00f9
            if (r4 != 0) goto L_0x00f3
            r0 = 90
            goto L_0x011e
        L_0x00f3:
            r5 = 0
            r7 = 65536(0x10000, float:9.18355E-41)
            r14 = -65536(0xffffffffffff0000, float:NaN)
            goto L_0x00fe
        L_0x00f9:
            r5 = 0
            r7 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00fe
        L_0x00fd:
            r5 = 0
        L_0x00fe:
            if (r5 != 0) goto L_0x0111
            if (r7 != r0) goto L_0x010e
            if (r14 != r15) goto L_0x0109
            if (r4 != 0) goto L_0x010a
            r0 = 270(0x10e, float:3.78E-43)
            goto L_0x011e
        L_0x0109:
            r15 = r14
        L_0x010a:
            r5 = 0
            r7 = -65536(0xffffffffffff0000, float:NaN)
            goto L_0x0112
        L_0x010e:
            r15 = r14
            r5 = 0
            goto L_0x0112
        L_0x0111:
            r15 = r14
        L_0x0112:
            if (r5 != r0) goto L_0x011d
            if (r7 != 0) goto L_0x011d
            if (r15 != 0) goto L_0x011d
            if (r4 != r0) goto L_0x011d
            r0 = 180(0xb4, float:2.52E-43)
            goto L_0x011e
        L_0x011d:
            r0 = 0
        L_0x011e:
            com.google.android.gms.internal.ads.zzagl r14 = new com.google.android.gms.internal.ads.zzagl
            r14.<init>(r10, r8, r0)
            int r0 = (r60 > r28 ? 1 : (r60 == r28 ? 0 : -1))
            if (r0 != 0) goto L_0x012e
            long r4 = r14.zzb
            r34 = r4
            goto L_0x0130
        L_0x012e:
            r34 = r60
        L_0x0130:
            com.google.android.gms.internal.ads.zzfa r0 = r2.zza
            r2 = 8
            r0.zzF(r2)
            int r4 = r0.zze()
            int r4 = com.google.android.gms.internal.ads.zzage.zze(r4)
            if (r4 != 0) goto L_0x0144
            r5 = 8
            goto L_0x0146
        L_0x0144:
            r5 = 16
        L_0x0146:
            r0.zzG(r5)
            long r40 = r0.zzs()
            int r0 = (r34 > r28 ? 1 : (r34 == r28 ? 0 : -1))
            if (r0 != 0) goto L_0x0152
            goto L_0x015d
        L_0x0152:
            r36 = 1000000(0xf4240, double:4.940656E-318)
            r38 = r40
            long r4 = com.google.android.gms.internal.ads.zzfj.zzp(r34, r36, r38)
            r28 = r4
        L_0x015d:
            r0 = 1835626086(0x6d696e66, float:4.515217E27)
            com.google.android.gms.internal.ads.zzagc r2 = r3.zza(r0)
            r2.getClass()
            r8 = 1937007212(0x7374626c, float:1.9362132E31)
            com.google.android.gms.internal.ads.zzagc r2 = r2.zza(r8)
            r2.getClass()
            r4 = 1835296868(0x6d646864, float:4.418049E27)
            com.google.android.gms.internal.ads.zzagd r3 = r3.zzb(r4)
            r3.getClass()
            com.google.android.gms.internal.ads.zzfa r3 = r3.zza
            android.util.Pair r15 = zzi(r3)
            r3 = 1937011556(0x73747364, float:1.9367383E31)
            com.google.android.gms.internal.ads.zzagd r2 = r2.zzb(r3)
            if (r2 == 0) goto L_0x0e83
            com.google.android.gms.internal.ads.zzfa r10 = r2.zza
            int r9 = r14.zza
            int r7 = r14.zzc
            java.lang.Object r2 = r15.second
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            r4 = 12
            r10.zzF(r4)
            int r3 = r10.zze()
            com.google.android.gms.internal.ads.zzagi r2 = new com.google.android.gms.internal.ads.zzagi
            r2.<init>(r3)
            r0 = 0
        L_0x01a8:
            if (r0 >= r3) goto L_0x0838
            r34 = r13
            int r13 = r10.zzc()
            int r1 = r10.zze()
            if (r1 <= 0) goto L_0x01b8
            r4 = 1
            goto L_0x01b9
        L_0x01b8:
            r4 = 0
        L_0x01b9:
            java.lang.String r8 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzaba.zzb(r4, r8)
            int r4 = r10.zze()
            r8 = 1635148593(0x61766331, float:2.840654E20)
            r24 = r3
            r3 = 1701733238(0x656e6376, float:7.035987E22)
            if (r4 == r8) goto L_0x03b1
            r8 = 1635148595(0x61766333, float:2.8406544E20)
            if (r4 == r8) goto L_0x03b1
            if (r4 == r3) goto L_0x03b1
            r8 = 1831958048(0x6d317620, float:3.4326032E27)
            if (r4 == r8) goto L_0x03b1
            r8 = 1836070006(0x6d703476, float:4.646239E27)
            if (r4 == r8) goto L_0x03b1
            r8 = 1752589105(0x68766331, float:4.6541277E24)
            if (r4 == r8) goto L_0x03b1
            r8 = 1751479857(0x68657631, float:4.3344087E24)
            if (r4 == r8) goto L_0x03b1
            r8 = 1932670515(0x73323633, float:1.4119387E31)
            if (r4 == r8) goto L_0x03b1
            r8 = 1211250227(0x48323633, float:182488.8)
            if (r4 == r8) goto L_0x03b1
            r8 = 1987063864(0x76703038, float:1.21789965E33)
            if (r4 == r8) goto L_0x03b1
            r8 = 1987063865(0x76703039, float:1.2178997E33)
            if (r4 == r8) goto L_0x03b1
            r8 = 1635135537(0x61763031, float:2.8383572E20)
            if (r4 == r8) goto L_0x03b1
            r8 = 1685479798(0x64766176, float:1.8179687E22)
            if (r4 == r8) goto L_0x03b1
            r8 = 1685479729(0x64766131, float:1.817961E22)
            if (r4 == r8) goto L_0x03b1
            r8 = 1685481573(0x64766865, float:1.8181686E22)
            if (r4 == r8) goto L_0x03b1
            r8 = 1685481521(0x64766831, float:1.8181627E22)
            if (r4 != r8) goto L_0x0216
            goto L_0x03b1
        L_0x0216:
            r3 = 1836069985(0x6d703461, float:4.6462328E27)
            if (r4 == r3) goto L_0x0370
            r3 = 1701733217(0x656e6361, float:7.0359778E22)
            if (r4 == r3) goto L_0x0370
            r3 = 1633889587(0x61632d33, float:2.6191674E20)
            if (r4 == r3) goto L_0x0370
            r3 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r4 == r3) goto L_0x0370
            r3 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r4 == r3) goto L_0x0370
            r3 = 1835823201(0x6d6c7061, float:4.573395E27)
            if (r4 == r3) goto L_0x0370
            r3 = 1685353315(0x64747363, float:1.803728E22)
            if (r4 == r3) goto L_0x0370
            r3 = 1685353317(0x64747365, float:1.8037282E22)
            if (r4 == r3) goto L_0x0370
            r3 = 1685353320(0x64747368, float:1.8037286E22)
            if (r4 == r3) goto L_0x0370
            r3 = 1685353324(0x6474736c, float:1.803729E22)
            if (r4 == r3) goto L_0x0370
            r3 = 1685353336(0x64747378, float:1.8037304E22)
            if (r4 == r3) goto L_0x0370
            r3 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r4 == r3) goto L_0x0370
            r3 = 1935767394(0x73617762, float:1.7863284E31)
            if (r4 == r3) goto L_0x0370
            r3 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r4 == r3) goto L_0x0370
            r3 = 1936684916(0x736f7774, float:1.89725E31)
            if (r4 == r3) goto L_0x0370
            r3 = 1953984371(0x74776f73, float:7.841539E31)
            if (r4 == r3) goto L_0x0370
            r3 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r4 == r3) goto L_0x0370
            r3 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r4 == r3) goto L_0x0370
            r3 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r4 == r3) goto L_0x0370
            r3 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r4 == r3) goto L_0x0370
            r3 = 1634492771(0x616c6163, float:2.7252807E20)
            if (r4 == r3) goto L_0x0370
            r3 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r4 == r3) goto L_0x0370
            r3 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r4 == r3) goto L_0x0370
            r3 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r4 == r3) goto L_0x0370
            r3 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r4 != r3) goto L_0x029a
            r8 = r2
            r35 = r5
            r30 = r6
            goto L_0x0375
        L_0x029a:
            r3 = 1414810956(0x54544d4c, float:3.64731957E12)
            if (r4 == r3) goto L_0x02f0
            r3 = 1954034535(0x74783367, float:7.865797E31)
            if (r4 == r3) goto L_0x02f0
            r3 = 2004251764(0x77767474, float:4.998699E33)
            if (r4 == r3) goto L_0x02f0
            r3 = 1937010800(0x73747070, float:1.9366469E31)
            if (r4 == r3) goto L_0x02f0
            r3 = 1664495672(0x63363038, float:3.360782E21)
            if (r4 != r3) goto L_0x02b4
            goto L_0x02f0
        L_0x02b4:
            r3 = 1835365492(0x6d657474, float:4.4383032E27)
            if (r4 != r3) goto L_0x02c0
            r3 = 1835365492(0x6d657474, float:4.4383032E27)
            zzo(r10, r3, r13, r9, r2)
            goto L_0x02d8
        L_0x02c0:
            r3 = 1667329389(0x63616d6d, float:4.1584024E21)
            if (r4 != r3) goto L_0x02d8
            com.google.android.gms.internal.ads.zzak r3 = new com.google.android.gms.internal.ads.zzak
            r3.<init>()
            r3.zzG(r9)
            java.lang.String r4 = "application/x-camera-motion"
            r3.zzS(r4)
            com.google.android.gms.internal.ads.zzam r3 = r3.zzY()
            r2.zzb = r3
        L_0x02d8:
            r22 = r0
            r30 = r1
            r3 = r2
            r19 = r5
            r2 = r6
            r5 = r7
            r4 = r9
            r36 = r11
            r38 = r13
            r20 = r14
            r16 = r15
            r18 = r21
            r1 = -1
            r15 = r10
            goto L_0x0813
        L_0x02f0:
            int r3 = r13 + 16
            r10.zzF(r3)
            r3 = 1414810956(0x54544d4c, float:3.64731957E12)
            r35 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r4 != r3) goto L_0x0305
            java.lang.String r3 = "application/ttml+xml"
        L_0x0301:
            r42 = r35
            r4 = 0
            goto L_0x0339
        L_0x0305:
            r3 = 1954034535(0x74783367, float:7.865797E31)
            if (r4 != r3) goto L_0x0320
            int r3 = r1 + -16
            byte[] r4 = new byte[r3]
            r8 = 0
            r10.zzB(r4, r8, r3)
            com.google.android.gms.internal.ads.zzfsc r3 = com.google.android.gms.internal.ads.zzfsc.zzm(r4)
            java.lang.String r4 = "application/x-quicktime-tx3g"
            r42 = r35
            r56 = r4
            r4 = r3
            r3 = r56
            goto L_0x0339
        L_0x0320:
            r3 = 2004251764(0x77767474, float:4.998699E33)
            if (r4 != r3) goto L_0x0328
            java.lang.String r3 = "application/x-mp4-vtt"
            goto L_0x0301
        L_0x0328:
            r3 = 1937010800(0x73747070, float:1.9366469E31)
            if (r4 != r3) goto L_0x0333
            java.lang.String r3 = "application/ttml+xml"
            r4 = 0
            r42 = 0
            goto L_0x0339
        L_0x0333:
            r8 = 1
            r2.zzd = r8
            java.lang.String r3 = "application/x-mp4-cea-608"
            goto L_0x0301
        L_0x0339:
            com.google.android.gms.internal.ads.zzak r8 = new com.google.android.gms.internal.ads.zzak
            r8.<init>()
            r8.zzG(r9)
            r8.zzS(r3)
            r8.zzK(r5)
            r35 = r5
            r30 = r6
            r5 = r42
            r8.zzW(r5)
            r8.zzI(r4)
            com.google.android.gms.internal.ads.zzam r3 = r8.zzY()
            r2.zzb = r3
            r22 = r0
            r3 = r2
            r5 = r7
            r4 = r9
            r36 = r11
            r38 = r13
            r20 = r14
            r16 = r15
            r18 = r21
            r2 = r30
            r19 = r35
            r30 = r1
            r15 = r10
            goto L_0x03ae
        L_0x0370:
            r35 = r5
            r30 = r6
            r8 = r2
        L_0x0375:
            r2 = r10
            r3 = r4
            r5 = 12
            r6 = 2
            r4 = r13
            r16 = r15
            r19 = r35
            r15 = 0
            r5 = r1
            r44 = r30
            r6 = r9
            r45 = r7
            r15 = 16
            r7 = r19
            r17 = r8
            r8 = r64
            r46 = r9
            r18 = r21
            r9 = r62
            r15 = r10
            r10 = r17
            r20 = r14
            r14 = r11
            r11 = r0
            zzn(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r22 = r0
            r30 = r1
            r38 = r13
            r36 = r14
            r3 = r17
            r2 = r44
            r5 = r45
            r4 = r46
        L_0x03ae:
            r1 = -1
            goto L_0x0813
        L_0x03b1:
            r17 = r2
            r19 = r5
            r44 = r6
            r45 = r7
            r46 = r9
            r20 = r14
            r16 = r15
            r18 = r21
            r15 = r10
            r14 = r11
            int r2 = r13 + 16
            r15.zzF(r2)
            r2 = 16
            r15.zzG(r2)
            int r5 = r15.zzo()
            int r6 = r15.zzo()
            r7 = 50
            r15.zzG(r7)
            int r7 = r15.zzc()
            if (r4 != r3) goto L_0x0414
            android.util.Pair r4 = zzj(r15, r13, r1)
            if (r4 == 0) goto L_0x040a
            java.lang.Object r3 = r4.first
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r12 != 0) goto L_0x03f4
            r9 = r17
            r8 = 0
            goto L_0x0400
        L_0x03f4:
            java.lang.Object r8 = r4.second
            com.google.android.gms.internal.ads.zzahd r8 = (com.google.android.gms.internal.ads.zzahd) r8
            java.lang.String r8 = r8.zzb
            com.google.android.gms.internal.ads.zzad r8 = r12.zzb(r8)
            r9 = r17
        L_0x0400:
            com.google.android.gms.internal.ads.zzahd[] r10 = r9.zza
            java.lang.Object r4 = r4.second
            com.google.android.gms.internal.ads.zzahd r4 = (com.google.android.gms.internal.ads.zzahd) r4
            r10[r0] = r4
            r4 = r3
            goto L_0x0410
        L_0x040a:
            r9 = r17
            r8 = r12
            r4 = 1701733238(0x656e6376, float:7.035987E22)
        L_0x0410:
            r15.zzF(r7)
            goto L_0x0417
        L_0x0414:
            r9 = r17
            r8 = r12
        L_0x0417:
            r3 = 1831958048(0x6d317620, float:3.4326032E27)
            if (r4 != r3) goto L_0x0424
            java.lang.String r3 = "video/mpeg"
            r56 = r4
            r4 = r3
            r3 = r56
            goto L_0x042e
        L_0x0424:
            r3 = 1211250227(0x48323633, float:182488.8)
            if (r4 != r3) goto L_0x042c
            java.lang.String r4 = "video/3gpp"
            goto L_0x042e
        L_0x042c:
            r3 = r4
            r4 = 0
        L_0x042e:
            r10 = 1065353216(0x3f800000, float:1.0)
            r22 = r0
            r23 = r8
            r36 = r14
            r0 = -1
            r2 = 0
            r8 = -1
            r11 = 1065353216(0x3f800000, float:1.0)
            r12 = 0
            r17 = 0
            r21 = 0
            r25 = 0
            r26 = -1
            r47 = -1
            r14 = r7
            r7 = r4
            r4 = 0
        L_0x0449:
            int r10 = r14 - r13
            if (r10 >= r1) goto L_0x0775
            r15.zzF(r14)
            int r10 = r15.zzc()
            int r30 = r15.zze()
            if (r30 != 0) goto L_0x0474
            int r30 = r15.zzc()
            r37 = r12
            int r12 = r30 - r13
            if (r12 != r1) goto L_0x0472
            r30 = r1
            r55 = r2
            r50 = r5
            r49 = r6
            r43 = r9
            r48 = r11
            goto L_0x0783
        L_0x0472:
            r12 = 0
            goto L_0x0478
        L_0x0474:
            r37 = r12
            r12 = r30
        L_0x0478:
            if (r12 <= 0) goto L_0x0480
            r30 = r1
            r38 = r13
            r1 = 1
            goto L_0x0485
        L_0x0480:
            r30 = r1
            r38 = r13
            r1 = 0
        L_0x0485:
            java.lang.String r13 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzaba.zzb(r1, r13)
            int r1 = r15.zze()
            r13 = 1635148611(0x61766343, float:2.8406573E20)
            if (r1 != r13) goto L_0x04cf
            if (r7 != 0) goto L_0x0497
            r0 = 1
            goto L_0x0498
        L_0x0497:
            r0 = 0
        L_0x0498:
            r1 = 0
            com.google.android.gms.internal.ads.zzaba.zzb(r0, r1)
            int r10 = r10 + 8
            r15.zzF(r10)
            com.google.android.gms.internal.ads.zzaab r0 = com.google.android.gms.internal.ads.zzaab.zza(r15)
            java.util.List r1 = r0.zza
            int r2 = r0.zzb
            r9.zzc = r2
            if (r4 != 0) goto L_0x04af
            float r11 = r0.zzh
        L_0x04af:
            java.lang.String r2 = r0.zzi
            int r7 = r0.zze
            int r8 = r0.zzf
            int r0 = r0.zzg
            java.lang.String r10 = "video/avc"
        L_0x04b9:
            r25 = r1
            r55 = r2
            r39 = r3
            r50 = r5
            r49 = r6
            r47 = r8
            r43 = r9
            r2 = r44
            r1 = -1
            r8 = r0
            r0 = r7
            r7 = r10
            goto L_0x0760
        L_0x04cf:
            r13 = 1752589123(0x68766343, float:4.6541328E24)
            if (r1 != r13) goto L_0x04fb
            if (r7 != 0) goto L_0x04d8
            r0 = 1
            goto L_0x04d9
        L_0x04d8:
            r0 = 0
        L_0x04d9:
            r1 = 0
            com.google.android.gms.internal.ads.zzaba.zzb(r0, r1)
            int r10 = r10 + 8
            r15.zzF(r10)
            com.google.android.gms.internal.ads.zzabm r0 = com.google.android.gms.internal.ads.zzabm.zza(r15)
            java.util.List r1 = r0.zza
            int r2 = r0.zzb
            r9.zzc = r2
            if (r4 != 0) goto L_0x04f0
            float r11 = r0.zzf
        L_0x04f0:
            java.lang.String r2 = r0.zzg
            int r7 = r0.zzc
            int r8 = r0.zzd
            int r0 = r0.zze
            java.lang.String r10 = "video/hevc"
            goto L_0x04b9
        L_0x04fb:
            r13 = 1685480259(0x64766343, float:1.8180206E22)
            if (r1 == r13) goto L_0x073e
            r13 = 1685485123(0x64767643, float:1.8185683E22)
            if (r1 != r13) goto L_0x0507
            goto L_0x073e
        L_0x0507:
            r13 = 1987076931(0x76706343, float:1.21891066E33)
            if (r1 != r13) goto L_0x0552
            if (r7 != 0) goto L_0x0510
            r0 = 1
            goto L_0x0511
        L_0x0510:
            r0 = 0
        L_0x0511:
            r1 = 0
            com.google.android.gms.internal.ads.zzaba.zzb(r0, r1)
            int r10 = r10 + 12
            r15.zzF(r10)
            r13 = 2
            r15.zzG(r13)
            int r0 = r15.zzk()
            r1 = 1
            r0 = r0 & r1
            int r7 = r15.zzk()
            int r8 = r15.zzk()
            int r7 = com.google.android.gms.internal.ads.zzs.zza(r7)
            if (r1 == r0) goto L_0x0534
            r0 = 2
            goto L_0x0535
        L_0x0534:
            r0 = 1
        L_0x0535:
            int r8 = com.google.android.gms.internal.ads.zzs.zzb(r8)
            r10 = 1987063864(0x76703038, float:1.21789965E33)
            if (r3 != r10) goto L_0x0541
            java.lang.String r10 = "video/x-vnd.on2.vp8"
            goto L_0x0543
        L_0x0541:
            java.lang.String r10 = "video/x-vnd.on2.vp9"
        L_0x0543:
            r47 = r0
            r55 = r2
            r39 = r3
            r50 = r5
            r49 = r6
            r0 = r7
            r43 = r9
            r7 = r10
            goto L_0x0590
        L_0x0552:
            r13 = 1635135811(0x61763143, float:2.8384055E20)
            if (r1 != r13) goto L_0x0564
            if (r7 != 0) goto L_0x055b
            r1 = 1
            goto L_0x055c
        L_0x055b:
            r1 = 0
        L_0x055c:
            r7 = 0
            com.google.android.gms.internal.ads.zzaba.zzb(r1, r7)
            java.lang.String r1 = "video/av01"
            r7 = r1
            goto L_0x0586
        L_0x0564:
            r13 = 1668050025(0x636c6c69, float:4.3612434E21)
            if (r1 != r13) goto L_0x0595
            if (r17 != 0) goto L_0x056f
            java.nio.ByteBuffer r17 = zzm()
        L_0x056f:
            r1 = r17
            r10 = 21
            r1.position(r10)
            short r10 = r15.zzy()
            r1.putShort(r10)
            short r10 = r15.zzy()
            r1.putShort(r10)
            r17 = r1
        L_0x0586:
            r55 = r2
            r39 = r3
            r50 = r5
            r49 = r6
            r43 = r9
        L_0x0590:
            r2 = r44
        L_0x0592:
            r1 = -1
            goto L_0x0760
        L_0x0595:
            r13 = 1835295606(0x6d646376, float:4.4176764E27)
            if (r1 != r13) goto L_0x060f
            if (r17 != 0) goto L_0x05a0
            java.nio.ByteBuffer r17 = zzm()
        L_0x05a0:
            r1 = r17
            short r10 = r15.zzy()
            short r13 = r15.zzy()
            r39 = r3
            short r3 = r15.zzy()
            r42 = r4
            short r4 = r15.zzy()
            r43 = r9
            short r9 = r15.zzy()
            r48 = r11
            short r11 = r15.zzy()
            r49 = r6
            short r6 = r15.zzy()
            r50 = r5
            short r5 = r15.zzy()
            long r51 = r15.zzs()
            long r53 = r15.zzs()
            r55 = r2
            r2 = 1
            r1.position(r2)
            r1.putShort(r9)
            r1.putShort(r11)
            r1.putShort(r10)
            r1.putShort(r13)
            r1.putShort(r3)
            r1.putShort(r4)
            r1.putShort(r6)
            r1.putShort(r5)
            r2 = 10000(0x2710, double:4.9407E-320)
            long r2 = r51 / r2
            int r3 = (int) r2
            short r2 = (short) r3
            r1.putShort(r2)
            r2 = 10000(0x2710, double:4.9407E-320)
            long r2 = r53 / r2
            int r3 = (int) r2
            short r2 = (short) r3
            r1.putShort(r2)
            r17 = r1
        L_0x0608:
            r4 = r42
            r2 = r44
            r11 = r48
            goto L_0x0592
        L_0x060f:
            r55 = r2
            r39 = r3
            r42 = r4
            r50 = r5
            r49 = r6
            r43 = r9
            r48 = r11
            r2 = 1681012275(0x64323633, float:1.3149704E22)
            if (r1 != r2) goto L_0x062f
            if (r7 != 0) goto L_0x0626
            r1 = 1
            goto L_0x0627
        L_0x0626:
            r1 = 0
        L_0x0627:
            r2 = 0
            com.google.android.gms.internal.ads.zzaba.zzb(r1, r2)
            java.lang.String r1 = "video/3gpp"
            r7 = r1
            goto L_0x0608
        L_0x062f:
            r2 = 0
            r3 = 1702061171(0x65736473, float:7.183675E22)
            if (r1 != r3) goto L_0x0659
            if (r7 != 0) goto L_0x0639
            r1 = 1
            goto L_0x063a
        L_0x0639:
            r1 = 0
        L_0x063a:
            com.google.android.gms.internal.ads.zzaba.zzb(r1, r2)
            com.google.android.gms.internal.ads.zzagg r1 = zzl(r15, r10)
            java.lang.String r2 = r1.zza
            byte[] r3 = r1.zzb
            if (r3 == 0) goto L_0x0655
            com.google.android.gms.internal.ads.zzfsc r3 = com.google.android.gms.internal.ads.zzfsc.zzm(r3)
            r21 = r1
            r7 = r2
            r25 = r3
            goto L_0x0608
        L_0x0655:
            r21 = r1
            r7 = r2
            goto L_0x0608
        L_0x0659:
            r2 = 1885434736(0x70617370, float:2.7909473E29)
            if (r1 != r2) goto L_0x0675
            int r10 = r10 + 8
            r15.zzF(r10)
            int r1 = r15.zzn()
            int r2 = r15.zzn()
            float r1 = (float) r1
            float r2 = (float) r2
            float r1 = r1 / r2
            r11 = r1
            r2 = r44
            r1 = -1
            r4 = 1
            goto L_0x0760
        L_0x0675:
            r2 = 1937126244(0x73763364, float:1.9506033E31)
            if (r1 != r2) goto L_0x0681
            byte[] r1 = zzq(r15, r10, r12)
            r37 = r1
            goto L_0x0608
        L_0x0681:
            r2 = 1936995172(0x73743364, float:1.9347576E31)
            if (r1 != r2) goto L_0x06cc
            int r1 = r15.zzk()
            r4 = 3
            r15.zzG(r4)
            if (r1 != 0) goto L_0x073a
            int r1 = r15.zzk()
            if (r1 == 0) goto L_0x06c1
            r2 = 1
            if (r1 == r2) goto L_0x06b6
            r2 = 2
            if (r1 == r2) goto L_0x06ab
            if (r1 == r4) goto L_0x06a0
            goto L_0x073a
        L_0x06a0:
            r4 = r42
            r2 = r44
            r11 = r48
            r1 = -1
            r26 = 3
            goto L_0x0760
        L_0x06ab:
            r4 = r42
            r2 = r44
            r11 = r48
            r1 = -1
            r26 = 2
            goto L_0x0760
        L_0x06b6:
            r4 = r42
            r2 = r44
            r11 = r48
            r1 = -1
            r26 = 1
            goto L_0x0760
        L_0x06c1:
            r4 = r42
            r2 = r44
            r11 = r48
            r1 = -1
            r26 = 0
            goto L_0x0760
        L_0x06cc:
            r2 = 1668246642(0x636f6c72, float:4.4165861E21)
            if (r1 != r2) goto L_0x073a
            r1 = -1
            if (r0 != r1) goto L_0x0737
            if (r8 != r1) goto L_0x072f
            int r0 = r15.zze()
            r2 = 1852009592(0x6e636c78, float:1.7596057E28)
            if (r0 == r2) goto L_0x06fc
            r2 = 1852009571(0x6e636c63, float:1.7596032E28)
            if (r0 != r2) goto L_0x06e5
            goto L_0x06fc
        L_0x06e5:
            java.lang.String r2 = "Unsupported color type: "
            java.lang.String r0 = com.google.android.gms.internal.ads.zzage.zzf(r0)
            java.lang.String r0 = r2.concat(r0)
            r2 = r44
            com.google.android.gms.internal.ads.zzer.zzf(r2, r0)
            r4 = r42
            r11 = r48
            r0 = -1
            r8 = -1
            goto L_0x0760
        L_0x06fc:
            r2 = r44
            int r0 = r15.zzo()
            int r3 = r15.zzo()
            r4 = 2
            r15.zzG(r4)
            r4 = 19
            if (r12 != r4) goto L_0x071c
            int r5 = r15.zzk()
            r5 = r5 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x0718
            r4 = 1
            goto L_0x0719
        L_0x0718:
            r4 = 0
        L_0x0719:
            r12 = 19
            goto L_0x071d
        L_0x071c:
            r4 = 0
        L_0x071d:
            int r0 = com.google.android.gms.internal.ads.zzs.zza(r0)
            r5 = 1
            if (r5 == r4) goto L_0x0726
            r4 = 2
            goto L_0x0727
        L_0x0726:
            r4 = 1
        L_0x0727:
            int r3 = com.google.android.gms.internal.ads.zzs.zzb(r3)
            r8 = r3
            r47 = r4
            goto L_0x075c
        L_0x072f:
            r2 = r44
            r4 = r42
            r11 = r48
            r0 = -1
            goto L_0x0760
        L_0x0737:
            r2 = r44
            goto L_0x075c
        L_0x073a:
            r2 = r44
            r1 = -1
            goto L_0x075c
        L_0x073e:
            r55 = r2
            r39 = r3
            r42 = r4
            r50 = r5
            r49 = r6
            r43 = r9
            r48 = r11
            r2 = r44
            r1 = -1
            com.google.android.gms.internal.ads.zzaas r3 = com.google.android.gms.internal.ads.zzaas.zza(r15)
            if (r3 == 0) goto L_0x075c
            java.lang.String r3 = r3.zza
            java.lang.String r4 = "video/dolby-vision"
            r55 = r3
            r7 = r4
        L_0x075c:
            r4 = r42
            r11 = r48
        L_0x0760:
            int r14 = r14 + r12
            r44 = r2
            r1 = r30
            r12 = r37
            r13 = r38
            r3 = r39
            r9 = r43
            r6 = r49
            r5 = r50
            r2 = r55
            goto L_0x0449
        L_0x0775:
            r30 = r1
            r55 = r2
            r50 = r5
            r49 = r6
            r43 = r9
            r48 = r11
            r37 = r12
        L_0x0783:
            r38 = r13
            r2 = r44
            r1 = -1
            if (r7 != 0) goto L_0x0792
            r3 = r43
            r5 = r45
            r4 = r46
            goto L_0x0813
        L_0x0792:
            com.google.android.gms.internal.ads.zzak r3 = new com.google.android.gms.internal.ads.zzak
            r3.<init>()
            r4 = r46
            r3.zzG(r4)
            r3.zzS(r7)
            r5 = r55
            r3.zzx(r5)
            r5 = r50
            r3.zzX(r5)
            r5 = r49
            r3.zzF(r5)
            r10 = r48
            r3.zzP(r10)
            r5 = r45
            r3.zzR(r5)
            r6 = r37
            r3.zzQ(r6)
            r6 = r26
            r3.zzV(r6)
            r6 = r25
            r3.zzI(r6)
            r12 = r23
            r3.zzB(r12)
            r6 = r47
            if (r0 != r1) goto L_0x07de
            if (r6 != r1) goto L_0x07db
            if (r8 != r1) goto L_0x07d8
            if (r17 == 0) goto L_0x07f3
            r0 = -1
            goto L_0x07d9
        L_0x07d8:
            r0 = r8
        L_0x07d9:
            r6 = -1
            goto L_0x07dc
        L_0x07db:
            r0 = r8
        L_0x07dc:
            r8 = -1
            goto L_0x07e3
        L_0x07de:
            r56 = r8
            r8 = r0
            r0 = r56
        L_0x07e3:
            com.google.android.gms.internal.ads.zzs r7 = new com.google.android.gms.internal.ads.zzs
            if (r17 == 0) goto L_0x07ec
            byte[] r9 = r17.array()
            goto L_0x07ed
        L_0x07ec:
            r9 = 0
        L_0x07ed:
            r7.<init>(r8, r6, r0, r9)
            r3.zzy(r7)
        L_0x07f3:
            if (r21 == 0) goto L_0x080b
            long r6 = r21.zzc
            int r0 = com.google.android.gms.internal.ads.zzfuk.zzc(r6)
            r3.zzv(r0)
            long r6 = r21.zzd
            int r0 = com.google.android.gms.internal.ads.zzfuk.zzc(r6)
            r3.zzO(r0)
        L_0x080b:
            com.google.android.gms.internal.ads.zzam r0 = r3.zzY()
            r3 = r43
            r3.zzb = r0
        L_0x0813:
            int r13 = r38 + r30
            r15.zzF(r13)
            int r0 = r22 + 1
            r1 = r59
            r12 = r62
            r6 = r2
            r2 = r3
            r9 = r4
            r7 = r5
            r10 = r15
            r15 = r16
            r21 = r18
            r5 = r19
            r14 = r20
            r3 = r24
            r13 = r34
            r11 = r36
            r4 = 12
            r8 = 1937007212(0x7374626c, float:1.9362132E31)
            goto L_0x01a8
        L_0x0838:
            r3 = r2
            r2 = r6
            r36 = r11
            r34 = r13
            r20 = r14
            r16 = r15
            r18 = r21
            r1 = -1
            r0 = 1701082227(0x65647473, float:6.742798E22)
            r4 = r36
            com.google.android.gms.internal.ads.zzagc r0 = r4.zza(r0)
            if (r0 == 0) goto L_0x0861
            android.util.Pair r0 = zzh(r0)
            if (r0 == 0) goto L_0x0861
            java.lang.Object r5 = r0.first
            long[] r5 = (long[]) r5
            java.lang.Object r0 = r0.second
            long[] r0 = (long[]) r0
            r30 = r0
            goto L_0x0864
        L_0x0861:
            r5 = 0
            r30 = 0
        L_0x0864:
            com.google.android.gms.internal.ads.zzam r0 = r3.zzb
            if (r0 != 0) goto L_0x086c
            r0 = r65
            goto L_0x0062
        L_0x086c:
            com.google.android.gms.internal.ads.zzahc r0 = new com.google.android.gms.internal.ads.zzahc
            int r17 = r20.zza
            r6 = r16
            java.lang.Object r6 = r6.first
            java.lang.Long r6 = (java.lang.Long) r6
            long r19 = r6.longValue()
            com.google.android.gms.internal.ads.zzam r6 = r3.zzb
            int r7 = r3.zzd
            com.google.android.gms.internal.ads.zzahd[] r8 = r3.zza
            int r3 = r3.zzc
            r16 = r0
            r21 = r40
            r23 = r28
            r25 = r6
            r26 = r7
            r27 = r8
            r28 = r3
            r29 = r5
            r16.<init>(r17, r18, r19, r21, r23, r25, r26, r27, r28, r29, r30)
            r5 = r0
            r0 = r65
        L_0x089a:
            java.lang.Object r3 = r0.apply(r5)
            r6 = r3
            com.google.android.gms.internal.ads.zzahc r6 = (com.google.android.gms.internal.ads.zzahc) r6
            if (r6 == 0) goto L_0x0e74
            r3 = 1835297121(0x6d646961, float:4.4181236E27)
            com.google.android.gms.internal.ads.zzagc r3 = r4.zza(r3)
            r3.getClass()
            r4 = 1835626086(0x6d696e66, float:4.515217E27)
            com.google.android.gms.internal.ads.zzagc r3 = r3.zza(r4)
            r3.getClass()
            r4 = 1937007212(0x7374626c, float:1.9362132E31)
            com.google.android.gms.internal.ads.zzagc r3 = r3.zza(r4)
            r3.getClass()
            r4 = 1937011578(0x7374737a, float:1.936741E31)
            com.google.android.gms.internal.ads.zzagd r4 = r3.zzb(r4)
            if (r4 == 0) goto L_0x08d2
            com.google.android.gms.internal.ads.zzagj r5 = new com.google.android.gms.internal.ads.zzagj
            com.google.android.gms.internal.ads.zzam r7 = r6.zzf
            r5.<init>(r4, r7)
            goto L_0x08e0
        L_0x08d2:
            r4 = 1937013298(0x73747a32, float:1.9369489E31)
            com.google.android.gms.internal.ads.zzagd r4 = r3.zzb(r4)
            if (r4 == 0) goto L_0x0e6c
            com.google.android.gms.internal.ads.zzagk r5 = new com.google.android.gms.internal.ads.zzagk
            r5.<init>(r4)
        L_0x08e0:
            int r4 = r5.zzb()
            if (r4 != 0) goto L_0x08fd
            com.google.android.gms.internal.ads.zzahf r1 = new com.google.android.gms.internal.ads.zzahf
            r2 = 0
            long[] r7 = new long[r2]
            int[] r8 = new int[r2]
            r9 = 0
            long[] r10 = new long[r2]
            int[] r11 = new int[r2]
            r12 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
        L_0x08f8:
            r2 = r34
            r0 = 0
            goto L_0x0e68
        L_0x08fd:
            r7 = 1937007471(0x7374636f, float:1.9362445E31)
            com.google.android.gms.internal.ads.zzagd r7 = r3.zzb(r7)
            if (r7 != 0) goto L_0x0913
            r7 = 1668232756(0x636f3634, float:4.4126776E21)
            com.google.android.gms.internal.ads.zzagd r7 = r3.zzb(r7)
            r7.getClass()
            r8 = r7
            r7 = 1
            goto L_0x0915
        L_0x0913:
            r8 = r7
            r7 = 0
        L_0x0915:
            com.google.android.gms.internal.ads.zzfa r8 = r8.zza
            r9 = 1937011555(0x73747363, float:1.9367382E31)
            com.google.android.gms.internal.ads.zzagd r9 = r3.zzb(r9)
            r9.getClass()
            com.google.android.gms.internal.ads.zzfa r9 = r9.zza
            r10 = 1937011827(0x73747473, float:1.9367711E31)
            com.google.android.gms.internal.ads.zzagd r10 = r3.zzb(r10)
            r10.getClass()
            com.google.android.gms.internal.ads.zzfa r10 = r10.zza
            r11 = 1937011571(0x73747373, float:1.9367401E31)
            com.google.android.gms.internal.ads.zzagd r11 = r3.zzb(r11)
            if (r11 == 0) goto L_0x093b
            com.google.android.gms.internal.ads.zzfa r11 = r11.zza
            goto L_0x093c
        L_0x093b:
            r11 = 0
        L_0x093c:
            r12 = 1668576371(0x63747473, float:4.5093966E21)
            com.google.android.gms.internal.ads.zzagd r3 = r3.zzb(r12)
            if (r3 == 0) goto L_0x0948
            com.google.android.gms.internal.ads.zzfa r3 = r3.zza
            goto L_0x0949
        L_0x0948:
            r3 = 0
        L_0x0949:
            com.google.android.gms.internal.ads.zzagf r12 = new com.google.android.gms.internal.ads.zzagf
            r12.<init>(r9, r8, r7)
            r7 = 12
            r10.zzF(r7)
            int r8 = r10.zzn()
            int r8 = r8 + r1
            int r9 = r10.zzn()
            int r13 = r10.zzn()
            if (r3 == 0) goto L_0x096a
            r3.zzF(r7)
            int r14 = r3.zzn()
            goto L_0x096b
        L_0x096a:
            r14 = 0
        L_0x096b:
            if (r11 == 0) goto L_0x097e
            r11.zzF(r7)
            int r7 = r11.zzn()
            if (r7 <= 0) goto L_0x097c
            int r15 = r11.zzn()
            int r15 = r15 + r1
            goto L_0x0980
        L_0x097c:
            r11 = 0
            goto L_0x097f
        L_0x097e:
            r7 = 0
        L_0x097f:
            r15 = -1
        L_0x0980:
            int r1 = r5.zza()
            com.google.android.gms.internal.ads.zzam r0 = r6.zzf
            java.lang.String r0 = r0.zzm
            r16 = r9
            r9 = -1
            if (r1 == r9) goto L_0x0a30
            java.lang.String r9 = "audio/raw"
            boolean r9 = r9.equals(r0)
            if (r9 != 0) goto L_0x09a5
            java.lang.String r9 = "audio/g711-mlaw"
            boolean r9 = r9.equals(r0)
            if (r9 != 0) goto L_0x09a5
            java.lang.String r9 = "audio/g711-alaw"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0a30
        L_0x09a5:
            if (r8 != 0) goto L_0x0a30
            if (r14 != 0) goto L_0x0a2f
            if (r7 != 0) goto L_0x0a2f
            int r0 = r12.zza
            long[] r2 = new long[r0]
            int[] r3 = new int[r0]
        L_0x09b1:
            boolean r5 = r12.zza()
            if (r5 == 0) goto L_0x09c2
            int r5 = r12.zzb
            long r7 = r12.zzd
            r2[r5] = r7
            int r7 = r12.zzc
            r3[r5] = r7
            goto L_0x09b1
        L_0x09c2:
            long r7 = (long) r13
            r5 = 8192(0x2000, float:1.14794E-41)
            int r5 = r5 / r1
            r9 = 0
            r10 = 0
        L_0x09c8:
            if (r9 >= r0) goto L_0x09d6
            r11 = r3[r9]
            int r12 = com.google.android.gms.internal.ads.zzfj.zza
            int r11 = r11 + r5
            r12 = -1
            int r11 = r11 + r12
            int r11 = r11 / r5
            int r10 = r10 + r11
            int r9 = r9 + 1
            goto L_0x09c8
        L_0x09d6:
            long[] r9 = new long[r10]
            int[] r11 = new int[r10]
            long[] r12 = new long[r10]
            int[] r10 = new int[r10]
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x09e3:
            if (r13 >= r0) goto L_0x0a24
            r17 = r3[r13]
            r18 = r2[r13]
            r56 = r17
            r17 = r0
            r0 = r56
        L_0x09ef:
            if (r0 <= 0) goto L_0x0a1b
            int r20 = java.lang.Math.min(r5, r0)
            r9[r16] = r18
            r21 = r2
            int r2 = r1 * r20
            r11[r16] = r2
            int r15 = java.lang.Math.max(r15, r2)
            r22 = r1
            long r1 = (long) r14
            long r1 = r1 * r7
            r12[r16] = r1
            r1 = 1
            r10[r16] = r1
            r1 = r11[r16]
            long r1 = (long) r1
            long r18 = r18 + r1
            int r14 = r14 + r20
            int r0 = r0 - r20
            int r16 = r16 + 1
            r2 = r21
            r1 = r22
            goto L_0x09ef
        L_0x0a1b:
            r22 = r1
            r21 = r2
            int r13 = r13 + 1
            r0 = r17
            goto L_0x09e3
        L_0x0a24:
            long r0 = (long) r14
            long r7 = r7 * r0
            r0 = r7
            r2 = r9
            r14 = r10
            r3 = r11
            r13 = r15
            r15 = r6
            goto L_0x0bfc
        L_0x0a2f:
            r8 = 0
        L_0x0a30:
            long[] r0 = new long[r4]
            int[] r1 = new int[r4]
            long[] r9 = new long[r4]
            r17 = r7
            int[] r7 = new int[r4]
            r20 = r6
            r6 = r13
            r21 = r14
            r14 = r15
            r13 = 0
            r18 = 0
            r19 = 0
            r22 = 0
            r23 = 0
            r25 = 0
            r15 = r8
            r8 = 0
        L_0x0a4d:
            if (r8 >= r4) goto L_0x0b26
            r27 = r23
            r23 = 1
        L_0x0a53:
            if (r18 != 0) goto L_0x0a78
            boolean r23 = r12.zza()
            if (r23 == 0) goto L_0x0a70
            r29 = r14
            r24 = r15
            long r14 = r12.zzd
            r30 = r4
            int r4 = r12.zzc
            r18 = r4
            r27 = r14
            r15 = r24
            r14 = r29
            r4 = r30
            goto L_0x0a53
        L_0x0a70:
            r30 = r4
            r29 = r14
            r24 = r15
            r4 = 0
            goto L_0x0a80
        L_0x0a78:
            r30 = r4
            r29 = r14
            r24 = r15
            r4 = r18
        L_0x0a80:
            if (r23 != 0) goto L_0x0a9a
            java.lang.String r4 = "Unexpected end of chunk data"
            com.google.android.gms.internal.ads.zzer.zzf(r2, r4)
            long[] r0 = java.util.Arrays.copyOf(r0, r8)
            int[] r1 = java.util.Arrays.copyOf(r1, r8)
            long[] r9 = java.util.Arrays.copyOf(r9, r8)
            int[] r7 = java.util.Arrays.copyOf(r7, r8)
            r4 = r8
            goto L_0x0b2a
        L_0x0a9a:
            r14 = r22
            if (r3 != 0) goto L_0x0a9f
            goto L_0x0ab5
        L_0x0a9f:
            if (r19 != 0) goto L_0x0ab2
            if (r21 <= 0) goto L_0x0aae
            int r21 = r21 + -1
            int r19 = r3.zzn()
            int r14 = r3.zze()
            goto L_0x0a9f
        L_0x0aae:
            r15 = -1
            r19 = 0
            goto L_0x0ab3
        L_0x0ab2:
            r15 = -1
        L_0x0ab3:
            int r19 = r19 + -1
        L_0x0ab5:
            r0[r8] = r27
            int r15 = r5.zzc()
            r1[r8] = r15
            if (r15 <= r13) goto L_0x0ac3
            r18 = r15
            r15 = r12
            goto L_0x0ac6
        L_0x0ac3:
            r15 = r12
            r18 = r13
        L_0x0ac6:
            long r12 = (long) r14
            long r12 = r25 + r12
            r9[r8] = r12
            if (r11 != 0) goto L_0x0acf
            r12 = 1
            goto L_0x0ad0
        L_0x0acf:
            r12 = 0
        L_0x0ad0:
            r7[r8] = r12
            r12 = r29
            if (r8 != r12) goto L_0x0ae6
            r13 = 1
            r7[r8] = r13
            int r17 = r17 + -1
            if (r17 <= 0) goto L_0x0ae6
            r11.getClass()
            int r12 = r11.zzn()
            r13 = -1
            int r12 = r12 + r13
        L_0x0ae6:
            r23 = r11
            r13 = r12
            long r11 = (long) r6
            long r25 = r25 + r11
            int r11 = r16 + -1
            if (r11 != 0) goto L_0x0b05
            if (r24 <= 0) goto L_0x0b02
            int r6 = r10.zzn()
            int r11 = r10.zze()
            int r12 = r24 + -1
            r16 = r6
            r6 = r11
            r24 = r12
            goto L_0x0b07
        L_0x0b02:
            r16 = 0
            goto L_0x0b07
        L_0x0b05:
            r16 = r11
        L_0x0b07:
            r11 = r1[r8]
            long r11 = (long) r11
            long r11 = r27 + r11
            r27 = -1
            int r4 = r4 + -1
            int r8 = r8 + 1
            r22 = r14
            r14 = r13
            r13 = r18
            r18 = r4
            r4 = r30
            r56 = r11
            r12 = r15
            r11 = r23
            r15 = r24
            r23 = r56
            goto L_0x0a4d
        L_0x0b26:
            r30 = r4
            r24 = r15
        L_0x0b2a:
            r14 = r22
            long r5 = (long) r14
            long r5 = r25 + r5
            if (r3 == 0) goto L_0x0b41
        L_0x0b31:
            if (r21 <= 0) goto L_0x0b41
            int r8 = r3.zzn()
            if (r8 == 0) goto L_0x0b3b
            r3 = 0
            goto L_0x0b42
        L_0x0b3b:
            r3.zze()
            int r21 = r21 + -1
            goto L_0x0b31
        L_0x0b41:
            r3 = 1
        L_0x0b42:
            if (r17 != 0) goto L_0x0b97
            if (r16 != 0) goto L_0x0b8a
            if (r18 != 0) goto L_0x0b7c
            if (r24 != 0) goto L_0x0b6f
            if (r19 != 0) goto L_0x0b63
            if (r3 != 0) goto L_0x0b59
            r16 = r0
            r15 = r20
            r3 = 0
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            goto L_0x0ba6
        L_0x0b59:
            r16 = r0
            r17 = r1
            r18 = r4
            r15 = r20
            goto L_0x0bf3
        L_0x0b63:
            r16 = r0
            r14 = r3
            r12 = r19
            r15 = r20
            r3 = 0
            r8 = 0
            r10 = 0
            r11 = 0
            goto L_0x0ba6
        L_0x0b6f:
            r16 = r0
            r14 = r3
            r12 = r19
            r15 = r20
            r11 = r24
            r3 = 0
            r8 = 0
            r10 = 0
            goto L_0x0ba6
        L_0x0b7c:
            r16 = r0
            r14 = r3
            r10 = r18
            r12 = r19
            r15 = r20
            r11 = r24
            r3 = 0
            r8 = 0
            goto L_0x0ba6
        L_0x0b8a:
            r14 = r3
            r8 = r16
            r10 = r18
            r12 = r19
            r15 = r20
            r11 = r24
            r3 = 0
            goto L_0x0ba4
        L_0x0b97:
            r14 = r3
            r8 = r16
            r3 = r17
            r10 = r18
            r12 = r19
            r15 = r20
            r11 = r24
        L_0x0ba4:
            r16 = r0
        L_0x0ba6:
            int r0 = r15.zza
            r17 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r18 = r4
            java.lang.String r4 = "Inconsistent stbl box for track "
            r1.append(r4)
            r1.append(r0)
            java.lang.String r0 = ": remainingSynchronizationSamples "
            r1.append(r0)
            r1.append(r3)
            java.lang.String r0 = ", remainingSamplesAtTimestampDelta "
            r1.append(r0)
            r1.append(r8)
            java.lang.String r0 = ", remainingSamplesInChunk "
            r1.append(r0)
            r1.append(r10)
            java.lang.String r0 = ", remainingTimestampDeltaChanges "
            r1.append(r0)
            r1.append(r11)
            java.lang.String r0 = ", remainingSamplesAtTimestampOffset "
            r1.append(r0)
            r1.append(r12)
            r0 = 1
            if (r0 == r14) goto L_0x0be7
            java.lang.String r0 = ", ctts invalid"
            goto L_0x0be9
        L_0x0be7:
            java.lang.String r0 = ""
        L_0x0be9:
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.ads.zzer.zzf(r2, r0)
        L_0x0bf3:
            r0 = r5
            r14 = r7
            r12 = r9
            r2 = r16
            r3 = r17
            r4 = r18
        L_0x0bfc:
            r7 = 1000000(0xf4240, double:4.940656E-318)
            long r9 = r15.zzc
            r5 = r0
            long r16 = com.google.android.gms.internal.ads.zzfj.zzp(r5, r7, r9)
            long[] r5 = r15.zzh
            if (r5 != 0) goto L_0x0c22
            r0 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r15.zzc
            com.google.android.gms.internal.ads.zzfj.zzB(r12, r0, r4)
            com.google.android.gms.internal.ads.zzahf r1 = new com.google.android.gms.internal.ads.zzahf
            r5 = r1
            r6 = r15
            r7 = r2
            r8 = r3
            r9 = r13
            r10 = r12
            r11 = r14
            r12 = r16
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            goto L_0x08f8
        L_0x0c22:
            int r6 = r5.length
            r7 = 1
            if (r6 != r7) goto L_0x0cbf
            int r6 = r15.zzb
            if (r6 != r7) goto L_0x0cbf
            int r6 = r12.length
            r7 = 2
            if (r6 < r7) goto L_0x0cbf
            long[] r6 = r15.zzi
            r6.getClass()
            r7 = 0
            r16 = r6[r7]
            r18 = r5[r7]
            long r5 = r15.zzc
            long r7 = r15.zzd
            r20 = r5
            r22 = r7
            long r5 = com.google.android.gms.internal.ads.zzfj.zzp(r18, r20, r22)
            long r18 = r16 + r5
            r5 = r12
            r6 = r0
            r8 = r16
            r10 = r18
            boolean r5 = zzp(r5, r6, r8, r10)
            if (r5 == 0) goto L_0x0cbf
            long r6 = r0 - r18
            r5 = 0
            r8 = r12[r5]
            long r18 = r16 - r8
            com.google.android.gms.internal.ads.zzam r5 = r15.zzf
            int r5 = r5.zzA
            long r8 = (long) r5
            long r10 = r15.zzc
            r20 = r8
            r22 = r10
            long r16 = com.google.android.gms.internal.ads.zzfj.zzp(r18, r20, r22)
            com.google.android.gms.internal.ads.zzam r5 = r15.zzf
            int r5 = r5.zzA
            long r8 = (long) r5
            long r10 = r15.zzc
            long r5 = com.google.android.gms.internal.ads.zzfj.zzp(r6, r8, r10)
            r7 = 0
            int r9 = (r16 > r7 ? 1 : (r16 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0c80
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0cbf
            r7 = 0
            goto L_0x0c82
        L_0x0c80:
            r7 = r16
        L_0x0c82:
            r9 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 > 0) goto L_0x0cbf
            r9 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r11 > 0) goto L_0x0cbf
            int r0 = (int) r7
            r1 = r59
            r1.zza = r0
            int r0 = (int) r5
            r1.zzb = r0
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r6 = r15.zzc
            com.google.android.gms.internal.ads.zzfj.zzB(r12, r4, r6)
            long[] r0 = r15.zzh
            r4 = 0
            r5 = r0[r4]
            r7 = 1000000(0xf4240, double:4.940656E-318)
            long r9 = r15.zzd
            long r16 = com.google.android.gms.internal.ads.zzfj.zzp(r5, r7, r9)
            com.google.android.gms.internal.ads.zzahf r0 = new com.google.android.gms.internal.ads.zzahf
            r5 = r0
            r6 = r15
            r7 = r2
            r8 = r3
            r9 = r13
            r10 = r12
            r11 = r14
            r12 = r16
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            r1 = r0
            goto L_0x08f8
        L_0x0cbf:
            long[] r5 = r15.zzh
            int r7 = r5.length
            r6 = 1
            if (r7 != r6) goto L_0x0d0b
            r6 = 0
            r7 = r5[r6]
            r9 = 0
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x0d0a
            long[] r4 = r15.zzi
            r4.getClass()
            r7 = r4[r6]
            r4 = 0
        L_0x0cd6:
            int r5 = r12.length
            if (r4 >= r5) goto L_0x0ced
            r5 = r12[r4]
            long r16 = r5 - r7
            r18 = 1000000(0xf4240, double:4.940656E-318)
            long r5 = r15.zzc
            r20 = r5
            long r5 = com.google.android.gms.internal.ads.zzfj.zzp(r16, r18, r20)
            r12[r4] = r5
            int r4 = r4 + 1
            goto L_0x0cd6
        L_0x0ced:
            long r16 = r0 - r7
            r18 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r15.zzc
            r20 = r0
            long r0 = com.google.android.gms.internal.ads.zzfj.zzp(r16, r18, r20)
            com.google.android.gms.internal.ads.zzahf r4 = new com.google.android.gms.internal.ads.zzahf
            r5 = r4
            r6 = r15
            r7 = r2
            r8 = r3
            r9 = r13
            r10 = r12
            r11 = r14
            r12 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            r1 = r4
            goto L_0x08f8
        L_0x0d0a:
            r7 = 1
        L_0x0d0b:
            int r0 = r15.zzb
            r1 = 1
            if (r0 != r1) goto L_0x0d12
            r0 = 1
            goto L_0x0d13
        L_0x0d12:
            r0 = 0
        L_0x0d13:
            int[] r1 = new int[r7]
            int[] r5 = new int[r7]
            long[] r6 = r15.zzi
            r6.getClass()
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x0d20:
            long[] r11 = r15.zzh
            r16 = r13
            int r13 = r11.length
            if (r8 >= r13) goto L_0x0d88
            r13 = r2
            r17 = r3
            r2 = r6[r8]
            r18 = -1
            int r20 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r20 == 0) goto L_0x0d75
            r21 = r11[r8]
            r11 = r9
            r18 = r10
            long r9 = r15.zzc
            r19 = r6
            r20 = r7
            long r6 = r15.zzd
            r23 = r9
            r25 = r6
            long r6 = com.google.android.gms.internal.ads.zzfj.zzp(r21, r23, r25)
            r9 = 1
            int r10 = com.google.android.gms.internal.ads.zzfj.zzc(r12, r2, r9, r9)
            r1[r8] = r10
            long r2 = r2 + r6
            r10 = 0
            int r2 = com.google.android.gms.internal.ads.zzfj.zza(r12, r2, r0, r10)
            r5[r8] = r2
        L_0x0d56:
            r2 = r1[r8]
            r3 = r5[r8]
            if (r2 >= r3) goto L_0x0d67
            r6 = r14[r2]
            r6 = r6 & r9
            if (r6 != 0) goto L_0x0d67
            int r2 = r2 + 1
            r1[r8] = r2
            r9 = 1
            goto L_0x0d56
        L_0x0d67:
            int r6 = r3 - r2
            int r7 = r20 + r6
            r6 = r18
            if (r6 == r2) goto L_0x0d71
            r2 = 1
            goto L_0x0d72
        L_0x0d71:
            r2 = 0
        L_0x0d72:
            r2 = r2 | r11
            r9 = r2
            goto L_0x0d7d
        L_0x0d75:
            r19 = r6
            r20 = r7
            r11 = r9
            r6 = r10
            r10 = 0
            r3 = r6
        L_0x0d7d:
            int r8 = r8 + 1
            r10 = r3
            r2 = r13
            r13 = r16
            r3 = r17
            r6 = r19
            goto L_0x0d20
        L_0x0d88:
            r13 = r2
            r17 = r3
            r11 = r9
            r10 = 0
            if (r7 == r4) goto L_0x0d91
            r0 = 1
            goto L_0x0d92
        L_0x0d91:
            r0 = 0
        L_0x0d92:
            r0 = r0 | r11
            if (r0 == 0) goto L_0x0d98
            long[] r2 = new long[r7]
            goto L_0x0d99
        L_0x0d98:
            r2 = r13
        L_0x0d99:
            if (r0 == 0) goto L_0x0d9f
            int[] r3 = new int[r7]
            r8 = r3
            goto L_0x0da1
        L_0x0d9f:
            r8 = r17
        L_0x0da1:
            r3 = 1
            if (r3 != r0) goto L_0x0da6
            r16 = 0
        L_0x0da6:
            if (r0 == 0) goto L_0x0dac
            int[] r3 = new int[r7]
            r11 = r3
            goto L_0x0dad
        L_0x0dac:
            r11 = r14
        L_0x0dad:
            long[] r3 = new long[r7]
            r4 = 0
            r6 = 0
            r9 = 0
        L_0x0db3:
            long[] r10 = r15.zzh
            int r10 = r10.length
            if (r4 >= r10) goto L_0x0e48
            long[] r10 = r15.zzi
            r24 = r10[r4]
            r10 = r1[r4]
            r26 = r1
            r1 = r5[r4]
            r27 = r5
            if (r0 == 0) goto L_0x0dd6
            int r5 = r1 - r10
            java.lang.System.arraycopy(r13, r10, r2, r9, r5)
            r28 = r13
            r13 = r17
            java.lang.System.arraycopy(r13, r10, r8, r9, r5)
            java.lang.System.arraycopy(r14, r10, r11, r9, r5)
            goto L_0x0dda
        L_0x0dd6:
            r28 = r13
            r13 = r17
        L_0x0dda:
            r5 = r16
        L_0x0ddc:
            if (r10 >= r1) goto L_0x0e25
            r20 = 1000000(0xf4240, double:4.940656E-318)
            r29 = r1
            r17 = r2
            long r1 = r15.zzd
            r18 = r6
            r22 = r1
            long r1 = com.google.android.gms.internal.ads.zzfj.zzp(r18, r20, r22)
            r18 = r12[r10]
            r30 = r11
            r20 = r12
            long r11 = r18 - r24
            r18 = r6
            r6 = 0
            long r35 = java.lang.Math.max(r6, r11)
            r37 = 1000000(0xf4240, double:4.940656E-318)
            long r11 = r15.zzc
            r39 = r11
            long r11 = com.google.android.gms.internal.ads.zzfj.zzp(r35, r37, r39)
            long r1 = r1 + r11
            r3[r9] = r1
            if (r0 == 0) goto L_0x0e16
            r1 = r8[r9]
            if (r1 <= r5) goto L_0x0e16
            r1 = r13[r10]
            r5 = r1
        L_0x0e16:
            int r9 = r9 + 1
            int r10 = r10 + 1
            r2 = r17
            r6 = r18
            r12 = r20
            r1 = r29
            r11 = r30
            goto L_0x0ddc
        L_0x0e25:
            r17 = r2
            r18 = r6
            r30 = r11
            r20 = r12
            r6 = 0
            long[] r1 = r15.zzh
            r10 = r1[r4]
            long r1 = r18 + r10
            int r4 = r4 + 1
            r6 = r1
            r16 = r5
            r2 = r17
            r1 = r26
            r5 = r27
            r11 = r30
            r17 = r13
            r13 = r28
            goto L_0x0db3
        L_0x0e48:
            r17 = r2
            r18 = r6
            r30 = r11
            r20 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r15.zzd
            r22 = r0
            long r12 = com.google.android.gms.internal.ads.zzfj.zzp(r18, r20, r22)
            com.google.android.gms.internal.ads.zzahf r1 = new com.google.android.gms.internal.ads.zzahf
            r5 = r1
            r6 = r15
            r7 = r17
            r9 = r16
            r0 = 0
            r10 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            r2 = r34
        L_0x0e68:
            r2.add(r1)
            goto L_0x0e78
        L_0x0e6c:
            java.lang.String r0 = "Track has no sample table size information"
            r1 = 0
            com.google.android.gms.internal.ads.zzcd r0 = com.google.android.gms.internal.ads.zzcd.zza(r0, r1)
            throw r0
        L_0x0e74:
            r2 = r34
            goto L_0x0027
        L_0x0e78:
            int r15 = r31 + 1
            r0 = r58
            r1 = r59
            r12 = r62
            r13 = r2
            goto L_0x000c
        L_0x0e83:
            r1 = 0
            java.lang.String r0 = "Malformed sample table (stbl) missing sample description (stsd)"
            com.google.android.gms.internal.ads.zzcd r0 = com.google.android.gms.internal.ads.zzcd.zza(r0, r1)
            throw r0
        L_0x0e8b:
            r2 = r13
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagn.zzc(com.google.android.gms.internal.ads.zzagc, com.google.android.gms.internal.ads.zzabl, long, com.google.android.gms.internal.ads.zzad, boolean, boolean, com.google.android.gms.internal.ads.zzfov):java.util.List");
    }

    public static void zzd(zzfa zzfa) {
        int zzc = zzfa.zzc();
        zzfa.zzG(4);
        if (zzfa.zze() != 1751411826) {
            zzc += 4;
        }
        zzfa.zzF(zzc);
    }

    private static int zze(int i2) {
        if (i2 == 1936684398) {
            return 1;
        }
        if (i2 == 1986618469) {
            return 2;
        }
        if (i2 == 1952807028 || i2 == 1935832172 || i2 == 1937072756 || i2 == 1668047728) {
            return 3;
        }
        return i2 == 1835365473 ? 5 : -1;
    }

    private static int zzf(zzfa zzfa) {
        int zzk = zzfa.zzk();
        int i2 = zzk & 127;
        while ((zzk & 128) == 128) {
            zzk = zzfa.zzk();
            i2 = (i2 << 7) | (zzk & 127);
        }
        return i2;
    }

    private static int zzg(zzfa zzfa) {
        zzfa.zzF(16);
        return zzfa.zze();
    }

    private static Pair zzh(zzagc zzagc) {
        long j2;
        long j3;
        zzagd zzb = zzagc.zzb(1701606260);
        if (zzb == null) {
            return null;
        }
        zzfa zzfa = zzb.zza;
        zzfa.zzF(8);
        int zze = zzage.zze(zzfa.zze());
        int zzn = zzfa.zzn();
        long[] jArr = new long[zzn];
        long[] jArr2 = new long[zzn];
        int i2 = 0;
        while (i2 < zzn) {
            if (zze == 1) {
                j2 = zzfa.zzt();
            } else {
                j2 = zzfa.zzs();
            }
            jArr[i2] = j2;
            if (zze == 1) {
                j3 = zzfa.zzr();
            } else {
                j3 = (long) zzfa.zze();
            }
            jArr2[i2] = j3;
            if (zzfa.zzy() == 1) {
                zzfa.zzG(2);
                i2++;
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static Pair zzi(zzfa zzfa) {
        int i2;
        int i3 = 8;
        zzfa.zzF(8);
        int zze = zzage.zze(zzfa.zze());
        if (zze == 0) {
            i2 = 8;
        } else {
            i2 = 16;
        }
        zzfa.zzG(i2);
        long zzs = zzfa.zzs();
        if (zze == 0) {
            i3 = 4;
        }
        zzfa.zzG(i3);
        int zzo = zzfa.zzo();
        StringBuilder sb = new StringBuilder();
        sb.append((char) (((zzo >> 10) & 31) + 96));
        sb.append((char) (((zzo >> 5) & 31) + 96));
        sb.append((char) ((zzo & 31) + 96));
        return Pair.create(Long.valueOf(zzs), sb.toString());
    }

    private static Pair zzj(zzfa zzfa, int i2, int i3) throws zzcd {
        boolean z2;
        Pair pair;
        boolean z3;
        boolean z4;
        Integer num;
        zzahd zzahd;
        int i4;
        int i5;
        boolean z5;
        byte[] bArr;
        zzfa zzfa2 = zzfa;
        int zzc = zzfa.zzc();
        while (zzc - i2 < i3) {
            zzfa2.zzF(zzc);
            int zze = zzfa.zze();
            boolean z6 = true;
            if (zze > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            zzaba.zzb(z2, "childAtomSize must be positive");
            if (zzfa.zze() == 1936289382) {
                int i6 = zzc + 8;
                int i7 = -1;
                int i8 = 0;
                String str = null;
                Integer num2 = null;
                while (i6 - zzc < zze) {
                    zzfa2.zzF(i6);
                    int zze2 = zzfa.zze();
                    int zze3 = zzfa.zze();
                    if (zze3 == 1718775137) {
                        num2 = Integer.valueOf(zzfa.zze());
                    } else if (zze3 == 1935894637) {
                        zzfa2.zzG(4);
                        str = zzfa2.zzx(4, zzfot.zzc);
                    } else if (zze3 == 1935894633) {
                        i7 = i6;
                        i8 = zze2;
                    }
                    i6 += zze2;
                }
                if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
                    if (num2 != null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zzaba.zzb(z3, "frma atom is mandatory");
                    if (i7 != -1) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    zzaba.zzb(z4, "schi atom is mandatory");
                    int i9 = i7 + 8;
                    while (true) {
                        if (i9 - i7 >= i8) {
                            num = num2;
                            zzahd = null;
                            break;
                        }
                        zzfa2.zzF(i9);
                        int zze4 = zzfa.zze();
                        if (zzfa.zze() == 1952804451) {
                            int zze5 = zzage.zze(zzfa.zze());
                            zzfa2.zzG(1);
                            if (zze5 == 0) {
                                zzfa2.zzG(1);
                                i5 = 0;
                                i4 = 0;
                            } else {
                                int zzk = zzfa.zzk();
                                int i10 = zzk & 240;
                                i5 = zzk & 15;
                                i4 = i10 >> 4;
                            }
                            if (zzfa.zzk() == 1) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            int zzk2 = zzfa.zzk();
                            byte[] bArr2 = new byte[16];
                            zzfa2.zzB(bArr2, 0, 16);
                            if (!z5 || zzk2 != 0) {
                                bArr = null;
                            } else {
                                int zzk3 = zzfa.zzk();
                                byte[] bArr3 = new byte[zzk3];
                                zzfa2.zzB(bArr3, 0, zzk3);
                                bArr = bArr3;
                            }
                            num = num2;
                            zzahd = new zzahd(z5, str, zzk2, bArr2, i4, i5, bArr);
                        } else {
                            Integer num3 = num2;
                            i9 += zze4;
                        }
                    }
                    if (zzahd == null) {
                        z6 = false;
                    }
                    zzaba.zzb(z6, "tenc atom is mandatory");
                    int i11 = zzfj.zza;
                    pair = Pair.create(num, zzahd);
                } else {
                    pair = null;
                }
                if (pair != null) {
                    return pair;
                }
            }
            zzc += zze;
        }
        return null;
    }

    private static zzbz zzk(zzfa zzfa) {
        short zzy = zzfa.zzy();
        zzfa.zzG(2);
        String zzx = zzfa.zzx(zzy, zzfot.zzc);
        int max = Math.max(zzx.lastIndexOf(43), zzx.lastIndexOf(45));
        try {
            return new zzbz(-9223372036854775807L, new zzfq(Float.parseFloat(zzx.substring(0, max)), Float.parseFloat(zzx.substring(max, zzx.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static zzagg zzl(zzfa zzfa, int i2) {
        long j2;
        long j3;
        zzfa.zzF(i2 + 12);
        zzfa.zzG(1);
        zzf(zzfa);
        zzfa.zzG(2);
        int zzk = zzfa.zzk();
        if ((zzk & 128) != 0) {
            zzfa.zzG(2);
        }
        if ((zzk & 64) != 0) {
            zzfa.zzG(zzfa.zzk());
        }
        if ((zzk & 32) != 0) {
            zzfa.zzG(2);
        }
        zzfa.zzG(1);
        zzf(zzfa);
        String zzd = zzcc.zzd(zzfa.zzk());
        if ("audio/mpeg".equals(zzd) || "audio/vnd.dts".equals(zzd) || "audio/vnd.dts.hd".equals(zzd)) {
            return new zzagg(zzd, (byte[]) null, -1, -1);
        }
        zzfa.zzG(4);
        long zzs = zzfa.zzs();
        long zzs2 = zzfa.zzs();
        zzfa.zzG(1);
        int zzf = zzf(zzfa);
        byte[] bArr = new byte[zzf];
        zzfa.zzB(bArr, 0, zzf);
        if (zzs2 <= 0) {
            j2 = -1;
        } else {
            j2 = zzs2;
        }
        if (zzs > 0) {
            j3 = zzs;
        } else {
            j3 = -1;
        }
        return new zzagg(zzd, bArr, j2, j3);
    }

    private static ByteBuffer zzm() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARNING: Removed duplicated region for block: B:171:0x03ab A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:187:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x016d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzn(com.google.android.gms.internal.ads.zzfa r23, int r24, int r25, int r26, int r27, java.lang.String r28, boolean r29, com.google.android.gms.internal.ads.zzad r30, com.google.android.gms.internal.ads.zzagi r31, int r32) throws com.google.android.gms.internal.ads.zzcd {
        /*
            r0 = r23
            r1 = r25
            r2 = r26
            r3 = r27
            r4 = r28
            r5 = r30
            r6 = r31
            int r7 = r1 + 16
            r0.zzF(r7)
            r7 = 6
            if (r29 == 0) goto L_0x001e
            int r9 = r23.zzo()
            r0.zzG(r7)
            goto L_0x0024
        L_0x001e:
            r9 = 8
            r0.zzG(r9)
            r9 = 0
        L_0x0024:
            r10 = 20
            r11 = 2
            r12 = 1
            r13 = 16
            if (r9 == 0) goto L_0x004b
            if (r9 != r12) goto L_0x002f
            goto L_0x004b
        L_0x002f:
            if (r9 != r11) goto L_0x004a
            r0.zzG(r13)
            long r13 = r23.zzr()
            double r13 = java.lang.Double.longBitsToDouble(r13)
            long r13 = java.lang.Math.round(r13)
            int r7 = (int) r13
            int r9 = r23.zzn()
            r0.zzG(r10)
            r15 = 0
            goto L_0x0069
        L_0x004a:
            return
        L_0x004b:
            int r14 = r23.zzo()
            r0.zzG(r7)
            int r7 = r23.zzl()
            int r15 = r23.zzc()
            int r15 = r15 + -4
            r0.zzF(r15)
            int r15 = r23.zze()
            if (r9 != r12) goto L_0x0068
            r0.zzG(r13)
        L_0x0068:
            r9 = r14
        L_0x0069:
            int r13 = r23.zzc()
            r14 = 1701733217(0x656e6361, float:7.0359778E22)
            r11 = r24
            if (r11 != r14) goto L_0x009c
            android.util.Pair r11 = zzj(r0, r1, r2)
            if (r11 == 0) goto L_0x0098
            java.lang.Object r14 = r11.first
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            if (r5 != 0) goto L_0x0086
            r5 = 0
            goto L_0x0090
        L_0x0086:
            java.lang.Object r12 = r11.second
            com.google.android.gms.internal.ads.zzahd r12 = (com.google.android.gms.internal.ads.zzahd) r12
            java.lang.String r12 = r12.zzb
            com.google.android.gms.internal.ads.zzad r5 = r5.zzb(r12)
        L_0x0090:
            com.google.android.gms.internal.ads.zzahd[] r12 = r6.zza
            java.lang.Object r11 = r11.second
            com.google.android.gms.internal.ads.zzahd r11 = (com.google.android.gms.internal.ads.zzahd) r11
            r12[r32] = r11
        L_0x0098:
            r0.zzF(r13)
            r11 = r14
        L_0x009c:
            r12 = 1633889587(0x61632d33, float:2.6191674E20)
            r14 = 1634492771(0x616c6163, float:2.7252807E20)
            java.lang.String r10 = "audio/ac4"
            if (r11 != r12) goto L_0x00ad
            java.lang.String r11 = "audio/ac3"
        L_0x00a8:
            r18 = r11
        L_0x00aa:
            r11 = -1
            goto L_0x0161
        L_0x00ad:
            r12 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r11 != r12) goto L_0x00b5
            java.lang.String r11 = "audio/eac3"
            goto L_0x00a8
        L_0x00b5:
            r12 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r11 != r12) goto L_0x00bd
            r18 = r10
            goto L_0x00aa
        L_0x00bd:
            r12 = 1685353315(0x64747363, float:1.803728E22)
            if (r11 != r12) goto L_0x00c5
            java.lang.String r11 = "audio/vnd.dts"
            goto L_0x00a8
        L_0x00c5:
            r12 = 1685353320(0x64747368, float:1.8037286E22)
            if (r11 == r12) goto L_0x015d
            r12 = 1685353324(0x6474736c, float:1.803729E22)
            if (r11 != r12) goto L_0x00d1
            goto L_0x015d
        L_0x00d1:
            r12 = 1685353317(0x64747365, float:1.8037282E22)
            if (r11 != r12) goto L_0x00d9
            java.lang.String r11 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x00a8
        L_0x00d9:
            r12 = 1685353336(0x64747378, float:1.8037304E22)
            if (r11 != r12) goto L_0x00e1
            java.lang.String r11 = "audio/vnd.dts.uhd;profile=p2"
            goto L_0x00a8
        L_0x00e1:
            r12 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r11 != r12) goto L_0x00e9
            java.lang.String r11 = "audio/3gpp"
            goto L_0x00a8
        L_0x00e9:
            r12 = 1935767394(0x73617762, float:1.7863284E31)
            if (r11 != r12) goto L_0x00f1
            java.lang.String r11 = "audio/amr-wb"
            goto L_0x00a8
        L_0x00f1:
            r12 = 1819304813(0x6c70636d, float:1.1624469E27)
            java.lang.String r18 = "audio/raw"
            if (r11 == r12) goto L_0x015b
            r12 = 1936684916(0x736f7774, float:1.89725E31)
            if (r11 != r12) goto L_0x00fe
            goto L_0x015b
        L_0x00fe:
            r12 = 1953984371(0x74776f73, float:7.841539E31)
            if (r11 != r12) goto L_0x0106
            r11 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0161
        L_0x0106:
            r12 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r11 == r12) goto L_0x0157
            r12 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r11 != r12) goto L_0x0111
            goto L_0x0157
        L_0x0111:
            r12 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r11 != r12) goto L_0x0119
            java.lang.String r11 = "audio/mha1"
            goto L_0x00a8
        L_0x0119:
            r12 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r11 != r12) goto L_0x0121
            java.lang.String r11 = "audio/mhm1"
            goto L_0x00a8
        L_0x0121:
            if (r11 != r14) goto L_0x0126
            java.lang.String r11 = "audio/alac"
            goto L_0x00a8
        L_0x0126:
            r12 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r11 != r12) goto L_0x012f
            java.lang.String r11 = "audio/g711-alaw"
            goto L_0x00a8
        L_0x012f:
            r12 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r11 != r12) goto L_0x0138
            java.lang.String r11 = "audio/g711-mlaw"
            goto L_0x00a8
        L_0x0138:
            r12 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r11 != r12) goto L_0x0141
            java.lang.String r11 = "audio/opus"
            goto L_0x00a8
        L_0x0141:
            r12 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r11 != r12) goto L_0x014a
            java.lang.String r11 = "audio/flac"
            goto L_0x00a8
        L_0x014a:
            r12 = 1835823201(0x6d6c7061, float:4.573395E27)
            if (r11 != r12) goto L_0x0153
            java.lang.String r11 = "audio/true-hd"
            goto L_0x00a8
        L_0x0153:
            r11 = -1
            r18 = 0
            goto L_0x0161
        L_0x0157:
            java.lang.String r11 = "audio/mpeg"
            goto L_0x00a8
        L_0x015b:
            r11 = 2
            goto L_0x0161
        L_0x015d:
            java.lang.String r11 = "audio/vnd.dts.hd"
            goto L_0x00a8
        L_0x0161:
            r12 = r18
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x0169:
            int r8 = r13 - r1
            if (r8 >= r2) goto L_0x03a5
            r0.zzF(r13)
            int r8 = r23.zze()
            if (r8 <= 0) goto L_0x0178
            r14 = 1
            goto L_0x0179
        L_0x0178:
            r14 = 0
        L_0x0179:
            java.lang.String r1 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzaba.zzb(r14, r1)
            int r14 = r23.zze()
            r2 = 1835557187(0x6d686143, float:4.4948815E27)
            if (r14 != r2) goto L_0x01a3
            int r1 = r8 + -13
            int r2 = r13 + 13
            byte[] r14 = new byte[r1]
            r0.zzF(r2)
            r2 = 0
            r0.zzB(r14, r2, r1)
            com.google.android.gms.internal.ads.zzfsc r20 = com.google.android.gms.internal.ads.zzfsc.zzm(r14)
            r21 = r11
        L_0x019a:
            r11 = 0
            r14 = 20
            r16 = 2
            r17 = 1
            goto L_0x0399
        L_0x01a3:
            r2 = 1702061171(0x65736473, float:7.183675E22)
            if (r14 == r2) goto L_0x0365
            if (r29 == 0) goto L_0x01fa
            r2 = 2002876005(0x77617665, float:4.5729223E33)
            if (r14 != r2) goto L_0x01fa
            int r2 = r23.zzc()
            if (r2 < r13) goto L_0x01ba
            r21 = r2
            r2 = 0
            r14 = 1
            goto L_0x01be
        L_0x01ba:
            r21 = r2
            r2 = 0
            r14 = 0
        L_0x01be:
            com.google.android.gms.internal.ads.zzaba.zzb(r14, r2)
            r2 = r21
        L_0x01c3:
            int r14 = r2 - r13
            if (r14 >= r8) goto L_0x01ed
            r0.zzF(r2)
            int r14 = r23.zze()
            if (r14 <= 0) goto L_0x01d4
            r21 = r11
            r11 = 1
            goto L_0x01d7
        L_0x01d4:
            r21 = r11
            r11 = 0
        L_0x01d7:
            com.google.android.gms.internal.ads.zzaba.zzb(r11, r1)
            int r11 = r23.zze()
            r22 = r1
            r1 = 1702061171(0x65736473, float:7.183675E22)
            if (r11 == r1) goto L_0x01eb
            int r2 = r2 + r14
            r11 = r21
            r1 = r22
            goto L_0x01c3
        L_0x01eb:
            r1 = -1
            goto L_0x01f1
        L_0x01ed:
            r21 = r11
            r1 = -1
            r2 = -1
        L_0x01f1:
            r11 = 0
            r14 = 20
            r16 = 2
            r17 = 1
            goto L_0x0370
        L_0x01fa:
            r21 = r11
            r1 = 1684103987(0x64616333, float:1.6630662E22)
            if (r14 != r1) goto L_0x0211
            int r1 = r13 + 8
            r0.zzF(r1)
            java.lang.String r1 = java.lang.Integer.toString(r27)
            com.google.android.gms.internal.ads.zzam r1 = com.google.android.gms.internal.ads.zzzx.zzc(r0, r1, r4, r5)
            r6.zzb = r1
            goto L_0x019a
        L_0x0211:
            r1 = 1684366131(0x64656333, float:1.692581E22)
            if (r14 != r1) goto L_0x0227
            int r1 = r13 + 8
            r0.zzF(r1)
            java.lang.String r1 = java.lang.Integer.toString(r27)
            com.google.android.gms.internal.ads.zzam r1 = com.google.android.gms.internal.ads.zzzx.zzd(r0, r1, r4, r5)
            r6.zzb = r1
            goto L_0x019a
        L_0x0227:
            r1 = 1684103988(0x64616334, float:1.6630663E22)
            if (r14 != r1) goto L_0x026c
            int r1 = r13 + 8
            r0.zzF(r1)
            java.lang.String r1 = java.lang.Integer.toString(r27)
            int r2 = com.google.android.gms.internal.ads.zzaaa.zza
            r2 = 1
            r0.zzG(r2)
            int r11 = r23.zzk()
            r11 = r11 & 32
            com.google.android.gms.internal.ads.zzak r14 = new com.google.android.gms.internal.ads.zzak
            r14.<init>()
            r14.zzH(r1)
            r14.zzS(r10)
            r1 = 2
            r14.zzw(r1)
            int r1 = r11 >> 5
            if (r2 == r1) goto L_0x0258
            r1 = 44100(0xac44, float:6.1797E-41)
            goto L_0x025b
        L_0x0258:
            r1 = 48000(0xbb80, float:6.7262E-41)
        L_0x025b:
            r14.zzT(r1)
            r14.zzB(r5)
            r14.zzK(r4)
            com.google.android.gms.internal.ads.zzam r1 = r14.zzY()
            r6.zzb = r1
            goto L_0x019a
        L_0x026c:
            r1 = 1684892784(0x646d6c70, float:1.7518768E22)
            if (r14 != r1) goto L_0x028e
            if (r15 <= 0) goto L_0x0277
            r7 = r15
            r9 = 2
            goto L_0x019a
        L_0x0277:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid sample rate for Dolby TrueHD MLP stream: "
            r0.append(r1)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            r1 = 0
            com.google.android.gms.internal.ads.zzcd r0 = com.google.android.gms.internal.ads.zzcd.zza(r0, r1)
            throw r0
        L_0x028e:
            r1 = 0
            r2 = 1684305011(0x64647473, float:1.6856995E22)
            if (r14 == r2) goto L_0x033d
            r2 = 1969517683(0x75647473, float:2.8960097E32)
            if (r14 != r2) goto L_0x029b
            goto L_0x033d
        L_0x029b:
            r2 = 1682927731(0x644f7073, float:1.5306315E22)
            if (r14 != r2) goto L_0x02b9
            int r2 = r8 + -8
            byte[] r11 = zza
            int r14 = r11.length
            int r14 = r14 + r2
            byte[] r14 = java.util.Arrays.copyOf(r11, r14)
            int r1 = r13 + 8
            r0.zzF(r1)
            int r1 = r11.length
            r0.zzB(r14, r1, r2)
            java.util.List r20 = com.google.android.gms.internal.ads.zzabr.zzd(r14)
            goto L_0x019a
        L_0x02b9:
            r1 = 1684425825(0x64664c61, float:1.6993019E22)
            if (r14 != r1) goto L_0x02ec
            int r1 = r8 + -12
            int r2 = r1 + 4
            byte[] r2 = new byte[r2]
            r11 = 102(0x66, float:1.43E-43)
            r14 = 0
            r2[r14] = r11
            r11 = 76
            r17 = 1
            r2[r17] = r11
            r11 = 97
            r16 = 2
            r2[r16] = r11
            r11 = 3
            r14 = 67
            r2[r11] = r14
            int r11 = r13 + 12
            r0.zzF(r11)
            r11 = 4
            r0.zzB(r2, r11, r1)
            com.google.android.gms.internal.ads.zzfsc r20 = com.google.android.gms.internal.ads.zzfsc.zzm(r2)
        L_0x02e7:
            r11 = 0
            r14 = 20
            goto L_0x0399
        L_0x02ec:
            r1 = 1634492771(0x616c6163, float:2.7252807E20)
            r16 = 2
            r17 = 1
            if (r14 != r1) goto L_0x02e7
            int r2 = r8 + -12
            int r7 = r13 + 12
            byte[] r9 = new byte[r2]
            r0.zzF(r7)
            r11 = 0
            r0.zzB(r9, r11, r2)
            int r2 = com.google.android.gms.internal.ads.zzea.zza
            com.google.android.gms.internal.ads.zzfa r2 = new com.google.android.gms.internal.ads.zzfa
            r2.<init>((byte[]) r9)
            r7 = 9
            r2.zzF(r7)
            int r7 = r2.zzk()
            r14 = 20
            r2.zzF(r14)
            int r2 = r2.zzn()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            android.util.Pair r2 = android.util.Pair.create(r2, r7)
            java.lang.Object r7 = r2.first
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r2 = r2.second
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            com.google.android.gms.internal.ads.zzfsc r20 = com.google.android.gms.internal.ads.zzfsc.zzm(r9)
            r9 = r2
            goto L_0x0399
        L_0x033d:
            r1 = 1634492771(0x616c6163, float:2.7252807E20)
            r11 = 0
            r14 = 20
            r16 = 2
            r17 = 1
            com.google.android.gms.internal.ads.zzak r2 = new com.google.android.gms.internal.ads.zzak
            r2.<init>()
            r2.zzG(r3)
            r2.zzS(r12)
            r2.zzw(r9)
            r2.zzT(r7)
            r2.zzB(r5)
            r2.zzK(r4)
            com.google.android.gms.internal.ads.zzam r2 = r2.zzY()
            r6.zzb = r2
            goto L_0x0399
        L_0x0365:
            r21 = r11
            r11 = 0
            r14 = 20
            r16 = 2
            r17 = 1
            r2 = r13
            r1 = -1
        L_0x0370:
            if (r2 == r1) goto L_0x0399
            com.google.android.gms.internal.ads.zzagg r18 = zzl(r0, r2)
            java.lang.String r2 = r18.zza
            byte[] r12 = r18.zzb
            if (r12 == 0) goto L_0x0398
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0394
            com.google.android.gms.internal.ads.zzzt r1 = com.google.android.gms.internal.ads.zzzu.zza(r12)
            int r7 = r1.zza
            int r9 = r1.zzb
            java.lang.String r1 = r1.zzc
            r19 = r1
        L_0x0394:
            com.google.android.gms.internal.ads.zzfsc r20 = com.google.android.gms.internal.ads.zzfsc.zzm(r12)
        L_0x0398:
            r12 = r2
        L_0x0399:
            int r13 = r13 + r8
            r1 = r25
            r2 = r26
            r11 = r21
            r14 = 1634492771(0x616c6163, float:2.7252807E20)
            goto L_0x0169
        L_0x03a5:
            r21 = r11
            com.google.android.gms.internal.ads.zzam r0 = r6.zzb
            if (r0 != 0) goto L_0x03f1
            if (r12 == 0) goto L_0x03f1
            com.google.android.gms.internal.ads.zzak r0 = new com.google.android.gms.internal.ads.zzak
            r0.<init>()
            r0.zzG(r3)
            r0.zzS(r12)
            r1 = r19
            r0.zzx(r1)
            r0.zzw(r9)
            r0.zzT(r7)
            r8 = r21
            r0.zzN(r8)
            r1 = r20
            r0.zzI(r1)
            r0.zzB(r5)
            r0.zzK(r4)
            if (r18 == 0) goto L_0x03eb
            long r1 = r18.zzc
            int r1 = com.google.android.gms.internal.ads.zzfuk.zzc(r1)
            r0.zzv(r1)
            long r1 = r18.zzd
            int r1 = com.google.android.gms.internal.ads.zzfuk.zzc(r1)
            r0.zzO(r1)
        L_0x03eb:
            com.google.android.gms.internal.ads.zzam r0 = r0.zzY()
            r6.zzb = r0
        L_0x03f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagn.zzn(com.google.android.gms.internal.ads.zzfa, int, int, int, int, java.lang.String, boolean, com.google.android.gms.internal.ads.zzad, com.google.android.gms.internal.ads.zzagi, int):void");
    }

    private static void zzo(zzfa zzfa, int i2, int i3, int i4, zzagi zzagi) {
        zzfa.zzF(i3 + 16);
        zzfa.zzv(0);
        String zzv = zzfa.zzv(0);
        if (zzv != null) {
            zzak zzak = new zzak();
            zzak.zzG(i4);
            zzak.zzS(zzv);
            zzagi.zzb = zzak.zzY();
        }
    }

    private static boolean zzp(long[] jArr, long j2, long j3, long j4) {
        int length = jArr.length;
        int i2 = length - 1;
        int max = Math.max(0, Math.min(4, i2));
        int max2 = Math.max(0, Math.min(length - 4, i2));
        if (jArr[0] > j3 || j3 >= jArr[max] || jArr[max2] >= j4 || j4 > j2) {
            return false;
        }
        return true;
    }

    private static byte[] zzq(zzfa zzfa, int i2, int i3) {
        int i4 = i2 + 8;
        while (i4 - i2 < i3) {
            zzfa.zzF(i4);
            int zze = zzfa.zze();
            if (zzfa.zze() == 1886547818) {
                return Arrays.copyOfRange(zzfa.zzH(), i4, zze + i4);
            }
            i4 += zze;
        }
        return null;
    }
}
