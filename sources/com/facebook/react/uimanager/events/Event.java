package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.SystemClock;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.events.Event;

public abstract class Event<T extends Event> {
    private static int sUniqueID;
    private boolean mInitialized;
    private int mSurfaceId;
    private long mTimestampMs;
    private int mUIManagerType;
    private int mUniqueID;
    private int mViewTag;

    protected Event() {
        int i2 = sUniqueID;
        sUniqueID = i2 + 1;
        this.mUniqueID = i2;
    }

    public boolean canCoalesce() {
        return true;
    }

    public T coalesce(T t2) {
        return getTimestampMs() >= t2.getTimestampMs() ? this : t2;
    }

    @Deprecated
    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        WritableMap eventData = getEventData();
        if (eventData != null) {
            rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), eventData);
            return;
        }
        throw new IllegalViewOperationException("Event: you must return a valid, non-null value from `getEventData`, or override `dispatch` and `dispatchModern`. Event: " + getEventName());
    }

    @Deprecated
    public void dispatchModern(RCTModernEventEmitter rCTModernEventEmitter) {
        WritableMap eventData;
        if (getSurfaceId() == -1 || (eventData = getEventData()) == null) {
            dispatch(rCTModernEventEmitter);
            return;
        }
        rCTModernEventEmitter.receiveEvent(getSurfaceId(), getViewTag(), getEventName(), canCoalesce(), getCoalescingKey(), eventData, getEventCategory());
    }

    /* access modifiers changed from: package-private */
    public final void dispose() {
        this.mInitialized = false;
        onDispose();
    }

    public short getCoalescingKey() {
        return 0;
    }

    /* access modifiers changed from: protected */
    @EventCategoryDef
    public int getEventCategory() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return null;
    }

    public abstract String getEventName();

    public final int getSurfaceId() {
        return this.mSurfaceId;
    }

    public final long getTimestampMs() {
        return this.mTimestampMs;
    }

    public final int getUIManagerType() {
        return this.mUIManagerType;
    }

    public int getUniqueID() {
        return this.mUniqueID;
    }

    public final int getViewTag() {
        return this.mViewTag;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void init(int i2) {
        init(-1, i2);
    }

    /* access modifiers changed from: package-private */
    public boolean isInitialized() {
        return this.mInitialized;
    }

    public void onDispose() {
    }

    /* access modifiers changed from: protected */
    public void init(int i2, int i3) {
        init(i2, i3, SystemClock.uptimeMillis());
    }

    @Deprecated
    protected Event(int i2) {
        int i3 = sUniqueID;
        sUniqueID = i3 + 1;
        this.mUniqueID = i3;
        init(i2);
    }

    /* access modifiers changed from: protected */
    public void init(int i2, int i3, long j2) {
        this.mSurfaceId = i2;
        this.mViewTag = i3;
        this.mUIManagerType = i2 == -1 ? 1 : 2;
        this.mTimestampMs = j2;
        this.mInitialized = true;
    }

    protected Event(int i2, int i3) {
        int i4 = sUniqueID;
        sUniqueID = i4 + 1;
        this.mUniqueID = i4;
        init(i2, i3);
    }
}
