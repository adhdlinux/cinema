package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.concurrent.Task;

public final class Http2Connection$writeWindowUpdateLater$$inlined$execute$default$1 extends Task {
    final /* synthetic */ int $streamId$inlined;
    final /* synthetic */ long $unacknowledgedBytesRead$inlined;
    final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Http2Connection$writeWindowUpdateLater$$inlined$execute$default$1(String str, boolean z2, Http2Connection http2Connection, int i2, long j2) {
        super(str, z2);
        this.this$0 = http2Connection;
        this.$streamId$inlined = i2;
        this.$unacknowledgedBytesRead$inlined = j2;
    }

    public long runOnce() {
        try {
            this.this$0.getWriter().windowUpdate(this.$streamId$inlined, this.$unacknowledgedBytesRead$inlined);
            return -1;
        } catch (IOException e2) {
            this.this$0.failConnection(e2);
            return -1;
        }
    }
}
