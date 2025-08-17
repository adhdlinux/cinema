package com.facebook.react.views.modal;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

class ShowEvent extends Event<ShowEvent> {
    public static final String EVENT_NAME = "topShow";

    @Deprecated
    protected ShowEvent(int i2) {
        this(-1, i2);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return Arguments.createMap();
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    protected ShowEvent(int i2, int i3) {
        super(i2, i3);
    }
}
