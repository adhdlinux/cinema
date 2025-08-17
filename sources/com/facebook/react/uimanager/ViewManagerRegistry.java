package com.facebook.react.uimanager;

import com.facebook.react.common.MapBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ViewManagerRegistry {
    private final ViewManagerResolver mViewManagerResolver;
    private final Map<String, ViewManager> mViewManagers;

    public ViewManagerRegistry(ViewManagerResolver viewManagerResolver) {
        this.mViewManagers = MapBuilder.newHashMap();
        this.mViewManagerResolver = viewManagerResolver;
    }

    private ViewManager getViewManagerFromResolver(String str) {
        ViewManager viewManager = this.mViewManagerResolver.getViewManager(str);
        if (viewManager != null) {
            this.mViewManagers.put(str, viewManager);
        }
        return viewManager;
    }

    public ViewManager get(String str) {
        ViewManager viewManager = this.mViewManagers.get(str);
        if (viewManager != null) {
            return viewManager;
        }
        if (this.mViewManagerResolver != null) {
            ViewManager viewManagerFromResolver = getViewManagerFromResolver(str);
            if (viewManagerFromResolver != null) {
                return viewManagerFromResolver;
            }
            throw new IllegalViewOperationException("ViewManagerResolver returned null for " + str + ", existing names are: " + this.mViewManagerResolver.getViewManagerNames());
        }
        throw new IllegalViewOperationException("No ViewManager found for class " + str);
    }

    /* access modifiers changed from: package-private */
    public ViewManager getViewManagerIfExists(String str) {
        ViewManager viewManager = this.mViewManagers.get(str);
        if (viewManager != null) {
            return viewManager;
        }
        if (this.mViewManagerResolver != null) {
            return getViewManagerFromResolver(str);
        }
        return null;
    }

    public ViewManagerRegistry(List<ViewManager> list) {
        HashMap newHashMap = MapBuilder.newHashMap();
        for (ViewManager next : list) {
            newHashMap.put(next.getName(), next);
        }
        this.mViewManagers = newHashMap;
        this.mViewManagerResolver = null;
    }

    public ViewManagerRegistry(Map<String, ViewManager> map) {
        this.mViewManagers = map == null ? MapBuilder.newHashMap() : map;
        this.mViewManagerResolver = null;
    }
}
