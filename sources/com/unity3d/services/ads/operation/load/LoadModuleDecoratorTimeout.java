package com.unity3d.services.ads.operation.load;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.request.metrics.AdOperationError;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import com.unity3d.services.core.timer.BaseTimer;
import com.unity3d.services.core.timer.ITimerListener;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import java.util.concurrent.Executors;

public class LoadModuleDecoratorTimeout extends LoadModuleDecorator {
    private static final String errorMsgTimeoutLoading = "[UnityAds] Timeout while loading ";

    public LoadModuleDecoratorTimeout(ILoadModule iLoadModule, ConfigurationReader configurationReader) {
        super(iLoadModule);
    }

    /* access modifiers changed from: private */
    public void onOperationTimeout(LoadOperationState loadOperationState) {
        if (loadOperationState != null) {
            getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdLoadFailure(AdOperationError.timeout, Long.valueOf(loadOperationState.duration()), loadOperationState.isBanner()));
            remove(loadOperationState.id);
            UnityAds.UnityAdsLoadError unityAdsLoadError = UnityAds.UnityAdsLoadError.TIMEOUT;
            loadOperationState.onUnityAdsFailedToLoad(unityAdsLoadError, errorMsgTimeoutLoading + loadOperationState.placementId);
        }
    }

    private void releaseOperationTimeoutLock(String str) {
        LoadOperationState loadOperationState;
        BaseTimer baseTimer;
        ILoadOperation iLoadOperation = get(str);
        if (iLoadOperation != null && (loadOperationState = iLoadOperation.getLoadOperationState()) != null && (baseTimer = loadOperationState.timeoutTimer) != null) {
            baseTimer.kill();
        }
    }

    private void startLoadTimeout(final LoadOperationState loadOperationState) {
        if (loadOperationState != null) {
            BaseTimer baseTimer = new BaseTimer(Integer.valueOf(loadOperationState.configuration.getLoadTimeout()), new ITimerListener() {
                public void onTimerFinished() {
                    LoadModuleDecoratorTimeout.this.onOperationTimeout(loadOperationState);
                }
            });
            loadOperationState.timeoutTimer = baseTimer;
            baseTimer.start(Executors.newSingleThreadScheduledExecutor());
        }
    }

    public void onUnityAdsAdLoaded(String str) {
        releaseOperationTimeoutLock(str);
        super.onUnityAdsAdLoaded(str);
    }

    public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
        releaseOperationTimeoutLock(str);
        super.onUnityAdsFailedToLoad(str, unityAdsLoadError, str2);
    }

    public void executeAdOperation(IWebViewBridgeInvoker iWebViewBridgeInvoker, LoadOperationState loadOperationState) {
        getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdLoadStart());
        loadOperationState.start();
        startLoadTimeout(loadOperationState);
        super.executeAdOperation(iWebViewBridgeInvoker, loadOperationState);
    }
}
