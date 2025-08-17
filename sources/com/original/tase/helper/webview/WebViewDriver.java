package com.original.tase.helper.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.google.android.gms.common.internal.ImagesContract;
import com.original.tase.helper.AppDispatchers;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

public final class WebViewDriver extends WebView {

    /* renamed from: b  reason: collision with root package name */
    private boolean f34023b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f34024c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f34025d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f34026e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f34027f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f34028g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f34029h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebViewDriver(Context context) {
        super(context);
        Intrinsics.f(context, "context");
    }

    public void destroy() {
        Job unused = BuildersKt__Builders_commonKt.b(AppDispatchers.Main.c(), (CoroutineContext) null, (CoroutineStart) null, new WebViewDriver$destroy$$inlined$launchOnMain$1((Continuation) null, this), 3, (Object) null);
        if (!this.f34023b) {
            WebViewDriverManager.f34039a.c();
        }
    }

    public final CookieManager getCookieManager() {
        return CookieManager.getInstance();
    }

    public final boolean getShouldClearCache() {
        return this.f34024c;
    }

    public final boolean getShouldClearCookies() {
        return this.f34025d;
    }

    public final boolean getShouldClearFormData() {
        return this.f34027f;
    }

    public final boolean getShouldClearHistory() {
        return this.f34026e;
    }

    public final boolean getShouldClearSslPreferences() {
        return this.f34029h;
    }

    public final boolean getShouldClearWebStorage() {
        return this.f34028g;
    }

    public final WebStorage getWebStorage() {
        return WebStorage.getInstance();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void loadUrl(String str, Map<String, String> map) {
        Intrinsics.f(str, ImagesContract.URL);
        Intrinsics.f(map, "headers");
        Job unused = BuildersKt__Builders_commonKt.b(AppDispatchers.Main.c(), (CoroutineContext) null, (CoroutineStart) null, new WebViewDriver$loadUrl$$inlined$launchOnMain$1((Continuation) null, this, str, map), 3, (Object) null);
        if (!this.f34023b) {
            WebViewDriverManager.f34039a.b(this);
        }
    }

    public final void setHeadless(boolean z2) {
        this.f34023b = z2;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void loadUrl(String str) {
        Intrinsics.f(str, ImagesContract.URL);
        Job unused = BuildersKt__Builders_commonKt.b(AppDispatchers.Main.c(), (CoroutineContext) null, (CoroutineStart) null, new WebViewDriver$loadUrl$$inlined$launchOnMain$2((Continuation) null, this, str), 3, (Object) null);
        if (!this.f34023b) {
            WebViewDriverManager.f34039a.b(this);
        }
    }
}
