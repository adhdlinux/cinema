package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class DrawerClosedEvent extends Event<DrawerClosedEvent> {
    public static final String EVENT_NAME = "topDrawerClose";

    @Deprecated
    public DrawerClosedEvent(int i2) {
        this(-1, i2);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return Arguments.createMap();
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    public DrawerClosedEvent(int i2, int i3) {
        super(i2, i3);
    }
}
