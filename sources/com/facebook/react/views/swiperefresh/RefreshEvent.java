package com.facebook.react.views.swiperefresh;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class RefreshEvent extends Event<RefreshEvent> {
    @Deprecated
    protected RefreshEvent(int i2) {
        this(-1, i2);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return Arguments.createMap();
    }

    public String getEventName() {
        return "topRefresh";
    }

    protected RefreshEvent(int i2, int i3) {
        super(i2, i3);
    }
}
