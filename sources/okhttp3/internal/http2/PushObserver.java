package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

public interface PushObserver {
    public static final PushObserver CANCEL = new Companion.PushObserverCancel();
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private static final class PushObserverCancel implements PushObserver {
            public boolean onData(int i2, BufferedSource bufferedSource, int i3, boolean z2) throws IOException {
                Intrinsics.f(bufferedSource, "source");
                bufferedSource.skip((long) i3);
                return true;
            }

            public boolean onHeaders(int i2, List<Header> list, boolean z2) {
                Intrinsics.f(list, "responseHeaders");
                return true;
            }

            public boolean onRequest(int i2, List<Header> list) {
                Intrinsics.f(list, "requestHeaders");
                return true;
            }

            public void onReset(int i2, ErrorCode errorCode) {
                Intrinsics.f(errorCode, "errorCode");
            }
        }

        private Companion() {
        }
    }

    boolean onData(int i2, BufferedSource bufferedSource, int i3, boolean z2) throws IOException;

    boolean onHeaders(int i2, List<Header> list, boolean z2);

    boolean onRequest(int i2, List<Header> list);

    void onReset(int i2, ErrorCode errorCode);
}
