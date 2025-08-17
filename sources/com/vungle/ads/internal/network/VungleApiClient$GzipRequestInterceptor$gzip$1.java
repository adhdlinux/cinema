package com.vungle.ads.internal.network;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

public final class VungleApiClient$GzipRequestInterceptor$gzip$1 extends RequestBody {
    final /* synthetic */ Buffer $output;
    final /* synthetic */ RequestBody $requestBody;

    VungleApiClient$GzipRequestInterceptor$gzip$1(RequestBody requestBody, Buffer buffer) {
        this.$requestBody = requestBody;
        this.$output = buffer;
    }

    public long contentLength() {
        return this.$output.size();
    }

    public MediaType contentType() {
        return this.$requestBody.contentType();
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Intrinsics.f(bufferedSink, "sink");
        bufferedSink.h0(this.$output.u0());
    }
}
