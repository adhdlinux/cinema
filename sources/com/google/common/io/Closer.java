package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Closer implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    private static final Suppressor f30682e;

    /* renamed from: b  reason: collision with root package name */
    final Suppressor f30683b;

    /* renamed from: c  reason: collision with root package name */
    private final Deque<Closeable> f30684c = new ArrayDeque(4);

    /* renamed from: d  reason: collision with root package name */
    private Throwable f30685d;

    static final class LoggingSuppressor implements Suppressor {

        /* renamed from: a  reason: collision with root package name */
        static final LoggingSuppressor f30686a = new LoggingSuppressor();

        LoggingSuppressor() {
        }

        public void a(Closeable closeable, Throwable th, Throwable th2) {
            Logger logger = Closeables.f30681a;
            Level level = Level.WARNING;
            logger.log(level, "Suppressing exception thrown when closing " + closeable, th2);
        }
    }

    static final class SuppressingSuppressor implements Suppressor {

        /* renamed from: a  reason: collision with root package name */
        private final Method f30687a;

        private SuppressingSuppressor(Method method) {
            this.f30687a = method;
        }

        static SuppressingSuppressor b() {
            Class<Throwable> cls = Throwable.class;
            try {
                return new SuppressingSuppressor(cls.getMethod("addSuppressed", new Class[]{cls}));
            } catch (Throwable unused) {
                return null;
            }
        }

        public void a(Closeable closeable, Throwable th, Throwable th2) {
            if (th != th2) {
                try {
                    this.f30687a.invoke(th, new Object[]{th2});
                } catch (Throwable unused) {
                    LoggingSuppressor.f30686a.a(closeable, th, th2);
                }
            }
        }
    }

    interface Suppressor {
        void a(Closeable closeable, Throwable th, Throwable th2);
    }

    static {
        Suppressor b2 = SuppressingSuppressor.b();
        if (b2 == null) {
            b2 = LoggingSuppressor.f30686a;
        }
        f30682e = b2;
    }

    Closer(Suppressor suppressor) {
        this.f30683b = (Suppressor) Preconditions.l(suppressor);
    }

    public static Closer a() {
        return new Closer(f30682e);
    }

    public void close() throws IOException {
        Throwable th = this.f30685d;
        while (!this.f30684c.isEmpty()) {
            Closeable removeFirst = this.f30684c.removeFirst();
            try {
                removeFirst.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    this.f30683b.a(removeFirst, th, th2);
                }
            }
        }
        if (this.f30685d == null && th != null) {
            Throwables.g(th, IOException.class);
            throw new AssertionError(th);
        }
    }

    public <C extends Closeable> C f(C c2) {
        if (c2 != null) {
            this.f30684c.addFirst(c2);
        }
        return c2;
    }

    public RuntimeException i(Throwable th) throws IOException {
        Preconditions.l(th);
        this.f30685d = th;
        Throwables.g(th, IOException.class);
        throw new RuntimeException(th);
    }
}
