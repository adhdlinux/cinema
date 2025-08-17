package com.facebook.react.uimanager;

import java.util.List;

public interface ViewManagerResolver {
    ViewManager getViewManager(String str);

    List<String> getViewManagerNames();
}
