package com.facebook.imagepipeline.nativecode;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class WebpTranscoderFactory {
    private static WebpTranscoder sWebpTranscoder = null;
    public static boolean sWebpTranscoderPresent = false;

    static {
        try {
            sWebpTranscoder = (WebpTranscoder) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            sWebpTranscoderPresent = true;
        } catch (Throwable unused) {
            sWebpTranscoderPresent = false;
        }
    }

    public static WebpTranscoder getWebpTranscoder() {
        return sWebpTranscoder;
    }
}
