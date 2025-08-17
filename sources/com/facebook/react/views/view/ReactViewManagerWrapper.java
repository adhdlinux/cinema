package com.facebook.react.views.view;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManager;
import kotlin.jvm.internal.Intrinsics;

public interface ReactViewManagerWrapper {

    public static final class DefaultViewManager implements ReactViewManagerWrapper {
        private final ViewManager<View, ?> viewManager;

        public DefaultViewManager(ViewManager<View, ?> viewManager2) {
            Intrinsics.f(viewManager2, "viewManager");
            this.viewManager = viewManager2;
        }

        public View createView(int i2, ThemedReactContext themedReactContext, Object obj, StateWrapper stateWrapper, JSResponderHandler jSResponderHandler) {
            ReactStylesDiffMap reactStylesDiffMap;
            Intrinsics.f(themedReactContext, "reactContext");
            Intrinsics.f(jSResponderHandler, "jsResponderHandler");
            ViewManager<View, ?> viewManager2 = this.viewManager;
            if (obj instanceof ReactStylesDiffMap) {
                reactStylesDiffMap = (ReactStylesDiffMap) obj;
            } else {
                reactStylesDiffMap = null;
            }
            View createView = viewManager2.createView(i2, themedReactContext, reactStylesDiffMap, stateWrapper, jSResponderHandler);
            Intrinsics.e(createView, "viewManager.createView(\n…pper, jsResponderHandler)");
            return createView;
        }

        public String getName() {
            String name = this.viewManager.getName();
            Intrinsics.e(name, "viewManager.name");
            return name;
        }

        public ViewGroupManager<?> getViewGroupManager() {
            return (ViewGroupManager) this.viewManager;
        }

        public void onDropViewInstance(View view) {
            Intrinsics.f(view, "view");
            this.viewManager.onDropViewInstance(view);
        }

        public void receiveCommand(View view, String str, ReadableArray readableArray) {
            Intrinsics.f(view, "root");
            Intrinsics.f(str, "commandId");
            this.viewManager.receiveCommand(view, str, readableArray);
        }

        public void setPadding(View view, int i2, int i3, int i4, int i5) {
            Intrinsics.f(view, "view");
            this.viewManager.setPadding(view, i2, i3, i4, i5);
        }

        public void updateExtraData(View view, Object obj) {
            Intrinsics.f(view, "root");
            this.viewManager.updateExtraData(view, obj);
        }

        public void updateProperties(View view, Object obj) {
            ReactStylesDiffMap reactStylesDiffMap;
            Intrinsics.f(view, "viewToUpdate");
            ViewManager<View, ?> viewManager2 = this.viewManager;
            if (obj instanceof ReactStylesDiffMap) {
                reactStylesDiffMap = (ReactStylesDiffMap) obj;
            } else {
                reactStylesDiffMap = null;
            }
            viewManager2.updateProperties(view, reactStylesDiffMap);
        }

        public Object updateState(View view, Object obj, StateWrapper stateWrapper) {
            ReactStylesDiffMap reactStylesDiffMap;
            Intrinsics.f(view, "view");
            ViewManager<View, ?> viewManager2 = this.viewManager;
            if (obj instanceof ReactStylesDiffMap) {
                reactStylesDiffMap = (ReactStylesDiffMap) obj;
            } else {
                reactStylesDiffMap = null;
            }
            return viewManager2.updateState(view, reactStylesDiffMap, stateWrapper);
        }

        public void receiveCommand(View view, int i2, ReadableArray readableArray) {
            Intrinsics.f(view, "root");
            this.viewManager.receiveCommand(view, i2, readableArray);
        }
    }

    View createView(int i2, ThemedReactContext themedReactContext, Object obj, StateWrapper stateWrapper, JSResponderHandler jSResponderHandler);

    String getName();

    ViewGroupManager<?> getViewGroupManager();

    void onDropViewInstance(View view);

    void receiveCommand(View view, int i2, ReadableArray readableArray);

    void receiveCommand(View view, String str, ReadableArray readableArray);

    void setPadding(View view, int i2, int i3, int i4, int i5);

    void updateExtraData(View view, Object obj);

    void updateProperties(View view, Object obj);

    Object updateState(View view, Object obj, StateWrapper stateWrapper);
}
