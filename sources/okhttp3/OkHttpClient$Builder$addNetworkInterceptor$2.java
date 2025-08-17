package okhttp3;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;

public final class OkHttpClient$Builder$addNetworkInterceptor$2 implements Interceptor {
    final /* synthetic */ Function1<Interceptor.Chain, Response> $block;

    public OkHttpClient$Builder$addNetworkInterceptor$2(Function1<? super Interceptor.Chain, Response> function1) {
        this.$block = function1;
    }

    public final Response intercept(Interceptor.Chain chain) {
        Intrinsics.f(chain, "chain");
        return this.$block.invoke(chain);
    }
}
