package com.original.tase.helper.http.cloudflare;

import android.webkit.CookieManager;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class CloudflareKiller$getWebViewCookie$1 extends Lambda implements Function0<String> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f33913f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudflareKiller$getWebViewCookie$1(String str) {
        super(0);
        this.f33913f = str;
    }

    /* renamed from: b */
    public final String invoke() {
        CookieManager instance = CookieManager.getInstance();
        if (instance != null) {
            return instance.getCookie(this.f33913f);
        }
        return null;
    }
}
