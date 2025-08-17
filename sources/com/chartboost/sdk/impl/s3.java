package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public abstract class s3 extends kd {

    public static final class a extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f18545b = new a();

        public a() {
            super(1);
        }

        /* renamed from: a */
        public final z2 invoke(Context context) {
            Intrinsics.f(context, "it");
            return new z2(context);
        }
    }

    public static final class b extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final b f18546b = new b();

        public b() {
            super(1);
        }

        /* renamed from: a */
        public final WebChromeClient invoke(View view) {
            Intrinsics.f(view, "it");
            return new WebChromeClient();
        }
    }

    public static final class c extends Lambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public static final c f18547b = new c();

        public c() {
            super(2);
        }

        /* renamed from: a */
        public final e4 invoke(f4 f4Var, z4 z4Var) {
            Intrinsics.f(f4Var, "cb");
            Intrinsics.f(z4Var, "et");
            return new e4(f4Var, z4Var);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ s3(android.content.Context r12, java.lang.String r13, com.chartboost.sdk.impl.f4 r14, java.lang.String r15, com.chartboost.sdk.impl.z4 r16, kotlin.jvm.functions.Function1 r17, kotlin.jvm.functions.Function1 r18, kotlin.jvm.functions.Function2 r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r11 = this;
            r0 = r20
            r1 = r0 & 32
            if (r1 == 0) goto L_0x000a
            com.chartboost.sdk.impl.s3$a r1 = com.chartboost.sdk.impl.s3.a.f18545b
            r8 = r1
            goto L_0x000c
        L_0x000a:
            r8 = r17
        L_0x000c:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0014
            com.chartboost.sdk.impl.s3$b r1 = com.chartboost.sdk.impl.s3.b.f18546b
            r9 = r1
            goto L_0x0016
        L_0x0014:
            r9 = r18
        L_0x0016:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x001e
            com.chartboost.sdk.impl.s3$c r0 = com.chartboost.sdk.impl.s3.c.f18547b
            r10 = r0
            goto L_0x0020
        L_0x001e:
            r10 = r19
        L_0x0020:
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.s3.<init>(android.content.Context, java.lang.String, com.chartboost.sdk.impl.f4, java.lang.String, com.chartboost.sdk.impl.z4, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s3(Context context, String str, f4 f4Var, String str2, z4 z4Var, Function1 function1, Function1 function12, Function2 function2) {
        super(context);
        Context context2 = context;
        f4 f4Var2 = f4Var;
        z4 z4Var2 = z4Var;
        Function1 function13 = function1;
        Function1 function14 = function12;
        Function2 function22 = function2;
        Intrinsics.f(context, "context");
        Intrinsics.f(str, "html");
        Intrinsics.f(f4Var2, "callback");
        Intrinsics.f(z4Var2, "eventTracker");
        Intrinsics.f(function13, "cbWebViewFactory");
        Intrinsics.f(function14, "cbWebChromeClientFactory");
        Intrinsics.f(function22, "cbWebViewClientFactory");
        setFocusable(false);
        t5 a2 = t5.a();
        setWebViewContainer((RelativeLayout) a2.a(new RelativeLayout(context)));
        setWebView((z2) function13.invoke(context));
        lc.f18142b.a(context);
        try {
            WebView.setWebContentsDebuggingEnabled(false);
        } catch (RuntimeException e2) {
            RuntimeException runtimeException = e2;
            w7.e("RichWebViewBase", "Exception while enabling webview debugging " + runtimeException);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        z2 webView = getWebView();
        if (webView != null) {
            webView.getSettings().setSupportZoom(false);
            webView.setLayoutParams(layoutParams);
            webView.setBackgroundColor(0);
            webView.setWebViewClient((WebViewClient) a2.a(function22.invoke(f4Var2, z4Var2)));
            RelativeLayout webViewContainer = getWebViewContainer();
            if (webViewContainer != null) {
                webViewContainer.setLayoutParams(layoutParams);
                webView.setWebChromeClient((WebChromeClient) function14.invoke(webViewContainer));
                webViewContainer.addView(webView);
            }
            webView.loadDataWithBaseURL(str2, str, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, AudienceNetworkActivity.WEBVIEW_ENCODING, (String) null);
        }
    }
}
