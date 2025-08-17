package com.original.tase.helper.http.cloudflare;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.Request;

@DebugMetadata(c = "com.original.tase.helper.http.cloudflare.CloudflareKiller", f = "CloudflareKiller.kt", l = {168, 176}, m = "bypassCloudflare")
final class CloudflareKiller$bypassCloudflare$1 extends ContinuationImpl {

    /* renamed from: i  reason: collision with root package name */
    Object f33905i;

    /* renamed from: j  reason: collision with root package name */
    Object f33906j;

    /* renamed from: k  reason: collision with root package name */
    /* synthetic */ Object f33907k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ CloudflareKiller f33908l;

    /* renamed from: m  reason: collision with root package name */
    int f33909m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudflareKiller$bypassCloudflare$1(CloudflareKiller cloudflareKiller, Continuation<? super CloudflareKiller$bypassCloudflare$1> continuation) {
        super(continuation);
        this.f33908l = cloudflareKiller;
    }

    public final Object invokeSuspend(Object obj) {
        this.f33907k = obj;
        this.f33909m |= Integer.MIN_VALUE;
        return this.f33908l.g((Request) null, this);
    }
}
