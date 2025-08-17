package com.facebook.react.views.modal;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

class RequestCloseEvent extends Event<RequestCloseEvent> {
    public static final String EVENT_NAME = "topRequestClose";

    @Deprecated
    protected RequestCloseEvent(int i2) {
        this(-1, i2);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return Arguments.createMap();
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    protected RequestCloseEvent(int i2, int i3) {
        super(i2, i3);
    }
}
