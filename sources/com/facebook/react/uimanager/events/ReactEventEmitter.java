package com.facebook.react.uimanager.events;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.common.ViewUtil;

public class ReactEventEmitter implements RCTModernEventEmitter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ReactEventEmitter";
    private RCTModernEventEmitter mFabricEventEmitter = null;
    private RCTEventEmitter mRCTEventEmitter = null;
    private final ReactApplicationContext mReactContext;

    public ReactEventEmitter(ReactApplicationContext reactApplicationContext) {
        this.mReactContext = reactApplicationContext;
    }

    private RCTEventEmitter getEventEmitter(int i2) {
        int uIManagerType = ViewUtil.getUIManagerType(i2);
        if (this.mRCTEventEmitter == null) {
            if (this.mReactContext.hasActiveReactInstance()) {
                this.mRCTEventEmitter = (RCTEventEmitter) this.mReactContext.getJSModule(RCTEventEmitter.class);
            } else {
                ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Cannot get RCTEventEmitter from Context for reactTag: " + i2 + " - uiManagerType: " + uIManagerType + " - No active Catalyst instance!"));
            }
        }
        return this.mRCTEventEmitter;
    }

    public void receiveEvent(int i2, String str, WritableMap writableMap) {
        receiveEvent(-1, i2, str, writableMap);
    }

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        Assertions.assertCondition(writableArray.size() > 0);
        int i2 = writableArray.getMap(0).getInt(TouchesHelper.TARGET_KEY);
        if (ViewUtil.getUIManagerType(i2) == 1 && getEventEmitter(i2) != null) {
            this.mRCTEventEmitter.receiveTouches(str, writableArray, writableArray2);
        }
    }

    public void register(int i2, RCTModernEventEmitter rCTModernEventEmitter) {
        this.mFabricEventEmitter = rCTModernEventEmitter;
    }

    public void unregister(int i2) {
        if (i2 == 1) {
            this.mRCTEventEmitter = null;
        } else {
            this.mFabricEventEmitter = null;
        }
    }

    public void receiveEvent(int i2, int i3, String str, WritableMap writableMap) {
        receiveEvent(i2, i3, str, false, 0, writableMap, 2);
    }

    public void register(int i2, RCTEventEmitter rCTEventEmitter) {
        this.mRCTEventEmitter = rCTEventEmitter;
    }

    public void receiveEvent(int i2, int i3, String str, boolean z2, int i4, WritableMap writableMap, @EventCategoryDef int i5) {
        RCTModernEventEmitter rCTModernEventEmitter;
        int i6 = i3;
        String str2 = str;
        int uIManagerType = ViewUtil.getUIManagerType(i3);
        if (uIManagerType == 2 && (rCTModernEventEmitter = this.mFabricEventEmitter) != null) {
            rCTModernEventEmitter.receiveEvent(i2, i3, str, z2, i4, writableMap, i5);
        } else if (uIManagerType != 1 || getEventEmitter(i3) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot find EventEmitter for receiveEvent: SurfaceId[");
            int i7 = i2;
            sb.append(i2);
            sb.append("] ReactTag[");
            sb.append(i3);
            sb.append("] UIManagerType[");
            sb.append(uIManagerType);
            sb.append("] EventName[");
            sb.append(str);
            sb.append("]");
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException(sb.toString()));
        } else {
            WritableMap writableMap2 = writableMap;
            this.mRCTEventEmitter.receiveEvent(i3, str, writableMap);
        }
    }

    public void receiveTouches(TouchEvent touchEvent) {
        RCTModernEventEmitter rCTModernEventEmitter;
        int viewTag = touchEvent.getViewTag();
        int uIManagerType = ViewUtil.getUIManagerType(viewTag);
        if (uIManagerType == 2 && (rCTModernEventEmitter = this.mFabricEventEmitter) != null) {
            rCTModernEventEmitter.receiveTouches(touchEvent);
        } else if (uIManagerType != 1 || getEventEmitter(viewTag) == null) {
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Cannot find EventEmitter for receivedTouches: ReactTag[" + viewTag + "] UIManagerType[" + uIManagerType + "] EventName[" + touchEvent.getEventName() + "]"));
        } else {
            TouchesHelper.sendTouchesLegacy(this.mRCTEventEmitter, touchEvent);
        }
    }
}
