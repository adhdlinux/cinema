package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;

class ReactTextInputSelectionEvent extends Event<ReactTextInputSelectionEvent> {
    private static final String EVENT_NAME = "topSelectionChange";
    private int mSelectionEnd;
    private int mSelectionStart;

    @Deprecated
    public ReactTextInputSelectionEvent(int i2, int i3, int i4) {
        this(-1, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putInt(ViewProps.END, this.mSelectionEnd);
        createMap2.putInt(ViewProps.START, this.mSelectionStart);
        createMap.putMap(ReactTextInputShadowNode.PROP_SELECTION, createMap2);
        return createMap;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    public ReactTextInputSelectionEvent(int i2, int i3, int i4, int i5) {
        super(i2, i3);
        this.mSelectionStart = i4;
        this.mSelectionEnd = i5;
    }
}
