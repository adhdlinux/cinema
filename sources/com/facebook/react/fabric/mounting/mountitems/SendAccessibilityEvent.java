package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.fabric.mounting.MountingManager;

public class SendAccessibilityEvent implements MountItem {
    private final String TAG = "Fabric.SendAccessibilityEvent";
    private final int mEventType;
    private final int mReactTag;
    private final int mSurfaceId;

    public SendAccessibilityEvent(int i2, int i3, int i4) {
        this.mSurfaceId = i2;
        this.mReactTag = i3;
        this.mEventType = i4;
    }

    public void execute(MountingManager mountingManager) {
        try {
            mountingManager.sendAccessibilityEvent(this.mSurfaceId, this.mReactTag, this.mEventType);
        } catch (RetryableMountingLayerException e2) {
            ReactSoftExceptionLogger.logSoftException("Fabric.SendAccessibilityEvent", e2);
        }
    }

    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    public String toString() {
        return "SendAccessibilityEvent [" + this.mReactTag + "] " + this.mEventType;
    }
}
