package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
@DoNotStrip
public class Bitmaps {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f21909a = 0;

    static {
        ImagePipelineNativeLoader.load();
    }

    @DoNotStrip
    public static void copyBitmap(Bitmap bitmap, Bitmap bitmap2) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (bitmap2.getConfig() == bitmap.getConfig()) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        Preconditions.checkArgument(Boolean.valueOf(bitmap.isMutable()));
        if (bitmap.getWidth() == bitmap2.getWidth()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z3));
        if (bitmap.getHeight() != bitmap2.getHeight()) {
            z4 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z4));
        nativeCopyBitmap(bitmap, bitmap.getRowBytes(), bitmap2, bitmap2.getRowBytes(), bitmap.getHeight());
    }

    @DoNotStrip
    private static native void nativeCopyBitmap(Bitmap bitmap, int i2, Bitmap bitmap2, int i3, int i4);
}
