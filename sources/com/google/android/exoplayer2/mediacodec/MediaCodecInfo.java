package com.google.android.exoplayer2.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.protobuf.CodedOutputStream;
import java.util.List;
import okhttp3.internal.http2.Http2;

public final class MediaCodecInfo {

    /* renamed from: a  reason: collision with root package name */
    public final String f25273a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25274b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25275c;

    /* renamed from: d  reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f25276d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f25277e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f25278f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f25279g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f25280h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f25281i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f25282j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f25283k;

    private static final class Api29 {
        private Api29() {
        }

        public static int a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
            List a2 = videoCapabilities.getSupportedPerformancePoints();
            if (a2 == null || a2.isEmpty() || MediaCodecInfo.C()) {
                return 0;
            }
            MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint = new MediaCodecInfo.VideoCapabilities.PerformancePoint(i2, i3, (int) d2);
            for (int i4 = 0; i4 < a2.size(); i4++) {
                if (((MediaCodecInfo.VideoCapabilities.PerformancePoint) a2.get(i4)).covers(performancePoint)) {
                    return 2;
                }
            }
            return 1;
        }
    }

    MediaCodecInfo(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f25273a = (String) Assertions.e(str);
        this.f25274b = str2;
        this.f25275c = str3;
        this.f25276d = codecCapabilities;
        this.f25280h = z2;
        this.f25281i = z3;
        this.f25282j = z4;
        this.f25277e = z5;
        this.f25278f = z6;
        this.f25279g = z7;
        this.f25283k = MimeTypes.s(str2);
    }

    private static boolean A(String str) {
        return Util.f28811d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private static boolean B(String str) {
        if (Util.f28808a <= 22) {
            String str2 = Util.f28811d;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean C() {
        String str = Util.f28809b;
        if (!str.equals("sabrina") && !str.equals("boreal")) {
            String str2 = Util.f28811d;
            if (str2.startsWith("Lenovo TB-X605") || str2.startsWith("Lenovo TB-X606") || str2.startsWith("Lenovo TB-X616")) {
                return true;
            }
            return false;
        }
        return true;
    }

    private static boolean D(String str, int i2) {
        if (com.unity3d.services.core.device.MimeTypes.VIDEO_H265.equals(str) && 2 == i2) {
            String str2 = Util.f28809b;
            if ("sailfish".equals(str2) || "marlin".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean E(String str) {
        if (!"OMX.MTK.VIDEO.DECODER.HEVC".equals(str) || !"mcv5a".equals(Util.f28809b)) {
            return true;
        }
        return false;
    }

    public static MediaCodecInfo F(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        boolean z7;
        boolean z8;
        boolean z9;
        if (z5 || codecCapabilities == null || !i(codecCapabilities) || B(str)) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (codecCapabilities == null || !u(codecCapabilities)) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (z6 || (codecCapabilities != null && s(codecCapabilities))) {
            z9 = true;
        } else {
            z9 = false;
        }
        return new MediaCodecInfo(str, str2, str3, codecCapabilities, z2, z3, z4, z7, z8, z9);
    }

    private static int b(String str, String str2, int i2) {
        int i3;
        if (i2 > 1 || ((Util.f28808a >= 26 && i2 > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i2;
        }
        if ("audio/ac3".equals(str2)) {
            i3 = 6;
        } else if ("audio/eac3".equals(str2)) {
            i3 = 16;
        } else {
            i3 = 30;
        }
        Log.i("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i2 + " to " + i3 + "]");
        return i3;
    }

    private static Point d(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(Util.l(i2, widthAlignment) * widthAlignment, Util.l(i3, heightAlignment) * heightAlignment);
    }

    private static boolean e(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        Point d3 = d(videoCapabilities, i2, i3);
        int i4 = d3.x;
        int i5 = d3.y;
        if (d2 == -1.0d || d2 < 1.0d) {
            return videoCapabilities.isSizeSupported(i4, i5);
        }
        return videoCapabilities.areSizeAndRateSupported(i4, i5, Math.floor(d2));
    }

    private static MediaCodecInfo.CodecProfileLevel[] g(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        int i2;
        int i3;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            i2 = 0;
        } else {
            i2 = videoCapabilities.getBitrateRange().getUpper().intValue();
        }
        if (i2 >= 180000000) {
            i3 = 1024;
        } else if (i2 >= 120000000) {
            i3 = 512;
        } else if (i2 >= 60000000) {
            i3 = UserVerificationMethods.USER_VERIFY_HANDPRINT;
        } else if (i2 >= 30000000) {
            i3 = 128;
        } else if (i2 >= 18000000) {
            i3 = 64;
        } else if (i2 >= 12000000) {
            i3 = 32;
        } else if (i2 >= 7200000) {
            i3 = 16;
        } else if (i2 >= 3600000) {
            i3 = 8;
        } else if (i2 >= 1800000) {
            i3 = 4;
        } else if (i2 >= 800000) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = 1;
        codecProfileLevel.level = i3;
        return new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
    }

    private static boolean i(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Util.f28808a >= 19 && j(codecCapabilities);
    }

    private static boolean j(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private boolean m(Format format, boolean z2) {
        Pair<Integer, Integer> q2 = MediaCodecUtil.q(format);
        if (q2 == null) {
            return true;
        }
        int intValue = ((Integer) q2.first).intValue();
        int intValue2 = ((Integer) q2.second).intValue();
        if ("video/dolby-vision".equals(format.f23071m)) {
            if (com.unity3d.services.core.device.MimeTypes.VIDEO_H264.equals(this.f25274b)) {
                intValue = 8;
            } else if (com.unity3d.services.core.device.MimeTypes.VIDEO_H265.equals(this.f25274b)) {
                intValue = 2;
            }
            intValue2 = 0;
        }
        if (!this.f25283k && intValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] h2 = h();
        if (Util.f28808a <= 23 && "video/x-vnd.on2.vp9".equals(this.f25274b) && h2.length == 0) {
            h2 = g(this.f25276d);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : h2) {
            if (codecProfileLevel.profile == intValue && ((codecProfileLevel.level >= intValue2 || !z2) && !D(this.f25274b, intValue))) {
                return true;
            }
        }
        y("codec.profileLevel, " + format.f23068j + ", " + this.f25275c);
        return false;
    }

    private boolean q(Format format) {
        if (this.f25274b.equals(format.f23071m) || this.f25274b.equals(MediaCodecUtil.m(format))) {
            return true;
        }
        return false;
    }

    private static boolean s(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Util.f28808a >= 21 && t(codecCapabilities);
    }

    private static boolean t(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean u(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Util.f28808a >= 21 && v(codecCapabilities);
    }

    private static boolean v(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private void x(String str) {
        Log.b("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.f25273a + ", " + this.f25274b + "] [" + Util.f28812e + "]");
    }

    private void y(String str) {
        Log.b("MediaCodecInfo", "NoSupport [" + str + "] [" + this.f25273a + ", " + this.f25274b + "] [" + Util.f28812e + "]");
    }

    private static boolean z(String str) {
        return "audio/opus".equals(str);
    }

    public Point c(int i2, int i3) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f25276d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return d(videoCapabilities, i2, i3);
    }

    public DecoderReuseEvaluation f(Format format, Format format2) {
        int i2;
        int i3;
        if (!Util.c(format.f23071m, format2.f23071m)) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        if (this.f25283k) {
            if (format.f23079u != format2.f23079u) {
                i2 |= 1024;
            }
            if (!this.f25277e && !(format.f23076r == format2.f23076r && format.f23077s == format2.f23077s)) {
                i2 |= 512;
            }
            if (!Util.c(format.f23083y, format2.f23083y)) {
                i2 |= 2048;
            }
            if (A(this.f25273a) && !format.g(format2)) {
                i2 |= 2;
            }
            if (i2 == 0) {
                String str = this.f25273a;
                if (format.g(format2)) {
                    i3 = 3;
                } else {
                    i3 = 2;
                }
                return new DecoderReuseEvaluation(str, format, format2, i3, 0);
            }
        } else {
            if (format.f23084z != format2.f23084z) {
                i2 |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
            }
            if (format.A != format2.A) {
                i2 |= 8192;
            }
            if (format.B != format2.B) {
                i2 |= Http2.INITIAL_MAX_FRAME_SIZE;
            }
            if (i2 == 0 && "audio/mp4a-latm".equals(this.f25274b)) {
                Pair<Integer, Integer> q2 = MediaCodecUtil.q(format);
                Pair<Integer, Integer> q3 = MediaCodecUtil.q(format2);
                if (!(q2 == null || q3 == null)) {
                    int intValue = ((Integer) q2.first).intValue();
                    int intValue2 = ((Integer) q3.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new DecoderReuseEvaluation(this.f25273a, format, format2, 3, 0);
                    }
                }
            }
            if (!format.g(format2)) {
                i2 |= 32;
            }
            if (z(this.f25274b)) {
                i2 |= 2;
            }
            if (i2 == 0) {
                return new DecoderReuseEvaluation(this.f25273a, format, format2, 1, 0);
            }
        }
        return new DecoderReuseEvaluation(this.f25273a, format, format2, 0, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.profileLevels;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.media.MediaCodecInfo.CodecProfileLevel[] h() {
        /*
            r1 = this;
            android.media.MediaCodecInfo$CodecCapabilities r0 = r1.f25276d
            if (r0 == 0) goto L_0x0008
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = r0.profileLevels
            if (r0 != 0) goto L_0x000b
        L_0x0008:
            r0 = 0
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = new android.media.MediaCodecInfo.CodecProfileLevel[r0]
        L_0x000b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecInfo.h():android.media.MediaCodecInfo$CodecProfileLevel[]");
    }

    public boolean k(int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f25276d;
        if (codecCapabilities == null) {
            y("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            y("channelCount.aCaps");
            return false;
        } else if (b(this.f25273a, this.f25274b, audioCapabilities.getMaxInputChannelCount()) >= i2) {
            return true;
        } else {
            y("channelCount.support, " + i2);
            return false;
        }
    }

    public boolean l(int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f25276d;
        if (codecCapabilities == null) {
            y("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            y("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i2)) {
            return true;
        } else {
            y("sampleRate.support, " + i2);
            return false;
        }
    }

    public boolean n(Format format) {
        if (!q(format) || !m(format, false)) {
            return false;
        }
        return true;
    }

    public boolean o(Format format) throws MediaCodecUtil.DecoderQueryException {
        int i2;
        boolean z2 = false;
        if (!q(format) || !m(format, true)) {
            return false;
        }
        if (this.f25283k) {
            int i3 = format.f23076r;
            if (i3 <= 0 || (i2 = format.f23077s) <= 0) {
                return true;
            }
            if (Util.f28808a >= 21) {
                return w(i3, i2, (double) format.f23078t);
            }
            if (i3 * i2 <= MediaCodecUtil.N()) {
                z2 = true;
            }
            if (!z2) {
                y("legacyFrameSize, " + format.f23076r + "x" + format.f23077s);
            }
            return z2;
        }
        if (Util.f28808a >= 21) {
            int i4 = format.A;
            if (i4 != -1 && !l(i4)) {
                return false;
            }
            int i5 = format.f23084z;
            if (i5 == -1 || k(i5)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean p() {
        if (Util.f28808a >= 29 && "video/x-vnd.on2.vp9".equals(this.f25274b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : h()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean r(Format format) {
        if (this.f25283k) {
            return this.f25277e;
        }
        Pair<Integer, Integer> q2 = MediaCodecUtil.q(format);
        if (q2 == null || ((Integer) q2.first).intValue() != 42) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.f25273a;
    }

    public boolean w(int i2, int i3, double d2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f25276d;
        if (codecCapabilities == null) {
            y("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            y("sizeAndRate.vCaps");
            return false;
        }
        if (Util.f28808a >= 29) {
            int a2 = Api29.a(videoCapabilities, i2, i3, d2);
            if (a2 == 2) {
                return true;
            }
            if (a2 == 1) {
                y("sizeAndRate.cover, " + i2 + "x" + i3 + "@" + d2);
                return false;
            }
        }
        if (!e(videoCapabilities, i2, i3, d2)) {
            if (i2 >= i3 || !E(this.f25273a) || !e(videoCapabilities, i3, i2, d2)) {
                y("sizeAndRate.support, " + i2 + "x" + i3 + "@" + d2);
                return false;
            }
            x("sizeAndRate.rotated, " + i2 + "x" + i3 + "@" + d2);
        }
        return true;
    }
}
