package androidx.media3.common;

import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.dataflow.qual.Pure;

public final class MimeTypes {

    /* renamed from: a  reason: collision with root package name */
    private static final ArrayList<CustomMimeType> f4285a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f4286b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    private static final class CustomMimeType {

        /* renamed from: a  reason: collision with root package name */
        public final String f4287a;

        /* renamed from: b  reason: collision with root package name */
        public final String f4288b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4289c;
    }

    static final class Mp4aObjectType {

        /* renamed from: a  reason: collision with root package name */
        public final int f4290a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4291b;

        public Mp4aObjectType(int i2, int i3) {
            this.f4290a = i2;
            this.f4291b = i3;
        }

        public int a() {
            int i2 = this.f4291b;
            if (i2 == 2) {
                return 10;
            }
            if (i2 == 5) {
                return 11;
            }
            if (i2 == 29) {
                return 12;
            }
            if (i2 == 42) {
                return 16;
            }
            if (i2 != 22) {
                return i2 != 23 ? 0 : 15;
            }
            return 1073741824;
        }
    }

    private MimeTypes() {
    }

    public static boolean a(String str, String str2) {
        Mp4aObjectType i2;
        int a2;
        if (str == null) {
            return false;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c2 = 0;
                    break;
                }
                break;
            case -432837260:
                if (str.equals("audio/mpeg-L1")) {
                    c2 = 1;
                    break;
                }
                break;
            case -432837259:
                if (str.equals("audio/mpeg-L2")) {
                    c2 = 2;
                    break;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c2 = 3;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c2 = 4;
                    break;
                }
                break;
            case 187094639:
                if (str.equals("audio/raw")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1504619009:
                if (str.equals("audio/flac")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c2 = 8;
                    break;
                }
                break;
            case 1903231877:
                if (str.equals("audio/g711-alaw")) {
                    c2 = 9;
                    break;
                }
                break;
            case 1903589369:
                if (str.equals("audio/g711-mlaw")) {
                    c2 = 10;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return true;
            case 3:
                if (str2 == null || (i2 = i(str2)) == null || (a2 = i2.a()) == 0 || a2 == 16) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    public static boolean b(String str, String str2) {
        return d(str, str2) != null;
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        for (String g2 : Util.m1(str)) {
            String g3 = g(g2);
            if (g3 != null && o(g3)) {
                return g3;
            }
        }
        return null;
    }

    public static String d(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String[] m12 = Util.m1(str);
        StringBuilder sb = new StringBuilder();
        for (String str3 : m12) {
            if (str2.equals(g(str3))) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str3);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    private static String e(String str) {
        int size = f4285a.size();
        for (int i2 = 0; i2 < size; i2++) {
            CustomMimeType customMimeType = f4285a.get(i2);
            if (str.startsWith(customMimeType.f4288b)) {
                return customMimeType.f4287a;
            }
        }
        return null;
    }

    public static int f(String str, String str2) {
        Mp4aObjectType i2;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1365340241:
                if (str.equals("audio/vnd.dts.hd;profile=lbr")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c2 = 2;
                    break;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c2 = 3;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c2 = 4;
                    break;
                }
                break;
            case 187078297:
                if (str.equals("audio/ac4")) {
                    c2 = 5;
                    break;
                }
                break;
            case 550520934:
                if (str.equals("audio/vnd.dts.uhd;profile=p2")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c2 = 8;
                    break;
                }
                break;
            case 1504891608:
                if (str.equals("audio/opus")) {
                    c2 = 9;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c2 = 10;
                    break;
                }
                break;
            case 1556697186:
                if (str.equals("audio/true-hd")) {
                    c2 = 11;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 18;
            case 1:
                return 8;
            case 2:
                return 7;
            case 3:
                if (str2 == null || (i2 = i(str2)) == null) {
                    return 0;
                }
                return i2.a();
            case 4:
                return 5;
            case 5:
                return 17;
            case 6:
                return 30;
            case 7:
                return 6;
            case 8:
                return 9;
            case 9:
                return 20;
            case 10:
                return 8;
            case 11:
                return 14;
            default:
                return 0;
        }
    }

    public static String g(String str) {
        Mp4aObjectType i2;
        String str2 = null;
        if (str == null) {
            return null;
        }
        String e2 = Ascii.e(str.trim());
        if (e2.startsWith("avc1") || e2.startsWith("avc3")) {
            return com.unity3d.services.core.device.MimeTypes.VIDEO_H264;
        }
        if (e2.startsWith("hev1") || e2.startsWith("hvc1")) {
            return com.unity3d.services.core.device.MimeTypes.VIDEO_H265;
        }
        if (e2.startsWith("dvav") || e2.startsWith("dva1") || e2.startsWith("dvhe") || e2.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (e2.startsWith("av01")) {
            return "video/av01";
        }
        if (e2.startsWith("vp9") || e2.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (e2.startsWith("vp8") || e2.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (e2.startsWith("mp4a")) {
            if (e2.startsWith("mp4a.") && (i2 = i(e2)) != null) {
                str2 = h(i2.f4290a);
            }
            if (str2 == null) {
                return "audio/mp4a-latm";
            }
            return str2;
        } else if (e2.startsWith("mha1")) {
            return "audio/mha1";
        } else {
            if (e2.startsWith("mhm1")) {
                return "audio/mhm1";
            }
            if (e2.startsWith("ac-3") || e2.startsWith("dac3")) {
                return "audio/ac3";
            }
            if (e2.startsWith("ec-3") || e2.startsWith("dec3")) {
                return "audio/eac3";
            }
            if (e2.startsWith("ec+3")) {
                return "audio/eac3-joc";
            }
            if (e2.startsWith("ac-4") || e2.startsWith("dac4")) {
                return "audio/ac4";
            }
            if (e2.startsWith("dtsc")) {
                return "audio/vnd.dts";
            }
            if (e2.startsWith("dtse")) {
                return "audio/vnd.dts.hd;profile=lbr";
            }
            if (e2.startsWith("dtsh") || e2.startsWith("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (e2.startsWith("dtsx")) {
                return "audio/vnd.dts.uhd;profile=p2";
            }
            if (e2.startsWith("opus")) {
                return "audio/opus";
            }
            if (e2.startsWith("vorbis")) {
                return "audio/vorbis";
            }
            if (e2.startsWith("flac")) {
                return "audio/flac";
            }
            if (e2.startsWith("stpp")) {
                return "application/ttml+xml";
            }
            if (e2.startsWith("wvtt")) {
                return "text/vtt";
            }
            if (e2.contains("cea708")) {
                return "application/cea-708";
            }
            if (e2.contains("eia608") || e2.contains("cea608")) {
                return "application/cea-608";
            }
            return e(e2);
        }
    }

    public static String h(int i2) {
        if (i2 == 32) {
            return "video/mp4v-es";
        }
        if (i2 == 33) {
            return com.unity3d.services.core.device.MimeTypes.VIDEO_H264;
        }
        if (i2 == 35) {
            return com.unity3d.services.core.device.MimeTypes.VIDEO_H265;
        }
        if (i2 == 64) {
            return "audio/mp4a-latm";
        }
        if (i2 == 163) {
            return "video/wvc1";
        }
        if (i2 == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i2 == 221) {
            return "audio/vorbis";
        }
        if (i2 == 165) {
            return "audio/ac3";
        }
        if (i2 == 166) {
            return "audio/eac3";
        }
        switch (i2) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            case 108:
                return "image/jpeg";
            default:
                switch (i2) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    static Mp4aObjectType i(String str) {
        int i2;
        Matcher matcher = f4286b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String str2 = (String) Assertions.f(matcher.group(1));
        String group = matcher.group(2);
        try {
            int parseInt = Integer.parseInt(str2, 16);
            if (group != null) {
                i2 = Integer.parseInt(group);
            } else {
                i2 = 0;
            }
            return new Mp4aObjectType(parseInt, i2);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static String j(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    public static int k(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (o(str)) {
            return 1;
        }
        if (s(str)) {
            return 2;
        }
        if (r(str)) {
            return 3;
        }
        if (p(str)) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        return l(str);
    }

    private static int l(String str) {
        int size = f4285a.size();
        for (int i2 = 0; i2 < size; i2++) {
            CustomMimeType customMimeType = f4285a.get(i2);
            if (str.equals(customMimeType.f4287a)) {
                return customMimeType.f4289c;
            }
        }
        return -1;
    }

    public static int m(String str) {
        return k(g(str));
    }

    public static String n(String str) {
        if (str == null) {
            return null;
        }
        for (String g2 : Util.m1(str)) {
            String g3 = g(g2);
            if (g3 != null && s(g3)) {
                return g3;
            }
        }
        return null;
    }

    public static boolean o(String str) {
        return com.unity3d.services.core.device.MimeTypes.BASE_TYPE_AUDIO.equals(j(str));
    }

    public static boolean p(String str) {
        if ("image".equals(j(str)) || "application/x-image-uri".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean q(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith(com.unity3d.services.core.device.MimeTypes.VIDEO_WEBM) || str.startsWith("audio/webm") || str.startsWith("application/webm") || str.startsWith("video/x-matroska") || str.startsWith("audio/x-matroska") || str.startsWith("application/x-matroska")) {
            return true;
        }
        return false;
    }

    @Pure
    public static boolean r(String str) {
        if ("text".equals(j(str)) || "application/x-media3-cues".equals(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean s(String str) {
        return com.unity3d.services.core.device.MimeTypes.BASE_TYPE_VIDEO.equals(j(str));
    }

    public static String t(String str) {
        if (str == null) {
            return null;
        }
        String e2 = Ascii.e(str);
        e2.hashCode();
        char c2 = 65535;
        switch (e2.hashCode()) {
            case -1007807498:
                if (e2.equals("audio/x-flac")) {
                    c2 = 0;
                    break;
                }
                break;
            case -979095690:
                if (e2.equals("application/x-mpegurl")) {
                    c2 = 1;
                    break;
                }
                break;
            case -586683234:
                if (e2.equals("audio/x-wav")) {
                    c2 = 2;
                    break;
                }
                break;
            case -432836268:
                if (e2.equals("audio/mpeg-l1")) {
                    c2 = 3;
                    break;
                }
                break;
            case -432836267:
                if (e2.equals("audio/mpeg-l2")) {
                    c2 = 4;
                    break;
                }
                break;
            case 187090231:
                if (e2.equals("audio/mp3")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return "audio/flac";
            case 1:
                return "application/x-mpegURL";
            case 2:
                return "audio/wav";
            case 3:
                return "audio/mpeg-L1";
            case 4:
                return "audio/mpeg-L2";
            case 5:
                return "audio/mpeg";
            default:
                return e2;
        }
    }
}
