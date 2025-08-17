package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

class AppendableWriter extends Writer {

    /* renamed from: b  reason: collision with root package name */
    private final Appendable f30676b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f30677c;

    AppendableWriter(Appendable appendable) {
        this.f30676b = (Appendable) Preconditions.l(appendable);
    }

    private void a() throws IOException {
        if (this.f30677c) {
            throw new IOException("Cannot write to a closed writer.");
        }
    }

    public void close() throws IOException {
        this.f30677c = true;
        Appendable appendable = this.f30676b;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    public void flush() throws IOException {
        a();
        Appendable appendable = this.f30676b;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    public void write(char[] cArr, int i2, int i3) throws IOException {
        a();
        this.f30676b.append(new String(cArr, i2, i3));
    }

    public void write(int i2) throws IOException {
        a();
        this.f30676b.append((char) i2);
    }

    public Writer append(char c2) throws IOException {
        a();
        this.f30676b.append(c2);
        return this;
    }

    public void write(String str) throws IOException {
        Preconditions.l(str);
        a();
        this.f30676b.append(str);
    }

    public Writer append(CharSequence charSequence) throws IOException {
        a();
        this.f30676b.append(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int i2, int i3) throws IOException {
        a();
        this.f30676b.append(charSequence, i2, i3);
        return this;
    }

    public void write(String str, int i2, int i3) throws IOException {
        Preconditions.l(str);
        a();
        this.f30676b.append(str, i2, i3 + i2);
    }
}
