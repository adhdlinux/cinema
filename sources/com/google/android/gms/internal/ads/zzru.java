package com.google.android.gms.internal.ads;

public final class zzru extends Exception {
    public final String zza;
    public final boolean zzb;
    public final zzrs zzc;
    public final String zzd;
    public final zzru zze;

    public zzru(zzam zzam, Throwable th, boolean z2, int i2) {
        this("Decoder init failed: [" + i2 + "], " + String.valueOf(zzam), th, zzam.zzm, false, (zzrs) null, "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_neg_" + Math.abs(i2), (zzru) null);
    }

    static /* bridge */ /* synthetic */ zzru zza(zzru zzru, zzru zzru2) {
        return new zzru(zzru.getMessage(), zzru.getCause(), zzru.zza, false, zzru.zzc, zzru.zzd, zzru2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzru(com.google.android.gms.internal.ads.zzam r11, java.lang.Throwable r12, boolean r13, com.google.android.gms.internal.ads.zzrs r14) {
        /*
            r10 = this;
            java.lang.String r13 = r14.zza
            java.lang.String r0 = java.lang.String.valueOf(r11)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Decoder init failed: "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r13 = ", "
            r1.append(r13)
            r1.append(r0)
            java.lang.String r3 = r1.toString()
            java.lang.String r5 = r11.zzm
            int r11 = com.google.android.gms.internal.ads.zzfj.zza
            r13 = 21
            r0 = 0
            if (r11 < r13) goto L_0x0035
            boolean r11 = r12 instanceof android.media.MediaCodec.CodecException
            if (r11 == 0) goto L_0x0035
            r11 = r12
            android.media.MediaCodec$CodecException r11 = (android.media.MediaCodec.CodecException) r11
            java.lang.String r11 = r11.getDiagnosticInfo()
            r8 = r11
            goto L_0x0036
        L_0x0035:
            r8 = r0
        L_0x0036:
            r6 = 0
            r9 = 0
            r2 = r10
            r4 = r12
            r7 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzru.<init>(com.google.android.gms.internal.ads.zzam, java.lang.Throwable, boolean, com.google.android.gms.internal.ads.zzrs):void");
    }

    private zzru(String str, Throwable th, String str2, boolean z2, zzrs zzrs, String str3, zzru zzru) {
        super(str, th);
        this.zza = str2;
        this.zzb = false;
        this.zzc = zzrs;
        this.zzd = str3;
        this.zze = zzru;
    }
}
