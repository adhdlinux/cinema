package com.vungle.ads.internal.ui;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.common.internal.ImagesContract;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import com.vungle.ads.EvaluateJsError;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.omsdk.WebViewObserver;
import com.vungle.ads.internal.platform.Platform;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.ui.view.WebViewAPI;
import com.vungle.ads.internal.util.Logger;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

public final class VungleWebClient extends WebViewClient implements WebViewAPI {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "VungleWebClient";
    private final AdPayload advertisement;
    private boolean collectConsent;
    private WebViewAPI.WebClientErrorHandler errorHandler;
    private String gdprAccept;
    private String gdprBody;
    private String gdprDeny;
    private String gdprTitle;
    private Boolean isViewable;
    private WebView loadedWebView;
    private WebViewAPI.MraidDelegate mraidDelegate;
    private final ExecutorService offloadExecutor;
    private final Placement placement;
    private final Platform platform;
    private boolean ready;
    private final SignalManager signalManager;
    private WebViewObserver webViewObserver;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class VungleWebViewRenderProcessClient extends WebViewRenderProcessClient {
        private WebViewAPI.WebClientErrorHandler errorHandler;

        public VungleWebViewRenderProcessClient(WebViewAPI.WebClientErrorHandler webClientErrorHandler) {
            this.errorHandler = webClientErrorHandler;
        }

        public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            Intrinsics.f(webView, "webView");
        }

