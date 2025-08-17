package com.original.tase.helper.http.cloudflare;

import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class CloudflareKiller$cleancookie$1 extends Lambda implements Function0<Unit> {

    /* renamed from: f  reason: collision with root package name */
    public static final CloudflareKiller$cleancookie$1 f33912f = new CloudflareKiller$cleancookie$1();

    CloudflareKiller$cleancookie$1() {
        super(0);
    }

    public final void invoke() {
        CookieManager.getInstance().removeAllCookies((ValueCallback) null);
    }
}
