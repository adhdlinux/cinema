package com.facebook.react.modules.appearance;

import android.content.Context;
import com.facebook.fbreact.specs.NativeAppearanceSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;

@ReactModule(name = "Appearance")
public class AppearanceModule extends NativeAppearanceSpec {
    private static final String APPEARANCE_CHANGED_EVENT_NAME = "appearanceChanged";
    public static final String NAME = "Appearance";
    private String mColorScheme;
    private final OverrideColorScheme mOverrideColorScheme;

    public interface OverrideColorScheme {
        String getScheme();
    }

    public AppearanceModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, (OverrideColorScheme) null);
    }

    private String colorSchemeForCurrentConfiguration(Context context) {
        OverrideColorScheme overrideColorScheme = this.mOverrideColorScheme;
        if (overrideColorScheme != null) {
            return overrideColorScheme.getScheme();
        }
        if ((context.getResources().getConfiguration().uiMode & 48) != 32) {
            return "light";
        }
        return "dark";
    }

    public void addListener(String str) {
    }

    public void emitAppearanceChanged(String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("colorScheme", str);
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContextIfActiveOrWarn.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(APPEARANCE_CHANGED_EVENT_NAME, createMap);
        }
    }

    public String getColorScheme() {
        Context currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            currentActivity = getReactApplicationContext();
        }
        String colorSchemeForCurrentConfiguration = colorSchemeForCurrentConfiguration(currentActivity);
        this.mColorScheme = colorSchemeForCurrentConfiguration;
        return colorSchemeForCurrentConfiguration;
    }

    public String getName() {
        return NAME;
    }

    public void onConfigurationChanged(Context context) {
        String colorSchemeForCurrentConfiguration = colorSchemeForCurrentConfiguration(context);
        if (!this.mColorScheme.equals(colorSchemeForCurrentConfiguration)) {
            this.mColorScheme = colorSchemeForCurrentConfiguration;
            emitAppearanceChanged(colorSchemeForCurrentConfiguration);
        }
    }

    public void removeListeners(double d2) {
    }

    public AppearanceModule(ReactApplicationContext reactApplicationContext, OverrideColorScheme overrideColorScheme) {
        super(reactApplicationContext);
        this.mColorScheme = "light";
        this.mOverrideColorScheme = overrideColorScheme;
        this.mColorScheme = colorSchemeForCurrentConfiguration(reactApplicationContext);
    }
}
