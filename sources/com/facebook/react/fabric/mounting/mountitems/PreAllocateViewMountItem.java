package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.common.logging.FLog;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.SurfaceMountingManager;
import com.facebook.react.uimanager.StateWrapper;

public class PreAllocateViewMountItem implements MountItem {
    private final String mComponent;
    private final EventEmitterWrapper mEventEmitterWrapper;
    private final boolean mIsLayoutable;
    private final Object mProps;
    private final int mReactTag;
    private final StateWrapper mStateWrapper;
    private final int mSurfaceId;

    public PreAllocateViewMountItem(int i2, int i3, String str, Object obj, StateWrapper stateWrapper, EventEmitterWrapper eventEmitterWrapper, boolean z2) {
        this.mComponent = str;
        this.mSurfaceId = i2;
        this.mProps = obj;
        this.mStateWrapper = stateWrapper;
        this.mEventEmitterWrapper = eventEmitterWrapper;
        this.mReactTag = i3;
        this.mIsLayoutable = z2;
    }

    public void execute(MountingManager mountingManager) {
        SurfaceMountingManager surfaceManager = mountingManager.getSurfaceManager(this.mSurfaceId);
        if (surfaceManager == null) {
            String str = FabricUIManager.TAG;
            FLog.e(str, "Skipping View PreAllocation; no SurfaceMountingManager found for [" + this.mSurfaceId + "]");
            return;
        }
        surfaceManager.preallocateView(this.mComponent, this.mReactTag, this.mProps, this.mStateWrapper, this.mEventEmitterWrapper, this.mIsLayoutable);
    }

    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    public String toString() {
        return "PreAllocateViewMountItem [" + this.mReactTag + "] - component: " + this.mComponent + " surfaceId: " + this.mSurfaceId + " isLayoutable: " + this.mIsLayoutable;
    }
}
