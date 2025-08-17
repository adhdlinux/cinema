package com.movie.ui.activity.player.utils;

import android.content.res.Resources;

public final class UiExtKt {
    public static final int a(int i2) {
        return (int) (((float) i2) * Resources.getSystem().getDisplayMetrics().density);
    }
}
