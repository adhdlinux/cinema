package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.SafeAreaViewManagerInterface;

public class SafeAreaViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & SafeAreaViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public SafeAreaViewManagerDelegate(U u2) {
        super(u2);
    }

    public void setProperty(T t2, String str, Object obj) {
        boolean z2;
        str.hashCode();
        if (!str.equals("emulateUnlessSupported")) {
            super.setProperty(t2, str, obj);
            return;
        }
        SafeAreaViewManagerInterface safeAreaViewManagerInterface = (SafeAreaViewManagerInterface) this.mViewManager;
        if (obj == null) {
            z2 = false;
        } else {
            z2 = ((Boolean) obj).booleanValue();
        }
        safeAreaViewManagerInterface.setEmulateUnlessSupported(t2, z2);
    }
}
