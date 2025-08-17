package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface;

public class AndroidDrawerLayoutManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidDrawerLayoutManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidDrawerLayoutManagerDelegate(U u2) {
        super(u2);
    }

    public void receiveCommand(T t2, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("closeDrawer")) {
            ((AndroidDrawerLayoutManagerInterface) this.mViewManager).closeDrawer(t2);
        } else if (str.equals("openDrawer")) {
            ((AndroidDrawerLayoutManagerInterface) this.mViewManager).openDrawer(t2);
        }
    }

    public void setProperty(T t2, String str, Object obj) {
        Float f2;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2082382380:
                if (str.equals("statusBarBackgroundColor")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1233873500:
                if (str.equals("drawerBackgroundColor")) {
                    c2 = 1;
                    break;
                }
                break;
            case -764307226:
                if (str.equals("keyboardDismissMode")) {
                    c2 = 2;
                    break;
                }
                break;
            case 268251989:
                if (str.equals("drawerWidth")) {
                    c2 = 3;
                    break;
                }
                break;
            case 695891258:
                if (str.equals("drawerPosition")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1857208703:
                if (str.equals("drawerLockMode")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((AndroidDrawerLayoutManagerInterface) this.mViewManager).setStatusBarBackgroundColor(t2, ColorPropConverter.getColor(obj, t2.getContext()));
                return;
            case 1:
                ((AndroidDrawerLayoutManagerInterface) this.mViewManager).setDrawerBackgroundColor(t2, ColorPropConverter.getColor(obj, t2.getContext()));
                return;
            case 2:
                ((AndroidDrawerLayoutManagerInterface) this.mViewManager).setKeyboardDismissMode(t2, (String) obj);
                return;
            case 3:
                AndroidDrawerLayoutManagerInterface androidDrawerLayoutManagerInterface = (AndroidDrawerLayoutManagerInterface) this.mViewManager;
                if (obj == null) {
                    f2 = null;
                } else {
                    f2 = Float.valueOf(((Double) obj).floatValue());
                }
                androidDrawerLayoutManagerInterface.setDrawerWidth(t2, f2);
                return;
            case 4:
                ((AndroidDrawerLayoutManagerInterface) this.mViewManager).setDrawerPosition(t2, (String) obj);
                return;
            case 5:
                ((AndroidDrawerLayoutManagerInterface) this.mViewManager).setDrawerLockMode(t2, (String) obj);
                return;
            default:
                super.setProperty(t2, str, obj);
                return;
        }
    }
}
