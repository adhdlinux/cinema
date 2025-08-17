package com.facebook.react.uimanager;

import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.TouchesHelper;

public class OnLayoutEvent extends Event<OnLayoutEvent> {
    private static final Pools$SynchronizedPool<OnLayoutEvent> EVENTS_POOL = new Pools$SynchronizedPool<>(20);
    private int mHeight;
    private int mWidth;
    private int mX;
    private int mY;

    private OnLayoutEvent() {
    }

    @Deprecated
    public static OnLayoutEvent obtain(int i2, int i3, int i4, int i5, int i6) {
        return obtain(-1, i2, i3, i4, i5, i6);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("x", (double) PixelUtil.toDIPFromPixel((float) this.mX));
        createMap.putDouble("y", (double) PixelUtil.toDIPFromPixel((float) this.mY));
        createMap.putDouble("width", (double) PixelUtil.toDIPFromPixel((float) this.mWidth));
        createMap.putDouble("height", (double) PixelUtil.toDIPFromPixel((float) this.mHeight));
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putMap("layout", createMap);
        createMap2.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        return createMap2;
    }

    public String getEventName() {
        return "topLayout";
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void init(int i2, int i3, int i4, int i5, int i6) {
        init(-1, i2, i3, i4, i5, i6);
    }

    public void onDispose() {
        EVENTS_POOL.release(this);
    }

    public static OnLayoutEvent obtain(int i2, int i3, int i4, int i5, int i6, int i7) {
        OnLayoutEvent acquire = EVENTS_POOL.acquire();
        if (acquire == null) {
            acquire = new OnLayoutEvent();
        }
        acquire.init(i2, i3, i4, i5, i6, i7);
        return acquire;
    }

    /* access modifiers changed from: protected */
    public void init(int i2, int i3, int i4, int i5, int i6, int i7) {
        super.init(i2, i3);
        this.mX = i4;
        this.mY = i5;
        this.mWidth = i6;
        this.mHeight = i7;
    }
}
