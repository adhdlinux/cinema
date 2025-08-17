package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.TouchesHelper;

class ReactTextInputEndEditingEvent extends Event<ReactTextInputEndEditingEvent> {
    private static final String EVENT_NAME = "topEndEditing";
    private String mText;

    @Deprecated
    public ReactTextInputEndEditingEvent(int i2, String str) {
        this(-1, i2, str);
    }

    public boolean canCoalesce() {
        return false;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        createMap.putString("text", this.mText);
        return createMap;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    public ReactTextInputEndEditingEvent(int i2, int i3, String str) {
        super(i2, i3);
        this.mText = str;
    }
}
