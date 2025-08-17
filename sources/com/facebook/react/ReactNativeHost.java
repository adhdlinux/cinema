package com.facebook.react;

import android.app.Application;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.devsupport.DevSupportManagerFactory;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.uimanager.UIImplementationProvider;
import java.util.List;

public abstract class ReactNativeHost {
    private final Application mApplication;
    private ReactInstanceManager mReactInstanceManager;

    protected ReactNativeHost(Application application) {
        this.mApplication = application;
    }

    public void clear() {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager != null) {
            reactInstanceManager.destroy();
            this.mReactInstanceManager = null;
        }
    }

    /* access modifiers changed from: protected */
    public ReactInstanceManager createReactInstanceManager() {
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_START);
        ReactInstanceManagerBuilder reactPackageTurboModuleManagerDelegateBuilder = ReactInstanceManager.builder().setApplication(this.mApplication).setJSMainModulePath(getJSMainModuleName()).setUseDeveloperSupport(getUseDeveloperSupport()).setDevSupportManagerFactory(getDevSupportManagerFactory()).setRequireActivity(getShouldRequireActivity()).setSurfaceDelegateFactory(getSurfaceDelegateFactory()).setRedBoxHandler(getRedBoxHandler()).setJavaScriptExecutorFactory(getJavaScriptExecutorFactory()).setUIImplementationProvider(getUIImplementationProvider()).setJSIModulesPackage(getJSIModulePackage()).setInitialLifecycleState(LifecycleState.BEFORE_CREATE).setReactPackageTurboModuleManagerDelegateBuilder(getReactPackageTurboModuleManagerDelegateBuilder());
        for (ReactPackage addPackage : getPackages()) {
            reactPackageTurboModuleManagerDelegateBuilder.addPackage(addPackage);
        }
        String jSBundleFile = getJSBundleFile();
        if (jSBundleFile != null) {
            reactPackageTurboModuleManagerDelegateBuilder.setJSBundleFile(jSBundleFile);
        } else {
            reactPackageTurboModuleManagerDelegateBuilder.setBundleAssetName((String) Assertions.assertNotNull(getBundleAssetName()));
        }
        ReactInstanceManager build = reactPackageTurboModuleManagerDelegateBuilder.build();
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_END);
        return build;
    }

    /* access modifiers changed from: protected */
    public final Application getApplication() {
        return this.mApplication;
    }

    /* access modifiers changed from: protected */
    public String getBundleAssetName() {
        return "index.android.bundle";
    }

    /* access modifiers changed from: protected */
    public DevSupportManagerFactory getDevSupportManagerFactory() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getJSBundleFile() {
        return null;
    }

    /* access modifiers changed from: protected */
    public JSIModulePackage getJSIModulePackage() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getJSMainModuleName() {
        return "index.android";
    }

    /* access modifiers changed from: protected */
    public JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract List<ReactPackage> getPackages();

    public ReactInstanceManager getReactInstanceManager() {
        if (this.mReactInstanceManager == null) {
            ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_START);
            this.mReactInstanceManager = createReactInstanceManager();
            ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_END);
        }
        return this.mReactInstanceManager;
    }

    /* access modifiers changed from: protected */
    public ReactPackageTurboModuleManagerDelegate.Builder getReactPackageTurboModuleManagerDelegateBuilder() {
        return null;
    }

    /* access modifiers changed from: protected */
    public RedBoxHandler getRedBoxHandler() {
        return null;
    }

    public boolean getShouldRequireActivity() {
        return true;
    }

    public SurfaceDelegateFactory getSurfaceDelegateFactory() {
        return new SurfaceDelegateFactory() {
            public SurfaceDelegate createSurfaceDelegate(String str) {
                return null;
            }
        };
    }

    /* access modifiers changed from: protected */
    public UIImplementationProvider getUIImplementationProvider() {
        return new UIImplementationProvider();
    }

    public abstract boolean getUseDeveloperSupport();

    public boolean hasInstance() {
        return this.mReactInstanceManager != null;
    }
}
