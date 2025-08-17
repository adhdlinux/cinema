package androidx.media3.datasource.cache;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class ReusableBufferedOutputStream extends BufferedOutputStream {

    /* renamed from: b  reason: collision with root package name */
    private boolean f5015b;

    public ReusableBufferedOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void a(OutputStream outputStream) {
        Assertions.h(this.f5015b);
        this.out = outputStream;
        this.count = 0;
        this.f5015b = false;
    }

    public void close() throws IOException {
        this.f5015b = true;
        try {
            flush();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.out.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th != null) {
            Util.i1(th);
        }
    }

    public ReusableBufferedOutputStream(OutputStream outputStream, int i2) {
        super(outputStream, i2);
    }
}
