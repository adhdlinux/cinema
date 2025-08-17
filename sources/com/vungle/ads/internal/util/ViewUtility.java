package com.vungle.ads.internal.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

public final class ViewUtility {
    public static final ViewUtility INSTANCE = new ViewUtility();

    private ViewUtility() {
    }

    public final int dpToPixels(Context context, int i2) {
        Intrinsics.f(context, "context");
        return (int) ((((float) i2) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final Pair<Integer, Integer> getDeviceWidthAndHeightWithOrientation(Context context, int i2) {
        Intrinsics.f(context, "context");
        Resources resources = context.getApplicationContext().getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int i3 = resources.getConfiguration().orientation;
        if (i2 == 0) {
            i2 = i3;
        }
        if (i2 == i3) {
            return new Pair<>(Integer.valueOf(Math.round(((float) displayMetrics.widthPixels) / displayMetrics.density)), Integer.valueOf(Math.round(((float) displayMetrics.heightPixels) / displayMetrics.density)));
        }
        return new Pair<>(Integer.valueOf(Math.round(((float) displayMetrics.heightPixels) / displayMetrics.density)), Integer.valueOf(Math.round(((float) displayMetrics.widthPixels) / displayMetrics.density)));
    }

    public final WebView getWebView(Context context) throws InstantiationException {
        Intrinsics.f(context, "context");
        try {
            return new WebView(context);
        } catch (Resources.NotFoundException e2) {
            throw new InstantiationException("Cannot instantiate WebView due to Resources.NotFoundException: " + e2 + ".message");
        } catch (Exception e3) {
            throw new InstantiationException(e3.getMessage());
        }
    }
}
