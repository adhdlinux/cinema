package com.facebook.react.bridge;

import android.view.View;
import com.facebook.infer.annotation.ThreadConfined;
import java.util.List;

public interface UIManager extends JSIModule, PerformanceCounter {
    @ThreadConfined("UI")
    @Deprecated
    <T extends View> int addRootView(T t2, WritableMap writableMap, String str);

    void addUIManagerEventListener(UIManagerListener uIManagerListener);

    void dispatchCommand(int i2, int i3, ReadableArray readableArray);

    void dispatchCommand(int i2, String str, ReadableArray readableArray);

    <T> T getEventDispatcher();

    @Deprecated
    void preInitializeViewManagers(List<String> list);

    void receiveEvent(int i2, int i3, String str, WritableMap writableMap);

    @Deprecated
    void receiveEvent(int i2, String str, WritableMap writableMap);

    void removeUIManagerEventListener(UIManagerListener uIManagerListener);

    @Deprecated
    String resolveCustomDirectEventName(String str);

    View resolveView(int i2);

    void sendAccessibilityEvent(int i2, int i3);

    <T extends View> int startSurface(T t2, String str, WritableMap writableMap, int i2, int i3);

    void stopSurface(int i2);

    @ThreadConfined("UI")
    void synchronouslyUpdateViewOnUIThread(int i2, ReadableMap readableMap);

    @ThreadConfined("UI")
    void updateRootLayoutSpecs(int i2, int i3, int i4, int i5, int i6);
}
