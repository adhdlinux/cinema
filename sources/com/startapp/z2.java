package com.startapp;

import com.startapp.networkTest.enums.FileTypes;
import com.startapp.networkTest.results.BaseResult;

public class z2 {
    public static String a(Object obj) {
        return a(obj, obj.getClass());
    }

    public static String a(Object obj, Class<?> cls) {
        return String.valueOf(h0.b(obj));
    }

    public static String a(FileTypes fileTypes, BaseResult baseResult) {
        return a(baseResult);
    }

    public static <T> T a(String str, Class<T> cls) {
        return a(str, cls, false);
    }

    public static <T> T a(String str, Class<T> cls, boolean z2) {
        return h0.a(str, cls);
    }
}
