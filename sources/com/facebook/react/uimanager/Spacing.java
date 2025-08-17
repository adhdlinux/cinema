package com.facebook.react.uimanager;

import com.facebook.yoga.YogaConstants;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.util.Arrays;

public class Spacing {
    public static final int ALL = 8;
    public static final int BOTTOM = 3;
    public static final int END = 5;
    public static final int HORIZONTAL = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    public static final int START = 4;
    public static final int TOP = 1;
    public static final int VERTICAL = 7;
    private static final int[] sFlagsMap = {1, 2, 4, 8, 16, 32, 64, 128, UserVerificationMethods.USER_VERIFY_HANDPRINT};
    private final float mDefaultValue;
    private boolean mHasAliasesSet;
    private final float[] mSpacing;
    private int mValueFlags;

    public Spacing() {
        this(0.0f);
    }

    private static float[] newFullSpacingArray() {
        return new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
    }

    public float get(int i2) {
        float f2;
        char c2;
        if (i2 == 4 || i2 == 5) {
            f2 = Float.NaN;
        } else {
            f2 = this.mDefaultValue;
        }
        int i3 = this.mValueFlags;
        if (i3 == 0) {
            return f2;
        }
        int[] iArr = sFlagsMap;
        if ((iArr[i2] & i3) != 0) {
            return this.mSpacing[i2];
        }
        if (this.mHasAliasesSet) {
            if (i2 == 1 || i2 == 3) {
                c2 = 7;
            } else {
                c2 = 6;
            }
            if ((iArr[c2] & i3) != 0) {
                return this.mSpacing[c2];
            }
            if ((i3 & iArr[8]) != 0) {
                return this.mSpacing[8];
            }
        }
        return f2;
    }

    public float getRaw(int i2) {
        return this.mSpacing[i2];
    }

    /* access modifiers changed from: package-private */
    public float getWithFallback(int i2, int i3) {
        return (this.mValueFlags & sFlagsMap[i2]) != 0 ? this.mSpacing[i2] : get(i3);
    }

    public void reset() {
        Arrays.fill(this.mSpacing, Float.NaN);
        this.mHasAliasesSet = false;
        this.mValueFlags = 0;
    }

    public boolean set(int i2, float f2) {
        boolean z2 = false;
        if (FloatUtil.floatsEqual(this.mSpacing[i2], f2)) {
            return false;
        }
        this.mSpacing[i2] = f2;
        if (YogaConstants.isUndefined(f2)) {
            this.mValueFlags = (~sFlagsMap[i2]) & this.mValueFlags;
        } else {
            this.mValueFlags = sFlagsMap[i2] | this.mValueFlags;
        }
        int i3 = this.mValueFlags;
        int[] iArr = sFlagsMap;
        if (!((iArr[8] & i3) == 0 && (iArr[7] & i3) == 0 && (i3 & iArr[6]) == 0)) {
            z2 = true;
        }
        this.mHasAliasesSet = z2;
        return true;
    }

    public Spacing(float f2) {
        this.mValueFlags = 0;
        this.mDefaultValue = f2;
        this.mSpacing = newFullSpacingArray();
    }

    public Spacing(Spacing spacing) {
        this.mValueFlags = 0;
        this.mDefaultValue = spacing.mDefaultValue;
        float[] fArr = spacing.mSpacing;
        this.mSpacing = Arrays.copyOf(fArr, fArr.length);
        this.mValueFlags = spacing.mValueFlags;
        this.mHasAliasesSet = spacing.mHasAliasesSet;
    }
}
