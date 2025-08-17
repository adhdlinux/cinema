package com.facebook.react;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.devsupport.LogBoxModule;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.bundleloader.NativeDevSplitBundleLoaderModule;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ExceptionsManagerModule;
import com.facebook.react.modules.core.HeadlessJsTaskSupportModule;
import com.facebook.react.modules.core.TimingModule;
import com.facebook.react.modules.debug.DevSettingsModule;
import com.facebook.react.modules.debug.SourceCodeModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.modules.systeminfo.AndroidInfoModule;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerResolver;
import com.facebook.systrace.Systrace;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoreModulesPackage extends TurboReactPackage implements ReactPackageLogger {
    private final DefaultHardwareBackBtnHandler mHardwareBackBtnHandler;
    private final boolean mLazyViewManagersEnabled;
    private final int mMinTimeLeftInFrameForNonBatchedOperationMs;
    /* access modifiers changed from: private */
    public final ReactInstanceManager mReactInstanceManager;

    public CoreModulesPackage(ReactInstanceManager reactInstanceManager, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler, UIImplementationProvider uIImplementationProvider, boolean z2, int i2) {
        this.mReactInstanceManager = reactInstanceManager;
        this.mHardwareBackBtnHandler = defaultHardwareBackBtnHandler;
        this.mLazyViewManagersEnabled = z2;
        this.mMinTimeLeftInFrameForNonBatchedOperationMs = i2;
    }

    private UIManagerModule createUIManager(ReactApplicationContext reactApplicationContext) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_START);
        Systrace.beginSection(0, "createUIManagerModule");
        try {
            if (this.mLazyViewManagersEnabled) {
                return new UIManagerModule(reactApplicationContext, (ViewManagerResolver) new ViewManagerResolver() {
                    public ViewManager getViewManager(String str) {
                        return CoreModulesPackage.this.mReactInstanceManager.createViewManager(str);
                    }

                    public List<String> getViewManagerNames() {
                        return CoreModulesPackage.this.mReactInstanceManager.getViewManagerNames();
                    }
                }, this.mMinTimeLeftInFrameForNonBatchedOperationMs);
            }
            UIManagerModule uIManagerModule = new UIManagerModule(reactApplicationContext, this.mReactInstanceManager.getOrCreateViewManagers(reactApplicationContext), this.mMinTimeLeftInFrameForNonBatchedOperationMs);
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END);
            return uIManagerModule;
        } finally {
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END);
        }
    }

    public void endProcessPackage() {
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_END);
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2013505529:
                if (str.equals(LogBoxModule.NAME)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1789797270:
                if (str.equals(TimingModule.NAME)) {
                    c2 = 1;
                    break;
                }
                break;
            case -1633589448:
                if (str.equals(DevSettingsModule.NAME)) {
                    c2 = 2;
                    break;
                }
                break;
            case -1520650172:
                if (str.equals(DeviceInfoModule.NAME)) {
                    c2 = 3;
                    break;
                }
                break;
            case -1037217463:
                if (str.equals(DeviceEventManagerModule.NAME)) {
                    c2 = 4;
                    break;
                }
                break;
            case -790603268:
                if (str.equals(AndroidInfoModule.NAME)) {
                    c2 = 5;
                    break;
                }
                break;
            case -508954630:
                if (str.equals(NativeDevSplitBundleLoaderModule.NAME)) {
                    c2 = 6;
                    break;
                }
                break;
            case 512434409:
                if (str.equals(ExceptionsManagerModule.NAME)) {
                    c2 = 7;
                    break;
                }
                break;
            case 881516744:
                if (str.equals(SourceCodeModule.NAME)) {
                    c2 = 8;
                    break;
                }
                break;
            case 1256514152:
                if (str.equals(HeadlessJsTaskSupportModule.NAME)) {
                    c2 = 9;
                    break;
                }
                break;
            case 1861242489:
                if (str.equals(UIManagerModule.NAME)) {
                    c2 = 10;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new LogBoxModule(reactApplicationContext, this.mReactInstanceManager.getDevSupportManager());
            case 1:
                return new TimingModule(reactApplicationContext, this.mReactInstanceManager.getDevSupportManager());
            case 2:
                return new DevSettingsModule(reactApplicationContext, this.mReactInstanceManager.getDevSupportManager());
            case 3:
                return new DeviceInfoModule(reactApplicationContext);
            case 4:
                return new DeviceEventManagerModule(reactApplicationContext, this.mHardwareBackBtnHandler);
            case 5:
                return new AndroidInfoModule(reactApplicationContext);
            case 6:
                return new NativeDevSplitBundleLoaderModule(reactApplicationContext, this.mReactInstanceManager.getDevSupportManager());
            case 7:
                return new ExceptionsManagerModule(this.mReactInstanceManager.getDevSupportManager());
            case 8:
                return new SourceCodeModule(reactApplicationContext);
            case 9:
                return new HeadlessJsTaskSupportModule(reactApplicationContext);
            case 10:
                return createUIManager(reactApplicationContext);
            default:
                throw new IllegalArgumentException("In CoreModulesPackage, could not find Native module for " + str);
        }
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        try {
            return (ReactModuleInfoProvider) Class.forName("com.facebook.react.CoreModulesPackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            Class[] clsArr = {AndroidInfoModule.class, DeviceEventManagerModule.class, DeviceInfoModule.class, DevSettingsModule.class, ExceptionsManagerModule.class, LogBoxModule.class, HeadlessJsTaskSupportModule.class, SourceCodeModule.class, TimingModule.class, UIManagerModule.class, NativeDevSplitBundleLoaderModule.class};
            final HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < 11; i2++) {
                Class cls = clsArr[i2];
                ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
                hashMap.put(reactModule.name(), new ReactModuleInfo(reactModule.name(), cls.getName(), reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.hasConstants(), reactModule.isCxxModule(), TurboModule.class.isAssignableFrom(cls)));
            }
            return new ReactModuleInfoProvider() {
                public Map<String, ReactModuleInfo> getReactModuleInfos() {
                    return hashMap;
                }
            };
        } catch (InstantiationException e2) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e3);
        }
    }

    public void startProcessPackage() {
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_START);
    }
}
