package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.TouchesHelper;

public class ReactTextInputEvent extends Event<ReactTextInputEvent> {
    public static final String EVENT_NAME = "topTextInput";
    private String mPreviousText;
    private int mRangeEnd;
    private int mRangeStart;
    private String mText;

    @Deprecated
    public ReactTextInputEvent(int i2, String str, String str2, int i3, int i4) {
        this(-1, i2, str, str2, i3, i4);
    }

    public boolean canCoalesce() {
        return false;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble(ViewProps.START, (double) this.mRangeStart);
        createMap2.putDouble(ViewProps.END, (double) this.mRangeEnd);
        createMap.putString("text", this.mText);
        createMap.putString("previousText", this.mPreviousText);
        createMap.putMap("range", createMap2);
        createMap.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        return createMap;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    public ReactTextInputEvent(int i2, int i3, String str, String str2, int i4, int i5) {
        super(i2, i3);
        this.mText = str;
        this.mPreviousText = str2;
        this.mRangeStart = i4;
        this.mRangeEnd = i5;
    }
}
