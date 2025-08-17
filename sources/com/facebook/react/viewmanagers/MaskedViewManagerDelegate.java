package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.MaskedViewManagerInterface;

public class MaskedViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & MaskedViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public MaskedViewManagerDelegate(U u2) {
        super(u2);
    }

    public void setProperty(T t2, String str, Object obj) {
        super.setProperty(t2, str, obj);
    }
}
