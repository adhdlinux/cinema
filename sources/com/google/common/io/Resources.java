package com.google.common.io;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public final class Resources {

    private static final class UrlByteSource extends ByteSource {

        /* renamed from: a  reason: collision with root package name */
        private final URL f30699a;

        public InputStream c() throws IOException {
            return this.f30699a.openStream();
        }

        public String toString() {
            return "Resources.asByteSource(" + this.f30699a + ")";
        }

        private UrlByteSource(URL url) {
            this.f30699a = (URL) Preconditions.l(url);
        }
    }

    private Resources() {
    }

    public static ByteSource asByteSource(URL url) {
        return new UrlByteSource(url);
    }

    public static CharSource asCharSource(URL url, Charset charset) {
        return asByteSource(url).a(charset);
    }

    public static void copy(URL url, OutputStream outputStream) throws IOException {
        asByteSource(url).b(outputStream);
    }

    public static URL getResource(String str) {
        URL resource = ((ClassLoader) MoreObjects.a(Thread.currentThread().getContextClassLoader(), Resources.class.getClassLoader())).getResource(str);
        Preconditions.h(resource != null, "resource %s not found.", str);
        return resource;
    }

    public static <T> T readLines(URL url, Charset charset, LineProcessor<T> lineProcessor) throws IOException {
        return asCharSource(url, charset).c(lineProcessor);
    }

    public static byte[] toByteArray(URL url) throws IOException {
        return asByteSource(url).d();
    }

    public static String toString(URL url, Charset charset) throws IOException {
        return asCharSource(url, charset).b();
    }

    public static List<String> readLines(URL url, Charset charset) throws IOException {
        return (List) readLines(url, charset, new LineProcessor<List<String>>() {

            /* renamed from: a  reason: collision with root package name */
            final List<String> f30698a = Lists.h();

            public boolean a(String str) {
                this.f30698a.add(str);
                return true;
            }

            /* renamed from: b */
            public List<String> getResult() {
                return this.f30698a;
            }
        });
    }

    public static URL getResource(Class<?> cls, String str) {
        URL resource = cls.getResource(str);
        Preconditions.i(resource != null, "resource %s relative to %s not found.", str, cls.getName());
        return resource;
    }
}
