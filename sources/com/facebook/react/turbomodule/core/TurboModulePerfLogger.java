package com.facebook.react.turbomodule.core;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.perflogger.NativeModulePerfLogger;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class TurboModulePerfLogger {
    private static boolean sIsSoLibraryLoaded = false;
    private static NativeModulePerfLogger sNativeModulePerfLogger;

    public static void enableLogging(NativeModulePerfLogger nativeModulePerfLogger) {
        if (nativeModulePerfLogger != null) {
            sNativeModulePerfLogger = nativeModulePerfLogger;
            maybeLoadSoLibrary();
            jniEnableCppLogging(nativeModulePerfLogger);
        }
    }

    private static native void jniEnableCppLogging(NativeModulePerfLogger nativeModulePerfLogger);

    private static synchronized void maybeLoadSoLibrary() {
        synchronized (TurboModulePerfLogger.class) {
            if (!sIsSoLibraryLoaded) {
                SoLoader.loadLibrary("turbomodulejsijni");
                sIsSoLibraryLoaded = true;
            }
        }
    }

    public static void moduleCreateCacheHit(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.moduleCreateCacheHit(str, i2);
        }
    }

    public static void moduleCreateConstructEnd(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.moduleCreateConstructEnd(str, i2);
        }
    }

    public static void moduleCreateConstructStart(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.moduleCreateConstructStart(str, i2);
        }
    }

    public static void moduleCreateEnd(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.moduleCreateEnd(str, i2);
        }
    }

    public static void moduleCreateFail(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.moduleCreateFail(str, i2);
        }
    }

    public static void moduleCreateSetUpEnd(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.moduleCreateSetUpEnd(str, i2);
        }
    }

    public static void moduleCreateSetUpStart(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.moduleCreateSetUpStart(str, i2);
        }
    }

    public static void moduleCreateStart(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.moduleCreateStart(str, i2);
        }
    }

    public static void moduleDataCreateEnd(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.moduleDataCreateEnd(str, i2);
        }
    }

    public static void moduleDataCreateStart(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.moduleDataCreateStart(str, i2);
        }
    }
}
