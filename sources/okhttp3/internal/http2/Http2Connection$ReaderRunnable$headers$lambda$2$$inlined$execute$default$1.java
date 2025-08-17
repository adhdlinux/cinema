package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.platform.Platform;

public final class Http2Connection$ReaderRunnable$headers$lambda$2$$inlined$execute$default$1 extends Task {
    final /* synthetic */ Http2Stream $newStream$inlined;
    final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Http2Connection$ReaderRunnable$headers$lambda$2$$inlined$execute$default$1(String str, boolean z2, Http2Connection http2Connection, Http2Stream http2Stream) {
        super(str, z2);
        this.this$0 = http2Connection;
        this.$newStream$inlined = http2Stream;
    }

    public long runOnce() {
        try {
            this.this$0.getListener$okhttp().onStream(this.$newStream$inlined);
            return -1;
        } catch (IOException e2) {
            Platform platform = Platform.Companion.get();
            platform.log("Http2Connection.Listener failure for " + this.this$0.getConnectionName$okhttp(), 4, e2);
            try {
                this.$newStream$inlined.close(ErrorCode.PROTOCOL_ERROR, e2);
                return -1;
            } catch (IOException unused) {
                return -1;
            }
        }
    }
}
