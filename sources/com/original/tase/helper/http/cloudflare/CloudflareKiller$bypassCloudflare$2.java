package com.original.tase.helper.http.cloudflare;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Request;

final class CloudflareKiller$bypassCloudflare$2 extends Lambda implements Function1<Request, Boolean> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ CloudflareKiller f33910f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Request f33911g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudflareKiller$bypassCloudflare$2(CloudflareKiller cloudflareKiller, Request request) {
        super(1);
        this.f33910f = cloudflareKiller;
        this.f33911g = request;
    }

    /* renamed from: a */
    public final Boolean invoke(Request request) {
        Intrinsics.f(request, "it");
        return Boolean.valueOf(this.f33910f.k(this.f33911g));
    }
}
