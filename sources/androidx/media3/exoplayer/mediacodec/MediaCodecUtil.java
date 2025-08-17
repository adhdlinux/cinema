package androidx.media3.exoplayer.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.ar.core.ImageMetadata;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.CodedOutputStream;
import com.unity3d.services.core.device.MimeTypes;
import com.uwetrottmann.trakt5.TraktV2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@SuppressLint({"InlinedApi"})
public final class MediaCodecUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f6743a = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<CodecKey, List<MediaCodecInfo>> f6744b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static int f6745c = -1;

    private static final class CodecKey {

        /* renamed from: a  reason: collision with root package name */
        public final String f6746a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f6747b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f6748c;

        public CodecKey(String str, boolean z2, boolean z3) {
            this.f6746a = str;
            this.f6747b = z2;
            this.f6748c = z3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != CodecKey.class) {
                return false;
            }
            CodecKey codecKey = (CodecKey) obj;
            if (TextUtils.equals(this.f6746a, codecKey.f6746a) && this.f6747b == codecKey.f6747b && this.f6748c == codecKey.f6748c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2;
            int hashCode = (this.f6746a.hashCode() + 31) * 31;
            int i3 = 1231;
            if (this.f6747b) {
                i2 = 1231;
            } else {
                i2 = 1237;
            }
            int i4 = (hashCode + i2) * 31;
            if (!this.f6748c) {
                i3 = 1237;
            }
            return i4 + i3;
        }
    }

    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    private interface MediaCodecListCompat {
        MediaCodecInfo a(int i2);

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int d();

        boolean e();
    }

    private static final class MediaCodecListCompatV16 implements MediaCodecListCompat {
        private MediaCodecListCompatV16() {
        }

        public MediaCodecInfo a(int i2) {
            return MediaCodecList.getCodecInfoAt(i2);
        }

        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            if (!"secure-playback".equals(str) || !MimeTypes.VIDEO_H264.equals(str2)) {
                return false;
            }
            return true;
        }

        public boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        public int d() {
            return MediaCodecList.getCodecCount();
        }

        public boolean e() {
            return false;
        }
    }

    private static final class MediaCodecListCompatV21 implements MediaCodecListCompat {

        /* renamed from: a  reason: collision with root package name */
        private final int f6749a;

        /* renamed from: b  reason: collision with root package name */
        private MediaCodecInfo[] f6750b;

        public MediaCodecListCompatV21(boolean z2, boolean z3) {
            int i2;
            if (z2 || z3) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.f6749a = i2;
        }

        @EnsuresNonNull({"mediaCodecInfos"})
        private void f() {
            if (this.f6750b == null) {
                this.f6750b = new MediaCodecList(this.f6749a).getCodecInfos();
            }
        }

        public MediaCodecInfo a(int i2) {
            f();
            return this.f6750b[i2];
        }

        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        public boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        public int d() {
            f();
            return this.f6750b.length;
        }

        public boolean e() {
            return true;
        }
    }

    private interface ScoreProvider<T> {
        int a(T t2);
    }

    private MediaCodecUtil() {
    }

    private static Pair<Integer, Integer> A(String str, String[] strArr) {
        if (strArr.length < 3) {
            Log.h("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2]);
            int T = T(parseInt);
            if (T == -1) {
                Log.h("MediaCodecUtil", "Unknown VP9 profile: " + parseInt);
                return null;
            }
            int S = S(parseInt2);
            if (S != -1) {
                return new Pair<>(Integer.valueOf(T), Integer.valueOf(S));
            }
            Log.h("MediaCodecUtil", "Unknown VP9 level: " + parseInt2);
            return null;
        } catch (NumberFormatException unused) {
            Log.h("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
    }

    private static Integer B(String str) {
        if (str == null) {
            return null;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 70821:
                if (str.equals("H30")) {
                    c2 = 0;
                    break;
                }
                break;
            case 70914:
                if (str.equals("H60")) {
                    c2 = 1;
                    break;
                }
                break;
            case 70917:
                if (str.equals("H63")) {
                    c2 = 2;
                    break;
                }
                break;
            case 71007:
                if (str.equals("H90")) {
                    c2 = 3;
                    break;
                }
                break;
            case 71010:
                if (str.equals("H93")) {
                    c2 = 4;
                    break;
                }
                break;
            case 74665:
                if (str.equals("L30")) {
                    c2 = 5;
                    break;
                }
                break;
            case 74758:
                if (str.equals("L60")) {
                    c2 = 6;
                    break;
                }
                break;
            case 74761:
                if (str.equals("L63")) {
                    c2 = 7;
                    break;
                }
                break;
            case 74851:
                if (str.equals("L90")) {
                    c2 = 8;
                    break;
                }
                break;
            case 74854:
                if (str.equals("L93")) {
                    c2 = 9;
                    break;
                }
                break;
            case 2193639:
                if (str.equals("H120")) {
                    c2 = 10;
                    break;
                }
                break;
            case 2193642:
                if (str.equals("H123")) {
                    c2 = 11;
                    break;
                }
                break;
            case 2193732:
                if (str.equals("H150")) {
                    c2 = 12;
                    break;
                }
                break;
            case 2193735:
                if (str.equals("H153")) {
                    c2 = 13;
                    break;
                }
                break;
            case 2193738:
                if (str.equals("H156")) {
                    c2 = 14;
                    break;
                }
                break;
            case 2193825:
                if (str.equals("H180")) {
                    c2 = 15;
                    break;
                }
                break;
            case 2193828:
                if (str.equals("H183")) {
                    c2 = 16;
                    break;
                }
                break;
            case 2193831:
                if (str.equals("H186")) {
                    c2 = 17;
                    break;
                }
                break;
            case 2312803:
                if (str.equals("L120")) {
                    c2 = 18;
                    break;
                }
                break;
            case 2312806:
                if (str.equals("L123")) {
                    c2 = 19;
                    break;
                }
                break;
            case 2312896:
                if (str.equals("L150")) {
                    c2 = 20;
                    break;
                }
                break;
            case 2312899:
                if (str.equals("L153")) {
                    c2 = 21;
                    break;
                }
                break;
            case 2312902:
                if (str.equals("L156")) {
                    c2 = 22;
                    break;
                }
                break;
            case 2312989:
                if (str.equals("L180")) {
                    c2 = 23;
                    break;
                }
                break;
            case 2312992:
                if (str.equals("L183")) {
                    c2 = 24;
                    break;
                }
                break;
            case 2312995:
                if (str.equals("L186")) {
                    c2 = 25;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 2;
            case 1:
                return 8;
            case 2:
                return 32;
            case 3:
                return 128;
            case 4:
                return 512;
            case 5:
                return 1;
            case 6:
                return 4;
            case 7:
                return 16;
            case 8:
                return 64;
            case 9:
                return Integer.valueOf(UserVerificationMethods.USER_VERIFY_HANDPRINT);
            case 10:
                return 2048;
            case 11:
                return 8192;
            case 12:
                return 32768;
            case 13:
                return 131072;
            case 14:
                return Integer.valueOf(ImageMetadata.LENS_APERTURE);
            case 15:
                return 2097152;
            case 16:
                return 8388608;
            case 17:
                return 33554432;
            case 18:
                return 1024;
            case 19:
                return Integer.valueOf(CodedOutputStream.DEFAULT_BUFFER_SIZE);
            case 20:
                return Integer.valueOf(Http2.INITIAL_MAX_FRAME_SIZE);
            case 21:
                return 65536;
            case 22:
                return 262144;
            case 23:
                return 1048576;
            case 24:
                return 4194304;
            case 25:
                return Integer.valueOf(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
            default:
                return null;
        }
    }

    private static boolean C(MediaCodecInfo mediaCodecInfo) {
        return Util.f4714a >= 29 && D(mediaCodecInfo);
    }

    private static boolean D(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    private static boolean E(MediaCodecInfo mediaCodecInfo, String str, boolean z2, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z2 && str.endsWith(".secure"))) {
            return false;
        }
        int i2 = Util.f4714a;
        if (i2 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i2 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(Util.f4716c))) {
            String str3 = Util.f4715b;
            if (str3.startsWith("zeroflte") || str3.startsWith("zerolte") || str3.startsWith("zenlte") || "SC-05G".equals(str3) || "marinelteatt".equals(str3) || "404SC".equals(str3) || "SC-04G".equals(str3) || "SCV31".equals(str3)) {
                return false;
            }
        }
        if (i2 == 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(Util.f4716c)) {
            String str4 = Util.f4715b;
            if (str4.startsWith("d2") || str4.startsWith("serrano") || str4.startsWith("jflte") || str4.startsWith("santos") || str4.startsWith("t0")) {
                return false;
            }
        }
        if (i2 == 19 && Util.f4715b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        if (i2 > 23 || !"audio/eac3-joc".equals(str2) || !"OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) {
            return true;
        }
        return false;
    }

    private static boolean F(MediaCodecInfo mediaCodecInfo, String str) {
        if (Util.f4714a >= 29) {
            return G(mediaCodecInfo);
        }
        return !H(mediaCodecInfo, str);
    }

    private static boolean G(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    private static boolean H(MediaCodecInfo mediaCodecInfo, String str) {
        if (Util.f4714a >= 29) {
            return I(mediaCodecInfo);
        }
        if (androidx.media3.common.MimeTypes.o(str)) {
            return true;
        }
        String e2 = Ascii.e(mediaCodecInfo.getName());
        if (e2.startsWith("arc.")) {
            return false;
        }
        if (e2.startsWith("omx.google.") || e2.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((e2.startsWith("omx.sec.") && e2.contains(".sw.")) || e2.equals("omx.qcom.video.decoder.hevcswvdec") || e2.startsWith("c2.android.") || e2.startsWith("c2.google.")) {
            return true;
        }
        if (e2.startsWith("omx.") || e2.startsWith("c2.")) {
            return false;
        }
        return true;
    }

    private static boolean I(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    private static boolean J(MediaCodecInfo mediaCodecInfo) {
        if (Util.f4714a >= 29) {
            return K(mediaCodecInfo);
        }
        String e2 = Ascii.e(mediaCodecInfo.getName());
        if (e2.startsWith("omx.google.") || e2.startsWith("c2.android.") || e2.startsWith("c2.google.")) {
            return false;
        }
        return true;
    }

    private static boolean K(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int L(MediaCodecInfo mediaCodecInfo) {
        String str = mediaCodecInfo.f6687a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        if (Util.f4714a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
            return 0;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int M(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.f6687a.startsWith("OMX.google") ? 1 : 0;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int N(Format format, MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.l(format) ? 1 : 0;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int O(ScoreProvider scoreProvider, Object obj, Object obj2) {
        return scoreProvider.a(obj2) - scoreProvider.a(obj);
    }

    public static int P() throws DecoderQueryException {
        int i2;
        if (f6745c == -1) {
            int i3 = 0;
            MediaCodecInfo s2 = s(MimeTypes.VIDEO_H264, false, false);
            if (s2 != null) {
                MediaCodecInfo.CodecProfileLevel[] g2 = s2.g();
                int length = g2.length;
                int i4 = 0;
                while (i3 < length) {
                    i4 = Math.max(h(g2[i3].level), i4);
                    i3++;
                }
                if (Util.f4714a >= 21) {
                    i2 = 345600;
                } else {
                    i2 = 172800;
                }
                i3 = Math.max(i4, i2);
            }
            f6745c = i3;
        }
        return f6745c;
    }

    private static int Q(int i2) {
        int i3 = 17;
        if (i2 != 17) {
            i3 = 20;
            if (i2 != 20) {
                i3 = 23;
                if (i2 != 23) {
                    i3 = 29;
                    if (i2 != 29) {
                        i3 = 39;
                        if (i2 != 39) {
                            i3 = 42;
                            if (i2 != 42) {
                                switch (i2) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i3;
    }

    private static <T> void R(List<T> list, ScoreProvider<T> scoreProvider) {
        Collections.sort(list, new w(scoreProvider));
    }

    private static int S(int i2) {
        if (i2 == 10) {
            return 1;
        }
        if (i2 == 11) {
            return 2;
        }
        if (i2 == 20) {
            return 4;
        }
        if (i2 == 21) {
            return 8;
        }
        if (i2 == 30) {
            return 16;
        }
        if (i2 == 31) {
            return 32;
        }
        if (i2 == 40) {
            return 64;
        }
        if (i2 == 41) {
            return 128;
        }
        if (i2 == 50) {
            return UserVerificationMethods.USER_VERIFY_HANDPRINT;
        }
        if (i2 == 51) {
            return 512;
        }
        switch (i2) {
            case 60:
                return 2048;
            case 61:
                return CodedOutputStream.DEFAULT_BUFFER_SIZE;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    private static int T(int i2) {
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return i2 != 3 ? -1 : 8;
        }
        return 4;
    }

    private static void e(String str, List<MediaCodecInfo> list) {
        if ("audio/raw".equals(str)) {
            if (Util.f4714a < 26 && Util.f4715b.equals("R9") && list.size() == 1 && list.get(0).f6687a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(MediaCodecInfo.C("OMX.google.raw.decoder", "audio/raw", "audio/raw", (MediaCodecInfo.CodecCapabilities) null, false, true, false, false, false));
            }
            R(list, new u());
        }
        int i2 = Util.f4714a;
        if (i2 < 21 && list.size() > 1) {
            String str2 = list.get(0).f6687a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                R(list, new v());
            }
        }
        if (i2 < 32 && list.size() > 1 && "OMX.qti.audio.decoder.flac".equals(list.get(0).f6687a)) {
            list.add(list.remove(0));
        }
    }

    private static int f(int i2) {
        switch (i2) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return UserVerificationMethods.USER_VERIFY_HANDPRINT;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return CodedOutputStream.DEFAULT_BUFFER_SIZE;
            case 13:
                return 8192;
            case 14:
                return Http2.INITIAL_MAX_FRAME_SIZE;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return ImageMetadata.LENS_APERTURE;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    private static int g(int i2) {
        switch (i2) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i2) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i2) {
                            case 30:
                                return UserVerificationMethods.USER_VERIFY_HANDPRINT;
                            case 31:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i2) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return CodedOutputStream.DEFAULT_BUFFER_SIZE;
                                    case 42:
                                        return 8192;
                                    default:
                                        switch (i2) {
                                            case 50:
                                                return Http2.INITIAL_MAX_FRAME_SIZE;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    private static int h(int i2) {
        if (i2 == 1 || i2 == 2) {
            return 25344;
        }
        switch (i2) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case UserVerificationMethods.USER_VERIFY_HANDPRINT /*256*/:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case CodedOutputStream.DEFAULT_BUFFER_SIZE /*4096*/:
                return 2097152;
            case 8192:
                return 2228224;
            case Http2.INITIAL_MAX_FRAME_SIZE /*16384*/:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            case 131072:
            case 262144:
            case ImageMetadata.LENS_APERTURE /*524288*/:
                return 35651584;
            default:
                return -1;
        }
    }

    private static int i(int i2) {
        if (i2 == 66) {
            return 1;
        }
        if (i2 == 77) {
            return 2;
        }
        if (i2 == 88) {
            return 4;
        }
        if (i2 == 100) {
            return 8;
        }
        if (i2 == 110) {
            return 16;
        }
        if (i2 != 122) {
            return i2 != 244 ? -1 : 64;
        }
        return 32;
    }

    private static Integer j(String str) {
        if (str == null) {
            return null;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 1537:
                if (str.equals("01")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    c2 = 8;
                    break;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    c2 = 9;
                    break;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    c2 = 10;
                    break;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1570:
                if (str.equals("13")) {
                    c2 = 12;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return Integer.valueOf(UserVerificationMethods.USER_VERIFY_HANDPRINT);
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return Integer.valueOf(CodedOutputStream.DEFAULT_BUFFER_SIZE);
            default:
                return null;
        }
    }

    private static Integer k(String str) {
        if (str == null) {
            return null;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 1536:
                if (str.equals("00")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1537:
                if (str.equals("01")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    c2 = 8;
                    break;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    c2 = 9;
                    break;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    c2 = 10;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return Integer.valueOf(UserVerificationMethods.USER_VERIFY_HANDPRINT);
            case 9:
                return 512;
            case 10:
                return 1024;
            default:
                return null;
        }
    }

    private static Pair<Integer, Integer> l(String str, String[] strArr) {
        int Q;
        if (strArr.length != 3) {
            Log.h("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(androidx.media3.common.MimeTypes.h(Integer.parseInt(strArr[1], 16))) && (Q = Q(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair<>(Integer.valueOf(Q), 0);
            }
        } catch (NumberFormatException unused) {
            Log.h("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    public static String m(Format format) {
        Pair<Integer, Integer> r2;
        if ("audio/eac3-joc".equals(format.f4015n)) {
            return "audio/eac3";
        }
        if (!"video/dolby-vision".equals(format.f4015n) || (r2 = r(format)) == null) {
            return null;
        }
        int intValue = ((Integer) r2.first).intValue();
        if (intValue == 16 || intValue == 256) {
            return MimeTypes.VIDEO_H265;
        }
        if (intValue == 512) {
            return MimeTypes.VIDEO_H264;
        }
        if (intValue == 1024) {
            return "video/av01";
        }
        return null;
    }

    public static List<MediaCodecInfo> n(MediaCodecSelector mediaCodecSelector, Format format, boolean z2, boolean z3) throws DecoderQueryException {
        String m2 = m(format);
        if (m2 == null) {
            return ImmutableList.r();
        }
        return mediaCodecSelector.a(m2, z2, z3);
    }

    private static Pair<Integer, Integer> o(String str, String[] strArr, ColorInfo colorInfo) {
        int i2;
        if (strArr.length < 4) {
            Log.h("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
        int i3 = 1;
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2].substring(0, 2));
            int parseInt3 = Integer.parseInt(strArr[3]);
            if (parseInt != 0) {
                Log.h("MediaCodecUtil", "Unknown AV1 profile: " + parseInt);
                return null;
            } else if (parseInt3 == 8 || parseInt3 == 10) {
                if (parseInt3 != 8) {
                    if (colorInfo == null || !(colorInfo.f3946d != null || (i2 = colorInfo.f3945c) == 7 || i2 == 6)) {
                        i3 = 2;
                    } else {
                        i3 = CodedOutputStream.DEFAULT_BUFFER_SIZE;
                    }
                }
                int f2 = f(parseInt2);
                if (f2 != -1) {
                    return new Pair<>(Integer.valueOf(i3), Integer.valueOf(f2));
                }
                Log.h("MediaCodecUtil", "Unknown AV1 level: " + parseInt2);
                return null;
            } else {
                Log.h("MediaCodecUtil", "Unknown AV1 bit depth: " + parseInt3);
                return null;
            }
        } catch (NumberFormatException unused) {
            Log.h("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
    }

    private static Pair<Integer, Integer> p(String str, String[] strArr) {
        int i2;
        int i3;
        if (strArr.length < 2) {
            Log.h("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i3 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i2 = Integer.parseInt(strArr[1].substring(4), 16);
            } else if (strArr.length >= 3) {
                int parseInt = Integer.parseInt(strArr[1]);
                i2 = Integer.parseInt(strArr[2]);
                i3 = parseInt;
            } else {
                Log.h("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                return null;
            }
            int i4 = i(i3);
            if (i4 == -1) {
                Log.h("MediaCodecUtil", "Unknown AVC profile: " + i3);
                return null;
            }
            int g2 = g(i2);
            if (g2 != -1) {
                return new Pair<>(Integer.valueOf(i4), Integer.valueOf(g2));
            }
            Log.h("MediaCodecUtil", "Unknown AVC level: " + i2);
            return null;
        } catch (NumberFormatException unused) {
            Log.h("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    private static String q(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        } else if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        } else {
            if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
                return "audio/x-lg-flac";
            }
            if (!str2.equals("audio/ac3") || !"OMX.lge.ac3.decoder".equals(str)) {
                return null;
            }
            return "audio/lg-ac3";
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0075, code lost:
        if (r3.equals("av01") == false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> r(androidx.media3.common.Format r6) {
        /*
            java.lang.String r0 = r6.f4011j
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.String r2 = "\\."
            java.lang.String[] r0 = r0.split(r2)
            java.lang.String r2 = "video/dolby-vision"
            java.lang.String r3 = r6.f4015n
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x001d
            java.lang.String r6 = r6.f4011j
            android.util.Pair r6 = y(r6, r0)
            return r6
        L_0x001d:
            r2 = 0
            r3 = r0[r2]
            r3.hashCode()
            int r4 = r3.hashCode()
            r5 = -1
            switch(r4) {
                case 3004662: goto L_0x006f;
                case 3006243: goto L_0x0064;
                case 3006244: goto L_0x0059;
                case 3199032: goto L_0x004e;
                case 3214780: goto L_0x0043;
                case 3356560: goto L_0x0038;
                case 3624515: goto L_0x002d;
                default: goto L_0x002b;
            }
        L_0x002b:
            r2 = -1
            goto L_0x0078
        L_0x002d:
            java.lang.String r2 = "vp09"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0036
            goto L_0x002b
        L_0x0036:
            r2 = 6
            goto L_0x0078
        L_0x0038:
            java.lang.String r2 = "mp4a"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0041
            goto L_0x002b
        L_0x0041:
            r2 = 5
            goto L_0x0078
        L_0x0043:
            java.lang.String r2 = "hvc1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x004c
            goto L_0x002b
        L_0x004c:
            r2 = 4
            goto L_0x0078
        L_0x004e:
            java.lang.String r2 = "hev1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0057
            goto L_0x002b
        L_0x0057:
            r2 = 3
            goto L_0x0078
        L_0x0059:
            java.lang.String r2 = "avc2"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0062
            goto L_0x002b
        L_0x0062:
            r2 = 2
            goto L_0x0078
        L_0x0064:
            java.lang.String r2 = "avc1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x006d
            goto L_0x002b
        L_0x006d:
            r2 = 1
            goto L_0x0078
        L_0x006f:
            java.lang.String r4 = "av01"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0078
            goto L_0x002b
        L_0x0078:
            switch(r2) {
                case 0: goto L_0x009a;
                case 1: goto L_0x0093;
                case 2: goto L_0x0093;
                case 3: goto L_0x008a;
                case 4: goto L_0x008a;
                case 5: goto L_0x0083;
                case 6: goto L_0x007c;
                default: goto L_0x007b;
            }
        L_0x007b:
            return r1
        L_0x007c:
            java.lang.String r6 = r6.f4011j
            android.util.Pair r6 = A(r6, r0)
            return r6
        L_0x0083:
            java.lang.String r6 = r6.f4011j
            android.util.Pair r6 = l(r6, r0)
            return r6
        L_0x008a:
            java.lang.String r1 = r6.f4011j
            androidx.media3.common.ColorInfo r6 = r6.A
            android.util.Pair r6 = z(r1, r0, r6)
            return r6
        L_0x0093:
            java.lang.String r6 = r6.f4011j
            android.util.Pair r6 = p(r6, r0)
            return r6
        L_0x009a:
            java.lang.String r1 = r6.f4011j
            androidx.media3.common.ColorInfo r6 = r6.A
            android.util.Pair r6 = o(r1, r0, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.r(androidx.media3.common.Format):android.util.Pair");
    }

    public static MediaCodecInfo s(String str, boolean z2, boolean z3) throws DecoderQueryException {
        List<MediaCodecInfo> t2 = t(str, z2, z3);
        if (t2.isEmpty()) {
            return null;
        }
        return t2.get(0);
    }

    public static synchronized List<MediaCodecInfo> t(String str, boolean z2, boolean z3) throws DecoderQueryException {
        MediaCodecListCompat mediaCodecListCompat;
        synchronized (MediaCodecUtil.class) {
            CodecKey codecKey = new CodecKey(str, z2, z3);
            HashMap<CodecKey, List<MediaCodecInfo>> hashMap = f6744b;
            List<MediaCodecInfo> list = hashMap.get(codecKey);
            if (list != null) {
                return list;
            }
            int i2 = Util.f4714a;
            if (i2 >= 21) {
                mediaCodecListCompat = new MediaCodecListCompatV21(z2, z3);
            } else {
                mediaCodecListCompat = new MediaCodecListCompatV16();
            }
            ArrayList<MediaCodecInfo> u2 = u(codecKey, mediaCodecListCompat);
            if (z2 && u2.isEmpty() && 21 <= i2 && i2 <= 23) {
                u2 = u(codecKey, new MediaCodecListCompatV16());
                if (!u2.isEmpty()) {
                    Log.h("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + u2.get(0).f6687a);
                }
            }
            e(str, u2);
            ImmutableList<MediaCodecInfo> n2 = ImmutableList.n(u2);
            hashMap.put(codecKey, n2);
            return n2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007f, code lost:
        if (r1.f6747b == false) goto L_0x0081;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0101 A[SYNTHETIC, Splitter:B:60:0x0101] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x012a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<androidx.media3.exoplayer.mediacodec.MediaCodecInfo> u(androidx.media3.exoplayer.mediacodec.MediaCodecUtil.CodecKey r24, androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat r25) throws androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
            r1 = r24
            r2 = r25
            java.lang.String r3 = "secure-playback"
            java.lang.String r4 = "tunneled-playback"
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x014f }
            r5.<init>()     // Catch:{ Exception -> 0x014f }
            java.lang.String r15 = r1.f6746a     // Catch:{ Exception -> 0x014f }
            int r14 = r25.d()     // Catch:{ Exception -> 0x014f }
            boolean r13 = r25.e()     // Catch:{ Exception -> 0x014f }
            r0 = 0
            r12 = 0
        L_0x0019:
            if (r12 >= r14) goto L_0x014e
            android.media.MediaCodecInfo r0 = r2.a(r12)     // Catch:{ Exception -> 0x014f }
            boolean r6 = C(r0)     // Catch:{ Exception -> 0x014f }
            if (r6 == 0) goto L_0x002d
        L_0x0025:
            r22 = r12
            r23 = r13
            r18 = r14
            goto L_0x0120
        L_0x002d:
            java.lang.String r11 = r0.getName()     // Catch:{ Exception -> 0x014f }
            boolean r6 = E(r0, r11, r13, r15)     // Catch:{ Exception -> 0x014f }
            if (r6 != 0) goto L_0x0038
            goto L_0x0025
        L_0x0038:
            java.lang.String r10 = q(r0, r11, r15)     // Catch:{ Exception -> 0x014f }
            if (r10 != 0) goto L_0x003f
            goto L_0x0025
        L_0x003f:
            android.media.MediaCodecInfo$CodecCapabilities r9 = r0.getCapabilitiesForType(r10)     // Catch:{ Exception -> 0x00ef }
            boolean r6 = r2.b(r4, r10, r9)     // Catch:{ Exception -> 0x00ef }
            boolean r7 = r2.c(r4, r10, r9)     // Catch:{ Exception -> 0x00ef }
            boolean r8 = r1.f6748c     // Catch:{ Exception -> 0x00ef }
            if (r8 != 0) goto L_0x0051
            if (r7 != 0) goto L_0x0025
        L_0x0051:
            if (r8 == 0) goto L_0x0056
            if (r6 != 0) goto L_0x0056
            goto L_0x0025
        L_0x0056:
            boolean r6 = r2.b(r3, r10, r9)     // Catch:{ Exception -> 0x00ef }
            boolean r7 = r2.c(r3, r10, r9)     // Catch:{ Exception -> 0x00ef }
            boolean r8 = r1.f6747b     // Catch:{ Exception -> 0x00ef }
            if (r8 != 0) goto L_0x0064
            if (r7 != 0) goto L_0x0025
        L_0x0064:
            if (r8 == 0) goto L_0x0069
            if (r6 != 0) goto L_0x0069
            goto L_0x0025
        L_0x0069:
            boolean r16 = F(r0, r15)     // Catch:{ Exception -> 0x00ef }
            boolean r17 = H(r0, r15)     // Catch:{ Exception -> 0x00ef }
            boolean r0 = J(r0)     // Catch:{ Exception -> 0x00ef }
            if (r13 == 0) goto L_0x007b
            boolean r7 = r1.f6747b     // Catch:{ Exception -> 0x00ef }
            if (r7 == r6) goto L_0x0081
        L_0x007b:
            if (r13 != 0) goto L_0x00b3
            boolean r7 = r1.f6747b     // Catch:{ Exception -> 0x00a8 }
            if (r7 != 0) goto L_0x00b3
        L_0x0081:
            r18 = 0
            r19 = 0
            r6 = r11
            r7 = r15
            r8 = r10
            r20 = r10
            r10 = r16
            r21 = r11
            r11 = r17
            r22 = r12
            r12 = r0
            r23 = r13
            r13 = r18
            r18 = r14
            r14 = r19
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r0 = androidx.media3.exoplayer.mediacodec.MediaCodecInfo.C(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x00a4 }
            r5.add(r0)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x0120
        L_0x00a4:
            r0 = move-exception
            r1 = r21
            goto L_0x00f9
        L_0x00a8:
            r0 = move-exception
            r20 = r10
            r22 = r12
            r23 = r13
            r18 = r14
            r1 = r11
            goto L_0x00f9
        L_0x00b3:
            r20 = r10
            r21 = r11
            r22 = r12
            r23 = r13
            r18 = r14
            if (r23 != 0) goto L_0x0120
            if (r6 == 0) goto L_0x0120
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a4 }
            r6.<init>()     // Catch:{ Exception -> 0x00a4 }
            r14 = r21
            r6.append(r14)     // Catch:{ Exception -> 0x00ec }
            java.lang.String r7 = ".secure"
            r6.append(r7)     // Catch:{ Exception -> 0x00ec }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00ec }
            r13 = 0
            r19 = 1
            r7 = r15
            r8 = r20
            r10 = r16
            r11 = r17
            r12 = r0
            r1 = r14
            r14 = r19
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r0 = androidx.media3.exoplayer.mediacodec.MediaCodecInfo.C(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x00ea }
            r5.add(r0)     // Catch:{ Exception -> 0x00ea }
            return r5
        L_0x00ea:
            r0 = move-exception
            goto L_0x00f9
        L_0x00ec:
            r0 = move-exception
            r1 = r14
            goto L_0x00f9
        L_0x00ef:
            r0 = move-exception
            r20 = r10
            r1 = r11
            r22 = r12
            r23 = r13
            r18 = r14
        L_0x00f9:
            int r6 = androidx.media3.common.util.Util.f4714a     // Catch:{ Exception -> 0x014f }
            r7 = 23
            java.lang.String r8 = "MediaCodecUtil"
            if (r6 > r7) goto L_0x012a
            boolean r6 = r5.isEmpty()     // Catch:{ Exception -> 0x014f }
            if (r6 != 0) goto L_0x012a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014f }
            r0.<init>()     // Catch:{ Exception -> 0x014f }
            java.lang.String r6 = "Skipping codec "
            r0.append(r6)     // Catch:{ Exception -> 0x014f }
            r0.append(r1)     // Catch:{ Exception -> 0x014f }
            java.lang.String r1 = " (failed to query capabilities)"
            r0.append(r1)     // Catch:{ Exception -> 0x014f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x014f }
            androidx.media3.common.util.Log.c(r8, r0)     // Catch:{ Exception -> 0x014f }
        L_0x0120:
            int r12 = r22 + 1
            r1 = r24
            r14 = r18
            r13 = r23
            goto L_0x0019
        L_0x012a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014f }
            r2.<init>()     // Catch:{ Exception -> 0x014f }
            java.lang.String r3 = "Failed to query codec "
            r2.append(r3)     // Catch:{ Exception -> 0x014f }
            r2.append(r1)     // Catch:{ Exception -> 0x014f }
            java.lang.String r1 = " ("
            r2.append(r1)     // Catch:{ Exception -> 0x014f }
            r1 = r20
            r2.append(r1)     // Catch:{ Exception -> 0x014f }
            java.lang.String r1 = ")"
            r2.append(r1)     // Catch:{ Exception -> 0x014f }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x014f }
            androidx.media3.common.util.Log.c(r8, r1)     // Catch:{ Exception -> 0x014f }
            throw r0     // Catch:{ Exception -> 0x014f }
        L_0x014e:
            return r5
        L_0x014f:
            r0 = move-exception
            androidx.media3.exoplayer.mediacodec.MediaCodecUtil$DecoderQueryException r1 = new androidx.media3.exoplayer.mediacodec.MediaCodecUtil$DecoderQueryException
            r2 = 0
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.u(androidx.media3.exoplayer.mediacodec.MediaCodecUtil$CodecKey, androidx.media3.exoplayer.mediacodec.MediaCodecUtil$MediaCodecListCompat):java.util.ArrayList");
    }

    @RequiresNonNull({"#2.sampleMimeType"})
    public static List<MediaCodecInfo> v(MediaCodecSelector mediaCodecSelector, Format format, boolean z2, boolean z3) throws DecoderQueryException {
        List<MediaCodecInfo> a2 = mediaCodecSelector.a(format.f4015n, z2, z3);
        return ImmutableList.k().j(a2).j(n(mediaCodecSelector, format, z2, z3)).k();
    }

    public static List<MediaCodecInfo> w(List<MediaCodecInfo> list, Format format) {
        ArrayList arrayList = new ArrayList(list);
        R(arrayList, new t(format));
        return arrayList;
    }

    public static MediaCodecInfo x() throws DecoderQueryException {
        return s("audio/raw", false, false);
    }

    private static Pair<Integer, Integer> y(String str, String[] strArr) {
        if (strArr.length < 3) {
            Log.h("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = f6743a.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.h("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        Integer k2 = k(group);
        if (k2 == null) {
            Log.h("MediaCodecUtil", "Unknown Dolby Vision profile string: " + group);
            return null;
        }
        String str2 = strArr[2];
        Integer j2 = j(str2);
        if (j2 != null) {
            return new Pair<>(k2, j2);
        }
        Log.h("MediaCodecUtil", "Unknown Dolby Vision level string: " + str2);
        return null;
    }

    private static Pair<Integer, Integer> z(String str, String[] strArr, ColorInfo colorInfo) {
        if (strArr.length < 4) {
            Log.h("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i2 = 1;
        Matcher matcher = f6743a.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.h("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        if (!"1".equals(group)) {
            if (!TraktV2.API_VERSION.equals(group)) {
                Log.h("MediaCodecUtil", "Unknown HEVC profile string: " + group);
                return null;
            } else if (colorInfo == null || colorInfo.f3945c != 6) {
                i2 = 2;
            } else {
                i2 = CodedOutputStream.DEFAULT_BUFFER_SIZE;
            }
        }
        String str2 = strArr[3];
        Integer B = B(str2);
        if (B != null) {
            return new Pair<>(Integer.valueOf(i2), B);
        }
        Log.h("MediaCodecUtil", "Unknown HEVC level string: " + str2);
        return null;
    }
}
