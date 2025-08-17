package okhttp3;

import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;

public final class RequestBody$Companion$toRequestBody$2 extends RequestBody {
    final /* synthetic */ int $byteCount;
    final /* synthetic */ MediaType $contentType;
    final /* synthetic */ int $offset;
    final /* synthetic */ byte[] $this_toRequestBody;

    RequestBody$Companion$toRequestBody$2(MediaType mediaType, int i2, byte[] bArr, int i3) {
        this.$contentType = mediaType;
        this.$byteCount = i2;
        this.$this_toRequestBody = bArr;
        this.$offset = i3;
    }

    public long contentLength() {
        return (long) this.$byteCount;
    }

    public MediaType contentType() {
        return this.$contentType;
    }

    public void writeTo(BufferedSink bufferedSink) {
        Intrinsics.f(bufferedSink, "sink");
        bufferedSink.write(this.$this_toRequestBody, this.$offset, this.$byteCount);
    }
}
