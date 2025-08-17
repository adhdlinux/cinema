package com.facebook.drawee.backends.pipeline.debug;

import android.util.SparseIntArray;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class DebugOverlayImageOriginColor {
    private static final SparseIntArray IMAGE_ORIGIN_COLOR_MAP;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(7);
        IMAGE_ORIGIN_COLOR_MAP = sparseIntArray;
        sparseIntArray.append(1, -7829368);
        sparseIntArray.append(2, -65536);
        sparseIntArray.append(3, -256);
        sparseIntArray.append(4, -256);
        sparseIntArray.append(5, -16711936);
        sparseIntArray.append(6, -16711936);
        sparseIntArray.append(7, -16711936);
    }

    public static int getImageOriginColor(int i2) {
        return IMAGE_ORIGIN_COLOR_MAP.get(i2, -1);
    }
}
