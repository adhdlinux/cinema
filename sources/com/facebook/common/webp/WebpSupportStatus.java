package com.facebook.common.webp;

import com.facebook.infer.annotation.Nullsafe;
import java.io.UnsupportedEncodingException;

@Nullsafe(Nullsafe.Mode.STRICT)
public class WebpSupportStatus {
    private static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
    private static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
    private static final String VP8X_WEBP_BASE64 = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==";
    private static final byte[] WEBP_NAME_BYTES = asciiBytes("WEBP");
    private static final byte[] WEBP_RIFF_BYTES = asciiBytes("RIFF");
    private static final byte[] WEBP_VP8L_BYTES = asciiBytes("VP8L");
    private static final byte[] WEBP_VP8X_BYTES = asciiBytes("VP8X");
    private static final byte[] WEBP_VP8_BYTES = asciiBytes("VP8 ");
    public static final boolean sIsExtendedWebpSupported = isExtendedWebpSupported();
    public static final boolean sIsSimpleWebpSupported = true;
    public static final boolean sIsWebpSupportRequired = false;
    public static WebpBitmapFactory sWebpBitmapFactory = null;
    private static boolean sWebpLibraryChecked = false;

    private static byte[] asciiBytes(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII not found!", e2);
        }
    }

    public static boolean isAnimatedWebpHeader(byte[] bArr, int i2) {
        boolean z2;
        boolean matchBytePattern = matchBytePattern(bArr, i2 + 12, WEBP_VP8X_BYTES);
        if ((bArr[i2 + 20] & 2) == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!matchBytePattern || !z2) {
            return false;
        }
        return true;
    }

    public static boolean isExtendedWebpHeader(byte[] bArr, int i2, int i3) {
        if (i3 < 21 || !matchBytePattern(bArr, i2 + 12, WEBP_VP8X_BYTES)) {
            return false;
        }
        return true;
    }

    public static boolean isExtendedWebpHeaderWithAlpha(byte[] bArr, int i2) {
        boolean z2;
        boolean matchBytePattern = matchBytePattern(bArr, i2 + 12, WEBP_VP8X_BYTES);
        if ((bArr[i2 + 20] & 16) == 16) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!matchBytePattern || !z2) {
            return false;
        }
        return true;
    }

    private static boolean isExtendedWebpSupported() {
        return true;
    }

    public static boolean isLosslessWebpHeader(byte[] bArr, int i2) {
        return matchBytePattern(bArr, i2 + 12, WEBP_VP8L_BYTES);
    }

    public static boolean isSimpleWebpHeader(byte[] bArr, int i2) {
        return matchBytePattern(bArr, i2 + 12, WEBP_VP8_BYTES);
    }

    public static boolean isWebpHeader(byte[] bArr, int i2, int i3) {
        if (i3 < 20 || !matchBytePattern(bArr, i2, WEBP_RIFF_BYTES) || !matchBytePattern(bArr, i2 + 8, WEBP_NAME_BYTES)) {
            return false;
        }
        return true;
    }

    public static boolean isWebpSupportedByPlatform(byte[] bArr, int i2, int i3) {
        if (isSimpleWebpHeader(bArr, i2)) {
            return sIsSimpleWebpSupported;
        }
        if (isLosslessWebpHeader(bArr, i2)) {
            return sIsExtendedWebpSupported;
        }
        if (!isExtendedWebpHeader(bArr, i2, i3) || isAnimatedWebpHeader(bArr, i2)) {
            return false;
        }
        return sIsExtendedWebpSupported;
    }

    public static WebpBitmapFactory loadWebpBitmapFactoryIfExists() {
        WebpBitmapFactory webpBitmapFactory;
        if (sWebpLibraryChecked) {
            return sWebpBitmapFactory;
        }
        try {
            webpBitmapFactory = (WebpBitmapFactory) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable unused) {
            webpBitmapFactory = null;
        }
        sWebpLibraryChecked = true;
        return webpBitmapFactory;
    }

    private static boolean matchBytePattern(byte[] bArr, int i2, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i2 > bArr.length) {
            return false;
        }
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            if (bArr[i3 + i2] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }
}
