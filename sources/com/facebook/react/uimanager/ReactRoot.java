package com.facebook.react.uimanager;

import android.os.Bundle;
import android.view.ViewGroup;
import java.util.concurrent.atomic.AtomicInteger;

public interface ReactRoot {
    public static final int STATE_STARTED = 1;
    public static final int STATE_STOPPED = 0;

    Bundle getAppProperties();

    int getHeightMeasureSpec();

    String getInitialUITemplate();

    String getJSModuleName();

    ViewGroup getRootViewGroup();

    int getRootViewTag();

    AtomicInteger getState();

    @Deprecated
    String getSurfaceID();

    int getUIManagerType();

    int getWidthMeasureSpec();

    void onStage(int i2);

    void runApplication();

    void setRootViewTag(int i2);

    void setShouldLogContentAppeared(boolean z2);
}
