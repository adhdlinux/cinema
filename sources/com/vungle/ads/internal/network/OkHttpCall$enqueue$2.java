package com.vungle.ads.internal.network;

import com.vungle.ads.internal.util.Logger;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public final class OkHttpCall$enqueue$2 implements Callback {
    final /* synthetic */ Callback<T> $callback;
    final /* synthetic */ OkHttpCall<T> this$0;

    OkHttpCall$enqueue$2(OkHttpCall<T> okHttpCall, Callback<T> callback) {
        this.this$0 = okHttpCall;
        this.$callback = callback;
    }

    private final void callFailure(Throwable th) {
        try {
            this.$callback.onFailure(this.this$0, th);
        } catch (Throwable th2) {
            OkHttpCall.Companion.throwIfFatal(th2);
            Logger.Companion.e("OkHttpCall", "Cannot pass failure to callback", th2);
        }
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.f(call, "call");
        Intrinsics.f(iOException, "e");
        callFailure(iOException);
    }

    public void onResponse(Call call, Response response) {
        Intrinsics.f(call, "call");
        Intrinsics.f(response, "response");
        try {
            try {
                this.$callback.onResponse(this.this$0, this.this$0.parseResponse(response));
            } catch (Throwable th) {
                OkHttpCall.Companion.throwIfFatal(th);
                Logger.Companion.e("OkHttpCall", "Cannot pass response to callback", th);
            }
        } catch (Throwable th2) {
            OkHttpCall.Companion.throwIfFatal(th2);
            callFailure(th2);
        }
    }
}
