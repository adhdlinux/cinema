package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class DrawerStateChangedEvent extends Event<DrawerStateChangedEvent> {
    public static final String EVENT_NAME = "topDrawerStateChanged";
    private final int mDrawerState;

    @Deprecated
    public DrawerStateChangedEvent(int i2, int i3) {
        this(-1, i2, i3);
    }

    public int getDrawerState() {
        return this.mDrawerState;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("drawerState", (double) getDrawerState());
        return createMap;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    public DrawerStateChangedEvent(int i2, int i3, int i4) {
        super(i2, i3);
        this.mDrawerState = i4;
    }
}
