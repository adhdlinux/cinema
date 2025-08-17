package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.ProgressViewManagerInterface;

public class ProgressViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & ProgressViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public ProgressViewManagerDelegate(U u2) {
        super(u2);
    }

    public void setProperty(T t2, String str, Object obj) {
        float f2;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1948954017:
                if (str.equals("progressViewStyle")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c2 = 1;
                    break;
                }
                break;
            case -287374307:
                if (str.equals("trackTintColor")) {
                    c2 = 2;
                    break;
                }
                break;
            case 760630062:
                if (str.equals("progressImage")) {
                    c2 = 3;
                    break;
                }
                break;
            case 962728315:
                if (str.equals("progressTintColor")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1139400400:
                if (str.equals("trackImage")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((ProgressViewManagerInterface) this.mViewManager).setProgressViewStyle(t2, (String) obj);
                return;
            case 1:
                ProgressViewManagerInterface progressViewManagerInterface = (ProgressViewManagerInterface) this.mViewManager;
                if (obj == null) {
                    f2 = 0.0f;
                } else {
                    f2 = ((Double) obj).floatValue();
                }
                progressViewManagerInterface.setProgress(t2, f2);
                return;
            case 2:
                ((ProgressViewManagerInterface) this.mViewManager).setTrackTintColor(t2, ColorPropConverter.getColor(obj, t2.getContext()));
                return;
            case 3:
                ((ProgressViewManagerInterface) this.mViewManager).setProgressImage(t2, (ReadableMap) obj);
                return;
            case 4:
                ((ProgressViewManagerInterface) this.mViewManager).setProgressTintColor(t2, ColorPropConverter.getColor(obj, t2.getContext()));
                return;
            case 5:
                ((ProgressViewManagerInterface) this.mViewManager).setTrackImage(t2, (ReadableMap) obj);
                return;
            default:
                super.setProperty(t2, str, obj);
                return;
        }
    }
}
