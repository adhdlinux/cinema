package com.facebook.imageformat;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ImageFormat {
    public static final ImageFormat UNKNOWN = new ImageFormat("UNKNOWN", (String) null);
    private final String mFileExtension;
    private final String mName;

    public interface FormatChecker {
        ImageFormat determineFormat(byte[] bArr, int i2);

        int getHeaderSize();
    }

    public ImageFormat(String str, String str2) {
        this.mName = str;
        this.mFileExtension = str2;
    }

    public String getFileExtension() {
        return this.mFileExtension;
    }

    public String getName() {
        return this.mName;
    }

    public String toString() {
        return getName();
    }
}
