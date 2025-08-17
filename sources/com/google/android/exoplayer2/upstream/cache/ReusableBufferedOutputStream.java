package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class ReusableBufferedOutputStream extends BufferedOutputStream {

    /* renamed from: b  reason: collision with root package name */
    private boolean f28627b;

    public ReusableBufferedOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void a(OutputStream outputStream) {
        Assertions.g(this.f28627b);
        this.out = outputStream;
        this.count = 0;
        this.f28627b = false;
    }

    public void close() throws IOException {
        this.f28627b = true;
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
            Util.U0(th);
        }
    }

    public ReusableBufferedOutputStream(OutputStream outputStream, int i2) {
        super(outputStream, i2);
    }
}
