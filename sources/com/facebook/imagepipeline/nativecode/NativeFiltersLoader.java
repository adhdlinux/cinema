package com.facebook.imagepipeline.nativecode;

import com.facebook.infer.annotation.Nullsafe;
import com.facebook.soloader.nativeloader.NativeLoader;

@Nullsafe(Nullsafe.Mode.STRICT)
public class NativeFiltersLoader {
    public static void load() {
        NativeLoader.loadLibrary("native-filters");
    }
}
