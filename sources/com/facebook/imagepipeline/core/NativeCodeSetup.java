package com.facebook.imagepipeline.core;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class NativeCodeSetup {
    private static boolean sUseNativeCode = true;

    private NativeCodeSetup() {
    }

    public static boolean getUseNativeCode() {
        return sUseNativeCode;
    }

    public static void setUseNativeCode(boolean z2) {
        sUseNativeCode = z2;
    }
}
