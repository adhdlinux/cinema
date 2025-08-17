package com.facebook.react.uimanager.util;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReactFindViewUtil {
    private static final Map<OnMultipleViewsFoundListener, Set<String>> mOnMultipleViewsFoundListener = new HashMap();
    private static final List<OnViewFoundListener> mOnViewFoundListeners = new ArrayList();

    public interface OnMultipleViewsFoundListener {
        void onViewFound(View view, String str);
    }

    public interface OnViewFoundListener {
        String getNativeId();

        void onViewFound(View view);
    }

    public static void addViewListener(OnViewFoundListener onViewFoundListener) {
        mOnViewFoundListeners.add(onViewFoundListener);
    }

    public static void addViewsListener(OnMultipleViewsFoundListener onMultipleViewsFoundListener, Set<String> set) {
        mOnMultipleViewsFoundListener.put(onMultipleViewsFoundListener, set);
    }

    public static View findView(View view, String str) {
        String nativeId = getNativeId(view);
        if (nativeId != null && nativeId.equals(str)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View findView = findView(viewGroup.getChildAt(i2), str);
            if (findView != null) {
                return findView;
            }
        }
        return null;
    }

    private static String getNativeId(View view) {
        Object tag = view.getTag(R.id.view_tag_native_id);
        if (tag instanceof String) {
            return (String) tag;
        }
        return null;
    }

    public static void notifyViewRendered(View view) {
        String nativeId = getNativeId(view);
        if (nativeId != null) {
            Iterator<OnViewFoundListener> it2 = mOnViewFoundListeners.iterator();
            while (it2.hasNext()) {
                OnViewFoundListener next = it2.next();
                if (nativeId.equals(next.getNativeId())) {
                    next.onViewFound(view);
                    it2.remove();
                }
            }
            for (Map.Entry next2 : mOnMultipleViewsFoundListener.entrySet()) {
                Set set = (Set) next2.getValue();
                if (set != null && set.contains(nativeId)) {
                    ((OnMultipleViewsFoundListener) next2.getKey()).onViewFound(view, nativeId);
                }
            }
        }
    }

    public static void removeViewListener(OnViewFoundListener onViewFoundListener) {
        mOnViewFoundListeners.remove(onViewFoundListener);
    }

    public static void removeViewsListener(OnMultipleViewsFoundListener onMultipleViewsFoundListener) {
        mOnMultipleViewsFoundListener.remove(onMultipleViewsFoundListener);
    }

    public static void findView(View view, OnViewFoundListener onViewFoundListener) {
        View findView = findView(view, onViewFoundListener.getNativeId());
        if (findView != null) {
            onViewFoundListener.onViewFound(findView);
        }
        addViewListener(onViewFoundListener);
    }
}
