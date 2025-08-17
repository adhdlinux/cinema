package com.google.android.gms.cast.framework.media.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.gms.cast.internal.Logger;

public final class zzs {
    private static final Logger zza = new Logger("WidgetUtil");

    @TargetApi(17)
    public static Bitmap zza(Context context, Bitmap bitmap, float f2, float f3) {
        Logger logger = zza;
        logger.d("Begin blurring bitmap %s, original width = %d, original height = %d.", bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
        int round = Math.round(((float) bitmap.getWidth()) * 0.25f);
        int round2 = Math.round(((float) bitmap.getHeight()) * 0.25f);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, round, round2, false);
        Bitmap createBitmap = Bitmap.createBitmap(round, round2, createScaledBitmap.getConfig());
        RenderScript create = RenderScript.create(context);
        Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
        Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, createFromBitmap.getElement());
        create2.setInput(createFromBitmap);
        create2.setRadius(7.5f);
        create2.forEach(createTyped);
        createTyped.copyTo(createBitmap);
        create.destroy();
        logger.d("End blurring bitmap %s, original width = %d, original height = %d.", createScaledBitmap, Integer.valueOf(round), Integer.valueOf(round2));
        return createBitmap;
    }

    public static Drawable zzb(Context context, int i2, int i3) {
        return zzd(context, i2, i3, 0, 17170443);
    }

    public static Drawable zzc(Context context, int i2, int i3) {
        return zzd(context, i2, i3, 16842800, 0);
    }

    private static Drawable zzd(Context context, int i2, int i3, int i4, int i5) {
        ColorStateList colorStateList;
        int i6;
        Drawable r2 = DrawableCompat.r(context.getResources().getDrawable(i3).mutate());
        DrawableCompat.p(r2, PorterDuff.Mode.SRC_IN);
        if (i2 != 0) {
            colorStateList = ContextCompat.getColorStateList(context, i2);
        } else {
            if (i4 != 0) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i4});
                i6 = obtainStyledAttributes.getColor(0, 0);
                obtainStyledAttributes.recycle();
            } else {
                i6 = ContextCompat.getColor(context, i5);
            }
            int[] iArr = {i6, ColorUtils.p(i6, 128)};
            colorStateList = new ColorStateList(new int[][]{new int[]{16842910}, new int[]{-16842910}}, iArr);
        }
        DrawableCompat.o(r2, colorStateList);
        return r2;
    }
}
