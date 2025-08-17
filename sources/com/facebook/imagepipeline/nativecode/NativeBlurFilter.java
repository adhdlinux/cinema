package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
@DoNotStrip
public class NativeBlurFilter {
    static {
        NativeFiltersLoader.load();
    }

    public static void iterativeBoxBlur(Bitmap bitmap, int i2, int i3) {
        boolean z2;
        Preconditions.checkNotNull(bitmap);
        boolean z3 = true;
        if (i2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        if (i3 <= 0) {
            z3 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z3));
        nativeIterativeBoxBlur(bitmap, i2, i3);
    }

    @DoNotStrip
    private static native void nativeIterativeBoxBlur(Bitmap bitmap, int i2, int i3);
}
