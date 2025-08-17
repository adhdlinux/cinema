package com.google.android.exoplayer2.extractor.avi;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.unity3d.services.core.device.MimeTypes;

final class StreamFormatChunk implements AviChunk {

    /* renamed from: a  reason: collision with root package name */
    public final Format f24340a;

    public StreamFormatChunk(Format format) {
        this.f24340a = format;
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
            Log.i("StreamFormatChunk", "Ignoring track with unsupported compression " + u4);
            return null;
        }
        Format.Builder builder = new Format.Builder();
        builder.n0(u2).S(u3).g0(a2);
        return new StreamFormatChunk(builder.G());
    }

    public static AviChunk d(int i2, ParsableByteArray parsableByteArray) {
        if (i2 == 2) {
            return c(parsableByteArray);
        }
        if (i2 == 1) {
            return e(parsableByteArray);
        }
        Log.i("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + Util.n0(i2));
        return null;
    }

    private static AviChunk e(ParsableByteArray parsableByteArray) {
        int z2 = parsableByteArray.z();
        String b2 = b(z2);
        if (b2 == null) {
            Log.i("StreamFormatChunk", "Ignoring track with unsupported format tag " + z2);
            return null;
        }
        int z3 = parsableByteArray.z();
        int u2 = parsableByteArray.u();
        parsableByteArray.V(6);
        int d02 = Util.d0(parsableByteArray.N());
        int z4 = parsableByteArray.z();
        byte[] bArr = new byte[z4];
        parsableByteArray.l(bArr, 0, z4);
        Format.Builder builder = new Format.Builder();
        builder.g0(b2).J(z3).h0(u2);
        if ("audio/raw".equals(b2) && d02 != 0) {
            builder.a0(d02);
        }
        if ("audio/mp4a-latm".equals(b2) && z4 > 0) {
            builder.V(ImmutableList.s(bArr));
        }
        return new StreamFormatChunk(builder.G());
    }

    public int getType() {
        return 1718776947;
    }
}