        public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            boolean z2;
            Intrinsics.f(webView, "webView");
            Logger.Companion companion = Logger.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append("onRenderProcessUnresponsive(Title = ");
            sb.append(webView.getTitle());
            sb.append(", URL = ");
            sb.append(webView.getOriginalUrl());
            sb.append(", (webViewRenderProcess != null) = ");
            if (webViewRenderProcess != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            sb.append(z2);
            companion.w(VungleWebClient.TAG, sb.toString());
            WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
            if (webClientErrorHandler != null) {
                webClientErrorHandler.onRenderProcessUnresponsive(webView, webViewRenderProcess);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VungleWebClient(AdPayload adPayload, Placement placement2, ExecutorService executorService, SignalManager signalManager2, Platform platform2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(adPayload, placement2, executorService, (i2 & 8) != 0 ? null : signalManager2, (i2 & 16) != 0 ? null : platform2);
    }

    public static /* synthetic */ void getCollectConsent$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getErrorHandler$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getGdprAccept$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getGdprBody$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getGdprDeny$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getGdprTitle$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getLoadedWebView$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getMraidDelegate$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getReady$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getWebViewObserver$vungle_ads_release$annotations() {
    }

    private final void handleWebViewError(String str, String str2, boolean z2) {
        String str3 = str2 + ' ' + str;
        WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
        if (webClientErrorHandler != null) {
            webClientErrorHandler.onReceivedError(str3, z2);
        }
    }

    private final boolean isCriticalAsset(String str) {
        boolean z2;
        if (str.length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return this.advertisement.isCriticalAsset(str);
        }
        return false;
    }

    public static /* synthetic */ void isViewable$vungle_ads_release$annotations() {
    }

    private final void runJavascriptOnWebView(WebView webView, String str) {
        boolean z2 = false;
        if (webView != null) {
            try {
                if (!webView.isAttachedToWindow()) {
                    z2 = true;
                }
            } catch (Throwable th) {
                new EvaluateJsError("Evaluate js failed " + th.getLocalizedMessage()).setLogEntry$vungle_ads_release(this.advertisement.getLogEntry$vungle_ads_release()).logErrorNoReturnValue$vungle_ads_release();
                return;
            }
        }
        if (!z2) {
            Logger.Companion companion = Logger.Companion;
            companion.w(TAG, "mraid Injecting JS " + str);
            if (webView != null) {
                webView.evaluateJavascript(str, (ValueCallback) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: shouldOverrideUrlLoading$lambda-6$lambda-1  reason: not valid java name */
    public static final void m217shouldOverrideUrlLoading$lambda6$lambda1(VungleWebClient vungleWebClient, Handler handler, WebView webView) {
        Intrinsics.f(vungleWebClient, "this$0");
        Intrinsics.f(handler, "$handler");
        JsonObject createMRAIDArgs = vungleWebClient.advertisement.createMRAIDArgs();
        handler.post(new c(vungleWebClient, webView, "window.vungle.mraidBridge.notifyReadyEvent(" + createMRAIDArgs + ')'));
    }

    /* access modifiers changed from: private */
    /* renamed from: shouldOverrideUrlLoading$lambda-6$lambda-1$lambda-0  reason: not valid java name */
    public static final void m218shouldOverrideUrlLoading$lambda6$lambda1$lambda0(VungleWebClient vungleWebClient, WebView webView, String str) {
        Intrinsics.f(vungleWebClient, "this$0");
        Intrinsics.f(str, "$injectJs");
        vungleWebClient.runJavascriptOnWebView(webView, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: shouldOverrideUrlLoading$lambda-6$lambda-5$lambda-4  reason: not valid java name */
    public static final void m219shouldOverrideUrlLoading$lambda6$lambda5$lambda4(WebViewAPI.MraidDelegate mraidDelegate2, String str, JsonObject jsonObject, Handler handler, VungleWebClient vungleWebClient, WebView webView) {
        Intrinsics.f(mraidDelegate2, "$it");
        Intrinsics.f(str, "$command");
        Intrinsics.f(jsonObject, "$args");
        Intrinsics.f(handler, "$handler");
        Intrinsics.f(vungleWebClient, "this$0");
        if (mraidDelegate2.processCommand(str, jsonObject)) {
            handler.post(new b(vungleWebClient, webView));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: shouldOverrideUrlLoading$lambda-6$lambda-5$lambda-4$lambda-3  reason: not valid java name */
    public static final void m220shouldOverrideUrlLoading$lambda6$lambda5$lambda4$lambda3(VungleWebClient vungleWebClient, WebView webView) {
        Intrinsics.f(vungleWebClient, "this$0");
        vungleWebClient.runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyCommandComplete()");
    }

    public final boolean getCollectConsent$vungle_ads_release() {
        return this.collectConsent;
    }

    public final WebViewAPI.WebClientErrorHandler getErrorHandler$vungle_ads_release() {
        return this.errorHandler;
    }

    public final String getGdprAccept$vungle_ads_release() {
        return this.gdprAccept;
    }

    public final String getGdprBody$vungle_ads_release() {
        return this.gdprBody;
    }

    public final String getGdprDeny$vungle_ads_release() {
        return this.gdprDeny;
    }

    public final String getGdprTitle$vungle_ads_release() {
        return this.gdprTitle;
    }

    public final WebView getLoadedWebView$vungle_ads_release() {
        return this.loadedWebView;
    }

    public final WebViewAPI.MraidDelegate getMraidDelegate$vungle_ads_release() {
        return this.mraidDelegate;
    }

    public final boolean getReady$vungle_ads_release() {
        return this.ready;
    }

    public final WebViewObserver getWebViewObserver$vungle_ads_release() {
        return this.webViewObserver;
    }

    public final Boolean isViewable$vungle_ads_release() {
        return this.isViewable;
    }

    public final void notifyDiskAvailableSize(long j2) {
        WebView webView = this.loadedWebView;
        if (webView != null) {
            runJavascriptOnWebView(webView, "window.vungle.mraidBridgeExt.notifyAvailableDiskSpace(" + j2 + ')');
        }
    }

    public void notifyPropertiesChange(boolean z2) {
        String str;
        WebView webView = this.loadedWebView;
        if (webView != null) {
            JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
            JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
            JsonElementBuildersKt.b(jsonObjectBuilder2, "width", Integer.valueOf(webView.getWidth()));
            JsonElementBuildersKt.b(jsonObjectBuilder2, "height", Integer.valueOf(webView.getHeight()));
            JsonObject a2 = jsonObjectBuilder2.a();
            JsonObjectBuilder jsonObjectBuilder3 = new JsonObjectBuilder();
            boolean z3 = false;
            JsonElementBuildersKt.b(jsonObjectBuilder3, "x", 0);
            JsonElementBuildersKt.b(jsonObjectBuilder3, "y", 0);
            JsonElementBuildersKt.b(jsonObjectBuilder3, "width", Integer.valueOf(webView.getWidth()));
            JsonElementBuildersKt.b(jsonObjectBuilder3, "height", Integer.valueOf(webView.getHeight()));
            JsonObject a3 = jsonObjectBuilder3.a();
            JsonObjectBuilder jsonObjectBuilder4 = new JsonObjectBuilder();
            Boolean bool = Boolean.FALSE;
            JsonElementBuildersKt.a(jsonObjectBuilder4, "sms", bool);
            JsonElementBuildersKt.a(jsonObjectBuilder4, "tel", bool);
            JsonElementBuildersKt.a(jsonObjectBuilder4, "calendar", bool);
            JsonElementBuildersKt.a(jsonObjectBuilder4, "storePicture", bool);
            JsonElementBuildersKt.a(jsonObjectBuilder4, "inlineVideo", bool);
            JsonObject a4 = jsonObjectBuilder4.a();
            jsonObjectBuilder.b("maxSize", a2);
            jsonObjectBuilder.b("screenSize", a2);
            jsonObjectBuilder.b("defaultPosition", a3);
            jsonObjectBuilder.b("currentPosition", a3);
            jsonObjectBuilder.b("supports", a4);
            JsonElementBuildersKt.c(jsonObjectBuilder, "placementType", this.advertisement.templateType());
            Boolean bool2 = this.isViewable;
            if (bool2 != null) {
                JsonElementBuildersKt.a(jsonObjectBuilder, "isViewable", Boolean.valueOf(bool2.booleanValue()));
            }
            JsonElementBuildersKt.c(jsonObjectBuilder, "os", "android");
            JsonElementBuildersKt.c(jsonObjectBuilder, "osVersion", String.valueOf(Build.VERSION.SDK_INT));
            JsonElementBuildersKt.a(jsonObjectBuilder, "incentivized", Boolean.valueOf(this.placement.isRewardedVideo()));
            JsonElementBuildersKt.c(jsonObjectBuilder, MediationMetaData.KEY_VERSION, "1.0");
            Platform platform2 = this.platform;
            if (platform2 != null) {
                JsonElementBuildersKt.a(jsonObjectBuilder, "isSilent", Boolean.valueOf(platform2.isSilentModeEnabled()));
            }
            if (this.collectConsent) {
                JsonElementBuildersKt.a(jsonObjectBuilder, "consentRequired", Boolean.TRUE);
                JsonElementBuildersKt.c(jsonObjectBuilder, "consentTitleText", this.gdprTitle);
                JsonElementBuildersKt.c(jsonObjectBuilder, "consentBodyText", this.gdprBody);
                JsonElementBuildersKt.c(jsonObjectBuilder, "consentAcceptButtonText", this.gdprAccept);
                JsonElementBuildersKt.c(jsonObjectBuilder, "consentDenyButtonText", this.gdprDeny);
            } else {
                JsonElementBuildersKt.a(jsonObjectBuilder, "consentRequired", bool);
            }
            if (!ConfigManager.INSTANCE.signalsDisabled()) {
                SignalManager signalManager2 = this.signalManager;
                String str2 = null;
                if (signalManager2 != null) {
                    str = signalManager2.getUuid();
                } else {
                    str = null;
                }
                if (str == null || str.length() == 0) {
                    z3 = true;
                }
                if (!z3) {
                    SignalManager signalManager3 = this.signalManager;
                    if (signalManager3 != null) {
                        str2 = signalManager3.getUuid();
                    }
                    JsonElementBuildersKt.c(jsonObjectBuilder, JsonStorageKeyNames.SESSION_ID_KEY, str2);
                }
            }
            JsonElementBuildersKt.c(jsonObjectBuilder, "sdkVersion", "7.4.3");
            runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyPropertiesChange(" + jsonObjectBuilder.a() + ',' + z2 + ')');
        }
    }

    public final void notifySilentModeChange(boolean z2) {
        WebView webView = this.loadedWebView;
        if (webView != null) {
            JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
            JsonElementBuildersKt.a(jsonObjectBuilder, "isSilent", Boolean.valueOf(z2));
            JsonObject a2 = jsonObjectBuilder.a();
            runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyPropertiesChange(" + a2 + ')');
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (webView != null) {
            this.loadedWebView = webView;
            webView.setVisibility(0);
            notifyPropertiesChange(true);
            if (Build.VERSION.SDK_INT >= 29) {
                webView.setWebViewRenderProcessClient(new VungleWebViewRenderProcessClient(this.errorHandler));
            }
            WebViewObserver webViewObserver2 = this.webViewObserver;
            if (webViewObserver2 != null) {
                webViewObserver2.onPageFinished(webView);
            }
        }
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        Intrinsics.f(str, MediaTrack.ROLE_DESCRIPTION);
        Intrinsics.f(str2, "failingUrl");
        super.onReceivedError(webView, i2, str, str2);
        if (Build.VERSION.SDK_INT < 23) {
            boolean isCriticalAsset = isCriticalAsset(str2);
            Logger.Companion companion = Logger.Companion;
            companion.e(TAG, "Error desc " + str + " for URL " + str2);
            handleWebViewError(str, str2, isCriticalAsset);
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Integer num;
        boolean z2;
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        Uri uri = null;
        if (webResourceResponse != null) {
            num = Integer.valueOf(webResourceResponse.getStatusCode());
        } else {
            num = null;
        }
        String valueOf = String.valueOf(num);
        if (webResourceRequest != null) {
            uri = webResourceRequest.getUrl();
        }
        String valueOf2 = String.valueOf(uri);
        boolean z3 = true;
        if (webResourceRequest == null || !webResourceRequest.isForMainFrame()) {
            z2 = false;
        } else {
            z2 = true;
        }
        Logger.Companion.e(TAG, "Http Error desc " + valueOf + ' ' + z2 + " for URL " + valueOf2);
        if (!isCriticalAsset(valueOf2) || !z2) {
            z3 = false;
        }
        handleWebViewError(valueOf, valueOf2, z3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onRenderProcessGone(android.webkit.WebView r6, android.webkit.RenderProcessGoneDetail r7) {
        /*
            r5 = this;
            r0 = 0
            r5.loadedWebView = r0
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            java.lang.String r3 = "onRenderProcessGone url: "
            java.lang.String r4 = "VungleWebClient"
            if (r1 >= r2) goto L_0x0034
            com.vungle.ads.internal.util.Logger$Companion r7 = com.vungle.ads.internal.util.Logger.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            if (r6 == 0) goto L_0x001d
            java.lang.String r0 = r6.getUrl()
        L_0x001d:
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r7.w(r4, r0)
            com.vungle.ads.internal.ui.view.WebViewAPI$WebClientErrorHandler r7 = r5.errorHandler
            if (r7 == 0) goto L_0x0032
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r6 = r7.onWebRenderingProcessGone(r6, r0)
            goto L_0x0033
        L_0x0032:
            r6 = 1
        L_0x0033:
            return r6
        L_0x0034:
            com.vungle.ads.internal.util.Logger$Companion r1 = com.vungle.ads.internal.util.Logger.Companion
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            if (r6 == 0) goto L_0x0045
            java.lang.String r3 = r6.getUrl()
            goto L_0x0046
        L_0x0045:
            r3 = r0
        L_0x0046:
            r2.append(r3)
            java.lang.String r3 = ", did crash: "
            r2.append(r3)
            if (r7 == 0) goto L_0x0059
            boolean r3 = r7.didCrash()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x005a
        L_0x0059:
            r3 = r0
        L_0x005a:
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.w(r4, r2)
            com.vungle.ads.internal.ui.view.WebViewAPI$WebClientErrorHandler r1 = r5.errorHandler
            if (r1 == 0) goto L_0x0077
            if (r7 == 0) goto L_0x0072
            boolean r7 = r7.didCrash()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r7)
        L_0x0072:
            boolean r6 = r1.onWebRenderingProcessGone(r6, r0)
            goto L_0x007b
        L_0x0077:
            boolean r6 = super.onRenderProcessGone(r6, r7)
        L_0x007b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.ui.VungleWebClient.onRenderProcessGone(android.webkit.WebView, android.webkit.RenderProcessGoneDetail):boolean");
    }

    public void setAdVisibility(boolean z2) {
        this.isViewable = Boolean.valueOf(z2);
        notifyPropertiesChange(false);
    }

    public final void setCollectConsent$vungle_ads_release(boolean z2) {
        this.collectConsent = z2;
    }

    public void setConsentStatus(boolean z2, String str, String str2, String str3, String str4) {
        this.collectConsent = z2;
        this.gdprTitle = str;
        this.gdprBody = str2;
        this.gdprAccept = str3;
        this.gdprDeny = str4;
    }

    public void setErrorHandler(WebViewAPI.WebClientErrorHandler webClientErrorHandler) {
        Intrinsics.f(webClientErrorHandler, "errorHandler");
        this.errorHandler = webClientErrorHandler;
    }

    public final void setErrorHandler$vungle_ads_release(WebViewAPI.WebClientErrorHandler webClientErrorHandler) {
        this.errorHandler = webClientErrorHandler;
    }

    public final void setGdprAccept$vungle_ads_release(String str) {
        this.gdprAccept = str;
    }

    public final void setGdprBody$vungle_ads_release(String str) {
        this.gdprBody = str;
    }

    public final void setGdprDeny$vungle_ads_release(String str) {
        this.gdprDeny = str;
    }

    public final void setGdprTitle$vungle_ads_release(String str) {
        this.gdprTitle = str;
    }

    public final void setLoadedWebView$vungle_ads_release(WebView webView) {
        this.loadedWebView = webView;
    }

    public void setMraidDelegate(WebViewAPI.MraidDelegate mraidDelegate2) {
        this.mraidDelegate = mraidDelegate2;
    }

    public final void setMraidDelegate$vungle_ads_release(WebViewAPI.MraidDelegate mraidDelegate2) {
        this.mraidDelegate = mraidDelegate2;
    }

    public final void setReady$vungle_ads_release(boolean z2) {
        this.ready = z2;
    }

    public final void setViewable$vungle_ads_release(Boolean bool) {
        this.isViewable = bool;
    }

    public void setWebViewObserver(WebViewObserver webViewObserver2) {
        this.webViewObserver = webViewObserver2;
    }

    public final void setWebViewObserver$vungle_ads_release(WebViewObserver webViewObserver2) {
        this.webViewObserver = webViewObserver2;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean z2;
        Logger.Companion companion = Logger.Companion;
        companion.d(TAG, "MRAID Command " + str);
        if (str == null || str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            companion.e(TAG, "Invalid URL ");
            return false;
        }
        Uri parse = Uri.parse(str);
        if (parse == null || parse.getScheme() == null) {
            return false;
        }
        String scheme = parse.getScheme();
        if (Intrinsics.a(scheme, "mraid")) {
            String host = parse.getHost();
            if (host != null) {
                if (!Intrinsics.a("propertiesChangeCompleted", host)) {
                    WebViewAPI.MraidDelegate mraidDelegate2 = this.mraidDelegate;
                    if (mraidDelegate2 != null) {
                        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
                        for (String next : parse.getQueryParameterNames()) {
                            Intrinsics.e(next, "param");
                            JsonElementBuildersKt.c(jsonObjectBuilder, next, parse.getQueryParameter(next));
                        }
                        this.offloadExecutor.submit(new e(mraidDelegate2, host, jsonObjectBuilder.a(), new Handler(Looper.getMainLooper()), this, webView));
                    }
                } else if (!this.ready) {
                    this.ready = true;
                    this.offloadExecutor.submit(new d(this, new Handler(Looper.getMainLooper()), webView));
                }
                return true;
            }
        } else if (StringsKt__StringsJVMKt.t(UriUtil.HTTP_SCHEME, scheme, true) || StringsKt__StringsJVMKt.t(UriUtil.HTTPS_SCHEME, scheme, true)) {
            companion.d(TAG, "Open URL" + str);
            WebViewAPI.MraidDelegate mraidDelegate3 = this.mraidDelegate;
            if (mraidDelegate3 != null) {
                JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
                JsonElementBuildersKt.c(jsonObjectBuilder2, ImagesContract.URL, str);
                mraidDelegate3.processCommand("openNonMraid", jsonObjectBuilder2.a());
            }
            return true;
        }
        return false;
    }

    public VungleWebClient(AdPayload adPayload, Placement placement2, ExecutorService executorService, SignalManager signalManager2, Platform platform2) {
        Intrinsics.f(adPayload, "advertisement");
        Intrinsics.f(placement2, "placement");
        Intrinsics.f(executorService, "offloadExecutor");
        this.advertisement = adPayload;
        this.placement = placement2;
        this.offloadExecutor = executorService;
        this.signalManager = signalManager2;
        this.platform = platform2;
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (Build.VERSION.SDK_INT >= 23) {
            Uri uri = null;
            String valueOf = String.valueOf(webResourceError != null ? webResourceError.getDescription() : null);
            if (webResourceRequest != null) {
                uri = webResourceRequest.getUrl();
            }
            String valueOf2 = String.valueOf(uri);
            boolean z2 = true;
            boolean z3 = webResourceRequest != null && webResourceRequest.isForMainFrame();
            Logger.Companion companion = Logger.Companion;
            companion.e(TAG, "Error desc " + valueOf + ' ' + z3 + " for URL " + valueOf2);
            if (!isCriticalAsset(valueOf2) || !z3) {
                z2 = false;
            }
            handleWebViewError(valueOf, valueOf2, z2);
        }
    }
}
