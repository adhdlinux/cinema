package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

public class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;
    private final Function1<IOException, Unit> onException;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FaultHidingSink(Sink sink, Function1<? super IOException, Unit> function1) {
        super(sink);
        Intrinsics.f(sink, "delegate");
        Intrinsics.f(function1, "onException");
        this.onException = function1;
    }

    public void close() {
        if (!this.hasErrors) {
            try {
                super.close();
            } catch (IOException e2) {
                this.hasErrors = true;
                this.onException.invoke(e2);
            }
        }
    }

    public void flush() {
        if (!this.hasErrors) {
            try {
                super.flush();
            } catch (IOException e2) {
                this.hasErrors = true;
                this.onException.invoke(e2);
            }
        }
    }

    public final Function1<IOException, Unit> getOnException() {
        return this.onException;
    }

    public void write(Buffer buffer, long j2) {
        Intrinsics.f(buffer, "source");
        if (this.hasErrors) {
            buffer.skip(j2);
            return;
        }
        try {
            super.write(buffer, j2);
        } catch (IOException e2) {
            this.hasErrors = true;
            this.onException.invoke(e2);
        }
    }
}
