package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.viewmanagers.AndroidHorizontalScrollContentViewManagerInterface;

public class AndroidHorizontalScrollContentViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidHorizontalScrollContentViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidHorizontalScrollContentViewManagerDelegate(U u2) {
        super(u2);
    }

    public void setProperty(T t2, String str, Object obj) {
        boolean z2;
        str.hashCode();
        if (!str.equals(ReactClippingViewGroupHelper.PROP_REMOVE_CLIPPED_SUBVIEWS)) {
            super.setProperty(t2, str, obj);
            return;
        }
        AndroidHorizontalScrollContentViewManagerInterface androidHorizontalScrollContentViewManagerInterface = (AndroidHorizontalScrollContentViewManagerInterface) this.mViewManager;
        if (obj == null) {
            z2 = false;
        } else {
            z2 = ((Boolean) obj).booleanValue();
        }
        androidHorizontalScrollContentViewManagerInterface.setRemoveClippedSubviews(t2, z2);
    }
}
