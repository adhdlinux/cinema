package com.facebook.react.turbomodule.core;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.CxxModuleWrapper;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.soloader.SoLoader;
import java.util.ArrayList;
import java.util.List;

public abstract class TurboModuleManagerDelegate {
    private static volatile boolean sIsSoLibraryLoaded;
    @DoNotStrip
    private final HybridData mHybridData = initHybrid();

    protected TurboModuleManagerDelegate() {
        maybeLoadOtherSoLibraries();
        maybeLoadSoLibrary();
    }

    private static synchronized void maybeLoadSoLibrary() {
        synchronized (TurboModuleManagerDelegate.class) {
            if (!sIsSoLibraryLoaded) {
                SoLoader.loadLibrary("turbomodulejsijni");
                sIsSoLibraryLoaded = true;
            }
        }
    }

    public List<String> getEagerInitModuleNames() {
        return new ArrayList();
    }

    public abstract CxxModuleWrapper getLegacyCxxModule(String str);

    public abstract TurboModule getModule(String str);

    /* access modifiers changed from: protected */
    public abstract HybridData initHybrid();

    /* access modifiers changed from: protected */
    public synchronized void maybeLoadOtherSoLibraries() {
    }
}
