package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;

public abstract class CharSource {
    protected CharSource() {
    }

    public abstract Reader a() throws IOException;

    public String b() throws IOException {
        Closer a2 = Closer.a();
        try {
            String g2 = CharStreams.g((Reader) a2.f(a()));
            a2.close();
            return g2;
        } catch (Throwable th) {
            a2.close();
            throw th;
        }
    }

    public <T> T c(LineProcessor<T> lineProcessor) throws IOException {
        Preconditions.l(lineProcessor);
        Closer a2 = Closer.a();
        try {
            T f2 = CharStreams.f((Reader) a2.f(a()), lineProcessor);
            a2.close();
            return f2;
        } catch (Throwable th) {
            a2.close();
            throw th;
        }
    }
}
