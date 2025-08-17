package com.facebook.fresco.ui.common;

import android.net.Uri;
import com.facebook.common.internal.Fn;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public abstract class MultiUriHelper {
    public static <T> Uri getMainUri(T t2, T t3, T[] tArr, Fn<T, Uri> fn) {
        T t4;
        Uri apply;
        Uri apply2;
        if (t2 != null && (apply2 = fn.apply(t2)) != null) {
            return apply2;
        }
        if (tArr != null && tArr.length > 0 && (t4 = tArr[0]) != null && (apply = fn.apply(t4)) != null) {
            return apply;
        }
        if (t3 != null) {
            return fn.apply(t3);
        }
        return null;
    }
}
