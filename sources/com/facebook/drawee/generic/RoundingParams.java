package com.facebook.drawee.generic;

import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Arrays;

@Nullsafe(Nullsafe.Mode.STRICT)
public class RoundingParams {
    private int mBorderColor = 0;
    private float mBorderWidth = 0.0f;
    private float[] mCornersRadii = null;
    private int mOverlayColor = 0;
    private float mPadding = 0.0f;
    private boolean mPaintFilterBitmap = false;
    private boolean mRoundAsCircle = false;
    private RoundingMethod mRoundingMethod = RoundingMethod.BITMAP_ONLY;
    private boolean mScaleDownInsideBorders = false;

    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public static RoundingParams asCircle() {
        return new RoundingParams().setRoundAsCircle(true);
    }

    public static RoundingParams fromCornersRadii(float f2, float f3, float f4, float f5) {
        return new RoundingParams().setCornersRadii(f2, f3, f4, f5);
    }

    public static RoundingParams fromCornersRadius(float f2) {
        return new RoundingParams().setCornersRadius(f2);
    }

    private float[] getOrCreateRoundedCornersRadii() {
        if (this.mCornersRadii == null) {
            this.mCornersRadii = new float[8];
        }
        return this.mCornersRadii;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.mRoundAsCircle == roundingParams.mRoundAsCircle && this.mOverlayColor == roundingParams.mOverlayColor && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.mRoundingMethod == roundingParams.mRoundingMethod && this.mScaleDownInsideBorders == roundingParams.mScaleDownInsideBorders && this.mPaintFilterBitmap == roundingParams.mPaintFilterBitmap) {
            return Arrays.equals(this.mCornersRadii, roundingParams.mCornersRadii);
        }
        return false;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public float[] getCornersRadii() {
        return this.mCornersRadii;
    }

    public int getOverlayColor() {
        return this.mOverlayColor;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean getPaintFilterBitmap() {
        return this.mPaintFilterBitmap;
    }

    public boolean getRoundAsCircle() {
        return this.mRoundAsCircle;
    }

    public RoundingMethod getRoundingMethod() {
        return this.mRoundingMethod;
    }

    public boolean getScaleDownInsideBorders() {
        return this.mScaleDownInsideBorders;
    }

    public int hashCode() {
        int i2;
        int i3;
        int i4;
        RoundingMethod roundingMethod = this.mRoundingMethod;
        int i5 = 0;
        if (roundingMethod != null) {
            i2 = roundingMethod.hashCode();
        } else {
            i2 = 0;
        }
        int i6 = ((i2 * 31) + (this.mRoundAsCircle ? 1 : 0)) * 31;
        float[] fArr = this.mCornersRadii;
        if (fArr != null) {
            i3 = Arrays.hashCode(fArr);
        } else {
            i3 = 0;
        }
        int i7 = (((i6 + i3) * 31) + this.mOverlayColor) * 31;
        float f2 = this.mBorderWidth;
        if (f2 != 0.0f) {
            i4 = Float.floatToIntBits(f2);
        } else {
            i4 = 0;
        }
        int i8 = (((i7 + i4) * 31) + this.mBorderColor) * 31;
        float f3 = this.mPadding;
        if (f3 != 0.0f) {
            i5 = Float.floatToIntBits(f3);
        }
        return ((((i8 + i5) * 31) + (this.mScaleDownInsideBorders ? 1 : 0)) * 31) + (this.mPaintFilterBitmap ? 1 : 0);
    }

    public RoundingParams setBorder(int i2, float f2) {
        boolean z2;
        if (f2 >= 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "the border width cannot be < 0");
        this.mBorderWidth = f2;
        this.mBorderColor = i2;
        return this;
    }

    public RoundingParams setBorderColor(int i2) {
        this.mBorderColor = i2;
        return this;
    }

    public RoundingParams setBorderWidth(float f2) {
        boolean z2;
        if (f2 >= 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "the border width cannot be < 0");
        this.mBorderWidth = f2;
        return this;
    }

    public RoundingParams setCornersRadii(float f2, float f3, float f4, float f5) {
        float[] orCreateRoundedCornersRadii = getOrCreateRoundedCornersRadii();
        orCreateRoundedCornersRadii[1] = f2;
        orCreateRoundedCornersRadii[0] = f2;
        orCreateRoundedCornersRadii[3] = f3;
        orCreateRoundedCornersRadii[2] = f3;
        orCreateRoundedCornersRadii[5] = f4;
        orCreateRoundedCornersRadii[4] = f4;
        orCreateRoundedCornersRadii[7] = f5;
        orCreateRoundedCornersRadii[6] = f5;
        return this;
    }

    public RoundingParams setCornersRadius(float f2) {
        Arrays.fill(getOrCreateRoundedCornersRadii(), f2);
        return this;
    }

    public RoundingParams setOverlayColor(int i2) {
        this.mOverlayColor = i2;
        this.mRoundingMethod = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public RoundingParams setPadding(float f2) {
        boolean z2;
        if (f2 >= 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "the padding cannot be < 0");
        this.mPadding = f2;
        return this;
    }

    public RoundingParams setPaintFilterBitmap(boolean z2) {
        this.mPaintFilterBitmap = z2;
        return this;
    }

    public RoundingParams setRoundAsCircle(boolean z2) {
        this.mRoundAsCircle = z2;
        return this;
    }

    public RoundingParams setRoundingMethod(RoundingMethod roundingMethod) {
        this.mRoundingMethod = roundingMethod;
        return this;
    }

    public RoundingParams setScaleDownInsideBorders(boolean z2) {
        this.mScaleDownInsideBorders = z2;
        return this;
    }

    public static RoundingParams fromCornersRadii(float[] fArr) {
        return new RoundingParams().setCornersRadii(fArr);
    }

    public RoundingParams setCornersRadii(float[] fArr) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
        System.arraycopy(fArr, 0, getOrCreateRoundedCornersRadii(), 0, 8);
        return this;
    }
}
