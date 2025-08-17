package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public final class InPlaceRoundFilter {
    private InPlaceRoundFilter() {
    }

    public static void roundBitmapInPlace(Bitmap bitmap) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        Preconditions.checkNotNull(bitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int min = Math.min(width, height) / 2;
        int i2 = width / 2;
        int i3 = height / 2;
        if (min != 0) {
            if (min >= 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(Boolean.valueOf(z2));
            if (width <= 0 || ((float) width) > 2048.0f) {
                z3 = false;
            } else {
                z3 = true;
            }
            Preconditions.checkArgument(Boolean.valueOf(z3));
            if (height <= 0 || ((float) height) > 2048.0f) {
                z4 = false;
            } else {
                z4 = true;
            }
            Preconditions.checkArgument(Boolean.valueOf(z4));
            if (i2 <= 0 || i2 >= width) {
                z5 = false;
            } else {
                z5 = true;
            }
            Preconditions.checkArgument(Boolean.valueOf(z5));
            if (i3 <= 0 || i3 >= height) {
                z6 = false;
            } else {
                z6 = true;
            }
            Preconditions.checkArgument(Boolean.valueOf(z6));
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int i4 = min - 1;
            int i5 = i2 + i4;
            int i6 = i3 + i4;
            int i7 = i3 - i4;
            if (i2 - i4 < 0 || i7 < 0 || i5 >= width || i6 >= height) {
                z7 = false;
            } else {
                z7 = true;
            }
            Preconditions.checkArgument(Boolean.valueOf(z7));
            int i8 = (-min) * 2;
            int[] iArr2 = new int[width];
            int i9 = i8 + 1;
            int i10 = 0;
            int i11 = 1;
            int i12 = 1;
            while (i4 >= i10) {
                int i13 = i2 + i4;
                int i14 = i2 - i4;
                int i15 = i2 + i10;
                int i16 = min;
                int i17 = i2 - i10;
                int i18 = i3 + i4;
                int i19 = i3 - i4;
                int i20 = i2;
                int i21 = i3 + i10;
                int i22 = i3 - i10;
                if (i4 < 0 || i15 >= width || i17 < 0 || i21 >= height || i22 < 0) {
                    z8 = false;
                } else {
                    z8 = true;
                }
                Preconditions.checkArgument(Boolean.valueOf(z8));
                int i23 = i21 * width;
                int i24 = height;
                int i25 = width * i22;
                int i26 = i3;
                int i27 = width * i18;
                int i28 = i8;
                int i29 = width * i19;
                int i30 = i11;
                System.arraycopy(iArr2, 0, iArr, i23, i14);
                System.arraycopy(iArr2, 0, iArr, i25, i14);
                System.arraycopy(iArr2, 0, iArr, i27, i17);
                System.arraycopy(iArr2, 0, iArr, i29, i17);
                int i31 = width - i13;
                System.arraycopy(iArr2, 0, iArr, i23 + i13, i31);
                System.arraycopy(iArr2, 0, iArr, i25 + i13, i31);
                int i32 = width - i15;
                System.arraycopy(iArr2, 0, iArr, i27 + i15, i32);
                System.arraycopy(iArr2, 0, iArr, i29 + i15, i32);
                if (i9 <= 0) {
                    i10++;
                    i12 += 2;
                    i9 += i12;
                }
                if (i9 > 0) {
                    i4--;
                    i11 = i30 + 2;
                    i9 += i11 + i28;
                    min = i16;
                    i8 = i28;
                } else {
                    min = i16;
                    i8 = i28;
                    i11 = i30;
                }
                i2 = i20;
                i3 = i26;
                height = i24;
            }
            int i33 = height;
            int i34 = min;
            int i35 = i3;
            for (int i36 = i35 - i34; i36 >= 0; i36--) {
                System.arraycopy(iArr2, 0, iArr, i36 * width, width);
            }
            int i37 = i33;
            for (int i38 = i35 + i34; i38 < i37; i38++) {
                System.arraycopy(iArr2, 0, iArr, i38 * width, width);
            }
            bitmap.setPixels(iArr, 0, width, 0, 0, width, i37);
        }
    }
}
