package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.view.Surface;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.nio.ByteBuffer;
import java.util.List;
import org.joda.time.DateTimeConstants;

public final class zzyu extends zzrw {
    private static final int[] zzb = {1920, 1600, DateTimeConstants.MINUTES_PER_DAY, 1280, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private long zzA;
    private long zzB;
    private int zzC;
    private long zzD;
    private zzdn zzE = zzdn.zza;
    private zzdn zzF = null;
    private int zzG = 0;
    private zzyy zzH;
    /* access modifiers changed from: private */
    public final Context zze;
    private final zzzf zzf;
    private final zzzq zzg;
    private final zzyt zzh;
    private final boolean zzi = "NVIDIA".equals(zzfj.zzc);
    private zzym zzj;
    private boolean zzk;
    private boolean zzl;
    private Surface zzm;
    private zzyx zzn;
    private boolean zzo;
    private int zzp = 1;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private long zzt;
    private long zzu = -9223372036854775807L;
    private long zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private long zzz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzyu(Context context, zzro zzro, zzry zzry, long j2, boolean z2, Handler handler, zzzr zzzr, int i2, float f2) {
        super(2, zzro, zzry, false, 30.0f);
        zzyp zzyp = new zzyp((zzyo) null);
        Context applicationContext = context.getApplicationContext();
        this.zze = applicationContext;
        zzzf zzzf = new zzzf(applicationContext);
        this.zzf = zzzf;
        this.zzg = new zzzq(handler, zzzr);
        this.zzh = new zzyt(zzyp, zzzf, this);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0072, code lost:
        if (r3.equals("video/av01") != false) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
        r11 = ((java.lang.Integer) r11.first).intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzW(com.google.android.gms.internal.ads.zzrs r10, com.google.android.gms.internal.ads.zzam r11) {
        /*
            int r0 = r11.zzr
            int r1 = r11.zzs
            r2 = -1
            if (r0 == r2) goto L_0x00d5
            if (r1 != r2) goto L_0x000b
            goto L_0x00d5
        L_0x000b:
            java.lang.String r3 = r11.zzm
            java.lang.String r4 = "video/dolby-vision"
            boolean r4 = r4.equals(r3)
            r5 = 2
            r6 = 1
            java.lang.String r7 = "video/avc"
            java.lang.String r8 = "video/hevc"
            if (r4 == 0) goto L_0x0034
            android.util.Pair r11 = com.google.android.gms.internal.ads.zzsl.zzb(r11)
            if (r11 == 0) goto L_0x0033
            java.lang.Object r11 = r11.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r3 = 512(0x200, float:7.175E-43)
            if (r11 == r3) goto L_0x0031
            if (r11 == r6) goto L_0x0031
            if (r11 != r5) goto L_0x0033
        L_0x0031:
            r3 = r7
            goto L_0x0034
        L_0x0033:
            r3 = r8
        L_0x0034:
            int r11 = r3.hashCode()
            r4 = 3
            r9 = 4
            switch(r11) {
                case -1664118616: goto L_0x0075;
                case -1662735862: goto L_0x006c;
                case -1662541442: goto L_0x0064;
                case 1187890754: goto L_0x005a;
                case 1331836730: goto L_0x0052;
                case 1599127256: goto L_0x0048;
                case 1599127257: goto L_0x003e;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x007f
        L_0x003e:
            java.lang.String r11 = "video/x-vnd.on2.vp9"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x007f
            r5 = 6
            goto L_0x0080
        L_0x0048:
            java.lang.String r11 = "video/x-vnd.on2.vp8"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x007f
            r5 = 3
            goto L_0x0080
        L_0x0052:
            boolean r11 = r3.equals(r7)
            if (r11 == 0) goto L_0x007f
            r5 = 5
            goto L_0x0080
        L_0x005a:
            java.lang.String r11 = "video/mp4v-es"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x007f
            r5 = 1
            goto L_0x0080
        L_0x0064:
            boolean r11 = r3.equals(r8)
            if (r11 == 0) goto L_0x007f
            r5 = 4
            goto L_0x0080
        L_0x006c:
            java.lang.String r11 = "video/av01"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x007f
            goto L_0x0080
        L_0x0075:
            java.lang.String r11 = "video/3gpp"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x007f
            r5 = 0
            goto L_0x0080
        L_0x007f:
            r5 = -1
        L_0x0080:
            switch(r5) {
                case 0: goto L_0x00cf;
                case 1: goto L_0x00cf;
                case 2: goto L_0x00cf;
                case 3: goto L_0x00cf;
                case 4: goto L_0x00c3;
                case 5: goto L_0x008b;
                case 6: goto L_0x0084;
                default: goto L_0x0083;
            }
        L_0x0083:
            return r2
        L_0x0084:
            int r0 = r0 * r1
            int r0 = r0 * 3
            int r0 = r0 / 8
            return r0
        L_0x008b:
            java.lang.String r11 = com.google.android.gms.internal.ads.zzfj.zzd
            java.lang.String r3 = "BRAVIA 4K 2015"
            boolean r3 = r3.equals(r11)
            if (r3 != 0) goto L_0x00c2
            java.lang.String r3 = "Amazon"
            java.lang.String r4 = com.google.android.gms.internal.ads.zzfj.zzc
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00b4
            java.lang.String r3 = "KFSOWI"
            boolean r3 = r3.equals(r11)
            if (r3 != 0) goto L_0x00c2
            java.lang.String r3 = "AFTS"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x00b4
            boolean r10 = r10.zzf
            if (r10 == 0) goto L_0x00b4
            goto L_0x00c2
        L_0x00b4:
            int r0 = r0 + 15
            int r1 = r1 + 15
            int r0 = r0 / 16
            int r1 = r1 / 16
            int r0 = r0 * r1
            int r0 = r0 * 768
            int r0 = r0 / r9
            return r0
        L_0x00c2:
            return r2
        L_0x00c3:
            int r0 = r0 * r1
            int r0 = r0 * 3
            int r0 = r0 / r9
            r10 = 2097152(0x200000, float:2.938736E-39)
            int r10 = java.lang.Math.max(r10, r0)
            return r10
        L_0x00cf:
            int r0 = r0 * r1
            int r0 = r0 * 3
            int r0 = r0 / r9
            return r0
        L_0x00d5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyu.zzW(com.google.android.gms.internal.ads.zzrs, com.google.android.gms.internal.ads.zzam):int");
    }

    protected static int zzX(zzrs zzrs, zzam zzam) {
        if (zzam.zzn == -1) {
            return zzW(zzrs, zzam);
        }
        int size = zzam.zzo.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += ((byte[]) zzam.zzo.get(i3)).length;
        }
        return zzam.zzn + i2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x04c0, code lost:
        if (r0.equals("deb") != false) goto L_0x078a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:511:0x07a0, code lost:
        if (r10 != 0) goto L_0x07a2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static final boolean zzaK(java.lang.String r17) {
        /*
            java.lang.String r0 = "OMX.google"
            r1 = r17
            boolean r0 = r1.startsWith(r0)
            r1 = 0
            if (r0 == 0) goto L_0x000c
            return r1
        L_0x000c:
            java.lang.Class<com.google.android.gms.internal.ads.zzyu> r2 = com.google.android.gms.internal.ads.zzyu.class
            monitor-enter(r2)
            boolean r0 = zzc     // Catch:{ all -> 0x07aa }
            if (r0 != 0) goto L_0x07a6
            int r0 = com.google.android.gms.internal.ads.zzfj.zza     // Catch:{ all -> 0x07aa }
            r3 = 28
            r4 = 5
            r5 = 6
            r6 = 4
            r7 = 7
            r8 = 2
            r9 = 3
            r10 = -1
            r11 = 1
            if (r0 > r3) goto L_0x0083
            java.lang.String r12 = com.google.android.gms.internal.ads.zzfj.zzb     // Catch:{ all -> 0x07aa }
            int r13 = r12.hashCode()     // Catch:{ all -> 0x07aa }
            switch(r13) {
                case -1339091551: goto L_0x0071;
                case -1220081023: goto L_0x0067;
                case -1220066608: goto L_0x005d;
                case -1012436106: goto L_0x0053;
                case -760312546: goto L_0x0049;
                case -64886864: goto L_0x003f;
                case 3415681: goto L_0x0035;
                case 825323514: goto L_0x002b;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x007b
        L_0x002b:
            java.lang.String r13 = "machuca"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x007b
            r12 = 5
            goto L_0x007c
        L_0x0035:
            java.lang.String r13 = "once"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x007b
            r12 = 6
            goto L_0x007c
        L_0x003f:
            java.lang.String r13 = "magnolia"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x007b
            r12 = 4
            goto L_0x007c
        L_0x0049:
            java.lang.String r13 = "aquaman"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x007b
            r12 = 0
            goto L_0x007c
        L_0x0053:
            java.lang.String r13 = "oneday"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x007b
            r12 = 7
            goto L_0x007c
        L_0x005d:
            java.lang.String r13 = "dangalUHD"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x007b
            r12 = 2
            goto L_0x007c
        L_0x0067:
            java.lang.String r13 = "dangalFHD"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x007b
            r12 = 3
            goto L_0x007c
        L_0x0071:
            java.lang.String r13 = "dangal"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x007b
            r12 = 1
            goto L_0x007c
        L_0x007b:
            r12 = -1
        L_0x007c:
            switch(r12) {
                case 0: goto L_0x0080;
                case 1: goto L_0x0080;
                case 2: goto L_0x0080;
                case 3: goto L_0x0080;
                case 4: goto L_0x0080;
                case 5: goto L_0x0080;
                case 6: goto L_0x0080;
                case 7: goto L_0x0080;
                default: goto L_0x007f;
            }
        L_0x007f:
            goto L_0x0083
        L_0x0080:
            r1 = 1
            goto L_0x07a2
        L_0x0083:
            r12 = 27
            if (r0 > r12) goto L_0x0092
            java.lang.String r13 = "HWEML"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzfj.zzb     // Catch:{ all -> 0x07aa }
            boolean r13 = r13.equals(r14)     // Catch:{ all -> 0x07aa }
            if (r13 == 0) goto L_0x0092
            goto L_0x0080
        L_0x0092:
            java.lang.String r13 = com.google.android.gms.internal.ads.zzfj.zzd     // Catch:{ all -> 0x07aa }
            int r14 = r13.hashCode()     // Catch:{ all -> 0x07aa }
            r15 = 8
            switch(r14) {
                case -349662828: goto L_0x00ef;
                case -321033677: goto L_0x00e5;
                case 2006354: goto L_0x00db;
                case 2006367: goto L_0x00d1;
                case 2006371: goto L_0x00c7;
                case 1785421873: goto L_0x00bd;
                case 1785421876: goto L_0x00b3;
                case 1798172390: goto L_0x00a8;
                case 2119412532: goto L_0x009e;
                default: goto L_0x009d;
            }
        L_0x009d:
            goto L_0x00f9
        L_0x009e:
            java.lang.String r14 = "AFTEUFF014"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00f9
            r14 = 5
            goto L_0x00fa
        L_0x00a8:
            java.lang.String r14 = "AFTSO001"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00f9
            r14 = 8
            goto L_0x00fa
        L_0x00b3:
            java.lang.String r14 = "AFTEU014"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00f9
            r14 = 4
            goto L_0x00fa
        L_0x00bd:
            java.lang.String r14 = "AFTEU011"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00f9
            r14 = 3
            goto L_0x00fa
        L_0x00c7:
            java.lang.String r14 = "AFTR"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00f9
            r14 = 2
            goto L_0x00fa
        L_0x00d1:
            java.lang.String r14 = "AFTN"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00f9
            r14 = 1
            goto L_0x00fa
        L_0x00db:
            java.lang.String r14 = "AFTA"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00f9
            r14 = 0
            goto L_0x00fa
        L_0x00e5:
            java.lang.String r14 = "AFTKMST12"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00f9
            r14 = 7
            goto L_0x00fa
        L_0x00ef:
            java.lang.String r14 = "AFTJMST12"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00f9
            r14 = 6
            goto L_0x00fa
        L_0x00f9:
            r14 = -1
        L_0x00fa:
            switch(r14) {
                case 0: goto L_0x0080;
                case 1: goto L_0x0080;
                case 2: goto L_0x0080;
                case 3: goto L_0x0080;
                case 4: goto L_0x0080;
                case 5: goto L_0x0080;
                case 6: goto L_0x0080;
                case 7: goto L_0x0080;
                case 8: goto L_0x0080;
                default: goto L_0x00fd;
            }
        L_0x00fd:
            r14 = 26
            if (r0 > r14) goto L_0x07a2
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfj.zzb     // Catch:{ all -> 0x07aa }
            int r16 = r0.hashCode()     // Catch:{ all -> 0x07aa }
            switch(r16) {
                case -2144781245: goto L_0x077e;
                case -2144781185: goto L_0x0773;
                case -2144781160: goto L_0x0768;
                case -2097309513: goto L_0x075d;
                case -2022874474: goto L_0x0752;
                case -1978993182: goto L_0x0747;
                case -1978990237: goto L_0x073c;
                case -1936688988: goto L_0x0731;
                case -1936688066: goto L_0x0726;
                case -1936688065: goto L_0x071a;
                case -1931988508: goto L_0x070e;
                case -1885099851: goto L_0x0702;
                case -1696512866: goto L_0x06f6;
                case -1680025915: goto L_0x06ea;
                case -1615810839: goto L_0x06de;
                case -1600724499: goto L_0x06d2;
                case -1554255044: goto L_0x06c6;
                case -1481772737: goto L_0x06ba;
                case -1481772730: goto L_0x06ae;
                case -1481772729: goto L_0x06a2;
                case -1320080169: goto L_0x0696;
                case -1217592143: goto L_0x068a;
                case -1180384755: goto L_0x067e;
                case -1139198265: goto L_0x0672;
                case -1052835013: goto L_0x0666;
                case -993250464: goto L_0x065b;
                case -993250458: goto L_0x0650;
                case -965403638: goto L_0x0644;
                case -958336948: goto L_0x0638;
                case -879245230: goto L_0x062c;
                case -842500323: goto L_0x0620;
                case -821392978: goto L_0x0614;
                case -797483286: goto L_0x0608;
                case -794946968: goto L_0x05fc;
                case -788334647: goto L_0x05f0;
                case -782144577: goto L_0x05e4;
                case -575125681: goto L_0x05d8;
                case -521118391: goto L_0x05cc;
                case -430914369: goto L_0x05c0;
                case -290434366: goto L_0x05b4;
                case -282781963: goto L_0x05a8;
                case -277133239: goto L_0x059c;
                case -173639913: goto L_0x0590;
                case -56598463: goto L_0x0584;
                case 2126: goto L_0x0578;
                case 2564: goto L_0x056c;
                case 2715: goto L_0x0560;
                case 2719: goto L_0x0554;
                case 3091: goto L_0x0548;
                case 3483: goto L_0x053c;
                case 73405: goto L_0x0530;
                case 75537: goto L_0x0524;
                case 75739: goto L_0x0518;
                case 76779: goto L_0x050c;
                case 78669: goto L_0x0500;
                case 79305: goto L_0x04f4;
                case 80618: goto L_0x04e8;
                case 88274: goto L_0x04dc;
                case 98846: goto L_0x04d0;
                case 98848: goto L_0x04c4;
                case 99329: goto L_0x04ba;
                case 101481: goto L_0x04ae;
                case 1513190: goto L_0x04a3;
                case 1514184: goto L_0x0498;
                case 1514185: goto L_0x048d;
                case 2133089: goto L_0x0481;
                case 2133091: goto L_0x0475;
                case 2133120: goto L_0x0469;
                case 2133151: goto L_0x045d;
                case 2133182: goto L_0x0451;
                case 2133184: goto L_0x0445;
                case 2436959: goto L_0x0439;
                case 2463773: goto L_0x042d;
                case 2464648: goto L_0x0421;
                case 2689555: goto L_0x0415;
                case 3154429: goto L_0x0409;
                case 3284551: goto L_0x03fd;
                case 3351335: goto L_0x03f1;
                case 3386211: goto L_0x03e5;
                case 41325051: goto L_0x03d9;
                case 51349633: goto L_0x03ce;
                case 51350594: goto L_0x03c3;
                case 55178625: goto L_0x03b7;
                case 61542055: goto L_0x03ac;
                case 65355429: goto L_0x03a0;
                case 66214468: goto L_0x0394;
                case 66214470: goto L_0x0388;
                case 66214473: goto L_0x037c;
                case 66215429: goto L_0x0370;
                case 66215431: goto L_0x0364;
                case 66215433: goto L_0x0358;
                case 66216390: goto L_0x034c;
                case 76402249: goto L_0x0340;
                case 76404105: goto L_0x0334;
                case 76404911: goto L_0x0328;
                case 80963634: goto L_0x031c;
                case 82882791: goto L_0x0310;
                case 98715550: goto L_0x0304;
                case 101370885: goto L_0x02f8;
                case 102844228: goto L_0x02ec;
                case 165221241: goto L_0x02e0;
                case 182191441: goto L_0x02d4;
                case 245388979: goto L_0x02c8;
                case 287431619: goto L_0x02bc;
                case 307593612: goto L_0x02b0;
                case 308517133: goto L_0x02a4;
                case 316215098: goto L_0x0298;
                case 316215116: goto L_0x028c;
                case 316246811: goto L_0x0280;
                case 316246818: goto L_0x0274;
                case 407160593: goto L_0x0268;
                case 507412548: goto L_0x025c;
                case 793982701: goto L_0x0250;
                case 794038622: goto L_0x0244;
                case 794040393: goto L_0x0238;
                case 835649806: goto L_0x022c;
                case 917340916: goto L_0x0220;
                case 958008161: goto L_0x0214;
                case 1060579533: goto L_0x0208;
                case 1150207623: goto L_0x01fc;
                case 1176899427: goto L_0x01f0;
                case 1280332038: goto L_0x01e4;
                case 1306947716: goto L_0x01d8;
                case 1349174697: goto L_0x01cc;
                case 1522194893: goto L_0x01c0;
                case 1691543273: goto L_0x01b4;
                case 1691544261: goto L_0x01a8;
                case 1709443163: goto L_0x019c;
                case 1865889110: goto L_0x0190;
                case 1906253259: goto L_0x0184;
                case 1977196784: goto L_0x0178;
                case 2006372676: goto L_0x016c;
                case 2019281702: goto L_0x0160;
                case 2029784656: goto L_0x0154;
                case 2030379515: goto L_0x0148;
                case 2033393791: goto L_0x013c;
                case 2047190025: goto L_0x0130;
                case 2047252157: goto L_0x0124;
                case 2048319463: goto L_0x0118;
                case 2048855701: goto L_0x010c;
                default: goto L_0x010a;
            }
        L_0x010a:
            goto L_0x0789
        L_0x010c:
            java.lang.String r3 = "HWWAS-H"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 66
            goto L_0x078a
        L_0x0118:
            java.lang.String r3 = "HWVNS-H"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 65
            goto L_0x078a
        L_0x0124:
            java.lang.String r3 = "ELUGA_Prim"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 33
            goto L_0x078a
        L_0x0130:
            java.lang.String r3 = "ELUGA_Note"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 32
            goto L_0x078a
        L_0x013c:
            java.lang.String r3 = "ASUS_X00AD_2"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 14
            goto L_0x078a
        L_0x0148:
            java.lang.String r3 = "HWCAM-H"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 64
            goto L_0x078a
        L_0x0154:
            java.lang.String r3 = "HWBLN-H"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 63
            goto L_0x078a
        L_0x0160:
            java.lang.String r3 = "DM-01K"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 29
            goto L_0x078a
        L_0x016c:
            java.lang.String r3 = "BRAVIA_ATV3_4K"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 19
            goto L_0x078a
        L_0x0178:
            java.lang.String r3 = "Infinix-X572"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 69
            goto L_0x078a
        L_0x0184:
            java.lang.String r3 = "PB2-670M"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 100
            goto L_0x078a
        L_0x0190:
            java.lang.String r3 = "santoni"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 117(0x75, float:1.64E-43)
            goto L_0x078a
        L_0x019c:
            java.lang.String r3 = "iball8735_9806"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 68
            goto L_0x078a
        L_0x01a8:
            java.lang.String r3 = "CPH1715"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 24
            goto L_0x078a
        L_0x01b4:
            java.lang.String r3 = "CPH1609"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 23
            goto L_0x078a
        L_0x01c0:
            java.lang.String r3 = "woods_f"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 133(0x85, float:1.86E-43)
            goto L_0x078a
        L_0x01cc:
            java.lang.String r3 = "htc_e56ml_dtul"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 61
            goto L_0x078a
        L_0x01d8:
            java.lang.String r3 = "EverStar_S"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 35
            goto L_0x078a
        L_0x01e4:
            java.lang.String r3 = "hwALE-H"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 62
            goto L_0x078a
        L_0x01f0:
            java.lang.String r3 = "itel_S41"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 71
            goto L_0x078a
        L_0x01fc:
            java.lang.String r3 = "LS-5017"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 78
            goto L_0x078a
        L_0x0208:
            java.lang.String r3 = "panell_d"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 96
            goto L_0x078a
        L_0x0214:
            java.lang.String r3 = "j2xlteins"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 72
            goto L_0x078a
        L_0x0220:
            java.lang.String r3 = "A7000plus"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 10
            goto L_0x078a
        L_0x022c:
            java.lang.String r3 = "manning"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 81
            goto L_0x078a
        L_0x0238:
            java.lang.String r3 = "GIONEE_WBL7519"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 59
            goto L_0x078a
        L_0x0244:
            java.lang.String r3 = "GIONEE_WBL7365"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 58
            goto L_0x078a
        L_0x0250:
            java.lang.String r3 = "GIONEE_WBL5708"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 57
            goto L_0x078a
        L_0x025c:
            java.lang.String r3 = "QM16XE_U"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 114(0x72, float:1.6E-43)
            goto L_0x078a
        L_0x0268:
            java.lang.String r3 = "Pixi5-10_4G"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 106(0x6a, float:1.49E-43)
            goto L_0x078a
        L_0x0274:
            java.lang.String r3 = "TB3-850M"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 125(0x7d, float:1.75E-43)
            goto L_0x078a
        L_0x0280:
            java.lang.String r3 = "TB3-850F"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 124(0x7c, float:1.74E-43)
            goto L_0x078a
        L_0x028c:
            java.lang.String r3 = "TB3-730X"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 123(0x7b, float:1.72E-43)
            goto L_0x078a
        L_0x0298:
            java.lang.String r3 = "TB3-730F"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 122(0x7a, float:1.71E-43)
            goto L_0x078a
        L_0x02a4:
            java.lang.String r3 = "A7020a48"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 12
            goto L_0x078a
        L_0x02b0:
            java.lang.String r3 = "A7010a48"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 11
            goto L_0x078a
        L_0x02bc:
            java.lang.String r3 = "griffin"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 60
            goto L_0x078a
        L_0x02c8:
            java.lang.String r3 = "marino_f"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 82
            goto L_0x078a
        L_0x02d4:
            java.lang.String r3 = "CPY83_I00"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 25
            goto L_0x078a
        L_0x02e0:
            java.lang.String r3 = "A2016a40"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 8
            goto L_0x078a
        L_0x02ec:
            java.lang.String r3 = "le_x6"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 77
            goto L_0x078a
        L_0x02f8:
            java.lang.String r3 = "l5460"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 76
            goto L_0x078a
        L_0x0304:
            java.lang.String r3 = "i9031"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 67
            goto L_0x078a
        L_0x0310:
            java.lang.String r3 = "X3_HK"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 135(0x87, float:1.89E-43)
            goto L_0x078a
        L_0x031c:
            java.lang.String r3 = "V23GB"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 128(0x80, float:1.794E-43)
            goto L_0x078a
        L_0x0328:
            java.lang.String r3 = "Q4310"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 112(0x70, float:1.57E-43)
            goto L_0x078a
        L_0x0334:
            java.lang.String r3 = "Q4260"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 110(0x6e, float:1.54E-43)
            goto L_0x078a
        L_0x0340:
            java.lang.String r3 = "PRO7S"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 108(0x6c, float:1.51E-43)
            goto L_0x078a
        L_0x034c:
            java.lang.String r3 = "F3311"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 48
            goto L_0x078a
        L_0x0358:
            java.lang.String r3 = "F3215"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 47
            goto L_0x078a
        L_0x0364:
            java.lang.String r3 = "F3213"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 46
            goto L_0x078a
        L_0x0370:
            java.lang.String r3 = "F3211"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 45
            goto L_0x078a
        L_0x037c:
            java.lang.String r3 = "F3116"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 44
            goto L_0x078a
        L_0x0388:
            java.lang.String r3 = "F3113"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 43
            goto L_0x078a
        L_0x0394:
            java.lang.String r3 = "F3111"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 42
            goto L_0x078a
        L_0x03a0:
            java.lang.String r3 = "E5643"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 30
            goto L_0x078a
        L_0x03ac:
            java.lang.String r3 = "A1601"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 7
            goto L_0x078a
        L_0x03b7:
            java.lang.String r3 = "Aura_Note_2"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 15
            goto L_0x078a
        L_0x03c3:
            java.lang.String r3 = "602LV"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 4
            goto L_0x078a
        L_0x03ce:
            java.lang.String r3 = "601LV"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 3
            goto L_0x078a
        L_0x03d9:
            java.lang.String r3 = "MEIZU_M5"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 83
            goto L_0x078a
        L_0x03e5:
            java.lang.String r3 = "p212"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 92
            goto L_0x078a
        L_0x03f1:
            java.lang.String r3 = "mido"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 85
            goto L_0x078a
        L_0x03fd:
            java.lang.String r3 = "kate"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 75
            goto L_0x078a
        L_0x0409:
            java.lang.String r3 = "fugu"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 50
            goto L_0x078a
        L_0x0415:
            java.lang.String r3 = "XE2X"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 136(0x88, float:1.9E-43)
            goto L_0x078a
        L_0x0421:
            java.lang.String r3 = "Q427"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 111(0x6f, float:1.56E-43)
            goto L_0x078a
        L_0x042d:
            java.lang.String r3 = "Q350"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 109(0x6d, float:1.53E-43)
            goto L_0x078a
        L_0x0439:
            java.lang.String r3 = "P681"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 93
            goto L_0x078a
        L_0x0445:
            java.lang.String r3 = "F04J"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 41
            goto L_0x078a
        L_0x0451:
            java.lang.String r3 = "F04H"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 40
            goto L_0x078a
        L_0x045d:
            java.lang.String r3 = "F03H"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 39
            goto L_0x078a
        L_0x0469:
            java.lang.String r3 = "F02H"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 38
            goto L_0x078a
        L_0x0475:
            java.lang.String r3 = "F01J"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 37
            goto L_0x078a
        L_0x0481:
            java.lang.String r3 = "F01H"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 36
            goto L_0x078a
        L_0x048d:
            java.lang.String r3 = "1714"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 2
            goto L_0x078a
        L_0x0498:
            java.lang.String r3 = "1713"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 1
            goto L_0x078a
        L_0x04a3:
            java.lang.String r3 = "1601"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 0
            goto L_0x078a
        L_0x04ae:
            java.lang.String r3 = "flo"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 49
            goto L_0x078a
        L_0x04ba:
            java.lang.String r4 = "deb"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0789
            goto L_0x078a
        L_0x04c4:
            java.lang.String r3 = "cv3"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 27
            goto L_0x078a
        L_0x04d0:
            java.lang.String r3 = "cv1"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 26
            goto L_0x078a
        L_0x04dc:
            java.lang.String r3 = "Z80"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 139(0x8b, float:1.95E-43)
            goto L_0x078a
        L_0x04e8:
            java.lang.String r3 = "QX1"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 115(0x73, float:1.61E-43)
            goto L_0x078a
        L_0x04f4:
            java.lang.String r3 = "PLE"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 107(0x6b, float:1.5E-43)
            goto L_0x078a
        L_0x0500:
            java.lang.String r3 = "P85"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 94
            goto L_0x078a
        L_0x050c:
            java.lang.String r3 = "MX6"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 86
            goto L_0x078a
        L_0x0518:
            java.lang.String r3 = "M5c"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 80
            goto L_0x078a
        L_0x0524:
            java.lang.String r3 = "M04"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 79
            goto L_0x078a
        L_0x0530:
            java.lang.String r3 = "JGZ"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 73
            goto L_0x078a
        L_0x053c:
            java.lang.String r3 = "mh"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 84
            goto L_0x078a
        L_0x0548:
            java.lang.String r3 = "b5"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 16
            goto L_0x078a
        L_0x0554:
            java.lang.String r3 = "V5"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 129(0x81, float:1.81E-43)
            goto L_0x078a
        L_0x0560:
            java.lang.String r3 = "V1"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 127(0x7f, float:1.78E-43)
            goto L_0x078a
        L_0x056c:
            java.lang.String r3 = "Q5"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 113(0x71, float:1.58E-43)
            goto L_0x078a
        L_0x0578:
            java.lang.String r3 = "C1"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 20
            goto L_0x078a
        L_0x0584:
            java.lang.String r3 = "woods_fn"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 134(0x86, float:1.88E-43)
            goto L_0x078a
        L_0x0590:
            java.lang.String r3 = "ELUGA_A3_Pro"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 31
            goto L_0x078a
        L_0x059c:
            java.lang.String r3 = "Z12_PRO"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 138(0x8a, float:1.93E-43)
            goto L_0x078a
        L_0x05a8:
            java.lang.String r3 = "BLACK-1X"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 17
            goto L_0x078a
        L_0x05b4:
            java.lang.String r3 = "taido_row"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 121(0x79, float:1.7E-43)
            goto L_0x078a
        L_0x05c0:
            java.lang.String r3 = "Pixi4-7_3G"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 105(0x69, float:1.47E-43)
            goto L_0x078a
        L_0x05cc:
            java.lang.String r3 = "GIONEE_GBL7360"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 53
            goto L_0x078a
        L_0x05d8:
            java.lang.String r3 = "GiONEE_CBL7513"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 51
            goto L_0x078a
        L_0x05e4:
            java.lang.String r3 = "OnePlus5T"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 91
            goto L_0x078a
        L_0x05f0:
            java.lang.String r3 = "whyred"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 132(0x84, float:1.85E-43)
            goto L_0x078a
        L_0x05fc:
            java.lang.String r3 = "watson"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 131(0x83, float:1.84E-43)
            goto L_0x078a
        L_0x0608:
            java.lang.String r3 = "SVP-DTV15"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 119(0x77, float:1.67E-43)
            goto L_0x078a
        L_0x0614:
            java.lang.String r3 = "A7000-a"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 9
            goto L_0x078a
        L_0x0620:
            java.lang.String r3 = "nicklaus_f"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 88
            goto L_0x078a
        L_0x062c:
            java.lang.String r3 = "tcl_eu"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 126(0x7e, float:1.77E-43)
            goto L_0x078a
        L_0x0638:
            java.lang.String r3 = "ELUGA_Ray_X"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 34
            goto L_0x078a
        L_0x0644:
            java.lang.String r3 = "s905x018"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 120(0x78, float:1.68E-43)
            goto L_0x078a
        L_0x0650:
            java.lang.String r3 = "A10-70L"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 6
            goto L_0x078a
        L_0x065b:
            java.lang.String r3 = "A10-70F"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 5
            goto L_0x078a
        L_0x0666:
            java.lang.String r3 = "namath"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 87
            goto L_0x078a
        L_0x0672:
            java.lang.String r3 = "Slate_Pro"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 118(0x76, float:1.65E-43)
            goto L_0x078a
        L_0x067e:
            java.lang.String r3 = "iris60"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 70
            goto L_0x078a
        L_0x068a:
            java.lang.String r3 = "BRAVIA_ATV2"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 18
            goto L_0x078a
        L_0x0696:
            java.lang.String r3 = "GiONEE_GBL7319"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 52
            goto L_0x078a
        L_0x06a2:
            java.lang.String r3 = "panell_dt"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 99
            goto L_0x078a
        L_0x06ae:
            java.lang.String r3 = "panell_ds"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 98
            goto L_0x078a
        L_0x06ba:
            java.lang.String r3 = "panell_dl"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 97
            goto L_0x078a
        L_0x06c6:
            java.lang.String r3 = "vernee_M5"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 130(0x82, float:1.82E-43)
            goto L_0x078a
        L_0x06d2:
            java.lang.String r3 = "pacificrim"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 95
            goto L_0x078a
        L_0x06de:
            java.lang.String r3 = "Phantom6"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 104(0x68, float:1.46E-43)
            goto L_0x078a
        L_0x06ea:
            java.lang.String r3 = "ComioS1"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 21
            goto L_0x078a
        L_0x06f6:
            java.lang.String r3 = "XT1663"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 137(0x89, float:1.92E-43)
            goto L_0x078a
        L_0x0702:
            java.lang.String r3 = "RAIJIN"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 116(0x74, float:1.63E-43)
            goto L_0x078a
        L_0x070e:
            java.lang.String r3 = "AquaPowerM"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 13
            goto L_0x078a
        L_0x071a:
            java.lang.String r3 = "PGN611"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 103(0x67, float:1.44E-43)
            goto L_0x078a
        L_0x0726:
            java.lang.String r3 = "PGN610"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 102(0x66, float:1.43E-43)
            goto L_0x078a
        L_0x0731:
            java.lang.String r3 = "PGN528"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 101(0x65, float:1.42E-43)
            goto L_0x078a
        L_0x073c:
            java.lang.String r3 = "NX573J"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 90
            goto L_0x078a
        L_0x0747:
            java.lang.String r3 = "NX541J"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 89
            goto L_0x078a
        L_0x0752:
            java.lang.String r3 = "CP8676_I02"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 22
            goto L_0x078a
        L_0x075d:
            java.lang.String r3 = "K50a40"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 74
            goto L_0x078a
        L_0x0768:
            java.lang.String r3 = "GIONEE_SWW1631"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 56
            goto L_0x078a
        L_0x0773:
            java.lang.String r3 = "GIONEE_SWW1627"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 55
            goto L_0x078a
        L_0x077e:
            java.lang.String r3 = "GIONEE_SWW1609"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0789
            r3 = 54
            goto L_0x078a
        L_0x0789:
            r3 = -1
        L_0x078a:
            switch(r3) {
                case 0: goto L_0x0080;
                case 1: goto L_0x0080;
                case 2: goto L_0x0080;
                case 3: goto L_0x0080;
                case 4: goto L_0x0080;
                case 5: goto L_0x0080;
                case 6: goto L_0x0080;
                case 7: goto L_0x0080;
                case 8: goto L_0x0080;
                case 9: goto L_0x0080;
                case 10: goto L_0x0080;
                case 11: goto L_0x0080;
                case 12: goto L_0x0080;
                case 13: goto L_0x0080;
                case 14: goto L_0x0080;
                case 15: goto L_0x0080;
                case 16: goto L_0x0080;
                case 17: goto L_0x0080;
                case 18: goto L_0x0080;
                case 19: goto L_0x0080;
                case 20: goto L_0x0080;
                case 21: goto L_0x0080;
                case 22: goto L_0x0080;
                case 23: goto L_0x0080;
                case 24: goto L_0x0080;
                case 25: goto L_0x0080;
                case 26: goto L_0x0080;
                case 27: goto L_0x0080;
                case 28: goto L_0x0080;
                case 29: goto L_0x0080;
                case 30: goto L_0x0080;
                case 31: goto L_0x0080;
                case 32: goto L_0x0080;
                case 33: goto L_0x0080;
                case 34: goto L_0x0080;
                case 35: goto L_0x0080;
                case 36: goto L_0x0080;
                case 37: goto L_0x0080;
                case 38: goto L_0x0080;
                case 39: goto L_0x0080;
                case 40: goto L_0x0080;
                case 41: goto L_0x0080;
                case 42: goto L_0x0080;
                case 43: goto L_0x0080;
                case 44: goto L_0x0080;
                case 45: goto L_0x0080;
                case 46: goto L_0x0080;
                case 47: goto L_0x0080;
                case 48: goto L_0x0080;
                case 49: goto L_0x0080;
                case 50: goto L_0x0080;
                case 51: goto L_0x0080;
                case 52: goto L_0x0080;
                case 53: goto L_0x0080;
                case 54: goto L_0x0080;
                case 55: goto L_0x0080;
                case 56: goto L_0x0080;
                case 57: goto L_0x0080;
                case 58: goto L_0x0080;
                case 59: goto L_0x0080;
                case 60: goto L_0x0080;
                case 61: goto L_0x0080;
                case 62: goto L_0x0080;
                case 63: goto L_0x0080;
                case 64: goto L_0x0080;
                case 65: goto L_0x0080;
                case 66: goto L_0x0080;
                case 67: goto L_0x0080;
                case 68: goto L_0x0080;
                case 69: goto L_0x0080;
                case 70: goto L_0x0080;
                case 71: goto L_0x0080;
                case 72: goto L_0x0080;
                case 73: goto L_0x0080;
                case 74: goto L_0x0080;
                case 75: goto L_0x0080;
                case 76: goto L_0x0080;
                case 77: goto L_0x0080;
                case 78: goto L_0x0080;
                case 79: goto L_0x0080;
                case 80: goto L_0x0080;
                case 81: goto L_0x0080;
                case 82: goto L_0x0080;
                case 83: goto L_0x0080;
                case 84: goto L_0x0080;
                case 85: goto L_0x0080;
                case 86: goto L_0x0080;
                case 87: goto L_0x0080;
                case 88: goto L_0x0080;
                case 89: goto L_0x0080;
                case 90: goto L_0x0080;
                case 91: goto L_0x0080;
                case 92: goto L_0x0080;
                case 93: goto L_0x0080;
                case 94: goto L_0x0080;
                case 95: goto L_0x0080;
                case 96: goto L_0x0080;
                case 97: goto L_0x0080;
                case 98: goto L_0x0080;
                case 99: goto L_0x0080;
                case 100: goto L_0x0080;
                case 101: goto L_0x0080;
                case 102: goto L_0x0080;
                case 103: goto L_0x0080;
                case 104: goto L_0x0080;
                case 105: goto L_0x0080;
                case 106: goto L_0x0080;
                case 107: goto L_0x0080;
                case 108: goto L_0x0080;
                case 109: goto L_0x0080;
                case 110: goto L_0x0080;
                case 111: goto L_0x0080;
                case 112: goto L_0x0080;
                case 113: goto L_0x0080;
                case 114: goto L_0x0080;
                case 115: goto L_0x0080;
                case 116: goto L_0x0080;
                case 117: goto L_0x0080;
                case 118: goto L_0x0080;
                case 119: goto L_0x0080;
                case 120: goto L_0x0080;
                case 121: goto L_0x0080;
                case 122: goto L_0x0080;
                case 123: goto L_0x0080;
                case 124: goto L_0x0080;
                case 125: goto L_0x0080;
                case 126: goto L_0x0080;
                case 127: goto L_0x0080;
                case 128: goto L_0x0080;
                case 129: goto L_0x0080;
                case 130: goto L_0x0080;
                case 131: goto L_0x0080;
                case 132: goto L_0x0080;
                case 133: goto L_0x0080;
                case 134: goto L_0x0080;
                case 135: goto L_0x0080;
                case 136: goto L_0x0080;
                case 137: goto L_0x0080;
                case 138: goto L_0x0080;
                case 139: goto L_0x0080;
                default: goto L_0x078d;
            }
        L_0x078d:
            int r0 = r13.hashCode()     // Catch:{ all -> 0x07aa }
            r3 = -594534941(0xffffffffdc901de3, float:-3.2452206E17)
            if (r0 == r3) goto L_0x0797
            goto L_0x07a0
        L_0x0797:
            java.lang.String r0 = "JSN-L21"
            boolean r0 = r13.equals(r0)
            if (r0 == 0) goto L_0x07a0
            r10 = 0
        L_0x07a0:
            if (r10 == 0) goto L_0x0080
        L_0x07a2:
            zzd = r1     // Catch:{ all -> 0x07aa }
            zzc = r11     // Catch:{ all -> 0x07aa }
        L_0x07a6:
            monitor-exit(r2)     // Catch:{ all -> 0x07aa }
            boolean r0 = zzd
            return r0
        L_0x07aa:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x07aa }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyu.zzaK(java.lang.String):boolean");
    }

    private static List zzaL(Context context, zzry zzry, zzam zzam, boolean z2, boolean z3) throws zzsf {
        String str = zzam.zzm;
        if (str == null) {
            return zzfsc.zzl();
        }
        if (zzfj.zza >= 26 && "video/dolby-vision".equals(str) && !zzyl.zza(context)) {
            List zzf2 = zzsl.zzf(zzry, zzam, z2, z3);
            if (!zzf2.isEmpty()) {
                return zzf2;
            }
        }
        return zzsl.zzh(zzry, zzam, z2, z3);
    }

    private final void zzaM(zzdn zzdn) {
        if (!zzdn.equals(zzdn.zza) && !zzdn.equals(this.zzF)) {
            this.zzF = zzdn;
            this.zzg.zzt(zzdn);
        }
    }

    private final void zzaN() {
        zzdn zzdn = this.zzF;
        if (zzdn != null) {
            this.zzg.zzt(zzdn);
        }
    }

    private final void zzaO() {
        Surface surface = this.zzm;
        zzyx zzyx = this.zzn;
        if (surface == zzyx) {
            this.zzm = null;
        }
        zzyx.release();
        this.zzn = null;
    }

    /* access modifiers changed from: private */
    public static boolean zzaP() {
        return zzfj.zza >= 21;
    }

    private static boolean zzaQ(long j2) {
        return j2 < -30000;
    }

    private final boolean zzaR(zzrs zzrs) {
        if (zzfj.zza < 23 || zzaK(zzrs.zza)) {
            return false;
        }
        if (!zzrs.zzf || zzyx.zzb(this.zze)) {
            return true;
        }
        return false;
    }

    public final void zzG(float f2, float f3) throws zzih {
        super.zzG(f2, f3);
        this.zzf.zze(f2);
    }

    public final String zzN() {
        return "MediaCodecVideoRenderer";
    }

    public final boolean zzQ() {
        zzyx zzyx;
        if (super.zzQ() && (this.zzq || (((zzyx = this.zzn) != null && this.zzm == zzyx) || zzan() == null))) {
            this.zzu = -9223372036854775807L;
            return true;
        } else if (this.zzu == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzu) {
                return true;
            }
            this.zzu = -9223372036854775807L;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final float zzS(float f2, zzam zzam, zzam[] zzamArr) {
        float f3 = -1.0f;
        for (zzam zzam2 : zzamArr) {
            float f4 = zzam2.zzt;
            if (f4 != -1.0f) {
                f3 = Math.max(f3, f4);
            }
        }
        if (f3 == -1.0f) {
            return -1.0f;
        }
        return f3 * f2;
    }

    /* access modifiers changed from: protected */
    public final int zzT(zzry zzry, zzam zzam) throws zzsf {
        boolean z2;
        boolean z3;
        int i2;
        int i3;
        int i4;
        int i5 = 128;
        if (!zzcc.zzg(zzam.zzm)) {
            return 128;
        }
        int i6 = 0;
        if (zzam.zzp != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        List zzaL = zzaL(this.zze, zzry, zzam, z2, false);
        if (z2 && zzaL.isEmpty()) {
            zzaL = zzaL(this.zze, zzry, zzam, false, false);
        }
        if (zzaL.isEmpty()) {
            return Sdk$SDKError.Reason.EMPTY_TPAT_ERROR_VALUE;
        }
        if (!zzrw.zzaB(zzam)) {
            return Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE;
        }
        zzrs zzrs = (zzrs) zzaL.get(0);
        boolean zze2 = zzrs.zze(zzam);
        if (!zze2) {
            int i7 = 1;
            while (true) {
                if (i7 >= zzaL.size()) {
                    break;
                }
                zzrs zzrs2 = (zzrs) zzaL.get(i7);
                if (zzrs2.zze(zzam)) {
                    zzrs = zzrs2;
                    z3 = false;
                    zze2 = true;
                    break;
                }
                i7++;
            }
        }
        z3 = true;
        if (true != zze2) {
            i2 = 3;
        } else {
            i2 = 4;
        }
        if (true != zzrs.zzf(zzam)) {
            i3 = 8;
        } else {
            i3 = 16;
        }
        if (true != zzrs.zzg) {
            i4 = 0;
        } else {
            i4 = 64;
        }
        if (true != z3) {
            i5 = 0;
        }
        if (zzfj.zza >= 26 && "video/dolby-vision".equals(zzam.zzm) && !zzyl.zza(this.zze)) {
            i5 = UserVerificationMethods.USER_VERIFY_HANDPRINT;
        }
        if (zze2) {
            List zzaL2 = zzaL(this.zze, zzry, zzam, z2, true);
            if (!zzaL2.isEmpty()) {
                zzrs zzrs3 = (zzrs) zzsl.zzi(zzaL2, zzam).get(0);
                if (zzrs3.zze(zzam) && zzrs3.zzf(zzam)) {
                    i6 = 32;
                }
            }
        }
        return i2 | i3 | i6 | i4 | i5;
    }

    /* access modifiers changed from: protected */
    public final zzia zzU(zzrs zzrs, zzam zzam, zzam zzam2) {
        int i2;
        int i3;
        zzia zzb2 = zzrs.zzb(zzam, zzam2);
        int i4 = zzb2.zze;
        int i5 = zzam2.zzr;
        zzym zzym = this.zzj;
        if (i5 > zzym.zza || zzam2.zzs > zzym.zzb) {
            i4 |= UserVerificationMethods.USER_VERIFY_HANDPRINT;
        }
        if (zzX(zzrs, zzam2) > this.zzj.zzc) {
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
        zzia zzV = super.zzV(zzkj);
        this.zzg.zzf(zzkj.zza, zzV);
        return zzV;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x021b  */
    @android.annotation.TargetApi(17)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzrn zzY(com.google.android.gms.internal.ads.zzrs r20, com.google.android.gms.internal.ads.zzam r21, android.media.MediaCrypto r22, float r23) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r23
            com.google.android.gms.internal.ads.zzyx r4 = r0.zzn
            if (r4 == 0) goto L_0x0015
            boolean r4 = r4.zza
            boolean r5 = r1.zzf
            if (r4 == r5) goto L_0x0015
            r19.zzaO()
        L_0x0015:
            java.lang.String r4 = r1.zzc
            com.google.android.gms.internal.ads.zzam[] r5 = r19.zzM()
            int r6 = r2.zzr
            int r7 = r2.zzs
            int r8 = zzX(r20, r21)
            int r9 = r5.length
            r10 = -1
            r13 = 1
            if (r9 != r13) goto L_0x0043
            if (r8 == r10) goto L_0x003a
            int r5 = zzW(r20, r21)
            if (r5 == r10) goto L_0x003a
            float r8 = (float) r8
            r9 = 1069547520(0x3fc00000, float:1.5)
            float r8 = r8 * r9
            int r8 = (int) r8
            int r8 = java.lang.Math.min(r8, r5)
        L_0x003a:
            com.google.android.gms.internal.ads.zzym r5 = new com.google.android.gms.internal.ads.zzym
            r5.<init>(r6, r7, r8)
            r16 = r4
            goto L_0x0173
        L_0x0043:
            r14 = 0
            r15 = 0
        L_0x0045:
            if (r14 >= r9) goto L_0x0089
            r11 = r5[r14]
            com.google.android.gms.internal.ads.zzs r12 = r2.zzy
            if (r12 == 0) goto L_0x005e
            com.google.android.gms.internal.ads.zzs r12 = r11.zzy
            if (r12 != 0) goto L_0x005e
            com.google.android.gms.internal.ads.zzak r11 = r11.zzb()
            com.google.android.gms.internal.ads.zzs r12 = r2.zzy
            r11.zzy(r12)
            com.google.android.gms.internal.ads.zzam r11 = r11.zzY()
        L_0x005e:
            com.google.android.gms.internal.ads.zzia r12 = r1.zzb(r2, r11)
            int r12 = r12.zzd
            if (r12 == 0) goto L_0x0085
            int r12 = r11.zzr
            if (r12 == r10) goto L_0x0071
            int r13 = r11.zzs
            if (r13 != r10) goto L_0x006f
            goto L_0x0071
        L_0x006f:
            r13 = 0
            goto L_0x0072
        L_0x0071:
            r13 = 1
        L_0x0072:
            r15 = r15 | r13
            int r6 = java.lang.Math.max(r6, r12)
            int r12 = r11.zzs
            int r7 = java.lang.Math.max(r7, r12)
            int r11 = zzX(r1, r11)
            int r8 = java.lang.Math.max(r8, r11)
        L_0x0085:
            int r14 = r14 + 1
            r13 = 1
            goto L_0x0045
        L_0x0089:
            if (r15 == 0) goto L_0x016c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = "Resolutions unknown. Codec max resolution: "
            r5.append(r9)
            r5.append(r6)
            java.lang.String r9 = "x"
            r5.append(r9)
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            java.lang.String r10 = "MediaCodecVideoRenderer"
            com.google.android.gms.internal.ads.zzer.zzf(r10, r5)
            int r5 = r2.zzs
            int r11 = r2.zzr
            if (r5 <= r11) goto L_0x00b1
            r12 = 1
            goto L_0x00b2
        L_0x00b1:
            r12 = 0
        L_0x00b2:
            if (r12 == 0) goto L_0x00b6
            r13 = r5
            goto L_0x00b7
        L_0x00b6:
            r13 = r11
        L_0x00b7:
            r14 = 1
            if (r14 != r12) goto L_0x00bb
            r5 = r11
        L_0x00bb:
            int[] r11 = zzb
            r14 = 0
        L_0x00be:
            r15 = 9
            if (r14 >= r15) goto L_0x012a
            float r15 = (float) r5
            float r3 = (float) r13
            r16 = r4
            r4 = r11[r14]
            r17 = r11
            float r11 = (float) r4
            if (r4 <= r13) goto L_0x012c
            float r15 = r15 / r3
            float r11 = r11 * r15
            int r3 = (int) r11
            if (r3 > r5) goto L_0x00d5
            goto L_0x012c
        L_0x00d5:
            int r11 = com.google.android.gms.internal.ads.zzfj.zza
            r15 = 21
            if (r11 < r15) goto L_0x00fb
            r11 = 1
            if (r11 == r12) goto L_0x00e0
            r15 = r4
            goto L_0x00e1
        L_0x00e0:
            r15 = r3
        L_0x00e1:
            if (r11 != r12) goto L_0x00e4
            goto L_0x00e5
        L_0x00e4:
            r4 = r3
        L_0x00e5:
            android.graphics.Point r3 = r1.zza(r15, r4)
            float r4 = r2.zzt
            int r11 = r3.x
            int r15 = r3.y
            r18 = r3
            double r3 = (double) r4
            boolean r3 = r1.zzg(r11, r15, r3)
            if (r3 == 0) goto L_0x011f
            r3 = r18
            goto L_0x012d
        L_0x00fb:
            int r4 = r4 + 15
            int r4 = r4 / 16
            int r4 = r4 * 16
            int r3 = r3 + 15
            int r3 = r3 / 16
            int r3 = r3 * 16
            int r11 = r4 * r3
            int r15 = com.google.android.gms.internal.ads.zzsl.zza()     // Catch:{ zzsf -> 0x0128 }
            if (r11 > r15) goto L_0x011f
            android.graphics.Point r5 = new android.graphics.Point     // Catch:{ zzsf -> 0x0128 }
            r11 = 1
            if (r11 == r12) goto L_0x0116
            r13 = r4
            goto L_0x0117
        L_0x0116:
            r13 = r3
        L_0x0117:
            if (r11 == r12) goto L_0x011a
            r4 = r3
        L_0x011a:
            r5.<init>(r13, r4)     // Catch:{ zzsf -> 0x0128 }
            r3 = r5
            goto L_0x012d
        L_0x011f:
            int r14 = r14 + 1
            r3 = r23
            r4 = r16
            r11 = r17
            goto L_0x00be
        L_0x0128:
            goto L_0x012c
        L_0x012a:
            r16 = r4
        L_0x012c:
            r3 = 0
        L_0x012d:
            if (r3 == 0) goto L_0x016e
            int r4 = r3.x
            int r6 = java.lang.Math.max(r6, r4)
            int r3 = r3.y
            int r7 = java.lang.Math.max(r7, r3)
            com.google.android.gms.internal.ads.zzak r3 = r21.zzb()
            r3.zzX(r6)
            r3.zzF(r7)
            com.google.android.gms.internal.ads.zzam r3 = r3.zzY()
            int r3 = zzW(r1, r3)
            int r8 = java.lang.Math.max(r8, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Codec max resolution adjusted to: "
            r3.append(r4)
            r3.append(r6)
            r3.append(r9)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            com.google.android.gms.internal.ads.zzer.zzf(r10, r3)
            goto L_0x016e
        L_0x016c:
            r16 = r4
        L_0x016e:
            com.google.android.gms.internal.ads.zzym r5 = new com.google.android.gms.internal.ads.zzym
            r5.<init>(r6, r7, r8)
        L_0x0173:
            r0.zzj = r5
            boolean r3 = r0.zzi
            android.media.MediaFormat r4 = new android.media.MediaFormat
            r4.<init>()
            java.lang.String r6 = "mime"
            r7 = r16
            r4.setString(r6, r7)
            int r6 = r2.zzr
            java.lang.String r7 = "width"
            r4.setInteger(r7, r6)
            int r6 = r2.zzs
            java.lang.String r7 = "height"
            r4.setInteger(r7, r6)
            java.util.List r6 = r2.zzo
            com.google.android.gms.internal.ads.zzet.zzb(r4, r6)
            float r6 = r2.zzt
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r8 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
            java.lang.String r8 = "frame-rate"
            r4.setFloat(r8, r6)
        L_0x01a3:
            int r6 = r2.zzu
            java.lang.String r8 = "rotation-degrees"
            com.google.android.gms.internal.ads.zzet.zza(r4, r8, r6)
            com.google.android.gms.internal.ads.zzs r6 = r2.zzy
            if (r6 == 0) goto L_0x01d0
            java.lang.String r8 = "color-transfer"
            int r9 = r6.zzf
            com.google.android.gms.internal.ads.zzet.zza(r4, r8, r9)
            java.lang.String r8 = "color-standard"
            int r9 = r6.zzd
            com.google.android.gms.internal.ads.zzet.zza(r4, r8, r9)
            java.lang.String r8 = "color-range"
            int r9 = r6.zze
            com.google.android.gms.internal.ads.zzet.zza(r4, r8, r9)
            byte[] r6 = r6.zzg
            if (r6 == 0) goto L_0x01d0
            java.lang.String r8 = "hdr-static-info"
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.wrap(r6)
            r4.setByteBuffer(r8, r6)
        L_0x01d0:
            java.lang.String r6 = r2.zzm
            java.lang.String r8 = "video/dolby-vision"
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L_0x01ed
            android.util.Pair r6 = com.google.android.gms.internal.ads.zzsl.zzb(r21)
            if (r6 == 0) goto L_0x01ed
            java.lang.Object r6 = r6.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.String r8 = "profile"
            com.google.android.gms.internal.ads.zzet.zza(r4, r8, r6)
        L_0x01ed:
            int r6 = r5.zza
            java.lang.String r8 = "max-width"
            r4.setInteger(r8, r6)
            int r6 = r5.zzb
            java.lang.String r8 = "max-height"
            r4.setInteger(r8, r6)
            int r5 = r5.zzc
            java.lang.String r6 = "max-input-size"
            com.google.android.gms.internal.ads.zzet.zza(r4, r6, r5)
            int r5 = com.google.android.gms.internal.ads.zzfj.zza
            r6 = 23
            if (r5 < r6) goto L_0x0219
            java.lang.String r5 = "priority"
            r6 = 0
            r4.setInteger(r5, r6)
            r5 = r23
            int r6 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x0219
            java.lang.String r6 = "operating-rate"
            r4.setFloat(r6, r5)
        L_0x0219:
            if (r3 == 0) goto L_0x0227
            java.lang.String r3 = "no-post-process"
            r5 = 1
            r4.setInteger(r3, r5)
            java.lang.String r3 = "auto-frc"
            r5 = 0
            r4.setInteger(r3, r5)
        L_0x0227:
            android.view.Surface r3 = r0.zzm
            if (r3 != 0) goto L_0x024a
            boolean r3 = r19.zzaR(r20)
            if (r3 == 0) goto L_0x0244
            com.google.android.gms.internal.ads.zzyx r3 = r0.zzn
            if (r3 != 0) goto L_0x023f
            android.content.Context r3 = r0.zze
            boolean r5 = r1.zzf
            com.google.android.gms.internal.ads.zzyx r3 = com.google.android.gms.internal.ads.zzyx.zza(r3, r5)
            r0.zzn = r3
        L_0x023f:
            com.google.android.gms.internal.ads.zzyx r3 = r0.zzn
            r0.zzm = r3
            goto L_0x024a
        L_0x0244:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x024a:
            android.view.Surface r3 = r0.zzm
            r5 = 0
            com.google.android.gms.internal.ads.zzrn r1 = com.google.android.gms.internal.ads.zzrn.zzb(r1, r4, r2, r3, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyu.zzY(com.google.android.gms.internal.ads.zzrs, com.google.android.gms.internal.ads.zzam, android.media.MediaCrypto, float):com.google.android.gms.internal.ads.zzrn");
    }

    /* access modifiers changed from: protected */
    public final List zzZ(zzry zzry, zzam zzam, boolean z2) throws zzsf {
        return zzsl.zzi(zzaL(this.zze, zzry, zzam, false, false), zzam);
    }

    /* access modifiers changed from: protected */
    public final boolean zzaA(zzrs zzrs) {
        return this.zzm != null || zzaR(zzrs);
    }

    /* access modifiers changed from: package-private */
    public final void zzaD() {
        this.zzs = true;
        if (!this.zzq) {
            this.zzq = true;
            this.zzg.zzq(this.zzm);
            this.zzo = true;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzaE(zzrp zzrp, int i2, long j2) {
        int i3 = zzfj.zza;
        Trace.beginSection("releaseOutputBuffer");
        zzrp.zzn(i2, true);
        Trace.endSection();
        this.zza.zze++;
        this.zzx = 0;
        this.zzA = SystemClock.elapsedRealtime() * 1000;
        zzaM(this.zzE);
        zzaD();
    }

    /* access modifiers changed from: protected */
    public final void zzaF(zzrp zzrp, int i2, long j2, long j3) {
        int i3 = zzfj.zza;
        Trace.beginSection("releaseOutputBuffer");
        zzrp.zzm(i2, j3);
        Trace.endSection();
        this.zza.zze++;
        this.zzx = 0;
        this.zzA = SystemClock.elapsedRealtime() * 1000;
        zzaM(this.zzE);
        zzaD();
    }

    /* access modifiers changed from: protected */
    public final void zzaG(zzrp zzrp, int i2, long j2) {
        int i3 = zzfj.zza;
        Trace.beginSection("skipVideoBuffer");
        zzrp.zzn(i2, false);
        Trace.endSection();
        this.zza.zzf++;
    }

    /* access modifiers changed from: protected */
    public final void zzaH(int i2, int i3) {
        zzhz zzhz = this.zza;
        zzhz.zzh += i2;
        int i4 = i2 + i3;
        zzhz.zzg += i4;
        this.zzw += i4;
        int i5 = this.zzx + i4;
        this.zzx = i5;
        zzhz.zzi = Math.max(i5, zzhz.zzi);
    }

    /* access modifiers changed from: protected */
    public final void zzaI(long j2) {
        zzhz zzhz = this.zza;
        zzhz.zzk += j2;
        zzhz.zzl++;
        this.zzB += j2;
        this.zzC++;
    }

    /* access modifiers changed from: protected */
    public final void zzaa(Exception exc) {
        zzer.zzd("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzs(exc);
    }

    /* access modifiers changed from: protected */
    public final void zzab(String str, zzrn zzrn, long j2, long j3) {
        this.zzg.zza(str, j2, j3);
        this.zzk = zzaK(str);
        zzrs zzap = zzap();
        zzap.getClass();
        boolean z2 = false;
        if (zzfj.zza >= 29 && "video/x-vnd.on2.vp9".equals(zzap.zzb)) {
            MediaCodecInfo.CodecProfileLevel[] zzh2 = zzap.zzh();
            int length = zzh2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (zzh2[i2].profile == 16384) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.zzl = z2;
        this.zzh.zza(str);
    }

    /* access modifiers changed from: protected */
    public final void zzac(String str) {
        this.zzg.zzb(str);
    }

    /* access modifiers changed from: protected */
    public final void zzad(zzam zzam, MediaFormat mediaFormat) {
        boolean z2;
        int i2;
        int i3;
        zzrp zzan = zzan();
        if (zzan != null) {
            zzan.zzq(this.zzp);
        }
        mediaFormat.getClass();
        int i4 = 0;
        if (!mediaFormat.containsKey("crop-right") || !mediaFormat.containsKey("crop-left") || !mediaFormat.containsKey("crop-bottom") || !mediaFormat.containsKey("crop-top")) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            i2 = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i2 = mediaFormat.getInteger("width");
        }
        if (z2) {
            i3 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i3 = mediaFormat.getInteger("height");
        }
        float f2 = zzam.zzv;
        if (zzaP()) {
            int i5 = zzam.zzu;
            if (i5 == 90 || i5 == 270) {
                f2 = 1.0f / f2;
                int i6 = i3;
                i3 = i2;
                i2 = i6;
            }
        } else {
            i4 = zzam.zzu;
        }
        this.zzE = new zzdn(i2, i3, i4, f2);
        this.zzf.zzc(zzam.zzt);
    }

    /* access modifiers changed from: protected */
    public final void zzaf(long j2) {
        super.zzaf(j2);
        this.zzy--;
    }

    /* access modifiers changed from: protected */
    public final void zzag() {
        this.zzq = false;
        int i2 = zzfj.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzah(zzhp zzhp) throws zzih {
        this.zzy++;
        int i2 = zzfj.zza;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaj(long j2, long j3, zzrp zzrp, ByteBuffer byteBuffer, int i2, int i3, int i4, long j4, boolean z2, boolean z3, zzam zzam) throws zzih {
        boolean z4;
        boolean z5;
        int zzd2;
        long j5 = j2;
        zzrp zzrp2 = zzrp;
        int i5 = i2;
        long j6 = j4;
        zzrp.getClass();
        if (this.zzt == -9223372036854775807L) {
            this.zzt = j5;
        }
        if (j6 != this.zzz) {
            this.zzf.zzd(j6);
            this.zzz = j6;
        }
        long zzam2 = j6 - zzam();
        if (!z2 || z3) {
            int zzbc = zzbc();
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            long zzal = (long) (((double) (j6 - j5)) / ((double) zzal()));
            if (zzbc == 2) {
                zzal -= elapsedRealtime - j3;
            }
            if (this.zzm != this.zzn) {
                int zzbc2 = zzbc();
                boolean z6 = this.zzs;
                if (zzbc2 == 2) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z6 ? this.zzq : !z4 && !this.zzr) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                long elapsedRealtime2 = (SystemClock.elapsedRealtime() * 1000) - this.zzA;
                if (this.zzu == -9223372036854775807L && j5 >= zzam() && (z5 || (z4 && zzaQ(zzal) && elapsedRealtime2 > 100000))) {
                    long nanoTime = System.nanoTime();
                    if (zzfj.zza >= 21) {
                        zzaF(zzrp, i2, zzam2, nanoTime);
                    } else {
                        zzaE(zzrp2, i5, zzam2);
                    }
                    zzaI(zzal);
                    return true;
                } else if (zzbc != 2 || j5 == this.zzt) {
                    return false;
                } else {
                    long nanoTime2 = System.nanoTime();
                    long zza = this.zzf.zza((zzal * 1000) + nanoTime2);
                    long j7 = (zza - nanoTime2) / 1000;
                    long j8 = this.zzu;
                    if (j7 < -500000 && !z3 && (zzd2 = zzd(j2)) != 0) {
                        if (j8 != -9223372036854775807L) {
                            zzhz zzhz = this.zza;
                            zzhz.zzd += zzd2;
                            zzhz.zzf += this.zzy;
                        } else {
                            this.zza.zzj++;
                            zzaH(zzd2, this.zzy);
                        }
                        zzaw();
                        return false;
                    } else if (zzaQ(j7) && !z3) {
                        if (j8 != -9223372036854775807L) {
                            zzaG(zzrp2, i5, zzam2);
                        } else {
                            int i6 = zzfj.zza;
                            Trace.beginSection("dropVideoBuffer");
                            zzrp2.zzn(i5, false);
                            Trace.endSection();
                            zzaH(0, 1);
                        }
                        zzaI(j7);
                        return true;
                    } else if (zzfj.zza >= 21) {
                        if (j7 >= 50000) {
                            return false;
                        }
                        if (zza == this.zzD) {
                            zzaG(zzrp2, i5, zzam2);
                        } else {
                            zzaF(zzrp, i2, zzam2, zza);
                        }
                        zzaI(j7);
                        this.zzD = zza;
                        return true;
                    } else if (j7 >= NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
                        return false;
                    } else {
                        if (j7 > 11000) {
                            try {
                                Thread.sleep((-10000 + j7) / 1000);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                return false;
                            }
                        }
                        zzaE(zzrp2, i5, zzam2);
                        zzaI(j7);
                        return true;
                    }
                }
            } else if (!zzaQ(zzal)) {
                return false;
            } else {
                zzaG(zzrp2, i5, zzam2);
                zzaI(zzal);
                return true;
            }
        } else {
            zzaG(zzrp2, i5, zzam2);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final zzrq zzao(Throwable th, zzrs zzrs) {
        return new zzyk(th, zzrs, this.zzm);
    }

    /* access modifiers changed from: protected */
    @TargetApi(29)
    public final void zzaq(zzhp zzhp) throws zzih {
        if (this.zzl) {
            ByteBuffer byteBuffer = zzhp.zze;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b2 = byteBuffer.get();
                short s2 = byteBuffer.getShort();
                short s3 = byteBuffer.getShort();
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                byteBuffer.position(0);
                if (b2 != -75 || s2 != 60 || s3 != 1 || b3 != 4) {
                    return;
                }
                if (b4 == 0 || b4 == 1) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    zzrp zzan = zzan();
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("hdr10-plus-info", bArr);
                    zzan.zzp(bundle);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzas(zzam zzam) throws zzih {
        this.zzh.zzd(zzam, zzam());
    }

    /* access modifiers changed from: protected */
    public final void zzau() {
        super.zzau();
        this.zzy = 0;
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzq(int r6, java.lang.Object r7) throws com.google.android.gms.internal.ads.zzih {
        /*
            r5 = this;
            r0 = 1
            if (r6 == r0) goto L_0x0070
            r0 = 7
            if (r6 == r0) goto L_0x006b
            r0 = 10
            if (r6 == r0) goto L_0x005e
            r0 = 4
            if (r6 == r0) goto L_0x004c
            r0 = 5
            if (r6 == r0) goto L_0x0040
            r0 = 13
            if (r6 == r0) goto L_0x0035
            r0 = 14
            if (r6 == r0) goto L_0x001a
            goto L_0x00f8
        L_0x001a:
            r7.getClass()
            com.google.android.gms.internal.ads.zzfb r7 = (com.google.android.gms.internal.ads.zzfb) r7
            int r6 = r7.zzb()
            if (r6 == 0) goto L_0x00f8
            int r6 = r7.zza()
            if (r6 == 0) goto L_0x00f8
            android.view.Surface r6 = r5.zzm
            if (r6 == 0) goto L_0x00f8
            com.google.android.gms.internal.ads.zzyt r0 = r5.zzh
            r0.zzb(r6, r7)
            return
        L_0x0035:
            r7.getClass()
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzyt r6 = r5.zzh
            r6.zzc(r7)
            return
        L_0x0040:
            com.google.android.gms.internal.ads.zzzf r6 = r5.zzf
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r6.zzj(r7)
            return
        L_0x004c:
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r6 = r7.intValue()
            r5.zzp = r6
            com.google.android.gms.internal.ads.zzrp r7 = r5.zzan()
            if (r7 == 0) goto L_0x00f8
            r7.zzq(r6)
            return
        L_0x005e:
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r6 = r7.intValue()
            int r7 = r5.zzG
            if (r7 == r6) goto L_0x00f8
            r5.zzG = r6
            return
        L_0x006b:
            com.google.android.gms.internal.ads.zzyy r7 = (com.google.android.gms.internal.ads.zzyy) r7
            r5.zzH = r7
            return
        L_0x0070:
            boolean r6 = r7 instanceof android.view.Surface
            r0 = 0
            if (r6 == 0) goto L_0x0078
            android.view.Surface r7 = (android.view.Surface) r7
            goto L_0x0079
        L_0x0078:
            r7 = r0
        L_0x0079:
            if (r7 != 0) goto L_0x0097
            com.google.android.gms.internal.ads.zzyx r6 = r5.zzn
            if (r6 == 0) goto L_0x0081
            r7 = r6
            goto L_0x0097
        L_0x0081:
            com.google.android.gms.internal.ads.zzrs r6 = r5.zzap()
            if (r6 == 0) goto L_0x0097
            boolean r1 = r5.zzaR(r6)
            if (r1 == 0) goto L_0x0097
            android.content.Context r7 = r5.zze
            boolean r6 = r6.zzf
            com.google.android.gms.internal.ads.zzyx r7 = com.google.android.gms.internal.ads.zzyx.zza(r7, r6)
            r5.zzn = r7
        L_0x0097:
            android.view.Surface r6 = r5.zzm
            if (r6 == r7) goto L_0x00e4
            r5.zzm = r7
            com.google.android.gms.internal.ads.zzzf r6 = r5.zzf
            r6.zzi(r7)
            r6 = 0
            r5.zzo = r6
            int r1 = r5.zzbc()
            com.google.android.gms.internal.ads.zzrp r2 = r5.zzan()
            if (r2 == 0) goto L_0x00c5
            int r3 = com.google.android.gms.internal.ads.zzfj.zza
            r4 = 23
            if (r3 < r4) goto L_0x00bf
            if (r7 == 0) goto L_0x00bf
            boolean r3 = r5.zzk
            if (r3 != 0) goto L_0x00bf
            r2.zzo(r7)
            goto L_0x00c5
        L_0x00bf:
            r5.zzat()
            r5.zzar()
        L_0x00c5:
            if (r7 == 0) goto L_0x00dd
            com.google.android.gms.internal.ads.zzyx r2 = r5.zzn
            if (r7 == r2) goto L_0x00dd
            r5.zzaN()
            r5.zzq = r6
            int r6 = com.google.android.gms.internal.ads.zzfj.zza
            r6 = 2
            if (r1 != r6) goto L_0x00f8
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5.zzu = r6
            return
        L_0x00dd:
            r5.zzF = r0
            r5.zzq = r6
            int r6 = com.google.android.gms.internal.ads.zzfj.zza
            return
        L_0x00e4:
            if (r7 == 0) goto L_0x00f8
            com.google.android.gms.internal.ads.zzyx r6 = r5.zzn
            if (r7 == r6) goto L_0x00f8
            r5.zzaN()
            boolean r6 = r5.zzo
            if (r6 == 0) goto L_0x00f8
            com.google.android.gms.internal.ads.zzzq r6 = r5.zzg
            android.view.Surface r7 = r5.zzm
            r6.zzq(r7)
        L_0x00f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyu.zzq(int, java.lang.Object):void");
    }

    /* access modifiers changed from: protected */
    public final void zzt() {
        this.zzF = null;
        this.zzq = false;
        int i2 = zzfj.zza;
        this.zzo = false;
        try {
            super.zzt();
        } finally {
            this.zzg.zzc(this.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzu(boolean z2, boolean z3) throws zzih {
        super.zzu(z2, z3);
        zzk();
        this.zzg.zze(this.zza);
        this.zzr = z3;
        this.zzs = false;
    }

    /* access modifiers changed from: protected */
    public final void zzv(long j2, boolean z2) throws zzih {
        super.zzv(j2, z2);
        this.zzq = false;
        int i2 = zzfj.zza;
        this.zzf.zzf();
        this.zzz = -9223372036854775807L;
        this.zzt = -9223372036854775807L;
        this.zzx = 0;
        this.zzu = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    @TargetApi(17)
    public final void zzw() {
        try {
            super.zzw();
            if (this.zzn != null) {
                zzaO();
            }
        } catch (Throwable th) {
            if (this.zzn != null) {
                zzaO();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzx() {
        this.zzw = 0;
        this.zzv = SystemClock.elapsedRealtime();
        this.zzA = SystemClock.elapsedRealtime() * 1000;
        this.zzB = 0;
        this.zzC = 0;
        this.zzf.zzg();
    }

    /* access modifiers changed from: protected */
    public final void zzy() {
        this.zzu = -9223372036854775807L;
        if (this.zzw > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzg.zzd(this.zzw, elapsedRealtime - this.zzv);
            this.zzw = 0;
            this.zzv = elapsedRealtime;
        }
        int i2 = this.zzC;
        if (i2 != 0) {
            this.zzg.zzr(this.zzB, i2);
            this.zzB = 0;
            this.zzC = 0;
        }
        this.zzf.zzh();
    }
}
