package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class DrawerSlideEvent extends Event<DrawerSlideEvent> {
    public static final String EVENT_NAME = "topDrawerSlide";
    private final float mOffset;

    @Deprecated
    public DrawerSlideEvent(int i2, float f2) {
        this(-1, i2, f2);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("offset", (double) getOffset());
        return createMap;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    public float getOffset() {
        return this.mOffset;
    }

    public DrawerSlideEvent(int i2, int i3, float f2) {
        super(i2, i3);
        this.mOffset = f2;
    }
}
