package com.facebook.react.fabric;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public interface ReactNativeConfig {
    public static final ReactNativeConfig DEFAULT_CONFIG = new EmptyReactNativeConfig();

    @DoNotStrip
    boolean getBool(String str);

    @DoNotStrip
    double getDouble(String str);

    @DoNotStrip
    long getInt64(String str);

    @DoNotStrip
    String getString(String str);
}
