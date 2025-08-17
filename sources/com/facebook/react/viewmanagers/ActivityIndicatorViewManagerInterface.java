package com.facebook.react.viewmanagers;

import android.view.View;

public interface ActivityIndicatorViewManagerInterface<T extends View> {
    void setAnimating(T t2, boolean z2);

    void setColor(T t2, Integer num);

    void setHidesWhenStopped(T t2, boolean z2);

    void setSize(T t2, String str);
}
