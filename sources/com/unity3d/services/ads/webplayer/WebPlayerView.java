package com.unity3d.services.ads.webplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebPlayerView extends WebView {
    private Map<String, String> _erroredSettings;
    /* access modifiers changed from: private */
    public Method _evaluateJavascript = null;
    private JSONObject _eventSettings;
    private Runnable _unsubscribeLayoutChange = null;
    /* access modifiers changed from: private */
    public String viewId;

    private class JavaScriptInvocation implements Runnable {
        private String _jsString;
        private WebView _webView;

        public JavaScriptInvocation(String str, WebView webView) {
            this._jsString = str;
            this._webView = webView;
        }

        public void run() {
            if (this._jsString != null) {
                try {
                    WebPlayerView.this._evaluateJavascript.invoke(this._webView, new Object[]{this._jsString, null});
                } catch (Exception e2) {
                    DeviceLog.exception("Error while processing JavaScriptString", e2);
                }
            } else {
                DeviceLog.error("Could not process JavaScript, the string is NULL");
            }
        }
    }

    @TargetApi(21)
    private class WebPlayerChromeClient extends WebChromeClient {
        private WebPlayerChromeClient() {
        }

        public void onCloseWindow(WebView webView) {
            if (WebPlayerView.this.shouldCallSuper("onCloseWindow")) {
                super.onCloseWindow(webView);
            }
            if (WebPlayerView.this.shouldSendEvent("onCloseWindow")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.CLOSE_WINDOW, WebPlayerView.this.viewId);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Boolean} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onConsoleMessage(android.webkit.ConsoleMessage r8) {
            /*
                r7 = this;
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                com.unity3d.services.ads.webplayer.WebPlayerView r1 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.String r2 = "onConsoleMessage"
                boolean r1 = r1.shouldCallSuper(r2)
                if (r1 == 0) goto L_0x0014
                boolean r0 = super.onConsoleMessage(r8)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            L_0x0014:
                com.unity3d.services.ads.webplayer.WebPlayerView r1 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                boolean r1 = r1.shouldSendEvent(r2)
                if (r1 == 0) goto L_0x003f
                if (r8 == 0) goto L_0x0023
                java.lang.String r8 = r8.message()
                goto L_0x0025
            L_0x0023:
                java.lang.String r8 = ""
            L_0x0025:
                com.unity3d.services.core.webview.WebViewApp r1 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
                com.unity3d.services.core.webview.WebViewEventCategory r3 = com.unity3d.services.core.webview.WebViewEventCategory.WEBPLAYER
                com.unity3d.services.ads.webplayer.WebPlayerEvent r4 = com.unity3d.services.ads.webplayer.WebPlayerEvent.CONSOLE_MESSAGE
                r5 = 2
                java.lang.Object[] r5 = new java.lang.Object[r5]
                r6 = 0
                r5[r6] = r8
                com.unity3d.services.ads.webplayer.WebPlayerView r8 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.String r8 = r8.viewId
                r6 = 1
                r5[r6] = r8
                r1.sendEvent(r3, r4, r5)
            L_0x003f:
                com.unity3d.services.ads.webplayer.WebPlayerView r8 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                boolean r8 = r8.hasReturnValue(r2)
                if (r8 == 0) goto L_0x0054
                com.unity3d.services.ads.webplayer.WebPlayerView r8 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
                java.lang.Boolean r1 = java.lang.Boolean.TRUE
                java.lang.Object r8 = r8.getReturnValue(r2, r0, r1)
                r0 = r8
                java.lang.Boolean r0 = (java.lang.Boolean) r0
            L_0x0054:
                boolean r8 = r0.booleanValue()
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.ads.webplayer.WebPlayerView.WebPlayerChromeClient.onConsoleMessage(android.webkit.ConsoleMessage):boolean");
        }

        public boolean onCreateWindow(WebView webView, boolean z2, boolean z3, Message message) {
            Boolean bool;
            Boolean bool2 = Boolean.FALSE;
            if (WebPlayerView.this.shouldCallSuper("onCreateWindow")) {
                bool = Boolean.valueOf(super.onCreateWindow(webView, z2, z3, message));
            } else {
                bool = bool2;
            }
            if (WebPlayerView.this.shouldSendEvent("onCreateWindow")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.CREATE_WINDOW, Boolean.valueOf(z2), Boolean.valueOf(z3), message, WebPlayerView.this.viewId);
            }
            if (WebPlayerView.this.hasReturnValue("onCreateWindow")) {
                bool = (Boolean) WebPlayerView.this.getReturnValue("onCreateWindow", Boolean.class, bool2);
            }
            return bool.booleanValue();
        }

        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            if (WebPlayerView.this.shouldCallSuper("onGeolocationPermissionsShowPrompt")) {
                super.onGeolocationPermissionsShowPrompt(str, callback);
            }
            if (WebPlayerView.this.shouldSendEvent("onGeolocationPermissionsShowPrompt")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.GEOLOCATION_PERMISSIONS_SHOW, str, WebPlayerView.this.viewId);
            }
        }

        public void onHideCustomView() {
            if (WebPlayerView.this.shouldCallSuper("onHideCustomView")) {
                super.onHideCustomView();
            }
            if (WebPlayerView.this.shouldSendEvent("onHideCustomView")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.HIDE_CUSTOM_VIEW, WebPlayerView.this.viewId);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Boolean} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onJsAlert(android.webkit.WebView r7, java.lang.String r8, java.lang.String r9, android.webkit.JsResult r10) {
            /*
                r6 = this;
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                com.unity3d.services.ads.webplayer.WebPlayerView r1 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.String r2 = "onJsAlert"
                boolean r1 = r1.shouldCallSuper(r2)
                if (r1 == 0) goto L_0x0014
                boolean r7 = super.onJsAlert(r7, r8, r9, r10)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r7)
            L_0x0014:
                com.unity3d.services.ads.webplayer.WebPlayerView r7 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                boolean r7 = r7.shouldSendEvent(r2)
                if (r7 == 0) goto L_0x003c
                com.unity3d.services.core.webview.WebViewApp r7 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
                com.unity3d.services.core.webview.WebViewEventCategory r1 = com.unity3d.services.core.webview.WebViewEventCategory.WEBPLAYER
                com.unity3d.services.ads.webplayer.WebPlayerEvent r3 = com.unity3d.services.ads.webplayer.WebPlayerEvent.JS_ALERT
                r4 = 4
                java.lang.Object[] r4 = new java.lang.Object[r4]
                r5 = 0
                r4[r5] = r8
                r8 = 1
                r4[r8] = r9
                r8 = 2
                r4[r8] = r10
                com.unity3d.services.ads.webplayer.WebPlayerView r8 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.String r8 = r8.viewId
                r9 = 3
                r4[r9] = r8
                r7.sendEvent(r1, r3, r4)
            L_0x003c:
                com.unity3d.services.ads.webplayer.WebPlayerView r7 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                boolean r7 = r7.hasReturnValue(r2)
                if (r7 == 0) goto L_0x0051
                com.unity3d.services.ads.webplayer.WebPlayerView r7 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.Class<java.lang.Boolean> r8 = java.lang.Boolean.class
                java.lang.Boolean r9 = java.lang.Boolean.TRUE
                java.lang.Object r7 = r7.getReturnValue(r2, r8, r9)
                r0 = r7
                java.lang.Boolean r0 = (java.lang.Boolean) r0
            L_0x0051:
                boolean r7 = r0.booleanValue()
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.ads.webplayer.WebPlayerView.WebPlayerChromeClient.onJsAlert(android.webkit.WebView, java.lang.String, java.lang.String, android.webkit.JsResult):boolean");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Boolean} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onJsConfirm(android.webkit.WebView r6, java.lang.String r7, java.lang.String r8, android.webkit.JsResult r9) {
            /*
                r5 = this;
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                com.unity3d.services.ads.webplayer.WebPlayerView r1 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.String r2 = "onJsConfirm"
                boolean r1 = r1.shouldCallSuper(r2)
                if (r1 == 0) goto L_0x0014
                boolean r6 = super.onJsConfirm(r6, r7, r8, r9)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r6)
            L_0x0014:
                com.unity3d.services.ads.webplayer.WebPlayerView r6 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                boolean r6 = r6.shouldSendEvent(r2)
                if (r6 == 0) goto L_0x0039
                com.unity3d.services.core.webview.WebViewApp r6 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
                com.unity3d.services.core.webview.WebViewEventCategory r9 = com.unity3d.services.core.webview.WebViewEventCategory.WEBPLAYER
                com.unity3d.services.ads.webplayer.WebPlayerEvent r1 = com.unity3d.services.ads.webplayer.WebPlayerEvent.JS_CONFIRM
                r3 = 3
                java.lang.Object[] r3 = new java.lang.Object[r3]
                r4 = 0
                r3[r4] = r7
                r7 = 1
                r3[r7] = r8
                com.unity3d.services.ads.webplayer.WebPlayerView r7 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.String r7 = r7.viewId
                r8 = 2
                r3[r8] = r7
                r6.sendEvent(r9, r1, r3)
            L_0x0039:
                com.unity3d.services.ads.webplayer.WebPlayerView r6 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                boolean r6 = r6.hasReturnValue(r2)
                if (r6 == 0) goto L_0x004e
                com.unity3d.services.ads.webplayer.WebPlayerView r6 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.Class<java.lang.Boolean> r7 = java.lang.Boolean.class
                java.lang.Boolean r8 = java.lang.Boolean.TRUE
                java.lang.Object r6 = r6.getReturnValue(r2, r7, r8)
                r0 = r6
                java.lang.Boolean r0 = (java.lang.Boolean) r0
            L_0x004e:
                boolean r6 = r0.booleanValue()
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.ads.webplayer.WebPlayerView.WebPlayerChromeClient.onJsConfirm(android.webkit.WebView, java.lang.String, java.lang.String, android.webkit.JsResult):boolean");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Boolean} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onJsPrompt(android.webkit.WebView r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, android.webkit.JsPromptResult r10) {
            /*
                r5 = this;
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                com.unity3d.services.ads.webplayer.WebPlayerView r1 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.String r2 = "onJsPrompt"
                boolean r1 = r1.shouldCallSuper(r2)
                if (r1 == 0) goto L_0x0014
                boolean r6 = super.onJsPrompt(r6, r7, r8, r9, r10)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r6)
            L_0x0014:
                com.unity3d.services.ads.webplayer.WebPlayerView r6 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                boolean r6 = r6.shouldSendEvent(r2)
                if (r6 == 0) goto L_0x003c
                com.unity3d.services.core.webview.WebViewApp r6 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
                com.unity3d.services.core.webview.WebViewEventCategory r10 = com.unity3d.services.core.webview.WebViewEventCategory.WEBPLAYER
                com.unity3d.services.ads.webplayer.WebPlayerEvent r1 = com.unity3d.services.ads.webplayer.WebPlayerEvent.JS_PROMPT
                r3 = 4
                java.lang.Object[] r3 = new java.lang.Object[r3]
                r4 = 0
                r3[r4] = r7
                r7 = 1
                r3[r7] = r8
                r7 = 2
                r3[r7] = r9
                com.unity3d.services.ads.webplayer.WebPlayerView r7 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.String r7 = r7.viewId
                r8 = 3
                r3[r8] = r7
                r6.sendEvent(r10, r1, r3)
            L_0x003c:
                com.unity3d.services.ads.webplayer.WebPlayerView r6 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                boolean r6 = r6.hasReturnValue(r2)
                if (r6 == 0) goto L_0x0051
                com.unity3d.services.ads.webplayer.WebPlayerView r6 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.Class<java.lang.Boolean> r7 = java.lang.Boolean.class
                java.lang.Boolean r8 = java.lang.Boolean.TRUE
                java.lang.Object r6 = r6.getReturnValue(r2, r7, r8)
                r0 = r6
                java.lang.Boolean r0 = (java.lang.Boolean) r0
            L_0x0051:
                boolean r6 = r0.booleanValue()
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.ads.webplayer.WebPlayerView.WebPlayerChromeClient.onJsPrompt(android.webkit.WebView, java.lang.String, java.lang.String, java.lang.String, android.webkit.JsPromptResult):boolean");
        }

        public void onPermissionRequest(PermissionRequest permissionRequest) {
            String str;
            if (WebPlayerView.this.shouldCallSuper("onPermissionRequest")) {
                super.onPermissionRequest(permissionRequest);
            }
            if (WebPlayerView.this.shouldSendEvent("onPermissionRequest")) {
                if (permissionRequest == null || permissionRequest.getOrigin() == null) {
                    str = "";
                } else {
                    str = permissionRequest.getOrigin().toString();
                }
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PERMISSION_REQUEST, str, WebPlayerView.this.viewId);
            }
        }

        public void onProgressChanged(WebView webView, int i2) {
            if (WebPlayerView.this.shouldCallSuper("onProgressChanged")) {
                super.onProgressChanged(webView, i2);
            }
            if (WebPlayerView.this.shouldSendEvent("onProgressChanged")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PROGRESS_CHANGED, Integer.valueOf(i2), WebPlayerView.this.viewId);
            }
        }

        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            if (WebPlayerView.this.shouldCallSuper("onReceivedIcon")) {
                super.onReceivedIcon(webView, bitmap);
            }
            if (WebPlayerView.this.shouldSendEvent("onReceivedIcon")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.RECEIVED_ICON, WebPlayerView.this.viewId);
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            if (WebPlayerView.this.shouldCallSuper("onReceivedTitle")) {
                super.onReceivedTitle(webView, str);
            }
            if (WebPlayerView.this.shouldSendEvent("onReceivedTitle")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.RECEIVED_TITLE, str, WebPlayerView.this.viewId);
            }
        }

        public void onReceivedTouchIconUrl(WebView webView, String str, boolean z2) {
            if (WebPlayerView.this.shouldCallSuper("onReceivedTouchIconUrl")) {
                super.onReceivedTouchIconUrl(webView, str, z2);
            }
            if (WebPlayerView.this.shouldSendEvent("onReceivedTouchIconUrl")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.RECEIVED_TOUCH_ICON_URL, str, Boolean.valueOf(z2), WebPlayerView.this.viewId);
            }
        }

        public void onRequestFocus(WebView webView) {
            if (WebPlayerView.this.shouldCallSuper("onRequestFocus")) {
                super.onRequestFocus(webView);
            }
            if (WebPlayerView.this.shouldSendEvent("onRequestFocus")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.REQUEST_FOCUS, WebPlayerView.this.viewId);
            }
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            if (WebPlayerView.this.shouldCallSuper("onShowCustomView")) {
                super.onShowCustomView(view, customViewCallback);
            }
            if (WebPlayerView.this.shouldSendEvent("onShowCustomView")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOW_CUSTOM_VIEW, WebPlayerView.this.viewId);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Boolean} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onShowFileChooser(android.webkit.WebView r7, android.webkit.ValueCallback<android.net.Uri[]> r8, android.webkit.WebChromeClient.FileChooserParams r9) {
            /*
                r6 = this;
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                com.unity3d.services.ads.webplayer.WebPlayerView r1 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.String r2 = "onShowFileChooser"
                boolean r1 = r1.shouldCallSuper(r2)
                if (r1 == 0) goto L_0x0014
                boolean r7 = super.onShowFileChooser(r7, r8, r9)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r7)
            L_0x0014:
                com.unity3d.services.ads.webplayer.WebPlayerView r7 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                boolean r7 = r7.shouldSendEvent(r2)
                if (r7 == 0) goto L_0x0033
                com.unity3d.services.core.webview.WebViewApp r7 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
                com.unity3d.services.core.webview.WebViewEventCategory r9 = com.unity3d.services.core.webview.WebViewEventCategory.WEBPLAYER
                com.unity3d.services.ads.webplayer.WebPlayerEvent r1 = com.unity3d.services.ads.webplayer.WebPlayerEvent.SHOW_FILE_CHOOSER
                r3 = 1
                java.lang.Object[] r3 = new java.lang.Object[r3]
                com.unity3d.services.ads.webplayer.WebPlayerView r4 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.String r4 = r4.viewId
                r5 = 0
                r3[r5] = r4
                r7.sendEvent(r9, r1, r3)
            L_0x0033:
                com.unity3d.services.ads.webplayer.WebPlayerView r7 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                boolean r7 = r7.hasReturnValue(r2)
                if (r7 == 0) goto L_0x0052
                com.unity3d.services.ads.webplayer.WebPlayerView r7 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.Class<java.lang.Boolean> r9 = java.lang.Boolean.class
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                java.lang.Object r7 = r7.getReturnValue(r2, r9, r0)
                r0 = r7
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                boolean r7 = r0.booleanValue()
                if (r7 == 0) goto L_0x0052
                r7 = 0
                r8.onReceiveValue(r7)
            L_0x0052:
                boolean r7 = r0.booleanValue()
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.ads.webplayer.WebPlayerView.WebPlayerChromeClient.onShowFileChooser(android.webkit.WebView, android.webkit.ValueCallback, android.webkit.WebChromeClient$FileChooserParams):boolean");
        }
    }

    private class WebPlayerDownloadListener implements DownloadListener {
        private WebPlayerDownloadListener() {
        }

        public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            if (WebPlayerView.this.shouldSendEvent("onDownloadStart")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.DOWNLOAD_START, str, str2, str3, str4, Long.valueOf(j2), WebPlayerView.this.viewId);
            }
        }
    }

    public WebPlayerView(Context context, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        super(context);
        this.viewId = str;
        WebSettings settings = getSettings();
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        try {
            this._evaluateJavascript = WebView.class.getMethod("evaluateJavascript", new Class[]{String.class, ValueCallback.class});
        } catch (NoSuchMethodException e2) {
            DeviceLog.exception("Method evaluateJavascript not found", e2);
            this._evaluateJavascript = null;
        }
        settings.setCacheMode(2);
        settings.setDatabaseEnabled(false);
        settings.setDomStorageEnabled(false);
        settings.setGeolocationEnabled(false);
        settings.setJavaScriptEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setPluginState(WebSettings.PluginState.OFF);
        settings.setRenderPriority(WebSettings.RenderPriority.NORMAL);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setInitialScale(0);
        setBackgroundColor(0);
        ViewUtilities.setBackground(this, new ColorDrawable(0));
        setBackgroundResource(0);
        setSettings(jSONObject, jSONObject2);
        setWebViewClient(new WebPlayerClient());
        setWebChromeClient(new WebPlayerChromeClient());
        setDownloadListener(new WebPlayerDownloadListener());
        addJavascriptInterface(new WebPlayerBridgeInterface(str), "webplayerbridge");
        WebPlayerViewCache.getInstance().addWebPlayer(str, this);
        subscribeOnLayoutChange();
    }

    private void addErroredSetting(String str, String str2) {
        if (this._erroredSettings == null) {
            this._erroredSettings = new HashMap();
        }
        this._erroredSettings.put(str, str2);
    }

    /* access modifiers changed from: private */
    public <T> T getReturnValue(String str, Class<T> cls, T t2) {
        try {
            JSONObject jSONObject = this._eventSettings;
            if (jSONObject != null && jSONObject.has(str) && this._eventSettings.getJSONObject(str).has("returnValue")) {
                return cls.cast(this._eventSettings.getJSONObject(str).get("returnValue"));
            }
        } catch (Exception e2) {
            DeviceLog.exception("Error getting default return value", e2);
        }
        return t2;
    }

    private Class<?>[] getTypes(JSONArray jSONArray) throws JSONException, ClassNotFoundException {
        if (jSONArray == null) {
            return null;
        }
        Class<?>[] clsArr = new Class[jSONArray.length()];
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (jSONArray.get(i2) instanceof JSONObject) {
                clsArr[i2] = Class.forName(((JSONObject) jSONArray.get(i2)).getString("className"));
            } else {
                clsArr[i2] = getPrimitiveClass(jSONArray.get(i2).getClass());
            }
        }
        return clsArr;
    }

    private Object[] getValues(JSONArray jSONArray) throws JSONException, ClassNotFoundException, NoSuchMethodException {
        String str;
        if (jSONArray == null) {
            return null;
        }
        Object[] objArr = new Object[jSONArray.length()];
        Object[] objArr2 = new Object[jSONArray.length()];
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (jSONArray.get(i2) instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                Object obj = jSONObject.get(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                String string = jSONObject.getString("type");
                if (jSONObject.has("className")) {
                    str = jSONObject.getString("className");
                } else {
                    str = null;
                }
                if (str != null && string.equals("Enum")) {
                    objArr2[i2] = Enum.valueOf(Class.forName(str), (String) obj);
                }
            } else {
                objArr2[i2] = jSONArray.get(i2);
            }
        }
        System.arraycopy(objArr2, 0, objArr, 0, jSONArray.length());
        return objArr;
    }

    /* access modifiers changed from: private */
    public boolean hasReturnValue(String str) {
        try {
            JSONObject jSONObject = this._eventSettings;
            if (jSONObject == null || !jSONObject.has(str) || !this._eventSettings.getJSONObject(str).has("returnValue")) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            DeviceLog.exception("Error getting default return value", e2);
            return false;
        }
    }

    private Object setTargetSettings(Object obj, JSONObject jSONObject) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    obj.getClass().getMethod(next, getTypes(jSONArray)).invoke(obj, getValues(jSONArray));
                } catch (Exception e2) {
                    addErroredSetting(next, e2.getMessage());
                    DeviceLog.exception("Setting errored", e2);
                }
            }
        }
        return obj;
    }

    /* access modifiers changed from: private */
    public boolean shouldCallSuper(String str) {
        try {
            JSONObject jSONObject = this._eventSettings;
            if (jSONObject == null || !jSONObject.has(str) || !this._eventSettings.getJSONObject(str).has("callSuper")) {
                return true;
            }
            return this._eventSettings.getJSONObject(str).getBoolean("callSuper");
        } catch (Exception e2) {
            DeviceLog.exception("Error getting super call status", e2);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public boolean shouldSendEvent(String str) {
        try {
            JSONObject jSONObject = this._eventSettings;
            if (jSONObject == null || !jSONObject.has(str) || !this._eventSettings.getJSONObject(str).has("sendEvent")) {
                return false;
            }
            return this._eventSettings.getJSONObject(str).getBoolean("sendEvent");
        } catch (Exception e2) {
            DeviceLog.exception("Error getting send event status", e2);
            return false;
        }
    }

    private void subscribeOnLayoutChange() {
        Runnable runnable = this._unsubscribeLayoutChange;
        if (runnable != null) {
            runnable.run();
        }
        final AnonymousClass1 r02 = new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                WebPlayerView.this.onLayoutChange();
            }
        };
        addOnLayoutChangeListener(r02);
        this._unsubscribeLayoutChange = new Runnable() {
            public void run() {
                WebPlayerView.this.removeOnLayoutChangeListener(r02);
            }
        };
    }

    public void destroy() {
        super.destroy();
        WebPlayerViewCache.getInstance().removeWebPlayer(this.viewId);
        Runnable runnable = this._unsubscribeLayoutChange;
        if (runnable != null) {
            runnable.run();
        }
    }

    public Map<String, String> getErroredSettings() {
        return this._erroredSettings;
    }

    public Class<?> getPrimitiveClass(Class<?> cls) {
        String name = cls.getName();
        if (name.equals("java.lang.Byte")) {
            return Byte.TYPE;
        }
        if (name.equals("java.lang.Short")) {
            return Short.TYPE;
        }
        if (name.equals("java.lang.Integer")) {
            return Integer.TYPE;
        }
        if (name.equals("java.lang.Long")) {
            return Long.TYPE;
        }
        if (name.equals("java.lang.Character")) {
            return Character.TYPE;
        }
        if (name.equals("java.lang.Float")) {
            return Float.TYPE;
        }
        if (name.equals("java.lang.Double")) {
            return Double.TYPE;
        }
        if (name.equals("java.lang.Boolean")) {
            return Boolean.TYPE;
        }
        if (name.equals("java.lang.Void")) {
            return Void.TYPE;
        }
        return cls;
    }

    public void invokeJavascript(String str) {
        Utilities.runOnUiThread(new JavaScriptInvocation(str, this));
    }

    public void onLayoutChange() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        WebPlayerEventBridge.sendFrameUpdate(this.viewId, iArr[0], iArr[1], getWidth(), getHeight(), getAlpha());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        onLayoutChange();
    }

    public void sendEvent(JSONArray jSONArray) {
        invokeJavascript("javascript:window.nativebridge.receiveEvent(" + jSONArray.toString() + ")");
    }

    public void setEventSettings(JSONObject jSONObject) {
        this._eventSettings = jSONObject;
    }

    public void setSettings(JSONObject jSONObject, JSONObject jSONObject2) {
        Map<String, String> map = this._erroredSettings;
        if (map != null) {
            map.clear();
        }
        setTargetSettings(getSettings(), jSONObject);
        setTargetSettings(this, jSONObject2);
    }

    private class WebPlayerClient extends WebViewClient {
        private WebPlayerClient() {
        }

        public void onFormResubmission(WebView webView, Message message, Message message2) {
            if (WebPlayerView.this.shouldCallSuper("onFormResubmission")) {
                super.onFormResubmission(webView, message, message2);
            }
            if (WebPlayerView.this.shouldSendEvent("onFormResubmission")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.FORM_RESUBMISSION, WebPlayerView.this.viewId);
            }
        }

        public void onLoadResource(WebView webView, String str) {
            if (WebPlayerView.this.shouldCallSuper("onLoadResource")) {
                super.onLoadResource(webView, str);
            }
            if (WebPlayerView.this.shouldSendEvent("onLoadResource")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.LOAD_RESOUCE, str, WebPlayerView.this.viewId);
            }
        }

        public void onPageCommitVisible(WebView webView, String str) {
            if (WebPlayerView.this.shouldCallSuper("onPageCommitVisible")) {
                super.onPageCommitVisible(webView, str);
            }
            if (WebPlayerView.this.shouldSendEvent("onPageCommitVisible")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PAGE_COMMIT_VISIBLE, str, WebPlayerView.this.viewId);
            }
        }

        public void onPageFinished(WebView webView, String str) {
            if (WebPlayerView.this.shouldCallSuper("onPageFinished")) {
                super.onPageFinished(webView, str);
            }
            if (WebPlayerView.this.shouldSendEvent("onPageFinished")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PAGE_FINISHED, str, WebPlayerView.this.viewId);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (WebPlayerView.this.shouldCallSuper("onPageStarted")) {
                super.onPageStarted(webView, str, bitmap);
            }
            if (WebPlayerView.this.shouldSendEvent("onPageStarted")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PAGE_STARTED, str, WebPlayerView.this.viewId);
            }
        }

        @TargetApi(21)
        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            int i2;
            String str;
            if (WebPlayerView.this.shouldCallSuper("onReceivedClientCertRequest")) {
                super.onReceivedClientCertRequest(webView, clientCertRequest);
            }
            if (WebPlayerView.this.shouldSendEvent("onReceivedClientCertRequest")) {
                if (clientCertRequest != null) {
                    str = clientCertRequest.getHost();
                    i2 = clientCertRequest.getPort();
                } else {
                    str = "";
                    i2 = -1;
                }
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.CLIENT_CERT_REQUEST, str, Integer.valueOf(i2), WebPlayerView.this.viewId);
            }
        }

        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            if (WebPlayerView.this.shouldCallSuper("onReceivedError")) {
                super.onReceivedError(webView, i2, str, str2);
            }
            if (WebPlayerView.this.shouldSendEvent("onReceivedError")) {
                WebPlayerEventBridge.error(WebPlayerView.this.viewId, str2, str);
            }
        }

        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            if (WebPlayerView.this.shouldCallSuper("onReceivedHttpAuthRequest")) {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
            if (WebPlayerView.this.shouldSendEvent("onReceivedHttpAuthRequest")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.HTTP_AUTH_REQUEST, str, str2, WebPlayerView.this.viewId);
            }
        }

        @TargetApi(21)
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            String str;
            int i2;
            if (WebPlayerView.this.shouldCallSuper("onReceivedHttpError")) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
            if (WebPlayerView.this.shouldSendEvent("onReceivedHttpError")) {
                String str2 = "";
                if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
                    str = str2;
                } else {
                    str = webResourceRequest.getUrl().toString();
                }
                if (webResourceResponse != null) {
                    int statusCode = webResourceResponse.getStatusCode();
                    String reasonPhrase = webResourceResponse.getReasonPhrase();
                    i2 = statusCode;
                    str2 = reasonPhrase;
                } else {
                    i2 = -1;
                }
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.HTTP_ERROR, str, str2, Integer.valueOf(i2), WebPlayerView.this.viewId);
            }
        }

        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            if (WebPlayerView.this.shouldCallSuper("onReceivedLoginRequest")) {
                super.onReceivedLoginRequest(webView, str, str2, str3);
            }
            if (WebPlayerView.this.shouldSendEvent("onReceivedLoginRequest")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.LOGIN_REQUEST, str, str2, str3, WebPlayerView.this.viewId);
            }
        }

        @TargetApi(14)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            if (sslError != null) {
                DeviceLog.error("Received SSL error for '%s': %s", sslError.getUrl(), sslError.toString());
            } else {
                DeviceLog.error("Received unknown SSL error: SslError was null");
            }
            if (WebPlayerView.this.shouldSendEvent("onReceivedSslError")) {
                if (sslError != null) {
                    str = sslError.getUrl();
                } else {
                    str = "";
                }
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SSL_ERROR, str, WebPlayerView.this.viewId);
            }
        }

        public boolean onRenderProcessGone(final WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    ViewUtilities.removeViewFromParent(webView);
                    webView.destroy();
                }
            });
            String access$400 = WebPlayerView.this.viewId;
            String url = WebPlayerView.this.getUrl();
            WebPlayerEventBridge.error(access$400, url, "UnityAds Sdk WebPlayer onRenderProcessGone : " + renderProcessGoneDetail.toString());
            DeviceLog.error("UnityAds Sdk WebPlayer onRenderProcessGone : " + renderProcessGoneDetail.toString());
            return true;
        }

        public void onScaleChanged(WebView webView, float f2, float f3) {
            if (WebPlayerView.this.shouldCallSuper("onScaleChanged")) {
                super.onScaleChanged(webView, f2, f3);
            }
            if (WebPlayerView.this.shouldSendEvent("onScaleChanged")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SCALE_CHANGED, Float.valueOf(f2), Float.valueOf(f3), WebPlayerView.this.viewId);
            }
        }

        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            if (WebPlayerView.this.shouldCallSuper("onUnhandledKeyEvent")) {
                super.onUnhandledKeyEvent(webView, keyEvent);
            }
            if (WebPlayerView.this.shouldSendEvent("onUnhandledKeyEvent")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.UNHANDLED_KEY_EVENT, Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()), WebPlayerView.this.viewId);
            }
        }

        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebResourceResponse webResourceResponse;
            if (WebPlayerView.this.shouldCallSuper("shouldInterceptRequest")) {
                webResourceResponse = super.shouldInterceptRequest(webView, webResourceRequest);
            } else {
                webResourceResponse = null;
            }
            if (WebPlayerView.this.shouldSendEvent("shouldInterceptRequest")) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOULD_INTERCEPT_REQUEST, webResourceRequest.getUrl().toString(), WebPlayerView.this.viewId);
            }
            return webResourceResponse;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Boolean} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean shouldOverrideKeyEvent(android.webkit.WebView r8, android.view.KeyEvent r9) {
            /*
                r7 = this;
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                com.unity3d.services.ads.webplayer.WebPlayerView r1 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.String r2 = "shouldOverrideKeyEvent"
                boolean r1 = r1.shouldCallSuper(r2)
                if (r1 == 0) goto L_0x0014
                boolean r8 = super.shouldOverrideKeyEvent(r8, r9)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r8)
            L_0x0014:
                com.unity3d.services.ads.webplayer.WebPlayerView r8 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                boolean r8 = r8.shouldSendEvent(r2)
                if (r8 == 0) goto L_0x0049
                com.unity3d.services.core.webview.WebViewApp r8 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
                com.unity3d.services.core.webview.WebViewEventCategory r1 = com.unity3d.services.core.webview.WebViewEventCategory.WEBPLAYER
                com.unity3d.services.ads.webplayer.WebPlayerEvent r3 = com.unity3d.services.ads.webplayer.WebPlayerEvent.SHOULD_OVERRIDE_KEY_EVENT
                r4 = 3
                java.lang.Object[] r4 = new java.lang.Object[r4]
                int r5 = r9.getKeyCode()
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r6 = 0
                r4[r6] = r5
                int r9 = r9.getAction()
                java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
                r5 = 1
                r4[r5] = r9
                com.unity3d.services.ads.webplayer.WebPlayerView r9 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.String r9 = r9.viewId
                r5 = 2
                r4[r5] = r9
                r8.sendEvent(r1, r3, r4)
            L_0x0049:
                com.unity3d.services.ads.webplayer.WebPlayerView r8 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                boolean r8 = r8.hasReturnValue(r2)
                if (r8 == 0) goto L_0x005e
                com.unity3d.services.ads.webplayer.WebPlayerView r8 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.Class<java.lang.Boolean> r9 = java.lang.Boolean.class
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                java.lang.Object r8 = r8.getReturnValue(r2, r9, r0)
                r0 = r8
                java.lang.Boolean r0 = (java.lang.Boolean) r0
            L_0x005e:
                boolean r8 = r0.booleanValue()
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.ads.webplayer.WebPlayerView.WebPlayerClient.shouldOverrideKeyEvent(android.webkit.WebView, android.view.KeyEvent):boolean");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Boolean} */
        /* JADX WARNING: Multi-variable type inference failed */
        @android.annotation.TargetApi(21)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean shouldOverrideUrlLoading(android.webkit.WebView r8, android.webkit.WebResourceRequest r9) {
            /*
                r7 = this;
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                com.unity3d.services.ads.webplayer.WebPlayerView r1 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.String r2 = "shouldOverrideUrlLoading"
                boolean r1 = r1.shouldCallSuper(r2)
                if (r1 == 0) goto L_0x0014
                boolean r8 = super.shouldOverrideUrlLoading(r8, r9)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r8)
            L_0x0014:
                com.unity3d.services.ads.webplayer.WebPlayerView r8 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                boolean r8 = r8.shouldSendEvent(r2)
                if (r8 == 0) goto L_0x0045
                com.unity3d.services.core.webview.WebViewApp r8 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
                com.unity3d.services.core.webview.WebViewEventCategory r1 = com.unity3d.services.core.webview.WebViewEventCategory.WEBPLAYER
                com.unity3d.services.ads.webplayer.WebPlayerEvent r3 = com.unity3d.services.ads.webplayer.WebPlayerEvent.SHOULD_OVERRIDE_URL_LOADING
                r4 = 3
                java.lang.Object[] r4 = new java.lang.Object[r4]
                android.net.Uri r5 = r9.getUrl()
                java.lang.String r5 = r5.toString()
                r6 = 0
                r4[r6] = r5
                r5 = 1
                java.lang.String r9 = r9.getMethod()
                r4[r5] = r9
                com.unity3d.services.ads.webplayer.WebPlayerView r9 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.String r9 = r9.viewId
                r5 = 2
                r4[r5] = r9
                r8.sendEvent(r1, r3, r4)
            L_0x0045:
                com.unity3d.services.ads.webplayer.WebPlayerView r8 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                boolean r8 = r8.hasReturnValue(r2)
                if (r8 == 0) goto L_0x005a
                com.unity3d.services.ads.webplayer.WebPlayerView r8 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.Class<java.lang.Boolean> r9 = java.lang.Boolean.class
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                java.lang.Object r8 = r8.getReturnValue(r2, r9, r0)
                r0 = r8
                java.lang.Boolean r0 = (java.lang.Boolean) r0
            L_0x005a:
                boolean r8 = r0.booleanValue()
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.ads.webplayer.WebPlayerView.WebPlayerClient.shouldOverrideUrlLoading(android.webkit.WebView, android.webkit.WebResourceRequest):boolean");
        }

        @TargetApi(25)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (WebPlayerView.this.shouldCallSuper("onReceivedError")) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
            if (WebPlayerView.this.shouldSendEvent("onReceivedError")) {
                String str = "";
                String charSequence = (webResourceError == null || webResourceError.getDescription() == null) ? str : webResourceError.getDescription().toString();
                if (!(webResourceRequest == null || webResourceRequest.getUrl() == null)) {
                    str = webResourceRequest.getUrl().toString();
                }
                WebPlayerEventBridge.error(WebPlayerView.this.viewId, str, charSequence);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Boolean} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean shouldOverrideUrlLoading(android.webkit.WebView r7, java.lang.String r8) {
            /*
                r6 = this;
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                com.unity3d.services.ads.webplayer.WebPlayerView r1 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.String r2 = "shouldOverrideUrlLoading"
                boolean r1 = r1.shouldCallSuper(r2)
                if (r1 == 0) goto L_0x0014
                boolean r7 = super.shouldOverrideUrlLoading(r7, r8)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r7)
            L_0x0014:
                com.unity3d.services.ads.webplayer.WebPlayerView r7 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                boolean r7 = r7.shouldSendEvent(r2)
                if (r7 == 0) goto L_0x0036
                com.unity3d.services.core.webview.WebViewApp r7 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
                com.unity3d.services.core.webview.WebViewEventCategory r1 = com.unity3d.services.core.webview.WebViewEventCategory.WEBPLAYER
                com.unity3d.services.ads.webplayer.WebPlayerEvent r3 = com.unity3d.services.ads.webplayer.WebPlayerEvent.SHOULD_OVERRIDE_URL_LOADING
                r4 = 2
                java.lang.Object[] r4 = new java.lang.Object[r4]
                r5 = 0
                r4[r5] = r8
                com.unity3d.services.ads.webplayer.WebPlayerView r8 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.String r8 = r8.viewId
                r5 = 1
                r4[r5] = r8
                r7.sendEvent(r1, r3, r4)
            L_0x0036:
                com.unity3d.services.ads.webplayer.WebPlayerView r7 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                boolean r7 = r7.hasReturnValue(r2)
                if (r7 == 0) goto L_0x004b
                com.unity3d.services.ads.webplayer.WebPlayerView r7 = com.unity3d.services.ads.webplayer.WebPlayerView.this
                java.lang.Class<java.lang.Boolean> r8 = java.lang.Boolean.class
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                java.lang.Object r7 = r7.getReturnValue(r2, r8, r0)
                r0 = r7
                java.lang.Boolean r0 = (java.lang.Boolean) r0
            L_0x004b:
                boolean r7 = r0.booleanValue()
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.ads.webplayer.WebPlayerView.WebPlayerClient.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
        }
    }
}
