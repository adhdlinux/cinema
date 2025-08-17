package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.UnimplementedNativeViewManagerInterface;

public class UnimplementedNativeViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & UnimplementedNativeViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public UnimplementedNativeViewManagerDelegate(U u2) {
        super(u2);
    }

    public void setProperty(T t2, String str, Object obj) {
        String str2;
        str.hashCode();
        if (!str.equals("name")) {
            super.setProperty(t2, str, obj);
            return;
        }
        UnimplementedNativeViewManagerInterface unimplementedNativeViewManagerInterface = (UnimplementedNativeViewManagerInterface) this.mViewManager;
        if (obj == null) {
            str2 = "";
        } else {
            str2 = (String) obj;
        }
        unimplementedNativeViewManagerInterface.setName(t2, str2);
    }
}
