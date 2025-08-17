package com.facebook.imagepipeline.transcoder;

import com.facebook.infer.annotation.Nullsafe;
import java.util.Locale;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ImageTranscodeResult {
    private final int mTranscodeStatus;

    public ImageTranscodeResult(int i2) {
        this.mTranscodeStatus = i2;
    }

    public int getTranscodeStatus() {
        return this.mTranscodeStatus;
    }

    public String toString() {
        return String.format((Locale) null, "Status: %d", new Object[]{Integer.valueOf(this.mTranscodeStatus)});
    }
}
