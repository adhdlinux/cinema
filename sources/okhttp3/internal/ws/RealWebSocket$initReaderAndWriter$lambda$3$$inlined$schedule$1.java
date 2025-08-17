package okhttp3.internal.ws;

import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.concurrent.Task;

public final class RealWebSocket$initReaderAndWriter$lambda$3$$inlined$schedule$1 extends Task {
    final /* synthetic */ long $pingIntervalNanos$inlined;
    final /* synthetic */ RealWebSocket this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealWebSocket$initReaderAndWriter$lambda$3$$inlined$schedule$1(String str, RealWebSocket realWebSocket, long j2) {
        super(str, false, 2, (DefaultConstructorMarker) null);
        this.this$0 = realWebSocket;
        this.$pingIntervalNanos$inlined = j2;
    }

    public long runOnce() {
        this.this$0.writePingFrame$okhttp();
        return this.$pingIntervalNanos$inlined;
    }
}
