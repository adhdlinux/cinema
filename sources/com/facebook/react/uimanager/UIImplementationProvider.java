package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import java.util.List;

@Deprecated
public class UIImplementationProvider {
    public UIImplementation createUIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerResolver viewManagerResolver, EventDispatcher eventDispatcher, int i2) {
        Systrace.beginSection(0, "UIImplementationProvider.createUIImplementation[1]");
        try {
            return new UIImplementation(reactApplicationContext, viewManagerResolver, eventDispatcher, i2);
        } finally {
            Systrace.endSection(0);
        }
    }

    public UIImplementation createUIImplementation(ReactApplicationContext reactApplicationContext, List<ViewManager> list, EventDispatcher eventDispatcher, int i2) {
        Systrace.beginSection(0, "UIImplementationProvider.createUIImplementation[2]");
        try {
            return new UIImplementation(reactApplicationContext, list, eventDispatcher, i2);
        } finally {
            Systrace.endSection(0);
        }
    }

    /* access modifiers changed from: package-private */
    public UIImplementation createUIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, EventDispatcher eventDispatcher, int i2) {
        Systrace.beginSection(0, "UIImplementationProvider.createUIImplementation[3]");
        try {
            return new UIImplementation(reactApplicationContext, viewManagerRegistry, eventDispatcher, i2);
        } finally {
            Systrace.endSection(0);
        }
    }
}
