package com.vungle.ads.internal.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcessClient;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.ImagesContract;
import com.vungle.ads.internal.util.HandlerScheduler;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.ViewUtility;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class MRAIDAdWidget extends RelativeLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "MRAIDAdWidget";
    private CloseDelegate closeDelegate;
    private OnViewTouchListener onViewTouchListener;
    private OrientationDelegate orientationDelegate;
    /* access modifiers changed from: private */
    public WebView webView;

    public interface CloseDelegate {
        void close();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class DestroyRunnable implements Runnable {
        private final MRAIDAdWidget widget;

        public DestroyRunnable(MRAIDAdWidget mRAIDAdWidget) {
            Intrinsics.f(mRAIDAdWidget, "widget");
            this.widget = mRAIDAdWidget;
        }

        public void run() {
            ViewGroup viewGroup;
            try {
                this.widget.removeAllViews();
                WebView access$getWebView$p = this.widget.webView;
                if (access$getWebView$p != null) {
                    access$getWebView$p.setWebChromeClient((WebChromeClient) null);
                    access$getWebView$p.stopLoading();
                    access$getWebView$p.clearHistory();
                    if (Build.VERSION.SDK_INT >= 29) {
                        access$getWebView$p.setWebViewRenderProcessClient((WebViewRenderProcessClient) null);
                    }
                    access$getWebView$p.loadUrl("about:blank");
                    access$getWebView$p.removeAllViews();
                    ViewParent parent = access$getWebView$p.getParent();
                    if (parent instanceof ViewGroup) {
                        viewGroup = (ViewGroup) parent;
                    } else {
                        viewGroup = null;
                    }
                    if (viewGroup != null) {
                        viewGroup.removeView(access$getWebView$p);
                    }
                    access$getWebView$p.destroy();
                }
                this.widget.webView = null;
            } catch (Throwable unused) {
            }
        }
    }

    public interface OnViewTouchListener {
        boolean onTouch(MotionEvent motionEvent);
    }

    public interface OrientationDelegate {
        void setOrientation(int i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MRAIDAdWidget(Context context) throws InstantiationException {
        super(context);
        Intrinsics.f(context, "context");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        setLayoutParams(layoutParams);
        WebView webView2 = ViewUtility.INSTANCE.getWebView(context);
        this.webView = webView2;
        if (webView2 != null) {
            webView2.setLayoutParams(layoutParams);
        }
        WebView webView3 = this.webView;
        if (webView3 != null) {
            webView3.setTag("VungleWebView");
        }
        addView(this.webView, layoutParams);
        bindListeners();
        prepare();
    }

    private final void applyDefault(WebView webView2) {
        WebSettings settings = webView2.getSettings();
        Intrinsics.e(settings, "webView.settings");
        settings.setBuiltInZoomControls(false);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSaveFormData(true);
        settings.setUseWideViewPort(false);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        webView2.setVisibility(4);
        settings.setMediaPlaybackRequiresUserGesture(false);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void bindListeners() {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.setOnTouchListener(new a(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindListeners$lambda-0  reason: not valid java name */
    public static final boolean m221bindListeners$lambda0(MRAIDAdWidget mRAIDAdWidget, View view, MotionEvent motionEvent) {
        Intrinsics.f(mRAIDAdWidget, "this$0");
        OnViewTouchListener onViewTouchListener2 = mRAIDAdWidget.onViewTouchListener;
        if (onViewTouchListener2 != null) {
            return onViewTouchListener2.onTouch(motionEvent);
        }
        return false;
    }

    public static /* synthetic */ void getCloseDelegate$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getOnViewTouchListener$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getOrientationDelegate$vungle_ads_release$annotations() {
    }

    private final void prepare() {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.setLayerType(2, (Paint) null);
            webView2.setBackgroundColor(0);
            webView2.setVisibility(8);
        }
    }

    public final void close() {
        CloseDelegate closeDelegate2 = this.closeDelegate;
        if (closeDelegate2 != null) {
            closeDelegate2.close();
        }
    }

    public final void destroyWebView(long j2) {
        if (j2 <= 0) {
            new DestroyRunnable(this).run();
        } else {
            new HandlerScheduler().schedule(new DestroyRunnable(this), j2);
        }
    }

    public final CloseDelegate getCloseDelegate$vungle_ads_release() {
        return this.closeDelegate;
    }

    public final OnViewTouchListener getOnViewTouchListener$vungle_ads_release() {
        return this.onViewTouchListener;
    }

    public final OrientationDelegate getOrientationDelegate$vungle_ads_release() {
        return this.orientationDelegate;
    }

    public final String getUrl() {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            return webView2.getUrl();
        }
        return null;
    }

    public final void linkWebView(WebViewClient webViewClient) {
        Intrinsics.f(webViewClient, "vngWebViewClient");
        WebView webView2 = this.webView;
        if (webView2 != null) {
            applyDefault(webView2);
            webView2.setWebViewClient(webViewClient);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        ViewGroup.LayoutParams layoutParams;
        super.onAttachedToWindow();
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = -1;
            layoutParams2.width = -1;
        }
        WebView webView2 = this.webView;
        if (webView2 != null && (layoutParams = webView2.getLayoutParams()) != null) {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
    }

    public final void pauseWeb() {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.onPause();
        }
    }

    public final void resumeWeb() {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.onResume();
        }
    }

    public final void setCloseDelegate(CloseDelegate closeDelegate2) {
        Intrinsics.f(closeDelegate2, "closeDelegate");
        this.closeDelegate = closeDelegate2;
    }

    public final void setCloseDelegate$vungle_ads_release(CloseDelegate closeDelegate2) {
        this.closeDelegate = closeDelegate2;
    }

    public final void setOnViewTouchListener(OnViewTouchListener onViewTouchListener2) {
        this.onViewTouchListener = onViewTouchListener2;
    }

    public final void setOnViewTouchListener$vungle_ads_release(OnViewTouchListener onViewTouchListener2) {
        this.onViewTouchListener = onViewTouchListener2;
    }

    public final void setOrientation(int i2) {
        OrientationDelegate orientationDelegate2 = this.orientationDelegate;
        if (orientationDelegate2 != null) {
            orientationDelegate2.setOrientation(i2);
        }
    }

    public final void setOrientationDelegate(OrientationDelegate orientationDelegate2) {
        this.orientationDelegate = orientationDelegate2;
    }

    public final void setOrientationDelegate$vungle_ads_release(OrientationDelegate orientationDelegate2) {
        this.orientationDelegate = orientationDelegate2;
    }

    public final void showWebsite(String str) {
        Intrinsics.f(str, ImagesContract.URL);
        Logger.Companion companion = Logger.Companion;
        companion.d(TAG, "loadUrl: " + str);
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.setVisibility(0);
            webView2.loadUrl(str);
        }
    }
}
