package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;

public class MaterialResources {
    private MaterialResources() {
    }

    public static ColorStateList a(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        ColorStateList a2;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (a2 = AppCompatResources.a(context, resourceId)) == null) {
            return typedArray.getColorStateList(i2);
        }
        return a2;
    }

    public static Drawable b(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        Drawable b2;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (b2 = AppCompatResources.b(context, resourceId)) == null) {
            return typedArray.getDrawable(i2);
        }
        return b2;
    }

    static int c(TypedArray typedArray, int i2, int i3) {
        return typedArray.hasValue(i2) ? i2 : i3;
    }

    public static TextAppearance d(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return new TextAppearance(context, resourceId);
    }
}
