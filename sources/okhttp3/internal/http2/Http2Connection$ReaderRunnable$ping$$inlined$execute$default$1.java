package okhttp3.internal.http2;

import okhttp3.internal.concurrent.Task;

public final class Http2Connection$ReaderRunnable$ping$$inlined$execute$default$1 extends Task {
    final /* synthetic */ int $payload1$inlined;
    final /* synthetic */ int $payload2$inlined;
    final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Http2Connection$ReaderRunnable$ping$$inlined$execute$default$1(String str, boolean z2, Http2Connection http2Connection, int i2, int i3) {
        super(str, z2);
        this.this$0 = http2Connection;
        this.$payload1$inlined = i2;
        this.$payload2$inlined = i3;
    }

    public long runOnce() {
        this.this$0.writePing(true, this.$payload1$inlined, this.$payload2$inlined);
        return -1;
    }
}
