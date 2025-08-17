package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.imageutils.JfifUtil;
import com.facebook.infer.annotation.Nullsafe;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.util.Locale;

@Nullsafe(Nullsafe.Mode.STRICT)
public abstract class IterativeBoxBlurFilter {
    private static final String TAG = "IterativeBoxBlurFilter";

    private static int bound(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public static void boxBlurBitmapInPlace(Bitmap bitmap, int i2, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Preconditions.checkNotNull(bitmap);
        Preconditions.checkArgument(Boolean.valueOf(bitmap.isMutable()));
        if (((float) bitmap.getHeight()) <= 2048.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        if (((float) bitmap.getWidth()) <= 2048.0f) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z3));
        if (i3 <= 0 || i3 > 25) {
            z4 = false;
        } else {
            z4 = true;
        }
        Preconditions.checkArgument(Boolean.valueOf(z4));
        if (i2 > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z5));
        try {
            fastBoxBlur(bitmap, i2, i3);
        } catch (OutOfMemoryError e2) {
            FLog.e(TAG, String.format((Locale) null, "OOM: %d iterations on %dx%d with %d radius", new Object[]{Integer.valueOf(i2), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i3)}));
            throw e2;
        }
    }

    private static void fastBoxBlur(Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i4 = i3 + 1;
        int i5 = i4 + i3;
        int[] iArr2 = new int[(i5 * UserVerificationMethods.USER_VERIFY_HANDPRINT)];
        int i6 = 1;
        while (true) {
            if (i6 > 255) {
                break;
            }
            for (int i7 = 0; i7 < i5; i7++) {
                iArr2[i4] = i6;
                i4++;
            }
            i6++;
        }
        int[] iArr3 = new int[Math.max(width, height)];
        int i8 = i2;
        for (int i9 = 0; i9 < i8; i9++) {
            for (int i10 = 0; i10 < height; i10++) {
                internalHorizontalBlur(iArr, iArr3, width, i10, i5, iArr2);
                System.arraycopy(iArr3, 0, iArr, i10 * width, width);
            }
            int i11 = 0;
            while (i11 < width) {
                int i12 = i11;
                internalVerticalBlur(iArr, iArr3, width, height, i11, i5, iArr2);
                int i13 = i12;
                for (int i14 = 0; i14 < height; i14++) {
                    iArr[i13] = iArr3[i14];
                    i13 += width;
                }
                i11 = i12 + 1;
            }
        }
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
    }

    private static void internalHorizontalBlur(int[] iArr, int[] iArr2, int i2, int i3, int i4, int[] iArr3) {
        int i5 = i2 * i3;
        int i6 = ((i3 + 1) * i2) - 1;
        int i7 = i4 >> 1;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = -i7; i12 < i2 + i7; i12++) {
            int i13 = iArr[bound(i5 + i12, i5, i6)];
            i8 += (i13 >> 16) & JfifUtil.MARKER_FIRST_BYTE;
            i9 += (i13 >> 8) & JfifUtil.MARKER_FIRST_BYTE;
            i10 += i13 & JfifUtil.MARKER_FIRST_BYTE;
            i11 += i13 >>> 24;
            if (i12 >= i7) {
                iArr2[i12 - i7] = (iArr3[i11] << 24) | (iArr3[i8] << 16) | (iArr3[i9] << 8) | iArr3[i10];
                int i14 = iArr[bound((i12 - (i4 - 1)) + i5, i5, i6)];
                i8 -= (i14 >> 16) & JfifUtil.MARKER_FIRST_BYTE;
                i9 -= (i14 >> 8) & JfifUtil.MARKER_FIRST_BYTE;
                i10 -= i14 & JfifUtil.MARKER_FIRST_BYTE;
                i11 -= i14 >>> 24;
            }
        }
    }

    private static void internalVerticalBlur(int[] iArr, int[] iArr2, int i2, int i3, int i4, int i5, int[] iArr3) {
        int i6 = ((i3 - 1) * i2) + i4;
        int i7 = (i5 >> 1) * i2;
        int i8 = (i5 - 1) * i2;
        int i9 = i4 - i7;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i9 <= i6 + i7) {
            int i15 = iArr[bound(i9, i4, i6)];
            i10 += (i15 >> 16) & JfifUtil.MARKER_FIRST_BYTE;
            i11 += (i15 >> 8) & JfifUtil.MARKER_FIRST_BYTE;
            i12 += i15 & JfifUtil.MARKER_FIRST_BYTE;
            i13 += i15 >>> 24;
            if (i9 - i7 >= i4) {
                iArr2[i14] = (iArr3[i13] << 24) | (iArr3[i10] << 16) | (iArr3[i11] << 8) | iArr3[i12];
                i14++;
                int i16 = iArr[bound(i9 - i8, i4, i6)];
                i10 -= (i16 >> 16) & JfifUtil.MARKER_FIRST_BYTE;
                i11 -= (i16 >> 8) & JfifUtil.MARKER_FIRST_BYTE;
                i12 -= i16 & JfifUtil.MARKER_FIRST_BYTE;
                i13 -= i16 >>> 24;
            }
            i9 += i2;
        }
    }
}
