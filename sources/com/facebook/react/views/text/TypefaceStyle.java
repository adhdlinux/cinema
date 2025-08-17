package com.facebook.react.views.text;

import android.graphics.Typeface;
import android.os.Build;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
class TypefaceStyle {
    public static final int BOLD = 700;
    private static final int MAX_WEIGHT = 1000;
    private static final int MIN_WEIGHT = 1;
    public static final int NORMAL = 400;
    private final boolean mItalic;
    private final int mWeight;

    public TypefaceStyle(int i2, boolean z2) {
        this.mItalic = z2;
        this.mWeight = i2 == -1 ? 400 : i2;
    }

    public Typeface apply(Typeface typeface) {
        if (Build.VERSION.SDK_INT < 28) {
            return Typeface.create(typeface, getNearestStyle());
        }
        return Typeface.create(typeface, this.mWeight, this.mItalic);
    }

    public int getNearestStyle() {
        if (this.mWeight < 700) {
            if (this.mItalic) {
                return 2;
            }
            return 0;
        } else if (this.mItalic) {
            return 3;
        } else {
            return 1;
        }
    }

    public TypefaceStyle(int i2) {
        boolean z2 = false;
        i2 = i2 == -1 ? 0 : i2;
        this.mItalic = (i2 & 2) != 0 ? true : z2;
        this.mWeight = (i2 & 1) != 0 ? BOLD : 400;
    }

    public TypefaceStyle(int i2, int i3) {
        boolean z2 = false;
        i2 = i2 == -1 ? 0 : i2;
        this.mItalic = (i2 & 2) != 0 ? true : z2;
        this.mWeight = i3 == -1 ? (i2 & 1) != 0 ? BOLD : 400 : i3;
    }
}
