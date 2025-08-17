package com.facebook.imagepipeline.transformation;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public final class TransformationUtils {
    public static boolean maybeApplyTransformation(BitmapTransformation bitmapTransformation, CloseableReference<Bitmap> closeableReference) {
        if (bitmapTransformation == null || closeableReference == null) {
            return false;
        }
        Bitmap bitmap = closeableReference.get();
        if (bitmapTransformation.modifiesTransparency()) {
            bitmap.setHasAlpha(true);
        }
        bitmapTransformation.transform(bitmap);
        return true;
    }
}
