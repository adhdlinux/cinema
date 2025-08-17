package com.chartboost.sdk.impl;

import android.net.Uri;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public abstract class g0 {
    public static final String a(String str) {
        Intrinsics.f(str, ImagesContract.URL);
        if (str.length() <= 0) {
            return "";
        }
        if (!StringsKt__StringsJVMKt.G(str, "https://", false, 2, (Object) null) && !StringsKt__StringsJVMKt.G(str, "http://", false, 2, (Object) null)) {
            str = "https://" + str;
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return "";
        }
        List<String> pathSegments = parse.getPathSegments();
        Intrinsics.e(pathSegments, "segments");
        return CollectionsKt___CollectionsKt.J(pathSegments, "_", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public static final y7 a(int i2) {
        y7 y7Var;
        y7[] values = y7.values();
        int length = values.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                y7Var = null;
                break;
            }
            y7Var = values[i3];
            if (y7Var.b() == i2) {
                break;
            }
            i3++;
        }
        return y7Var == null ? y7.UNKNOWN : y7Var;
    }
}
