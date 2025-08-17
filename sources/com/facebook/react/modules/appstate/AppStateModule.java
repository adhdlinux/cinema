package com.facebook.react.modules.appstate;

import com.facebook.fbreact.specs.NativeAppStateSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WindowFocusChangeListener;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "AppState")
public class AppStateModule extends NativeAppStateSpec implements LifecycleEventListener, WindowFocusChangeListener {
    public static final String APP_STATE_ACTIVE = "active";
    public static final String APP_STATE_BACKGROUND = "background";
    private static final String INITIAL_STATE = "initialAppState";
    public static final String NAME = "AppState";
    public static final String TAG = "AppStateModule";
    private String mAppState;

    public AppStateModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        String str;
        reactApplicationContext.addLifecycleEventListener(this);
        reactApplicationContext.addWindowFocusChangeListener(this);
        if (reactApplicationContext.getLifecycleState() == LifecycleState.RESUMED) {
            str = "active";
        } else {
            str = APP_STATE_BACKGROUND;
        }
        this.mAppState = str;
    }

    private WritableMap createAppStateEventMap() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("app_state", this.mAppState);
        return createMap;
    }

    private void sendAppStateChangeEvent() {
        sendEvent("appStateDidChange", createAppStateEventMap());
    }

    private void sendEvent(String str, Object obj) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext != null && reactApplicationContext.hasActiveReactInstance()) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, obj);
        }
    }

    public void addListener(String str) {
    }

    public void getCurrentAppState(Callback callback, Callback callback2) {
        callback.invoke(createAppStateEventMap());
    }

    public String getName() {
        return NAME;
    }

    public Map<String, Object> getTypedExportedConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put(INITIAL_STATE, this.mAppState);
        return hashMap;
    }

    public void invalidate() {
        super.invalidate();
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            reactApplicationContextIfActiveOrWarn.removeLifecycleEventListener(this);
        }
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
        this.mAppState = APP_STATE_BACKGROUND;
        sendAppStateChangeEvent();
    }

    public void onHostResume() {
        this.mAppState = "active";
        sendAppStateChangeEvent();
    }

    public void onWindowFocusChange(boolean z2) {
        sendEvent("appStateFocusChange", Boolean.valueOf(z2));
    }

    public void removeListeners(double d2) {
    }
}
