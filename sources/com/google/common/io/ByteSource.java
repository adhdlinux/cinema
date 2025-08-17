package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;

public abstract class ByteSource {

    class AsCharSource extends CharSource {

        /* renamed from: a  reason: collision with root package name */
        final Charset f30678a;

        AsCharSource(Charset charset) {
            this.f30678a = (Charset) Preconditions.l(charset);
        }

        public Reader a() throws IOException {
            return new InputStreamReader(ByteSource.this.c(), this.f30678a);
        }

        public String b() throws IOException {
            return new String(ByteSource.this.d(), this.f30678a);
        }

        public String toString() {
            return ByteSource.this.toString() + ".asCharSource(" + this.f30678a + ")";
        }
    }

    protected ByteSource() {
    }

    public CharSource a(Charset charset) {
        return new AsCharSource(charset);
    }

    public long b(OutputStream outputStream) throws IOException {
        Preconditions.l(outputStream);
        Closer a2 = Closer.a();
        try {
            long b2 = ByteStreams.b((InputStream) a2.f(c()), outputStream);
            a2.close();
            return b2;
        } catch (Throwable th) {
            a2.close();
            throw th;
        }
    }

    public abstract InputStream c() throws IOException;

    public byte[] d() throws IOException {
        byte[] bArr;
        Closer a2 = Closer.a();
        try {
            InputStream inputStream = (InputStream) a2.f(c());
            Optional<Long> e2 = e();
            if (e2.c()) {
                bArr = ByteStreams.e(inputStream, e2.b().longValue());
            } else {
                bArr = ByteStreams.d(inputStream);
            }
            a2.close();
            return bArr;
        } catch (Throwable th) {
            a2.close();
            throw th;
        }
    }

    public Optional<Long> e() {
        return Optional.a();
    }
}
