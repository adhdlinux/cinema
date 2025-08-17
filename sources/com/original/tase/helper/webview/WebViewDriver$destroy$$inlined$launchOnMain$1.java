package com.original.tase.helper.webview;

import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebStorage;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.original.tase.helper.webview.WebViewDriver$destroy$$inlined$launchOnMain$1", f = "WebViewDriver.kt", l = {}, m = "invokeSuspend")
public final class WebViewDriver$destroy$$inlined$launchOnMain$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: i  reason: collision with root package name */
    int f34030i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ WebViewDriver f34031j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebViewDriver$destroy$$inlined$launchOnMain$1(Continuation continuation, WebViewDriver webViewDriver) {
        super(2, continuation);
        this.f34031j = webViewDriver;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewDriver$destroy$$inlined$launchOnMain$1(continuation, this.f34031j);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewDriver$destroy$$inlined$launchOnMain$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        WebStorage webStorage;
        Object unused = IntrinsicsKt__IntrinsicsKt.e();
        if (this.f34030i == 0) {
            ResultKt.b(obj);
            if (this.f34031j.getShouldClearCache()) {
                this.f34031j.clearCache(true);
            }
            if (this.f34031j.getShouldClearCookies()) {
                CookieManager cookieManager = this.f34031j.getCookieManager();
                if (cookieManager != null) {
                    cookieManager.removeAllCookies((ValueCallback) null);
                }
                CookieManager cookieManager2 = this.f34031j.getCookieManager();
                if (cookieManager2 != null) {
                    cookieManager2.flush();
                }
            }
            if (this.f34031j.getShouldClearHistory()) {
                this.f34031j.clearHistory();
            }
            if (this.f34031j.getShouldClearFormData()) {
                this.f34031j.clearFormData();
            }
            if (this.f34031j.getShouldClearWebStorage() && (webStorage = this.f34031j.getWebStorage()) != null) {
                webStorage.deleteAllData();
            }
            if (this.f34031j.getShouldClearSslPreferences()) {
                this.f34031j.clearSslPreferences();
            }
            this.f34031j.stopLoading();
            this.f34031j.onPause();
            WebViewDriver$destroy$$inlined$launchOnMain$1.super.destroy();
            return Unit.f40298a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
