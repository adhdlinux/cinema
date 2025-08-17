package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface;

public class AndroidSwipeRefreshLayoutManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidSwipeRefreshLayoutManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidSwipeRefreshLayoutManagerDelegate(U u2) {
        super(u2);
    }

    public void receiveCommand(T t2, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setNativeRefreshing")) {
            ((AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager).setNativeRefreshing(t2, readableArray.getBoolean(0));
        }
    }

    public void setProperty(T t2, String str, Object obj) {
        float f2;
        str.hashCode();
        boolean z2 = true;
        boolean z3 = false;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1609594047:
                if (str.equals(ViewProps.ENABLED)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1354842768:
                if (str.equals("colors")) {
                    c2 = 1;
                    break;
                }
                break;
            case -885150488:
                if (str.equals("progressBackgroundColor")) {
                    c2 = 2;
                    break;
                }
                break;
            case -416037467:
                if (str.equals("progressViewOffset")) {
                    c2 = 3;
                    break;
                }
                break;
            case -321826009:
                if (str.equals("refreshing")) {
                    c2 = 4;
                    break;
                }
                break;
            case 3530753:
                if (str.equals("size")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                AndroidSwipeRefreshLayoutManagerInterface androidSwipeRefreshLayoutManagerInterface = (AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager;
                if (obj != null) {
                    z2 = ((Boolean) obj).booleanValue();
                }
                androidSwipeRefreshLayoutManagerInterface.setEnabled(t2, z2);
                return;
            case 1:
                ((AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager).setColors(t2, (ReadableArray) obj);
                return;
            case 2:
                ((AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager).setProgressBackgroundColor(t2, ColorPropConverter.getColor(obj, t2.getContext()));
                return;
            case 3:
                AndroidSwipeRefreshLayoutManagerInterface androidSwipeRefreshLayoutManagerInterface2 = (AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager;
                if (obj == null) {
                    f2 = 0.0f;
                } else {
                    f2 = ((Double) obj).floatValue();
                }
                androidSwipeRefreshLayoutManagerInterface2.setProgressViewOffset(t2, f2);
                return;
            case 4:
                AndroidSwipeRefreshLayoutManagerInterface androidSwipeRefreshLayoutManagerInterface3 = (AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager;
                if (obj != null) {
                    z3 = ((Boolean) obj).booleanValue();
                }
                androidSwipeRefreshLayoutManagerInterface3.setRefreshing(t2, z3);
                return;
            case 5:
                ((AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager).setSize(t2, (String) obj);
                return;
            default:
                super.setProperty(t2, str, obj);
                return;
        }
    }
}
