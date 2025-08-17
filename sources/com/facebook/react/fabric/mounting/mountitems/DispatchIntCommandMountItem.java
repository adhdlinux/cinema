package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.fabric.mounting.MountingManager;

public class DispatchIntCommandMountItem extends DispatchCommandMountItem {
    private final ReadableArray mCommandArgs;
    private final int mCommandId;
    private final int mReactTag;
    private final int mSurfaceId;

    public DispatchIntCommandMountItem(int i2, int i3, int i4, ReadableArray readableArray) {
        this.mSurfaceId = i2;
        this.mReactTag = i3;
        this.mCommandId = i4;
        this.mCommandArgs = readableArray;
    }

    public void execute(MountingManager mountingManager) {
        mountingManager.receiveCommand(this.mSurfaceId, this.mReactTag, this.mCommandId, this.mCommandArgs);
    }

    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    public String toString() {
        return "DispatchIntCommandMountItem [" + this.mReactTag + "] " + this.mCommandId;
    }
}
