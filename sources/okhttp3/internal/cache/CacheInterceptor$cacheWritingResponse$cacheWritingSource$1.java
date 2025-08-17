package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

public final class CacheInterceptor$cacheWritingResponse$cacheWritingSource$1 implements Source {
    final /* synthetic */ BufferedSink $cacheBody;
    final /* synthetic */ CacheRequest $cacheRequest;
    final /* synthetic */ BufferedSource $source;
    private boolean cacheRequestClosed;

    CacheInterceptor$cacheWritingResponse$cacheWritingSource$1(BufferedSource bufferedSource, CacheRequest cacheRequest, BufferedSink bufferedSink) {
        this.$source = bufferedSource;
        this.$cacheRequest = cacheRequest;
        this.$cacheBody = bufferedSink;
    }

    public void close() throws IOException {
        if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
            this.cacheRequestClosed = true;
            this.$cacheRequest.abort();
        }
        this.$source.close();
    }

    public long read(Buffer buffer, long j2) throws IOException {
        Intrinsics.f(buffer, "sink");
        try {
            long read = this.$source.read(buffer, j2);
            if (read == -1) {
                if (!this.cacheRequestClosed) {
                    this.cacheRequestClosed = true;
                    this.$cacheBody.close();
                }
                return -1;
            }
            buffer.q(this.$cacheBody.c(), buffer.size() - read, read);
            this.$cacheBody.r();
            return read;
        } catch (IOException e2) {
            if (!this.cacheRequestClosed) {
                this.cacheRequestClosed = true;
                this.$cacheRequest.abort();
            }
            throw e2;
        }
    }

    public Timeout timeout() {
        return this.$source.timeout();
    }
}
