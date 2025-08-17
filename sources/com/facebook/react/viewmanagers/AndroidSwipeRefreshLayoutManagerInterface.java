package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;

public interface AndroidSwipeRefreshLayoutManagerInterface<T extends View> {
    void setColors(T t2, ReadableArray readableArray);

    void setEnabled(T t2, boolean z2);

    void setNativeRefreshing(T t2, boolean z2);

    void setProgressBackgroundColor(T t2, Integer num);

    void setProgressViewOffset(T t2, float f2);

    void setRefreshing(T t2, boolean z2);

    void setSize(T t2, String str);
}
