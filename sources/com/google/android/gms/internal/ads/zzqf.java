package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import java.nio.ByteBuffer;
import java.util.List;

public final class zzqf extends zzrw implements zzkl {
    private final Context zzb;
    /* access modifiers changed from: private */
    public final zzos zzc;
    private final zzoz zzd;
    private int zze;
    private boolean zzf;
    private zzam zzg;
    private zzam zzh;
    private long zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    /* access modifiers changed from: private */
    public zzlh zzm;

    public zzqf(Context context, zzro zzro, zzry zzry, boolean z2, Handler handler, zzot zzot, zzoz zzoz) {
        super(1, zzro, zzry, false, 44100.0f);
        this.zzb = context.getApplicationContext();
        this.zzd = zzoz;
        this.zzc = new zzos(handler, zzot);
        zzoz.zzo(new zzqe(this, (zzqd) null));
    }

    private final int zzaC(zzrs zzrs, zzam zzam) {
        int i2;
        if (!"OMX.google.raw.decoder".equals(zzrs.zza) || (i2 = zzfj.zza) >= 24 || (i2 == 23 && zzfj.zzE(this.zzb))) {
            return zzam.zzn;
        }
        return -1;
    }

    private static List zzaD(zzry zzry, zzam zzam, boolean z2, zzoz zzoz) throws zzsf {
        zzrs zzd2;
        if (zzam.zzm == null) {
            return zzfsc.zzl();
        }
        if (!zzoz.zzx(zzam) || (zzd2 = zzsl.zzd()) == null) {
            return zzsl.zzh(zzry, zzam, false, false);
        }
        return zzfsc.zzm(zzd2);
    }

    private final void zzaE() {
        long zzb2 = this.zzd.zzb(zzP());
        if (zzb2 != Long.MIN_VALUE) {
            if (!this.zzk) {
                zzb2 = Math.max(this.zzi, zzb2);
            }
            this.zzi = zzb2;
            this.zzk = false;
        }
    }

    public final String zzN() {
        return "MediaCodecAudioRenderer";
    }

    public final boolean zzP() {
        return super.zzP() && this.zzd.zzw();
    }

    public final boolean zzQ() {
        return this.zzd.zzv() || super.zzQ();
    }

