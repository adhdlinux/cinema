package com.vincentbrison.openlibraries.android.dualcache;

class LoggerHelper {

    /* renamed from: a  reason: collision with root package name */
    private final Logger f37816a;

    LoggerHelper(Logger logger) {
        this.f37816a = logger;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        Logger logger = this.f37816a;
        logger.c("Entry for " + str + " is in RAM.");
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        Logger logger = this.f37816a;
        logger.c("Entry for " + str + " is not in RAM.");
    }

    /* access modifiers changed from: package-private */
    public void c(String str) {
        Logger logger = this.f37816a;
        logger.c("Entry for " + str + " is not on disk.");
    }

    /* access modifiers changed from: package-private */
    public void d(String str) {
        Logger logger = this.f37816a;
        logger.c("Entry for " + str + " is on disk.");
    }
}
