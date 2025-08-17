package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.fabric.mounting.MountingManager;

public class DispatchStringCommandMountItem extends DispatchCommandMountItem {
    private final ReadableArray mCommandArgs;
    private final String mCommandId;
    private final int mReactTag;
    private final int mSurfaceId;

    public DispatchStringCommandMountItem(int i2, int i3, String str, ReadableArray readableArray) {
        this.mSurfaceId = i2;
        this.mReactTag = i3;
        this.mCommandId = str;
        this.mCommandArgs = readableArray;
    }

    public void execute(MountingManager mountingManager) {
        mountingManager.receiveCommand(this.mSurfaceId, this.mReactTag, this.mCommandId, this.mCommandArgs);
    }

    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    public String toString() {
        return "DispatchStringCommandMountItem [" + this.mReactTag + "] " + this.mCommandId;
    }
}
