package com.facebook.react.fabric;

import com.facebook.react.bridge.NativeMap;

public interface SurfaceHandler {
    String getModuleName();

    int getSurfaceId();

    boolean isRunning();

    void setLayoutConstraints(int i2, int i3, int i4, int i5, boolean z2, boolean z3, float f2);

    void setMountable(boolean z2);

    void setProps(NativeMap nativeMap);

    void setSurfaceId(int i2);

    void start();

    void stop();
}
