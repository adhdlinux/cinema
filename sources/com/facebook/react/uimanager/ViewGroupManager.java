package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.List;
import java.util.WeakHashMap;

public abstract class ViewGroupManager<T extends ViewGroup> extends BaseViewManager<T, LayoutShadowNode> implements IViewManagerWithChildren {
    private static WeakHashMap<View, Integer> mZIndexHash = new WeakHashMap<>();

    public static Integer getViewZIndex(View view) {
        return mZIndexHash.get(view);
    }

    public static void setViewZIndex(View view, int i2) {
        mZIndexHash.put(view, Integer.valueOf(i2));
    }

    public void addView(T t2, View view, int i2) {
        t2.addView(view, i2);
    }

    public void addViews(T t2, List<View> list) {
        UiThreadUtil.assertOnUiThread();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            addView(t2, list.get(i2), i2);
        }
    }

    public View getChildAt(T t2, int i2) {
        return t2.getChildAt(i2);
    }

    public int getChildCount(T t2) {
        return t2.getChildCount();
    }

    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return LayoutShadowNode.class;
    }

    public boolean needsCustomLayoutForChildren() {
        return false;
    }

    public void removeAllViews(T t2) {
        UiThreadUtil.assertOnUiThread();
        for (int childCount = getChildCount(t2) - 1; childCount >= 0; childCount--) {
            removeViewAt(t2, childCount);
        }
    }

    public void removeView(T t2, View view) {
        UiThreadUtil.assertOnUiThread();
        for (int i2 = 0; i2 < getChildCount(t2); i2++) {
            if (getChildAt(t2, i2) == view) {
                removeViewAt(t2, i2);
                return;
            }
        }
    }

    public void removeViewAt(T t2, int i2) {
        UiThreadUtil.assertOnUiThread();
        t2.removeViewAt(i2);
    }

    public boolean shouldPromoteGrandchildren() {
        return false;
    }

    public void updateExtraData(T t2, Object obj) {
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new LayoutShadowNode();
    }
}
