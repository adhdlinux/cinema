package com.facebook.react.modules.debug;

import com.facebook.fbreact.specs.NativeDevSettingsSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;

@ReactModule(name = "DevSettings")
public class DevSettingsModule extends NativeDevSettingsSpec {
    public static final String NAME = "DevSettings";
    /* access modifiers changed from: private */
    public final DevSupportManager mDevSupportManager;

    public DevSettingsModule(ReactApplicationContext reactApplicationContext, DevSupportManager devSupportManager) {
        super(reactApplicationContext);
        this.mDevSupportManager = devSupportManager;
    }

    public void addListener(String str) {
    }

    public void addMenuItem(final String str) {
        this.mDevSupportManager.addCustomDevOption(str, new DevOptionHandler() {
            public void onOptionSelected() {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("title", str);
                ReactApplicationContext access$100 = DevSettingsModule.this.getReactApplicationContextIfActiveOrWarn();
                if (access$100 != null) {
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) access$100.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("didPressMenuItem", createMap);
                }
            }
        });
    }

    public String getName() {
        return NAME;
    }

    public void onFastRefresh() {
    }

    public void reload() {
        if (this.mDevSupportManager.getDevSupportEnabled()) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    DevSettingsModule.this.mDevSupportManager.handleReloadJS();
                }
            });
        }
    }

    public void reloadWithReason(String str) {
        reload();
    }

    public void removeListeners(double d2) {
    }

    public void setHotLoadingEnabled(boolean z2) {
        this.mDevSupportManager.setHotModuleReplacementEnabled(z2);
    }

    public void setIsDebuggingRemotely(boolean z2) {
        this.mDevSupportManager.setRemoteJSDebugEnabled(z2);
    }

    public void setIsShakeToShowDevMenuEnabled(boolean z2) {
    }

    public void setProfilingEnabled(boolean z2) {
        this.mDevSupportManager.setFpsDebugEnabled(z2);
    }

    public void toggleElementInspector() {
        this.mDevSupportManager.toggleElementInspector();
    }
}
