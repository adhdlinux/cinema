package com.facebook.react.views.view;

import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;

public abstract class ReactClippingViewManager<T extends ReactViewGroup> extends ViewGroupManager<T> {
    @ReactProp(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(T t2, boolean z2) {
        UiThreadUtil.assertOnUiThread();
        t2.setRemoveClippedSubviews(z2);
    }

    public void addView(T t2, View view, int i2) {
        UiThreadUtil.assertOnUiThread();
        if (t2.getRemoveClippedSubviews()) {
            t2.addViewWithSubviewClippingEnabled(view, i2);
        } else {
            t2.addView(view, i2);
        }
    }

    public View getChildAt(T t2, int i2) {
        if (t2.getRemoveClippedSubviews()) {
            return t2.getChildAtWithSubviewClippingEnabled(i2);
        }
        return t2.getChildAt(i2);
    }

    public int getChildCount(T t2) {
        if (t2.getRemoveClippedSubviews()) {
            return t2.getAllChildrenCount();
        }
        return t2.getChildCount();
    }

    public void removeAllViews(T t2) {
        UiThreadUtil.assertOnUiThread();
        if (t2.getRemoveClippedSubviews()) {
            t2.removeAllViewsWithSubviewClippingEnabled();
        } else {
            t2.removeAllViews();
        }
    }

    public void removeViewAt(T t2, int i2) {
        UiThreadUtil.assertOnUiThread();
        if (t2.getRemoveClippedSubviews()) {
            View childAt = getChildAt(t2, i2);
            if (childAt.getParent() != null) {
                t2.removeView(childAt);
            }
            t2.removeViewWithSubviewClippingEnabled(childAt);
            return;
        }
        t2.removeViewAt(i2);
    }
}
