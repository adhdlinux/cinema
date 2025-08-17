package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class ReactTextInputKeyPressEvent extends Event<ReactTextInputEvent> {
    public static final String EVENT_NAME = "topKeyPress";
    private String mKey;

    @Deprecated
    ReactTextInputKeyPressEvent(int i2, String str) {
        this(-1, i2, str);
    }

    public boolean canCoalesce() {
        return false;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("key", this.mKey);
        return createMap;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    ReactTextInputKeyPressEvent(int i2, int i3, String str) {
        super(i2, i3);
        this.mKey = str;
    }
}
