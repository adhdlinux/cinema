package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class DrawerOpenedEvent extends Event<DrawerOpenedEvent> {
    public static final String EVENT_NAME = "topDrawerOpen";

    @Deprecated
    public DrawerOpenedEvent(int i2) {
        this(-1, i2);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return Arguments.createMap();
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    public DrawerOpenedEvent(int i2, int i3) {
        super(i2, i3);
    }
}
