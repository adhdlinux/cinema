package com.facebook.react.viewmanagers;

import android.view.View;

public interface AndroidProgressBarManagerInterface<T extends View> {
    void setAnimating(T t2, boolean z2);

    void setColor(T t2, Integer num);

    void setIndeterminate(T t2, boolean z2);

    void setProgress(T t2, double d2);

    void setStyleAttr(T t2, String str);

    void setTestID(T t2, String str);

    void setTypeAttr(T t2, String str);
}
