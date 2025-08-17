package com.unity3d.services.core.webview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.google.android.gms.common.internal.ImagesContract;
import com.unity3d.services.core.configuration.Experiments;
import com.unity3d.services.core.configuration.IExperiments;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.IInvocationCallbackInvoker;
import com.unity3d.services.core.webview.bridge.IWebViewBridge;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import com.unity3d.services.core.webview.bridge.WebViewBridgeInterface;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.chromium.support_lib_boundary.util.Features;

public class WebView extends android.webkit.WebView implements IServiceComponent {
    private final Lazy sdkMetricsSender$delegate;
    private final WebViewBridgeInterface webViewBridgeInterface;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WebView(Context context) {
        this(context, false, (IWebViewBridge) null, (IInvocationCallbackInvoker) null, (IExperiments) null, 30, (DefaultConstructorMarker) null);
        Intrinsics.f(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WebView(Context context, boolean z2) {
        this(context, z2, (IWebViewBridge) null, (IInvocationCallbackInvoker) null, (IExperiments) null, 28, (DefaultConstructorMarker) null);
        Intrinsics.f(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WebView(Context context, boolean z2, IWebViewBridge iWebViewBridge) {
        this(context, z2, iWebViewBridge, (IInvocationCallbackInvoker) null, (IExperiments) null, 24, (DefaultConstructorMarker) null);
        Intrinsics.f(context, "context");
        Intrinsics.f(iWebViewBridge, "webViewBridge");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WebView(Context context, boolean z2, IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker) {
        this(context, z2, iWebViewBridge, iInvocationCallbackInvoker, (IExperiments) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.f(context, "context");
        Intrinsics.f(iWebViewBridge, "webViewBridge");
        Intrinsics.f(iInvocationCallbackInvoker, "callbackInvoker");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebView(Context context, boolean z2, IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker, IExperiments iExperiments, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? SharedInstances.INSTANCE.getWebViewBridge() : iWebViewBridge, (i2 & 8) != 0 ? SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker() : iInvocationCallbackInvoker, (i2 & 16) != 0 ? new Experiments() : iExperiments);
    }

    /* access modifiers changed from: private */
    public static final void evaluateJavascript$lambda$1(WebView webView, String str, ValueCallback valueCallback) {
        Intrinsics.f(webView, "this$0");
        Intrinsics.f(str, "$script");
        super.evaluateJavascript(str, valueCallback);
    }

    private final SDKMetricsSender getSdkMetricsSender() {
        return (SDKMetricsSender) this.sdkMetricsSender$delegate.getValue();
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        Intrinsics.f(str, "script");
        Utilities.runOnUiThread(new c(this, str, valueCallback));
    }

    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    public void loadUrl(String str) {
        Intrinsics.f(str, ImagesContract.URL);
        DeviceLog.debug("Loading url: " + str);
        super.loadUrl(str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebView(Context context, boolean z2, IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker, IExperiments iExperiments) {
        super(context);
        Intrinsics.f(context, "context");
        Intrinsics.f(iWebViewBridge, "webViewBridge");
        Intrinsics.f(iInvocationCallbackInvoker, "callbackInvoker");
        Intrinsics.f(iExperiments, "experiments");
        this.sdkMetricsSender$delegate = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new WebView$special$$inlined$inject$default$1(this, ""));
        WebViewBridgeInterface webViewBridgeInterface2 = new WebViewBridgeInterface(iWebViewBridge, iInvocationCallbackInvoker);
        this.webViewBridgeInterface = webViewBridgeInterface2;
        WebSettings settings = getSettings();
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowFileAccess(true);
        settings.setBlockNetworkImage(false);
        settings.setBlockNetworkLoads(false);
        settings.setBuiltInZoomControls(false);
        settings.setCacheMode(2);
        settings.setDatabaseEnabled(false);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(false);
        settings.setEnableSmoothTransition(false);
        settings.setGeolocationEnabled(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setJavaScriptEnabled(true);
        settings.setLightTouchEnabled(false);
        settings.setLoadWithOverviewMode(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(1);
        settings.setNeedInitialFocus(true);
        settings.setPluginState(WebSettings.PluginState.OFF);
        settings.setRenderPriority(WebSettings.RenderPriority.NORMAL);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(false);
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(true);
        settings.setMediaPlaybackRequiresUserGesture(!z2);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setInitialScale(0);
        setBackgroundColor(0);
        ViewUtilities.setBackground(this, new ColorDrawable(0));
        setBackgroundResource(0);
        boolean isWebMessageEnabled = iExperiments.isWebMessageEnabled();
        if (isWebMessageEnabled) {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerEnabledMetric());
        } else {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerDisabledMetric());
        }
        boolean a2 = WebViewFeature.a(Features.WEB_MESSAGE_LISTENER);
        if (a2) {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerSupportedMetric());
        } else {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerUnsupportedMetric());
        }
        if (!isWebMessageEnabled || !a2) {
            addJavascriptInterface(webViewBridgeInterface2, "webviewbridge");
            return;
        }
        WebViewCompat.a(this, "handleInvocation", SetsKt__SetsJVMKt.a("*"), new a(webViewBridgeInterface2));
        WebViewCompat.a(this, "handleCallback", SetsKt__SetsJVMKt.a("*"), new b(webViewBridgeInterface2));
    }
}
