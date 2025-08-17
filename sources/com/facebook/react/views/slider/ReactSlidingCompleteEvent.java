package com.facebook.react.views.slider;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

public class ReactSlidingCompleteEvent extends Event<ReactSlidingCompleteEvent> {
    public static final String EVENT_NAME = "topSlidingComplete";
    private final double mValue;

    @Deprecated
    public ReactSlidingCompleteEvent(int i2, double d2) {
        this(-1, i2, d2);
    }

    public boolean canCoalesce() {
        return false;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        createMap.putDouble(AppMeasurementSdk.ConditionalUserProperty.VALUE, getValue());
        return createMap;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    public double getValue() {
        return this.mValue;
    }

    public ReactSlidingCompleteEvent(int i2, int i3, double d2) {
        super(i2, i3);
        this.mValue = d2;
    }
}
