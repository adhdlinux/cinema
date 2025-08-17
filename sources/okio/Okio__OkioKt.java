package okio;

import kotlin.jvm.internal.Intrinsics;

final /* synthetic */ class Okio__OkioKt {
    public static final Sink a() {
        return new BlackholeSink();
    }

    public static final BufferedSink b(Sink sink) {
        Intrinsics.f(sink, "<this>");
        return new RealBufferedSink(sink);
    }

    public static final BufferedSource c(Source source) {
        Intrinsics.f(source, "<this>");
        return new RealBufferedSource(source);
    }
}
