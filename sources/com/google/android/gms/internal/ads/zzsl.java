package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.ar.core.ImageMetadata;
import com.google.protobuf.CodedOutputStream;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import okhttp3.internal.http2.Http2;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@SuppressLint({"InlinedApi"})
public final class zzsl {
    public static final /* synthetic */ int zza = 0;
    private static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap zzc = new HashMap();
    private static int zzd = -1;

    public static int zza() throws zzsf {
        int i2;
        int i3;
        int i4 = zzd;
        if (i4 == -1) {
            zzrs zzc2 = zzc(MimeTypes.VIDEO_H264, false, false);
            if (zzc2 != null) {
                int i5 = 0;
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : zzc2.zzh()) {
                    int i6 = codecProfileLevel.level;
                    if (i6 != 1 && i6 != 2) {
                        switch (i6) {
                            case 8:
                            case 16:
                            case 32:
                                i3 = 101376;
                                break;
                            case 64:
                                i3 = 202752;
                                break;
                            case 128:
                            case UserVerificationMethods.USER_VERIFY_HANDPRINT:
                                i3 = 414720;
                                break;
                            case 512:
                                i3 = 921600;
                                break;
                            case 1024:
                                i3 = 1310720;
                                break;
                            case 2048:
                            case CodedOutputStream.DEFAULT_BUFFER_SIZE /*4096*/:
                                i3 = 2097152;
                                break;
                            case 8192:
                                i3 = 2228224;
                                break;
                            case Http2.INITIAL_MAX_FRAME_SIZE /*16384*/:
                                i3 = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i3 = 9437184;
                                break;
                            case 131072:
                            case 262144:
                            case ImageMetadata.LENS_APERTURE /*524288*/:
                                i3 = 35651584;
                                break;
                            default:
                                i3 = -1;
                                break;
                        }
                    } else {
                        i3 = 25344;
                    }
                    i5 = Math.max(i3, i5);
                }
                if (zzfj.zza >= 21) {
                    i2 = 345600;
                } else {
                    i2 = 172800;
                }
                i4 = Math.max(i5, i2);
            } else {
                i4 = 0;
            }
            zzd = i4;
        }
        return i4;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x02c5 A[Catch:{ NumberFormatException -> 0x02d5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair zzb(com.google.android.gms.internal.ads.zzam r17) {
        /*
            r0 = r17
            java.lang.String r1 = r0.zzj
            r2 = 0
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            java.lang.String r3 = "\\."
            java.lang.String[] r1 = r1.split(r3)
            java.lang.String r3 = r0.zzm
            java.lang.String r4 = "video/dolby-vision"
            boolean r3 = r4.equals(r3)
            r7 = 512(0x200, float:7.175E-43)
            r8 = 256(0x100, float:3.59E-43)
            r9 = 128(0x80, float:1.794E-43)
            r10 = 64
            r11 = 32
            r14 = 4096(0x1000, float:5.74E-42)
            r15 = 8
            r5 = 16
            r2 = 3
            r12 = 4
            r13 = 2
            java.lang.String r4 = "MediaCodecUtil"
            r6 = 1
            if (r3 == 0) goto L_0x01f9
            java.lang.String r0 = r0.zzj
            int r3 = r1.length
            if (r3 >= r2) goto L_0x0043
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed Dolby Vision codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
        L_0x0040:
            r2 = 0
            goto L_0x01f8
        L_0x0043:
            java.util.regex.Pattern r3 = zzb
            r2 = r1[r6]
            java.util.regex.Matcher r2 = r3.matcher(r2)
            boolean r3 = r2.matches()
            if (r3 != 0) goto L_0x005f
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed Dolby Vision codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
            goto L_0x0040
        L_0x005f:
            java.lang.String r0 = r2.group(r6)
            if (r0 != 0) goto L_0x0068
        L_0x0065:
            r2 = 0
            goto L_0x010d
        L_0x0068:
            int r2 = r0.hashCode()
            switch(r2) {
                case 1536: goto L_0x00cd;
                case 1537: goto L_0x00c3;
                case 1538: goto L_0x00b9;
                case 1539: goto L_0x00af;
                case 1540: goto L_0x00a5;
                case 1541: goto L_0x009b;
                case 1542: goto L_0x0091;
                case 1543: goto L_0x0087;
                case 1544: goto L_0x007c;
                case 1545: goto L_0x0071;
                default: goto L_0x006f;
            }
        L_0x006f:
            goto L_0x00d7
        L_0x0071:
            java.lang.String r2 = "09"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00d7
            r2 = 9
            goto L_0x00d8
        L_0x007c:
            java.lang.String r2 = "08"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00d7
            r2 = 8
            goto L_0x00d8
        L_0x0087:
            java.lang.String r2 = "07"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00d7
            r2 = 7
            goto L_0x00d8
        L_0x0091:
            java.lang.String r2 = "06"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00d7
            r2 = 6
            goto L_0x00d8
        L_0x009b:
            java.lang.String r2 = "05"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00d7
            r2 = 5
            goto L_0x00d8
        L_0x00a5:
            java.lang.String r2 = "04"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00d7
            r2 = 4
            goto L_0x00d8
        L_0x00af:
            java.lang.String r2 = "03"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00d7
            r2 = 3
            goto L_0x00d8
        L_0x00b9:
            java.lang.String r2 = "02"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00d7
            r2 = 2
            goto L_0x00d8
        L_0x00c3:
            java.lang.String r2 = "01"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00d7
            r2 = 1
            goto L_0x00d8
        L_0x00cd:
            java.lang.String r2 = "00"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00d7
            r2 = 0
            goto L_0x00d8
        L_0x00d7:
            r2 = -1
        L_0x00d8:
            switch(r2) {
                case 0: goto L_0x0109;
                case 1: goto L_0x0104;
                case 2: goto L_0x00ff;
                case 3: goto L_0x00fa;
                case 4: goto L_0x00f5;
                case 5: goto L_0x00f0;
                case 6: goto L_0x00eb;
                case 7: goto L_0x00e6;
                case 8: goto L_0x00e1;
                case 9: goto L_0x00dc;
                default: goto L_0x00db;
            }
        L_0x00db:
            goto L_0x0065
        L_0x00dc:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x010d
        L_0x00e1:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            goto L_0x010d
        L_0x00e6:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)
            goto L_0x010d
        L_0x00eb:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            goto L_0x010d
        L_0x00f0:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            goto L_0x010d
        L_0x00f5:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            goto L_0x010d
        L_0x00fa:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)
            goto L_0x010d
        L_0x00ff:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
            goto L_0x010d
        L_0x0104:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            goto L_0x010d
        L_0x0109:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
        L_0x010d:
            if (r2 != 0) goto L_0x011e
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Unknown Dolby Vision profile string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
            goto L_0x0040
        L_0x011e:
            r0 = r1[r13]
            if (r0 != 0) goto L_0x0125
        L_0x0122:
            r1 = 0
            goto L_0x01e1
        L_0x0125:
            int r1 = r0.hashCode()
            switch(r1) {
                case 1537: goto L_0x01d5;
                case 1538: goto L_0x01c8;
                case 1539: goto L_0x01bb;
                case 1540: goto L_0x01ae;
                case 1541: goto L_0x01a1;
                case 1542: goto L_0x0194;
                case 1543: goto L_0x0187;
                case 1544: goto L_0x017a;
                case 1545: goto L_0x016c;
                default: goto L_0x012c;
            }
        L_0x012c:
            switch(r1) {
                case 1567: goto L_0x015e;
                case 1568: goto L_0x014e;
                case 1569: goto L_0x013e;
                case 1570: goto L_0x0130;
                default: goto L_0x012f;
            }
        L_0x012f:
            goto L_0x0122
        L_0x0130:
            java.lang.String r1 = "13"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            goto L_0x01e1
        L_0x013e:
            java.lang.String r1 = "12"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            r1 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x01e1
        L_0x014e:
            java.lang.String r1 = "11"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            r1 = 1024(0x400, float:1.435E-42)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x01e1
        L_0x015e:
            java.lang.String r1 = "10"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            goto L_0x01e1
        L_0x016c:
            java.lang.String r1 = "09"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            goto L_0x01e1
        L_0x017a:
            java.lang.String r1 = "08"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            goto L_0x01e1
        L_0x0187:
            java.lang.String r1 = "07"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
            goto L_0x01e1
        L_0x0194:
            java.lang.String r1 = "06"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            goto L_0x01e1
        L_0x01a1:
            java.lang.String r1 = "05"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            goto L_0x01e1
        L_0x01ae:
            java.lang.String r1 = "04"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            java.lang.Integer r1 = java.lang.Integer.valueOf(r15)
            goto L_0x01e1
        L_0x01bb:
            java.lang.String r1 = "03"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            goto L_0x01e1
        L_0x01c8:
            java.lang.String r1 = "02"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            goto L_0x01e1
        L_0x01d5:
            java.lang.String r1 = "01"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
        L_0x01e1:
            if (r1 != 0) goto L_0x01f2
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Unknown Dolby Vision level string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
            goto L_0x0040
        L_0x01f2:
            android.util.Pair r0 = new android.util.Pair
            r0.<init>(r2, r1)
            r2 = r0
        L_0x01f8:
            return r2
        L_0x01f9:
            r2 = 0
            r3 = r1[r2]
            int r2 = r3.hashCode()
            switch(r2) {
                case 3004662: goto L_0x0240;
                case 3006243: goto L_0x0236;
                case 3006244: goto L_0x022c;
                case 3199032: goto L_0x0222;
                case 3214780: goto L_0x0218;
                case 3356560: goto L_0x020e;
                case 3624515: goto L_0x0204;
                default: goto L_0x0203;
            }
        L_0x0203:
            goto L_0x024a
        L_0x0204:
            java.lang.String r2 = "vp09"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x024a
            r2 = 2
            goto L_0x024b
        L_0x020e:
            java.lang.String r2 = "mp4a"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x024a
            r2 = 6
            goto L_0x024b
        L_0x0218:
            java.lang.String r2 = "hvc1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x024a
            r2 = 4
            goto L_0x024b
        L_0x0222:
            java.lang.String r2 = "hev1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x024a
            r2 = 3
            goto L_0x024b
        L_0x022c:
            java.lang.String r2 = "avc2"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x024a
            r2 = 1
            goto L_0x024b
        L_0x0236:
            java.lang.String r2 = "avc1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x024a
            r2 = 0
            goto L_0x024b
        L_0x0240:
            java.lang.String r2 = "av01"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x024a
            r2 = 5
            goto L_0x024b
        L_0x024a:
            r2 = -1
        L_0x024b:
            r3 = 8192(0x2000, float:1.14794E-41)
            r10 = 20
            switch(r2) {
                case 0: goto L_0x0728;
                case 1: goto L_0x0728;
                case 2: goto L_0x0646;
                case 3: goto L_0x03da;
                case 4: goto L_0x03da;
                case 5: goto L_0x02e4;
                case 6: goto L_0x0254;
                default: goto L_0x0252;
            }
        L_0x0252:
            r0 = 0
            return r0
        L_0x0254:
            java.lang.String r0 = r0.zzj
            int r2 = r1.length
            r3 = 3
            if (r2 == r3) goto L_0x026a
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed MP4A codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
        L_0x0267:
            r2 = 0
            goto L_0x02e3
        L_0x026a:
            r2 = r1[r6]     // Catch:{ NumberFormatException -> 0x02d5 }
            int r2 = java.lang.Integer.parseInt(r2, r5)     // Catch:{ NumberFormatException -> 0x02d5 }
            java.lang.String r2 = com.google.android.gms.internal.ads.zzcc.zzd(r2)     // Catch:{ NumberFormatException -> 0x02d5 }
            java.lang.String r3 = "audio/mp4a-latm"
            boolean r2 = r3.equals(r2)     // Catch:{ NumberFormatException -> 0x02d5 }
            if (r2 == 0) goto L_0x0267
            r1 = r1[r13]     // Catch:{ NumberFormatException -> 0x02d5 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x02d5 }
            r2 = 17
            if (r1 == r2) goto L_0x02c0
            if (r1 == r10) goto L_0x02bc
            r2 = 23
            if (r1 == r2) goto L_0x02b9
            r2 = 29
            if (r1 == r2) goto L_0x02b6
            r2 = 39
            if (r1 == r2) goto L_0x02b3
            r2 = 42
            if (r1 == r2) goto L_0x02b0
            switch(r1) {
                case 1: goto L_0x02ad;
                case 2: goto L_0x02aa;
                case 3: goto L_0x02a7;
                case 4: goto L_0x02a4;
                case 5: goto L_0x02a1;
                case 6: goto L_0x029e;
                default: goto L_0x029b;
            }     // Catch:{ NumberFormatException -> 0x02d5 }
        L_0x029b:
            r1 = -1
            r5 = -1
            goto L_0x02c3
        L_0x029e:
            r1 = -1
            r5 = 6
            goto L_0x02c3
        L_0x02a1:
            r1 = -1
            r5 = 5
            goto L_0x02c3
        L_0x02a4:
            r1 = -1
            r5 = 4
            goto L_0x02c3
        L_0x02a7:
            r1 = -1
            r5 = 3
            goto L_0x02c3
        L_0x02aa:
            r1 = -1
            r5 = 2
            goto L_0x02c3
        L_0x02ad:
            r1 = -1
            r5 = 1
            goto L_0x02c3
        L_0x02b0:
            r5 = 42
            goto L_0x02c2
        L_0x02b3:
            r5 = 39
            goto L_0x02c2
        L_0x02b6:
            r5 = 29
            goto L_0x02c2
        L_0x02b9:
            r5 = 23
            goto L_0x02c2
        L_0x02bc:
            r1 = -1
            r5 = 20
            goto L_0x02c3
        L_0x02c0:
            r5 = 17
        L_0x02c2:
            r1 = -1
        L_0x02c3:
            if (r5 == r1) goto L_0x0267
            android.util.Pair r1 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x02d5 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch:{ NumberFormatException -> 0x02d5 }
            r3 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ NumberFormatException -> 0x02d5 }
            r1.<init>(r2, r3)     // Catch:{ NumberFormatException -> 0x02d5 }
            r2 = r1
            goto L_0x02e3
        L_0x02d5:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed MP4A codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
            goto L_0x0267
        L_0x02e3:
            return r2
        L_0x02e4:
            java.lang.String r2 = r0.zzj
            com.google.android.gms.internal.ads.zzs r0 = r0.zzy
            int r10 = r1.length
            if (r10 >= r12) goto L_0x02fb
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r1 = "Ignoring malformed AV1 codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
        L_0x02f8:
            r2 = 0
            goto L_0x03d9
        L_0x02fb:
            r10 = r1[r6]     // Catch:{ NumberFormatException -> 0x03ca }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x03ca }
            r5 = r1[r13]     // Catch:{ NumberFormatException -> 0x03ca }
            r8 = 0
            java.lang.String r5 = r5.substring(r8, r13)     // Catch:{ NumberFormatException -> 0x03ca }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ NumberFormatException -> 0x03ca }
            r8 = 3
            r1 = r1[r8]     // Catch:{ NumberFormatException -> 0x03ca }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x03ca }
            if (r10 == 0) goto L_0x032a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown AV1 profile: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
            goto L_0x02f8
        L_0x032a:
            if (r1 == r15) goto L_0x0358
            r2 = 10
            if (r1 == r2) goto L_0x0345
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Unknown AV1 bit depth: "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
            goto L_0x02f8
        L_0x0345:
            if (r0 == 0) goto L_0x0356
            byte[] r1 = r0.zzg
            if (r1 != 0) goto L_0x0353
            int r0 = r0.zzf
            r1 = 7
            if (r0 == r1) goto L_0x0353
            r1 = 6
            if (r0 != r1) goto L_0x0356
        L_0x0353:
            r0 = 4096(0x1000, float:5.74E-42)
            goto L_0x0359
        L_0x0356:
            r0 = 2
            goto L_0x0359
        L_0x0358:
            r0 = 1
        L_0x0359:
            switch(r5) {
                case 0: goto L_0x03a2;
                case 1: goto L_0x03a0;
                case 2: goto L_0x039e;
                case 3: goto L_0x039b;
                case 4: goto L_0x0398;
                case 5: goto L_0x0395;
                case 6: goto L_0x0392;
                case 7: goto L_0x038f;
                case 8: goto L_0x038c;
                case 9: goto L_0x0389;
                case 10: goto L_0x0386;
                case 11: goto L_0x0383;
                case 12: goto L_0x0380;
                case 13: goto L_0x037d;
                case 14: goto L_0x037a;
                case 15: goto L_0x0376;
                case 16: goto L_0x0373;
                case 17: goto L_0x0370;
                case 18: goto L_0x036d;
                case 19: goto L_0x036a;
                case 20: goto L_0x0367;
                case 21: goto L_0x0364;
                case 22: goto L_0x0361;
                case 23: goto L_0x035e;
                default: goto L_0x035c;
            }
        L_0x035c:
            r1 = -1
            goto L_0x03a3
        L_0x035e:
            r1 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x03a3
        L_0x0361:
            r1 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x03a3
        L_0x0364:
            r1 = 2097152(0x200000, float:2.938736E-39)
            goto L_0x03a3
        L_0x0367:
            r1 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x03a3
        L_0x036a:
            r1 = 524288(0x80000, float:7.34684E-40)
            goto L_0x03a3
        L_0x036d:
            r1 = 262144(0x40000, float:3.67342E-40)
            goto L_0x03a3
        L_0x0370:
            r1 = 131072(0x20000, float:1.83671E-40)
            goto L_0x03a3
        L_0x0373:
            r1 = 65536(0x10000, float:9.18355E-41)
            goto L_0x03a3
        L_0x0376:
            r1 = 32768(0x8000, float:4.5918E-41)
            goto L_0x03a3
        L_0x037a:
            r1 = 16384(0x4000, float:2.2959E-41)
            goto L_0x03a3
        L_0x037d:
            r1 = 8192(0x2000, float:1.14794E-41)
            goto L_0x03a3
        L_0x0380:
            r1 = 4096(0x1000, float:5.74E-42)
            goto L_0x03a3
        L_0x0383:
            r1 = 2048(0x800, float:2.87E-42)
            goto L_0x03a3
        L_0x0386:
            r1 = 1024(0x400, float:1.435E-42)
            goto L_0x03a3
        L_0x0389:
            r1 = 512(0x200, float:7.175E-43)
            goto L_0x03a3
        L_0x038c:
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x03a3
        L_0x038f:
            r1 = 128(0x80, float:1.794E-43)
            goto L_0x03a3
        L_0x0392:
            r1 = 64
            goto L_0x03a3
        L_0x0395:
            r1 = 32
            goto L_0x03a3
        L_0x0398:
            r1 = 16
            goto L_0x03a3
        L_0x039b:
            r1 = 8
            goto L_0x03a3
        L_0x039e:
            r1 = 4
            goto L_0x03a3
        L_0x03a0:
            r1 = 2
            goto L_0x03a3
        L_0x03a2:
            r1 = 1
        L_0x03a3:
            r2 = -1
            if (r1 != r2) goto L_0x03bc
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown AV1 level: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
            goto L_0x02f8
        L_0x03bc:
            android.util.Pair r2 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2.<init>(r0, r1)
            goto L_0x03d9
        L_0x03ca:
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r1 = "Ignoring malformed AV1 codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
            goto L_0x02f8
        L_0x03d9:
            return r2
        L_0x03da:
            java.lang.String r2 = r0.zzj
            com.google.android.gms.internal.ads.zzs r0 = r0.zzy
            int r5 = r1.length
            if (r5 >= r12) goto L_0x03f1
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r1 = "Ignoring malformed HEVC codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
        L_0x03ee:
            r2 = 0
            goto L_0x0645
        L_0x03f1:
            java.util.regex.Pattern r5 = zzb
            r8 = r1[r6]
            java.util.regex.Matcher r5 = r5.matcher(r8)
            boolean r8 = r5.matches()
            if (r8 != 0) goto L_0x040d
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r1 = "Ignoring malformed HEVC codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
            goto L_0x03ee
        L_0x040d:
            java.lang.String r2 = r5.group(r6)
            java.lang.String r5 = "1"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x041c
            r0 = 1
        L_0x041a:
            r2 = 3
            goto L_0x0430
        L_0x041c:
            java.lang.String r5 = "2"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x0636
            if (r0 == 0) goto L_0x042e
            int r0 = r0.zzf
            r2 = 6
            if (r0 != r2) goto L_0x042e
            r0 = 4096(0x1000, float:5.74E-42)
            goto L_0x041a
        L_0x042e:
            r0 = 2
            goto L_0x041a
        L_0x0430:
            r1 = r1[r2]
            if (r1 != 0) goto L_0x0437
        L_0x0434:
            r2 = 0
            goto L_0x061a
        L_0x0437:
            int r2 = r1.hashCode()
            switch(r2) {
                case 70821: goto L_0x055b;
                case 70914: goto L_0x0550;
                case 70917: goto L_0x0545;
                case 71007: goto L_0x053a;
                case 71010: goto L_0x052f;
                case 74665: goto L_0x0525;
                case 74758: goto L_0x051b;
                case 74761: goto L_0x0511;
                case 74851: goto L_0x0507;
                case 74854: goto L_0x04fd;
                case 2193639: goto L_0x04f1;
                case 2193642: goto L_0x04e5;
                case 2193732: goto L_0x04d9;
                case 2193735: goto L_0x04cd;
                case 2193738: goto L_0x04c1;
                case 2193825: goto L_0x04b5;
                case 2193828: goto L_0x04a9;
                case 2193831: goto L_0x049d;
                case 2312803: goto L_0x0492;
                case 2312806: goto L_0x0487;
                case 2312896: goto L_0x047c;
                case 2312899: goto L_0x0470;
                case 2312902: goto L_0x0464;
                case 2312989: goto L_0x0458;
                case 2312992: goto L_0x044c;
                case 2312995: goto L_0x0440;
                default: goto L_0x043e;
            }
        L_0x043e:
            goto L_0x0566
        L_0x0440:
            java.lang.String r2 = "L186"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 12
            goto L_0x0567
        L_0x044c:
            java.lang.String r2 = "L183"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 11
            goto L_0x0567
        L_0x0458:
            java.lang.String r2 = "L180"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 10
            goto L_0x0567
        L_0x0464:
            java.lang.String r2 = "L156"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 9
            goto L_0x0567
        L_0x0470:
            java.lang.String r2 = "L153"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 8
            goto L_0x0567
        L_0x047c:
            java.lang.String r2 = "L150"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 7
            goto L_0x0567
        L_0x0487:
            java.lang.String r2 = "L123"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 6
            goto L_0x0567
        L_0x0492:
            java.lang.String r2 = "L120"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 5
            goto L_0x0567
        L_0x049d:
            java.lang.String r2 = "H186"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 25
            goto L_0x0567
        L_0x04a9:
            java.lang.String r2 = "H183"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 24
            goto L_0x0567
        L_0x04b5:
            java.lang.String r2 = "H180"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 23
            goto L_0x0567
        L_0x04c1:
            java.lang.String r2 = "H156"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 22
            goto L_0x0567
        L_0x04cd:
            java.lang.String r2 = "H153"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 21
            goto L_0x0567
        L_0x04d9:
            java.lang.String r2 = "H150"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 20
            goto L_0x0567
        L_0x04e5:
            java.lang.String r2 = "H123"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 19
            goto L_0x0567
        L_0x04f1:
            java.lang.String r2 = "H120"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 18
            goto L_0x0567
        L_0x04fd:
            java.lang.String r2 = "L93"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 4
            goto L_0x0567
        L_0x0507:
            java.lang.String r2 = "L90"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 3
            goto L_0x0567
        L_0x0511:
            java.lang.String r2 = "L63"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 2
            goto L_0x0567
        L_0x051b:
            java.lang.String r2 = "L60"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 1
            goto L_0x0567
        L_0x0525:
            java.lang.String r2 = "L30"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 0
            goto L_0x0567
        L_0x052f:
            java.lang.String r2 = "H93"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 17
            goto L_0x0567
        L_0x053a:
            java.lang.String r2 = "H90"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 16
            goto L_0x0567
        L_0x0545:
            java.lang.String r2 = "H63"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 15
            goto L_0x0567
        L_0x0550:
            java.lang.String r2 = "H60"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 14
            goto L_0x0567
        L_0x055b:
            java.lang.String r2 = "H30"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0566
            r5 = 13
            goto L_0x0567
        L_0x0566:
            r5 = -1
        L_0x0567:
            switch(r5) {
                case 0: goto L_0x0616;
                case 1: goto L_0x0611;
                case 2: goto L_0x060a;
                case 3: goto L_0x0603;
                case 4: goto L_0x05fc;
                case 5: goto L_0x05f5;
                case 6: goto L_0x05f0;
                case 7: goto L_0x05e9;
                case 8: goto L_0x05e2;
                case 9: goto L_0x05db;
                case 10: goto L_0x05d4;
                case 11: goto L_0x05cd;
                case 12: goto L_0x05c6;
                case 13: goto L_0x05c1;
                case 14: goto L_0x05bc;
                case 15: goto L_0x05b7;
                case 16: goto L_0x05b1;
                case 17: goto L_0x05ab;
                case 18: goto L_0x05a3;
                case 19: goto L_0x059d;
                case 20: goto L_0x0594;
                case 21: goto L_0x058c;
                case 22: goto L_0x0584;
                case 23: goto L_0x057c;
                case 24: goto L_0x0574;
                case 25: goto L_0x056c;
                default: goto L_0x056a;
            }
        L_0x056a:
            goto L_0x0434
        L_0x056c:
            r2 = 33554432(0x2000000, float:9.403955E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x061a
        L_0x0574:
            r2 = 8388608(0x800000, float:1.17549435E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x061a
        L_0x057c:
            r2 = 2097152(0x200000, float:2.938736E-39)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x061a
        L_0x0584:
            r2 = 524288(0x80000, float:7.34684E-40)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x061a
        L_0x058c:
            r2 = 131072(0x20000, float:1.83671E-40)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x061a
        L_0x0594:
            r2 = 32768(0x8000, float:4.5918E-41)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x061a
        L_0x059d:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            goto L_0x061a
        L_0x05a3:
            r2 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x061a
        L_0x05ab:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x061a
        L_0x05b1:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)
            goto L_0x061a
        L_0x05b7:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            goto L_0x061a
        L_0x05bc:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)
            goto L_0x061a
        L_0x05c1:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            goto L_0x061a
        L_0x05c6:
            r2 = 16777216(0x1000000, float:2.3509887E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x061a
        L_0x05cd:
            r2 = 4194304(0x400000, float:5.877472E-39)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x061a
        L_0x05d4:
            r2 = 1048576(0x100000, float:1.469368E-39)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x061a
        L_0x05db:
            r2 = 262144(0x40000, float:3.67342E-40)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x061a
        L_0x05e2:
            r2 = 65536(0x10000, float:9.18355E-41)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x061a
        L_0x05e9:
            r2 = 16384(0x4000, float:2.2959E-41)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x061a
        L_0x05f0:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)
            goto L_0x061a
        L_0x05f5:
            r5 = 1024(0x400, float:1.435E-42)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            goto L_0x061a
        L_0x05fc:
            r8 = 256(0x100, float:3.59E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            goto L_0x061a
        L_0x0603:
            r16 = 64
            java.lang.Integer r2 = java.lang.Integer.valueOf(r16)
            goto L_0x061a
        L_0x060a:
            r2 = 16
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x061a
        L_0x0611:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
            goto L_0x061a
        L_0x0616:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
        L_0x061a:
            if (r2 != 0) goto L_0x062b
            java.lang.String r0 = java.lang.String.valueOf(r1)
            java.lang.String r1 = "Unknown HEVC level string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
            goto L_0x03ee
        L_0x062b:
            android.util.Pair r1 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.<init>(r0, r2)
            r2 = r1
            goto L_0x0645
        L_0x0636:
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r1 = "Unknown HEVC profile string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
            goto L_0x03ee
        L_0x0645:
            return r2
        L_0x0646:
            r2 = 2048(0x800, float:2.87E-42)
            r16 = 64
            java.lang.String r0 = r0.zzj
            int r5 = r1.length
            r2 = 3
            if (r5 >= r2) goto L_0x0660
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed VP9 codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
        L_0x065d:
            r2 = 0
            goto L_0x0727
        L_0x0660:
            r2 = r1[r6]     // Catch:{ NumberFormatException -> 0x0718 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0718 }
            r1 = r1[r13]     // Catch:{ NumberFormatException -> 0x0718 }
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0718 }
            if (r2 == 0) goto L_0x067e
            if (r2 == r6) goto L_0x067c
            if (r2 == r13) goto L_0x067a
            r1 = 3
            if (r2 == r1) goto L_0x0677
            r1 = -1
            goto L_0x067f
        L_0x0677:
            r1 = 8
            goto L_0x067f
        L_0x067a:
            r1 = 4
            goto L_0x067f
        L_0x067c:
            r1 = 2
            goto L_0x067f
        L_0x067e:
            r1 = 1
        L_0x067f:
            r5 = -1
            if (r1 != r5) goto L_0x0697
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown VP9 profile: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
            goto L_0x065d
        L_0x0697:
            r2 = 10
            if (r0 == r2) goto L_0x06f1
            r2 = 11
            if (r0 == r2) goto L_0x06ee
            if (r0 == r10) goto L_0x06eb
            r2 = 21
            if (r0 == r2) goto L_0x06e7
            r2 = 30
            if (r0 == r2) goto L_0x06e3
            r2 = 31
            if (r0 == r2) goto L_0x06df
            r2 = 40
            if (r0 == r2) goto L_0x06db
            r2 = 41
            if (r0 == r2) goto L_0x06d7
            r2 = 50
            if (r0 == r2) goto L_0x06d3
            r2 = 51
            if (r0 == r2) goto L_0x06cf
            switch(r0) {
                case 60: goto L_0x06cb;
                case 61: goto L_0x06c7;
                case 62: goto L_0x06c3;
                default: goto L_0x06c0;
            }
        L_0x06c0:
            r2 = -1
            r6 = -1
            goto L_0x06f2
        L_0x06c3:
            r2 = -1
            r6 = 8192(0x2000, float:1.14794E-41)
            goto L_0x06f2
        L_0x06c7:
            r2 = -1
            r6 = 4096(0x1000, float:5.74E-42)
            goto L_0x06f2
        L_0x06cb:
            r2 = -1
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x06f2
        L_0x06cf:
            r2 = -1
            r6 = 512(0x200, float:7.175E-43)
            goto L_0x06f2
        L_0x06d3:
            r2 = -1
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x06f2
        L_0x06d7:
            r2 = -1
            r6 = 128(0x80, float:1.794E-43)
            goto L_0x06f2
        L_0x06db:
            r2 = -1
            r6 = 64
            goto L_0x06f2
        L_0x06df:
            r2 = -1
            r6 = 32
            goto L_0x06f2
        L_0x06e3:
            r2 = -1
            r6 = 16
            goto L_0x06f2
        L_0x06e7:
            r2 = -1
            r6 = 8
            goto L_0x06f2
        L_0x06eb:
            r2 = -1
            r6 = 4
            goto L_0x06f2
        L_0x06ee:
            r2 = -1
            r6 = 2
            goto L_0x06f2
        L_0x06f1:
            r2 = -1
        L_0x06f2:
            if (r6 != r2) goto L_0x070a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown VP9 level: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
            goto L_0x065d
        L_0x070a:
            android.util.Pair r2 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            r2.<init>(r0, r1)
            goto L_0x0727
        L_0x0718:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed VP9 codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
            goto L_0x065d
        L_0x0727:
            return r2
        L_0x0728:
            r5 = 1024(0x400, float:1.435E-42)
            r16 = 64
            java.lang.String r0 = r0.zzj
            int r2 = r1.length
            if (r2 >= r13) goto L_0x0741
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed AVC codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
        L_0x073e:
            r2 = 0
            goto L_0x084c
        L_0x0741:
            r10 = r1[r6]     // Catch:{ NumberFormatException -> 0x083d }
            int r10 = r10.length()     // Catch:{ NumberFormatException -> 0x083d }
            r3 = 6
            if (r10 != r3) goto L_0x0762
            r2 = r1[r6]     // Catch:{ NumberFormatException -> 0x083d }
            r3 = 0
            java.lang.String r2 = r2.substring(r3, r13)     // Catch:{ NumberFormatException -> 0x083d }
            r3 = 16
            int r2 = java.lang.Integer.parseInt(r2, r3)     // Catch:{ NumberFormatException -> 0x083d }
            r1 = r1[r6]     // Catch:{ NumberFormatException -> 0x083d }
            java.lang.String r1 = r1.substring(r12)     // Catch:{ NumberFormatException -> 0x083d }
            int r0 = java.lang.Integer.parseInt(r1, r3)     // Catch:{ NumberFormatException -> 0x083d }
            goto L_0x0773
        L_0x0762:
            r3 = 16
            r10 = 3
            if (r2 < r10) goto L_0x0827
            r2 = r1[r6]     // Catch:{ NumberFormatException -> 0x083d }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x083d }
            r1 = r1[r13]     // Catch:{ NumberFormatException -> 0x083d }
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x083d }
        L_0x0773:
            r1 = 66
            if (r2 == r1) goto L_0x07a7
            r1 = 77
            if (r2 == r1) goto L_0x07a5
            r1 = 88
            if (r2 == r1) goto L_0x07a2
            r1 = 100
            if (r2 == r1) goto L_0x079e
            r1 = 110(0x6e, float:1.54E-43)
            if (r2 == r1) goto L_0x079a
            r1 = 122(0x7a, float:1.71E-43)
            if (r2 == r1) goto L_0x0796
            r1 = 244(0xf4, float:3.42E-43)
            if (r2 == r1) goto L_0x0792
            r1 = -1
            r13 = -1
            goto L_0x07a9
        L_0x0792:
            r1 = -1
            r13 = 64
            goto L_0x07a9
        L_0x0796:
            r1 = -1
            r13 = 32
            goto L_0x07a9
        L_0x079a:
            r1 = -1
            r13 = 16
            goto L_0x07a9
        L_0x079e:
            r1 = -1
            r13 = 8
            goto L_0x07a9
        L_0x07a2:
            r1 = -1
            r13 = 4
            goto L_0x07a9
        L_0x07a5:
            r1 = -1
            goto L_0x07a9
        L_0x07a7:
            r1 = -1
            r13 = 1
        L_0x07a9:
            if (r13 != r1) goto L_0x07c1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown AVC profile: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
            goto L_0x073e
        L_0x07c1:
            switch(r0) {
                case 10: goto L_0x07ff;
                case 11: goto L_0x07fd;
                case 12: goto L_0x07fa;
                case 13: goto L_0x07f7;
                default: goto L_0x07c4;
            }
        L_0x07c4:
            switch(r0) {
                case 20: goto L_0x07f4;
                case 21: goto L_0x07f1;
                case 22: goto L_0x07ee;
                default: goto L_0x07c7;
            }
        L_0x07c7:
            switch(r0) {
                case 30: goto L_0x07eb;
                case 31: goto L_0x07e8;
                case 32: goto L_0x07e5;
                default: goto L_0x07ca;
            }
        L_0x07ca:
            switch(r0) {
                case 40: goto L_0x07e2;
                case 41: goto L_0x07df;
                case 42: goto L_0x07dc;
                default: goto L_0x07cd;
            }
        L_0x07cd:
            switch(r0) {
                case 50: goto L_0x07d9;
                case 51: goto L_0x07d5;
                case 52: goto L_0x07d2;
                default: goto L_0x07d0;
            }
        L_0x07d0:
            r1 = -1
            goto L_0x0800
        L_0x07d2:
            r1 = 65536(0x10000, float:9.18355E-41)
            goto L_0x0800
        L_0x07d5:
            r1 = 32768(0x8000, float:4.5918E-41)
            goto L_0x0800
        L_0x07d9:
            r1 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0800
        L_0x07dc:
            r1 = 8192(0x2000, float:1.14794E-41)
            goto L_0x0800
        L_0x07df:
            r1 = 4096(0x1000, float:5.74E-42)
            goto L_0x0800
        L_0x07e2:
            r1 = 2048(0x800, float:2.87E-42)
            goto L_0x0800
        L_0x07e5:
            r1 = 1024(0x400, float:1.435E-42)
            goto L_0x0800
        L_0x07e8:
            r1 = 512(0x200, float:7.175E-43)
            goto L_0x0800
        L_0x07eb:
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x0800
        L_0x07ee:
            r1 = 128(0x80, float:1.794E-43)
            goto L_0x0800
        L_0x07f1:
            r1 = 64
            goto L_0x0800
        L_0x07f4:
            r1 = 32
            goto L_0x0800
        L_0x07f7:
            r1 = 16
            goto L_0x0800
        L_0x07fa:
            r1 = 8
            goto L_0x0800
        L_0x07fd:
            r1 = 4
            goto L_0x0800
        L_0x07ff:
            r1 = 1
        L_0x0800:
            r2 = -1
            if (r1 != r2) goto L_0x0819
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown AVC level: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
            goto L_0x073e
        L_0x0819:
            android.util.Pair r2 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2.<init>(r0, r1)
            goto L_0x084c
        L_0x0827:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x083d }
            r1.<init>()     // Catch:{ NumberFormatException -> 0x083d }
            java.lang.String r2 = "Ignoring malformed AVC codec string: "
            r1.append(r2)     // Catch:{ NumberFormatException -> 0x083d }
            r1.append(r0)     // Catch:{ NumberFormatException -> 0x083d }
            java.lang.String r1 = r1.toString()     // Catch:{ NumberFormatException -> 0x083d }
            com.google.android.gms.internal.ads.zzer.zzf(r4, r1)     // Catch:{ NumberFormatException -> 0x083d }
            goto L_0x073e
        L_0x083d:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed AVC codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzer.zzf(r4, r0)
            goto L_0x073e
        L_0x084c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsl.zzb(com.google.android.gms.internal.ads.zzam):android.util.Pair");
    }

    public static zzrs zzc(String str, boolean z2, boolean z3) throws zzsf {
        List zzg = zzg(str, false, false);
        if (zzg.isEmpty()) {
            return null;
        }
        return (zzrs) zzg.get(0);
    }

    public static zzrs zzd() throws zzsf {
        return zzc("audio/raw", false, false);
    }

    public static String zze(zzam zzam) {
        Pair zzb2;
        if ("audio/eac3-joc".equals(zzam.zzm)) {
            return "audio/eac3";
        }
        if (!"video/dolby-vision".equals(zzam.zzm) || (zzb2 = zzb(zzam)) == null) {
            return null;
        }
        int intValue = ((Integer) zzb2.first).intValue();
        if (intValue == 16 || intValue == 256) {
            return MimeTypes.VIDEO_H265;
        }
        if (intValue == 512) {
            return MimeTypes.VIDEO_H264;
        }
        return null;
    }

    public static List zzf(zzry zzry, zzam zzam, boolean z2, boolean z3) throws zzsf {
        String zze = zze(zzam);
        if (zze == null) {
            return zzfsc.zzl();
        }
        return zzg(zze, z2, z3);
    }

    public static synchronized List zzg(String str, boolean z2, boolean z3) throws zzsf {
        zzsg zzsg;
        String str2 = str;
        boolean z4 = z2;
        boolean z5 = z3;
        synchronized (zzsl.class) {
            zzsd zzsd = new zzsd(str2, z4, z5);
            HashMap hashMap = zzc;
            List list = (List) hashMap.get(zzsd);
            if (list != null) {
                return list;
            }
            int i2 = zzfj.zza;
            if (i2 >= 21) {
                zzsg = new zzsj(z4, z5);
            } else {
                zzsg = new zzsi((zzsh) null);
            }
            ArrayList zzj = zzj(zzsd, zzsg);
            if (z4 && zzj.isEmpty() && i2 >= 21 && i2 <= 23) {
                zzj = zzj(zzsd, new zzsi((zzsh) null));
                if (!zzj.isEmpty()) {
                    String str3 = ((zzrs) zzj.get(0)).zza;
                    zzer.zzf("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str2 + ". Assuming: " + str3);
                }
            }
            if ("audio/raw".equals(str2)) {
                if (i2 < 26 && zzfj.zzb.equals("R9") && zzj.size() == 1 && ((zzrs) zzj.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    zzj.add(zzrs.zzc("OMX.google.raw.decoder", "audio/raw", "audio/raw", (MediaCodecInfo.CodecCapabilities) null, false, true, false, false, false));
                }
                zzk(zzj, zzsb.zza);
            }
            if (i2 < 21 && zzj.size() > 1) {
                String str4 = ((zzrs) zzj.get(0)).zza;
                if ("OMX.SEC.mp3.dec".equals(str4) || "OMX.SEC.MP3.Decoder".equals(str4) || "OMX.brcm.audio.mp3.decoder".equals(str4)) {
                    zzk(zzj, zzsc.zza);
                }
            }
            if (i2 < 32 && zzj.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzrs) zzj.get(0)).zza)) {
                zzj.add((zzrs) zzj.remove(0));
            }
            zzfsc zzj2 = zzfsc.zzj(zzj);
            hashMap.put(zzsd, zzj2);
            return zzj2;
        }
    }

    @RequiresNonNull({"#2.sampleMimeType"})
    public static List zzh(zzry zzry, zzam zzam, boolean z2, boolean z3) throws zzsf {
        List zzg = zzg(zzam.zzm, z2, z3);
        List zzf = zzf(zzry, zzam, z2, z3);
        zzfrz zzfrz = new zzfrz();
        zzfrz.zzh(zzg);
        zzfrz.zzh(zzf);
        return zzfrz.zzi();
    }

    public static List zzi(List list, zzam zzam) {
        ArrayList arrayList = new ArrayList(list);
        zzk(arrayList, new zzrz(zzam));
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r20v2 */
    /* JADX WARNING: type inference failed for: r20v3 */
    /* JADX WARNING: type inference failed for: r20v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0233, code lost:
        if (r1.zzb == false) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        if (r12.endsWith(".secure") == false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00da, code lost:
        if ("SCV31".equals(r10) == false) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0118, code lost:
        if (r8.startsWith("t0") == false) goto L_0x011a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x02b0 A[SYNTHETIC, Splitter:B:183:0x02b0] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x02d0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList zzj(com.google.android.gms.internal.ads.zzsd r27, com.google.android.gms.internal.ads.zzsg r28) throws com.google.android.gms.internal.ads.zzsf {
        /*
            r1 = r27
            r2 = r28
            java.lang.String r3 = "secure-playback"
            java.lang.String r4 = "tunneled-playback"
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x02ff }
            r6.<init>()     // Catch:{ Exception -> 0x02ff }
            java.lang.String r15 = r1.zza     // Catch:{ Exception -> 0x02ff }
            int r14 = r28.zza()     // Catch:{ Exception -> 0x02ff }
            boolean r16 = r28.zze()     // Catch:{ Exception -> 0x02ff }
            r17 = 0
            r13 = 0
        L_0x001a:
            if (r13 >= r14) goto L_0x02fe
            android.media.MediaCodecInfo r0 = r2.zzb(r13)     // Catch:{ Exception -> 0x02ff }
            int r7 = com.google.android.gms.internal.ads.zzfj.zza     // Catch:{ Exception -> 0x02ff }
            r8 = 29
            if (r7 < r8) goto L_0x0034
            boolean r9 = r0.isAlias()     // Catch:{ Exception -> 0x02ff }
            if (r9 == 0) goto L_0x0034
        L_0x002c:
            r24 = r13
            r25 = r14
            r26 = r15
            goto L_0x02f4
        L_0x0034:
            java.lang.String r12 = r0.getName()     // Catch:{ Exception -> 0x02ff }
            boolean r9 = r0.isEncoder()     // Catch:{ Exception -> 0x02ff }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = ".secure"
            if (r16 != 0) goto L_0x0048
            boolean r10 = r12.endsWith(r9)     // Catch:{ Exception -> 0x02ff }
            if (r10 != 0) goto L_0x002c
        L_0x0048:
            r10 = 21
            if (r7 >= r10) goto L_0x007c
            java.lang.String r10 = "CIPAACDecoder"
            boolean r10 = r10.equals(r12)     // Catch:{ Exception -> 0x02ff }
            if (r10 != 0) goto L_0x002c
            java.lang.String r10 = "CIPMP3Decoder"
            boolean r10 = r10.equals(r12)     // Catch:{ Exception -> 0x02ff }
            if (r10 != 0) goto L_0x002c
            java.lang.String r10 = "CIPVorbisDecoder"
            boolean r10 = r10.equals(r12)     // Catch:{ Exception -> 0x02ff }
            if (r10 != 0) goto L_0x002c
            java.lang.String r10 = "CIPAMRNBDecoder"
            boolean r10 = r10.equals(r12)     // Catch:{ Exception -> 0x02ff }
            if (r10 != 0) goto L_0x002c
            java.lang.String r10 = "AACDecoder"
            boolean r10 = r10.equals(r12)     // Catch:{ Exception -> 0x02ff }
            if (r10 != 0) goto L_0x002c
            java.lang.String r10 = "MP3Decoder"
            boolean r10 = r10.equals(r12)     // Catch:{ Exception -> 0x02ff }
            if (r10 != 0) goto L_0x002c
        L_0x007c:
            r10 = 24
            java.lang.String r11 = "samsung"
            if (r7 >= r10) goto L_0x00dc
            java.lang.String r10 = "OMX.SEC.aac.dec"
            boolean r10 = r10.equals(r12)     // Catch:{ Exception -> 0x02ff }
            if (r10 != 0) goto L_0x0092
            java.lang.String r10 = "OMX.Exynos.AAC.Decoder"
            boolean r10 = r10.equals(r12)     // Catch:{ Exception -> 0x02ff }
            if (r10 == 0) goto L_0x00dc
        L_0x0092:
            java.lang.String r10 = com.google.android.gms.internal.ads.zzfj.zzc     // Catch:{ Exception -> 0x02ff }
            boolean r10 = r11.equals(r10)     // Catch:{ Exception -> 0x02ff }
            if (r10 == 0) goto L_0x00dc
            java.lang.String r10 = com.google.android.gms.internal.ads.zzfj.zzb     // Catch:{ Exception -> 0x02ff }
            java.lang.String r5 = "zeroflte"
            boolean r5 = r10.startsWith(r5)     // Catch:{ Exception -> 0x02ff }
            if (r5 != 0) goto L_0x002c
            java.lang.String r5 = "zerolte"
            boolean r5 = r10.startsWith(r5)     // Catch:{ Exception -> 0x02ff }
            if (r5 != 0) goto L_0x002c
            java.lang.String r5 = "zenlte"
            boolean r5 = r10.startsWith(r5)     // Catch:{ Exception -> 0x02ff }
            if (r5 != 0) goto L_0x002c
            java.lang.String r5 = "SC-05G"
            boolean r5 = r5.equals(r10)     // Catch:{ Exception -> 0x02ff }
            if (r5 != 0) goto L_0x002c
            java.lang.String r5 = "marinelteatt"
            boolean r5 = r5.equals(r10)     // Catch:{ Exception -> 0x02ff }
            if (r5 != 0) goto L_0x002c
            java.lang.String r5 = "404SC"
            boolean r5 = r5.equals(r10)     // Catch:{ Exception -> 0x02ff }
            if (r5 != 0) goto L_0x002c
            java.lang.String r5 = "SC-04G"
            boolean r5 = r5.equals(r10)     // Catch:{ Exception -> 0x02ff }
            if (r5 != 0) goto L_0x002c
            java.lang.String r5 = "SCV31"
            boolean r5 = r5.equals(r10)     // Catch:{ Exception -> 0x02ff }
            if (r5 != 0) goto L_0x002c
        L_0x00dc:
            java.lang.String r5 = "jflte"
            r10 = 19
            if (r7 > r10) goto L_0x011a
            java.lang.String r8 = "OMX.SEC.vp8.dec"
            boolean r8 = r8.equals(r12)     // Catch:{ Exception -> 0x02ff }
            if (r8 == 0) goto L_0x011a
            java.lang.String r8 = com.google.android.gms.internal.ads.zzfj.zzc     // Catch:{ Exception -> 0x02ff }
            boolean r8 = r11.equals(r8)     // Catch:{ Exception -> 0x02ff }
            if (r8 == 0) goto L_0x011a
            java.lang.String r8 = com.google.android.gms.internal.ads.zzfj.zzb     // Catch:{ Exception -> 0x02ff }
            java.lang.String r11 = "d2"
            boolean r11 = r8.startsWith(r11)     // Catch:{ Exception -> 0x02ff }
            if (r11 != 0) goto L_0x002c
            java.lang.String r11 = "serrano"
            boolean r11 = r8.startsWith(r11)     // Catch:{ Exception -> 0x02ff }
            if (r11 != 0) goto L_0x002c
            boolean r11 = r8.startsWith(r5)     // Catch:{ Exception -> 0x02ff }
            if (r11 != 0) goto L_0x002c
            java.lang.String r11 = "santos"
            boolean r11 = r8.startsWith(r11)     // Catch:{ Exception -> 0x02ff }
            if (r11 != 0) goto L_0x002c
            java.lang.String r11 = "t0"
            boolean r8 = r8.startsWith(r11)     // Catch:{ Exception -> 0x02ff }
            if (r8 != 0) goto L_0x002c
        L_0x011a:
            if (r7 > r10) goto L_0x012c
            java.lang.String r8 = com.google.android.gms.internal.ads.zzfj.zzb     // Catch:{ Exception -> 0x02ff }
            boolean r5 = r8.startsWith(r5)     // Catch:{ Exception -> 0x02ff }
            if (r5 == 0) goto L_0x012c
            java.lang.String r5 = "OMX.qcom.video.decoder.vp8"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x02ff }
            if (r5 != 0) goto L_0x002c
        L_0x012c:
            r5 = 23
            if (r7 > r5) goto L_0x0140
            java.lang.String r7 = "audio/eac3-joc"
            boolean r7 = r7.equals(r15)     // Catch:{ Exception -> 0x02ff }
            if (r7 == 0) goto L_0x0140
            java.lang.String r7 = "OMX.MTK.AUDIO.DECODER.DSPAC3"
            boolean r7 = r7.equals(r12)     // Catch:{ Exception -> 0x02ff }
            if (r7 != 0) goto L_0x002c
        L_0x0140:
            java.lang.String[] r7 = r0.getSupportedTypes()     // Catch:{ Exception -> 0x02ff }
            int r8 = r7.length     // Catch:{ Exception -> 0x02ff }
            r10 = 0
        L_0x0146:
            if (r10 >= r8) goto L_0x0154
            r11 = r7[r10]     // Catch:{ Exception -> 0x02ff }
            boolean r19 = r11.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x02ff }
            if (r19 == 0) goto L_0x0151
            goto L_0x01b4
        L_0x0151:
            int r10 = r10 + 1
            goto L_0x0146
        L_0x0154:
            java.lang.String r7 = "video/dolby-vision"
            boolean r7 = r15.equals(r7)     // Catch:{ Exception -> 0x02ff }
            if (r7 == 0) goto L_0x017a
            java.lang.String r7 = "OMX.MS.HEVCDV.Decoder"
            boolean r7 = r7.equals(r12)     // Catch:{ Exception -> 0x02ff }
            if (r7 == 0) goto L_0x0167
            java.lang.String r11 = "video/hevcdv"
            goto L_0x01b4
        L_0x0167:
            java.lang.String r7 = "OMX.RTK.video.decoder"
            boolean r7 = r7.equals(r12)     // Catch:{ Exception -> 0x02ff }
            if (r7 != 0) goto L_0x0177
            java.lang.String r7 = "OMX.realtek.video.decoder.tunneled"
            boolean r7 = r7.equals(r12)     // Catch:{ Exception -> 0x02ff }
            if (r7 == 0) goto L_0x01b3
        L_0x0177:
            java.lang.String r11 = "video/dv_hevc"
            goto L_0x01b4
        L_0x017a:
            java.lang.String r7 = "audio/alac"
            boolean r7 = r15.equals(r7)     // Catch:{ Exception -> 0x02ff }
            if (r7 == 0) goto L_0x018d
            java.lang.String r7 = "OMX.lge.alac.decoder"
            boolean r7 = r7.equals(r12)     // Catch:{ Exception -> 0x02ff }
            if (r7 == 0) goto L_0x018d
            java.lang.String r11 = "audio/x-lg-alac"
            goto L_0x01b4
        L_0x018d:
            java.lang.String r7 = "audio/flac"
            boolean r7 = r15.equals(r7)     // Catch:{ Exception -> 0x02ff }
            if (r7 == 0) goto L_0x01a0
            java.lang.String r7 = "OMX.lge.flac.decoder"
            boolean r7 = r7.equals(r12)     // Catch:{ Exception -> 0x02ff }
            if (r7 == 0) goto L_0x01a0
            java.lang.String r11 = "audio/x-lg-flac"
            goto L_0x01b4
        L_0x01a0:
            java.lang.String r7 = "audio/ac3"
            boolean r7 = r15.equals(r7)     // Catch:{ Exception -> 0x02ff }
            if (r7 == 0) goto L_0x01b3
            java.lang.String r7 = "OMX.lge.ac3.decoder"
            boolean r7 = r7.equals(r12)     // Catch:{ Exception -> 0x02ff }
            if (r7 == 0) goto L_0x01b3
            java.lang.String r11 = "audio/lg-ac3"
            goto L_0x01b4
        L_0x01b3:
            r11 = 0
        L_0x01b4:
            if (r11 == 0) goto L_0x002c
            android.media.MediaCodecInfo$CodecCapabilities r10 = r0.getCapabilitiesForType(r11)     // Catch:{ Exception -> 0x029e }
            boolean r7 = r2.zzd(r4, r11, r10)     // Catch:{ Exception -> 0x029e }
            boolean r8 = r2.zzc(r4, r11, r10)     // Catch:{ Exception -> 0x029e }
            boolean r5 = r1.zzc     // Catch:{ Exception -> 0x029e }
            if (r5 != 0) goto L_0x01c9
            if (r8 != 0) goto L_0x002c
            goto L_0x01cd
        L_0x01c9:
            if (r7 != 0) goto L_0x01cd
            goto L_0x002c
        L_0x01cd:
            boolean r5 = r2.zzd(r3, r11, r10)     // Catch:{ Exception -> 0x029e }
            boolean r7 = r2.zzc(r3, r11, r10)     // Catch:{ Exception -> 0x029e }
            boolean r8 = r1.zzb     // Catch:{ Exception -> 0x029e }
            r20 = 1
            if (r8 != 0) goto L_0x01de
            if (r7 != 0) goto L_0x002c
            goto L_0x01e1
        L_0x01de:
            if (r5 == 0) goto L_0x002c
            r5 = 1
        L_0x01e1:
            int r7 = com.google.android.gms.internal.ads.zzfj.zza     // Catch:{ Exception -> 0x029e }
            r8 = 29
            if (r7 < r8) goto L_0x01ee
            boolean r8 = r0.isHardwareAccelerated()     // Catch:{ Exception -> 0x029e }
            r21 = r8
            goto L_0x01f9
        L_0x01ee:
            boolean r8 = zzl(r0, r15)     // Catch:{ Exception -> 0x029e }
            if (r8 != 0) goto L_0x01f7
            r21 = 1
            goto L_0x01f9
        L_0x01f7:
            r21 = 0
        L_0x01f9:
            boolean r22 = zzl(r0, r15)     // Catch:{ Exception -> 0x029e }
            r8 = 29
            if (r7 < r8) goto L_0x0206
            boolean r0 = r0.isVendor()     // Catch:{ Exception -> 0x029e }
            goto L_0x0229
        L_0x0206:
            java.lang.String r0 = r0.getName()     // Catch:{ Exception -> 0x029e }
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfon.zza(r0)     // Catch:{ Exception -> 0x029e }
            java.lang.String r7 = "omx.google."
            boolean r7 = r0.startsWith(r7)     // Catch:{ Exception -> 0x029e }
            if (r7 != 0) goto L_0x0228
            java.lang.String r7 = "c2.android."
            boolean r7 = r0.startsWith(r7)     // Catch:{ Exception -> 0x029e }
            if (r7 != 0) goto L_0x0228
            java.lang.String r7 = "c2.google."
            boolean r0 = r0.startsWith(r7)     // Catch:{ Exception -> 0x029e }
            if (r0 != 0) goto L_0x0228
            r0 = 1
            goto L_0x0229
        L_0x0228:
            r0 = 0
        L_0x0229:
            if (r16 == 0) goto L_0x022f
            boolean r7 = r1.zzb     // Catch:{ Exception -> 0x029e }
            if (r7 == r5) goto L_0x0235
        L_0x022f:
            if (r16 != 0) goto L_0x0265
            boolean r7 = r1.zzb     // Catch:{ Exception -> 0x025a }
            if (r7 != 0) goto L_0x0265
        L_0x0235:
            r5 = 0
            r18 = 0
            r7 = r12
            r8 = r15
            r9 = r11
            r20 = r11
            r11 = r21
            r23 = r12
            r12 = r22
            r24 = r13
            r13 = r0
            r25 = r14
            r14 = r5
            r26 = r15
            r15 = r18
            com.google.android.gms.internal.ads.zzrs r0 = com.google.android.gms.internal.ads.zzrs.zzc(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x0256 }
            r6.add(r0)     // Catch:{ Exception -> 0x0256 }
            goto L_0x02f4
        L_0x0256:
            r0 = move-exception
            r1 = r23
            goto L_0x02a8
        L_0x025a:
            r0 = move-exception
            r20 = r11
            r24 = r13
            r25 = r14
            r26 = r15
            r1 = r12
            goto L_0x02a8
        L_0x0265:
            r20 = r11
            r23 = r12
            r24 = r13
            r25 = r14
            r26 = r15
            if (r16 != 0) goto L_0x02f4
            if (r5 == 0) goto L_0x02f4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0256 }
            r5.<init>()     // Catch:{ Exception -> 0x0256 }
            r15 = r23
            r5.append(r15)     // Catch:{ Exception -> 0x029b }
            r5.append(r9)     // Catch:{ Exception -> 0x029b }
            java.lang.String r7 = r5.toString()     // Catch:{ Exception -> 0x029b }
            r14 = 0
            r5 = 1
            r8 = r26
            r9 = r20
            r11 = r21
            r12 = r22
            r13 = r0
            r1 = r15
            r15 = r5
            com.google.android.gms.internal.ads.zzrs r0 = com.google.android.gms.internal.ads.zzrs.zzc(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x0299 }
            r6.add(r0)     // Catch:{ Exception -> 0x0299 }
            return r6
        L_0x0299:
            r0 = move-exception
            goto L_0x02a8
        L_0x029b:
            r0 = move-exception
            r1 = r15
            goto L_0x02a8
        L_0x029e:
            r0 = move-exception
            r20 = r11
            r1 = r12
            r24 = r13
            r25 = r14
            r26 = r15
        L_0x02a8:
            int r5 = com.google.android.gms.internal.ads.zzfj.zza     // Catch:{ Exception -> 0x02ff }
            java.lang.String r7 = "MediaCodecUtil"
            r8 = 23
            if (r5 > r8) goto L_0x02d0
            boolean r5 = r6.isEmpty()     // Catch:{ Exception -> 0x02ff }
            if (r5 != 0) goto L_0x02d0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ff }
            r0.<init>()     // Catch:{ Exception -> 0x02ff }
            java.lang.String r5 = "Skipping codec "
            r0.append(r5)     // Catch:{ Exception -> 0x02ff }
            r0.append(r1)     // Catch:{ Exception -> 0x02ff }
            java.lang.String r1 = " (failed to query capabilities)"
            r0.append(r1)     // Catch:{ Exception -> 0x02ff }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02ff }
            com.google.android.gms.internal.ads.zzer.zzc(r7, r0)     // Catch:{ Exception -> 0x02ff }
            goto L_0x02f4
        L_0x02d0:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ff }
            r2.<init>()     // Catch:{ Exception -> 0x02ff }
            java.lang.String r3 = "Failed to query codec "
            r2.append(r3)     // Catch:{ Exception -> 0x02ff }
            r2.append(r1)     // Catch:{ Exception -> 0x02ff }
            java.lang.String r1 = " ("
            r2.append(r1)     // Catch:{ Exception -> 0x02ff }
            r11 = r20
            r2.append(r11)     // Catch:{ Exception -> 0x02ff }
            java.lang.String r1 = ")"
            r2.append(r1)     // Catch:{ Exception -> 0x02ff }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x02ff }
            com.google.android.gms.internal.ads.zzer.zzc(r7, r1)     // Catch:{ Exception -> 0x02ff }
            throw r0     // Catch:{ Exception -> 0x02ff }
        L_0x02f4:
            int r13 = r24 + 1
            r1 = r27
            r14 = r25
            r15 = r26
            goto L_0x001a
        L_0x02fe:
            return r6
        L_0x02ff:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzsf r1 = new com.google.android.gms.internal.ads.zzsf
            r2 = 0
            r1.<init>(r0, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsl.zzj(com.google.android.gms.internal.ads.zzsd, com.google.android.gms.internal.ads.zzsg):java.util.ArrayList");
    }

    private static void zzk(List list, zzsk zzsk) {
        Collections.sort(list, new zzsa(zzsk));
    }

    private static boolean zzl(MediaCodecInfo mediaCodecInfo, String str) {
        if (zzfj.zza >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzcc.zzf(str)) {
            return true;
        }
        String zza2 = zzfon.zza(mediaCodecInfo.getName());
        if (zza2.startsWith("arc.")) {
            return false;
        }
        if (zza2.startsWith("omx.google.") || zza2.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((zza2.startsWith("omx.sec.") && zza2.contains(".sw.")) || zza2.equals("omx.qcom.video.decoder.hevcswvdec") || zza2.startsWith("c2.android.") || zza2.startsWith("c2.google.")) {
            return true;
        }
        if (zza2.startsWith("omx.") || zza2.startsWith("c2.")) {
            return false;
        }
        return true;
    }
}
