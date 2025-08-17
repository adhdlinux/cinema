package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public abstract class zzrw extends zzhy {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private zzru zzA;
    private zzrs zzB;
    private int zzC;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private boolean zzH;
    private boolean zzI;
    private boolean zzJ;
    private boolean zzK;
    private boolean zzL;
    private zzrk zzM;
    private long zzN;
    private int zzO;
    private int zzP;
    private ByteBuffer zzQ;
    private boolean zzR;
    private boolean zzS;
    private boolean zzT;
    private boolean zzU;
    private boolean zzV;
    private boolean zzW;
    private int zzX;
    private int zzY;
    private int zzZ;
    protected zzhz zza;
    private boolean zzaa;
    private boolean zzab;
    private boolean zzac;
    private long zzad;
    private long zzae;
    private boolean zzaf;
    private boolean zzag;
    private boolean zzah;
    private zzrv zzai;
    private long zzaj;
    private boolean zzak;
    private zzqv zzal;
    private zzqv zzam;
    private final zzro zzc;
    private final zzry zzd;
    private final float zze;
    private final zzhp zzf = new zzhp(0, 0);
    private final zzhp zzg = new zzhp(0, 0);
    private final zzhp zzh = new zzhp(2, 0);
    private final zzrj zzi;
    private final ArrayList zzj;
    private final MediaCodec.BufferInfo zzk;
    private final ArrayDeque zzl;
    private final zzqg zzm;
    private zzam zzn;
    private zzam zzo;
    private MediaCrypto zzp;
    private boolean zzq;
    private long zzr;
    private float zzs;
    private float zzt;
    private zzrp zzu;
    private zzam zzv;
    private MediaFormat zzw;
    private boolean zzx;
    private float zzy;
    private ArrayDeque zzz;

    public zzrw(int i2, zzro zzro, zzry zzry, boolean z2, float f2) {
        super(i2);
        this.zzc = zzro;
        zzry.getClass();
        this.zzd = zzry;
        this.zze = f2;
        zzrj zzrj = new zzrj();
        this.zzi = zzrj;
        this.zzj = new ArrayList();
        this.zzk = new MediaCodec.BufferInfo();
        this.zzs = 1.0f;
        this.zzt = 1.0f;
        this.zzr = -9223372036854775807L;
        this.zzl = new ArrayDeque();
        zzaG(zzrv.zza);
        zzrj.zzj(0);
        zzrj.zzb.order(ByteOrder.nativeOrder());
        this.zzm = new zzqg();
        this.zzy = -1.0f;
        this.zzC = 0;
        this.zzX = 0;
        this.zzO = -1;
        this.zzP = -1;
        this.zzN = -9223372036854775807L;
        this.zzad = -9223372036854775807L;
        this.zzae = -9223372036854775807L;
        this.zzaj = -9223372036854775807L;
        this.zzY = 0;
        this.zzZ = 0;
    }

    private final void zzW() {
        this.zzV = false;
        this.zzi.zzb();
        this.zzh.zzb();
        this.zzU = false;
        this.zzT = false;
        this.zzm.zzb();
    }

    private final void zzX() throws zzih {
        if (this.zzaa) {
            this.zzY = 1;
            this.zzZ = 3;
            return;
        }
        zzat();
        zzar();
    }

    protected static boolean zzaB(zzam zzam2) {
        return zzam2.zzF == 0;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x034f, code lost:
        if ("stvm8".equals(r5) == false) goto L_0x0362;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x035f, code lost:
        if ("OMX.amlogic.avc.decoder.awesome.secure".equals(r2) == false) goto L_0x0362;
     */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02f7  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02f9  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0329  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x032b  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x036f  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x042b  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0439  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x045f A[SYNTHETIC, Splitter:B:231:0x045f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzaC(com.google.android.gms.internal.ads.zzrs r21, android.media.MediaCrypto r22) throws java.lang.Exception {
        /*
            r20 = this;
            r8 = r20
            r0 = r21
            java.lang.String r1 = "createCodec:"
            java.lang.String r2 = r0.zza
            int r3 = com.google.android.gms.internal.ads.zzfj.zza
            r5 = 23
            if (r3 >= r5) goto L_0x0011
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x001d
        L_0x0011:
            float r6 = r8.zzt
            com.google.android.gms.internal.ads.zzam r7 = r8.zzn
            com.google.android.gms.internal.ads.zzam[] r9 = r20.zzM()
            float r6 = r8.zzS(r6, r7, r9)
        L_0x001d:
            float r7 = r8.zze
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x0025
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0025:
            com.google.android.gms.internal.ads.zzam r7 = r8.zzn
            r8.zzas(r7)
            long r9 = android.os.SystemClock.elapsedRealtime()
            com.google.android.gms.internal.ads.zzam r7 = r8.zzn
            r11 = 0
            com.google.android.gms.internal.ads.zzrn r7 = r8.zzY(r0, r7, r11, r6)
            r12 = 31
            if (r3 < r12) goto L_0x0040
            com.google.android.gms.internal.ads.zzoc r13 = r20.zzl()
            com.google.android.gms.internal.ads.zzrt.zza(r7, r13)
        L_0x0040:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0463 }
            r13.<init>()     // Catch:{ all -> 0x0463 }
            r13.append(r1)     // Catch:{ all -> 0x0463 }
            r13.append(r2)     // Catch:{ all -> 0x0463 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0463 }
            android.os.Trace.beginSection(r13)     // Catch:{ all -> 0x0463 }
            r13 = 0
            if (r3 < r5) goto L_0x0078
            if (r3 < r12) goto L_0x0078
            com.google.android.gms.internal.ads.zzam r1 = r7.zzc     // Catch:{ all -> 0x0463 }
            java.lang.String r1 = r1.zzm     // Catch:{ all -> 0x0463 }
            int r1 = com.google.android.gms.internal.ads.zzcc.zzb(r1)     // Catch:{ all -> 0x0463 }
            java.lang.String r3 = "DMCodecAdapterFactory"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzfj.zzy(r1)     // Catch:{ all -> 0x0463 }
            java.lang.String r12 = "Creating an asynchronous MediaCodec adapter for track type "
            java.lang.String r11 = r12.concat(r11)     // Catch:{ all -> 0x0463 }
            com.google.android.gms.internal.ads.zzer.zze(r3, r11)     // Catch:{ all -> 0x0463 }
            com.google.android.gms.internal.ads.zzra r3 = new com.google.android.gms.internal.ads.zzra     // Catch:{ all -> 0x0463 }
            r3.<init>(r1, r13)     // Catch:{ all -> 0x0463 }
            com.google.android.gms.internal.ads.zzrc r1 = r3.zzc(r7)     // Catch:{ all -> 0x0463 }
            goto L_0x00ad
        L_0x0078:
            com.google.android.gms.internal.ads.zzrs r3 = r7.zza     // Catch:{ IOException -> 0x045c, RuntimeException -> 0x045a }
            r3.getClass()
            java.lang.String r3 = r3.zza     // Catch:{ IOException -> 0x045c, RuntimeException -> 0x045a }
            java.lang.String r1 = r1.concat(r3)     // Catch:{ IOException -> 0x045c, RuntimeException -> 0x045a }
            android.os.Trace.beginSection(r1)     // Catch:{ IOException -> 0x045c, RuntimeException -> 0x045a }
            android.media.MediaCodec r1 = android.media.MediaCodec.createByCodecName(r3)     // Catch:{ IOException -> 0x045c, RuntimeException -> 0x045a }
            android.os.Trace.endSection()     // Catch:{ IOException -> 0x045c, RuntimeException -> 0x045a }
            java.lang.String r3 = "configureCodec"
            android.os.Trace.beginSection(r3)     // Catch:{ IOException -> 0x0457, RuntimeException -> 0x0455 }
            android.media.MediaFormat r3 = r7.zzb     // Catch:{ IOException -> 0x0457, RuntimeException -> 0x0455 }
            android.view.Surface r12 = r7.zzd     // Catch:{ IOException -> 0x0457, RuntimeException -> 0x0455 }
            r1.configure(r3, r12, r11, r13)     // Catch:{ IOException -> 0x0457, RuntimeException -> 0x0455 }
            android.os.Trace.endSection()     // Catch:{ IOException -> 0x0457, RuntimeException -> 0x0455 }
            java.lang.String r3 = "startCodec"
            android.os.Trace.beginSection(r3)     // Catch:{ IOException -> 0x0457, RuntimeException -> 0x0455 }
            r1.start()     // Catch:{ IOException -> 0x0457, RuntimeException -> 0x0455 }
            android.os.Trace.endSection()     // Catch:{ IOException -> 0x0457, RuntimeException -> 0x0455 }
            com.google.android.gms.internal.ads.zzsn r3 = new com.google.android.gms.internal.ads.zzsn     // Catch:{ IOException -> 0x0457, RuntimeException -> 0x0455 }
            r3.<init>(r1, r11)     // Catch:{ IOException -> 0x0457, RuntimeException -> 0x0455 }
            r1 = r3
        L_0x00ad:
            r8.zzu = r1     // Catch:{ all -> 0x0463 }
            android.os.Trace.endSection()
            long r11 = android.os.SystemClock.elapsedRealtime()
            com.google.android.gms.internal.ads.zzam r1 = r8.zzn
            boolean r1 = r0.zze(r1)
            r3 = 2
            if (r1 != 0) goto L_0x0267
            java.lang.Object[] r1 = new java.lang.Object[r3]
            com.google.android.gms.internal.ads.zzam r15 = r8.zzn
            com.google.android.gms.internal.ads.zzn r16 = com.google.android.gms.internal.ads.zzam.zza
            if (r15 != 0) goto L_0x00d0
            java.lang.String r4 = "null"
            r17 = r7
            r18 = r9
        L_0x00cd:
            r7 = 0
            goto L_0x0254
        L_0x00d0:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r13 = "id="
            r5.append(r13)
            java.lang.String r13 = r15.zzb
            r5.append(r13)
            java.lang.String r13 = ", mimeType="
            r5.append(r13)
            java.lang.String r13 = r15.zzm
            r5.append(r13)
            int r13 = r15.zzi
            r3 = -1
            if (r13 == r3) goto L_0x00f8
            java.lang.String r13 = ", bitrate="
            r5.append(r13)
            int r13 = r15.zzi
            r5.append(r13)
        L_0x00f8:
            java.lang.String r13 = r15.zzj
            if (r13 == 0) goto L_0x0106
            java.lang.String r13 = ", codecs="
            r5.append(r13)
            java.lang.String r13 = r15.zzj
            r5.append(r13)
        L_0x0106:
            com.google.android.gms.internal.ads.zzad r13 = r15.zzp
            java.lang.String r14 = ","
            if (r13 == 0) goto L_0x019e
            java.util.LinkedHashSet r13 = new java.util.LinkedHashSet
            r13.<init>()
            r4 = 0
        L_0x0112:
            com.google.android.gms.internal.ads.zzad r3 = r15.zzp
            r17 = r7
            int r7 = r3.zzb
            if (r4 >= r7) goto L_0x018e
            com.google.android.gms.internal.ads.zzac r3 = r3.zza(r4)
            java.util.UUID r3 = r3.zza
            java.util.UUID r7 = com.google.android.gms.internal.ads.zzo.zzb
            boolean r7 = r3.equals(r7)
            if (r7 == 0) goto L_0x0130
            java.lang.String r3 = "cenc"
            r13.add(r3)
        L_0x012d:
            r18 = r9
            goto L_0x0187
        L_0x0130:
            java.util.UUID r7 = com.google.android.gms.internal.ads.zzo.zzc
            boolean r7 = r3.equals(r7)
            if (r7 == 0) goto L_0x013e
            java.lang.String r3 = "clearkey"
            r13.add(r3)
            goto L_0x012d
        L_0x013e:
            java.util.UUID r7 = com.google.android.gms.internal.ads.zzo.zze
            boolean r7 = r3.equals(r7)
            if (r7 == 0) goto L_0x014c
            java.lang.String r3 = "playready"
            r13.add(r3)
            goto L_0x012d
        L_0x014c:
            java.util.UUID r7 = com.google.android.gms.internal.ads.zzo.zzd
            boolean r7 = r3.equals(r7)
            if (r7 == 0) goto L_0x015a
            java.lang.String r3 = "widevine"
            r13.add(r3)
            goto L_0x012d
        L_0x015a:
            java.util.UUID r7 = com.google.android.gms.internal.ads.zzo.zza
            boolean r7 = r3.equals(r7)
            if (r7 == 0) goto L_0x0168
            java.lang.String r3 = "universal"
            r13.add(r3)
            goto L_0x012d
        L_0x0168:
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r18 = r9
            java.lang.String r9 = "unknown ("
            r7.append(r9)
            r7.append(r3)
            java.lang.String r3 = ")"
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            r13.add(r3)
        L_0x0187:
            int r4 = r4 + 1
            r7 = r17
            r9 = r18
            goto L_0x0112
        L_0x018e:
            r18 = r9
            java.lang.String r3 = ", drm=["
            r5.append(r3)
            com.google.android.gms.internal.ads.zzfow.zzb(r5, r13, r14)
            r3 = 93
            r5.append(r3)
            goto L_0x01a2
        L_0x019e:
            r17 = r7
            r18 = r9
        L_0x01a2:
            int r3 = r15.zzr
            r4 = -1
            if (r3 == r4) goto L_0x01bf
            int r3 = r15.zzs
            if (r3 == r4) goto L_0x01bf
            java.lang.String r3 = ", res="
            r5.append(r3)
            int r3 = r15.zzr
            r5.append(r3)
            java.lang.String r3 = "x"
            r5.append(r3)
            int r3 = r15.zzs
            r5.append(r3)
        L_0x01bf:
            com.google.android.gms.internal.ads.zzs r3 = r15.zzy
            if (r3 == 0) goto L_0x01d7
            boolean r3 = r3.zze()
            if (r3 == 0) goto L_0x01d7
            java.lang.String r3 = ", color="
            r5.append(r3)
            com.google.android.gms.internal.ads.zzs r3 = r15.zzy
            java.lang.String r3 = r3.zzd()
            r5.append(r3)
        L_0x01d7:
            float r3 = r15.zzt
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x01e9
            java.lang.String r3 = ", fps="
            r5.append(r3)
            float r3 = r15.zzt
            r5.append(r3)
        L_0x01e9:
            int r3 = r15.zzz
            r4 = -1
            if (r3 == r4) goto L_0x01f8
            java.lang.String r3 = ", channels="
            r5.append(r3)
            int r3 = r15.zzz
            r5.append(r3)
        L_0x01f8:
            int r3 = r15.zzA
            if (r3 == r4) goto L_0x0206
            java.lang.String r3 = ", sample_rate="
            r5.append(r3)
            int r3 = r15.zzA
            r5.append(r3)
        L_0x0206:
            java.lang.String r3 = r15.zzd
            if (r3 == 0) goto L_0x0214
            java.lang.String r3 = ", language="
            r5.append(r3)
            java.lang.String r3 = r15.zzd
            r5.append(r3)
        L_0x0214:
            java.lang.String r3 = r15.zzc
            if (r3 == 0) goto L_0x0222
            java.lang.String r3 = ", label="
            r5.append(r3)
            java.lang.String r3 = r15.zzc
            r5.append(r3)
        L_0x0222:
            int r3 = r15.zze
            if (r3 == 0) goto L_0x024e
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            int r4 = r15.zze
            r7 = 1
            r4 = r4 & r7
            if (r4 == 0) goto L_0x0236
            java.lang.String r4 = "default"
            r3.add(r4)
        L_0x0236:
            int r4 = r15.zze
            r7 = 2
            r4 = r4 & r7
            if (r4 == 0) goto L_0x0241
            java.lang.String r4 = "forced"
            r3.add(r4)
        L_0x0241:
            java.lang.String r4 = ", selectionFlags=["
            r5.append(r4)
            com.google.android.gms.internal.ads.zzfow.zzb(r5, r3, r14)
            java.lang.String r3 = "]"
            r5.append(r3)
        L_0x024e:
            java.lang.String r4 = r5.toString()
            goto L_0x00cd
        L_0x0254:
            r1[r7] = r4
            r3 = 1
            r1[r3] = r2
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r4 = "Format exceeds selected codec's capabilities [%s, %s]"
            java.lang.String r1 = java.lang.String.format(r3, r4, r1)
            java.lang.String r3 = "MediaCodecRenderer"
            com.google.android.gms.internal.ads.zzer.zzf(r3, r1)
            goto L_0x026c
        L_0x0267:
            r17 = r7
            r18 = r9
            r7 = 0
        L_0x026c:
            r8.zzB = r0
            r8.zzy = r6
            com.google.android.gms.internal.ads.zzam r1 = r8.zzn
            r8.zzv = r1
            int r1 = com.google.android.gms.internal.ads.zzfj.zza
            java.lang.String r3 = "OMX.Exynos.avc.dec.secure"
            r4 = 25
            if (r1 > r4) goto L_0x02a6
            boolean r5 = r3.equals(r2)
            if (r5 == 0) goto L_0x02a6
            java.lang.String r5 = com.google.android.gms.internal.ads.zzfj.zzd
            java.lang.String r6 = "SM-T585"
            boolean r6 = r5.startsWith(r6)
            if (r6 != 0) goto L_0x02a4
            java.lang.String r6 = "SM-A510"
            boolean r6 = r5.startsWith(r6)
            if (r6 != 0) goto L_0x02a4
            java.lang.String r6 = "SM-A520"
            boolean r6 = r5.startsWith(r6)
            if (r6 != 0) goto L_0x02a4
            java.lang.String r6 = "SM-J700"
            boolean r5 = r5.startsWith(r6)
            if (r5 == 0) goto L_0x02a6
        L_0x02a4:
            r5 = 2
            goto L_0x02df
        L_0x02a6:
            r5 = 24
            if (r1 >= r5) goto L_0x02de
            java.lang.String r5 = "OMX.Nvidia.h264.decode"
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x02ba
            java.lang.String r5 = "OMX.Nvidia.h264.decode.secure"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x02de
        L_0x02ba:
            java.lang.String r5 = com.google.android.gms.internal.ads.zzfj.zzb
            java.lang.String r6 = "flounder"
            boolean r6 = r6.equals(r5)
            if (r6 != 0) goto L_0x02dc
            java.lang.String r6 = "flounder_lte"
            boolean r6 = r6.equals(r5)
            if (r6 != 0) goto L_0x02dc
            java.lang.String r6 = "grouper"
            boolean r6 = r6.equals(r5)
            if (r6 != 0) goto L_0x02dc
            java.lang.String r6 = "tilapia"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x02de
        L_0x02dc:
            r5 = 1
            goto L_0x02df
        L_0x02de:
            r5 = 0
        L_0x02df:
            r8.zzC = r5
            com.google.android.gms.internal.ads.zzam r5 = r8.zzv
            r6 = 21
            if (r1 >= r6) goto L_0x02f9
            java.util.List r5 = r5.zzo
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x02f9
            java.lang.String r5 = "OMX.MTK.VIDEO.DECODER.AVC"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x02f9
            r5 = 1
            goto L_0x02fa
        L_0x02f9:
            r5 = 0
        L_0x02fa:
            r8.zzD = r5
            r5 = 19
            if (r1 != r5) goto L_0x031a
            java.lang.String r9 = com.google.android.gms.internal.ads.zzfj.zzd
            java.lang.String r10 = "SM-G800"
            boolean r9 = r9.startsWith(r10)
            if (r9 == 0) goto L_0x031a
            java.lang.String r9 = "OMX.Exynos.avc.dec"
            boolean r9 = r9.equals(r2)
            if (r9 != 0) goto L_0x0318
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x031a
        L_0x0318:
            r3 = 1
            goto L_0x031b
        L_0x031a:
            r3 = 0
        L_0x031b:
            r8.zzE = r3
            r3 = 29
            if (r1 != r3) goto L_0x032b
            java.lang.String r9 = "c2.android.aac.decoder"
            boolean r9 = r9.equals(r2)
            if (r9 == 0) goto L_0x032b
            r9 = 1
            goto L_0x032c
        L_0x032b:
            r9 = 0
        L_0x032c:
            r8.zzF = r9
            r9 = 23
            if (r1 > r9) goto L_0x033d
            java.lang.String r9 = "OMX.google.vorbis.decoder"
            boolean r9 = r9.equals(r2)
            if (r9 != 0) goto L_0x033b
            goto L_0x033d
        L_0x033b:
            r5 = 1
            goto L_0x0363
        L_0x033d:
            if (r1 > r5) goto L_0x0362
            java.lang.String r5 = com.google.android.gms.internal.ads.zzfj.zzb
            java.lang.String r9 = "hb2000"
            boolean r9 = r9.equals(r5)
            if (r9 != 0) goto L_0x0351
            java.lang.String r9 = "stvm8"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x0362
        L_0x0351:
            java.lang.String r5 = "OMX.amlogic.avc.decoder.awesome"
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x033b
            java.lang.String r5 = "OMX.amlogic.avc.decoder.awesome.secure"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x0362
            goto L_0x033b
        L_0x0362:
            r5 = 0
        L_0x0363:
            r8.zzG = r5
            if (r1 != r6) goto L_0x0371
            java.lang.String r5 = "OMX.google.aac.decoder"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x0371
            r5 = 1
            goto L_0x0372
        L_0x0371:
            r5 = 0
        L_0x0372:
            r8.zzH = r5
            if (r1 >= r6) goto L_0x03bc
            java.lang.String r5 = "OMX.SEC.mp3.dec"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x03bc
            java.lang.String r5 = "samsung"
            java.lang.String r6 = com.google.android.gms.internal.ads.zzfj.zzc
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x03bc
            java.lang.String r5 = com.google.android.gms.internal.ads.zzfj.zzb
            java.lang.String r6 = "baffin"
            boolean r6 = r5.startsWith(r6)
            if (r6 != 0) goto L_0x03ba
            java.lang.String r6 = "grand"
            boolean r6 = r5.startsWith(r6)
            if (r6 != 0) goto L_0x03ba
            java.lang.String r6 = "fortuna"
            boolean r6 = r5.startsWith(r6)
            if (r6 != 0) goto L_0x03ba
            java.lang.String r6 = "gprimelte"
            boolean r6 = r5.startsWith(r6)
            if (r6 != 0) goto L_0x03ba
            java.lang.String r6 = "j2y18lte"
            boolean r6 = r5.startsWith(r6)
            if (r6 != 0) goto L_0x03ba
            java.lang.String r6 = "ms01"
            boolean r5 = r5.startsWith(r6)
            if (r5 == 0) goto L_0x03bc
        L_0x03ba:
            r5 = 1
            goto L_0x03bd
        L_0x03bc:
            r5 = 0
        L_0x03bd:
            r8.zzI = r5
            java.lang.String r5 = r0.zza
            if (r1 > r4) goto L_0x03ce
            java.lang.String r4 = "OMX.rk.video_decoder.avc"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x03cc
            goto L_0x03ce
        L_0x03cc:
            r13 = 1
            goto L_0x041a
        L_0x03ce:
            if (r1 > r3) goto L_0x0400
            java.lang.String r1 = "OMX.broadcom.video_decoder.tunnel"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x03cc
            java.lang.String r1 = "OMX.broadcom.video_decoder.tunnel.secure"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x03cc
            java.lang.String r1 = "OMX.bcm.vdec.avc.tunnel"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x03cc
            java.lang.String r1 = "OMX.bcm.vdec.avc.tunnel.secure"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x03cc
            java.lang.String r1 = "OMX.bcm.vdec.hevc.tunnel"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x03cc
            java.lang.String r1 = "OMX.bcm.vdec.hevc.tunnel.secure"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x03cc
        L_0x0400:
            java.lang.String r1 = "Amazon"
            java.lang.String r3 = com.google.android.gms.internal.ads.zzfj.zzc
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0419
            java.lang.String r1 = "AFTS"
            java.lang.String r3 = com.google.android.gms.internal.ads.zzfj.zzd
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0419
            boolean r1 = r0.zzf
            if (r1 == 0) goto L_0x0419
            goto L_0x03cc
        L_0x0419:
            r13 = 0
        L_0x041a:
            r8.zzL = r13
            com.google.android.gms.internal.ads.zzrp r1 = r8.zzu
            r1.zzr()
            java.lang.String r0 = r0.zza
            java.lang.String r1 = "c2.android.mp3.decoder"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0432
            com.google.android.gms.internal.ads.zzrk r0 = new com.google.android.gms.internal.ads.zzrk
            r0.<init>()
            r8.zzM = r0
        L_0x0432:
            int r0 = r20.zzbc()
            r1 = 2
            if (r0 != r1) goto L_0x0442
            long r0 = android.os.SystemClock.elapsedRealtime()
            r3 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 + r3
            r8.zzN = r0
        L_0x0442:
            com.google.android.gms.internal.ads.zzhz r0 = r8.zza
            int r1 = r0.zza
            r3 = 1
            int r1 = r1 + r3
            r0.zza = r1
            long r6 = r11 - r18
            r1 = r20
            r3 = r17
            r4 = r11
            r1.zzab(r2, r3, r4, r6)
            return
        L_0x0455:
            r0 = move-exception
            goto L_0x0458
        L_0x0457:
            r0 = move-exception
        L_0x0458:
            r11 = r1
            goto L_0x045d
        L_0x045a:
            r0 = move-exception
            goto L_0x045d
        L_0x045c:
            r0 = move-exception
        L_0x045d:
            if (r11 == 0) goto L_0x0462
            r11.release()     // Catch:{ all -> 0x0463 }
        L_0x0462:
            throw r0     // Catch:{ all -> 0x0463 }
        L_0x0463:
            r0 = move-exception
            android.os.Trace.endSection()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrw.zzaC(com.google.android.gms.internal.ads.zzrs, android.media.MediaCrypto):void");
    }

    @TargetApi(23)
    private final void zzaD() throws zzih {
        int i2 = this.zzZ;
        if (i2 == 1) {
            zzae();
        } else if (i2 == 2) {
            zzae();
            zzaH();
        } else if (i2 != 3) {
            this.zzag = true;
            zzai();
        } else {
            zzat();
            zzar();
        }
    }

    private final void zzaE() {
        this.zzO = -1;
        this.zzg.zzb = null;
    }

    private final void zzaF() {
        this.zzP = -1;
        this.zzQ = null;
    }

    private final void zzaG(zzrv zzrv) {
        this.zzai = zzrv;
        if (zzrv.zzc != -9223372036854775807L) {
            this.zzak = true;
        }
    }

    private final void zzaH() throws zzih {
        this.zzal = this.zzam;
        this.zzY = 0;
        this.zzZ = 0;
    }

    @TargetApi(23)
    private final boolean zzaI() throws zzih {
        if (this.zzaa) {
            this.zzY = 1;
            if (this.zzE || this.zzG) {
                this.zzZ = 3;
                return false;
            }
            this.zzZ = 2;
        } else {
            zzaH();
        }
        return true;
    }

    private final boolean zzaJ() throws zzih {
        zzrp zzrp = this.zzu;
        if (zzrp == null || this.zzY == 2 || this.zzaf) {
            return false;
        }
        if (this.zzO < 0) {
            int zza2 = zzrp.zza();
            this.zzO = zza2;
            if (zza2 < 0) {
                return false;
            }
            this.zzg.zzb = this.zzu.zzf(zza2);
            this.zzg.zzb();
        }
        if (this.zzY == 1) {
            if (!this.zzL) {
                this.zzab = true;
                this.zzu.zzj(this.zzO, 0, 0, 0, 4);
                zzaE();
            }
            this.zzY = 2;
            return false;
        } else if (this.zzJ) {
            this.zzJ = false;
            this.zzg.zzb.put(zzb);
            this.zzu.zzj(this.zzO, 0, 38, 0, 0);
            zzaE();
            this.zzaa = true;
            return true;
        } else {
            if (this.zzX == 1) {
                for (int i2 = 0; i2 < this.zzv.zzo.size(); i2++) {
                    this.zzg.zzb.put((byte[]) this.zzv.zzo.get(i2));
                }
                this.zzX = 2;
            }
            int position = this.zzg.zzb.position();
            zzkj zzh2 = zzh();
            try {
                int zzbd = zzbd(zzh2, this.zzg, 0);
                if (zzJ() || this.zzg.zzi()) {
                    this.zzae = this.zzad;
                }
                if (zzbd == -3) {
                    return false;
                }
                if (zzbd == -5) {
                    if (this.zzX == 2) {
                        this.zzg.zzb();
                        this.zzX = 1;
                    }
                    zzV(zzh2);
                    return true;
                }
                zzhp zzhp = this.zzg;
                if (zzhp.zzg()) {
                    if (this.zzX == 2) {
                        zzhp.zzb();
                        this.zzX = 1;
                    }
                    this.zzaf = true;
                    if (!this.zzaa) {
                        zzaD();
                        return false;
                    }
                    try {
                        if (!this.zzL) {
                            this.zzab = true;
                            this.zzu.zzj(this.zzO, 0, 0, 0, 4);
                            zzaE();
                        }
                        return false;
                    } catch (MediaCodec.CryptoException e2) {
                        throw zzbe(e2, this.zzn, false, zzfj.zzh(e2.getErrorCode()));
                    }
                } else if (this.zzaa || zzhp.zzh()) {
                    boolean zzl2 = zzhp.zzl();
                    if (zzl2) {
                        zzhp.zza.zzb(position);
                    }
                    if (this.zzD && !zzl2) {
                        ByteBuffer byteBuffer = this.zzg.zzb;
                        byte[] bArr = zzfu.zza;
                        int position2 = byteBuffer.position();
                        int i3 = 0;
                        int i4 = 0;
                        while (true) {
                            int i5 = i3 + 1;
                            if (i5 >= position2) {
                                byteBuffer.clear();
                                break;
                            }
                            byte b2 = byteBuffer.get(i3) & 255;
                            if (i4 == 3) {
                                if (b2 == 1) {
                                    if ((byteBuffer.get(i5) & 31) == 7) {
                                        ByteBuffer duplicate = byteBuffer.duplicate();
                                        duplicate.position(i3 - 3);
                                        duplicate.limit(position2);
                                        byteBuffer.position(0);
                                        byteBuffer.put(duplicate);
                                        break;
                                    }
                                    b2 = 1;
                                }
                            } else if (b2 == 0) {
                                i4++;
                            }
                            if (b2 != 0) {
                                i4 = 0;
                            }
                            i3 = i5;
                        }
                        if (this.zzg.zzb.position() == 0) {
                            return true;
                        }
                        this.zzD = false;
                    }
                    zzhp zzhp2 = this.zzg;
                    long j2 = zzhp2.zzd;
                    zzrk zzrk = this.zzM;
                    if (zzrk != null) {
                        j2 = zzrk.zzb(this.zzn, zzhp2);
                        this.zzad = Math.max(this.zzad, this.zzM.zza(this.zzn));
                    }
                    long j3 = j2;
                    if (this.zzg.zzf()) {
                        this.zzj.add(Long.valueOf(j3));
                    }
                    if (this.zzah) {
                        if (!this.zzl.isEmpty()) {
                            ((zzrv) this.zzl.peekLast()).zzd.zzd(j3, this.zzn);
                        } else {
                            this.zzai.zzd.zzd(j3, this.zzn);
                        }
                        this.zzah = false;
                    }
                    this.zzad = Math.max(this.zzad, j3);
                    this.zzg.zzk();
                    zzhp zzhp3 = this.zzg;
                    if (zzhp3.zze()) {
                        zzaq(zzhp3);
                    }
                    zzah(this.zzg);
                    if (zzl2) {
                        try {
                            this.zzu.zzk(this.zzO, 0, this.zzg.zza, j3, 0);
                        } catch (MediaCodec.CryptoException e3) {
                            throw zzbe(e3, this.zzn, false, zzfj.zzh(e3.getErrorCode()));
                        }
                    } else {
                        this.zzu.zzj(this.zzO, 0, this.zzg.zzb.limit(), j3, 0);
                    }
                    zzaE();
                    this.zzaa = true;
                    this.zzX = 0;
                    this.zza.zzc++;
                    return true;
                } else {
                    zzhp.zzb();
                    if (this.zzX == 2) {
                        this.zzX = 1;
                    }
                    return true;
                }
            } catch (zzho e4) {
                zzaa(e4);
                zzaL(0);
                zzae();
                return true;
            }
        }
    }

    private final boolean zzaK() {
        return this.zzP >= 0;
    }

    private final boolean zzaL(int i2) throws zzih {
        zzkj zzh2 = zzh();
        this.zzf.zzb();
        int zzbd = zzbd(zzh2, this.zzf, i2 | 4);
        if (zzbd == -5) {
            zzV(zzh2);
            return true;
        } else if (zzbd != -4 || !this.zzf.zzg()) {
            return false;
        } else {
            this.zzaf = true;
            zzaD();
            return false;
        }
    }

    private final boolean zzaM(long j2) {
        return this.zzr == -9223372036854775807L || SystemClock.elapsedRealtime() - j2 < this.zzr;
    }

    private final boolean zzaN(zzam zzam2) throws zzih {
        if (!(zzfj.zza < 23 || this.zzu == null || this.zzZ == 3 || zzbc() == 0)) {
            float zzS2 = zzS(this.zzt, zzam2, zzM());
            float f2 = this.zzy;
            if (f2 == zzS2) {
                return true;
            }
            if (zzS2 == -1.0f) {
                zzX();
                return false;
            } else if (f2 == -1.0f && zzS2 <= this.zze) {
                return true;
            } else {
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", zzS2);
                this.zzu.zzp(bundle);
                this.zzy = zzS2;
            }
        }
        return true;
    }

    private final void zzae() {
        try {
            this.zzu.zzi();
        } finally {
            zzau();
        }
    }

    public void zzG(float f2, float f3) throws zzih {
        this.zzs = f2;
        this.zzt = f3;
        zzaN(this.zzv);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: com.google.android.gms.internal.ads.zzrw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.ads.zzrw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.google.android.gms.internal.ads.zzrw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v8, resolved type: com.google.android.gms.internal.ads.zzrw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: com.google.android.gms.internal.ads.zzrp} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: com.google.android.gms.internal.ads.zzrw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: android.media.MediaFormat} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v17, resolved type: com.google.android.gms.internal.ads.zzrw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v75, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v26, resolved type: com.google.android.gms.internal.ads.zzrw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v27, resolved type: com.google.android.gms.internal.ads.zzrw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v76, resolved type: com.google.android.gms.internal.ads.zzrw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v79, resolved type: com.google.android.gms.internal.ads.zzrw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v87, resolved type: com.google.android.gms.internal.ads.zzrw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v31, resolved type: com.google.android.gms.internal.ads.zzam} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v88, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v89, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v91, resolved type: com.google.android.gms.internal.ads.zzrw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v93, resolved type: com.google.android.gms.internal.ads.zzrw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v95, resolved type: com.google.android.gms.internal.ads.zzrw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v96, resolved type: com.google.android.gms.internal.ads.zzrw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v97, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v98, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v100, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v101, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v38, resolved type: com.google.android.gms.internal.ads.zzam} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v39, resolved type: com.google.android.gms.internal.ads.zzrw} */
    /* JADX WARNING: type inference failed for: r1v31, types: [android.media.MediaFormat] */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:91|92|(1:94)(0)) */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x027f, code lost:
        if (r15.zzo != null) goto L_0x0281;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x02cd, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:?, code lost:
        zzaD();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x02d0, code lost:
        r15 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x02d2, code lost:
        r1 = r1;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x02d4, code lost:
        if (r15.zzag != false) goto L_0x02d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x02d6, code lost:
        zzat();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x02d9, code lost:
        r1 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x02da, code lost:
        r2 = r21;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x02dd, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x034e, code lost:
        r0 = e;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0167, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
        zzaD();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x016c, code lost:
        if (r15.zzag != false) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x016e, code lost:
        zzat();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:174:0x02cd */
    /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x0167 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01ba A[Catch:{ IllegalStateException -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x030e  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x032f A[Catch:{ IllegalStateException -> 0x0370 }, LOOP:2: B:82:0x0150->B:202:0x032f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0339 A[Catch:{ IllegalStateException -> 0x0370 }, LOOP:4: B:204:0x0339->B:207:0x0343, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0336 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x032e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0181 A[Catch:{ IllegalStateException -> 0x0373 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzO(long r24, long r26) throws com.google.android.gms.internal.ads.zzih {
        /*
            r23 = this;
            r15 = r23
            r14 = 1
            r13 = 0
            boolean r0 = r15.zzag     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 == 0) goto L_0x000c
            r23.zzai()     // Catch:{ IllegalStateException -> 0x0373 }
            return
        L_0x000c:
            com.google.android.gms.internal.ads.zzam r0 = r15.zzn     // Catch:{ IllegalStateException -> 0x0373 }
            r11 = 2
            if (r0 != 0) goto L_0x0019
            boolean r0 = r15.zzaL(r11)     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 == 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            return
        L_0x0019:
            r23.zzar()     // Catch:{ IllegalStateException -> 0x0373 }
            boolean r0 = r15.zzT     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 == 0) goto L_0x0141
            java.lang.String r0 = "bypassRender"
            int r1 = com.google.android.gms.internal.ads.zzfj.zza     // Catch:{ IllegalStateException -> 0x0373 }
            android.os.Trace.beginSection(r0)     // Catch:{ IllegalStateException -> 0x0373 }
        L_0x0027:
            boolean r0 = r15.zzag     // Catch:{ IllegalStateException -> 0x0373 }
            r0 = r0 ^ r14
            com.google.android.gms.internal.ads.zzdy.zzf(r0)     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzrj r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0373 }
            boolean r1 = r0.zzq()     // Catch:{ IllegalStateException -> 0x0373 }
            if (r1 == 0) goto L_0x007b
            java.nio.ByteBuffer r7 = r0.zzb     // Catch:{ IllegalStateException -> 0x0373 }
            int r8 = r15.zzP     // Catch:{ IllegalStateException -> 0x0373 }
            int r10 = r0.zzm()     // Catch:{ IllegalStateException -> 0x0373 }
            long r11 = r0.zzd     // Catch:{ IllegalStateException -> 0x0373 }
            boolean r16 = r0.zzf()     // Catch:{ IllegalStateException -> 0x0373 }
            r6 = 0
            r9 = 0
            boolean r0 = r0.zzg()     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzam r4 = r15.zzo     // Catch:{ IllegalStateException -> 0x0373 }
            r1 = r23
            r2 = r24
            r17 = r4
            r4 = r26
            r13 = r16
            r14 = r0
            r15 = r17
            boolean r0 = r1.zzaj(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x0075 }
            if (r0 == 0) goto L_0x006f
            r15 = r23
            com.google.android.gms.internal.ads.zzrj r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0373 }
            long r0 = r0.zzn()     // Catch:{ IllegalStateException -> 0x0373 }
            r15.zzaf(r0)     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzrj r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0373 }
            r0.zzb()     // Catch:{ IllegalStateException -> 0x0373 }
            goto L_0x007b
        L_0x006f:
            r15 = r23
            r13 = 0
            r14 = 1
            goto L_0x0138
        L_0x0075:
            r0 = move-exception
            r2 = 1
            r19 = 0
            goto L_0x02df
        L_0x007b:
            boolean r0 = r15.zzaf     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 == 0) goto L_0x0085
            r14 = 1
            r15.zzag = r14     // Catch:{ IllegalStateException -> 0x0373 }
            r13 = 0
            goto L_0x0138
        L_0x0085:
            r14 = 1
            boolean r0 = r15.zzU     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 == 0) goto L_0x0099
            com.google.android.gms.internal.ads.zzrj r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzhp r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0373 }
            boolean r0 = r0.zzp(r1)     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzdy.zzf(r0)     // Catch:{ IllegalStateException -> 0x0373 }
            r13 = 0
            r15.zzU = r13     // Catch:{ IllegalStateException -> 0x0373 }
            goto L_0x009a
        L_0x0099:
            r13 = 0
        L_0x009a:
            boolean r0 = r15.zzV     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 == 0) goto L_0x00b2
            com.google.android.gms.internal.ads.zzrj r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0373 }
            boolean r0 = r0.zzq()     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 != 0) goto L_0x0027
            r23.zzW()     // Catch:{ IllegalStateException -> 0x0373 }
            r15.zzV = r13     // Catch:{ IllegalStateException -> 0x0373 }
            r23.zzar()     // Catch:{ IllegalStateException -> 0x0373 }
            boolean r0 = r15.zzT     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 == 0) goto L_0x0138
        L_0x00b2:
            boolean r0 = r15.zzaf     // Catch:{ IllegalStateException -> 0x0373 }
            r0 = r0 ^ r14
            com.google.android.gms.internal.ads.zzdy.zzf(r0)     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzkj r0 = r23.zzh()     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzhp r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0373 }
            r1.zzb()     // Catch:{ IllegalStateException -> 0x0373 }
        L_0x00c1:
            com.google.android.gms.internal.ads.zzhp r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0373 }
            r1.zzb()     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzhp r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0373 }
            int r1 = r15.zzbd(r0, r1, r13)     // Catch:{ IllegalStateException -> 0x0373 }
            r2 = -5
            if (r1 == r2) goto L_0x0118
            r2 = -4
            if (r1 == r2) goto L_0x00d3
            goto L_0x011b
        L_0x00d3:
            com.google.android.gms.internal.ads.zzhp r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0373 }
            boolean r1 = r1.zzg()     // Catch:{ IllegalStateException -> 0x0373 }
            if (r1 == 0) goto L_0x00de
            r15.zzaf = r14     // Catch:{ IllegalStateException -> 0x0373 }
            goto L_0x011b
        L_0x00de:
            boolean r1 = r15.zzah     // Catch:{ IllegalStateException -> 0x0373 }
            if (r1 == 0) goto L_0x00ef
            com.google.android.gms.internal.ads.zzam r1 = r15.zzn     // Catch:{ IllegalStateException -> 0x0373 }
            r1.getClass()
            r15.zzo = r1     // Catch:{ IllegalStateException -> 0x0373 }
            r2 = 0
            r15.zzad(r1, r2)     // Catch:{ IllegalStateException -> 0x0373 }
            r15.zzah = r13     // Catch:{ IllegalStateException -> 0x0373 }
        L_0x00ef:
            com.google.android.gms.internal.ads.zzhp r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0373 }
            r1.zzk()     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzam r1 = r15.zzn     // Catch:{ IllegalStateException -> 0x0373 }
            if (r1 == 0) goto L_0x010b
            java.lang.String r1 = r1.zzm     // Catch:{ IllegalStateException -> 0x0373 }
            if (r1 == 0) goto L_0x010b
            java.lang.String r2 = "audio/opus"
            boolean r1 = r1.equals(r2)     // Catch:{ IllegalStateException -> 0x0373 }
            if (r1 == 0) goto L_0x010b
            com.google.android.gms.internal.ads.zzqg r1 = r15.zzm     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzhp r2 = r15.zzh     // Catch:{ IllegalStateException -> 0x0373 }
            r1.zza(r2)     // Catch:{ IllegalStateException -> 0x0373 }
        L_0x010b:
            com.google.android.gms.internal.ads.zzrj r1 = r15.zzi     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzhp r2 = r15.zzh     // Catch:{ IllegalStateException -> 0x0373 }
            boolean r1 = r1.zzp(r2)     // Catch:{ IllegalStateException -> 0x0373 }
            if (r1 != 0) goto L_0x00c1
            r15.zzU = r14     // Catch:{ IllegalStateException -> 0x0373 }
            goto L_0x011b
        L_0x0118:
            r15.zzV(r0)     // Catch:{ IllegalStateException -> 0x0373 }
        L_0x011b:
            com.google.android.gms.internal.ads.zzrj r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0373 }
            boolean r1 = r0.zzq()     // Catch:{ IllegalStateException -> 0x0373 }
            if (r1 == 0) goto L_0x0126
            r0.zzk()     // Catch:{ IllegalStateException -> 0x0373 }
        L_0x0126:
            com.google.android.gms.internal.ads.zzrj r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0373 }
            boolean r0 = r0.zzq()     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 != 0) goto L_0x0027
            boolean r0 = r15.zzaf     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 != 0) goto L_0x0027
            boolean r0 = r15.zzV     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 == 0) goto L_0x0138
            goto L_0x0027
        L_0x0138:
            android.os.Trace.endSection()     // Catch:{ IllegalStateException -> 0x0373 }
            r1 = r15
            r2 = 1
            r19 = 0
            goto L_0x0368
        L_0x0141:
            com.google.android.gms.internal.ads.zzrp r0 = r15.zzu     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 == 0) goto L_0x0356
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IllegalStateException -> 0x0351 }
            java.lang.String r0 = "drainAndFeed"
            int r1 = com.google.android.gms.internal.ads.zzfj.zza     // Catch:{ IllegalStateException -> 0x0351 }
            android.os.Trace.beginSection(r0)     // Catch:{ IllegalStateException -> 0x0351 }
        L_0x0150:
            boolean r0 = r23.zzaK()     // Catch:{ IllegalStateException -> 0x0351 }
            if (r0 != 0) goto L_0x028c
            boolean r0 = r15.zzH     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 == 0) goto L_0x0177
            boolean r0 = r15.zzab     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 == 0) goto L_0x0177
            com.google.android.gms.internal.ads.zzrp r0 = r15.zzu     // Catch:{ IllegalStateException -> 0x0167 }
            android.media.MediaCodec$BufferInfo r1 = r15.zzk     // Catch:{ IllegalStateException -> 0x0167 }
            int r0 = r0.zzb(r1)     // Catch:{ IllegalStateException -> 0x0167 }
            goto L_0x017f
        L_0x0167:
            r23.zzaD()     // Catch:{ IllegalStateException -> 0x0373 }
            boolean r0 = r15.zzag     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 == 0) goto L_0x0171
            r23.zzat()     // Catch:{ IllegalStateException -> 0x0373 }
        L_0x0171:
            r2 = r9
            r1 = r15
            r19 = 0
            goto L_0x0339
        L_0x0177:
            com.google.android.gms.internal.ads.zzrp r0 = r15.zzu     // Catch:{ IllegalStateException -> 0x0373 }
            android.media.MediaCodec$BufferInfo r1 = r15.zzk     // Catch:{ IllegalStateException -> 0x0373 }
            int r0 = r0.zzb(r1)     // Catch:{ IllegalStateException -> 0x0373 }
        L_0x017f:
            if (r0 >= 0) goto L_0x01ba
            r1 = -2
            if (r0 != r1) goto L_0x01aa
            r15.zzac = r14     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzrp r0 = r15.zzu     // Catch:{ IllegalStateException -> 0x0373 }
            android.media.MediaFormat r0 = r0.zzc()     // Catch:{ IllegalStateException -> 0x0373 }
            int r1 = r15.zzC     // Catch:{ IllegalStateException -> 0x0373 }
            if (r1 == 0) goto L_0x01a5
            java.lang.String r1 = "width"
            int r1 = r0.getInteger(r1)     // Catch:{ IllegalStateException -> 0x0373 }
            r2 = 32
            if (r1 != r2) goto L_0x01a5
            java.lang.String r1 = "height"
            int r1 = r0.getInteger(r1)     // Catch:{ IllegalStateException -> 0x0373 }
            if (r1 != r2) goto L_0x01a5
            r15.zzK = r14     // Catch:{ IllegalStateException -> 0x0373 }
            goto L_0x01c5
        L_0x01a5:
            r15.zzw = r0     // Catch:{ IllegalStateException -> 0x0373 }
            r15.zzx = r14     // Catch:{ IllegalStateException -> 0x0373 }
            goto L_0x01c5
        L_0x01aa:
            boolean r0 = r15.zzL     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 == 0) goto L_0x0171
            boolean r0 = r15.zzaf     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 != 0) goto L_0x01b6
            int r0 = r15.zzY     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 != r11) goto L_0x0171
        L_0x01b6:
            r23.zzaD()     // Catch:{ IllegalStateException -> 0x0373 }
            goto L_0x0171
        L_0x01ba:
            boolean r1 = r15.zzK     // Catch:{ IllegalStateException -> 0x0373 }
            if (r1 == 0) goto L_0x01cd
            r15.zzK = r13     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzrp r1 = r15.zzu     // Catch:{ IllegalStateException -> 0x0373 }
            r1.zzn(r0, r13)     // Catch:{ IllegalStateException -> 0x0373 }
        L_0x01c5:
            r2 = r9
            r1 = r15
            r16 = 2
            r19 = 0
            goto L_0x0328
        L_0x01cd:
            android.media.MediaCodec$BufferInfo r1 = r15.zzk     // Catch:{ IllegalStateException -> 0x0373 }
            int r2 = r1.size     // Catch:{ IllegalStateException -> 0x0373 }
            if (r2 != 0) goto L_0x01dd
            int r1 = r1.flags     // Catch:{ IllegalStateException -> 0x0373 }
            r1 = r1 & 4
            if (r1 == 0) goto L_0x01dd
            r23.zzaD()     // Catch:{ IllegalStateException -> 0x0373 }
            goto L_0x0171
        L_0x01dd:
            r15.zzP = r0     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzrp r1 = r15.zzu     // Catch:{ IllegalStateException -> 0x0373 }
            java.nio.ByteBuffer r0 = r1.zzg(r0)     // Catch:{ IllegalStateException -> 0x0373 }
            r15.zzQ = r0     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 == 0) goto L_0x01fc
            android.media.MediaCodec$BufferInfo r1 = r15.zzk     // Catch:{ IllegalStateException -> 0x0373 }
            int r1 = r1.offset     // Catch:{ IllegalStateException -> 0x0373 }
            r0.position(r1)     // Catch:{ IllegalStateException -> 0x0373 }
            java.nio.ByteBuffer r0 = r15.zzQ     // Catch:{ IllegalStateException -> 0x0373 }
            android.media.MediaCodec$BufferInfo r1 = r15.zzk     // Catch:{ IllegalStateException -> 0x0373 }
            int r2 = r1.offset     // Catch:{ IllegalStateException -> 0x0373 }
            int r1 = r1.size     // Catch:{ IllegalStateException -> 0x0373 }
            int r2 = r2 + r1
            r0.limit(r2)     // Catch:{ IllegalStateException -> 0x0373 }
        L_0x01fc:
            boolean r0 = r15.zzI     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 == 0) goto L_0x021d
            android.media.MediaCodec$BufferInfo r0 = r15.zzk     // Catch:{ IllegalStateException -> 0x0373 }
            long r1 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0373 }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x021d
            int r1 = r0.flags     // Catch:{ IllegalStateException -> 0x0373 }
            r1 = r1 & 4
            if (r1 == 0) goto L_0x021d
            long r1 = r15.zzad     // Catch:{ IllegalStateException -> 0x0373 }
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x021d
            r0.presentationTimeUs = r1     // Catch:{ IllegalStateException -> 0x0373 }
        L_0x021d:
            android.media.MediaCodec$BufferInfo r0 = r15.zzk     // Catch:{ IllegalStateException -> 0x0373 }
            long r0 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0373 }
            java.util.ArrayList r2 = r15.zzj     // Catch:{ IllegalStateException -> 0x0373 }
            int r2 = r2.size()     // Catch:{ IllegalStateException -> 0x0373 }
            r3 = 0
        L_0x0228:
            if (r3 >= r2) goto L_0x0244
            java.util.ArrayList r4 = r15.zzj     // Catch:{ IllegalStateException -> 0x0373 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ IllegalStateException -> 0x0373 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ IllegalStateException -> 0x0373 }
            long r4 = r4.longValue()     // Catch:{ IllegalStateException -> 0x0373 }
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 != 0) goto L_0x0241
            java.util.ArrayList r0 = r15.zzj     // Catch:{ IllegalStateException -> 0x0373 }
            r0.remove(r3)     // Catch:{ IllegalStateException -> 0x0373 }
            r0 = 1
            goto L_0x0245
        L_0x0241:
            int r3 = r3 + 1
            goto L_0x0228
        L_0x0244:
            r0 = 0
        L_0x0245:
            r15.zzR = r0     // Catch:{ IllegalStateException -> 0x0373 }
            long r0 = r15.zzae     // Catch:{ IllegalStateException -> 0x0373 }
            android.media.MediaCodec$BufferInfo r2 = r15.zzk     // Catch:{ IllegalStateException -> 0x0373 }
            long r2 = r2.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0373 }
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0253
            r0 = 1
            goto L_0x0254
        L_0x0253:
            r0 = 0
        L_0x0254:
            r15.zzS = r0     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzrv r0 = r15.zzai     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzfg r0 = r0.zzd     // Catch:{ IllegalStateException -> 0x0373 }
            java.lang.Object r0 = r0.zzc(r2)     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzam r0 = (com.google.android.gms.internal.ads.zzam) r0     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 != 0) goto L_0x0274
            boolean r1 = r15.zzak     // Catch:{ IllegalStateException -> 0x0373 }
            if (r1 == 0) goto L_0x0274
            android.media.MediaFormat r1 = r15.zzw     // Catch:{ IllegalStateException -> 0x0373 }
            if (r1 == 0) goto L_0x0274
            com.google.android.gms.internal.ads.zzrv r0 = r15.zzai     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzfg r0 = r0.zzd     // Catch:{ IllegalStateException -> 0x0373 }
            java.lang.Object r0 = r0.zzb()     // Catch:{ IllegalStateException -> 0x0373 }
            com.google.android.gms.internal.ads.zzam r0 = (com.google.android.gms.internal.ads.zzam) r0     // Catch:{ IllegalStateException -> 0x0373 }
        L_0x0274:
            if (r0 == 0) goto L_0x0279
            r15.zzo = r0     // Catch:{ IllegalStateException -> 0x0373 }
            goto L_0x0281
        L_0x0279:
            boolean r0 = r15.zzx     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 == 0) goto L_0x028c
            com.google.android.gms.internal.ads.zzam r0 = r15.zzo     // Catch:{ IllegalStateException -> 0x0373 }
            if (r0 == 0) goto L_0x028c
        L_0x0281:
            com.google.android.gms.internal.ads.zzam r0 = r15.zzo     // Catch:{ IllegalStateException -> 0x0373 }
            android.media.MediaFormat r1 = r15.zzw     // Catch:{ IllegalStateException -> 0x0373 }
            r15.zzad(r0, r1)     // Catch:{ IllegalStateException -> 0x0373 }
            r15.zzx = r13     // Catch:{ IllegalStateException -> 0x0373 }
            r15.zzak = r13     // Catch:{ IllegalStateException -> 0x0373 }
        L_0x028c:
            boolean r0 = r15.zzH     // Catch:{ IllegalStateException -> 0x0351 }
            if (r0 == 0) goto L_0x02e8
            boolean r0 = r15.zzab     // Catch:{ IllegalStateException -> 0x02e3 }
            if (r0 == 0) goto L_0x02e8
            com.google.android.gms.internal.ads.zzrp r6 = r15.zzu     // Catch:{ IllegalStateException -> 0x02c9 }
            java.nio.ByteBuffer r7 = r15.zzQ     // Catch:{ IllegalStateException -> 0x02c9 }
            int r8 = r15.zzP     // Catch:{ IllegalStateException -> 0x02c9 }
            android.media.MediaCodec$BufferInfo r0 = r15.zzk     // Catch:{ IllegalStateException -> 0x02c9 }
            int r12 = r0.flags     // Catch:{ IllegalStateException -> 0x02c9 }
            r16 = 1
            long r4 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x02c9 }
            boolean r0 = r15.zzR     // Catch:{ IllegalStateException -> 0x02c9 }
            boolean r2 = r15.zzS     // Catch:{ IllegalStateException -> 0x02c9 }
            com.google.android.gms.internal.ads.zzam r3 = r15.zzo     // Catch:{ IllegalStateException -> 0x02c9 }
            r1 = r23
            r17 = r2
            r18 = r3
            r2 = r24
            r19 = r4
            r4 = r26
            r21 = r9
            r9 = r12
            r10 = r16
            r16 = 2
            r11 = r19
            r19 = 0
            r13 = r0
            r14 = r17
            r15 = r18
            boolean r0 = r1.zzaj(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x02cd }
            goto L_0x030c
        L_0x02c9:
            r21 = r9
            r19 = 0
        L_0x02cd:
            r23.zzaD()     // Catch:{ IllegalStateException -> 0x02dd }
            r15 = r23
            boolean r0 = r15.zzag     // Catch:{ IllegalStateException -> 0x034e }
            if (r0 == 0) goto L_0x02d9
            r23.zzat()     // Catch:{ IllegalStateException -> 0x034e }
        L_0x02d9:
            r1 = r15
        L_0x02da:
            r2 = r21
            goto L_0x0339
        L_0x02dd:
            r0 = move-exception
            r2 = 1
        L_0x02df:
            r1 = r23
            goto L_0x0378
        L_0x02e3:
            r0 = move-exception
            r19 = 0
            goto L_0x034f
        L_0x02e8:
            r21 = r9
            r16 = 2
            r19 = 0
            com.google.android.gms.internal.ads.zzrp r6 = r15.zzu     // Catch:{ IllegalStateException -> 0x034e }
            java.nio.ByteBuffer r7 = r15.zzQ     // Catch:{ IllegalStateException -> 0x034e }
            int r8 = r15.zzP     // Catch:{ IllegalStateException -> 0x034e }
            android.media.MediaCodec$BufferInfo r0 = r15.zzk     // Catch:{ IllegalStateException -> 0x034e }
            int r9 = r0.flags     // Catch:{ IllegalStateException -> 0x034e }
            r10 = 1
            long r11 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x034e }
            boolean r13 = r15.zzR     // Catch:{ IllegalStateException -> 0x034e }
            boolean r14 = r15.zzS     // Catch:{ IllegalStateException -> 0x034e }
            com.google.android.gms.internal.ads.zzam r0 = r15.zzo     // Catch:{ IllegalStateException -> 0x034e }
            r1 = r23
            r2 = r24
            r4 = r26
            r15 = r0
            boolean r0 = r1.zzaj(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x034a }
        L_0x030c:
            if (r0 == 0) goto L_0x0336
            r1 = r23
            android.media.MediaCodec$BufferInfo r0 = r1.zzk     // Catch:{ IllegalStateException -> 0x0370 }
            long r2 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0370 }
            r1.zzaf(r2)     // Catch:{ IllegalStateException -> 0x0370 }
            android.media.MediaCodec$BufferInfo r0 = r1.zzk     // Catch:{ IllegalStateException -> 0x0370 }
            int r0 = r0.flags     // Catch:{ IllegalStateException -> 0x0370 }
            r0 = r0 & 4
            r23.zzaF()     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 == 0) goto L_0x0326
            r23.zzaD()     // Catch:{ IllegalStateException -> 0x0370 }
            goto L_0x02da
        L_0x0326:
            r2 = r21
        L_0x0328:
            boolean r0 = r1.zzaM(r2)     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 != 0) goto L_0x032f
            goto L_0x0339
        L_0x032f:
            r15 = r1
            r9 = r2
            r11 = 2
            r13 = 0
            r14 = 1
            goto L_0x0150
        L_0x0336:
            r1 = r23
            goto L_0x02da
        L_0x0339:
            boolean r0 = r23.zzaJ()     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 == 0) goto L_0x0345
            boolean r0 = r1.zzaM(r2)     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 != 0) goto L_0x0339
        L_0x0345:
            android.os.Trace.endSection()     // Catch:{ IllegalStateException -> 0x0370 }
            r2 = 1
            goto L_0x0368
        L_0x034a:
            r0 = move-exception
            r1 = r23
            goto L_0x0371
        L_0x034e:
            r0 = move-exception
        L_0x034f:
            r1 = r15
            goto L_0x0371
        L_0x0351:
            r0 = move-exception
            r1 = r15
            r19 = 0
            goto L_0x0371
        L_0x0356:
            r1 = r15
            r19 = 0
            com.google.android.gms.internal.ads.zzhz r0 = r1.zza     // Catch:{ IllegalStateException -> 0x0370 }
            int r2 = r0.zzd     // Catch:{ IllegalStateException -> 0x0370 }
            int r3 = r23.zzd(r24)     // Catch:{ IllegalStateException -> 0x0370 }
            int r2 = r2 + r3
            r0.zzd = r2     // Catch:{ IllegalStateException -> 0x0370 }
            r2 = 1
            r1.zzaL(r2)     // Catch:{ IllegalStateException -> 0x036e }
        L_0x0368:
            com.google.android.gms.internal.ads.zzhz r0 = r1.zza     // Catch:{ IllegalStateException -> 0x036e }
            r0.zza()     // Catch:{ IllegalStateException -> 0x036e }
            return
        L_0x036e:
            r0 = move-exception
            goto L_0x0378
        L_0x0370:
            r0 = move-exception
        L_0x0371:
            r2 = 1
            goto L_0x0378
        L_0x0373:
            r0 = move-exception
            r1 = r15
            r2 = 1
            r19 = 0
        L_0x0378:
            int r3 = com.google.android.gms.internal.ads.zzfj.zza
            r4 = 21
            if (r3 < r4) goto L_0x0383
            boolean r5 = r0 instanceof android.media.MediaCodec.CodecException
            if (r5 == 0) goto L_0x0383
            goto L_0x0398
        L_0x0383:
            java.lang.StackTraceElement[] r5 = r0.getStackTrace()
            int r6 = r5.length
            if (r6 <= 0) goto L_0x03c1
            r5 = r5[r19]
            java.lang.String r5 = r5.getClassName()
            java.lang.String r6 = "android.media.MediaCodec"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x03c1
        L_0x0398:
            r1.zzaa(r0)
            if (r3 < r4) goto L_0x03ac
            boolean r3 = r0 instanceof android.media.MediaCodec.CodecException
            if (r3 == 0) goto L_0x03ac
            r3 = r0
            android.media.MediaCodec$CodecException r3 = (android.media.MediaCodec.CodecException) r3
            boolean r3 = r3.isRecoverable()
            if (r3 == 0) goto L_0x03ac
            r14 = 1
            goto L_0x03ad
        L_0x03ac:
            r14 = 0
        L_0x03ad:
            if (r14 == 0) goto L_0x03b2
            r23.zzat()
        L_0x03b2:
            com.google.android.gms.internal.ads.zzrs r2 = r1.zzB
            com.google.android.gms.internal.ads.zzrq r0 = r1.zzao(r0, r2)
            com.google.android.gms.internal.ads.zzam r2 = r1.zzn
            r3 = 4003(0xfa3, float:5.61E-42)
            com.google.android.gms.internal.ads.zzih r0 = r1.zzbe(r0, r2, r14, r3)
            throw r0
        L_0x03c1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrw.zzO(long, long):void");
    }

    public boolean zzP() {
        return this.zzag;
    }

    public boolean zzQ() {
        if (this.zzn == null) {
            return false;
        }
        if (zzL() || zzaK()) {
            return true;
        }
        if (this.zzN == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.zzN) {
            return false;
        }
        return true;
    }

    public final int zzR(zzam zzam2) throws zzih {
        try {
            return zzT(this.zzd, zzam2);
        } catch (zzsf e2) {
            throw zzbe(e2, zzam2, false, 4002);
        }
    }

    /* access modifiers changed from: protected */
    public float zzS(float f2, zzam zzam2, zzam[] zzamArr) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public abstract int zzT(zzry zzry, zzam zzam2) throws zzsf;

    /* access modifiers changed from: protected */
    public zzia zzU(zzrs zzrs, zzam zzam2, zzam zzam3) {
        throw null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0060, code lost:
        if (zzaI() == false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008c, code lost:
        if (zzaI() == false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a0, code lost:
        if (zzaI() == false) goto L_0x00bc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d5 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzia zzV(com.google.android.gms.internal.ads.zzkj r12) throws com.google.android.gms.internal.ads.zzih {
        /*
            r11 = this;
            r0 = 1
            r11.zzah = r0
            com.google.android.gms.internal.ads.zzam r4 = r12.zza
            r4.getClass()
            java.lang.String r1 = r4.zzm
            r2 = 0
            if (r1 == 0) goto L_0x00e7
            com.google.android.gms.internal.ads.zzqv r12 = r12.zzb
            r11.zzam = r12
            r11.zzn = r4
            boolean r1 = r11.zzT
            r3 = 0
            if (r1 == 0) goto L_0x001b
            r11.zzV = r0
            return r3
        L_0x001b:
            com.google.android.gms.internal.ads.zzrp r1 = r11.zzu
            if (r1 != 0) goto L_0x0025
            r11.zzz = r3
            r11.zzar()
            return r3
        L_0x0025:
            com.google.android.gms.internal.ads.zzrs r3 = r11.zzB
            com.google.android.gms.internal.ads.zzam r5 = r11.zzv
            com.google.android.gms.internal.ads.zzqv r6 = r11.zzal
            if (r6 != r12) goto L_0x00d6
            if (r12 == r6) goto L_0x0031
            r12 = 1
            goto L_0x0032
        L_0x0031:
            r12 = 0
        L_0x0032:
            if (r12 == 0) goto L_0x003d
            int r6 = com.google.android.gms.internal.ads.zzfj.zza
            r7 = 23
            if (r6 < r7) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r6 = 0
            goto L_0x003e
        L_0x003d:
            r6 = 1
        L_0x003e:
            com.google.android.gms.internal.ads.zzdy.zzf(r6)
            com.google.android.gms.internal.ads.zzia r6 = r11.zzU(r3, r5, r4)
            int r7 = r6.zzd
            r8 = 3
            if (r7 == 0) goto L_0x00b8
            r9 = 16
            r10 = 2
            if (r7 == r0) goto L_0x008f
            if (r7 == r10) goto L_0x0063
            boolean r0 = r11.zzaN(r4)
            if (r0 != 0) goto L_0x0058
            goto L_0x0095
        L_0x0058:
            r11.zzv = r4
            if (r12 == 0) goto L_0x00bb
            boolean r12 = r11.zzaI()
            if (r12 != 0) goto L_0x00bb
            goto L_0x00bc
        L_0x0063:
            boolean r7 = r11.zzaN(r4)
            if (r7 != 0) goto L_0x006a
            goto L_0x0095
        L_0x006a:
            r11.zzW = r0
            r11.zzX = r0
            int r7 = r11.zzC
            if (r7 == r10) goto L_0x0082
            if (r7 != r0) goto L_0x0081
            int r7 = r4.zzr
            int r9 = r5.zzr
            if (r7 != r9) goto L_0x0081
            int r7 = r4.zzs
            int r9 = r5.zzs
            if (r7 != r9) goto L_0x0081
            goto L_0x0082
        L_0x0081:
            r0 = 0
        L_0x0082:
            r11.zzJ = r0
            r11.zzv = r4
            if (r12 == 0) goto L_0x00bb
            boolean r12 = r11.zzaI()
            if (r12 != 0) goto L_0x00bb
            goto L_0x00bc
        L_0x008f:
            boolean r7 = r11.zzaN(r4)
            if (r7 != 0) goto L_0x0098
        L_0x0095:
            r10 = 16
            goto L_0x00bc
        L_0x0098:
            r11.zzv = r4
            if (r12 == 0) goto L_0x00a3
            boolean r12 = r11.zzaI()
            if (r12 != 0) goto L_0x00bb
            goto L_0x00bc
        L_0x00a3:
            boolean r12 = r11.zzaa
            if (r12 == 0) goto L_0x00bb
            r11.zzY = r0
            boolean r12 = r11.zzE
            if (r12 != 0) goto L_0x00b5
            boolean r12 = r11.zzG
            if (r12 == 0) goto L_0x00b2
            goto L_0x00b5
        L_0x00b2:
            r11.zzZ = r0
            goto L_0x00bb
        L_0x00b5:
            r11.zzZ = r8
            goto L_0x00bc
        L_0x00b8:
            r11.zzX()
        L_0x00bb:
            r10 = 0
        L_0x00bc:
            int r12 = r6.zzd
            if (r12 == 0) goto L_0x00d5
            com.google.android.gms.internal.ads.zzrp r12 = r11.zzu
            if (r12 != r1) goto L_0x00c8
            int r12 = r11.zzZ
            if (r12 != r8) goto L_0x00d5
        L_0x00c8:
            com.google.android.gms.internal.ads.zzia r12 = new com.google.android.gms.internal.ads.zzia
            java.lang.String r2 = r3.zza
            r0 = 0
            r1 = r12
            r3 = r5
            r5 = r0
            r6 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return r12
        L_0x00d5:
            return r6
        L_0x00d6:
            r11.zzX()
            com.google.android.gms.internal.ads.zzia r12 = new com.google.android.gms.internal.ads.zzia
            java.lang.String r2 = r3.zza
            r0 = 0
            r6 = 128(0x80, float:1.794E-43)
            r1 = r12
            r3 = r5
            r5 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            return r12
        L_0x00e7:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            r12.<init>()
            r0 = 4005(0xfa5, float:5.612E-42)
            com.google.android.gms.internal.ads.zzih r12 = r11.zzbe(r12, r4, r2, r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrw.zzV(com.google.android.gms.internal.ads.zzkj):com.google.android.gms.internal.ads.zzia");
    }

    /* access modifiers changed from: protected */
    public abstract zzrn zzY(zzrs zzrs, zzam zzam2, MediaCrypto mediaCrypto, float f2);

    /* access modifiers changed from: protected */
    public abstract List zzZ(zzry zzry, zzam zzam2, boolean z2) throws zzsf;

    /* access modifiers changed from: protected */
    public boolean zzaA(zzrs zzrs) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void zzaa(Exception exc) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzab(String str, zzrn zzrn, long j2, long j3) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzac(String str) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzad(zzam zzam2, MediaFormat mediaFormat) throws zzih {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzaf(long j2) {
        this.zzaj = j2;
        while (!this.zzl.isEmpty() && j2 >= ((zzrv) this.zzl.peek()).zzb) {
            zzaG((zzrv) this.zzl.poll());
            zzag();
        }
    }

    /* access modifiers changed from: protected */
    public void zzag() {
    }

    /* access modifiers changed from: protected */
    public void zzah(zzhp zzhp) throws zzih {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzai() throws zzih {
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzaj(long j2, long j3, zzrp zzrp, ByteBuffer byteBuffer, int i2, int i3, int i4, long j4, boolean z2, boolean z3, zzam zzam2) throws zzih;

    /* access modifiers changed from: protected */
    public boolean zzak(zzam zzam2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public final float zzal() {
        return this.zzs;
    }

    /* access modifiers changed from: protected */
    public final long zzam() {
        return this.zzai.zzc;
    }

    /* access modifiers changed from: protected */
    public final zzrp zzan() {
        return this.zzu;
    }

    /* access modifiers changed from: protected */
    public zzrq zzao(Throwable th, zzrs zzrs) {
        return new zzrq(th, zzrs);
    }

    /* access modifiers changed from: protected */
    public final zzrs zzap() {
        return this.zzB;
    }

    /* access modifiers changed from: protected */
    public void zzaq(zzhp zzhp) throws zzih {
    }

    /* access modifiers changed from: protected */
    public final void zzar() throws zzih {
        zzam zzam2;
        if (this.zzu == null && !this.zzT && (zzam2 = this.zzn) != null) {
            if (zzaz(zzam2)) {
                zzam zzam3 = this.zzn;
                zzW();
                String str = zzam3.zzm;
                if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
                    this.zzi.zzo(32);
                } else {
                    this.zzi.zzo(1);
                }
                this.zzT = true;
                return;
            }
            zzqv zzqv = this.zzam;
            this.zzal = zzqv;
            zzam zzam4 = this.zzn;
            String str2 = zzam4.zzm;
            if (zzqv != null) {
                boolean z2 = zzqw.zza;
            }
            try {
                if (this.zzz == null) {
                    List zzZ2 = zzZ(this.zzd, zzam4, false);
                    zzZ2.isEmpty();
                    this.zzz = new ArrayDeque();
                    if (!zzZ2.isEmpty()) {
                        this.zzz.add((zzrs) zzZ2.get(0));
                    }
                    this.zzA = null;
                }
                if (!this.zzz.isEmpty()) {
                    zzrs zzrs = (zzrs) this.zzz.peekFirst();
                    while (this.zzu == null) {
                        zzrs zzrs2 = (zzrs) this.zzz.peekFirst();
                        if (zzaA(zzrs2)) {
                            try {
                                zzaC(zzrs2, (MediaCrypto) null);
                            } catch (Exception e2) {
                                if (zzrs2 == zzrs) {
                                    zzer.zzf("MediaCodecRenderer", "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                                    Thread.sleep(50);
                                    zzaC(zzrs2, (MediaCrypto) null);
                                } else {
                                    throw e2;
                                }
                            } catch (Exception e3) {
                                zzer.zzg("MediaCodecRenderer", "Failed to initialize decoder: ".concat(String.valueOf(zzrs2)), e3);
                                this.zzz.removeFirst();
                                zzru zzru = new zzru(this.zzn, (Throwable) e3, false, zzrs2);
                                zzaa(zzru);
                                zzru zzru2 = this.zzA;
                                if (zzru2 == null) {
                                    this.zzA = zzru;
                                } else {
                                    this.zzA = zzru.zza(zzru2, zzru);
                                }
                                if (this.zzz.isEmpty()) {
                                    throw this.zzA;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    this.zzz = null;
                    return;
                }
                throw new zzru(this.zzn, (Throwable) null, false, -49999);
            } catch (zzsf e4) {
                throw new zzru(this.zzn, (Throwable) e4, false, -49998);
            } catch (zzru e5) {
                throw zzbe(e5, this.zzn, false, 4001);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzas(zzam zzam2) throws zzih {
    }

    /* access modifiers changed from: protected */
    public final void zzat() {
        try {
            zzrp zzrp = this.zzu;
            if (zzrp != null) {
                zzrp.zzl();
                this.zza.zzb++;
                zzac(this.zzB.zza);
            }
        } finally {
            this.zzu = null;
            this.zzp = null;
            this.zzal = null;
            zzav();
        }
    }

    /* access modifiers changed from: protected */
    public void zzau() {
        zzaE();
        zzaF();
        this.zzN = -9223372036854775807L;
        this.zzab = false;
        this.zzaa = false;
        this.zzJ = false;
        this.zzK = false;
        this.zzR = false;
        this.zzS = false;
        this.zzj.clear();
        this.zzad = -9223372036854775807L;
        this.zzae = -9223372036854775807L;
        this.zzaj = -9223372036854775807L;
        zzrk zzrk = this.zzM;
        if (zzrk != null) {
            zzrk.zzc();
        }
        this.zzY = 0;
        this.zzZ = 0;
        this.zzX = this.zzW ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public final void zzav() {
        zzau();
        this.zzM = null;
        this.zzz = null;
        this.zzB = null;
        this.zzv = null;
        this.zzw = null;
        this.zzx = false;
        this.zzac = false;
        this.zzy = -1.0f;
        this.zzC = 0;
        this.zzD = false;
        this.zzE = false;
        this.zzF = false;
        this.zzG = false;
        this.zzH = false;
        this.zzI = false;
        this.zzL = false;
        this.zzW = false;
        this.zzX = 0;
        this.zzq = false;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaw() throws zzih {
        boolean zzax = zzax();
        if (zzax) {
            zzar();
        }
        return zzax;
    }

    /* access modifiers changed from: protected */
    public final boolean zzax() {
        boolean z2;
        if (this.zzu == null) {
            return false;
        }
        int i2 = this.zzZ;
        if (i2 == 3 || this.zzE || ((this.zzF && !this.zzac) || (this.zzG && this.zzab))) {
            zzat();
            return true;
        }
        if (i2 == 2) {
            int i3 = zzfj.zza;
            if (i3 >= 23) {
                z2 = true;
            } else {
                z2 = false;
            }
            zzdy.zzf(z2);
            if (i3 >= 23) {
                try {
                    zzaH();
                } catch (zzih e2) {
                    zzer.zzg("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e2);
                    zzat();
                    return true;
                }
            }
        }
        zzae();
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean zzay() {
        return this.zzT;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaz(zzam zzam2) {
        return this.zzam == null && zzak(zzam2);
    }

    public final int zze() {
        return 8;
    }

    /* access modifiers changed from: protected */
    public void zzt() {
        this.zzn = null;
        zzaG(zzrv.zza);
        this.zzl.clear();
        zzax();
    }

    /* access modifiers changed from: protected */
    public void zzu(boolean z2, boolean z3) throws zzih {
        this.zza = new zzhz();
    }

    /* access modifiers changed from: protected */
    public void zzv(long j2, boolean z2) throws zzih {
        this.zzaf = false;
        this.zzag = false;
        if (this.zzT) {
            this.zzi.zzb();
            this.zzh.zzb();
            this.zzU = false;
        } else {
            zzaw();
        }
        zzfg zzfg = this.zzai.zzd;
        if (zzfg.zza() > 0) {
            this.zzah = true;
        }
        zzfg.zze();
        this.zzl.clear();
    }

    /* access modifiers changed from: protected */
    public void zzw() {
        try {
            zzW();
            zzat();
        } finally {
            this.zzam = null;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (r5 >= r1) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzz(com.google.android.gms.internal.ads.zzam[] r16, long r17, long r19) throws com.google.android.gms.internal.ads.zzih {
        /*
            r15 = this;
            r0 = r15
            com.google.android.gms.internal.ads.zzrv r1 = r0.zzai
            long r1 = r1.zzc
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0021
            com.google.android.gms.internal.ads.zzrv r1 = new com.google.android.gms.internal.ads.zzrv
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = r1
            r9 = r17
            r11 = r19
            r6.<init>(r7, r9, r11)
            r15.zzaG(r1)
            return
        L_0x0021:
            java.util.ArrayDeque r1 = r0.zzl
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0057
            long r1 = r0.zzad
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0039
            long r5 = r0.zzaj
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x0057
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 < 0) goto L_0x0057
        L_0x0039:
            com.google.android.gms.internal.ads.zzrv r1 = new com.google.android.gms.internal.ads.zzrv
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = r1
            r11 = r17
            r13 = r19
            r8.<init>(r9, r11, r13)
            r15.zzaG(r1)
            com.google.android.gms.internal.ads.zzrv r1 = r0.zzai
            long r1 = r1.zzc
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0056
            r15.zzag()
        L_0x0056:
            return
        L_0x0057:
            java.util.ArrayDeque r1 = r0.zzl
            com.google.android.gms.internal.ads.zzrv r9 = new com.google.android.gms.internal.ads.zzrv
            long r3 = r0.zzad
            r2 = r9
            r5 = r17
            r7 = r19
            r2.<init>(r3, r5, r7)
            r1.add(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrw.zzz(com.google.android.gms.internal.ads.zzam[], long, long):void");
    }
}
