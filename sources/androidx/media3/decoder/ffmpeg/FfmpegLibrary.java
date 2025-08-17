package androidx.media3.decoder.ffmpeg;

import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.LibraryLoader;
import androidx.media3.common.util.Log;
import com.google.android.gms.cast.HlsSegmentFormat;

public final class FfmpegLibrary {

    /* renamed from: a  reason: collision with root package name */
    private static final LibraryLoader f5109a = new LibraryLoader("ffmpegJNI") {
        /* access modifiers changed from: protected */
        public void b(String str) {
            System.loadLibrary(str);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static String f5110b;

    /* renamed from: c  reason: collision with root package name */
    private static int f5111c = -1;

    static {
        MediaLibraryInfo.a("media3.decoder.ffmpeg");
    }

    private FfmpegLibrary() {
    }

    static String a(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1606874997:
                if (str.equals("audio/amr-wb")) {
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
            case -1003765268:
                if (str.equals("audio/vorbis")) {
                    c2 = 3;
                    break;
                }
                break;
            case -432837260:
                if (str.equals("audio/mpeg-L1")) {
                    c2 = 4;
                    break;
                }
                break;
            case -432837259:
                if (str.equals("audio/mpeg-L2")) {
                    c2 = 5;
                    break;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c2 = 6;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1503095341:
                if (str.equals("audio/3gpp")) {
                    c2 = 8;
                    break;
                }
                break;
            case 1504470054:
                if (str.equals("audio/alac")) {
                    c2 = 9;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c2 = 10;
                    break;
                }
                break;
            case 1504619009:
                if (str.equals("audio/flac")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c2 = 12;
                    break;
                }
                break;
            case 1504891608:
                if (str.equals("audio/opus")) {
                    c2 = 13;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c2 = 14;
                    break;
                }
                break;
            case 1556697186:
                if (str.equals("audio/true-hd")) {
                    c2 = 15;
                    break;
                }
                break;
            case 1903231877:
                if (str.equals("audio/g711-alaw")) {
                    c2 = 16;
                    break;
                }
                break;
            case 1903589369:
                if (str.equals("audio/g711-mlaw")) {
                    c2 = 17;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 10:
                return "eac3";
            case 1:
                return "amrwb";
            case 2:
            case 14:
                return "dca";
            case 3:
                return "vorbis";
            case 4:
            case 5:
            case 12:
                return HlsSegmentFormat.MP3;
            case 6:
                return HlsSegmentFormat.AAC;
            case 7:
                return HlsSegmentFormat.AC3;
            case 8:
                return "amrnb";
            case 9:
                return "alac";
            case 11:
                return "flac";
            case 13:
                return "opus";
            case 15:
                return "truehd";
            case 16:
                return "pcm_alaw";
            case 17:
                return "pcm_mulaw";
            default:
                return null;
        }
    }

    public static int b() {
        if (!d()) {
            return -1;
        }
        if (f5111c == -1) {
            f5111c = ffmpegGetInputBufferPaddingSize();
        }
        return f5111c;
    }

    public static String c() {
        if (!d()) {
            return null;
        }
        if (f5110b == null) {
            f5110b = ffmpegGetVersion();
        }
        return f5110b;
    }

    public static boolean d() {
        return f5109a.a();
    }

    public static boolean e(String str) {
        String a2;
        if (!d() || (a2 = a(str)) == null) {
            return false;
        }
        if (ffmpegHasDecoder(a2)) {
            return true;
        }
        Log.h("FfmpegLibrary", "No " + a2 + " decoder available. Check the FFmpeg build configuration.");
        return false;
    }

    private static native int ffmpegGetInputBufferPaddingSize();

    private static native String ffmpegGetVersion();

    private static native boolean ffmpegHasDecoder(String str);
}
