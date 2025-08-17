package com.google.common.util.concurrent;

import java.util.logging.Logger;

final class LazyLogger {

    /* renamed from: a  reason: collision with root package name */
    private final String f30771a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Logger f30772b;

    LazyLogger(Class<?> cls) {
        this.f30771a = cls.getName();
    }

    /* access modifiers changed from: package-private */
    public Logger a() {
        Logger logger = this.f30772b;
        if (logger != null) {
            return logger;
        }
        synchronized (this) {
            Logger logger2 = this.f30772b;
            if (logger2 != null) {
                return logger2;
            }
            Logger logger3 = Logger.getLogger(this.f30771a);
            this.f30772b = logger3;
            return logger3;
        }
    }
}
