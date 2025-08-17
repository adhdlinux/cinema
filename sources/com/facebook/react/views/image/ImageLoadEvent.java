package com.facebook.react.views.image;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.vungle.ads.internal.presenter.MRAIDPresenter;

public class ImageLoadEvent extends Event<ImageLoadEvent> {
    public static final int ON_ERROR = 1;
    public static final int ON_LOAD = 2;
    public static final int ON_LOAD_END = 3;
    public static final int ON_LOAD_START = 4;
    public static final int ON_PROGRESS = 5;
    private final String mErrorMessage;
    private final int mEventType;
    private final int mHeight;
    private final int mLoaded;
    private final String mSourceUri;
    private final int mTotal;
    private final int mWidth;

    private ImageLoadEvent(int i2, int i3, int i4) {
        this(i2, i3, i4, (String) null, (String) null, 0, 0, 0, 0);
    }

    @Deprecated
    public static final ImageLoadEvent createErrorEvent(int i2, Throwable th) {
        return createErrorEvent(-1, i2, th);
    }

    private WritableMap createEventDataSource() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("uri", this.mSourceUri);
        createMap.putDouble("width", (double) this.mWidth);
        createMap.putDouble("height", (double) this.mHeight);
        return createMap;
    }

    @Deprecated
    public static final ImageLoadEvent createLoadEndEvent(int i2) {
        return createLoadEndEvent(-1, i2);
    }

    @Deprecated
    public static final ImageLoadEvent createLoadEvent(int i2, String str, int i3, int i4) {
        return createLoadEvent(-1, i2, str, i3, i4);
    }

    @Deprecated
    public static final ImageLoadEvent createLoadStartEvent(int i2) {
        return createLoadStartEvent(-1, i2);
    }

    @Deprecated
    public static final ImageLoadEvent createProgressEvent(int i2, String str, int i3, int i4) {
        return createProgressEvent(-1, i2, str, i3, i4);
    }

    public static String eventNameForType(int i2) {
        if (i2 == 1) {
            return "topError";
        }
        if (i2 == 2) {
            return "topLoad";
        }
        if (i2 == 3) {
            return "topLoadEnd";
        }
        if (i2 == 4) {
            return "topLoadStart";
        }
        if (i2 == 5) {
            return "topProgress";
        }
        throw new IllegalStateException("Invalid image event: " + Integer.toString(i2));
    }

    public short getCoalescingKey() {
        return (short) this.mEventType;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        int i2 = this.mEventType;
        if (i2 == 1) {
            createMap.putString(MRAIDPresenter.ERROR, this.mErrorMessage);
        } else if (i2 == 2) {
            createMap.putMap("source", createEventDataSource());
        } else if (i2 == 5) {
            createMap.putInt("loaded", this.mLoaded);
            createMap.putInt("total", this.mTotal);
        }
        return createMap;
    }

    public String getEventName() {
        return eventNameForType(this.mEventType);
    }

    private ImageLoadEvent(int i2, int i3, int i4, String str, String str2, int i5, int i6, int i7, int i8) {
        super(i2, i3);
        this.mEventType = i4;
        this.mErrorMessage = str;
        this.mSourceUri = str2;
        this.mWidth = i5;
        this.mHeight = i6;
        this.mLoaded = i7;
        this.mTotal = i8;
    }

    public static final ImageLoadEvent createErrorEvent(int i2, int i3, Throwable th) {
        return new ImageLoadEvent(i2, i3, 1, th.getMessage(), (String) null, 0, 0, 0, 0);
    }

    public static final ImageLoadEvent createLoadEndEvent(int i2, int i3) {
        return new ImageLoadEvent(i2, i3, 3);
    }

    public static final ImageLoadEvent createLoadEvent(int i2, int i3, String str, int i4, int i5) {
        return new ImageLoadEvent(i2, i3, 2, (String) null, str, i4, i5, 0, 0);
    }

    public static final ImageLoadEvent createLoadStartEvent(int i2, int i3) {
        return new ImageLoadEvent(i2, i3, 4);
    }

    public static final ImageLoadEvent createProgressEvent(int i2, int i3, String str, int i4, int i5) {
        return new ImageLoadEvent(i2, i3, 5, (String) null, str, 0, 0, i4, i5);
    }
}
