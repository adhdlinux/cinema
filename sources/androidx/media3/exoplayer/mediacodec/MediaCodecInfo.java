package androidx.media3.exoplayer.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.protobuf.CodedOutputStream;
import okhttp3.internal.http2.Http2;

public final class MediaCodecInfo {

    /* renamed from: a  reason: collision with root package name */
    public final String f6687a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6688b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6689c;

    /* renamed from: d  reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f6690d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f6691e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f6692f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f6693g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f6694h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f6695i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f6696j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f6697k;

    MediaCodecInfo(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f6687a = (String) Assertions.f(str);
        this.f6688b = str2;
        this.f6689c = str3;
        this.f6690d = codecCapabilities;
        this.f6694h = z2;
        this.f6695i = z3;
        this.f6696j = z4;
        this.f6691e = z5;
        this.f6692f = z6;
        this.f6693g = z7;
        this.f6697k = MimeTypes.s(str2);
    }

    private static boolean A(String str, int i2) {
        if (com.unity3d.services.core.device.MimeTypes.VIDEO_H265.equals(str) && 2 == i2) {
            String str2 = Util.f4715b;
            if ("sailfish".equals(str2) || "marlin".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean B(String str) {
        if (!"OMX.MTK.VIDEO.DECODER.HEVC".equals(str) || !"mcv5a".equals(Util.f4715b)) {
            return true;
        }
        return false;
    }

    public static MediaCodecInfo C(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        boolean z7;
        boolean z8;
        boolean z9;
        if (z5 || codecCapabilities == null || !h(codecCapabilities) || z(str)) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (codecCapabilities == null || !s(codecCapabilities)) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (z6 || (codecCapabilities != null && q(codecCapabilities))) {
            z9 = true;
        } else {
            z9 = false;
        }
        return new MediaCodecInfo(str, str2, str3, codecCapabilities, z2, z3, z4, z7, z8, z9);
    }

    private static int a(String str, String str2, int i2) {
        int i3;
        if (i2 > 1 || ((Util.f4714a >= 26 && i2 > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i2;
        }
        if ("audio/ac3".equals(str2)) {
            i3 = 6;
        } else if ("audio/eac3".equals(str2)) {
            i3 = 16;
        } else {
            i3 = 30;
        }
        Log.h("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i2 + " to " + i3 + "]");
        return i3;
    }

    private static Point c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(Util.k(i2, widthAlignment) * widthAlignment, Util.k(i3, heightAlignment) * heightAlignment);
    }

    private static boolean d(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        Point c2 = c(videoCapabilities, i2, i3);
        int i4 = c2.x;
        int i5 = c2.y;
        if (d2 == -1.0d || d2 < 1.0d) {
            return videoCapabilities.isSizeSupported(i4, i5);
        }
        return videoCapabilities.areSizeAndRateSupported(i4, i5, Math.floor(d2));
    }

    private static MediaCodecInfo.CodecProfileLevel[] f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
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

    private static boolean h(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private boolean k(Format format, boolean z2) {
        Pair<Integer, Integer> r2 = MediaCodecUtil.r(format);
        if (r2 == null) {
            return true;
        }
        int intValue = ((Integer) r2.first).intValue();
        int intValue2 = ((Integer) r2.second).intValue();
        if ("video/dolby-vision".equals(format.f4015n)) {
            if (com.unity3d.services.core.device.MimeTypes.VIDEO_H264.equals(this.f6688b)) {
                intValue = 8;
            } else if (com.unity3d.services.core.device.MimeTypes.VIDEO_H265.equals(this.f6688b)) {
                intValue = 2;
            }
            intValue2 = 0;
        }
        if (!this.f6697k && intValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] g2 = g();
        if (Util.f4714a <= 23 && "video/x-vnd.on2.vp9".equals(this.f6688b) && g2.length == 0) {
            g2 = f(this.f6690d);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : g2) {
            if (codecProfileLevel.profile == intValue && ((codecProfileLevel.level >= intValue2 || !z2) && !A(this.f6688b, intValue))) {
                return true;
            }
        }
        w("codec.profileLevel, " + format.f4011j + ", " + this.f6689c);
        return false;
    }

    private boolean o(Format format) {
        if (this.f6688b.equals(format.f4015n) || this.f6688b.equals(MediaCodecUtil.m(format))) {
            return true;
        }
        return false;
    }

    private static boolean q(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Util.f4714a >= 21 && r(codecCapabilities);
    }

    private static boolean r(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean s(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Util.f4714a >= 21 && t(codecCapabilities);
    }

    private static boolean t(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private void v(String str) {
        Log.b("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.f6687a + ", " + this.f6688b + "] [" + Util.f4718e + "]");
    }

    private void w(String str) {
        Log.b("MediaCodecInfo", "NoSupport [" + str + "] [" + this.f6687a + ", " + this.f6688b + "] [" + Util.f4718e + "]");
    }

    private static boolean x(String str) {
        return "audio/opus".equals(str);
    }

    private static boolean y(String str) {
        return Util.f4717d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private static boolean z(String str) {
        if (Util.f4714a <= 22) {
            String str2 = Util.f4717d;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    public Point b(int i2, int i3) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f6690d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return c(videoCapabilities, i2, i3);
    }

    public DecoderReuseEvaluation e(Format format, Format format2) {
        int i2;
        int i3;
        if (!Util.c(format.f4015n, format2.f4015n)) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        if (this.f6697k) {
            if (format.f4024w != format2.f4024w) {
                i2 |= 1024;
            }
            if (!this.f6691e && !(format.f4021t == format2.f4021t && format.f4022u == format2.f4022u)) {
                i2 |= 512;
            }
            if ((!ColorInfo.h(format.A) || !ColorInfo.h(format2.A)) && !Util.c(format.A, format2.A)) {
                i2 |= 2048;
            }
            if (y(this.f6687a) && !format.e(format2)) {
                i2 |= 2;
            }
            if (i2 == 0) {
                String str = this.f6687a;
                if (format.e(format2)) {
                    i3 = 3;
                } else {
                    i3 = 2;
                }
                return new DecoderReuseEvaluation(str, format, format2, i3, 0);
            }
        } else {
            if (format.B != format2.B) {
                i2 |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
            }
            if (format.C != format2.C) {
                i2 |= 8192;
            }
            if (format.D != format2.D) {
                i2 |= Http2.INITIAL_MAX_FRAME_SIZE;
            }
            if (i2 == 0 && "audio/mp4a-latm".equals(this.f6688b)) {
                Pair<Integer, Integer> r2 = MediaCodecUtil.r(format);
                Pair<Integer, Integer> r3 = MediaCodecUtil.r(format2);
                if (!(r2 == null || r3 == null)) {
                    int intValue = ((Integer) r2.first).intValue();
                    int intValue2 = ((Integer) r3.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new DecoderReuseEvaluation(this.f6687a, format, format2, 3, 0);
                    }
                }
            }
            if (!format.e(format2)) {
                i2 |= 32;
            }
            if (x(this.f6688b)) {
                i2 |= 2;
            }
            if (i2 == 0) {
                return new DecoderReuseEvaluation(this.f6687a, format, format2, 1, 0);
            }
        }
        return new DecoderReuseEvaluation(this.f6687a, format, format2, 0, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.profileLevels;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.media.MediaCodecInfo.CodecProfileLevel[] g() {
        /*
            r1 = this;
            android.media.MediaCodecInfo$CodecCapabilities r0 = r1.f6690d
            if (r0 == 0) goto L_0x0008
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = r0.profileLevels
            if (r0 != 0) goto L_0x000b
        L_0x0008:
            r0 = 0
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = new android.media.MediaCodecInfo.CodecProfileLevel[r0]
        L_0x000b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecInfo.g():android.media.MediaCodecInfo$CodecProfileLevel[]");
    }

    public boolean i(int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f6690d;
        if (codecCapabilities == null) {
            w("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            w("channelCount.aCaps");
            return false;
        } else if (a(this.f6687a, this.f6688b, audioCapabilities.getMaxInputChannelCount()) >= i2) {
            return true;
        } else {
            w("channelCount.support, " + i2);
            return false;
        }
    }

    public boolean j(int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f6690d;
        if (codecCapabilities == null) {
            w("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            w("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i2)) {
            return true;
        } else {
            w("sampleRate.support, " + i2);
            return false;
        }
    }

    public boolean l(Format format) {
        if (!o(format) || !k(format, false)) {
            return false;
        }
        return true;
    }

    public boolean m(Format format) throws MediaCodecUtil.DecoderQueryException {
        int i2;
        boolean z2 = false;
        if (!o(format) || !k(format, true)) {
            return false;
        }
        if (this.f6697k) {
            int i3 = format.f4021t;
            if (i3 <= 0 || (i2 = format.f4022u) <= 0) {
                return true;
            }
            if (Util.f4714a >= 21) {
                return u(i3, i2, (double) format.f4023v);
            }
            if (i3 * i2 <= MediaCodecUtil.P()) {
                z2 = true;
            }
            if (!z2) {
                w("legacyFrameSize, " + format.f4021t + "x" + format.f4022u);
            }
            return z2;
        }
        if (Util.f4714a >= 21) {
            int i4 = format.C;
            if (i4 != -1 && !j(i4)) {
                return false;
            }
            int i5 = format.B;
            if (i5 == -1 || i(i5)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean n() {
        if (Util.f4714a >= 29 && "video/x-vnd.on2.vp9".equals(this.f6688b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : g()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean p(Format format) {
        if (this.f6697k) {
            return this.f6691e;
        }
        Pair<Integer, Integer> r2 = MediaCodecUtil.r(format);
        if (r2 == null || ((Integer) r2.first).intValue() != 42) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.f6687a;
    }

    public boolean u(int i2, int i3, double d2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f6690d;
        if (codecCapabilities == null) {
            w("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            w("sizeAndRate.vCaps");
            return false;
        }
        if (Util.f4714a >= 29) {
            int c2 = MediaCodecPerformancePointCoverageProvider.c(videoCapabilities, i2, i3, d2);
            if (c2 == 2) {
                return true;
            }
            if (c2 == 1) {
                w("sizeAndRate.cover, " + i2 + "x" + i3 + "@" + d2);
                return false;
            }
        }
        if (!d(videoCapabilities, i2, i3, d2)) {
            if (i2 >= i3 || !B(this.f6687a) || !d(videoCapabilities, i3, i2, d2)) {
                w("sizeAndRate.support, " + i2 + "x" + i3 + "@" + d2);
                return false;
            }
            v("sizeAndRate.rotated, " + i2 + "x" + i3 + "@" + d2);
        }
        return true;
    }
}
