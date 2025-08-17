package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;

public class ContentSizeChangeEvent extends Event<ContentSizeChangeEvent> {
    public static final String EVENT_NAME = "topContentSizeChange";
    private final int mHeight;
    private final int mWidth;

    @Deprecated
    public ContentSizeChangeEvent(int i2, int i3, int i4) {
        this(-1, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("width", (double) PixelUtil.toDIPFromPixel((float) this.mWidth));
        createMap.putDouble("height", (double) PixelUtil.toDIPFromPixel((float) this.mHeight));
        return createMap;
    }

    public String getEventName() {
        return "topContentSizeChange";
    }

    public ContentSizeChangeEvent(int i2, int i3, int i4, int i5) {
        super(i2, i3);
        this.mWidth = i4;
        this.mHeight = i5;
    }
}
