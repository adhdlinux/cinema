package com.original.tase.helper.http.cloudflare;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class CloudflareKillerKt$getHeaders$cookieMap$1 extends Lambda implements Function1<Map.Entry<? extends String, ? extends String>, CharSequence> {

    /* renamed from: f  reason: collision with root package name */
    public static final CloudflareKillerKt$getHeaders$cookieMap$1 f33919f = new CloudflareKillerKt$getHeaders$cookieMap$1();

    CloudflareKillerKt$getHeaders$cookieMap$1() {
        super(1);
    }

    /* renamed from: a */
    public final CharSequence invoke(Map.Entry<String, String> entry) {
        Intrinsics.f(entry, "it");
        return entry.getKey() + '=' + entry.getValue() + ';';
    }
}
