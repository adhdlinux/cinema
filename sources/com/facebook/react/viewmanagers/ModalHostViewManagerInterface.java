package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;

public interface ModalHostViewManagerInterface<T extends View> {
    void setAnimated(T t2, boolean z2);

    void setAnimationType(T t2, String str);

    void setHardwareAccelerated(T t2, boolean z2);

    void setIdentifier(T t2, int i2);

    void setPresentationStyle(T t2, String str);

    void setStatusBarTranslucent(T t2, boolean z2);

    void setSupportedOrientations(T t2, ReadableArray readableArray);

    void setTransparent(T t2, boolean z2);

    void setVisible(T t2, boolean z2);
}
