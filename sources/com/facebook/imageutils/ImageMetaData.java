package com.facebook.imageutils;

import android.graphics.ColorSpace;
import android.util.Pair;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ImageMetaData {
    private final ColorSpace mColorSpace;
    private final Pair<Integer, Integer> mDimensions;

    public ImageMetaData(int i2, int i3, ColorSpace colorSpace) {
        Pair<Integer, Integer> pair;
        if (i2 == -1 || i3 == -1) {
            pair = null;
        } else {
            pair = new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.mDimensions = pair;
        this.mColorSpace = colorSpace;
    }

    public ColorSpace getColorSpace() {
        return this.mColorSpace;
    }

    public Pair<Integer, Integer> getDimensions() {
        return this.mDimensions;
    }
}
