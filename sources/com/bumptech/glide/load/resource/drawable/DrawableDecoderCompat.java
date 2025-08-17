package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public final class DrawableDecoderCompat {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f16903a = true;

    private DrawableDecoderCompat() {
    }

    public static Drawable a(Context context, int i2, Resources.Theme theme) {
        return c(context, context, i2, theme);
    }

    public static Drawable b(Context context, Context context2, int i2) {
        return c(context, context2, i2, (Resources.Theme) null);
    }

    private static Drawable c(Context context, Context context2, int i2, Resources.Theme theme) {
        try {
            if (f16903a) {
                return e(context2, i2, theme);
            }
        } catch (NoClassDefFoundError unused) {
            f16903a = false;
        } catch (IllegalStateException e2) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return ContextCompat.getDrawable(context2, i2);
            }
            throw e2;
        } catch (Resources.NotFoundException unused2) {
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i2, theme);
    }

    private static Drawable d(Context context, int i2, Resources.Theme theme) {
        return ResourcesCompat.e(context.getResources(), i2, theme);
    }

    private static Drawable e(Context context, int i2, Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.b(context, i2);
    }
}
