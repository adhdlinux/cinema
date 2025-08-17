package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface;

public class AndroidProgressBarManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidProgressBarManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidProgressBarManagerDelegate(U u2) {
        super(u2);
    }

    public void setProperty(T t2, String str, Object obj) {
        double d2;
        String str2;
        str.hashCode();
        boolean z2 = true;
        boolean z3 = false;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1001078227:
                if (str.equals("progress")) {
                    c2 = 0;
                    break;
                }
                break;
            case -877170387:
                if (str.equals(ViewProps.TEST_ID)) {
                    c2 = 1;
                    break;
                }
                break;
            case -676876213:
                if (str.equals("typeAttr")) {
                    c2 = 2;
                    break;
                }
                break;
            case 94842723:
                if (str.equals(ViewProps.COLOR)) {
                    c2 = 3;
                    break;
                }
                break;
            case 633138363:
                if (str.equals("indeterminate")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1118509918:
                if (str.equals("animating")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1804741442:
                if (str.equals("styleAttr")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        String str3 = null;
        switch (c2) {
            case 0:
                AndroidProgressBarManagerInterface androidProgressBarManagerInterface = (AndroidProgressBarManagerInterface) this.mViewManager;
                if (obj == null) {
                    d2 = 0.0d;
                } else {
                    d2 = ((Double) obj).doubleValue();
                }
                androidProgressBarManagerInterface.setProgress(t2, d2);
                return;
            case 1:
                AndroidProgressBarManagerInterface androidProgressBarManagerInterface2 = (AndroidProgressBarManagerInterface) this.mViewManager;
                if (obj == null) {
                    str2 = "";
                } else {
                    str2 = (String) obj;
                }
                androidProgressBarManagerInterface2.setTestID(t2, str2);
                return;
            case 2:
                AndroidProgressBarManagerInterface androidProgressBarManagerInterface3 = (AndroidProgressBarManagerInterface) this.mViewManager;
                if (obj != null) {
                    str3 = (String) obj;
                }
                androidProgressBarManagerInterface3.setTypeAttr(t2, str3);
                return;
            case 3:
                ((AndroidProgressBarManagerInterface) this.mViewManager).setColor(t2, ColorPropConverter.getColor(obj, t2.getContext()));
                return;
            case 4:
                AndroidProgressBarManagerInterface androidProgressBarManagerInterface4 = (AndroidProgressBarManagerInterface) this.mViewManager;
                if (obj != null) {
                    z3 = ((Boolean) obj).booleanValue();
                }
                androidProgressBarManagerInterface4.setIndeterminate(t2, z3);
                return;
            case 5:
                AndroidProgressBarManagerInterface androidProgressBarManagerInterface5 = (AndroidProgressBarManagerInterface) this.mViewManager;
                if (obj != null) {
                    z2 = ((Boolean) obj).booleanValue();
                }
                androidProgressBarManagerInterface5.setAnimating(t2, z2);
                return;
            case 6:
                AndroidProgressBarManagerInterface androidProgressBarManagerInterface6 = (AndroidProgressBarManagerInterface) this.mViewManager;
                if (obj != null) {
                    str3 = (String) obj;
                }
                androidProgressBarManagerInterface6.setStyleAttr(t2, str3);
                return;
            default:
                super.setProperty(t2, str, obj);
                return;
        }
    }
}
