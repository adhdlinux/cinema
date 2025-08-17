package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableMap;

public interface SliderManagerInterface<T extends View> {
    void setDisabled(T t2, boolean z2);

    void setEnabled(T t2, boolean z2);

    void setMaximumTrackImage(T t2, ReadableMap readableMap);

    void setMaximumTrackTintColor(T t2, Integer num);

    void setMaximumValue(T t2, double d2);

    void setMinimumTrackImage(T t2, ReadableMap readableMap);

    void setMinimumTrackTintColor(T t2, Integer num);

    void setMinimumValue(T t2, double d2);

    void setStep(T t2, double d2);

    void setTestID(T t2, String str);

    void setThumbImage(T t2, ReadableMap readableMap);

    void setThumbTintColor(T t2, Integer num);

    void setTrackImage(T t2, ReadableMap readableMap);

    void setValue(T t2, double d2);
}
