package com.utils.Getlink.Provider;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.original.Constants;

public final class SmashyWebview$1$1 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SmashyWebview f37443a;

    SmashyWebview$1$1(SmashyWebview smashyWebview) {
        this.f37443a = smashyWebview;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (webView != null) {
            webView.evaluateJavascript(Constants.a(), (ValueCallback) null);
        }
        if (webView != null) {
            webView.evaluateJavascript(this.f37443a.R(), (ValueCallback) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldOverrideUrlLoading(android.webkit.WebView r7, android.webkit.WebResourceRequest r8) {
        /*
            r6 = this;
            r0 = 0
            if (r8 == 0) goto L_0x0008
            android.net.Uri r1 = r8.getUrl()
            goto L_0x0009
        L_0x0008:
            r1 = r0
        L_0x0009:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "shouldOverrideUrlLoading"
            com.original.tase.Logger.b(r2, r1)
            if (r8 == 0) goto L_0x0019
            android.net.Uri r1 = r8.getUrl()
            goto L_0x001a
        L_0x0019:
            r1 = r0
        L_0x001a:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "smashy"
            r3 = 0
            r4 = 2
            boolean r1 = kotlin.text.StringsKt__StringsKt.L(r1, r2, r3, r4, r0)
            r2 = 1
            if (r1 != 0) goto L_0x0054
            if (r8 == 0) goto L_0x0030
            android.net.Uri r1 = r8.getUrl()
            goto L_0x0031
        L_0x0030:
            r1 = r0
        L_0x0031:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r5 = "javascript:"
            boolean r1 = kotlin.text.StringsKt__StringsKt.L(r1, r5, r3, r4, r0)
            if (r1 != 0) goto L_0x0054
            if (r8 == 0) goto L_0x0044
            android.net.Uri r1 = r8.getUrl()
            goto L_0x0045
        L_0x0044:
            r1 = r0
        L_0x0045:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r5 = "Smashy"
            boolean r0 = kotlin.text.StringsKt__StringsKt.L(r1, r5, r3, r4, r0)
            if (r0 == 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r0 = 0
            goto L_0x0055
        L_0x0054:
            r0 = 1
        L_0x0055:
            com.utils.Getlink.Provider.SmashyWebview r1 = r6.f37443a
            java.lang.String r1 = r1.T()
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0063
            r1 = 1
            goto L_0x0064
        L_0x0063:
            r1 = 0
        L_0x0064:
            if (r1 == 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            r3 = r0
        L_0x0068:
            if (r3 == 0) goto L_0x006e
            boolean r2 = super.shouldOverrideUrlLoading(r7, r8)
        L_0x006e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.SmashyWebview$1$1.shouldOverrideUrlLoading(android.webkit.WebView, android.webkit.WebResourceRequest):boolean");
    }
}
