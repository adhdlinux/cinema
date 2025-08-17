package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;

public interface ViewManagerDelegate<T extends View> {
    void receiveCommand(T t2, String str, ReadableArray readableArray);

    void setProperty(T t2, String str, Object obj);
}
