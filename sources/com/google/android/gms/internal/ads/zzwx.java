package com.google.android.gms.internal.ads;

final class zzwx extends zzwu {
    private final boolean zze;
    private final zzwm zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final boolean zzo;
    private final boolean zzp;
    private final int zzq;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0091 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzwx(int r5, com.google.android.gms.internal.ads.zzcy r6, int r7, com.google.android.gms.internal.ads.zzwm r8, int r9, int r10, boolean r11) {
        /*
            r4 = this;
            r4.<init>(r5, r6, r7)
            r4.zzf = r8
            boolean r5 = r8.zzJ
            r6 = 1
            if (r6 == r5) goto L_0x000d
            r5 = 16
            goto L_0x000f
        L_0x000d:
            r5 = 24
        L_0x000f:
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r10 = 0
            if (r11 == 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzam r0 = r4.zzd
            int r1 = r0.zzr
            float r0 = r0.zzt
            int r1 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0024
            r1 = 1325400064(0x4f000000, float:2.14748365E9)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0026
        L_0x0024:
            r0 = 1
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            r4.zze = r0
            r0 = -1
            if (r11 == 0) goto L_0x004d
            com.google.android.gms.internal.ads.zzam r11 = r4.zzd
            int r1 = r11.zzr
            if (r1 == r0) goto L_0x0034
            if (r1 < 0) goto L_0x004d
        L_0x0034:
            int r1 = r11.zzs
            if (r1 == r0) goto L_0x003a
            if (r1 < 0) goto L_0x004d
        L_0x003a:
            float r1 = r11.zzt
            int r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0045
            r7 = 0
            int r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r7 < 0) goto L_0x004d
        L_0x0045:
            int r7 = r11.zzi
            if (r7 == r0) goto L_0x004b
            if (r7 < 0) goto L_0x004d
        L_0x004b:
            r7 = 1
            goto L_0x004e
        L_0x004d:
            r7 = 0
        L_0x004e:
            r4.zzg = r7
            boolean r7 = com.google.android.gms.internal.ads.zzwy.zzn(r9, r10)
            r4.zzh = r7
            com.google.android.gms.internal.ads.zzam r7 = r4.zzd
            int r11 = r7.zzi
            r4.zzi = r11
            int r7 = r7.zza()
            r4.zzj = r7
            com.google.android.gms.internal.ads.zzam r7 = r4.zzd
            int r7 = r7.zzf
            int r7 = java.lang.Integer.bitCount(r10)
            r4.zzl = r7
            com.google.android.gms.internal.ads.zzam r7 = r4.zzd
            int r7 = r7.zzf
            r4.zzm = r6
            r7 = 0
        L_0x0073:
            com.google.android.gms.internal.ads.zzfsc r11 = r8.zzo
            int r11 = r11.size()
            if (r7 >= r11) goto L_0x0091
            com.google.android.gms.internal.ads.zzam r11 = r4.zzd
            java.lang.String r11 = r11.zzm
            if (r11 == 0) goto L_0x008e
            com.google.android.gms.internal.ads.zzfsc r1 = r8.zzo
            java.lang.Object r1 = r1.get(r7)
            boolean r11 = r11.equals(r1)
            if (r11 == 0) goto L_0x008e
            goto L_0x0094
        L_0x008e:
            int r7 = r7 + 1
            goto L_0x0073
        L_0x0091:
            r7 = 2147483647(0x7fffffff, float:NaN)
        L_0x0094:
            r4.zzk = r7
            r7 = r9 & 384(0x180, float:5.38E-43)
            r8 = 128(0x80, float:1.794E-43)
            if (r7 != r8) goto L_0x009e
            r7 = 1
            goto L_0x009f
        L_0x009e:
            r7 = 0
        L_0x009f:
            r4.zzo = r7
            r7 = r9 & 64
            r8 = 64
            if (r7 != r8) goto L_0x00a9
            r7 = 1
            goto L_0x00aa
        L_0x00a9:
            r7 = 0
        L_0x00aa:
            r4.zzp = r7
            com.google.android.gms.internal.ads.zzam r7 = r4.zzd
            java.lang.String r8 = r7.zzm
            r11 = 2
            if (r8 != 0) goto L_0x00b5
        L_0x00b3:
            r2 = 0
            goto L_0x0104
        L_0x00b5:
            int r1 = r8.hashCode()
            r2 = 4
            r3 = 3
            switch(r1) {
                case -1851077871: goto L_0x00e7;
                case -1662735862: goto L_0x00dd;
                case -1662541442: goto L_0x00d3;
                case 1331836730: goto L_0x00c9;
                case 1599127257: goto L_0x00bf;
                default: goto L_0x00be;
            }
        L_0x00be:
            goto L_0x00f1
        L_0x00bf:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x00f1
            r8 = 3
            goto L_0x00f2
        L_0x00c9:
            java.lang.String r1 = "video/avc"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x00f1
            r8 = 4
            goto L_0x00f2
        L_0x00d3:
            java.lang.String r1 = "video/hevc"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x00f1
            r8 = 2
            goto L_0x00f2
        L_0x00dd:
            java.lang.String r1 = "video/av01"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x00f1
            r8 = 1
            goto L_0x00f2
        L_0x00e7:
            java.lang.String r1 = "video/dolby-vision"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x00f1
            r8 = 0
            goto L_0x00f2
        L_0x00f1:
            r8 = -1
        L_0x00f2:
            if (r8 == 0) goto L_0x0103
            if (r8 == r6) goto L_0x0104
            if (r8 == r11) goto L_0x0101
            if (r8 == r3) goto L_0x00ff
            if (r8 == r2) goto L_0x00fd
            goto L_0x00b3
        L_0x00fd:
            r2 = 1
            goto L_0x0104
        L_0x00ff:
            r2 = 2
            goto L_0x0104
        L_0x0101:
            r2 = 3
            goto L_0x0104
        L_0x0103:
            r2 = 5
        L_0x0104:
            r4.zzq = r2
            com.google.android.gms.internal.ads.zzwm r8 = r4.zzf
            boolean r1 = r8.zzR
            boolean r1 = com.google.android.gms.internal.ads.zzwy.zzn(r9, r1)
            if (r1 != 0) goto L_0x0112
        L_0x0110:
            r6 = 0
            goto L_0x012f
        L_0x0112:
            boolean r1 = r4.zze
            if (r1 != 0) goto L_0x011b
            boolean r8 = r8.zzH
            if (r8 != 0) goto L_0x011b
            goto L_0x0110
        L_0x011b:
            boolean r8 = com.google.android.gms.internal.ads.zzwy.zzn(r9, r10)
            if (r8 == 0) goto L_0x012f
            boolean r8 = r4.zzg
            if (r8 == 0) goto L_0x012f
            if (r1 == 0) goto L_0x012f
            int r7 = r7.zzi
            if (r7 == r0) goto L_0x012f
            r5 = r5 & r9
            if (r5 == 0) goto L_0x012f
            r6 = 2
        L_0x012f:
            r4.zzn = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwx.<init>(int, com.google.android.gms.internal.ads.zzcy, int, com.google.android.gms.internal.ads.zzwm, int, int, boolean):void");
    }

    public static /* synthetic */ int zza(zzwx zzwx, zzwx zzwx2) {
        zzftl zzftl;
        if (!zzwx.zze || !zzwx.zzh) {
            zzftl = zzwy.zzc.zza();
        } else {
            zzftl = zzwy.zzc;
        }
        zzfrr zzj2 = zzfrr.zzj();
        Integer valueOf = Integer.valueOf(zzwx.zzi);
        Integer valueOf2 = Integer.valueOf(zzwx2.zzi);
        boolean z2 = zzwx.zzf.zzA;
        return zzj2.zzc(valueOf, valueOf2, zzwy.zzd).zzc(Integer.valueOf(zzwx.zzj), Integer.valueOf(zzwx2.zzj), zzftl).zzc(Integer.valueOf(zzwx.zzi), Integer.valueOf(zzwx2.zzi), zzftl).zza();
    }

    public static /* synthetic */ int zzd(zzwx zzwx, zzwx zzwx2) {
        zzfrr zzc = zzfrr.zzj().zzd(zzwx.zzh, zzwx2.zzh).zzb(zzwx.zzl, zzwx2.zzl).zzd(true, true).zzd(zzwx.zze, zzwx2.zze).zzd(zzwx.zzg, zzwx2.zzg).zzc(Integer.valueOf(zzwx.zzk), Integer.valueOf(zzwx2.zzk), zzftl.zzc().zza());
        boolean z2 = zzwx.zzo;
        zzfrr zzd = zzc.zzd(z2, zzwx2.zzo);
        boolean z3 = zzwx.zzp;
        zzfrr zzd2 = zzd.zzd(z3, zzwx2.zzp);
        if (z2 && z3) {
            zzd2 = zzd2.zzb(zzwx.zzq, zzwx2.zzq);
        }
        return zzd2.zza();
    }

    public final int zzb() {
        return this.zzn;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzwu zzwu) {
        zzwx zzwx = (zzwx) zzwu;
        if (!zzfj.zzC(this.zzd.zzm, zzwx.zzd.zzm)) {
            return false;
        }
        boolean z2 = this.zzf.zzK;
        if (this.zzo == zzwx.zzo && this.zzp == zzwx.zzp) {
            return true;
        }
        return false;
    }
}
