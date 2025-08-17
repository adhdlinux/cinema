package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class DrawableProperties {
    private static final int UNSET = -1;
    private int mAlpha = -1;
    private ColorFilter mColorFilter = null;
    private int mDither = -1;
    private int mFilterBitmap = -1;
    private boolean mIsSetColorFilter = false;

    @SuppressLint({"Range"})
    public void applyTo(Drawable drawable) {
        boolean z2;
        if (drawable != null) {
            int i2 = this.mAlpha;
            if (i2 != -1) {
                drawable.setAlpha(i2);
            }
            if (this.mIsSetColorFilter) {
                drawable.setColorFilter(this.mColorFilter);
            }
            int i3 = this.mDither;
            boolean z3 = true;
            if (i3 != -1) {
                if (i3 != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                drawable.setDither(z2);
            }
            int i4 = this.mFilterBitmap;
            if (i4 != -1) {
                if (i4 == 0) {
                    z3 = false;
                }
                drawable.setFilterBitmap(z3);
            }
        }
    }

    public void setAlpha(int i2) {
        this.mAlpha = i2;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        boolean z2;
        this.mColorFilter = colorFilter;
        if (colorFilter != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mIsSetColorFilter = z2;
    }

    public void setDither(boolean z2) {
        this.mDither = z2 ? 1 : 0;
    }

    public void setFilterBitmap(boolean z2) {
        this.mFilterBitmap = z2 ? 1 : 0;
    }
}
