package com.vungle.ads.internal.load;

import android.content.Context;
import com.vungle.ads.AdMarkupInvalidError;
import com.vungle.ads.InvalidBidPayloadError;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.BidPayload;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMInjector;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

public final class RealtimeAdLoader extends BaseAdLoader {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealtimeAdLoader(Context context, VungleApiClient vungleApiClient, Executors executors, OMInjector oMInjector, Downloader downloader, PathProvider pathProvider, AdRequest adRequest) {
        super(context, vungleApiClient, executors, oMInjector, downloader, pathProvider, adRequest);
        Intrinsics.f(context, "context");
        Intrinsics.f(vungleApiClient, "vungleApiClient");
        Intrinsics.f(executors, "sdkExecutors");
        Intrinsics.f(oMInjector, "omInjector");
        Intrinsics.f(downloader, "downloader");
        Intrinsics.f(pathProvider, "pathProvider");
        Intrinsics.f(adRequest, "adRequest");
    }

    /* renamed from: requestAd$lambda-0  reason: not valid java name */
    private static final VungleApiClient m187requestAd$lambda0(Lazy<VungleApiClient> lazy) {
        return lazy.getValue();
    }

    private final void sendWinNotification(List<String> list) {
        boolean z2 = false;
        if (list != null && list.isEmpty()) {
            z2 = true;
        }
        if (!z2) {
            ServiceLocator.Companion companion = ServiceLocator.Companion;
            TpatSender tpatSender = new TpatSender(getVungleApiClient(), getLogEntry$vungle_ads_release(), getSdkExecutors().getIoExecutor(), getPathProvider(), m188sendWinNotification$lambda2(LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new RealtimeAdLoader$sendWinNotification$$inlined$inject$1(getContext()))));
            if (list != null) {
                for (String sendWinNotification : list) {
                    tpatSender.sendWinNotification(sendWinNotification, getSdkExecutors().getJobExecutor());
                }
            }
        }
    }

    /* renamed from: sendWinNotification$lambda-2  reason: not valid java name */
    private static final SignalManager m188sendWinNotification$lambda2(Lazy<SignalManager> lazy) {
        return lazy.getValue();
    }

    public void onAdLoadReady() {
        AdPayload advertisement$vungle_ads_release = getAdvertisement$vungle_ads_release();
        sendWinNotification(advertisement$vungle_ads_release != null ? advertisement$vungle_ads_release.getWinNotifications() : null);
    }

    /* access modifiers changed from: protected */
    public void requestAd() {
        BidPayload adMarkup = getAdRequest().getAdMarkup();
        if (adMarkup == null) {
            onAdLoadFailed(new InvalidBidPayloadError().setLogEntry$vungle_ads_release(getLogEntry$vungle_ads_release()).logError$vungle_ads_release());
            return;
        }
        if (ConfigManager.INSTANCE.rtaDebuggingEnabled()) {
            try {
                String decodedAdsResponse = adMarkup.getDecodedAdsResponse();
                Logger.Companion.d("RTA_DEBUGGER", String.valueOf(decodedAdsResponse));
                ServiceLocator.Companion companion = ServiceLocator.Companion;
                Lazy a2 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new RealtimeAdLoader$requestAd$$inlined$inject$1(getContext()));
                if (decodedAdsResponse != null) {
                    new RTADebugger(m187requestAd$lambda0(a2)).reportAdMarkup(decodedAdsResponse);
                }
            } catch (Throwable unused) {
            }
        }
        AdPayload adPayload = adMarkup.getAdPayload();
        Integer version = adMarkup.getVersion();
        if (version == null || version.intValue() != 2 || adPayload == null) {
            onAdLoadFailed(new AdMarkupInvalidError("The ad response did not contain valid ad markup").setLogEntry$vungle_ads_release(getLogEntry$vungle_ads_release()).logError$vungle_ads_release());
        } else {
            handleAdMetaData$vungle_ads_release(adPayload, new SingleValueMetric(Sdk$SDKMetric.SDKMetricType.CONFIG_LOADED_FROM_ADM_LOAD));
        }
    }
}
