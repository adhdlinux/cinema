package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
@DoNotStrip
public class NativeRoundingFilter {
    static {
        NativeFiltersLoader.load();
    }

    public static void addRoundedCorners(Bitmap bitmap, int i2, int i3, int i4, int i5) {
        nativeAddRoundedCornersFilter(bitmap, i2, i3, i4, i5);
    }

    @DoNotStrip
    private static native void nativeAddRoundedCornersFilter(Bitmap bitmap, int i2, int i3, int i4, int i5);

    @DoNotStrip
    private static native void nativeToCircleFastFilter(Bitmap bitmap, boolean z2);

    @DoNotStrip
    private static native void nativeToCircleFilter(Bitmap bitmap, boolean z2);

    @DoNotStrip
    private static native void nativeToCircleWithBorderFilter(Bitmap bitmap, int i2, int i3, boolean z2);

    public static void toCircle(Bitmap bitmap) {
        toCircle(bitmap, false);
    }

    public static void toCircleFast(Bitmap bitmap) {
        toCircleFast(bitmap, false);
    }

    public static void toCircleWithBorder(Bitmap bitmap, int i2, int i3, boolean z2) {
        Preconditions.checkNotNull(bitmap);
        if (bitmap.getWidth() >= 3 && bitmap.getHeight() >= 3) {
            nativeToCircleWithBorderFilter(bitmap, i2, i3, z2);
        }
    }

    @DoNotStrip
    public static void toCircle(Bitmap bitmap, boolean z2) {
        Preconditions.checkNotNull(bitmap);
        if (bitmap.getWidth() >= 3 && bitmap.getHeight() >= 3) {
            nativeToCircleFilter(bitmap, z2);
        }
    }

    @DoNotStrip
    public static void toCircleFast(Bitmap bitmap, boolean z2) {
        Preconditions.checkNotNull(bitmap);
        if (bitmap.getWidth() >= 3 && bitmap.getHeight() >= 3) {
            nativeToCircleFastFilter(bitmap, z2);
        }
    }
}
