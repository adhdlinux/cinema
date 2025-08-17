package com.original.tase;

import android.content.Context;
import com.movie.FreeMoviesApp;
import com.utils.Utils;
import java.util.Objects;

public class I18N {
    public static String a(int i2) {
        Context v2 = Utils.v();
        Objects.requireNonNull(v2);
        return FreeMoviesApp.m(v2).getResources().getString(i2);
    }

    public static String b(int i2, Object... objArr) {
        Context v2 = Utils.v();
        Objects.requireNonNull(v2);
        return FreeMoviesApp.m(v2).getResources().getString(i2, objArr);
    }
}
