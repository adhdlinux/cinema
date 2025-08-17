package com.facebook.react.views.view;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import kotlin.jvm.internal.Intrinsics;

public final class ReactMapBufferViewManager implements ReactViewManagerWrapper {
    public static final ReactMapBufferViewManager INSTANCE = new ReactMapBufferViewManager();
    private static final ReactViewManager viewManager = new ReactViewManager();

    private ReactMapBufferViewManager() {
    }

    public View createView(int i2, ThemedReactContext themedReactContext, Object obj, StateWrapper stateWrapper, JSResponderHandler jSResponderHandler) {
        ReactStylesDiffMap reactStylesDiffMap;
        Intrinsics.f(themedReactContext, "reactContext");
        Intrinsics.f(jSResponderHandler, "jsResponderHandler");
        ReactViewManager reactViewManager = viewManager;
        if (obj instanceof ReactStylesDiffMap) {
            reactStylesDiffMap = (ReactStylesDiffMap) obj;
        } else {
            reactStylesDiffMap = null;
        }
        View createView = reactViewManager.createView(i2, themedReactContext, reactStylesDiffMap, stateWrapper, jSResponderHandler);
        ReactViewGroup reactViewGroup = (ReactViewGroup) createView;
        if (obj instanceof ReadableMapBuffer) {
            ReactMapBufferViewManager reactMapBufferViewManager = INSTANCE;
            Intrinsics.e(reactViewGroup, "view");
            reactMapBufferViewManager.updateProperties(reactViewGroup, obj);
        }
        Intrinsics.e(createView, "viewManager\n          .c…            }\n          }");
        return createView;
    }

    public String getName() {
        String name = viewManager.getName();
        Intrinsics.e(name, "viewManager.name");
        return name;
    }

    public ViewGroupManager<?> getViewGroupManager() {
        return viewManager;
    }

    public void onDropViewInstance(View view) {
        Intrinsics.f(view, "view");
        viewManager.onDropViewInstance((ReactViewGroup) view);
    }

    public void receiveCommand(View view, String str, ReadableArray readableArray) {
        Intrinsics.f(view, "root");
        Intrinsics.f(str, "commandId");
        viewManager.receiveCommand((ReactViewGroup) view, str, readableArray);
    }

    public void setPadding(View view, int i2, int i3, int i4, int i5) {
        Intrinsics.f(view, "view");
        viewManager.setPadding((ReactViewGroup) view, i2, i3, i4, i5);
    }

    public void updateExtraData(View view, Object obj) {
        Intrinsics.f(view, "root");
        viewManager.updateExtraData((ReactViewGroup) view, obj);
    }

    public void updateProperties(View view, Object obj) {
        ReactStylesDiffMap reactStylesDiffMap;
        Intrinsics.f(view, "viewToUpdate");
        if (!(obj instanceof ReadableMapBuffer)) {
            ReactViewManager reactViewManager = viewManager;
            ReactViewGroup reactViewGroup = (ReactViewGroup) view;
            if (obj instanceof ReactStylesDiffMap) {
                reactStylesDiffMap = (ReactStylesDiffMap) obj;
            } else {
                reactStylesDiffMap = null;
            }
            reactViewManager.updateProperties(reactViewGroup, reactStylesDiffMap);
            return;
        }
        ReactMapBufferPropSetter.INSTANCE.setProps((ReactViewGroup) view, viewManager, (MapBuffer) obj);
    }

    public Object updateState(View view, Object obj, StateWrapper stateWrapper) {
        Intrinsics.f(view, "view");
        return null;
    }

    public void receiveCommand(View view, int i2, ReadableArray readableArray) {
        Intrinsics.f(view, "root");
        viewManager.receiveCommand((ReactViewGroup) view, i2, readableArray);
    }
}
