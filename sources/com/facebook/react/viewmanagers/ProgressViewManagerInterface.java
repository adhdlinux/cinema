package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableMap;

public interface ProgressViewManagerInterface<T extends View> {
    void setProgress(T t2, float f2);

    void setProgressImage(T t2, ReadableMap readableMap);

    void setProgressTintColor(T t2, Integer num);

    void setProgressViewStyle(T t2, String str);

    void setTrackImage(T t2, ReadableMap readableMap);

    void setTrackTintColor(T t2, Integer num);
}
