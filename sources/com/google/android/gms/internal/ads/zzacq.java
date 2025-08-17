package com.google.android.gms.internal.ads;

final class zzacq implements zzaci {
    public final zzfsc zza;
    private final int zzb;

    private zzacq(int i2, zzfsc zzfsc) {
        this.zzb = i2;
        this.zza = zzfsc;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzacq zzc(int r16, com.google.android.gms.internal.ads.zzfa r17) {
        /*
            r0 = r17
            com.google.android.gms.internal.ads.zzfrz r1 = new com.google.android.gms.internal.ads.zzfrz
            r1.<init>()
            int r2 = r17.zzd()
            r3 = -2
        L_0x000c:
            int r4 = r17.zza()
            r5 = 8
            if (r4 <= r5) goto L_0x018c
            int r4 = r17.zzg()
            int r5 = r17.zzg()
            int r6 = r17.zzc()
            int r6 = r6 + r5
            r0.zzE(r6)
            r5 = 1414744396(0x5453494c, float:3.62987127E12)
            r7 = 2
            r8 = 1
            if (r4 != r5) goto L_0x0035
            int r4 = r17.zzg()
            com.google.android.gms.internal.ads.zzacq r4 = zzc(r4, r0)
            goto L_0x0148
        L_0x0035:
            r5 = 0
            switch(r4) {
                case 1718776947: goto L_0x004e;
                case 1751742049: goto L_0x0048;
                case 1752331379: goto L_0x0042;
                case 1852994675: goto L_0x003c;
                default: goto L_0x0039;
            }
        L_0x0039:
            r4 = r5
            goto L_0x0148
        L_0x003c:
            com.google.android.gms.internal.ads.zzacs r4 = com.google.android.gms.internal.ads.zzacs.zzb(r17)
            goto L_0x0148
        L_0x0042:
            com.google.android.gms.internal.ads.zzaco r4 = com.google.android.gms.internal.ads.zzaco.zzb(r17)
            goto L_0x0148
        L_0x0048:
            com.google.android.gms.internal.ads.zzacn r4 = com.google.android.gms.internal.ads.zzacn.zzb(r17)
            goto L_0x0148
        L_0x004e:
            java.lang.String r4 = "StreamFormatChunk"
            if (r3 != r7) goto L_0x00a7
            r9 = 4
            r0.zzG(r9)
            int r10 = r17.zzg()
            int r11 = r17.zzg()
            r0.zzG(r9)
            int r9 = r17.zzg()
            switch(r9) {
                case 808802372: goto L_0x0076;
                case 826496577: goto L_0x0073;
                case 828601953: goto L_0x0073;
                case 842289229: goto L_0x0070;
                case 859066445: goto L_0x006d;
                case 875967048: goto L_0x0073;
                case 877677894: goto L_0x0076;
                case 1145656883: goto L_0x0076;
                case 1145656920: goto L_0x0076;
                case 1196444237: goto L_0x006a;
                case 1482049860: goto L_0x0076;
                case 1684633208: goto L_0x0076;
                case 1735420525: goto L_0x006a;
                case 2021026148: goto L_0x0076;
                default: goto L_0x0068;
            }
        L_0x0068:
            r12 = r5
            goto L_0x0078
        L_0x006a:
            java.lang.String r12 = "video/mjpeg"
            goto L_0x0078
        L_0x006d:
            java.lang.String r12 = "video/mp43"
            goto L_0x0078
        L_0x0070:
            java.lang.String r12 = "video/mp42"
            goto L_0x0078
        L_0x0073:
            java.lang.String r12 = "video/avc"
            goto L_0x0078
        L_0x0076:
            java.lang.String r12 = "video/mp4v-es"
        L_0x0078:
            if (r12 != 0) goto L_0x008f
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Ignoring track with unsupported compression "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.google.android.gms.internal.ads.zzer.zzf(r4, r9)
            goto L_0x0039
        L_0x008f:
            com.google.android.gms.internal.ads.zzak r4 = new com.google.android.gms.internal.ads.zzak
            r4.<init>()
            r4.zzX(r10)
            r4.zzF(r11)
            r4.zzS(r12)
            com.google.android.gms.internal.ads.zzacr r5 = new com.google.android.gms.internal.ads.zzacr
            com.google.android.gms.internal.ads.zzam r4 = r4.zzY()
            r5.<init>(r4)
            goto L_0x0039
        L_0x00a7:
            if (r3 != r8) goto L_0x0139
            int r9 = r17.zzi()
            java.lang.String r10 = "audio/mp4a-latm"
            java.lang.String r11 = "audio/raw"
            if (r9 == r8) goto L_0x00d0
            r12 = 85
            if (r9 == r12) goto L_0x00cd
            r12 = 255(0xff, float:3.57E-43)
            if (r9 == r12) goto L_0x00cb
            r12 = 8192(0x2000, float:1.14794E-41)
            if (r9 == r12) goto L_0x00c8
            r12 = 8193(0x2001, float:1.1481E-41)
            if (r9 == r12) goto L_0x00c5
            r12 = r5
            goto L_0x00d1
        L_0x00c5:
            java.lang.String r12 = "audio/vnd.dts"
            goto L_0x00d1
        L_0x00c8:
            java.lang.String r12 = "audio/ac3"
            goto L_0x00d1
        L_0x00cb:
            r12 = r10
            goto L_0x00d1
        L_0x00cd:
            java.lang.String r12 = "audio/mpeg"
            goto L_0x00d1
        L_0x00d0:
            r12 = r11
        L_0x00d1:
            if (r12 != 0) goto L_0x00e9
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Ignoring track with unsupported format tag "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.google.android.gms.internal.ads.zzer.zzf(r4, r9)
            goto L_0x0039
        L_0x00e9:
            int r4 = r17.zzi()
            int r5 = r17.zzg()
            r9 = 6
            r0.zzG(r9)
            int r9 = r17.zzo()
            int r9 = com.google.android.gms.internal.ads.zzfj.zzj(r9)
            int r13 = r17.zzi()
            byte[] r14 = new byte[r13]
            r15 = 0
            r0.zzB(r14, r15, r13)
            com.google.android.gms.internal.ads.zzak r15 = new com.google.android.gms.internal.ads.zzak
            r15.<init>()
            r15.zzS(r12)
            r15.zzw(r4)
            r15.zzT(r5)
            boolean r4 = r11.equals(r12)
            if (r4 == 0) goto L_0x0120
            if (r9 == 0) goto L_0x0120
            r15.zzN(r9)
        L_0x0120:
            boolean r4 = r10.equals(r12)
            if (r4 == 0) goto L_0x012f
            if (r13 <= 0) goto L_0x012f
            com.google.android.gms.internal.ads.zzfsc r4 = com.google.android.gms.internal.ads.zzfsc.zzm(r14)
            r15.zzI(r4)
        L_0x012f:
            com.google.android.gms.internal.ads.zzacr r4 = new com.google.android.gms.internal.ads.zzacr
            com.google.android.gms.internal.ads.zzam r5 = r15.zzY()
            r4.<init>(r5)
            goto L_0x0148
        L_0x0139:
            java.lang.String r9 = "Ignoring strf box for unsupported track type: "
            java.lang.String r10 = com.google.android.gms.internal.ads.zzfj.zzy(r3)
            java.lang.String r9 = r9.concat(r10)
            com.google.android.gms.internal.ads.zzer.zzf(r4, r9)
            goto L_0x0039
        L_0x0148:
            if (r4 == 0) goto L_0x0184
            int r5 = r4.zza()
            r9 = 1752331379(0x68727473, float:4.5798432E24)
            if (r5 != r9) goto L_0x0181
            r3 = r4
            com.google.android.gms.internal.ads.zzaco r3 = (com.google.android.gms.internal.ads.zzaco) r3
            int r3 = r3.zza
            r5 = 1935960438(0x73646976, float:1.809666E31)
            if (r3 == r5) goto L_0x0180
            r5 = 1935963489(0x73647561, float:1.8100348E31)
            if (r3 == r5) goto L_0x017e
            r5 = 1937012852(0x73747874, float:1.936895E31)
            if (r3 == r5) goto L_0x017c
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r5 = "AviStreamHeaderChunk"
            java.lang.String r7 = "Found unsupported streamType fourCC: "
            java.lang.String r3 = r7.concat(r3)
            com.google.android.gms.internal.ads.zzer.zzf(r5, r3)
            r3 = -1
            goto L_0x0181
        L_0x017c:
            r3 = 3
            goto L_0x0181
        L_0x017e:
            r3 = 1
            goto L_0x0181
        L_0x0180:
            r3 = 2
        L_0x0181:
            r1.zzf(r4)
        L_0x0184:
            r0.zzF(r6)
            r0.zzE(r2)
            goto L_0x000c
        L_0x018c:
            com.google.android.gms.internal.ads.zzacq r0 = new com.google.android.gms.internal.ads.zzacq
            com.google.android.gms.internal.ads.zzfsc r1 = r1.zzi()
            r2 = r16
            r0.<init>(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacq.zzc(int, com.google.android.gms.internal.ads.zzfa):com.google.android.gms.internal.ads.zzacq");
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzaci zzb(Class cls) {
        zzfsc zzfsc = this.zza;
        int size = zzfsc.size();
        int i2 = 0;
        while (i2 < size) {
            zzaci zzaci = (zzaci) zzfsc.get(i2);
            i2++;
            if (zzaci.getClass() == cls) {
                return zzaci;
            }
        }
        return null;
    }
}
