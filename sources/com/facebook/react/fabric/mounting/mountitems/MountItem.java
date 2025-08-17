package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.fabric.mounting.MountingManager;

@DoNotStrip
public interface MountItem {
    void execute(MountingManager mountingManager);

    int getSurfaceId();
}
