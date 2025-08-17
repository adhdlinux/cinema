package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.ActivityIndicatorViewManagerInterface;

public class ActivityIndicatorViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & ActivityIndicatorViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public ActivityIndicatorViewManagerDelegate(U u2) {
        super(u2);
    }

    public void setProperty(T t2, String str, Object obj) {
        str.hashCode();
        boolean z2 = false;
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3530753:
                if (str.equals("size")) {
                    c2 = 0;
                    break;
                }
                break;
            case 94842723:
                if (str.equals(ViewProps.COLOR)) {
                    c2 = 1;
                    break;
                }
                break;
            case 865748226:
                if (str.equals("hidesWhenStopped")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1118509918:
                if (str.equals("animating")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((ActivityIndicatorViewManagerInterface) this.mViewManager).setSize(t2, (String) obj);
                return;
            case 1:
                ((ActivityIndicatorViewManagerInterface) this.mViewManager).setColor(t2, ColorPropConverter.getColor(obj, t2.getContext()));
                return;
            case 2:
                ActivityIndicatorViewManagerInterface activityIndicatorViewManagerInterface = (ActivityIndicatorViewManagerInterface) this.mViewManager;
                if (obj != null) {
                    z2 = ((Boolean) obj).booleanValue();
                }
                activityIndicatorViewManagerInterface.setHidesWhenStopped(t2, z2);
                return;
            case 3:
                ActivityIndicatorViewManagerInterface activityIndicatorViewManagerInterface2 = (ActivityIndicatorViewManagerInterface) this.mViewManager;
                if (obj != null) {
                    z2 = ((Boolean) obj).booleanValue();
                }
                activityIndicatorViewManagerInterface2.setAnimating(t2, z2);
                return;
            default:
                super.setProperty(t2, str, obj);
                return;
        }
    }
}
