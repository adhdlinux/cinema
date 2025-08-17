package com.facebook.react.views.switchview;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

class ReactSwitchEvent extends Event<ReactSwitchEvent> {
    public static final String EVENT_NAME = "topChange";
    private final boolean mIsChecked;

    @Deprecated
    public ReactSwitchEvent(int i2, boolean z2) {
        this(-1, i2, z2);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        createMap.putBoolean(AppMeasurementSdk.ConditionalUserProperty.VALUE, getIsChecked());
        return createMap;
    }

    public String getEventName() {
        return "topChange";
    }

    public boolean getIsChecked() {
        return this.mIsChecked;
    }

    public ReactSwitchEvent(int i2, int i3, boolean z2) {
        super(i2, i3);
        this.mIsChecked = z2;
    }
}
