package com.facebook.react.uimanager;

import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.annotations.ReactPropertyHolder;
import com.facebook.yoga.YogaMeasureMode;
import java.util.Map;

@ReactPropertyHolder
public abstract class ViewManager<T extends View, C extends ReactShadowNode> extends BaseJavaModule {
    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, T t2) {
    }

    public C createShadowNodeInstance() {
        throw new RuntimeException("ViewManager subclasses must implement createShadowNodeInstance()");
    }

    public T createView(int i2, ThemedReactContext themedReactContext, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper, JSResponderHandler jSResponderHandler) {
        T createViewInstance = createViewInstance(i2, themedReactContext, reactStylesDiffMap, stateWrapper);
        if (createViewInstance instanceof ReactInterceptingViewGroup) {
            ((ReactInterceptingViewGroup) createViewInstance).setOnInterceptTouchEventListener(jSResponderHandler);
        }
        return createViewInstance;
    }

    /* access modifiers changed from: protected */
    public T createViewInstance(int i2, ThemedReactContext themedReactContext, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        Object updateState;
        T createViewInstance = createViewInstance(themedReactContext);
        createViewInstance.setId(i2);
        addEventEmitters(themedReactContext, createViewInstance);
        if (reactStylesDiffMap != null) {
            updateProperties(createViewInstance, reactStylesDiffMap);
        }
        if (!(stateWrapper == null || (updateState = updateState(createViewInstance, reactStylesDiffMap, stateWrapper)) == null)) {
            updateExtraData(createViewInstance, updateState);
        }
        return createViewInstance;
    }

    /* access modifiers changed from: protected */
    public abstract T createViewInstance(ThemedReactContext themedReactContext);

    public Map<String, Integer> getCommandsMap() {
        return null;
    }

    /* access modifiers changed from: protected */
    public ViewManagerDelegate<T> getDelegate() {
        return null;
    }

    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return null;
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return null;
    }

    public Map<String, Object> getExportedViewConstants() {
        return null;
    }

    public abstract String getName();

    public Map<String, String> getNativeProps() {
        return ViewManagerPropertyUpdater.getNativeProps(getClass(), getShadowNodeClass());
    }

    public abstract Class<? extends C> getShadowNodeClass();

    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2, float[] fArr) {
        return 0;
    }

    public long measure(Context context, MapBuffer mapBuffer, MapBuffer mapBuffer2, MapBuffer mapBuffer3, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2, float[] fArr) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(T t2) {
    }

    public void onDropViewInstance(T t2) {
    }

    @Deprecated
    public void receiveCommand(T t2, int i2, ReadableArray readableArray) {
    }

    public void receiveCommand(T t2, String str, ReadableArray readableArray) {
    }

    public void setPadding(T t2, int i2, int i3, int i4, int i5) {
    }

    public abstract void updateExtraData(T t2, Object obj);

    public void updateProperties(T t2, ReactStylesDiffMap reactStylesDiffMap) {
        ViewManagerDelegate delegate = getDelegate();
        if (delegate != null) {
            ViewManagerPropertyUpdater.updateProps(delegate, t2, reactStylesDiffMap);
        } else {
            ViewManagerPropertyUpdater.updateProps(this, t2, reactStylesDiffMap);
        }
        onAfterUpdateTransaction(t2);
    }

    public Object updateState(T t2, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        return null;
    }

    public C createShadowNodeInstance(ReactApplicationContext reactApplicationContext) {
        return createShadowNodeInstance();
    }
}