    /* access modifiers changed from: protected */
    public final float zzS(float f2, zzam zzam, zzam[] zzamArr) {
        int i2 = -1;
        for (zzam zzam2 : zzamArr) {
            int i3 = zzam2.zzA;
            if (i3 != -1) {
                i2 = Math.max(i2, i3);
            }
        }
        if (i2 == -1) {
            return -1.0f;
        }
        return ((float) i2) * f2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzT(com.google.android.gms.internal.ads.zzry r12, com.google.android.gms.internal.ads.zzam r13) throws com.google.android.gms.internal.ads.zzsf {
        /*
            r11 = this;
            java.lang.String r0 = r13.zzm
            boolean r0 = com.google.android.gms.internal.ads.zzcc.zzf(r0)
            r1 = 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x000b
            return r1
        L_0x000b:
            int r0 = com.google.android.gms.internal.ads.zzfj.zza
            r2 = 21
            r3 = 0
            if (r0 < r2) goto L_0x0015
            r0 = 32
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            int r2 = r13.zzF
            boolean r4 = com.google.android.gms.internal.ads.zzrw.zzaB(r13)
            r5 = 1
            if (r4 == 0) goto L_0x004f
            if (r2 == 0) goto L_0x0027
            com.google.android.gms.internal.ads.zzrs r2 = com.google.android.gms.internal.ads.zzsl.zzd()
            if (r2 == 0) goto L_0x004f
        L_0x0027:
            com.google.android.gms.internal.ads.zzoz r2 = r11.zzd
            com.google.android.gms.internal.ads.zzoh r2 = r2.zzd(r13)
            boolean r6 = r2.zzb
            if (r6 != 0) goto L_0x0033
            r6 = 0
            goto L_0x0042
        L_0x0033:
            boolean r6 = r2.zzc
            if (r5 == r6) goto L_0x003a
            r6 = 512(0x200, float:7.175E-43)
            goto L_0x003c
        L_0x003a:
            r6 = 1536(0x600, float:2.152E-42)
        L_0x003c:
            boolean r2 = r2.zzd
            if (r2 == 0) goto L_0x0042
            r6 = r6 | 2048(0x800, float:2.87E-42)
        L_0x0042:
            com.google.android.gms.internal.ads.zzoz r2 = r11.zzd
            boolean r2 = r2.zzx(r13)
            if (r2 != 0) goto L_0x004b
            goto L_0x0050
        L_0x004b:
            r12 = r0 | 140(0x8c, float:1.96E-43)
        L_0x004d:
            r12 = r12 | r6
            return r12
        L_0x004f:
            r6 = 0
        L_0x0050:
            java.lang.String r2 = r13.zzm
            java.lang.String r7 = "audio/raw"
            boolean r2 = r7.equals(r2)
            r7 = 129(0x81, float:1.81E-43)
            if (r2 == 0) goto L_0x0066
            com.google.android.gms.internal.ads.zzoz r2 = r11.zzd
            boolean r2 = r2.zzx(r13)
            if (r2 == 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            return r7
        L_0x0066:
            com.google.android.gms.internal.ads.zzoz r2 = r11.zzd
            int r8 = r13.zzz
            int r9 = r13.zzA
            r10 = 2
            com.google.android.gms.internal.ads.zzam r8 = com.google.android.gms.internal.ads.zzfj.zzv(r10, r8, r9)
            boolean r2 = r2.zzx(r8)
            if (r2 != 0) goto L_0x0078
            return r7
        L_0x0078:
            com.google.android.gms.internal.ads.zzoz r2 = r11.zzd
            java.util.List r12 = zzaD(r12, r13, r3, r2)
            boolean r2 = r12.isEmpty()
            if (r2 == 0) goto L_0x0085
            return r7
        L_0x0085:
            if (r4 != 0) goto L_0x008a
            r12 = 130(0x82, float:1.82E-43)
            return r12
        L_0x008a:
            java.lang.Object r2 = r12.get(r3)
            com.google.android.gms.internal.ads.zzrs r2 = (com.google.android.gms.internal.ads.zzrs) r2
            boolean r4 = r2.zze(r13)
            if (r4 != 0) goto L_0x00b0
            r7 = 1
        L_0x0097:
            int r8 = r12.size()
            if (r7 >= r8) goto L_0x00b0
            java.lang.Object r8 = r12.get(r7)
            com.google.android.gms.internal.ads.zzrs r8 = (com.google.android.gms.internal.ads.zzrs) r8
            boolean r9 = r8.zze(r13)
            if (r9 == 0) goto L_0x00ad
            r2 = r8
            r12 = 0
            r4 = 1
            goto L_0x00b1
        L_0x00ad:
            int r7 = r7 + 1
            goto L_0x0097
        L_0x00b0:
            r12 = 1
        L_0x00b1:
            if (r5 == r4) goto L_0x00b5
            r7 = 3
            goto L_0x00b6
        L_0x00b5:
            r7 = 4
        L_0x00b6:
            r8 = 8
            if (r4 == 0) goto L_0x00c2
            boolean r13 = r2.zzf(r13)
            if (r13 == 0) goto L_0x00c2
            r8 = 16
        L_0x00c2:
            boolean r13 = r2.zzg
            if (r5 == r13) goto L_0x00c8
            r13 = 0
            goto L_0x00ca
        L_0x00c8:
            r13 = 64
        L_0x00ca:
            if (r5 == r12) goto L_0x00cd
            r1 = 0
        L_0x00cd:
            r12 = r7 | r8
            r12 = r12 | r0
            r12 = r12 | r13
            r12 = r12 | r1
            goto L_0x004d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqf.zzT(com.google.android.gms.internal.ads.zzry, com.google.android.gms.internal.ads.zzam):int");
    }

    /* access modifiers changed from: protected */
    public final zzia zzU(zzrs zzrs, zzam zzam, zzam zzam2) {
        int i2;
        int i3;
        zzia zzb2 = zzrs.zzb(zzam, zzam2);
        int i4 = zzb2.zze;
        if (zzaz(zzam2)) {
            i4 |= 32768;
        }
        if (zzaC(zzrs, zzam2) > this.zze) {
            i4 |= 64;
        }
        String str = zzrs.zza;
        if (i4 != 0) {
            i2 = i4;
            i3 = 0;
        } else {
            i3 = zzb2.zzd;
            i2 = 0;
        }
        return new zzia(str, zzam, zzam2, i3, i2);
    }

    /* access modifiers changed from: protected */
    public final zzia zzV(zzkj zzkj) throws zzih {
        zzam zzam = zzkj.zza;
        zzam.getClass();
        this.zzg = zzam;
        zzia zzV = super.zzV(zzkj);
        this.zzc.zzg(this.zzg, zzV);
        return zzV;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a8, code lost:
        if ("AXON 7 mini".equals(r10) == false) goto L_0x00aa;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzrn zzY(com.google.android.gms.internal.ads.zzrs r8, com.google.android.gms.internal.ads.zzam r9, android.media.MediaCrypto r10, float r11) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzam[] r10 = r7.zzM()
            int r0 = r10.length
            int r1 = r7.zzaC(r8, r9)
            r2 = 0
            r3 = 1
            if (r0 != r3) goto L_0x000e
            goto L_0x0026
        L_0x000e:
            r4 = 0
        L_0x000f:
            if (r4 >= r0) goto L_0x0026
            r5 = r10[r4]
            com.google.android.gms.internal.ads.zzia r6 = r8.zzb(r9, r5)
            int r6 = r6.zzd
            if (r6 == 0) goto L_0x0023
            int r5 = r7.zzaC(r8, r5)
            int r1 = java.lang.Math.max(r1, r5)
        L_0x0023:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x0026:
            r7.zze = r1
            java.lang.String r10 = r8.zza
            int r0 = com.google.android.gms.internal.ads.zzfj.zza
            r1 = 24
            if (r0 >= r1) goto L_0x005e
            java.lang.String r4 = "OMX.SEC.aac.dec"
            boolean r10 = r4.equals(r10)
            if (r10 == 0) goto L_0x005e
            java.lang.String r10 = "samsung"
            java.lang.String r4 = com.google.android.gms.internal.ads.zzfj.zzc
            boolean r10 = r10.equals(r4)
            if (r10 == 0) goto L_0x005e
            java.lang.String r10 = com.google.android.gms.internal.ads.zzfj.zzb
            java.lang.String r4 = "zeroflte"
            boolean r4 = r10.startsWith(r4)
            if (r4 != 0) goto L_0x005c
            java.lang.String r4 = "herolte"
            boolean r4 = r10.startsWith(r4)
            if (r4 != 0) goto L_0x005c
            java.lang.String r4 = "heroqlte"
            boolean r10 = r10.startsWith(r4)
            if (r10 == 0) goto L_0x005e
        L_0x005c:
            r10 = 1
            goto L_0x005f
        L_0x005e:
            r10 = 0
        L_0x005f:
            r7.zzf = r10
            java.lang.String r10 = r8.zzc
            int r4 = r7.zze
            android.media.MediaFormat r5 = new android.media.MediaFormat
            r5.<init>()
            java.lang.String r6 = "mime"
            r5.setString(r6, r10)
            int r10 = r9.zzz
            java.lang.String r6 = "channel-count"
            r5.setInteger(r6, r10)
            int r10 = r9.zzA
            java.lang.String r6 = "sample-rate"
            r5.setInteger(r6, r10)
            java.util.List r10 = r9.zzo
            com.google.android.gms.internal.ads.zzet.zzb(r5, r10)
            java.lang.String r10 = "max-input-size"
            com.google.android.gms.internal.ads.zzet.zza(r5, r10, r4)
            r10 = 23
            if (r0 < r10) goto L_0x00af
            java.lang.String r4 = "priority"
            r5.setInteger(r4, r2)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x00af
            if (r0 != r10) goto L_0x00aa
            java.lang.String r10 = com.google.android.gms.internal.ads.zzfj.zzd
            java.lang.String r2 = "ZTE B2017G"
            boolean r2 = r2.equals(r10)
            if (r2 != 0) goto L_0x00af
            java.lang.String r2 = "AXON 7 mini"
            boolean r10 = r2.equals(r10)
            if (r10 != 0) goto L_0x00af
        L_0x00aa:
            java.lang.String r10 = "operating-rate"
            r5.setFloat(r10, r11)
        L_0x00af:
            r10 = 28
            if (r0 > r10) goto L_0x00c2
            java.lang.String r10 = r9.zzm
            java.lang.String r11 = "audio/ac4"
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x00c2
            java.lang.String r10 = "ac4-is-sync"
            r5.setInteger(r10, r3)
        L_0x00c2:
            if (r0 < r1) goto L_0x00db
            com.google.android.gms.internal.ads.zzoz r10 = r7.zzd
            int r11 = r9.zzz
            int r1 = r9.zzA
            r2 = 4
            com.google.android.gms.internal.ads.zzam r11 = com.google.android.gms.internal.ads.zzfj.zzv(r2, r11, r1)
            int r10 = r10.zza(r11)
            r11 = 2
            if (r10 != r11) goto L_0x00db
            java.lang.String r10 = "pcm-encoding"
            r5.setInteger(r10, r2)
        L_0x00db:
            r10 = 32
            if (r0 < r10) goto L_0x00e6
            java.lang.String r10 = "max-output-channel-count"
            r11 = 99
            r5.setInteger(r10, r11)
        L_0x00e6:
            java.lang.String r10 = r8.zzb
            java.lang.String r11 = "audio/raw"
            boolean r10 = r11.equals(r10)
            r0 = 0
            if (r10 == 0) goto L_0x00fb
            java.lang.String r10 = r9.zzm
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L_0x00fb
            r10 = r9
            goto L_0x00fc
        L_0x00fb:
            r10 = r0
        L_0x00fc:
            r7.zzh = r10
            com.google.android.gms.internal.ads.zzrn r8 = com.google.android.gms.internal.ads.zzrn.zza(r8, r5, r9, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqf.zzY(com.google.android.gms.internal.ads.zzrs, com.google.android.gms.internal.ads.zzam, android.media.MediaCrypto, float):com.google.android.gms.internal.ads.zzrn");
    }

    /* access modifiers changed from: protected */
    public final List zzZ(zzry zzry, zzam zzam, boolean z2) throws zzsf {
        return zzsl.zzi(zzaD(zzry, zzam, false, this.zzd), zzam);
    }

    public final long zza() {
        if (zzbc() == 2) {
            zzaE();
        }
        return this.zzi;
    }

    /* access modifiers changed from: protected */
    public final void zzaa(Exception exc) {
        zzer.zzd("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zza(exc);
    }

    /* access modifiers changed from: protected */
    public final void zzab(String str, zzrn zzrn, long j2, long j3) {
        this.zzc.zzc(str, j2, j3);
    }

    /* access modifiers changed from: protected */
    public final void zzac(String str) {
        this.zzc.zzd(str);
    }

    /* access modifiers changed from: protected */
    public final void zzad(zzam zzam, MediaFormat mediaFormat) throws zzih {
        boolean z2;
        int i2;
        int i3;
        zzam zzam2 = this.zzh;
        int[] iArr = null;
        if (zzam2 != null) {
            zzam = zzam2;
        } else if (zzan() != null) {
            if ("audio/raw".equals(zzam.zzm)) {
                i2 = zzam.zzB;
            } else if (zzfj.zza >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                i2 = mediaFormat.getInteger("pcm-encoding");
            } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                i2 = zzfj.zzj(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                i2 = 2;
            }
            zzak zzak = new zzak();
            zzak.zzS("audio/raw");
            zzak.zzN(i2);
            zzak.zzC(zzam.zzC);
            zzak.zzD(zzam.zzD);
            zzak.zzw(mediaFormat.getInteger("channel-count"));
            zzak.zzT(mediaFormat.getInteger("sample-rate"));
            zzam zzY = zzak.zzY();
            if (this.zzf && zzY.zzz == 6 && (i3 = zzam.zzz) < 6) {
                iArr = new int[i3];
                for (int i4 = 0; i4 < zzam.zzz; i4++) {
                    iArr[i4] = i4;
                }
            }
            zzam = zzY;
        }
        try {
            int i5 = zzfj.zza;
            if (i5 >= 29) {
                if (zzay()) {
                    zzk();
                }
                if (i5 >= 29) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zzdy.zzf(z2);
            }
            this.zzd.zze(zzam, 0, iArr);
        } catch (zzou e2) {
            throw zzbe(e2, e2.zza, false, 5001);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzae() {
        this.zzk = true;
    }

    /* access modifiers changed from: protected */
    public final void zzaf(long j2) {
        super.zzaf(j2);
        this.zzj = false;
    }

    /* access modifiers changed from: protected */
    public final void zzag() {
        this.zzd.zzg();
    }

    /* access modifiers changed from: protected */
    public final void zzah(zzhp zzhp) {
        if (this.zzj && !zzhp.zzf()) {
            if (Math.abs(zzhp.zzd - this.zzi) > 500000) {
                this.zzi = zzhp.zzd;
            }
            this.zzj = false;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzai() throws zzih {
        try {
            this.zzd.zzj();
        } catch (zzoy e2) {
            throw zzbe(e2, e2.zzc, e2.zzb, 5002);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzaj(long j2, long j3, zzrp zzrp, ByteBuffer byteBuffer, int i2, int i3, int i4, long j4, boolean z2, boolean z3, zzam zzam) throws zzih {
        byteBuffer.getClass();
        if (this.zzh != null && (i3 & 2) != 0) {
            zzrp.getClass();
            zzrp.zzn(i2, false);
            return true;
        } else if (z2) {
            if (zzrp != null) {
                zzrp.zzn(i2, false);
            }
            this.zza.zzf += i4;
            this.zzd.zzg();
            return true;
        } else {
            try {
                if (!this.zzd.zzu(byteBuffer, j4, i4)) {
                    return false;
                }
                if (zzrp != null) {
                    zzrp.zzn(i2, false);
                }
                this.zza.zze += i4;
                return true;
            } catch (zzov e2) {
                throw zzbe(e2, this.zzg, e2.zzb, 5001);
            } catch (zzoy e3) {
                throw zzbe(e3, zzam, e3.zzb, 5002);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzak(zzam zzam) {
        zzk();
        return this.zzd.zzx(zzam);
    }

    public final zzch zzc() {
        return this.zzd.zzc();
    }

    public final void zzg(zzch zzch) {
        this.zzd.zzp(zzch);
    }

    public final zzkl zzi() {
        return this;
    }

    public final void zzq(int i2, Object obj) throws zzih {
        if (i2 == 2) {
            this.zzd.zzt(((Float) obj).floatValue());
        } else if (i2 == 3) {
            this.zzd.zzl((zzk) obj);
        } else if (i2 != 6) {
            switch (i2) {
                case 9:
                    this.zzd.zzs(((Boolean) obj).booleanValue());
                    return;
                case 10:
                    this.zzd.zzm(((Integer) obj).intValue());
                    return;
                case 11:
                    this.zzm = (zzlh) obj;
                    return;
                case 12:
                    if (zzfj.zza >= 23) {
                        zzqc.zza(this.zzd, obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            this.zzd.zzn((zzl) obj);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzt() {
        this.zzl = true;
        this.zzg = null;
        try {
            this.zzd.zzf();
            try {
                super.zzt();
            } finally {
                this.zzc.zze(this.zza);
            }
        } catch (Throwable th) {
            super.zzt();
            throw th;
        } finally {
            this.zzc.zze(this.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzu(boolean z2, boolean z3) throws zzih {
        super.zzu(z2, z3);
        this.zzc.zzf(this.zza);
        zzk();
        this.zzd.zzq(zzl());
    }

    /* access modifiers changed from: protected */
    public final void zzv(long j2, boolean z2) throws zzih {
        super.zzv(j2, z2);
        this.zzd.zzf();
        this.zzi = j2;
        this.zzj = true;
        this.zzk = true;
    }

    /* access modifiers changed from: protected */
    public final void zzw() {
        try {
            super.zzw();
            if (this.zzl) {
                this.zzl = false;
                this.zzd.zzk();
            }
        } catch (Throwable th) {
            if (this.zzl) {
                this.zzl = false;
                this.zzd.zzk();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzx() {
        this.zzd.zzi();
    }

    /* access modifiers changed from: protected */
    public final void zzy() {
        zzaE();
        this.zzd.zzh();
    }
}
