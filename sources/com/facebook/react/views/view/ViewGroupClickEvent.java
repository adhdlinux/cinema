package com.facebook.react.views.view;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class ViewGroupClickEvent extends Event<ViewGroupClickEvent> {
    private static final String EVENT_NAME = "topClick";

    @Deprecated
    public ViewGroupClickEvent(int i2) {
        this(-1, i2);
    }

    public boolean canCoalesce() {
        return false;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return Arguments.createMap();
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    public ViewGroupClickEvent(int i2, int i3) {
        super(i2, i3);
    }
}
