package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

public final class zzaem {
    public static final zzaek zza = zzaej.zza;

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00af A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.google.android.gms.internal.ads.zzbz zza(byte[] r11, int r12, com.google.android.gms.internal.ads.zzaek r13, com.google.android.gms.internal.ads.zzadn r14) {
        /*
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            com.google.android.gms.internal.ads.zzfa r0 = new com.google.android.gms.internal.ads.zzfa
            r0.<init>(r11, r12)
            int r11 = r0.zza()
            r12 = 2
            r1 = 4
            r2 = 0
            r3 = 1
            java.lang.String r4 = "Id3Decoder"
            r5 = 0
            r6 = 10
            if (r11 >= r6) goto L_0x0021
            java.lang.String r11 = "Data too short to be an ID3 tag"
            com.google.android.gms.internal.ads.zzer.zzf(r4, r11)
        L_0x001e:
            r9 = r5
            goto L_0x00ad
        L_0x0021:
            int r11 = r0.zzm()
            r7 = 4801587(0x494433, float:6.728456E-39)
            if (r11 == r7) goto L_0x0046
            java.lang.Object[] r7 = new java.lang.Object[r3]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r7[r2] = r11
            java.lang.String r11 = "%06X"
            java.lang.String r11 = java.lang.String.format(r11, r7)
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r7 = "Unexpected first three bytes of ID3 tag header: 0x"
            java.lang.String r11 = r7.concat(r11)
            com.google.android.gms.internal.ads.zzer.zzf(r4, r11)
            goto L_0x001e
        L_0x0046:
            int r11 = r0.zzk()
            r0.zzG(r3)
            int r7 = r0.zzk()
            int r8 = r0.zzj()
            if (r11 != r12) goto L_0x0061
            r9 = r7 & 64
            if (r9 == 0) goto L_0x0088
            java.lang.String r11 = "Skipped ID3 tag with majorVersion=2 and undefined compression scheme"
            com.google.android.gms.internal.ads.zzer.zzf(r4, r11)
            goto L_0x001e
        L_0x0061:
            r9 = 3
            if (r11 != r9) goto L_0x0072
            r9 = r7 & 64
            if (r9 == 0) goto L_0x0088
            int r9 = r0.zze()
            r0.zzG(r9)
            int r9 = r9 + r1
            int r8 = r8 - r9
            goto L_0x0088
        L_0x0072:
            if (r11 != r1) goto L_0x0097
            r9 = r7 & 64
            if (r9 == 0) goto L_0x0082
            int r9 = r0.zzj()
            int r10 = r9 + -4
            r0.zzG(r10)
            int r8 = r8 - r9
        L_0x0082:
            r9 = r7 & 16
            if (r9 == 0) goto L_0x0088
            int r8 = r8 + -10
        L_0x0088:
            if (r11 >= r1) goto L_0x0090
            r7 = r7 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0090
            r7 = 1
            goto L_0x0091
        L_0x0090:
            r7 = 0
        L_0x0091:
            com.google.android.gms.internal.ads.zzael r9 = new com.google.android.gms.internal.ads.zzael
            r9.<init>(r11, r7, r8)
            goto L_0x00ad
        L_0x0097:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Skipped ID3 tag with unsupported majorVersion="
            r7.append(r8)
            r7.append(r11)
            java.lang.String r11 = r7.toString()
            com.google.android.gms.internal.ads.zzer.zzf(r4, r11)
            goto L_0x001e
        L_0x00ad:
            if (r9 != 0) goto L_0x00b0
            return r5
        L_0x00b0:
            int r11 = r0.zzc()
            int r7 = r9.zza
            if (r7 != r12) goto L_0x00bb
            r6 = 6
        L_0x00bb:
            int r12 = r9.zzc
            boolean r7 = r9.zzb
            if (r7 == 0) goto L_0x00cd
            int r12 = r9.zzc
            int r12 = zze(r0, r12)
        L_0x00cd:
            int r11 = r11 + r12
            r0.zzE(r11)
            int r11 = r9.zza
            boolean r11 = zzk(r0, r11, r6, r2)
            if (r11 != 0) goto L_0x0102
            int r11 = r9.zza
            if (r11 != r1) goto L_0x00e9
            boolean r11 = zzk(r0, r1, r6, r3)
            if (r11 == 0) goto L_0x00e9
            r2 = 1
            goto L_0x0102
        L_0x00e9:
            int r11 = r9.zza
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Failed to validate ID3 tag with majorVersion="
            r12.append(r13)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            com.google.android.gms.internal.ads.zzer.zzf(r4, r11)
            return r5
        L_0x0102:
            int r11 = r0.zza()
            if (r11 < r6) goto L_0x0116
            int r11 = r9.zza
            com.google.android.gms.internal.ads.zzaen r11 = zzf(r11, r0, r2, r6, r13)
            if (r11 == 0) goto L_0x0102
            r14.add(r11)
            goto L_0x0102
        L_0x0116:
            com.google.android.gms.internal.ads.zzbz r11 = new com.google.android.gms.internal.ads.zzbz
            r11.<init>((java.util.List) r14)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaem.zza(byte[], int, com.google.android.gms.internal.ads.zzaek, com.google.android.gms.internal.ads.zzadn):com.google.android.gms.internal.ads.zzbz");
    }

    private static int zzb(int i2) {
        return (i2 == 0 || i2 == 3) ? 1 : 2;
    }

    private static int zzc(byte[] bArr, int i2, int i3) {
        int zzd = zzd(bArr, i2);
        if (i3 == 0 || i3 == 3) {
            return zzd;
        }
        while (true) {
            int length = bArr.length;
            if (zzd >= length - 1) {
                return length;
            }
            if ((zzd - i2) % 2 == 0 && bArr[zzd + 1] == 0) {
                return zzd;
            }
            zzd = zzd(bArr, zzd + 1);
        }
    }

    private static int zzd(byte[] bArr, int i2) {
        while (true) {
            int length = bArr.length;
            if (i2 >= length) {
                return length;
            }
            if (bArr[i2] == 0) {
                return i2;
            }
            i2++;
        }
    }

    private static int zze(zzfa zzfa, int i2) {
        byte[] zzH = zzfa.zzH();
        int zzc = zzfa.zzc();
        int i3 = zzc;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= zzc + i2) {
                return i2;
            }
            if ((zzH[i3] & 255) == 255 && zzH[i4] == 0) {
                System.arraycopy(zzH, i3 + 2, zzH, i4, (i2 - (i3 - zzc)) - 2);
                i2--;
            }
            i3 = i4;
        }
    }

    /* JADX WARNING: type inference failed for: r13v1, types: [com.google.android.gms.internal.ads.zzaen] */
    /* JADX WARNING: type inference failed for: r13v19, types: [com.google.android.gms.internal.ads.zzaeg] */
    /* JADX WARNING: type inference failed for: r13v20 */
    /* JADX WARNING: type inference failed for: r13v24, types: [com.google.android.gms.internal.ads.zzady] */
    /* JADX WARNING: type inference failed for: r13v45 */
    /* JADX WARNING: type inference failed for: r13v47 */
    /* JADX WARNING: type inference failed for: r13v49 */
    /* JADX WARNING: type inference failed for: r16v4, types: [com.google.android.gms.internal.ads.zzaer] */
    /* JADX WARNING: type inference failed for: r25v2, types: [com.google.android.gms.internal.ads.zzaee] */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x026e, code lost:
        if (r9 == 67) goto L_0x0270;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0482 A[Catch:{ all -> 0x051a }] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x04de A[Catch:{ all -> 0x051a }] */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x04f5 A[Catch:{ all -> 0x051a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzaen zzf(int r35, com.google.android.gms.internal.ads.zzfa r36, boolean r37, int r38, com.google.android.gms.internal.ads.zzaek r39) {
        /*
            r0 = r35
            r1 = r36
            r2 = r37
            r3 = r38
            int r4 = r36.zzk()
            int r5 = r36.zzk()
            int r6 = r36.zzk()
            r8 = 3
            if (r0 < r8) goto L_0x001c
            int r9 = r36.zzk()
            goto L_0x001d
        L_0x001c:
            r9 = 0
        L_0x001d:
            r10 = 4
            if (r0 != r10) goto L_0x003c
            int r11 = r36.zzn()
            if (r2 != 0) goto L_0x0047
            r12 = r11 & 255(0xff, float:3.57E-43)
            int r13 = r11 >> 8
            int r14 = r11 >> 16
            int r11 = r11 >> 24
            r13 = r13 & 255(0xff, float:3.57E-43)
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r13 = r13 << 7
            r12 = r12 | r13
            int r13 = r14 << 14
            r12 = r12 | r13
            int r11 = r11 << 21
            r11 = r11 | r12
            goto L_0x0047
        L_0x003c:
            if (r0 != r8) goto L_0x0043
            int r11 = r36.zzn()
            goto L_0x0047
        L_0x0043:
            int r11 = r36.zzm()
        L_0x0047:
            if (r0 < r8) goto L_0x004e
            int r12 = r36.zzo()
            goto L_0x004f
        L_0x004e:
            r12 = 0
        L_0x004f:
            r13 = 0
            if (r4 != 0) goto L_0x0065
            if (r5 != 0) goto L_0x0065
            if (r6 != 0) goto L_0x0065
            if (r9 != 0) goto L_0x0065
            if (r11 != 0) goto L_0x0065
            if (r12 == 0) goto L_0x005d
            goto L_0x0065
        L_0x005d:
            int r0 = r36.zzd()
            r1.zzF(r0)
            return r13
        L_0x0065:
            int r14 = r36.zzc()
            int r14 = r14 + r11
            int r15 = r36.zzd()
            java.lang.String r7 = "Id3Decoder"
            if (r14 <= r15) goto L_0x007f
            java.lang.String r0 = "Frame size exceeds remaining tag data"
            com.google.android.gms.internal.ads.zzer.zzf(r7, r0)
            int r0 = r36.zzd()
            r1.zzF(r0)
            return r13
        L_0x007f:
            if (r39 != 0) goto L_0x0533
            r15 = 1
            if (r0 != r8) goto L_0x00a2
            r8 = r12 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x008a
            r8 = 1
            goto L_0x008b
        L_0x008a:
            r8 = 0
        L_0x008b:
            r17 = r12 & 64
            if (r17 == 0) goto L_0x0092
            r17 = 1
            goto L_0x0094
        L_0x0092:
            r17 = 0
        L_0x0094:
            r12 = r12 & 32
            if (r12 == 0) goto L_0x009a
            r12 = 1
            goto L_0x009b
        L_0x009a:
            r12 = 0
        L_0x009b:
            r18 = r17
            r19 = 0
            r17 = r8
            goto L_0x00d5
        L_0x00a2:
            if (r0 != r10) goto L_0x00cd
            r8 = r12 & 64
            if (r8 == 0) goto L_0x00aa
            r8 = 1
            goto L_0x00ab
        L_0x00aa:
            r8 = 0
        L_0x00ab:
            r17 = r12 & 8
            if (r17 == 0) goto L_0x00b2
            r17 = 1
            goto L_0x00b4
        L_0x00b2:
            r17 = 0
        L_0x00b4:
            r18 = r12 & 4
            if (r18 == 0) goto L_0x00bb
            r18 = 1
            goto L_0x00bd
        L_0x00bb:
            r18 = 0
        L_0x00bd:
            r19 = r12 & 2
            if (r19 == 0) goto L_0x00c4
            r19 = 1
            goto L_0x00c6
        L_0x00c4:
            r19 = 0
        L_0x00c6:
            r12 = r12 & r15
            r34 = r12
            r12 = r8
            r8 = r34
            goto L_0x00d5
        L_0x00cd:
            r8 = 0
            r12 = 0
            r17 = 0
            r18 = 0
            r19 = 0
        L_0x00d5:
            if (r17 != 0) goto L_0x0528
            if (r18 == 0) goto L_0x00db
            goto L_0x0528
        L_0x00db:
            if (r12 == 0) goto L_0x00e2
            r1.zzG(r15)
            int r11 = r11 + -1
        L_0x00e2:
            if (r8 == 0) goto L_0x00e9
            r1.zzG(r10)
            int r11 = r11 + -4
        L_0x00e9:
            if (r19 == 0) goto L_0x00ef
            int r11 = zze(r1, r11)
        L_0x00ef:
            r8 = 84
            r12 = 88
            r10 = 2
            if (r4 != r8) goto L_0x012b
            if (r5 != r12) goto L_0x012b
            if (r6 != r12) goto L_0x012b
            if (r0 == r10) goto L_0x00fe
            if (r9 != r12) goto L_0x012b
        L_0x00fe:
            if (r11 > 0) goto L_0x0101
            goto L_0x0133
        L_0x0101:
            int r2 = r36.zzk()     // Catch:{ all -> 0x015b }
            int r3 = r11 + -1
            byte[] r8 = new byte[r3]     // Catch:{ all -> 0x015b }
            r10 = 0
            r1.zzB(r8, r10, r3)     // Catch:{ all -> 0x015b }
            int r3 = zzc(r8, r10, r2)     // Catch:{ all -> 0x015b }
            java.lang.String r12 = new java.lang.String     // Catch:{ all -> 0x015b }
            java.nio.charset.Charset r13 = zzj(r2)     // Catch:{ all -> 0x015b }
            r12.<init>(r8, r10, r3, r13)     // Catch:{ all -> 0x015b }
            int r10 = zzb(r2)     // Catch:{ all -> 0x015b }
            int r3 = r3 + r10
            com.google.android.gms.internal.ads.zzfsc r2 = zzg(r8, r2, r3)     // Catch:{ all -> 0x015b }
            com.google.android.gms.internal.ads.zzaev r13 = new com.google.android.gms.internal.ads.zzaev     // Catch:{ all -> 0x015b }
            java.lang.String r3 = "TXXX"
            r13.<init>(r3, r12, r2)     // Catch:{ all -> 0x015b }
            goto L_0x0133
        L_0x012b:
            if (r4 != r8) goto L_0x015e
            java.lang.String r2 = zzi(r0, r8, r5, r6, r9)     // Catch:{ all -> 0x015b }
            if (r11 > 0) goto L_0x013e
        L_0x0133:
            r24 = r4
            r3 = r5
            r4 = r6
            r23 = r7
        L_0x0139:
            r7 = r9
            r22 = r14
            goto L_0x04f3
        L_0x013e:
            int r3 = r36.zzk()     // Catch:{ all -> 0x015b }
            int r8 = r11 + -1
            byte[] r10 = new byte[r8]     // Catch:{ all -> 0x015b }
            r12 = 0
            r1.zzB(r10, r12, r8)     // Catch:{ all -> 0x015b }
            com.google.android.gms.internal.ads.zzfsc r3 = zzg(r10, r3, r12)     // Catch:{ all -> 0x015b }
            com.google.android.gms.internal.ads.zzaev r8 = new com.google.android.gms.internal.ads.zzaev     // Catch:{ all -> 0x015b }
            r8.<init>(r2, r13, r3)     // Catch:{ all -> 0x015b }
            r24 = r4
            r3 = r5
            r4 = r6
            r23 = r7
            r13 = r8
            goto L_0x0139
        L_0x015b:
            r0 = move-exception
            goto L_0x0524
        L_0x015e:
            r8 = 87
            if (r4 != r8) goto L_0x01a0
            if (r5 != r12) goto L_0x019d
            if (r6 != r12) goto L_0x019d
            if (r0 == r10) goto L_0x016a
            if (r9 != r12) goto L_0x019d
        L_0x016a:
            if (r11 > 0) goto L_0x016d
            goto L_0x0133
        L_0x016d:
            int r2 = r36.zzk()     // Catch:{ all -> 0x015b }
            int r3 = r11 + -1
            byte[] r8 = new byte[r3]     // Catch:{ all -> 0x015b }
            r10 = 0
            r1.zzB(r8, r10, r3)     // Catch:{ all -> 0x015b }
            int r3 = zzc(r8, r10, r2)     // Catch:{ all -> 0x015b }
            java.lang.String r12 = new java.lang.String     // Catch:{ all -> 0x015b }
            java.nio.charset.Charset r13 = zzj(r2)     // Catch:{ all -> 0x015b }
            r12.<init>(r8, r10, r3, r13)     // Catch:{ all -> 0x015b }
            int r2 = zzb(r2)     // Catch:{ all -> 0x015b }
            int r3 = r3 + r2
            int r2 = zzd(r8, r3)     // Catch:{ all -> 0x015b }
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzfot.zzb     // Catch:{ all -> 0x015b }
            java.lang.String r2 = zzh(r8, r3, r2, r10)     // Catch:{ all -> 0x015b }
            com.google.android.gms.internal.ads.zzaex r13 = new com.google.android.gms.internal.ads.zzaex     // Catch:{ all -> 0x015b }
            java.lang.String r3 = "WXXX"
            r13.<init>(r3, r12, r2)     // Catch:{ all -> 0x015b }
            goto L_0x0133
        L_0x019d:
            r12 = 87
            goto L_0x01a1
        L_0x01a0:
            r12 = r4
        L_0x01a1:
            if (r12 != r8) goto L_0x01c0
            java.lang.String r2 = zzi(r0, r8, r5, r6, r9)     // Catch:{ all -> 0x015b }
            byte[] r3 = new byte[r11]     // Catch:{ all -> 0x015b }
            r8 = 0
            r1.zzB(r3, r8, r11)     // Catch:{ all -> 0x015b }
            int r10 = zzd(r3, r8)     // Catch:{ all -> 0x015b }
            java.lang.String r12 = new java.lang.String     // Catch:{ all -> 0x015b }
            java.nio.charset.Charset r15 = com.google.android.gms.internal.ads.zzfot.zzb     // Catch:{ all -> 0x015b }
            r12.<init>(r3, r8, r10, r15)     // Catch:{ all -> 0x015b }
            com.google.android.gms.internal.ads.zzaex r3 = new com.google.android.gms.internal.ads.zzaex     // Catch:{ all -> 0x015b }
            r3.<init>(r2, r13, r12)     // Catch:{ all -> 0x015b }
            r13 = r3
            goto L_0x0133
        L_0x01c0:
            r8 = 73
            r13 = 80
            if (r12 != r13) goto L_0x01ef
            r12 = 82
            if (r5 != r12) goto L_0x01ed
            if (r6 != r8) goto L_0x01ed
            r12 = 86
            if (r9 != r12) goto L_0x01ed
            byte[] r2 = new byte[r11]     // Catch:{ all -> 0x015b }
            r3 = 0
            r1.zzB(r2, r3, r11)     // Catch:{ all -> 0x015b }
            int r8 = zzd(r2, r3)     // Catch:{ all -> 0x015b }
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x015b }
            java.nio.charset.Charset r12 = com.google.android.gms.internal.ads.zzfot.zzb     // Catch:{ all -> 0x015b }
            r10.<init>(r2, r3, r8, r12)     // Catch:{ all -> 0x015b }
            int r8 = r8 + r15
            byte[] r2 = zzl(r2, r8, r11)     // Catch:{ all -> 0x015b }
            com.google.android.gms.internal.ads.zzaet r13 = new com.google.android.gms.internal.ads.zzaet     // Catch:{ all -> 0x015b }
            r13.<init>(r10, r2)     // Catch:{ all -> 0x015b }
            goto L_0x0133
        L_0x01ed:
            r12 = 80
        L_0x01ef:
            r8 = 79
            r13 = 71
            if (r12 != r13) goto L_0x0251
            r12 = 69
            if (r5 != r12) goto L_0x024c
            if (r6 != r8) goto L_0x024c
            r12 = 66
            if (r9 == r12) goto L_0x0201
            if (r0 != r10) goto L_0x024c
        L_0x0201:
            int r2 = r36.zzk()     // Catch:{ all -> 0x015b }
            java.nio.charset.Charset r3 = zzj(r2)     // Catch:{ all -> 0x015b }
            int r8 = r11 + -1
            byte[] r10 = new byte[r8]     // Catch:{ all -> 0x015b }
            r12 = 0
            r1.zzB(r10, r12, r8)     // Catch:{ all -> 0x015b }
            int r13 = zzd(r10, r12)     // Catch:{ all -> 0x015b }
            java.lang.String r15 = new java.lang.String     // Catch:{ all -> 0x015b }
            r22 = r14
            java.nio.charset.Charset r14 = com.google.android.gms.internal.ads.zzfot.zzb     // Catch:{ all -> 0x051a }
            r15.<init>(r10, r12, r13, r14)     // Catch:{ all -> 0x051a }
            r12 = 1
            int r13 = r13 + r12
            int r12 = zzc(r10, r13, r2)     // Catch:{ all -> 0x051a }
            java.lang.String r13 = zzh(r10, r13, r12, r3)     // Catch:{ all -> 0x051a }
            int r14 = zzb(r2)     // Catch:{ all -> 0x051a }
            int r12 = r12 + r14
            int r14 = zzc(r10, r12, r2)     // Catch:{ all -> 0x051a }
            java.lang.String r3 = zzh(r10, r12, r14, r3)     // Catch:{ all -> 0x051a }
            int r2 = zzb(r2)     // Catch:{ all -> 0x051a }
            int r14 = r14 + r2
            byte[] r2 = zzl(r10, r14, r8)     // Catch:{ all -> 0x051a }
            com.google.android.gms.internal.ads.zzaei r8 = new com.google.android.gms.internal.ads.zzaei     // Catch:{ all -> 0x051a }
            r8.<init>(r15, r13, r3, r2)     // Catch:{ all -> 0x051a }
            r24 = r4
            r3 = r5
            r4 = r6
            r23 = r7
            r13 = r8
            goto L_0x033d
        L_0x024c:
            r22 = r14
            r12 = 71
            goto L_0x0253
        L_0x0251:
            r22 = r14
        L_0x0253:
            r13 = 65
            r14 = 67
            if (r0 != r10) goto L_0x0264
            r15 = 80
            if (r12 != r15) goto L_0x02e9
            r8 = 73
            if (r5 != r8) goto L_0x02e9
            if (r6 != r14) goto L_0x02e9
            goto L_0x0270
        L_0x0264:
            r8 = 73
            r15 = 80
            if (r12 != r13) goto L_0x02e9
            if (r5 != r15) goto L_0x02e9
            if (r6 != r8) goto L_0x02e9
            if (r9 != r14) goto L_0x02e9
        L_0x0270:
            int r2 = r36.zzk()     // Catch:{ all -> 0x051a }
            java.nio.charset.Charset r3 = zzj(r2)     // Catch:{ all -> 0x051a }
            int r8 = r11 + -1
            byte[] r12 = new byte[r8]     // Catch:{ all -> 0x051a }
            r13 = 0
            r1.zzB(r12, r13, r8)     // Catch:{ all -> 0x051a }
            if (r0 != r10) goto L_0x02a4
            java.lang.String r14 = new java.lang.String     // Catch:{ all -> 0x051a }
            java.nio.charset.Charset r15 = com.google.android.gms.internal.ads.zzfot.zzb     // Catch:{ all -> 0x051a }
            r10 = 3
            r14.<init>(r12, r13, r10, r15)     // Catch:{ all -> 0x051a }
            java.lang.String r10 = com.google.android.gms.internal.ads.zzfon.zza(r14)     // Catch:{ all -> 0x051a }
            java.lang.String r13 = "image/"
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x051a }
            java.lang.String r10 = r13.concat(r10)     // Catch:{ all -> 0x051a }
            java.lang.String r13 = "image/jpg"
            boolean r13 = r13.equals(r10)     // Catch:{ all -> 0x051a }
            if (r13 == 0) goto L_0x02a2
            java.lang.String r10 = "image/jpeg"
        L_0x02a2:
            r13 = 2
            goto L_0x02c3
        L_0x02a4:
            r10 = 0
            int r13 = zzd(r12, r10)     // Catch:{ all -> 0x051a }
            java.lang.String r14 = new java.lang.String     // Catch:{ all -> 0x051a }
            java.nio.charset.Charset r15 = com.google.android.gms.internal.ads.zzfot.zzb     // Catch:{ all -> 0x051a }
            r14.<init>(r12, r10, r13, r15)     // Catch:{ all -> 0x051a }
            java.lang.String r10 = com.google.android.gms.internal.ads.zzfon.zza(r14)     // Catch:{ all -> 0x051a }
            r14 = 47
            int r14 = r10.indexOf(r14)     // Catch:{ all -> 0x051a }
            r15 = -1
            if (r14 != r15) goto L_0x02c3
            java.lang.String r14 = "image/"
            java.lang.String r10 = r14.concat(r10)     // Catch:{ all -> 0x051a }
        L_0x02c3:
            int r14 = r13 + 1
            byte r14 = r12[r14]     // Catch:{ all -> 0x051a }
            r14 = r14 & 255(0xff, float:3.57E-43)
            r15 = 2
            int r13 = r13 + r15
            int r15 = zzc(r12, r13, r2)     // Catch:{ all -> 0x051a }
            r23 = r7
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x051a }
            r24 = r4
            int r4 = r15 - r13
            r7.<init>(r12, r13, r4, r3)     // Catch:{ all -> 0x051a }
            int r2 = zzb(r2)     // Catch:{ all -> 0x051a }
            int r15 = r15 + r2
            byte[] r2 = zzl(r12, r15, r8)     // Catch:{ all -> 0x051a }
            com.google.android.gms.internal.ads.zzady r13 = new com.google.android.gms.internal.ads.zzady     // Catch:{ all -> 0x051a }
            r13.<init>(r10, r7, r14, r2)     // Catch:{ all -> 0x051a }
            goto L_0x033b
        L_0x02e9:
            r24 = r4
            r23 = r7
            r4 = 77
            if (r12 != r14) goto L_0x0340
            r7 = 79
            if (r5 != r7) goto L_0x0340
            if (r6 != r4) goto L_0x0340
            if (r9 == r4) goto L_0x02fc
            r7 = 2
            if (r0 != r7) goto L_0x0340
        L_0x02fc:
            r2 = 4
            if (r11 >= r2) goto L_0x0305
            r3 = r5
            r4 = r6
            r7 = r9
            r13 = 0
            goto L_0x04f3
        L_0x0305:
            int r2 = r36.zzk()     // Catch:{ all -> 0x051a }
            java.nio.charset.Charset r3 = zzj(r2)     // Catch:{ all -> 0x051a }
            r4 = 3
            byte[] r7 = new byte[r4]     // Catch:{ all -> 0x051a }
            r8 = 0
            r1.zzB(r7, r8, r4)     // Catch:{ all -> 0x051a }
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x051a }
            r10.<init>(r7, r8, r4)     // Catch:{ all -> 0x051a }
            int r4 = r11 + -4
            byte[] r7 = new byte[r4]     // Catch:{ all -> 0x051a }
            r1.zzB(r7, r8, r4)     // Catch:{ all -> 0x051a }
            int r4 = zzc(r7, r8, r2)     // Catch:{ all -> 0x051a }
            java.lang.String r12 = new java.lang.String     // Catch:{ all -> 0x051a }
            r12.<init>(r7, r8, r4, r3)     // Catch:{ all -> 0x051a }
            int r8 = zzb(r2)     // Catch:{ all -> 0x051a }
            int r4 = r4 + r8
            int r2 = zzc(r7, r4, r2)     // Catch:{ all -> 0x051a }
            java.lang.String r2 = zzh(r7, r4, r2, r3)     // Catch:{ all -> 0x051a }
            com.google.android.gms.internal.ads.zzaeg r13 = new com.google.android.gms.internal.ads.zzaeg     // Catch:{ all -> 0x051a }
            r13.<init>(r10, r12, r2)     // Catch:{ all -> 0x051a }
        L_0x033b:
            r3 = r5
            r4 = r6
        L_0x033d:
            r7 = r9
            goto L_0x04f3
        L_0x0340:
            if (r12 != r14) goto L_0x03c1
            r7 = 72
            if (r5 != r7) goto L_0x03c1
            if (r6 != r13) goto L_0x03c1
            r7 = 80
            if (r9 != r7) goto L_0x03c1
            int r4 = r36.zzc()     // Catch:{ all -> 0x051a }
            byte[] r7 = r36.zzH()     // Catch:{ all -> 0x051a }
            int r7 = zzd(r7, r4)     // Catch:{ all -> 0x051a }
            java.lang.String r8 = new java.lang.String     // Catch:{ all -> 0x051a }
            byte[] r10 = r36.zzH()     // Catch:{ all -> 0x051a }
            int r12 = r7 - r4
            java.nio.charset.Charset r13 = com.google.android.gms.internal.ads.zzfot.zzb     // Catch:{ all -> 0x051a }
            r8.<init>(r10, r4, r12, r13)     // Catch:{ all -> 0x051a }
            r10 = 1
            int r7 = r7 + r10
            r1.zzF(r7)     // Catch:{ all -> 0x051a }
            int r27 = r36.zze()     // Catch:{ all -> 0x051a }
            int r28 = r36.zze()     // Catch:{ all -> 0x051a }
            long r12 = r36.zzs()     // Catch:{ all -> 0x051a }
            r14 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r7 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r7 != 0) goto L_0x0381
            r12 = -1
        L_0x0381:
            r29 = r12
            long r12 = r36.zzs()     // Catch:{ all -> 0x051a }
            r14 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r7 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r7 != 0) goto L_0x0392
            r12 = -1
        L_0x0392:
            r31 = r12
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x051a }
            r7.<init>()     // Catch:{ all -> 0x051a }
            int r4 = r4 + r11
        L_0x039a:
            int r10 = r36.zzc()     // Catch:{ all -> 0x051a }
            if (r10 >= r4) goto L_0x03ab
            r10 = 0
            com.google.android.gms.internal.ads.zzaen r12 = zzf(r0, r1, r2, r3, r10)     // Catch:{ all -> 0x051a }
            if (r12 == 0) goto L_0x039a
            r7.add(r12)     // Catch:{ all -> 0x051a }
            goto L_0x039a
        L_0x03ab:
            r2 = 0
            com.google.android.gms.internal.ads.zzaen[] r2 = new com.google.android.gms.internal.ads.zzaen[r2]     // Catch:{ all -> 0x051a }
            java.lang.Object[] r2 = r7.toArray(r2)     // Catch:{ all -> 0x051a }
            r33 = r2
            com.google.android.gms.internal.ads.zzaen[] r33 = (com.google.android.gms.internal.ads.zzaen[]) r33     // Catch:{ all -> 0x051a }
            com.google.android.gms.internal.ads.zzaec r13 = new com.google.android.gms.internal.ads.zzaec     // Catch:{ all -> 0x051a }
            r25 = r13
            r26 = r8
            r25.<init>(r26, r27, r28, r29, r31, r33)     // Catch:{ all -> 0x051a }
            goto L_0x033b
        L_0x03c1:
            if (r12 != r14) goto L_0x047a
            r7 = 84
            if (r5 != r7) goto L_0x047a
            r7 = 79
            if (r6 != r7) goto L_0x047a
            if (r9 != r14) goto L_0x047a
            int r4 = r36.zzc()     // Catch:{ all -> 0x051a }
            byte[] r7 = r36.zzH()     // Catch:{ all -> 0x051a }
            int r7 = zzd(r7, r4)     // Catch:{ all -> 0x051a }
            java.lang.String r8 = new java.lang.String     // Catch:{ all -> 0x051a }
            byte[] r10 = r36.zzH()     // Catch:{ all -> 0x051a }
            int r12 = r7 - r4
            java.nio.charset.Charset r13 = com.google.android.gms.internal.ads.zzfot.zzb     // Catch:{ all -> 0x051a }
            r8.<init>(r10, r4, r12, r13)     // Catch:{ all -> 0x051a }
            r10 = 1
            int r7 = r7 + r10
            r1.zzF(r7)     // Catch:{ all -> 0x051a }
            int r7 = r36.zzk()     // Catch:{ all -> 0x051a }
            r10 = r7 & 2
            if (r10 == 0) goto L_0x03f7
            r10 = 1
            r27 = 1
            goto L_0x03fa
        L_0x03f7:
            r10 = 1
            r27 = 0
        L_0x03fa:
            r7 = r7 & r10
            int r10 = r36.zzk()     // Catch:{ all -> 0x051a }
            java.lang.String[] r12 = new java.lang.String[r10]     // Catch:{ all -> 0x051a }
            r13 = 0
        L_0x0402:
            if (r13 >= r10) goto L_0x0437
            int r14 = r36.zzc()     // Catch:{ all -> 0x051a }
            byte[] r15 = r36.zzH()     // Catch:{ all -> 0x051a }
            int r15 = zzd(r15, r14)     // Catch:{ all -> 0x051a }
            r39 = r10
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x051a }
            r16 = r9
            byte[] r9 = r36.zzH()     // Catch:{ all -> 0x051a }
            r17 = r6
            int r6 = r15 - r14
            r19 = r5
            java.nio.charset.Charset r5 = com.google.android.gms.internal.ads.zzfot.zzb     // Catch:{ all -> 0x051a }
            r10.<init>(r9, r14, r6, r5)     // Catch:{ all -> 0x051a }
            r12[r13] = r10     // Catch:{ all -> 0x051a }
            int r15 = r15 + 1
            r1.zzF(r15)     // Catch:{ all -> 0x051a }
            int r13 = r13 + 1
            r10 = r39
            r9 = r16
            r6 = r17
            r5 = r19
            goto L_0x0402
        L_0x0437:
            r19 = r5
            r17 = r6
            r16 = r9
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x051a }
            r5.<init>()     // Catch:{ all -> 0x051a }
            int r4 = r4 + r11
        L_0x0443:
            int r6 = r36.zzc()     // Catch:{ all -> 0x051a }
            if (r6 >= r4) goto L_0x0454
            r6 = 0
            com.google.android.gms.internal.ads.zzaen r9 = zzf(r0, r1, r2, r3, r6)     // Catch:{ all -> 0x051a }
            if (r9 == 0) goto L_0x0443
            r5.add(r9)     // Catch:{ all -> 0x051a }
            goto L_0x0443
        L_0x0454:
            r2 = 0
            com.google.android.gms.internal.ads.zzaen[] r3 = new com.google.android.gms.internal.ads.zzaen[r2]     // Catch:{ all -> 0x051a }
            java.lang.Object[] r2 = r5.toArray(r3)     // Catch:{ all -> 0x051a }
            r30 = r2
            com.google.android.gms.internal.ads.zzaen[] r30 = (com.google.android.gms.internal.ads.zzaen[]) r30     // Catch:{ all -> 0x051a }
            com.google.android.gms.internal.ads.zzaee r13 = new com.google.android.gms.internal.ads.zzaee     // Catch:{ all -> 0x051a }
            r2 = 1
            if (r2 == r7) goto L_0x0467
            r28 = 0
            goto L_0x0469
        L_0x0467:
            r28 = 1
        L_0x0469:
            r25 = r13
            r26 = r8
            r29 = r12
            r25.<init>(r26, r27, r28, r29, r30)     // Catch:{ all -> 0x051a }
            r7 = r16
            r4 = r17
            r3 = r19
            goto L_0x04f3
        L_0x047a:
            r19 = r5
            r17 = r6
            r16 = r9
            if (r12 != r4) goto L_0x04de
            r2 = 76
            r3 = r19
            if (r3 != r2) goto L_0x04d9
            r2 = 76
            r4 = r17
            r7 = r16
            if (r4 != r2) goto L_0x04e4
            r2 = 84
            if (r7 != r2) goto L_0x04e4
            int r17 = r36.zzo()     // Catch:{ all -> 0x051a }
            int r18 = r36.zzm()     // Catch:{ all -> 0x051a }
            int r19 = r36.zzm()     // Catch:{ all -> 0x051a }
            int r2 = r36.zzk()     // Catch:{ all -> 0x051a }
            int r5 = r36.zzk()     // Catch:{ all -> 0x051a }
            com.google.android.gms.internal.ads.zzez r6 = new com.google.android.gms.internal.ads.zzez     // Catch:{ all -> 0x051a }
            r6.<init>()     // Catch:{ all -> 0x051a }
            r6.zzh(r1)     // Catch:{ all -> 0x051a }
            int r8 = r11 + -10
            int r8 = r8 * 8
            int r9 = r2 + r5
            int r8 = r8 / r9
            int[] r9 = new int[r8]     // Catch:{ all -> 0x051a }
            int[] r10 = new int[r8]     // Catch:{ all -> 0x051a }
            r12 = 0
        L_0x04bc:
            if (r12 >= r8) goto L_0x04cd
            int r13 = r6.zzd(r2)     // Catch:{ all -> 0x051a }
            int r14 = r6.zzd(r5)     // Catch:{ all -> 0x051a }
            r9[r12] = r13     // Catch:{ all -> 0x051a }
            r10[r12] = r14     // Catch:{ all -> 0x051a }
            int r12 = r12 + 1
            goto L_0x04bc
        L_0x04cd:
            com.google.android.gms.internal.ads.zzaer r13 = new com.google.android.gms.internal.ads.zzaer     // Catch:{ all -> 0x051a }
            r16 = r13
            r20 = r9
            r21 = r10
            r16.<init>(r17, r18, r19, r20, r21)     // Catch:{ all -> 0x051a }
            goto L_0x04f3
        L_0x04d9:
            r7 = r16
            r4 = r17
            goto L_0x04e4
        L_0x04de:
            r7 = r16
            r4 = r17
            r3 = r19
        L_0x04e4:
            java.lang.String r2 = zzi(r0, r12, r3, r4, r7)     // Catch:{ all -> 0x051a }
            byte[] r5 = new byte[r11]     // Catch:{ all -> 0x051a }
            r6 = 0
            r1.zzB(r5, r6, r11)     // Catch:{ all -> 0x051a }
            com.google.android.gms.internal.ads.zzaea r13 = new com.google.android.gms.internal.ads.zzaea     // Catch:{ all -> 0x051a }
            r13.<init>(r2, r5)     // Catch:{ all -> 0x051a }
        L_0x04f3:
            if (r13 != 0) goto L_0x051e
            r2 = r24
            java.lang.String r0 = zzi(r0, r2, r3, r4, r7)     // Catch:{ all -> 0x051a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x051a }
            r2.<init>()     // Catch:{ all -> 0x051a }
            java.lang.String r3 = "Failed to decode frame: id="
            r2.append(r3)     // Catch:{ all -> 0x051a }
            r2.append(r0)     // Catch:{ all -> 0x051a }
            java.lang.String r0 = ", frameSize="
            r2.append(r0)     // Catch:{ all -> 0x051a }
            r2.append(r11)     // Catch:{ all -> 0x051a }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x051a }
            r2 = r23
            com.google.android.gms.internal.ads.zzer.zzf(r2, r0)     // Catch:{ all -> 0x051a }
            goto L_0x051e
        L_0x051a:
            r0 = move-exception
            r14 = r22
            goto L_0x0524
        L_0x051e:
            r14 = r22
            r1.zzF(r14)
            return r13
        L_0x0524:
            r1.zzF(r14)
            throw r0
        L_0x0528:
            r2 = r7
            java.lang.String r0 = "Skipping unsupported compressed or encrypted frame"
            com.google.android.gms.internal.ads.zzer.zzf(r2, r0)
            r1.zzF(r14)
            r0 = 0
            return r0
        L_0x0533:
            r0 = r13
            r1.zzF(r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaem.zzf(int, com.google.android.gms.internal.ads.zzfa, boolean, int, com.google.android.gms.internal.ads.zzaek):com.google.android.gms.internal.ads.zzaen");
    }

    private static zzfsc zzg(byte[] bArr, int i2, int i3) {
        if (i3 >= bArr.length) {
            return zzfsc.zzm("");
        }
        zzfrz zzfrz = new zzfrz();
        int zzc = zzc(bArr, i3, i2);
        while (i3 < zzc) {
            zzfrz.zzf(new String(bArr, i3, zzc - i3, zzj(i2)));
            i3 = zzb(i2) + zzc;
            zzc = zzc(bArr, i3, i2);
        }
        zzfsc zzi = zzfrz.zzi();
        if (zzi.isEmpty()) {
            return zzfsc.zzm("");
        }
        return zzi;
    }

    private static String zzh(byte[] bArr, int i2, int i3, Charset charset) {
        return (i3 <= i2 || i3 > bArr.length) ? "" : new String(bArr, i2, i3 - i2, charset);
    }

    private static String zzi(int i2, int i3, int i4, int i5, int i6) {
        if (i2 == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)});
    }

    private static Charset zzj(int i2) {
        if (i2 == 1) {
            return zzfot.zzf;
        }
        if (i2 == 2) {
            return zzfot.zzd;
        }
        if (i2 != 3) {
            return zzfot.zzb;
        }
        return zzfot.zzc;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0087, code lost:
        if ((r10 & 128) != 0) goto L_0x008c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zzk(com.google.android.gms.internal.ads.zzfa r21, int r22, int r23, boolean r24) {
        /*
            r1 = r21
            r0 = r22
            int r2 = r21.zzc()
        L_0x0008:
            int r3 = r21.zza()     // Catch:{ all -> 0x00b0 }
            r4 = 1
            r5 = r23
            if (r3 < r5) goto L_0x00ac
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L_0x0022
            int r7 = r21.zze()     // Catch:{ all -> 0x00b0 }
            long r8 = r21.zzs()     // Catch:{ all -> 0x00b0 }
            int r10 = r21.zzo()     // Catch:{ all -> 0x00b0 }
            goto L_0x002c
        L_0x0022:
            int r7 = r21.zzm()     // Catch:{ all -> 0x00b0 }
            int r8 = r21.zzm()     // Catch:{ all -> 0x00b0 }
            long r8 = (long) r8
            r10 = 0
        L_0x002c:
            r11 = 0
            if (r7 != 0) goto L_0x003b
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x003b
            if (r10 == 0) goto L_0x0037
            goto L_0x003b
        L_0x0037:
            r1.zzF(r2)
            return r4
        L_0x003b:
            r7 = 4
            if (r0 != r7) goto L_0x006c
            if (r24 != 0) goto L_0x006c
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L_0x004c
            r1.zzF(r2)
            return r6
        L_0x004c:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            r17 = 16
            long r17 = r8 >> r17
            r19 = 24
            long r8 = r8 >> r19
            long r15 = r15 & r11
            long r11 = r17 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 14
            long r11 = r11 << r15
            long r11 = r11 | r13
            r13 = 21
            long r8 = r8 << r13
            long r8 = r8 | r11
        L_0x006c:
            if (r0 != r7) goto L_0x007c
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0073
            goto L_0x0074
        L_0x0073:
            r4 = 0
        L_0x0074:
            r3 = r10 & 1
            r20 = r4
            r4 = r3
            r3 = r20
            goto L_0x008c
        L_0x007c:
            if (r0 != r3) goto L_0x008a
            r3 = r10 & 32
            if (r3 == 0) goto L_0x0084
            r3 = 1
            goto L_0x0085
        L_0x0084:
            r3 = 0
        L_0x0085:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x008b
            goto L_0x008c
        L_0x008a:
            r3 = 0
        L_0x008b:
            r4 = 0
        L_0x008c:
            if (r4 == 0) goto L_0x0090
            int r3 = r3 + 4
        L_0x0090:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0099
            r1.zzF(r2)
            return r6
        L_0x0099:
            int r3 = r21.zza()     // Catch:{ all -> 0x00b0 }
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x00a6
            r1.zzF(r2)
            return r6
        L_0x00a6:
            int r3 = (int) r8
            r1.zzG(r3)     // Catch:{ all -> 0x00b0 }
            goto L_0x0008
        L_0x00ac:
            r1.zzF(r2)
            return r4
        L_0x00b0:
            r0 = move-exception
            r1.zzF(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaem.zzk(com.google.android.gms.internal.ads.zzfa, int, int, boolean):boolean");
    }

    private static byte[] zzl(byte[] bArr, int i2, int i3) {
        if (i3 <= i2) {
            return zzfj.zzf;
        }
        return Arrays.copyOfRange(bArr, i2, i3);
    }
}
