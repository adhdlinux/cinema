package com.facebook.react.views.slider;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

public class ReactSliderEvent extends Event<ReactSliderEvent> {
    public static final String EVENT_NAME = "topChange";
    private final boolean mFromUser;
    private final double mValue;

    public ReactSliderEvent(int i2, double d2, boolean z2) {
        super(i2);
        this.mValue = d2;
        this.mFromUser = z2;
    }

    private WritableMap serializeEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        createMap.putDouble(AppMeasurementSdk.ConditionalUserProperty.VALUE, getValue());
        createMap.putBoolean("fromUser", isFromUser());
        return createMap;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    public String getEventName() {
        return "topChange";
    }

    public double getValue() {
        return this.mValue;
    }

    public boolean isFromUser() {
        return this.mFromUser;
    }
}
