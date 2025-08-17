package com.facebook.react.fabric.events;

import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.uimanager.events.EventCategoryDef;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;
import com.facebook.react.uimanager.events.TouchEvent;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.facebook.systrace.Systrace;

public class FabricEventEmitter implements RCTModernEventEmitter {
    private static final String TAG = "FabricEventEmitter";
    private final FabricUIManager mUIManager;

    public FabricEventEmitter(FabricUIManager fabricUIManager) {
        this.mUIManager = fabricUIManager;
    }

    public void receiveEvent(int i2, String str, WritableMap writableMap) {
        receiveEvent(-1, i2, str, writableMap);
    }

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        throw new IllegalStateException("EventEmitter#receiveTouches is not supported by Fabric");
    }

    public void receiveEvent(int i2, int i3, String str, WritableMap writableMap) {
        receiveEvent(i2, i3, str, false, 0, writableMap, 2);
    }

    public void receiveTouches(TouchEvent touchEvent) {
        TouchesHelper.sendTouchEvent(this, touchEvent);
    }

    public void receiveEvent(int i2, int i3, String str, boolean z2, int i4, WritableMap writableMap, @EventCategoryDef int i5) {
        StringBuilder sb = new StringBuilder();
        sb.append("FabricEventEmitter.receiveEvent('");
        String str2 = str;
        sb.append(str);
        sb.append("')");
        Systrace.beginSection(0, sb.toString());
        this.mUIManager.receiveEvent(i2, i3, str, z2, i4, writableMap, i5);
        Systrace.endSection(0);
    }
}
