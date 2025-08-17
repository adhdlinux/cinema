package androidx.media3.extractor.avi;

import androidx.media3.common.Format;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.unity3d.services.core.device.MimeTypes;

final class StreamFormatChunk implements AviChunk {

    /* renamed from: a  reason: collision with root package name */
    public final Format f8184a;

    public StreamFormatChunk(Format format) {
        this.f8184a = format;
    }

    private static String a(int i2) {
        switch (i2) {
            case 808802372:
            case 877677894:
            case 1145656883:
            case 1145656920:
            case 1482049860:
            case 1684633208:
            case 2021026148:
                return "video/mp4v-es";
            case 826496577:
            case 828601953:
            case 875967048:
                return MimeTypes.VIDEO_H264;
            case 842289229:
                return "video/mp42";
            case 859066445:
                return "video/mp43";
            case 1196444237:
            case 1735420525:
                return "video/mjpeg";
            default:
                return null;
        }
    }

    private static String b(int i2) {
        if (i2 == 1) {
            return "audio/raw";
        }
        if (i2 == 85) {
            return "audio/mpeg";
        }
        if (i2 == 255) {
            return "audio/mp4a-latm";
        }
        if (i2 == 8192) {
            return "audio/ac3";
        }
        if (i2 != 8193) {
            return null;
        }
        return "audio/vnd.dts";
    }

    private static AviChunk c(ParsableByteArray parsableByteArray) {
        parsableByteArray.V(4);
        int u2 = parsableByteArray.u();
        int u3 = parsableByteArray.u();
        parsableByteArray.V(4);
        int u4 = parsableByteArray.u();
        String a2 = a(u4);
        if (a2 == null) {
            Log.h("StreamFormatChunk", "Ignoring track with unsupported compression " + u4);
            return null;
        }
        Format.Builder builder = new Format.Builder();
        builder.v0(u2).Y(u3).o0(a2);
        return new StreamFormatChunk(builder.K());
    }

    public static AviChunk d(int i2, ParsableByteArray parsableByteArray) {
        if (i2 == 2) {
            return c(parsableByteArray);
        }
        if (i2 == 1) {
            return e(parsableByteArray);
        }
        Log.h("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + Util.s0(i2));
        return null;
    }

    private static AviChunk e(ParsableByteArray parsableByteArray) {
        int i2;
        int z2 = parsableByteArray.z();
        String b2 = b(z2);
        if (b2 == null) {
            Log.h("StreamFormatChunk", "Ignoring track with unsupported format tag " + z2);
            return null;
        }
        int z3 = parsableByteArray.z();
        int u2 = parsableByteArray.u();
        parsableByteArray.V(6);
        int g02 = Util.g0(parsableByteArray.z());
        if (parsableByteArray.a() > 0) {
            i2 = parsableByteArray.z();
        } else {
            i2 = 0;
        }
        byte[] bArr = new byte[i2];
        parsableByteArray.l(bArr, 0, i2);
        Format.Builder builder = new Format.Builder();
        builder.o0(b2).N(z3).p0(u2);
        if ("audio/raw".equals(b2) && g02 != 0) {
            builder.i0(g02);
        }
        if ("audio/mp4a-latm".equals(b2) && i2 > 0) {
            builder.b0(ImmutableList.s(bArr));
        }
        return new StreamFormatChunk(builder.K());
    }

    public int getType() {
        return 1718776947;
    }
}
