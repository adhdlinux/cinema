package com.facebook.react.viewmanagers;

import android.view.View;

public interface AndroidDrawerLayoutManagerInterface<T extends View> {
    void closeDrawer(T t2);

    void openDrawer(T t2);

    void setDrawerBackgroundColor(T t2, Integer num);

    void setDrawerLockMode(T t2, String str);

    void setDrawerPosition(T t2, String str);

    void setDrawerWidth(T t2, Float f2);

    void setKeyboardDismissMode(T t2, String str);

    void setStatusBarBackgroundColor(T t2, Integer num);
}
