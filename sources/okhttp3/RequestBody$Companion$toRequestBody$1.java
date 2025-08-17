package okhttp3;

import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.ByteString;

public final class RequestBody$Companion$toRequestBody$1 extends RequestBody {
    final /* synthetic */ MediaType $contentType;
    final /* synthetic */ ByteString $this_toRequestBody;

    RequestBody$Companion$toRequestBody$1(MediaType mediaType, ByteString byteString) {
        this.$contentType = mediaType;
        this.$this_toRequestBody = byteString;
    }

    public long contentLength() {
        return (long) this.$this_toRequestBody.size();
    }

    public MediaType contentType() {
        return this.$contentType;
    }

    public void writeTo(BufferedSink bufferedSink) {
        Intrinsics.f(bufferedSink, "sink");
        bufferedSink.h0(this.$this_toRequestBody);
    }
}
