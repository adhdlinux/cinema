package com.facebook.hermes.reactexecutor;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.soloader.SoLoader;

public class HermesExecutor extends JavaScriptExecutor {
    private static String mode_;

    static {
        loadLibrary();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HermesExecutor(RuntimeConfig runtimeConfig) {
        super(runtimeConfig == null ? initHybridDefaultConfig() : initHybrid(runtimeConfig.heapSizeMB));
    }

    public static native boolean canLoadFile(String str);

    private static native HybridData initHybrid(long j2);

    private static native HybridData initHybridDefaultConfig();

    public static void loadLibrary() throws UnsatisfiedLinkError {
        if (mode_ == null) {
            SoLoader.loadLibrary("hermes");
            try {
                SoLoader.loadLibrary("hermes-executor-debug");
                mode_ = "Debug";
            } catch (UnsatisfiedLinkError unused) {
                SoLoader.loadLibrary("hermes-executor-release");
                mode_ = "Release";
            }
        }
    }

    public String getName() {
        return "HermesExecutor" + mode_;
    }
}
