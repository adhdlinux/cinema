package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.TouchesHelper;

class ReactTextInputFocusEvent extends Event<ReactTextInputFocusEvent> {
    private static final String EVENT_NAME = "topFocus";

    @Deprecated
    public ReactTextInputFocusEvent(int i2) {
        this(-1, i2);
    }

    public boolean canCoalesce() {
        return false;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        return createMap;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    public ReactTextInputFocusEvent(int i2, int i3) {
        super(i2, i3);
    }
}
