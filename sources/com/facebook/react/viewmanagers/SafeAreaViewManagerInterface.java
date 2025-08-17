package com.facebook.react.viewmanagers;

import android.view.View;

public interface SafeAreaViewManagerInterface<T extends View> {
    void setEmulateUnlessSupported(T t2, boolean z2);
}
