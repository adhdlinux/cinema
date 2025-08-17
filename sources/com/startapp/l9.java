package com.startapp;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayInputStream;
import java.util.Locale;

public class l9 extends WebViewClient {
    private static final String LOG_TAG = "l9";
    private static final String MRAID_JS = "mraid.js";
    private static final String MRAID_PREFIX = "mraid://";
    private k9 controller;
    private boolean isMraidInjected = false;

    public l9(k9 k9Var) {
        this.controller = k9Var;
    }

    @TargetApi(11)
    private WebResourceResponse createMraidInjectionResponse() {
        return new WebResourceResponse("text/javascript", "UTF-8", new ByteArrayInputStream(("javascript:" + p9.a()).getBytes()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean invokeMraidMethod(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "close"
            java.lang.String r1 = "resize"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            java.lang.String r1 = "createCalendarEvent"
            java.lang.String r2 = "expand"
            java.lang.String r3 = "open"
            java.lang.String r4 = "playVideo"
            java.lang.String r5 = "storePicture"
            java.lang.String r6 = "useCustomClose"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2, r3, r4, r5, r6}
            java.lang.String r2 = "setOrientationProperties"
            java.lang.String r3 = "setResizeProperties"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}
            r3 = 0
            java.util.Map r8 = com.startapp.q9.a(r8)     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r4 = "command"
            java.lang.Object r4 = r8.get(r4)     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x00b8 }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ Exception -> 0x00b8 }
            boolean r0 = r0.contains(r4)     // Catch:{ Exception -> 0x00b8 }
            java.lang.Class<com.startapp.k9> r5 = com.startapp.k9.class
            r6 = 1
            if (r0 == 0) goto L_0x0049
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x00b8 }
            java.lang.reflect.Method r8 = r5.getDeclaredMethod(r4, r8)     // Catch:{ Exception -> 0x00b8 }
            com.startapp.k9 r0 = r7.controller     // Catch:{ Exception -> 0x00b8 }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x00b8 }
            r8.invoke(r0, r1)     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00b7
        L_0x0049:
            java.util.List r0 = java.util.Arrays.asList(r1)     // Catch:{ Exception -> 0x00b8 }
            boolean r0 = r0.contains(r4)     // Catch:{ Exception -> 0x00b8 }
            if (r0 == 0) goto L_0x009a
            java.lang.Class[] r0 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x00b8 }
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            r0[r3] = r1     // Catch:{ Exception -> 0x00b8 }
            java.lang.reflect.Method r0 = r5.getDeclaredMethod(r4, r0)     // Catch:{ Exception -> 0x00b8 }
            int r1 = r4.hashCode()     // Catch:{ Exception -> 0x00b8 }
            r2 = -733616544(0xffffffffd445e660, float:-3.39989443E12)
            java.lang.String r5 = "useCustomClose"
            if (r1 == r2) goto L_0x0076
            r2 = 1614272768(0x6037d900, float:5.299048E19)
            if (r1 == r2) goto L_0x006e
            goto L_0x0080
        L_0x006e:
            boolean r1 = r4.equals(r5)     // Catch:{ Exception -> 0x00b8 }
            if (r1 == 0) goto L_0x0080
            r1 = 1
            goto L_0x0081
        L_0x0076:
            java.lang.String r1 = "createCalendarEvent"
            boolean r1 = r4.equals(r1)     // Catch:{ Exception -> 0x00b8 }
            if (r1 == 0) goto L_0x0080
            r1 = 0
            goto L_0x0081
        L_0x0080:
            r1 = -1
        L_0x0081:
            if (r1 == 0) goto L_0x0088
            if (r1 == r6) goto L_0x008a
            java.lang.String r5 = "url"
            goto L_0x008a
        L_0x0088:
            java.lang.String r5 = "eventJSON"
        L_0x008a:
            java.lang.Object r8 = r8.get(r5)     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x00b8 }
            com.startapp.k9 r1 = r7.controller     // Catch:{ Exception -> 0x00b8 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x00b8 }
            r2[r3] = r8     // Catch:{ Exception -> 0x00b8 }
            r0.invoke(r1, r2)     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00b7
        L_0x009a:
            java.util.List r0 = java.util.Arrays.asList(r2)     // Catch:{ Exception -> 0x00b8 }
            boolean r0 = r0.contains(r4)     // Catch:{ Exception -> 0x00b8 }
            if (r0 == 0) goto L_0x00b7
            java.lang.Class[] r0 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x00b8 }
            java.lang.Class<java.util.Map> r1 = java.util.Map.class
            r0[r3] = r1     // Catch:{ Exception -> 0x00b8 }
            java.lang.reflect.Method r0 = r5.getDeclaredMethod(r4, r0)     // Catch:{ Exception -> 0x00b8 }
            com.startapp.k9 r1 = r7.controller     // Catch:{ Exception -> 0x00b8 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x00b8 }
            r2[r3] = r8     // Catch:{ Exception -> 0x00b8 }
            r0.invoke(r1, r2)     // Catch:{ Exception -> 0x00b8 }
        L_0x00b7:
            return r6
        L_0x00b8:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.l9.invokeMraidMethod(java.lang.String):boolean");
    }

    public boolean isMraidUrl(String str) {
        if (str == null || !str.startsWith(MRAID_PREFIX)) {
            return false;
        }
        return true;
    }

    public boolean matchesInjectionUrl(String str) {
        try {
            return "mraid.js".equals(Uri.parse(str.toLowerCase(Locale.US)).getLastPathSegment());
        } catch (Exception unused) {
            return false;
        }
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        super.onReceivedError(webView, i2, str, str2);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.isMraidInjected || !matchesInjectionUrl(str)) {
            return super.shouldInterceptRequest(webView, str);
        }
        this.isMraidInjected = true;
        return createMraidInjectionResponse();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (webView == null || str == null || lb.b(webView.getContext(), str)) {
            return true;
        }
        if (isMraidUrl(str)) {
            return invokeMraidMethod(str);
        }
        return this.controller.open(str);
    }
}
