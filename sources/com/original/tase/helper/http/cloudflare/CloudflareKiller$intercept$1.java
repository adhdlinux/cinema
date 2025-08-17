package com.original.tase.helper.http.cloudflare;

import android.util.Log;
import com.original.tase.Logger;
import com.utils.Utils;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@DebugMetadata(c = "com.original.tase.helper.http.cloudflare.CloudflareKiller$intercept$1", f = "CloudflareKiller.kt", l = {88, 92, 101}, m = "invokeSuspend")
final class CloudflareKiller$intercept$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response>, Object> {

    /* renamed from: i  reason: collision with root package name */
    Object f33914i;

    /* renamed from: j  reason: collision with root package name */
    int f33915j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ Interceptor.Chain f33916k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ CloudflareKiller f33917l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudflareKiller$intercept$1(Interceptor.Chain chain, CloudflareKiller cloudflareKiller, Continuation<? super CloudflareKiller$intercept$1> continuation) {
        super(2, continuation);
        this.f33916k = chain;
        this.f33917l = cloudflareKiller;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CloudflareKiller$intercept$1(this.f33916k, this.f33917l, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Response> continuation) {
        return ((CloudflareKiller$intercept$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Interceptor.Chain chain;
        Interceptor.Chain chain2;
        Request request;
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.f33915j;
        if (i2 == 0) {
            ResultKt.b(obj);
            request = this.f33916k.request();
            if (!Utils.f37612e) {
                return this.f33916k.proceed(request);
            }
            Map map = CloudflareKiller.f33901a.a().get(request.url().host());
            if (map == null) {
                Response proceed = this.f33916k.proceed(request);
                if (!CollectionsKt___CollectionsKt.z(CloudflareKiller.f33903c, Response.header$default(proceed, "Server", (String) null, 2, (Object) null)) || !CloudflareKiller.f33902b.contains(Boxing.b(proceed.code()))) {
                    return proceed;
                }
                proceed.close();
                this.f33917l.h();
                CloudflareKiller cloudflareKiller = this.f33917l;
                this.f33914i = request;
                this.f33915j = 1;
                obj = cloudflareKiller.g(request, this);
                if (obj == e2) {
                    return e2;
                }
            } else {
                Interceptor.Chain chain3 = this.f33916k;
                CloudflareKiller cloudflareKiller2 = this.f33917l;
                this.f33914i = chain3;
                this.f33915j = 3;
                obj = cloudflareKiller2.j(request, map, this);
                if (obj == e2) {
                    return e2;
                }
                chain = chain3;
                return chain.proceed((Request) obj);
            }
        } else if (i2 == 1) {
            request = (Request) this.f33914i;
            ResultKt.b(obj);
        } else if (i2 == 2) {
            chain2 = (Interceptor.Chain) this.f33914i;
            ResultKt.b(obj);
            return chain2.proceed((Request) obj);
        } else if (i2 == 3) {
            chain = (Interceptor.Chain) this.f33914i;
            ResultKt.b(obj);
            return chain.proceed((Request) obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Request request2 = (Request) obj;
        if (request2 != null) {
            Interceptor.Chain chain4 = this.f33916k;
            CloudflareKiller cloudflareKiller3 = this.f33917l;
            Log.d("CloudflareKiller", "Succeeded bypassing cloudflare: " + request.url());
            Map map2 = CloudflareKiller.f33901a.a().get(request.url().host());
            if (map2 == null) {
                return chain4.proceed(request2);
            }
            this.f33914i = chain4;
            this.f33915j = 2;
            obj = cloudflareKiller3.j(request2, map2, this);
            if (obj == e2) {
                return e2;
            }
            chain2 = chain4;
            return chain2.proceed((Request) obj);
        }
        Logger.a("Failed cloudflare at: " + request.url());
        return this.f33916k.proceed(request);
    }
}
