package com.facebook.react.views.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;

public final class DefaultStyleValuesUtil {
    private DefaultStyleValuesUtil() {
        throw new AssertionError("Never invoke this for an Utility class!");
    }

    private static ColorStateList getDefaultTextAttribute(Context context, int i2) {
        TypedArray typedArray = null;
        try {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i2});
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
            obtainStyledAttributes.recycle();
            return colorStateList;
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
    }

    public static ColorStateList getDefaultTextColor(Context context) {
        return getDefaultTextAttribute(context, 16842904);
    }

    public static int getDefaultTextColorHighlight(Context context) {
        return getDefaultTextAttribute(context, 16842905).getDefaultColor();
    }

    public static ColorStateList getDefaultTextColorHint(Context context) {
        return getDefaultTextAttribute(context, 16842906);
    }
}
