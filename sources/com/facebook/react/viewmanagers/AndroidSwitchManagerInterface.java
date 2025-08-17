package com.facebook.react.viewmanagers;

import android.view.View;

public interface AndroidSwitchManagerInterface<T extends View> {
    void setDisabled(T t2, boolean z2);

    void setEnabled(T t2, boolean z2);

    void setNativeValue(T t2, boolean z2);

    void setOn(T t2, boolean z2);

    void setThumbColor(T t2, Integer num);

    void setThumbTintColor(T t2, Integer num);

    void setTrackColorForFalse(T t2, Integer num);

    void setTrackColorForTrue(T t2, Integer num);

    void setTrackTintColor(T t2, Integer num);

    void setValue(T t2, boolean z2);
}
