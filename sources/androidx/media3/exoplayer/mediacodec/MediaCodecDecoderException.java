package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import androidx.media3.decoder.DecoderException;

public class MediaCodecDecoderException extends DecoderException {

    /* renamed from: b  reason: collision with root package name */
    public final MediaCodecInfo f6684b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6685c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6686d;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MediaCodecDecoderException(java.lang.Throwable r4, androidx.media3.exoplayer.mediacodec.MediaCodecInfo r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Decoder failed: "
            r0.append(r1)
            r1 = 0
            if (r5 != 0) goto L_0x000f
            r2 = r1
            goto L_0x0011
        L_0x000f:
            java.lang.String r2 = r5.f6687a
        L_0x0011:
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0, r4)
            r3.f6684b = r5
            int r5 = androidx.media3.common.util.Util.f4714a
            r0 = 21
            if (r5 < r0) goto L_0x0027
            java.lang.String r1 = a(r4)
        L_0x0027:
            r3.f6685c = r1
            r0 = 23
            if (r5 < r0) goto L_0x0032
            int r4 = b(r4)
            goto L_0x0036
        L_0x0032:
            int r4 = androidx.media3.common.util.Util.Z(r1)
        L_0x0036:
            r3.f6686d = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException.<init>(java.lang.Throwable, androidx.media3.exoplayer.mediacodec.MediaCodecInfo):void");
    }

    private static String a(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        return null;
    }

    private static int b(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getErrorCode();
        }
        return 0;
    }
}
