package com.facebook.imageformat;

import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.io.UnsupportedEncodingException;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ImageFormatCheckerUtils {
    private ImageFormatCheckerUtils() {
    }

    public static byte[] asciiBytes(String str) {
        Preconditions.checkNotNull(str);
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII not found!", e2);
        }
    }

    public static boolean hasPatternAt(byte[] bArr, byte[] bArr2, int i2) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkNotNull(bArr2);
        if (bArr2.length + i2 > bArr.length) {
            return false;
        }
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            if (bArr[i2 + i3] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    public static int indexOfPattern(byte[] bArr, int i2, byte[] bArr2, int i3) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkNotNull(bArr2);
        if (i3 > i2) {
            return -1;
        }
        int i4 = 0;
        byte b2 = bArr2[0];
        int i5 = i2 - i3;
        while (i4 <= i5) {
            int i6 = 1;
            if (bArr[i4] != b2) {
                do {
                    i4++;
                    if (i4 > i5) {
                        break;
                    }
                } while (bArr[i4] == b2);
            }
            if (i4 <= i5) {
                int i7 = i4 + 1;
                int i8 = (i7 + i3) - 1;
                while (i7 < i8 && bArr[i7] == bArr2[i6]) {
                    i7++;
                    i6++;
                }
                if (i7 == i8) {
                    return i4;
                }
            }
            i4++;
        }
        return -1;
    }

    public static boolean startsWithPattern(byte[] bArr, byte[] bArr2) {
        return hasPatternAt(bArr, bArr2, 0);
    }
}
