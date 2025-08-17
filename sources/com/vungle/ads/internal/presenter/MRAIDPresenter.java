package com.vungle.ads.internal.presenter;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import com.facebook.react.uimanager.ViewProps;
import com.vungle.ads.AdConfig;
import com.vungle.ads.AdNotLoadedCantPlay;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.IndexHtmlError;
import com.vungle.ads.NetworkUnreachable;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.VungleError;
import com.vungle.ads.WebViewError;
import com.vungle.ads.WebViewRenderProcessUnresponsive;
import com.vungle.ads.WebViewRenderingProcessGone;
import com.vungle.ads.internal.ClickCoordinateTracker;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.BidPayload;
import com.vungle.ads.internal.model.CommonRequestBody;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.network.Call;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMTracker;
import com.vungle.ads.internal.omsdk.WebViewObserver;
import com.vungle.ads.internal.platform.Platform;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.ui.VungleWebClient;
import com.vungle.ads.internal.ui.view.MRAIDAdWidget;
import com.vungle.ads.internal.ui.view.WebViewAPI;
import com.vungle.ads.internal.util.HandlerScheduler;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import com.vungle.ads.internal.util.SuspendableTimer;
import com.vungle.ads.internal.util.ThreadUtil;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class MRAIDPresenter implements WebViewAPI.MraidDelegate, WebViewAPI.WebClientErrorHandler {
    private static final String ACTION = "action";
    public static final String ACTION_WITH_VALUE = "actionWithValue";
    public static final String CLOSE = "close";
    public static final String CONSENT_ACTION = "consentAction";
    public static final String CREATIVE_HEARTBEAT = "creativeHeartbeat";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ERROR = "error";
    public static final String GET_AVAILABLE_DISK_SPACE = "getAvailableDiskSpace";
    private static final double HEARTBEAT_INTERVAL = 6.0d;
    public static final String OPEN = "open";
    private static final String OPEN_NON_MRAID = "openNonMraid";
    public static final String OPEN_PRIVACY = "openPrivacy";
    public static final String PING_URL = "pingUrl";
    public static final String SET_ORIENTATION_PROPERTIES = "setOrientationProperties";
    public static final String SUCCESSFUL_VIEW = "successfulView";
    private static final String TAG = "MRAIDPresenter";
    public static final String TPAT = "tpat";
    public static final String UPDATE_SIGNALS = "updateSignals";
    private static final String USE_CUSTOM_CLOSE = "useCustomClose";
    private static final String USE_CUSTOM_PRIVACY = "useCustomPrivacy";
    public static final String VIDEO_LENGTH = "videoLength";
    public static final String VIDEO_VIEWED = "videoViewed";
    /* access modifiers changed from: private */
    public static final Map<String, Sdk$SDKMetric.SDKMetricType> eventMap = MapsKt__MapsKt.j(TuplesKt.a(Constants.CHECKPOINT_0, Sdk$SDKMetric.SDKMetricType.AD_START_EVENT), TuplesKt.a(Constants.CLICK_URL, Sdk$SDKMetric.SDKMetricType.AD_CLICK_EVENT));
    private Long adStartTime;
    private boolean adViewed;
    /* access modifiers changed from: private */
    public final MRAIDAdWidget adWidget;
    /* access modifiers changed from: private */
    public final AdPayload advertisement;
    private boolean backEnabled;
    private final BidPayload bidPayload;
    private AdEventListener bus;
    private final Lazy clickCoordinateTracker$delegate;
    /* access modifiers changed from: private */
    public Executor executor;
    private final Lazy executors$delegate;
    private boolean heartbeatEnabled;
    private final AtomicBoolean isDestroying = new AtomicBoolean(false);
    private long lastUserInteractionTimestamp;
    private final Lazy logEntry$delegate;
    private final OMTracker omTracker;
    private final Lazy pathProvider$delegate;
    private final Placement placement;
    private final Platform platform;
    private PresenterDelegate presenterDelegate;
    private final Lazy scheduler$delegate;
    private final AtomicBoolean sendReportIncentivized = new AtomicBoolean(false);
    private final Lazy signalManager$delegate;
    private final Lazy suspendableTimer$delegate;
    private String userId;
    private long videoLength;
    private final Lazy vungleApiClient$delegate;
    private final VungleWebClient vungleWebClient;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getACTION_WITH_VALUE$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getCLOSE$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getCONSENT_ACTION$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getCREATIVE_HEARTBEAT$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getERROR$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getEventMap$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getGET_AVAILABLE_DISK_SPACE$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getOPEN$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getOPEN_PRIVACY$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getPING_URL$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getSET_ORIENTATION_PROPERTIES$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getSUCCESSFUL_VIEW$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getTPAT$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getUPDATE_SIGNALS$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getVIDEO_LENGTH$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getVIDEO_VIEWED$vungle_ads_release$annotations() {
        }

        public final Map<String, Sdk$SDKMetric.SDKMetricType> getEventMap$vungle_ads_release() {
            return MRAIDPresenter.eventMap;
        }
    }

    public MRAIDPresenter(MRAIDAdWidget mRAIDAdWidget, AdPayload adPayload, Placement placement2, VungleWebClient vungleWebClient2, Executor executor2, OMTracker oMTracker, BidPayload bidPayload2, Platform platform2) {
        Intrinsics.f(mRAIDAdWidget, "adWidget");
        Intrinsics.f(adPayload, "advertisement");
        Intrinsics.f(placement2, "placement");
        Intrinsics.f(vungleWebClient2, "vungleWebClient");
        Intrinsics.f(executor2, "executor");
        Intrinsics.f(oMTracker, "omTracker");
        Intrinsics.f(platform2, "platform");
        this.adWidget = mRAIDAdWidget;
        this.advertisement = adPayload;
        this.placement = placement2;
        this.vungleWebClient = vungleWebClient2;
        this.executor = executor2;
        this.omTracker = oMTracker;
        this.bidPayload = bidPayload2;
        this.platform = platform2;
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        Context context = mRAIDAdWidget.getContext();
        Intrinsics.e(context, "adWidget.context");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        this.vungleApiClient$delegate = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new MRAIDPresenter$special$$inlined$inject$1(context));
        Context context2 = mRAIDAdWidget.getContext();
        Intrinsics.e(context2, "adWidget.context");
        this.executors$delegate = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new MRAIDPresenter$special$$inlined$inject$2(context2));
        Context context3 = mRAIDAdWidget.getContext();
        Intrinsics.e(context3, "adWidget.context");
        this.pathProvider$delegate = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new MRAIDPresenter$special$$inlined$inject$3(context3));
        Context context4 = mRAIDAdWidget.getContext();
        Intrinsics.e(context4, "adWidget.context");
        this.signalManager$delegate = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new MRAIDPresenter$special$$inlined$inject$4(context4));
        this.scheduler$delegate = LazyKt__LazyJVMKt.b(MRAIDPresenter$scheduler$2.INSTANCE);
        this.logEntry$delegate = LazyKt__LazyJVMKt.b(new MRAIDPresenter$logEntry$2(this));
        this.suspendableTimer$delegate = LazyKt__LazyJVMKt.b(new MRAIDPresenter$suspendableTimer$2(this));
        this.clickCoordinateTracker$delegate = LazyKt__LazyJVMKt.b(new MRAIDPresenter$clickCoordinateTracker$2(this));
    }

    private final void closeView() {
        Long l2 = this.adStartTime;
        if (l2 != null) {
            long longValue = l2.longValue();
            TpatSender tpatSender = new TpatSender(getVungleApiClient$vungle_ads_release(), getLogEntry(), getExecutors().getIoExecutor(), getPathProvider(), getSignalManager());
            List<String> tpatUrls = this.advertisement.getTpatUrls(Constants.AD_CLOSE, String.valueOf(System.currentTimeMillis() - longValue), String.valueOf(this.platform.getVolumeLevel()));
            if (tpatUrls != null) {
                tpatSender.sendTpats(tpatUrls, this.executor);
            }
        }
        ThreadUtil.INSTANCE.runOnUiThread(new g(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: closeView$lambda-3  reason: not valid java name */
    public static final void m197closeView$lambda3(MRAIDPresenter mRAIDPresenter) {
        Intrinsics.f(mRAIDPresenter, "this$0");
        mRAIDPresenter.adWidget.close();
    }

    public static /* synthetic */ void getAdStartTime$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getBackEnabled$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getBus$annotations() {
    }

    public static /* synthetic */ void getClickCoordinateTracker$vungle_ads_release$annotations() {
    }

    /* access modifiers changed from: private */
    public final Executors getExecutors() {
        return (Executors) this.executors$delegate.getValue();
    }

    public static /* synthetic */ void getHeartbeatEnabled$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getLastUserInteractionTimestamp$vungle_ads_release$annotations() {
    }

    /* access modifiers changed from: private */
    public final LogEntry getLogEntry() {
        return (LogEntry) this.logEntry$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PathProvider getPathProvider() {
        return (PathProvider) this.pathProvider$delegate.getValue();
    }

    private final HandlerScheduler getScheduler() {
        return (HandlerScheduler) this.scheduler$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SignalManager getSignalManager() {
        return (SignalManager) this.signalManager$delegate.getValue();
    }

    public static /* synthetic */ void getSuspendableTimer$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getUserId$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getVideoLength$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getVungleApiClient$vungle_ads_release$annotations() {
    }

    private final void handleWebViewException(VungleError vungleError, boolean z2, String str) {
        Logger.Companion companion = Logger.Companion;
        companion.e(TAG, "handleWebViewException: " + vungleError.getLocalizedMessage() + ", fatal: " + z2 + ", errorMsg: " + str);
        if (z2) {
            makeBusError(vungleError);
            closeView();
        }
    }

    static /* synthetic */ void handleWebViewException$default(MRAIDPresenter mRAIDPresenter, VungleError vungleError, boolean z2, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = null;
        }
        mRAIDPresenter.handleWebViewException(vungleError, z2, str);
    }

    public static /* synthetic */ void isDestroying$vungle_ads_release$annotations() {
    }

    private final boolean loadMraidAd(File file) {
        File file2 = new File(file.getPath(), Constants.AD_INDEX_FILE_NAME);
        if (!file2.exists()) {
            Sdk$SDKError.Reason reason = Sdk$SDKError.Reason.AD_HTML_FAILED_TO_LOAD;
            new IndexHtmlError(reason, "Fail to load html " + file2.getPath()).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
            return false;
        }
        MRAIDAdWidget mRAIDAdWidget = this.adWidget;
        mRAIDAdWidget.showWebsite(AdPayload.FILE_SCHEME + file2.getPath());
        return true;
    }

    private final void makeBusError(VungleError vungleError) {
        AdEventListener adEventListener = this.bus;
        if (adEventListener != null) {
            adEventListener.onError(vungleError, this.placement.getReferenceId());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: prepare$lambda-16  reason: not valid java name */
    public static final void m198prepare$lambda16(MRAIDPresenter mRAIDPresenter) {
        Intrinsics.f(mRAIDPresenter, "this$0");
        mRAIDPresenter.backEnabled = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: processCommand$lambda-11  reason: not valid java name */
    public static final void m199processCommand$lambda11(MRAIDPresenter mRAIDPresenter) {
        Intrinsics.f(mRAIDPresenter, "this$0");
        String referenceId = mRAIDPresenter.placement.getReferenceId();
        Call<Void> ri = mRAIDPresenter.getVungleApiClient$vungle_ads_release().ri(new CommonRequestBody.RequestParam((List) null, (CommonRequestBody.AdSizeParam) null, mRAIDPresenter.adStartTime, mRAIDPresenter.advertisement.advAppId(), referenceId, mRAIDPresenter.userId, 3, (DefaultConstructorMarker) null));
        if (ri == null) {
            Logger.Companion.e(TAG, "Invalid ri call.");
            new NetworkUnreachable("Error RI API for placement: " + mRAIDPresenter.placement.getReferenceId()).setLogEntry$vungle_ads_release(mRAIDPresenter.getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
            return;
        }
        ri.enqueue(new MRAIDPresenter$processCommand$7$1(mRAIDPresenter));
    }

    /* access modifiers changed from: private */
    /* renamed from: processCommand$lambda-12  reason: not valid java name */
    public static final void m200processCommand$lambda12(MRAIDPresenter mRAIDPresenter, VungleError vungleError, boolean z2, String str) {
        Intrinsics.f(mRAIDPresenter, "this$0");
        Intrinsics.f(vungleError, "$exception");
        Intrinsics.f(str, "$message");
        mRAIDPresenter.handleWebViewException(vungleError, z2, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: processCommand$lambda-13  reason: not valid java name */
    public static final void m201processCommand$lambda13(MRAIDPresenter mRAIDPresenter) {
        Intrinsics.f(mRAIDPresenter, "this$0");
        mRAIDPresenter.getSuspendableTimer$vungle_ads_release().reset();
    }

    /* access modifiers changed from: private */
    /* renamed from: processCommand$lambda-14  reason: not valid java name */
    public static final void m202processCommand$lambda14(MRAIDPresenter mRAIDPresenter, long j2) {
        Intrinsics.f(mRAIDPresenter, "this$0");
        mRAIDPresenter.vungleWebClient.notifyDiskAvailableSize(j2);
    }

    /* access modifiers changed from: private */
    /* renamed from: processCommand$lambda-7  reason: not valid java name */
    public static final void m203processCommand$lambda7(MRAIDPresenter mRAIDPresenter) {
        Intrinsics.f(mRAIDPresenter, "this$0");
        mRAIDPresenter.adWidget.setVisibility(0);
    }

    private final void recordPlayAssetMetric() {
        Sdk$SDKMetric.SDKMetricType sDKMetricType;
        if (this.advertisement.getAssetsFullyDownloaded()) {
            sDKMetricType = Sdk$SDKMetric.SDKMetricType.LOCAL_ASSETS_USED;
        } else {
            sDKMetricType = Sdk$SDKMetric.SDKMetricType.REMOTE_ASSETS_USED;
        }
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new SingleValueMetric(sDKMetricType), getLogEntry(), (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void reportErrorAndCloseAd(VungleError vungleError) {
        makeBusError(vungleError);
        closeView();
    }

    private final void triggerEventMetricForTpat(String str) {
        Sdk$SDKMetric.SDKMetricType sDKMetricType = eventMap.get(str);
        if (sDKMetricType != null) {
            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new SingleValueMetric(sDKMetricType), getLogEntry(), (String) null, 4, (Object) null);
        }
    }

    public final void detach(int i2) {
        boolean z2;
        AdEventListener adEventListener;
        Logger.Companion.d(TAG, "detach()");
        boolean z3 = false;
        if ((i2 & 1) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((i2 & 2) != 0) {
            z3 = true;
        }
        this.vungleWebClient.setWebViewObserver((WebViewObserver) null);
        this.vungleWebClient.setMraidDelegate((WebViewAPI.MraidDelegate) null);
        if (!z2 && z3 && !this.isDestroying.getAndSet(true) && (adEventListener = this.bus) != null) {
            adEventListener.onNext(ViewProps.END, (String) null, this.placement.getReferenceId());
        }
        this.adWidget.destroyWebView(this.omTracker.stop());
        if (this.heartbeatEnabled) {
            getSuspendableTimer$vungle_ads_release().cancel();
        }
    }

    public final Long getAdStartTime$vungle_ads_release() {
        return this.adStartTime;
    }

    public final boolean getBackEnabled$vungle_ads_release() {
        return this.backEnabled;
    }

    public final AdEventListener getBus() {
        return this.bus;
    }

    public final ClickCoordinateTracker getClickCoordinateTracker$vungle_ads_release() {
        return (ClickCoordinateTracker) this.clickCoordinateTracker$delegate.getValue();
    }

    public final boolean getHeartbeatEnabled$vungle_ads_release() {
        return this.heartbeatEnabled;
    }

    public final long getLastUserInteractionTimestamp$vungle_ads_release() {
        return this.lastUserInteractionTimestamp;
    }

    public final SuspendableTimer getSuspendableTimer$vungle_ads_release() {
        return (SuspendableTimer) this.suspendableTimer$delegate.getValue();
    }

    public final String getUserId$vungle_ads_release() {
        return this.userId;
    }

    public final long getVideoLength$vungle_ads_release() {
        return this.videoLength;
    }

    public final VungleApiClient getVungleApiClient$vungle_ads_release() {
        return (VungleApiClient) this.vungleApiClient$delegate.getValue();
    }

    public final void handleExit() {
        if (this.backEnabled) {
            this.adWidget.showWebsite("javascript:window.vungle.mraidBridgeExt.requestMRAIDClose()");
        }
    }

    public final AtomicBoolean isDestroying$vungle_ads_release() {
        return this.isDestroying;
    }

    public void onReceivedError(String str, boolean z2) {
        Intrinsics.f(str, "errorDesc");
        if (z2) {
            reportErrorAndCloseAd(new WebViewError(str).setLogEntry$vungle_ads_release(getLogEntry()).logError$vungle_ads_release());
        }
    }

    public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        handleWebViewException$default(this, new WebViewRenderProcessUnresponsive("fatal=true"), true, (String) null, 4, (Object) null);
    }

    public final void onViewConfigurationChanged() {
        this.vungleWebClient.notifyPropertiesChange(true);
    }

    public final void onViewTouched(MotionEvent motionEvent) {
        if (motionEvent != null) {
            Logger.Companion.d(TAG, "user interaction");
            this.lastUserInteractionTimestamp = System.currentTimeMillis();
            getClickCoordinateTracker$vungle_ads_release().trackCoordinate(motionEvent);
        }
    }

    public boolean onWebRenderingProcessGone(WebView webView, Boolean bool) {
        boolean z2;
        if (bool != null) {
            z2 = bool.booleanValue();
        } else {
            z2 = true;
        }
        handleWebViewException$default(this, new WebViewRenderingProcessGone("didCrash=" + z2), z2, (String) null, 4, (Object) null);
        return true;
    }

    public final void prepare() {
        Integer num;
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int settings;
        boolean z2;
        boolean z3 = false;
        this.isDestroying.set(false);
        this.adWidget.linkWebView(this.vungleWebClient);
        AdConfig adConfig = this.advertisement.getAdConfig();
        if (adConfig != null && (settings = adConfig.getSettings()) > 0) {
            if ((settings & 2) == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.backEnabled = z2;
        }
        this.heartbeatEnabled = this.advertisement.heartbeatEnabled();
        AdConfig adConfig2 = this.advertisement.getAdConfig();
        if (adConfig2 != null) {
            num = Integer.valueOf(adConfig2.getAdOrientation());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            i2 = 7;
        } else if (num != null && num.intValue() == 1) {
            i2 = 6;
        } else {
            i2 = 4;
        }
        this.adWidget.setOrientation(i2);
        this.omTracker.start();
        this.vungleWebClient.setMraidDelegate(this);
        this.vungleWebClient.setErrorHandler(this);
        File assetDirectory = this.advertisement.getAssetDirectory();
        if (assetDirectory == null || !assetDirectory.exists()) {
            reportErrorAndCloseAd(new AdNotLoadedCantPlay("adv dir not exists.").setLogEntry$vungle_ads_release(getLogEntry()).logError$vungle_ads_release());
        } else if (!loadMraidAd(assetDirectory)) {
            reportErrorAndCloseAd(new AdNotLoadedCantPlay("ad index html not exists.").setLogEntry$vungle_ads_release(getLogEntry()).logError$vungle_ads_release());
        } else {
            this.adStartTime = Long.valueOf(System.currentTimeMillis());
            PresenterDelegate presenterDelegate2 = this.presenterDelegate;
            if (presenterDelegate2 != null) {
                str = presenterDelegate2.getUserId();
            } else {
                str = null;
            }
            this.userId = str;
            PresenterDelegate presenterDelegate3 = this.presenterDelegate;
            if (presenterDelegate3 == null || (str2 = presenterDelegate3.getAlertTitleText()) == null) {
                str2 = "";
            }
            PresenterDelegate presenterDelegate4 = this.presenterDelegate;
            if (presenterDelegate4 == null || (str3 = presenterDelegate4.getAlertBodyText()) == null) {
                str3 = "";
            }
            PresenterDelegate presenterDelegate5 = this.presenterDelegate;
            if (presenterDelegate5 == null || (str4 = presenterDelegate5.getAlertContinueButtonText()) == null) {
                str4 = "";
            }
            PresenterDelegate presenterDelegate6 = this.presenterDelegate;
            if (presenterDelegate6 == null || (str5 = presenterDelegate6.getAlertCloseButtonText()) == null) {
                str5 = "";
            }
            this.advertisement.setIncentivizedText(str2, str3, str4, str5);
            ConfigManager configManager = ConfigManager.INSTANCE;
            if (configManager.getGDPRIsCountryDataProtected() && Intrinsics.a("unknown", PrivacyManager.INSTANCE.getConsentStatus())) {
                z3 = true;
            }
            this.vungleWebClient.setConsentStatus(z3, configManager.getGDPRConsentTitle(), configManager.getGDPRConsentMessage(), configManager.getGDPRButtonAccept(), configManager.getGDPRButtonDeny());
            if (z3) {
                PrivacyManager.INSTANCE.updateGdprConsent("opted_out_by_timeout", "vungle_modal", "");
            }
            int showCloseDelay = this.advertisement.getShowCloseDelay(Boolean.valueOf(this.placement.isRewardedVideo()));
            if (showCloseDelay > 0) {
                getScheduler().schedule(new a(this), (long) showCloseDelay);
            } else {
                this.backEnabled = true;
            }
            AdEventListener adEventListener = this.bus;
            if (adEventListener != null) {
                adEventListener.onNext(ViewProps.START, (String) null, this.placement.getReferenceId());
            }
            if (this.heartbeatEnabled) {
                getSuspendableTimer$vungle_ads_release().start();
            }
            if (this.advertisement.adLoadOptimizationEnabled()) {
                recordPlayAssetMetric();
            }
        }
    }

    /* JADX WARNING: type inference failed for: r18v0, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r15v3, types: [java.util.Map] */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0589, code lost:
        new com.vungle.ads.MraidJsError(com.vungle.ads.internal.protos.Sdk$SDKError.Reason.MRAID_JS_CALL_EMPTY, "Unknown MRAID Command: " + r0).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
        com.vungle.ads.internal.util.Logger.Companion.w(TAG, "processCommand# Unknown MRAID Command: " + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x05c2, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0214, code lost:
        if (r0.equals(OPEN) == false) goto L_0x0589;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0229, code lost:
        if (r0.equals(OPEN_NON_MRAID) == false) goto L_0x0589;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x022d, code lost:
        r0 = r1.advertisement.adUnit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0233, code lost:
        if (r0 == null) goto L_0x0239;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0235, code lost:
        r15 = r0.getDeeplinkUrl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0239, code lost:
        r0 = com.vungle.ads.internal.util.JsonUtil.INSTANCE.getContentStringValue(r2, com.google.android.gms.common.internal.ImagesContract.URL);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0243, code lost:
        if (shouldBlockAutoRedirect$vungle_ads_release() == false) goto L_0x0260;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0245, code lost:
        r1.lastUserInteractionTimestamp = 0;
        com.vungle.ads.AnalyticsClient.logMetric$vungle_ads_release$default(com.vungle.ads.AnalyticsClient.INSTANCE, new com.vungle.ads.SingleValueMetric(com.vungle.ads.internal.protos.Sdk$SDKMetric.SDKMetricType.BANNER_AUTO_REDIRECT), getLogEntry(), (java.lang.String) null, 4, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x025f, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0260, code lost:
        r1.lastUserInteractionTimestamp = 0;
        r2 = r1.adWidget.getContext();
        kotlin.jvm.internal.Intrinsics.e(r2, "adWidget.context");
        r0 = com.vungle.ads.internal.util.ExternalRouter.launch(r15, r0, r2, getLogEntry(), new com.vungle.ads.internal.presenter.MRAIDPresenter$processCommand$launched$1(r15, r1));
        r2 = r1.bus;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x027a, code lost:
        if (r2 == null) goto L_0x0289;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x027c, code lost:
        r2.onNext(OPEN, "adClick", r1.placement.getReferenceId());
        r2 = kotlin.Unit.f40298a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0289, code lost:
        if (r0 == false) goto L_0x029a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x028b, code lost:
        r0 = r1.bus;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x028d, code lost:
        if (r0 == null) goto L_0x029a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x028f, code lost:
        r0.onNext(OPEN, "adLeftApplication", r1.placement.getReferenceId());
        r0 = kotlin.Unit.f40298a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x029a, code lost:
        return true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x04ec  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x04fd  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean processCommand(java.lang.String r27, kotlinx.serialization.json.JsonObject r28) {
        /*
            r26 = this;
            r1 = r26
            r0 = r27
            r2 = r28
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            java.lang.String r4 = "command"
            kotlin.jvm.internal.Intrinsics.f(r0, r4)
            java.lang.String r4 = "arguments"
            kotlin.jvm.internal.Intrinsics.f(r2, r4)
            android.os.Handler r4 = new android.os.Handler
            android.os.Looper r5 = android.os.Looper.getMainLooper()
            r4.<init>(r5)
            int r5 = r27.hashCode()
            java.lang.String r6 = "adLeftApplication"
            java.lang.String r7 = "adWidget.context"
            r8 = 0
            java.lang.String r10 = "url"
            java.lang.String r11 = "event"
            java.lang.String r12 = "MRAIDPresenter"
            java.lang.String r14 = "open"
            r15 = 0
            r13 = 1
            switch(r5) {
                case -1912374177: goto L_0x054e;
                case -1422950858: goto L_0x0544;
                case -735200587: goto L_0x0477;
                case -660787472: goto L_0x0448;
                case -568000867: goto L_0x0319;
                case -511324706: goto L_0x029b;
                case -418575596: goto L_0x0223;
                case -348095344: goto L_0x0218;
                case 3417674: goto L_0x0210;
                case 3566511: goto L_0x016d;
                case 94756344: goto L_0x015f;
                case 96784904: goto L_0x0106;
                case 133423073: goto L_0x00b6;
                case 592314818: goto L_0x008c;
                case 1496446614: goto L_0x0056;
                case 1614272768: goto L_0x004b;
                case 1850430989: goto L_0x0034;
                default: goto L_0x0032;
            }
        L_0x0032:
            goto L_0x0589
        L_0x0034:
            java.lang.String r2 = "creativeHeartbeat"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x003e
            goto L_0x0589
        L_0x003e:
            boolean r0 = r1.heartbeatEnabled
            if (r0 == 0) goto L_0x004a
            com.vungle.ads.internal.presenter.e r0 = new com.vungle.ads.internal.presenter.e
            r0.<init>(r1)
            r4.post(r0)
        L_0x004a:
            return r13
        L_0x004b:
            java.lang.String r2 = "useCustomClose"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x0055
            goto L_0x0589
        L_0x0055:
            return r13
        L_0x0056:
            java.lang.String r2 = "getAvailableDiskSpace"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x0060
            goto L_0x0589
        L_0x0060:
            com.vungle.ads.internal.ui.view.MRAIDAdWidget r0 = r1.adWidget     // Catch:{ Exception -> 0x0084 }
            android.content.Context r0 = r0.getContext()     // Catch:{ Exception -> 0x0084 }
            java.io.File r0 = r0.getNoBackupFilesDir()     // Catch:{ Exception -> 0x0084 }
            com.vungle.ads.internal.util.PathProvider r2 = r26.getPathProvider()     // Catch:{ Exception -> 0x0084 }
            java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x0084 }
            java.lang.String r3 = "dir.path"
            kotlin.jvm.internal.Intrinsics.e(r0, r3)     // Catch:{ Exception -> 0x0084 }
            long r2 = r2.getAvailableBytes(r0)     // Catch:{ Exception -> 0x0084 }
            com.vungle.ads.internal.presenter.f r0 = new com.vungle.ads.internal.presenter.f     // Catch:{ Exception -> 0x0084 }
            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x0084 }
            r4.post(r0)     // Catch:{ Exception -> 0x0084 }
            goto L_0x008b
        L_0x0084:
            com.vungle.ads.internal.util.Logger$Companion r0 = com.vungle.ads.internal.util.Logger.Companion
            java.lang.String r2 = "Failed to get available disk space"
            r0.e(r12, r2)
        L_0x008b:
            return r13
        L_0x008c:
            java.lang.String r3 = "updateSignals"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L_0x0096
            goto L_0x0589
        L_0x0096:
            com.vungle.ads.internal.util.JsonUtil r0 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r3 = "signals"
            java.lang.String r0 = r0.getContentStringValue(r2, r3)
            if (r0 == 0) goto L_0x00aa
            int r2 = r0.length()
            if (r2 != 0) goto L_0x00a7
            goto L_0x00aa
        L_0x00a7:
            r16 = 0
            goto L_0x00ac
        L_0x00aa:
            r16 = 1
        L_0x00ac:
            if (r16 != 0) goto L_0x00b5
            com.vungle.ads.internal.signals.SignalManager r2 = r26.getSignalManager()
            r2.updateTemplateSignals(r0)
        L_0x00b5:
            return r13
        L_0x00b6:
            java.lang.String r3 = "setOrientationProperties"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L_0x00c0
            goto L_0x0589
        L_0x00c0:
            com.vungle.ads.internal.util.JsonUtil r0 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r3 = "forceOrientation"
            java.lang.String r0 = r0.getContentStringValue(r2, r3)
            if (r0 == 0) goto L_0x00d4
            int r2 = r0.length()
            if (r2 != 0) goto L_0x00d1
            goto L_0x00d4
        L_0x00d1:
            r16 = 0
            goto L_0x00d6
        L_0x00d4:
            r16 = 1
        L_0x00d6:
            if (r16 != 0) goto L_0x0105
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r3 = "ENGLISH"
            kotlin.jvm.internal.Intrinsics.e(r2, r3)
            java.lang.String r0 = r0.toLowerCase(r2)
            java.lang.String r2 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.e(r0, r2)
            java.lang.String r2 = "landscape"
            boolean r2 = kotlin.jvm.internal.Intrinsics.a(r0, r2)
            if (r2 == 0) goto L_0x00f7
            com.vungle.ads.internal.ui.view.MRAIDAdWidget r0 = r1.adWidget
            r2 = 6
            r0.setOrientation(r2)
            goto L_0x0105
        L_0x00f7:
            java.lang.String r2 = "portrait"
            boolean r0 = kotlin.jvm.internal.Intrinsics.a(r0, r2)
            if (r0 == 0) goto L_0x0105
            com.vungle.ads.internal.ui.view.MRAIDAdWidget r0 = r1.adWidget
            r2 = 7
            r0.setOrientation(r2)
        L_0x0105:
            return r13
        L_0x0106:
            java.lang.String r3 = "error"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L_0x0110
            goto L_0x0589
        L_0x0110:
            com.vungle.ads.internal.util.JsonUtil r0 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r3 = "code"
            java.lang.String r3 = r0.getContentStringValue(r2, r3)
            java.lang.String r4 = "fatal"
            java.lang.String r4 = r0.getContentStringValue(r2, r4)
            boolean r4 = java.lang.Boolean.parseBoolean(r4)
            java.lang.String r5 = "errorMessage"
            java.lang.String r0 = r0.getContentStringValue(r2, r5)
            if (r4 == 0) goto L_0x012d
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r2 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.AD_CLOSED_TEMPLATE_ERROR
            goto L_0x012f
        L_0x012d:
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r2 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.MRAID_ERROR
        L_0x012f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            java.lang.String r3 = " : "
            r5.append(r3)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            com.vungle.ads.MraidTemplateError r3 = new com.vungle.ads.MraidTemplateError
            r3.<init>(r2, r0)
            com.vungle.ads.internal.util.LogEntry r2 = r26.getLogEntry()
            com.vungle.ads.VungleError r2 = r3.setLogEntry$vungle_ads_release(r2)
            com.vungle.ads.VungleError r2 = r2.logError$vungle_ads_release()
            com.vungle.ads.internal.util.ThreadUtil r3 = com.vungle.ads.internal.util.ThreadUtil.INSTANCE
            com.vungle.ads.internal.presenter.d r5 = new com.vungle.ads.internal.presenter.d
            r5.<init>(r1, r2, r4, r0)
            r3.runOnUiThread(r5)
            return r13
        L_0x015f:
            java.lang.String r2 = "close"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x0169
            goto L_0x0589
        L_0x0169:
            r26.closeView()
            return r13
        L_0x016d:
            java.lang.String r3 = "tpat"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L_0x0177
            goto L_0x0589
        L_0x0177:
            com.vungle.ads.internal.util.JsonUtil r0 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r3 = r0.getContentStringValue(r2, r11)
            if (r3 == 0) goto L_0x0189
            int r0 = r3.length()
            if (r0 != 0) goto L_0x0186
            goto L_0x0189
        L_0x0186:
            r16 = 0
            goto L_0x018b
        L_0x0189:
            r16 = 1
        L_0x018b:
            if (r16 == 0) goto L_0x01a2
            com.vungle.ads.TpatError r0 = new com.vungle.ads.TpatError
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r2 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.EMPTY_TPAT_ERROR
            java.lang.String r3 = "Empty tpat key"
            r0.<init>(r2, r3)
            com.vungle.ads.internal.util.LogEntry r2 = r26.getLogEntry()
            com.vungle.ads.VungleError r0 = r0.setLogEntry$vungle_ads_release(r2)
            r0.logErrorNoReturnValue$vungle_ads_release()
            return r13
        L_0x01a2:
            r1.triggerEventMetricForTpat(r3)
            com.vungle.ads.internal.network.TpatSender r0 = new com.vungle.ads.internal.network.TpatSender
            com.vungle.ads.internal.network.VungleApiClient r5 = r26.getVungleApiClient$vungle_ads_release()
            com.vungle.ads.internal.util.LogEntry r6 = r26.getLogEntry()
            com.vungle.ads.internal.executor.Executors r2 = r26.getExecutors()
            com.vungle.ads.internal.executor.VungleThreadPoolExecutor r7 = r2.getIoExecutor()
            com.vungle.ads.internal.util.PathProvider r8 = r26.getPathProvider()
            com.vungle.ads.internal.signals.SignalManager r9 = r26.getSignalManager()
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            java.lang.String r2 = "checkpoint.0"
            boolean r2 = kotlin.jvm.internal.Intrinsics.a(r3, r2)
            if (r2 == 0) goto L_0x01e2
            com.vungle.ads.internal.model.AdPayload r2 = r1.advertisement
            com.vungle.ads.internal.platform.Platform r4 = r1.platform
            java.lang.String r4 = r4.getCarrierName()
            com.vungle.ads.internal.platform.Platform r5 = r1.platform
            float r5 = r5.getVolumeLevel()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.util.List r2 = r2.getTpatUrls(r3, r4, r5)
            goto L_0x0204
        L_0x01e2:
            java.lang.String r2 = "{{{vlen}}}"
            boolean r2 = kotlin.jvm.internal.Intrinsics.a(r3, r2)
            if (r2 == 0) goto L_0x01fa
            com.vungle.ads.internal.model.AdPayload r2 = r1.advertisement
            long r4 = r1.videoLength
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r5 = 0
            r6 = 4
            r7 = 0
            java.util.List r2 = com.vungle.ads.internal.model.AdPayload.getTpatUrls$default(r2, r3, r4, r5, r6, r7)
            goto L_0x0204
        L_0x01fa:
            com.vungle.ads.internal.model.AdPayload r2 = r1.advertisement
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            java.util.List r2 = com.vungle.ads.internal.model.AdPayload.getTpatUrls$default(r2, r3, r4, r5, r6, r7)
        L_0x0204:
            if (r2 == 0) goto L_0x020f
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.concurrent.Executor r3 = r1.executor
            r0.sendTpats(r2, r3)
            kotlin.Unit r0 = kotlin.Unit.f40298a
        L_0x020f:
            return r13
        L_0x0210:
            boolean r3 = r0.equals(r14)
            if (r3 != 0) goto L_0x022d
            goto L_0x0589
        L_0x0218:
            java.lang.String r2 = "useCustomPrivacy"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x0222
            goto L_0x0589
        L_0x0222:
            return r13
        L_0x0223:
            java.lang.String r3 = "openNonMraid"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L_0x022d
            goto L_0x0589
        L_0x022d:
            com.vungle.ads.internal.model.AdPayload r0 = r1.advertisement
            com.vungle.ads.internal.model.AdPayload$AdUnit r0 = r0.adUnit()
            if (r0 == 0) goto L_0x0239
            java.lang.String r15 = r0.getDeeplinkUrl()
        L_0x0239:
            com.vungle.ads.internal.util.JsonUtil r0 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r0 = r0.getContentStringValue(r2, r10)
            boolean r2 = r26.shouldBlockAutoRedirect$vungle_ads_release()
            if (r2 == 0) goto L_0x0260
            r1.lastUserInteractionTimestamp = r8
            com.vungle.ads.AnalyticsClient r16 = com.vungle.ads.AnalyticsClient.INSTANCE
            com.vungle.ads.SingleValueMetric r0 = new com.vungle.ads.SingleValueMetric
            com.vungle.ads.internal.protos.Sdk$SDKMetric$SDKMetricType r2 = com.vungle.ads.internal.protos.Sdk$SDKMetric.SDKMetricType.BANNER_AUTO_REDIRECT
            r0.<init>(r2)
            com.vungle.ads.internal.util.LogEntry r18 = r26.getLogEntry()
            r19 = 0
            r20 = 4
            r21 = 0
            r17 = r0
            com.vungle.ads.AnalyticsClient.logMetric$vungle_ads_release$default((com.vungle.ads.AnalyticsClient) r16, (com.vungle.ads.SingleValueMetric) r17, (com.vungle.ads.internal.util.LogEntry) r18, (java.lang.String) r19, (int) r20, (java.lang.Object) r21)
            return r13
        L_0x0260:
            r1.lastUserInteractionTimestamp = r8
            com.vungle.ads.internal.ui.view.MRAIDAdWidget r2 = r1.adWidget
            android.content.Context r2 = r2.getContext()
            kotlin.jvm.internal.Intrinsics.e(r2, r7)
            com.vungle.ads.internal.util.LogEntry r3 = r26.getLogEntry()
            com.vungle.ads.internal.presenter.MRAIDPresenter$processCommand$launched$1 r4 = new com.vungle.ads.internal.presenter.MRAIDPresenter$processCommand$launched$1
            r4.<init>(r15, r1)
            boolean r0 = com.vungle.ads.internal.util.ExternalRouter.launch(r15, r0, r2, r3, r4)
            com.vungle.ads.internal.presenter.AdEventListener r2 = r1.bus
            if (r2 == 0) goto L_0x0289
            com.vungle.ads.internal.model.Placement r3 = r1.placement
            java.lang.String r3 = r3.getReferenceId()
            java.lang.String r4 = "adClick"
            r2.onNext(r14, r4, r3)
            kotlin.Unit r2 = kotlin.Unit.f40298a
        L_0x0289:
            if (r0 == 0) goto L_0x029a
            com.vungle.ads.internal.presenter.AdEventListener r0 = r1.bus
            if (r0 == 0) goto L_0x029a
            com.vungle.ads.internal.model.Placement r2 = r1.placement
            java.lang.String r2 = r2.getReferenceId()
            r0.onNext(r14, r6, r2)
            kotlin.Unit r0 = kotlin.Unit.f40298a
        L_0x029a:
            return r13
        L_0x029b:
            java.lang.String r3 = "openPrivacy"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L_0x02a5
            goto L_0x0589
        L_0x02a5:
            com.vungle.ads.internal.util.JsonUtil r0 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r0 = r0.getContentStringValue(r2, r10)
            if (r0 == 0) goto L_0x02b7
            int r2 = r0.length()
            if (r2 != 0) goto L_0x02b4
            goto L_0x02b7
        L_0x02b4:
            r16 = 0
            goto L_0x02b9
        L_0x02b7:
            r16 = 1
        L_0x02b9:
            if (r16 != 0) goto L_0x0304
            com.vungle.ads.internal.util.FileUtility r2 = com.vungle.ads.internal.util.FileUtility.INSTANCE
            boolean r2 = r2.isValidUrl(r0)
            if (r2 != 0) goto L_0x02c4
            goto L_0x0304
        L_0x02c4:
            r17 = 0
            com.vungle.ads.internal.ui.view.MRAIDAdWidget r2 = r1.adWidget
            android.content.Context r2 = r2.getContext()
            kotlin.jvm.internal.Intrinsics.e(r2, r7)
            com.vungle.ads.internal.util.LogEntry r20 = r26.getLogEntry()
            r21 = 0
            r22 = 16
            r23 = 0
            r18 = r0
            r19 = r2
            boolean r2 = com.vungle.ads.internal.util.ExternalRouter.launch$default(r17, r18, r19, r20, r21, r22, r23)
            if (r2 == 0) goto L_0x02f3
            com.vungle.ads.internal.presenter.AdEventListener r0 = r1.bus
            if (r0 == 0) goto L_0x0303
            com.vungle.ads.internal.model.Placement r2 = r1.placement
            java.lang.String r2 = r2.getReferenceId()
            r0.onNext(r14, r6, r2)
            kotlin.Unit r0 = kotlin.Unit.f40298a
            goto L_0x0303
        L_0x02f3:
            com.vungle.ads.PrivacyUrlError r2 = new com.vungle.ads.PrivacyUrlError
            r2.<init>(r0)
            com.vungle.ads.internal.util.LogEntry r0 = r26.getLogEntry()
            com.vungle.ads.VungleError r0 = r2.setLogEntry$vungle_ads_release(r0)
            r0.logErrorNoReturnValue$vungle_ads_release()
        L_0x0303:
            return r13
        L_0x0304:
            com.vungle.ads.PrivacyUrlError r2 = new com.vungle.ads.PrivacyUrlError
            if (r0 != 0) goto L_0x030a
            java.lang.String r0 = "nonePrivacyUrl"
        L_0x030a:
            r2.<init>(r0)
            com.vungle.ads.internal.util.LogEntry r0 = r26.getLogEntry()
            com.vungle.ads.VungleError r0 = r2.setLogEntry$vungle_ads_release(r0)
            r0.logErrorNoReturnValue$vungle_ads_release()
            return r13
        L_0x0319:
            java.lang.String r4 = "pingUrl"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L_0x0323
            goto L_0x0589
        L_0x0323:
            com.vungle.ads.internal.util.JsonUtil r0 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r4 = "requestType"
            java.lang.String r4 = r0.getContentStringValue(r2, r4)
            if (r4 == 0) goto L_0x0339
            java.util.Locale r5 = java.util.Locale.ROOT
            java.lang.String r4 = r4.toUpperCase(r5)
            java.lang.String r5 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.e(r4, r5)
            goto L_0x033a
        L_0x0339:
            r4 = r15
        L_0x033a:
            java.lang.String r5 = "POST"
            java.lang.String r6 = "GET"
            java.lang.String[] r5 = new java.lang.String[]{r6, r5}
            java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsKt.i(r5)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            boolean r5 = kotlin.collections.CollectionsKt___CollectionsKt.z(r5, r4)
            if (r5 != 0) goto L_0x0377
            com.vungle.ads.TpatError r0 = new com.vungle.ads.TpatError
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r2 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.TPAT_ERROR
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Invalid request type: "
            r3.append(r5)
            r3.append(r4)
            java.lang.String r4 = ". Only 'GET' and 'POST' are supported"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.<init>(r2, r3)
            com.vungle.ads.internal.util.LogEntry r2 = r26.getLogEntry()
            com.vungle.ads.VungleError r0 = r0.setLogEntry$vungle_ads_release(r2)
            r0.logErrorNoReturnValue$vungle_ads_release()
            return r13
        L_0x0377:
            java.lang.String r5 = r0.getContentStringValue(r2, r10)
            java.lang.String r7 = "requestData"
            java.lang.String r19 = r0.getContentStringValue(r2, r7)
            java.lang.String r7 = "retry"
            java.lang.String r7 = r0.getContentStringValue(r2, r7)
            boolean r7 = java.lang.Boolean.parseBoolean(r7)
            java.lang.String r8 = "headers"
            java.lang.String r0 = r0.getContentStringValue(r2, r8)
            if (r0 == 0) goto L_0x03e6
            kotlinx.serialization.json.Json$Default r2 = kotlinx.serialization.json.Json.f41116d     // Catch:{ Exception -> 0x03c2 }
            kotlinx.serialization.modules.SerializersModule r8 = r2.a()     // Catch:{ Exception -> 0x03c2 }
            java.lang.Class<java.util.Map> r9 = java.util.Map.class
            kotlin.reflect.KTypeProjection$Companion r10 = kotlin.reflect.KTypeProjection.f40475c     // Catch:{ Exception -> 0x03c2 }
            kotlin.reflect.KType r11 = kotlin.jvm.internal.Reflection.h(r3)     // Catch:{ Exception -> 0x03c2 }
            kotlin.reflect.KTypeProjection r11 = r10.a(r11)     // Catch:{ Exception -> 0x03c2 }
            kotlin.reflect.KType r3 = kotlin.jvm.internal.Reflection.h(r3)     // Catch:{ Exception -> 0x03c2 }
            kotlin.reflect.KTypeProjection r3 = r10.a(r3)     // Catch:{ Exception -> 0x03c2 }
            kotlin.reflect.KType r3 = kotlin.jvm.internal.Reflection.j(r9, r11, r3)     // Catch:{ Exception -> 0x03c2 }
            kotlinx.serialization.KSerializer r3 = kotlinx.serialization.SerializersKt.b(r8, r3)     // Catch:{ Exception -> 0x03c2 }
            java.lang.String r8 = "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>"
            kotlin.jvm.internal.Intrinsics.d(r3, r8)     // Catch:{ Exception -> 0x03c2 }
            java.lang.Object r2 = r2.b(r3, r0)     // Catch:{ Exception -> 0x03c2 }
            r15 = r2
            java.util.Map r15 = (java.util.Map) r15     // Catch:{ Exception -> 0x03c2 }
            goto L_0x03e6
        L_0x03c2:
            com.vungle.ads.TpatError r2 = new com.vungle.ads.TpatError
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r3 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.TPAT_ERROR
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Failed to decode header: "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r2.<init>(r3, r0)
            com.vungle.ads.internal.util.LogEntry r0 = r26.getLogEntry()
            com.vungle.ads.VungleError r0 = r2.setLogEntry$vungle_ads_release(r0)
            r0.logErrorNoReturnValue$vungle_ads_release()
            return r13
        L_0x03e6:
            r18 = r15
            com.vungle.ads.internal.util.Utils r0 = com.vungle.ads.internal.util.Utils.INSTANCE
            boolean r0 = r0.isUrlValid(r5)
            if (r0 != 0) goto L_0x0405
            com.vungle.ads.TpatError r0 = new com.vungle.ads.TpatError
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r2 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.EMPTY_TPAT_ERROR
            java.lang.String r3 = "URL is missing in params from a template for generic tpat"
            r0.<init>(r2, r3)
            com.vungle.ads.internal.util.LogEntry r2 = r26.getLogEntry()
            com.vungle.ads.VungleError r0 = r0.setLogEntry$vungle_ads_release(r2)
            r0.logErrorNoReturnValue$vungle_ads_release()
            return r13
        L_0x0405:
            if (r5 == 0) goto L_0x0447
            com.vungle.ads.internal.network.TpatSender r0 = new com.vungle.ads.internal.network.TpatSender
            com.vungle.ads.internal.network.VungleApiClient r21 = r26.getVungleApiClient$vungle_ads_release()
            com.vungle.ads.internal.util.LogEntry r22 = r26.getLogEntry()
            com.vungle.ads.internal.executor.Executors r2 = r26.getExecutors()
            com.vungle.ads.internal.executor.VungleThreadPoolExecutor r23 = r2.getIoExecutor()
            com.vungle.ads.internal.util.PathProvider r24 = r26.getPathProvider()
            com.vungle.ads.internal.signals.SignalManager r25 = r26.getSignalManager()
            r20 = r0
            r20.<init>(r21, r22, r23, r24, r25)
            com.vungle.ads.internal.network.GenericTpatRequest r2 = new com.vungle.ads.internal.network.GenericTpatRequest
            boolean r3 = kotlin.jvm.internal.Intrinsics.a(r4, r6)
            if (r3 == 0) goto L_0x0431
            com.vungle.ads.internal.network.HttpMethod r3 = com.vungle.ads.internal.network.HttpMethod.GET
            goto L_0x0433
        L_0x0431:
            com.vungle.ads.internal.network.HttpMethod r3 = com.vungle.ads.internal.network.HttpMethod.POST
        L_0x0433:
            r17 = r3
            r20 = 0
            r21 = 8
            r22 = 0
            r16 = r2
            r16.<init>((com.vungle.ads.internal.network.HttpMethod) r17, (java.util.Map) r18, (java.lang.String) r19, (int) r20, (int) r21, (kotlin.jvm.internal.DefaultConstructorMarker) r22)
            java.util.concurrent.Executor r3 = r1.executor
            r0.sendGenericTpat(r5, r2, r7, r3)
            kotlin.Unit r0 = kotlin.Unit.f40298a
        L_0x0447:
            return r13
        L_0x0448:
            java.lang.String r3 = "consentAction"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L_0x0452
            goto L_0x0589
        L_0x0452:
            com.vungle.ads.internal.util.JsonUtil r0 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r0 = r0.getContentStringValue(r2, r11)
            com.vungle.ads.internal.privacy.PrivacyConsent r2 = com.vungle.ads.internal.privacy.PrivacyConsent.OPT_OUT
            java.lang.String r3 = r2.getValue()
            boolean r0 = kotlin.jvm.internal.Intrinsics.a(r0, r3)
            if (r0 == 0) goto L_0x0469
            java.lang.String r0 = r2.getValue()
            goto L_0x046f
        L_0x0469:
            com.vungle.ads.internal.privacy.PrivacyConsent r0 = com.vungle.ads.internal.privacy.PrivacyConsent.OPT_IN
            java.lang.String r0 = r0.getValue()
        L_0x046f:
            com.vungle.ads.internal.privacy.PrivacyManager r2 = com.vungle.ads.internal.privacy.PrivacyManager.INSTANCE
            java.lang.String r3 = "vungle_modal"
            r2.updateGdprConsent(r0, r3, r15)
            return r13
        L_0x0477:
            java.lang.String r3 = "actionWithValue"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L_0x0481
            goto L_0x0589
        L_0x0481:
            com.vungle.ads.internal.util.JsonUtil r0 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r3 = r0.getContentStringValue(r2, r11)
            java.lang.String r5 = "value"
            java.lang.String r2 = r0.getContentStringValue(r2, r5)
            java.lang.String r0 = "videoLength"
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.t(r0, r3, r13)
            if (r0 == 0) goto L_0x04c4
            kotlin.Result$Companion r0 = kotlin.Result.f40263c     // Catch:{ all -> 0x04a8 }
            if (r2 == 0) goto L_0x04a2
            long r5 = java.lang.Long.parseLong(r2)     // Catch:{ all -> 0x04a8 }
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x04a8 }
            goto L_0x04a3
        L_0x04a2:
            r0 = r15
        L_0x04a3:
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch:{ all -> 0x04a8 }
            goto L_0x04b3
        L_0x04a8:
            r0 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.f40263c
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L_0x04b3:
            boolean r5 = kotlin.Result.g(r0)
            if (r5 == 0) goto L_0x04ba
            r0 = r15
        L_0x04ba:
            java.lang.Long r0 = (java.lang.Long) r0
            if (r0 == 0) goto L_0x04c2
            long r8 = r0.longValue()
        L_0x04c2:
            r1.videoLength = r8
        L_0x04c4:
            java.lang.String r0 = "videoViewed"
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.t(r0, r3, r13)
            if (r0 == 0) goto L_0x053b
            r0 = 0
            if (r2 == 0) goto L_0x04db
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x04d4 }
            goto L_0x04dc
        L_0x04d4:
            com.vungle.ads.internal.util.Logger$Companion r2 = com.vungle.ads.internal.util.Logger.Companion
            java.lang.String r3 = "value for videoViewed is null !"
            r2.e(r12, r3)
        L_0x04db:
            r2 = 0
        L_0x04dc:
            com.vungle.ads.internal.presenter.AdEventListener r3 = r1.bus
            if (r3 == 0) goto L_0x053b
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x053b
            boolean r0 = r1.adViewed
            if (r0 != 0) goto L_0x053b
            r1.adViewed = r13
            if (r3 == 0) goto L_0x04f9
            com.vungle.ads.internal.model.Placement r0 = r1.placement
            java.lang.String r0 = r0.getReferenceId()
            java.lang.String r2 = "adViewed"
            r3.onNext(r2, r15, r0)
            kotlin.Unit r0 = kotlin.Unit.f40298a
        L_0x04f9:
            com.vungle.ads.internal.model.BidPayload r0 = r1.bidPayload
            if (r0 == 0) goto L_0x053b
            com.vungle.ads.internal.network.TpatSender r2 = new com.vungle.ads.internal.network.TpatSender
            com.vungle.ads.internal.network.VungleApiClient r6 = r26.getVungleApiClient$vungle_ads_release()
            com.vungle.ads.internal.util.LogEntry r7 = r26.getLogEntry()
            com.vungle.ads.internal.executor.Executors r3 = r26.getExecutors()
            com.vungle.ads.internal.executor.VungleThreadPoolExecutor r8 = r3.getIoExecutor()
            com.vungle.ads.internal.util.PathProvider r9 = r26.getPathProvider()
            com.vungle.ads.internal.signals.SignalManager r10 = r26.getSignalManager()
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            java.util.List r0 = r0.getImpression()
            if (r0 == 0) goto L_0x053b
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0527:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0539
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            java.util.concurrent.Executor r5 = r1.executor
            r2.sendTpat(r3, r5)
            goto L_0x0527
        L_0x0539:
            kotlin.Unit r0 = kotlin.Unit.f40298a
        L_0x053b:
            com.vungle.ads.internal.presenter.b r0 = new com.vungle.ads.internal.presenter.b
            r0.<init>(r1)
            r4.post(r0)
            return r13
        L_0x0544:
            java.lang.String r2 = "action"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x054d
            goto L_0x0589
        L_0x054d:
            return r13
        L_0x054e:
            java.lang.String r2 = "successfulView"
            boolean r3 = r0.equals(r2)
            if (r3 != 0) goto L_0x0557
            goto L_0x0589
        L_0x0557:
            com.vungle.ads.internal.presenter.AdEventListener r0 = r1.bus
            if (r0 == 0) goto L_0x0566
            com.vungle.ads.internal.model.Placement r3 = r1.placement
            java.lang.String r3 = r3.getReferenceId()
            r0.onNext(r2, r15, r3)
            kotlin.Unit r0 = kotlin.Unit.f40298a
        L_0x0566:
            com.vungle.ads.internal.model.Placement r0 = r1.placement
            boolean r0 = r0.isRewardedVideo()
            if (r0 == 0) goto L_0x0588
            com.vungle.ads.internal.ConfigManager r0 = com.vungle.ads.internal.ConfigManager.INSTANCE
            boolean r0 = r0.isReportIncentivizedEnabled()
            if (r0 == 0) goto L_0x0588
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.sendReportIncentivized
            boolean r0 = r0.getAndSet(r13)
            if (r0 != 0) goto L_0x0588
            java.util.concurrent.Executor r0 = r1.executor
            com.vungle.ads.internal.presenter.c r2 = new com.vungle.ads.internal.presenter.c
            r2.<init>(r1)
            r0.execute(r2)
        L_0x0588:
            return r13
        L_0x0589:
            com.vungle.ads.MraidJsError r2 = new com.vungle.ads.MraidJsError
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r3 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.MRAID_JS_CALL_EMPTY
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Unknown MRAID Command: "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r2.<init>(r3, r4)
            com.vungle.ads.internal.util.LogEntry r3 = r26.getLogEntry()
            com.vungle.ads.VungleError r2 = r2.setLogEntry$vungle_ads_release(r3)
            r2.logErrorNoReturnValue$vungle_ads_release()
            com.vungle.ads.internal.util.Logger$Companion r2 = com.vungle.ads.internal.util.Logger.Companion
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "processCommand# Unknown MRAID Command: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.w(r12, r0)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.presenter.MRAIDPresenter.processCommand(java.lang.String, kotlinx.serialization.json.JsonObject):boolean");
    }

    public final void setAdStartTime$vungle_ads_release(Long l2) {
        this.adStartTime = l2;
    }

    public final void setAdVisibility(boolean z2) {
        this.vungleWebClient.setAdVisibility(z2);
    }

    public final void setBackEnabled$vungle_ads_release(boolean z2) {
        this.backEnabled = z2;
    }

    public final void setBus(AdEventListener adEventListener) {
        this.bus = adEventListener;
    }

    public final void setEventListener(AdEventListener adEventListener) {
        this.bus = adEventListener;
    }

    public final void setHeartbeatEnabled$vungle_ads_release(boolean z2) {
        this.heartbeatEnabled = z2;
    }

    public final void setLastUserInteractionTimestamp$vungle_ads_release(long j2) {
        this.lastUserInteractionTimestamp = j2;
    }

    public final void setPresenterDelegate$vungle_ads_release(PresenterDelegate presenterDelegate2) {
        this.presenterDelegate = presenterDelegate2;
    }

    public final void setUserId$vungle_ads_release(String str) {
        this.userId = str;
    }

    public final void setVideoLength$vungle_ads_release(long j2) {
        this.videoLength = j2;
    }

    public final boolean shouldBlockAutoRedirect$vungle_ads_release() {
        ConfigManager configManager = ConfigManager.INSTANCE;
        if (configManager.allowAutoRedirects()) {
            return false;
        }
        if (!this.placement.isBanner() && !this.placement.isMREC() && !this.placement.isInline()) {
            return false;
        }
        if (this.lastUserInteractionTimestamp != 0 && System.currentTimeMillis() - this.lastUserInteractionTimestamp <= configManager.afterClickDuration()) {
            return false;
        }
        return true;
    }

    public final void start() {
        Logger.Companion.d(TAG, "start()");
        this.adWidget.resumeWeb();
        setAdVisibility(true);
    }

    public final void stop() {
        Logger.Companion.d(TAG, "stop()");
        this.adWidget.pauseWeb();
        setAdVisibility(false);
    }
}
