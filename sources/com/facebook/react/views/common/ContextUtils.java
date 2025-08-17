package com.facebook.react.views.common;

import android.content.ContextWrapper;

public class ContextUtils {
    public static <T> T findContextOfType(T t2, Class<? extends T> cls) {
        T baseContext;
        while (!cls.isInstance(t2)) {
            if (!(t2 instanceof ContextWrapper) || t2 == (baseContext = ((ContextWrapper) t2).getBaseContext())) {
                return null;
            }
            t2 = baseContext;
        }
        return t2;
    }
}
