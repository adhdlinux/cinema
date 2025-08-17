package okhttp3.internal.http1;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okio.BufferedSource;

public final class HeadersReader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int HEADER_LIMIT = 262144;
    private long headerLimit = 262144;
    private final BufferedSource source;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HeadersReader(BufferedSource bufferedSource) {
        Intrinsics.f(bufferedSource, "source");
        this.source = bufferedSource;
    }

    public final BufferedSource getSource() {
        return this.source;
    }

    public final Headers readHeaders() {
        boolean z2;
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readLine = readLine();
            if (readLine.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return builder.build();
            }
            builder.addLenient$okhttp(readLine);
        }
    }

    public final String readLine() {
        String t2 = this.source.t(this.headerLimit);
        this.headerLimit -= (long) t2.length();
        return t2;
    }
}
