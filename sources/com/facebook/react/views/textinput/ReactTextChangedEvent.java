package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.TouchesHelper;

public class ReactTextChangedEvent extends Event<ReactTextChangedEvent> {
    public static final String EVENT_NAME = "topChange";
    private int mEventCount;
    private String mText;

    @Deprecated
    public ReactTextChangedEvent(int i2, String str, int i3) {
        this(-1, i2, str, i3);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("text", this.mText);
        createMap.putInt("eventCount", this.mEventCount);
        createMap.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        return createMap;
    }

    public String getEventName() {
        return "topChange";
    }

    public ReactTextChangedEvent(int i2, int i3, String str, int i4) {
        super(i2, i3);
        this.mText = str;
        this.mEventCount = i4;
    }
}
