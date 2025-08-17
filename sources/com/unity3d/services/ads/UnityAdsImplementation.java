package com.unity3d.services.ads;

import android.app.Activity;
import android.content.Context;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.services.UnityServices;
import com.unity3d.services.ads.gmascar.managers.BiddingBaseManager;
import com.unity3d.services.ads.gmascar.managers.BiddingManagerFactory;
import com.unity3d.services.ads.operation.load.LoadModule;
import com.unity3d.services.ads.operation.load.LoadOperationState;
import com.unity3d.services.ads.operation.show.ShowModule;
import com.unity3d.services.ads.operation.show.ShowOperationState;
import com.unity3d.services.ads.token.AsyncTokenStorage;
import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.bridge.WebViewBridgeInvoker;
import j1.a;

public final class UnityAdsImplementation implements IUnityAds {
    private static Configuration configuration;
    private static IUnityAds instance;
    private static WebViewBridgeInvoker webViewBridgeInvoker = new WebViewBridgeInvoker();
    private final AsyncTokenStorage asyncTokenStorage = ((AsyncTokenStorage) Utilities.getService(AsyncTokenStorage.class));
    private final SDKMetricsSender sdkMetricsSender = ((SDKMetricsSender) Utilities.getService(SDKMetricsSender.class));
    private final TokenStorage tokenStorage = ((TokenStorage) Utilities.getService(TokenStorage.class));

    public static IUnityAds getInstance() {
        if (instance == null) {
            instance = new UnityAdsImplementation();
        }
        return instance;
    }

    private void handleShowError(IUnityAdsShowListener iUnityAdsShowListener, String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
        this.sdkMetricsSender.sendMetricWithInitState(AdOperationMetric.newAdShowFailure(unityAdsShowError, (Long) 0L));
        if (iUnityAdsShowListener != null) {
            iUnityAdsShowListener.onUnityAdsShowFailure(str, unityAdsShowError, str2);
        }
    }

    public static void setConfiguration(Configuration configuration2) {
        configuration = configuration2;
    }

    public boolean getDebugMode() {
        return UnityServices.getDebugMode();
    }

    public String getToken() {
        String token = this.tokenStorage.getToken();
        if (token == null || token.isEmpty()) {
            return null;
        }
        Configuration configuration2 = configuration;
        if (configuration2 == null) {
            configuration2 = new ConfigurationReader().getCurrentConfiguration();
        }
        BiddingBaseManager createManager = BiddingManagerFactory.getInstance().createManager((IUnityAdsTokenListener) null, configuration2.getExperiments());
        createManager.start();
        return createManager.getFormattedToken(token);
    }

    public String getVersion() {
        return UnityServices.getVersion();
    }

    public void initialize(Context context, String str, boolean z2, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        DeviceLog.entered();
        UnityServices.initialize(context, str, z2, iUnityAdsInitializationListener);
    }

    public boolean isInitialized() {
        return UnityServices.isInitialized();
    }

    public boolean isSupported() {
        return UnityServices.isSupported();
    }

    public void load(String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener) {
        Configuration configuration2 = configuration;
        if (configuration2 == null) {
            configuration2 = new Configuration();
        }
        LoadModule.getInstance().executeAdOperation(webViewBridgeInvoker, new LoadOperationState(str, iUnityAdsLoadListener, unityAdsLoadOptions, configuration2));
    }

    public void setDebugMode(boolean z2) {
        UnityServices.setDebugMode(z2);
    }

    public void show(Activity activity, String str) {
        show(activity, str, new UnityAdsShowOptions(), (IUnityAdsShowListener) null);
    }

    public void show(Activity activity, String str, IUnityAdsShowListener iUnityAdsShowListener) {
        show(activity, str, new UnityAdsShowOptions(), iUnityAdsShowListener);
    }

    public void show(Activity activity, String str, UnityAdsShowOptions unityAdsShowOptions, IUnityAdsShowListener iUnityAdsShowListener) {
        if (!isSupported()) {
            handleShowError(iUnityAdsShowListener, str, UnityAds.UnityAdsShowError.NOT_INITIALIZED, "Unity Ads is not supported for this device");
        } else if (!isInitialized()) {
            handleShowError(iUnityAdsShowListener, str, UnityAds.UnityAdsShowError.NOT_INITIALIZED, "Unity Ads is not initialized");
        } else if (activity == null) {
            handleShowError(iUnityAdsShowListener, str, UnityAds.UnityAdsShowError.INVALID_ARGUMENT, "Activity must not be null");
        } else {
            Configuration configuration2 = configuration;
            if (configuration2 == null) {
                configuration2 = new Configuration();
            }
            ClientProperties.setActivity(activity);
            ShowModule.getInstance().executeAdOperation(WebViewApp.getCurrentApp(), new ShowOperationState(str, iUnityAdsShowListener, activity, unityAdsShowOptions, configuration2));
        }
    }

    public void getToken(IUnityAdsTokenListener iUnityAdsTokenListener) {
        if (iUnityAdsTokenListener == null) {
            DeviceLog.info("Please provide non-null listener to UnityAds.GetToken method");
        } else if (ClientProperties.getApplicationContext() == null) {
            Utilities.wrapCustomerListener(new a(iUnityAdsTokenListener));
        } else {
            Configuration configuration2 = configuration;
            if (configuration2 == null) {
                configuration2 = new ConfigurationReader().getCurrentConfiguration();
            }
            BiddingBaseManager createManager = BiddingManagerFactory.getInstance().createManager(iUnityAdsTokenListener, configuration2.getExperiments());
            createManager.start();
            this.asyncTokenStorage.getToken(createManager);
        }
    }
}
