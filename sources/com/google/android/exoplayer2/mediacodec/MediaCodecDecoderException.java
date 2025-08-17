package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import com.google.android.exoplayer2.decoder.DecoderException;

public class MediaCodecDecoderException extends DecoderException {

    /* renamed from: b  reason: collision with root package name */
    public final MediaCodecInfo f25271b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25272c;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MediaCodecDecoderException(java.lang.Throwable r4, com.google.android.exoplayer2.mediacodec.MediaCodecInfo r5) {
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
            java.lang.String r2 = r5.f25273a
        L_0x0011:
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0, r4)
            r3.f25271b = r5
            int r5 = com.google.android.exoplayer2.util.Util.f28808a
            r0 = 21
            if (r5 < r0) goto L_0x0027
            java.lang.String r1 = a(r4)
        L_0x0027:
            r3.f25272c = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException.<init>(java.lang.Throwable, com.google.android.exoplayer2.mediacodec.MediaCodecInfo):void");
    }

    private static String a(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        return null;
    }
}
